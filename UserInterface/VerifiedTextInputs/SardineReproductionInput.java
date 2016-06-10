package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SardineReproductionInput extends VerifiedTextInput {
	public SardineReproductionInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sardineReproductionChance = Double.parseDouble(this.field.getText());
		
	}
}