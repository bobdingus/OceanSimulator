package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SardineReproductionAgeInput extends VerifiedTextInput {
	public SardineReproductionAgeInput(String defaultValue,
			String labelText, InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sardineReproductionAge = Integer.parseInt(this.field.getText());
		
	}
}