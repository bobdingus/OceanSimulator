package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class PlanktonReproductionInput extends VerifiedTextInput {
	public PlanktonReproductionInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().planktonReproductionChance = Double.parseDouble(this.field.getText());
		
	}
}