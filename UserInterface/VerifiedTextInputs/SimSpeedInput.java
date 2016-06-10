package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SimSpeedInput extends VerifiedTextInput {
	public SimSpeedInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().simulationSpeed = Integer.parseInt(this.field.getText());
		
	}
}