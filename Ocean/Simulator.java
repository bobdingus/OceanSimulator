package Ocean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import Ocean.Creature.Creature;
import Ocean.Creature.Plankton;
import Ocean.Creature.Sardine;
import Ocean.Creature.Shark;
import UserInterface.Launcher;
/**
 * The simulator class contains all the components that make up the simulation
 * as well as the main loops that govern the running of simulation frames
 * 
 * The simulator uses an event queue and timer to update itself, the speed of which is determined by the
 * user
 * 
 * There is also another timer event which will terminate the simulation, this is the duration, also governed by the user
 * 
 * @author Ian McNeilly
 *
 */
public class Simulator {

	public SimulatorView simulatorView;
	public 	Field field;
	
	//tracks the current simulation step
	private int simulationStep;
	
	//once set to false the simulators simulate() method will finish
	public 	boolean simulationActive = true;
	
	/*
	 * this will be a shuffled list of cordinate pairs corresponding to the field
	 * avoiding the need for duplicate creature container and associated baggage 
	 * eg - concurrent modification exceptions
	 * Performance is improved over using lists due to not having to do expensive remove() calls
	 */
	public 	ArrayList<Location> gridLocations;

	//the simulation event queue will hold events for tasks like simulating a frame, and closing the simulation
	public 	Queue<SimulationEvent> EventQueue;
	
	//will put simulateOneStep() events onto the event queue
	private Timer frameTimer;
	
	//will put the simulation termination command onto the event queue
	private Timer simulationTimer;

	public 	Simulator(int width, int depth,Launcher startScreen){
		//set the RNG seed according to the user preference
		RandomGenerator.initialiseWithSeed(ModelConstants.getConstants().simulationSeed);

		EventQueue = new LinkedList<SimulationEvent>();
		
		/*
		 * - initialise the frame timer with the desired simulation speed in FPS
		 * - show it which event queue to place the event on
		 * - give it the command to simulate one frame
		 * 
		 */
		frameTimer = new Timer(ModelConstants.getConstants().simulationSpeed,EventQueue, new SimulationEvent(){
			@Override
			public void handle() {
				Simulator.this.simulateOneStep();
				
			}});
		
		/*
		 * - initialise the simulation timer with the desired simulation duration
		 * - 1/duration to convert seconds to FPS
		 * - show it which event queue to place the event on
		 * - give it the command to terminate simulation
		 * 
		 */
		simulationTimer = new Timer(1/ModelConstants.getConstants().siumulationDuration,EventQueue, new SimulationEvent(){
			@Override
			public void handle() {
				Simulator.this.simulationActive = false;
				
			}});	
		
		/*
		 * check the size of the field is not less than zero and init to defaults if so.
		 * should be avoided due to regex validation in user input. 
		 */
		if(width <= 0 ||
				depth <= 0){
			simulatorView = new SimulatorView(ModelConstants.getConstants().fieldWidth,ModelConstants.getConstants().fieldDepth,this);
			field = new Field(ModelConstants.getConstants().fieldWidth, ModelConstants.getConstants().fieldDepth);
		}
		else{
			simulatorView = new SimulatorView(width,depth,this);
			field = new Field(width, depth);
		}
		
		//set colours for creatures.
		simulatorView.setColor(Shark.class, ModelConstants.getConstants().sharkColour);
		simulatorView.setColor(Sardine.class, ModelConstants.getConstants().sardineColour);
		simulatorView.setColor(Plankton.class, ModelConstants.getConstants().planktonColour);
		
		/*
		 * List of grid locations only needs to be compiled once, after which it should be shuffled once per frame to avoid
		 * order of processing related visual anomolies.
		 */
		gridLocations = new ArrayList<Location>();
		for(int x = 0 ; x < field.getWidth();x++){
			for(int y = 0; y < field.getDepth(); y++){
				gridLocations.add(new Location(x,y));
			}
		}
		
		//for displaying which frame we are on in the GUI
		simulationStep = 0;
		startSimulation();
	
	}
	
	//using the ratio of 0 - 1 split across the three types, populate the field
	public void populate(){
		for(int x = 0; x < field.getWidth(); x++){
			for(int y = 0; y < field.getDepth(); y++){
				double chance = RandomGenerator.getRandom().nextDouble();
				if(chance < ModelConstants.getConstants().planktonProbability){
					new Plankton(this, true,new Location(x,y));
					
				}
				else if(chance  < ModelConstants.getConstants().planktonProbability + ModelConstants.getConstants().sharkProbability){
					new Shark(this,true,new Location(x,y));
					
				}
				else if(chance  < ModelConstants.getConstants().planktonProbability + ModelConstants.getConstants().sharkProbability + ModelConstants.getConstants().sardineProbability){
					new Sardine(this, true,new Location(x,y));
					
				}
			}
		}
		
		
		
	}
	
	
	public void startSimulation(){
		populate();
		simulate();
	}
	
	/*
	 * timers are ticked and the display is updated whenever there is nothing on the event queue,
	 * otherwise the events are handled in a FIFO order until the queue is empty.
	 */
	public void simulate(){
		while(simulationActive){
			frameTimer.tick();
			simulationTimer.tick();
			simulatorView.showStatus(simulationStep, field);
			while (!EventQueue.isEmpty())
			{
				EventQueue.poll().handle();
			}
			
		}
	}
	
	/*
	 * shuffle the locations, if there is a creature at any given location, allow it to act.
	 * advance the sumulation step count
	 */
	public void simulateOneStep(){
		Collections.shuffle(gridLocations,RandomGenerator.getRandom());
		for(Location l: gridLocations){
			Creature c = field.getObjectAt(l);
			if(c!=null){
				c.act();
			}
		}
		simulationStep++;
	}
	


}
