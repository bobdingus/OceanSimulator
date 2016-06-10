package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SharkReproductionFoodInput extends VerifiedTextInput {
	public SharkReproductionFoodInput(String defaultValue,
			String labelText, InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sharkReproductionFoodLevel = Integer.parseInt(this.field.getText());
		
	}
}