package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SharkReproductionInput extends VerifiedTextInput {
	public SharkReproductionInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sharkReproductionChance = Double.parseDouble(this.field.getText());
		
	}
}