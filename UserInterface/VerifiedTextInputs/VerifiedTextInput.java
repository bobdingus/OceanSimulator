package UserInterface.VerifiedTextInputs;

import javax.swing.InputVerifier;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class VerifiedTextInput extends JPanel {
	
	public JLabel label;
	public JTextField field;
	
	public abstract void setConstant();
	
	public VerifiedTextInput(String defaultValue, String labelText,InputVerifier verifier){
		label = new JLabel(labelText);
		label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		field = new JTextField();
		field.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		field.setInputVerifier(verifier);
		field.setColumns(10);
		field.setText(defaultValue);

	}
	


}
