package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class PlanktonReproductionAgeInput extends VerifiedTextInput {
	public PlanktonReproductionAgeInput(String defaultValue,
			String labelText, InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().planktonReproductionAge = Integer.parseInt(this.field.getText());
		
	}
}