package Ocean.Creature;
import java.util.Hashtable;
import java.util.Iterator;
import Ocean.Location;
import Ocean.ModelConstants;
import Ocean.RandomGenerator;
import Ocean.Simulator;
/**
 * The Fish Class contains fields and methods that are common to both sardines and sharks but not plankton
 * @author Ian McNeilly
 *
 */
public abstract class Fish extends Creature{
	
	protected int foodLevel;	//The level of food that a creature currently has
	
	/**
	 * By pairing specific creature classes with an integer, we can specify independant
	 * nutritional values other creatures provide this creature.
	 * So instead of having a static nutritional value for each creature. This is extensible
	 * eg: plankton might be worth 10 to sardine but could simultaneously be worth 5 to a whale.
	 */
	protected Hashtable<Class,Integer> diet; 
	
	public Fish(Simulator simulator, boolean randomAge, Location location) {
		super(simulator, randomAge, location);
		diet = new Hashtable<Class,Integer>();
		
		//random food level, can lead to free energy, see report
		this.foodLevel = RandomGenerator.getRandom().nextInt(ModelConstants.getConstants().maxFood);
		
		//compile a list of actions for all fish to perform
		actions.add(new CreatureAction(){public void perform(){move();}});
		actions.add(new CreatureAction(){public void perform(){findFood();;}});
		actions.add(new CreatureAction(){public void perform(){getHungrier();;}});
		actions.add(new CreatureAction(){public void perform(){
			if(age >= getReporductionAge()&& foodLevel >= getReproductionFoodLevel())reproduce();
		}});
		actions.add(new CreatureAction(){public void perform(){incrementAge();}});
	}
	
	// find a free location and move to it, if possible
	public void move(){
		Location freeAdjacentLocation = simulator.field.freeAdjacentLocation(location);
		if(freeAdjacentLocation !=null){
			this.setLocation(freeAdjacentLocation);
		}
	}
	
	//decrease the foodLevel and kill the creature if it reaches 0
	private void getHungrier(){
		this.foodLevel--;
		if(this.foodLevel <=0){
			this.die();
		}
	}
	
	//defer specification of constant to concrete class
	public abstract int getReproductionFoodLevel();

	//using the hashtable to find if the creature to be devoured on the list
	protected boolean isEdible(Creature c){
		if(diet.containsKey(c.getClass())){
			return true;
		}
		else{
			return false;
		}
	}
	
	//determine if target creature is edible, kill it and add the nutritional value to foodLevel
	protected boolean eat(Creature c){
		if(isEdible(c)){
			c.die();
			foodLevel += diet.get(c.getClass());
			return true;
		}
		else return false;
	}

	/*
	 * find nearby locations using the method from the Field Class
	 * search for a Creature, and if found attempt to eat it.
	 * If the attempt is successful the method terminates 
	 */
	protected void findFood(){
		Iterator adjacent = simulator.field.adjacentLocations(location);
		while(adjacent.hasNext()) {
			Location next = (Location) adjacent.next();
			Creature c = simulator.field.field[next.getRow()][next.getCol()];
			if(c != null) {
				if(eat(c)){
					this.setLocation(next);
					return;
				}
			}
		}
	}
}
