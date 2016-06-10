package Ocean.Creature;

import Ocean.Location;
import Ocean.ModelConstants;
import Ocean.Simulator;

public class Shark extends Fish {

	public Shark(Simulator simulator, boolean randomAge,Location location) {
		super(simulator, randomAge, location );
		diet.put(Sardine.class, ModelConstants.getConstants().sardineNutritionalValueToShark);
	}
	
	//Fetch the model constants from the model constants class
	@Override
	public int getMaxAge() {
		return ModelConstants.getConstants().sharkMaxAge;
	}
	@Override
	public double getReporductionChance() {
		return ModelConstants.getConstants().sharkReproductionChance;
	}
	@Override
	public int getReporductionAge() {
		return ModelConstants.getConstants().sharkReproductionAge;
	}
	
	@Override
	public int getReproductionFoodLevel() {
		return ModelConstants.getConstants().sharkReproductionFoodLevel;
	}
	
	//used by the reproduce methods
	@Override
	public void placeChild(Location babyPos) {
		new Shark(simulator,false,babyPos);
		
	}
	

}
