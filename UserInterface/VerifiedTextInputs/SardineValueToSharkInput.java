package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SardineValueToSharkInput extends VerifiedTextInput {
	public SardineValueToSharkInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sardineNutritionalValueToShark = Integer.parseInt(this.field.getText());
	}
}