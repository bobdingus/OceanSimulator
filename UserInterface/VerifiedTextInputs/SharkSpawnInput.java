package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SharkSpawnInput extends VerifiedTextInput {
	public SharkSpawnInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sharkProbability = Double.parseDouble(this.field.getText());
		
	}
}