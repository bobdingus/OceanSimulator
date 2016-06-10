package Ocean.Creature;
import java.util.ArrayList;
import Ocean.Location;
import Ocean.RandomGenerator;
import Ocean.Simulator;
/**
 * The creature class is at the top of the inheritance heirarchy for our implementaion
 * It contains fields and methods which are common for all types of creatures as well
 * as abstract methods to enforce their concrete implementation within subclasses.
 * @author Ian McNeilly
 *
 */
public abstract class Creature {
	
	//location on the grid that the creature is currently residing
	protected Location location; 
	
	//stores the number of steps the creature has been alive for
	protected int age;			
	
	//Injected dependancy, allows creature to act on simulator
	public Simulator simulator; 
	
	//if this is false it will prevent the creature from carrying out further action
	public boolean isAlive;		
	
	/*
	 * This list will contain an ordered sequence of all actions a specific creature
	 * will perform.
	 */
	public ArrayList<CreatureAction>actions; 
											
	/**
	 * 
	 * @param simulator 	Simulator to interact with
	 * @param randomAge		If true, the new creatures age will be random otherwise 0
	 * @param location		The location in the field to place the creature
	 */
	public Creature(Simulator simulator,boolean randomAge,Location location){
		actions = new ArrayList<CreatureAction>();
		this.isAlive = true;
		this.simulator = simulator;	
		this.setLocation(location);		

		if(randomAge){
			age = RandomGenerator.getRandom().nextInt(getMaxAge());
		}
		else{
			age = 0;
		}
	}
	
	/**
	 * removes the creature form the field and marks it as dead
	 */
	public void die(){
		if(simulator.field.getObjectAt(this.location) == this){
			this.isAlive = false;
			simulator.field.place(null, this.location);	
		}
	}
	
	/**
	 * Used by all creatures to carry out sequences of actions.
	 * Any action that causes the creature to die will stop further actions from taking place
	 */
	public void act() {
		for(CreatureAction a: actions){
			if(isAlive){
				a.perform();
			}
			else{
				return;
			}
		}
	}
	
	//defer responsibility of lookup for specific model constants to concrete subclasses
	public abstract int getMaxAge();
	public abstract double getReporductionChance();
	public abstract int getReporductionAge();
	
	
	//kills creature if it has reached its age limit
	public void incrementAge(){
		age++;
		if(age >= getMaxAge()){
			this.die();
		}
	}
	
	public void setLocation(Location location) {
		/**
		 * Ensure the location passed is empty within the field
		 */
		if(simulator.field.getObjectAt(location)!= null){
			try {
				throw new IllegalArgumentException("The location specified is occupied by another creature");
			} catch (IllegalArgumentException e) {
				System.out.println(simulator.field.getObjectAt(this.location)+ " " + this);
				e.printStackTrace();
				System.exit(12);
			}
		}
		/*
		 * During initialisation, the current location doesn't have to be cleared and infact doing 
		 * so would throw a null pointer exception in the field.place() method
		 */
		if(this.location !=null){
			simulator.field.place(null, this.location);
		}
		this.location = location;
		simulator.field.place(this,this.location);
	}
	
	/**
	 * Decide weather to reproduce based on chance constant for that species
	 * Find a location and place a child in it/
	 */
	public void reproduce() {
		if(RandomGenerator.getRandom().nextDouble()< getReporductionChance()){
			Location babyPos = simulator.field.freeAdjacentLocation(this.location);
			if(babyPos !=null){
				placeChild(babyPos);
			}
		}
	}
	
	//defer responsibility for specifying place child to concrete subclasses
	public abstract void placeChild(Location babyPos);

}
