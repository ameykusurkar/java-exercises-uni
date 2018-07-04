package ticks;

import simulation.Event;

public class Tick implements Event<Ticks> {
	
	// INTERVAL in seconds
	public static final double INTERVAL = 1.0;

	@Override
	public void invoke(Ticks simulation) {
		
		System.out.println("Tick at: " + simulation.getCurrentTime());
		
		simulation.schedule(new Tick(), INTERVAL);
		
	}

}
