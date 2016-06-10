package UserInterface;

import Ocean.ModelConstants;
import Ocean.Simulator;

final class SimulationThread extends Thread {
	/**
	 * this will start a new thread and begin a simulation on it
	 *  once complete, the simulation will dispose of the JFrame and return to the launcher.
	 */
	private final Launcher launcher;

	/**
	 * @param launcher Launcher to set visible again once thread complete
	 */
	SimulationThread(Launcher launcher) {
		this.launcher = launcher;
	}

	@Override
	public void run() {
		this.launcher.optionsPanel.setAllValues();
		this.launcher.setVisible(false);
		Simulator s = new Simulator(ModelConstants.getConstants().fieldWidth,
				ModelConstants.getConstants().fieldDepth,this.launcher);
		s.simulatorView.dispose();
		this.launcher.setVisible(true);
		
	}
}