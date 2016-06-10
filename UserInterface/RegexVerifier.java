package UserInterface;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
/**
 * This class extends the standard swing InputVerifier class and provides a verify method that
 * evaluates text inputs.
 * 
 * If an input doesnt match the regular expression a dialog box appears, and the value is reset to a default
 * @author Ian McNeilly
 *
 */
public class RegexVerifier extends InputVerifier{
	
	private final String regex;
	private final String defaultValue;
	/**
	 * 
	 * @param regex			the regular expression to be used in evaluation of input
	 * @param defaultValue	the value to default to if the user puts in an invalid value
	 */
	public RegexVerifier(String regex,String defaultValue){
		this.regex = regex;
		this.defaultValue = defaultValue;
	}
	

	@Override
	public boolean verify(JComponent component) {
		/*
		 * this should only be used with a JTextComponent type object
		 */
		if(!JTextComponent.class.isAssignableFrom(component.getClass())){
			try {
				throw new UnsupportedOperationException("RegexVerifier class only supports JTextComponents or subclasses thereof");
			} catch (UnsupportedOperationException e) {
				e.printStackTrace();
				System.exit(4);
			}
		}
		//At this point a cast to JTextComponent should be safe.
		JTextComponent textComponent = (JTextComponent)component;
		if(!textComponent.getText().matches(regex)){
			JOptionPane.showMessageDialog(textComponent, "Invalid value");
			textComponent.setText(defaultValue);
			return false;
		}
		return true;
	}
}
