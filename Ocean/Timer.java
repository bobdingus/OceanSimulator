package Ocean;

import java.util.Calendar;
import java.util.Queue;


/**
 * The timer class takes three arguments for construction
 * 	- frequency: how often it is triggered (FPS)
 *  - An event queue
 *  - An event 
 *  
 *  It serves to put the specified event onto the specified event queue 
 *  when the specified amount of time in milliseconds(frequency) has passed.
 *  In order to do this, the tick() method must be called regularly
 *  
 *  The class is extensible and can be used on any event queue with any simulation event.
 *
 *  
 * @author Ian McNeilly

 */
public  class Timer {
	
	double startTime;
	double endTime;
	long currentTime;
	double frequency;
	
	//indicates if the last tick triggered an event to be placed on the queue
	boolean signal;
	
	Queue<SimulationEvent> myEventQueue;
	SimulationEvent myEvent;
	
	
	public Timer(double frequency,Queue<SimulationEvent> evq,SimulationEvent ev){
		signal = false;
		myEvent = ev;
		myEventQueue = evq;
		this.frequency = frequency;
		
		//get the current time in milliseconds
		startTime =  Calendar.getInstance().getTimeInMillis(); 
		
		//calculate ammount of milliseconds till desired time has passed
		endTime = startTime + (1000/frequency);
	}
	
	/*
	 * update the current time and check if it has reached the desired duration
	 * if so places the desired event onto the event queue and signals via boolean return
	 * that the tick has resulted in an event
	 * resets the timer
	 */
	public boolean tick(){
		currentTime = Calendar.getInstance().getTimeInMillis();
		if (currentTime >= endTime){
			signal = true;
			myEventQueue.add(myEvent);
			reset();
		}
		else signal = false;
		return signal;
	}
	
	/*
	 * calculate the next time interval
	 */
	protected void reset(){
		startTime =  (double)(Calendar.getInstance().getTimeInMillis()); 
		endTime = startTime + (1000/frequency);
	}
}
