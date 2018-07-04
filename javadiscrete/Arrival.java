package ssq;

import simulation.Event;

public class Arrival implements Event<SingleServerQueue> {
  
  @Override
  public void invoke(SingleServerQueue simulation) {
    
    
    if (simulation.queueIsEmpty()) {
      
      simulation.newDeparture();
    }
    
    simulation.incrementQueue();
    
    simulation.newArrival();
    
    System.out.println("Arrival at " + simulation.getCurrentTime()
        + ", new population = " + simulation.getQueueSize());
    
  }

}
