package Ocean;

import java.awt.Color;
/**
 * Model constants has been modified to be a singleton class containing non static members
 * as they are updated by the launcher.
 * 
 * Singleton class was easier to debug than static fields.
 * 
 * @author Ian McNeilly
 *
 */
public class ModelConstants {
	
	private static ModelConstants instance;
	
	private ModelConstants(){}
	
	public static ModelConstants getConstants(){
		if(instance == null){
			instance = new ModelConstants();
		}
		return instance;
	}
	
	public double simulationSpeed = 60;
	public double siumulationDuration = 3;

	public double 	planktonProbability = 0.1d;
	public double 	planktonReproductionChance = 0.04d;
	public int 	  	planktonMaxAge 	= 60;
	public int 		planktonReproductionAge 	= 5; 
	public Color 	planktonColour 	= Color.GREEN;
	
	public double 	sharkProbability 	= 0.01d;
	public double 	sharkReproductionChance = 0.6d;
	public int 		sharkMaxAge 		= 10;
	public int 		sharkReproductionAge 		= 5;
	public int 		sharkReproductionFoodLevel 		= 900;
	public Color 	sharkColour 		= Color.RED;
	
	public double 	sardineProbability 	= 0.3d;
	public double 	sardineReproductionChance = 0.33d;
	public int 		sardineMaxAge 	= 100;
	public int 		sardineReproductionAge 	= 5;
	public int 		sardineReproductionFoodLevel 	= 100;
	public Color 	sardineColour 	= Color.GRAY;
	
	public int fieldDepth 		= 99;
	public int fieldWidth 		= 99;
	
	public int sardineNutritionalValueToShark = 100;
	public int planktonNutritionalValueToSardine = 50;
	
	public int simulationSeed = 44;
	
	public int maxFood = 1000;
	
}
