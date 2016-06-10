package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class PlanktonMaxAgeInput extends VerifiedTextInput {
	public PlanktonMaxAgeInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().planktonMaxAge = Integer.parseInt(this.field.getText());
		
	}
}