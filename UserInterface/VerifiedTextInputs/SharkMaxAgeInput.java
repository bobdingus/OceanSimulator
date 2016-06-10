package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SharkMaxAgeInput extends VerifiedTextInput {
	public SharkMaxAgeInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sharkMaxAge = Integer.parseInt(this.field.getText());
		
	}
}