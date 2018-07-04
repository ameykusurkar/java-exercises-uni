package simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public abstract class Simulation<S> {
	
	///*** Instance Variables ***///
	private double currentTime;
	private Queue<ScheduledEvent<S>> queue;
	
	///*** Constructor ***///
	public Simulation() {
		this.queue = new PriorityQueue<ScheduledEvent<S>>();
		this.currentTime = 0;
	}
	
	///*** Methods ***///
	
	protected abstract boolean stop();
	
	protected abstract S getState();
	
	public void schedule(Event<S> e, double offset) {
		queue.add(new ScheduledEvent<S>(e, currentTime + offset));
	}
	
	protected void simulate() {
		
		while (!queue.isEmpty()) {
			
			ScheduledEvent<S> e = queue.poll();
			currentTime = e.getEventTime();
			
			if (stop()) {
				break;
			}
			
			e.getEvent().invoke(getState());
		}
	}
	
	public double getCurrentTime() {
		return currentTime;
	}
	
	public int getNumEvents() {
		return queue.size();
	}

}
