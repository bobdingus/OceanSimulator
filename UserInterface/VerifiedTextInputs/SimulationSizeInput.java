package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SimulationSizeInput extends VerifiedTextInput {
	public SimulationSizeInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().fieldDepth = Integer.parseInt(this.field.getText());
		ModelConstants.getConstants().fieldWidth = Integer.parseInt(this.field.getText());
	}
}