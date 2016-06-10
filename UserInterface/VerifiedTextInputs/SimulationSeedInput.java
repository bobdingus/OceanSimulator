package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SimulationSeedInput extends VerifiedTextInput {
	public SimulationSeedInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().simulationSeed = Integer.parseInt(this.field.getText());
	}
}