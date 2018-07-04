package simulation;

public class ScheduledEvent<S> implements Comparable<ScheduledEvent<S>> {
	
	private final Event<S> event;
	private final double eventTime;
	
	public ScheduledEvent(Event<S> event, double eventTime) {
		this.event = event;
		this.eventTime = eventTime;
	}
	
	public double getEventTime() {
		return eventTime;
	}
	
	public Event<S> getEvent() {
		return event;
	}

	@Override
	public int compareTo(ScheduledEvent<S> o) {
		// Sorts ScheduledEvents by their eventTimes
		
		if (this.getEventTime() < o.getEventTime()) {
			return -1;
		} else if (this.getEventTime() > o.getEventTime()) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
