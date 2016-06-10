package Ocean.Creature;

import Ocean.Location;
import Ocean.ModelConstants;
import Ocean.Simulator;
/**
 * The Plankton class is a concrete class containing the methods specific to plankton
 * @author Ian McNeilly
 *
 */
public class Plankton extends Creature {

	public Plankton(Simulator simulator, boolean randomAge,Location location) {
		super(simulator, randomAge, location);
		
		//construct a list of actions for the plankton to perform
		actions.add(new CreatureAction(){public void perform(){incrementAge();}});
		actions.add(new CreatureAction(){public void perform(){
			if(age >= getReporductionAge()){
				reproduce();
			}
		}});
	}
	
	//Fetch the model constants from the model constants class
	@Override
	public int getMaxAge() {
		return ModelConstants.getConstants().planktonMaxAge;
	}
	@Override
	public double getReporductionChance() {
		return ModelConstants.getConstants().planktonReproductionChance;
	}
	@Override
	public int getReporductionAge() {
		return ModelConstants.getConstants().planktonReproductionAge;
	}
	
	//used by the reproduce methods
	@Override
	public void placeChild(Location babyPos) {
		new Plankton(simulator,false,babyPos);
		
	}
	
	


	


}
