package UserInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import UserInterface.VerifiedTextInputs.*;
/**
 * The options panel contains a list of verified text inputs.
 * These consist of a pair, a label and a text field, the text field is verified using
 * a custom regex input verifier
 * @author Ian McNeilly
 *
 */
@SuppressWarnings("serial")
public class OptionsPanel extends JPanel {
	
	/*
	 * this list is for the purposes of starting the simulation. Each input can be iterated over and its contents copied to 
	 *	the model constants class
	 */
	private ArrayList<VerifiedTextInput> inputs;
	
	//grid bag layout to allign inputs
	private GridBagConstraints constraints;
	
	//regular expressions to validate our inputs
	private String doubleRegex 		= "^(0\\.){1}[0-9]{1,9}(d|f)?$"; //allows numbers between 0 and 1, d or f optional
	private String intRegex 		= "^[0-9]{1,9}$";					//up to 1 billion -1 (9 digits)
	private String threeDigitIntRegex = "^([1-9][0-9][0-9]|[1-9][0-9]|[1-9])$"; //any number from 1 to 999
	
	public OptionsPanel() {
		this.inputs = new ArrayList<VerifiedTextInput>();
		this.setVisible(false);
		this.setLayout(new GridBagLayout());
		
		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		//add the text inputs to the panel
		this.addVerifiedTextInput(new SimSpeedInput(				"60", 	"Simulation Speed (FPS)", 				new RegexVerifier(intRegex,"60")));		
		this.addVerifiedTextInput(new PlanktonSpawnInput(			"0.2", 	"Plankton Spawn probability", 			new RegexVerifier(doubleRegex,"0.1")));		
		this.addVerifiedTextInput(new SharkSpawnInput(				"0.01", "Shark Spawn probability", 				new RegexVerifier(doubleRegex,"0.01")));		
		this.addVerifiedTextInput(new SardineSpawnInput(			"0.3", 	"Sardine Spawn probability", 			new RegexVerifier(doubleRegex,"0.3")));		
		this.addVerifiedTextInput(new PlanktonReproductionInput(	"0.33", "Plankton Reproduction Chance", 		new RegexVerifier(doubleRegex,"0.04")));		
		this.addVerifiedTextInput(new SharkReproductionInput(		"0.3", 	"Shark Reproduction Chance", 			new RegexVerifier(doubleRegex,"0.6")));	
		this.addVerifiedTextInput(new SardineReproductionInput(		"0.04", "Sardine Reproduction Chance", 			new RegexVerifier(doubleRegex,"0.33")));	
		this.addVerifiedTextInput(new PlanktonReproductionAgeInput(	"1", 	"Plankton Reproduction Age", 			new RegexVerifier(intRegex,"5")));	
		this.addVerifiedTextInput(new SharkReproductionAgeInput(	"15", 	"Shark Reproduction Age", 				new RegexVerifier(intRegex,"5")));		
		this.addVerifiedTextInput(new SardineReproductionAgeInput(	"1", 	"Sardine Reproduction Age", 			new RegexVerifier(intRegex,"5")));		
		this.addVerifiedTextInput(new SardineReproductionFoodInput(	"900",	"Sardine Reproduction Food Level", 		new RegexVerifier(intRegex,"100")));		
		this.addVerifiedTextInput(new SharkReproductionFoodInput(	"800", 	"Shark Reproduction Food Level", 		new RegexVerifier(intRegex,"900")));		
		this.addVerifiedTextInput(new SardineMaxAgeInput(			"200", 	"Sardine Max Age", 						new RegexVerifier(intRegex,"100")));
		this.addVerifiedTextInput(new PlanktonMaxAgeInput(			"60", 	"Plankton Max Age", 					new RegexVerifier(intRegex,"60")));
		this.addVerifiedTextInput(new SharkMaxAgeInput(				"100", 	"Shark Max Age", 						new RegexVerifier(intRegex,"10")));		
		this.addVerifiedTextInput(new SimulationSizeInput(			"150", 	"Simulation size (root)", 				new RegexVerifier(threeDigitIntRegex,"99")));		
		this.addVerifiedTextInput(new PlanktonValueToSardineInput(	"5", 	"Plankton nutritional value(Sardine)", 	new RegexVerifier(intRegex,			 "50")));
		this.addVerifiedTextInput(new SardineValueToSharkInput(		"10", 	"Sardine nutritional value(Shark)", 	new RegexVerifier(intRegex,"100")));
		this.addVerifiedTextInput(new SimulationSeedInput(			"1233", "Simulation Seed", 						new RegexVerifier(intRegex,"44")));
		this.addVerifiedTextInput(new SimulationDurationInput(		"60", 	"Simulation Duration (Seconds)", 		new RegexVerifier(intRegex,"60")));
		
	}
	
	/*
	 * adds the input to the list for use in starting simulation,
	 * adds the input to the panel itself
	 * change the grid bag constraints to keep the layout in line
	 * 
	 */
	private void addVerifiedTextInput(VerifiedTextInput input){
		this.inputs.add(input);
		constraints.gridx = 0;
		this.add(input.label,constraints);
		constraints.gridx = 1;
		this.add(input.field,constraints);
		constraints.gridy++;
	}
	
	//causes inputs to convert their fields and copy them to the associated values in ModelConstants
	public void setAllValues(){
		for(VerifiedTextInput v : inputs){
			v.setConstant();
		}
	}
	
		
}
