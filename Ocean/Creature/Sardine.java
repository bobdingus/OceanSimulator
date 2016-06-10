package Ocean.Creature;

import Ocean.Location;
import Ocean.ModelConstants;
import Ocean.Simulator;

public class Sardine extends Fish {

	public Sardine(Simulator simulator, boolean randomAge,Location location) {
		super(simulator, randomAge, location);
		//specify sardine specific diet by adding the class and value to the diet hashmap
		diet.put(Plankton.class, ModelConstants.getConstants().planktonNutritionalValueToSardine);
	}

	//Fetch the model constants from the model constants class
	@Override
	public int getMaxAge() {
		return ModelConstants.getConstants().sardineMaxAge;
	}
	@Override
	public double getReporductionChance() {
		return ModelConstants.getConstants().sardineReproductionChance;
	}
	@Override
	public int getReporductionAge() {
		return ModelConstants.getConstants().sardineReproductionAge;
	}

	@Override
	public int getReproductionFoodLevel() {
		return ModelConstants.getConstants().sardineReproductionFoodLevel;
	}

	//used by the reproduce methods
	@Override
	public void placeChild(Location babyPos) {
		new Sardine(simulator,false,babyPos);
		
	}
	


}
