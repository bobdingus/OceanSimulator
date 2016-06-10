package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SardineReproductionFoodInput extends VerifiedTextInput {
	public SardineReproductionFoodInput(String defaultValue,
			String labelText, InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sardineReproductionFoodLevel = Integer.parseInt(this.field.getText());
		
	}
}