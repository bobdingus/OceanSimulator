package Ocean;
/**
 * Basic interface for putting events onto the simulation event queue
 * 
 * @author Ian McNeilly
 *
 */
public interface SimulationEvent {
	public  void handle();
}
