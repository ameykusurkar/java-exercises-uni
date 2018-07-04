package ticks;

import simulation.Simulation;

public class Ticks extends Simulation<Ticks> {
	
	private final double endTime;
	
	public Ticks(double endTime) {
		assert endTime >= 1: "End time must be at least 1.0";
		this.endTime = endTime;
		schedule(new Tick(), Tick.INTERVAL);
	}

	@Override
	protected boolean stop() {
		return getCurrentTime() >= endTime;
	}
	
	@Override
	protected Ticks getState() {
		return this;
	}
	
	public static void main(String args[]) {
		
		try {
			Ticks t = new Ticks(Double.parseDouble(args[0]));
			t.simulate();
		} catch (Exception e) {
			System.out.println("Invalid input for Ticks duration.");
			return;
		}
		
	  }

}
