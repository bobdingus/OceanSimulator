package UserInterface;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 * The Launcher Class contains GUI containers and Components with actionlisteners
 * that trigger events such as
 * - starting the simulation
 * - view options menu, enter parameters
 * - quit application
 * @author Ian McNeilly
 *
 */

@SuppressWarnings("serial")
public class Launcher extends JFrame{
	
	//backround with image
	private BackroundPanel backround;
	
	//button to start simulation, uses defaults if options have not been configured
	private JButton startButton;
	
	//expands the options menu to confugure model parameters
	private JButton optionsButton;
	
	//exits the application
	private JButton quitButton;
	
	//a panel to contain start, options and quit, layered pane allows transparency
	private JLayeredPane primaryOptions;
	
	//contains the text fields to enter parameters and their associated labels
	protected OptionsPanel optionsPanel;
	
	
	public Launcher(){
		
		//design choice
		this.setUndecorated(true);
		
		//pane is not visible by default
		this.setVisible(true);
		
		//standard border layout
		this.setLayout(new BorderLayout());
		
		
		backround = new BackroundPanel();
		
		//the launcher will appear in the center of the users screen
		this.setLocation((Display.MONITOR_WIDTH/2)  - (backround.size.x/2) , (Display.MONITOR_HEIGHT /2) - (backround.size.y/2));

		this.getContentPane().add(backround,BorderLayout.CENTER);

		primaryOptions = new JLayeredPane();
		
  		backround.add(primaryOptions,BorderLayout.CENTER);
  		
  		
  		primaryOptions.setVisible(true);
  		
  		//standard left to right layout
  		primaryOptions.setLayout(new FlowLayout());

  		optionsPanel = new OptionsPanel();
  		
  		//will appear on the left
  		backround.add(optionsPanel, BorderLayout.WEST);
  		
  		startButton = new JButton("Start");
  		primaryOptions.add(startButton);
  		startButton.addActionListener(new ActionListener(){
			@Override
			/**
			 * when clicked, this will start a new thread and begin a simulation on it
			 * once complete, the simulation will dispose of the JFrame and return to the launcher.
			 */
			public void actionPerformed(ActionEvent arg0) {
				Thread r = new SimulationThread(Launcher.this);
				r.start();
			}});
  		
  		optionsButton = new JButton("Options");
  		primaryOptions.add(optionsButton);
  		//have the button toggle the optionsPanel visibility
  		optionsButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				optionsPanel.setVisible(!optionsPanel.isVisible());
				
			}});
  		
  	
  		quitButton = new JButton("Quit");
  		primaryOptions.add(quitButton);
  		//simply exit the application after disposing of the launcher
  		quitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);
				
			}
		});

		this.pack();
	}
	
	public static void main(String[] args){
		Launcher launcher = new Launcher();
	}


}
