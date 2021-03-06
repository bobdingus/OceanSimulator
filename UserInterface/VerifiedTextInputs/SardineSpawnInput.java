package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SardineSpawnInput extends VerifiedTextInput {
	public SardineSpawnInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().sardineProbability = Double.parseDouble(this.field.getText());
		
	}
}