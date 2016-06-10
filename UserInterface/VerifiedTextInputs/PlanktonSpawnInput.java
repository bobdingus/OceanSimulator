package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class PlanktonSpawnInput extends VerifiedTextInput {
	public PlanktonSpawnInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().planktonProbability = Double.parseDouble(this.field.getText());
		
	}
}