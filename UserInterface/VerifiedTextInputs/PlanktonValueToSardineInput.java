package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class PlanktonValueToSardineInput extends VerifiedTextInput {
	public PlanktonValueToSardineInput(String defaultValue,
			String labelText, InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().planktonNutritionalValueToSardine = Integer.parseInt(this.field.getText());
		
	}
}