package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;

import Ocean.ModelConstants;

public class SimulationDurationInput extends VerifiedTextInput {
	public SimulationDurationInput(String defaultValue, String labelText,
			InputVerifier verifier) {
		super(defaultValue, labelText, verifier);
	}

	@Override
	public void setConstant() {
		ModelConstants.getConstants().siumulationDuration = Integer.parseInt(this.field.getText());
	}
}