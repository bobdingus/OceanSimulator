package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SharkReproductionAgeInput extends VerifiedTextInput {
	public SharkReproductionAgeInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sharkReproductionAge = Integer.parseInt(this.field.getText());
		
	}
}