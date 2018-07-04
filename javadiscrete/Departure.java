package ssq;

import simulation.Event;

public class Departure implements Event<SingleServerQueue> {

  @Override
  public void invoke(SingleServerQueue simulation) {
    
    simulation.decrementQueue();
    
    System.out.println("Departure at " + simulation.getCurrentTime()
        + ", new population = " + simulation.getQueueSize());
    
    if (!simulation.queueIsEmpty()) {
      
      simulation.newDeparture();
    }
    
  }

}
