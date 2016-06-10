package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SardineMaxAgeInput extends VerifiedTextInput {
	public SardineMaxAgeInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sardineMaxAge = Integer.parseInt(this.field.getText());
		
	}
}