package ssq;

import java.util.Random;

import simulation.Simulation;

public class SingleServerQueue extends Simulation<SingleServerQueue> {
  
  //*** Instance Variables ***///
  private final double endTime;
  private final Random random;
  private int queueSize;
  
  private double aggregateLength;
  private double timeElapsed;
  
  ///*** Constants ***///
  private static final double SERVICE_TIME = 0.25;
  
  ///*** Constructor ***/// 
  public SingleServerQueue(long seed, double endTime) {
    this.endTime = endTime;
    this.queueSize = 0;
    this.random = new Random(seed);
    this.aggregateLength = 0;
    this.timeElapsed = 0;
    
    newArrival();
  }

  ///*** Methods ***///
  
  @Override
  protected boolean stop() {
    return getCurrentTime() >= endTime;
  }
  
  @Override
  protected SingleServerQueue getState() {
    return this;
  }
  
  public static void main(String[] args) {
    
    long seed;
    double endTime;
    
    try {
      seed = Long.parseLong(args[0]);
      endTime = Double.parseDouble(args[1]);
    } catch (Exception e) {
      System.out.println("Invalid input for Ticks duration.");
      return;
    }
    
    SingleServerQueue ssq = new SingleServerQueue(seed, endTime);
    ssq.simulate();
    
    // This is to ensure that currentTime is endTime
    ssq.setToEndTime();
    ssq.updateMeanQueueLength();
    
    System.out.println("SIMULATION COMPLETE - the mean queue length was "
                + ssq.getMeanQueueLength());

  }
  
  public void newArrival() {
    schedule(new Arrival(), random.nextDouble());
  }
  
  public void newDeparture() {
    schedule(new Departure(), SERVICE_TIME);
  }
  
  public void incrementQueue() {
    updateMeanQueueLength();
    queueSize++;
  }
  
  public void decrementQueue() {
    if (queueSize > 0) {
      updateMeanQueueLength();
      queueSize--;
    }
  }
  
  public boolean queueIsEmpty() {
    return queueSize == 0;
  }
  
  public int getQueueSize() {
    return queueSize;
  }
  
  // Used to correctly set the currentTime to endTime if it overshoots
  private void setToEndTime() {
    goToTime(endTime);
  }
  
  private void updateMeanQueueLength() {
    aggregateLength += getQueueSize() * getEventDuration();
    timeElapsed += getEventDuration();
  }
  
  private double getMeanQueueLength() {
    return aggregateLength / timeElapsed;
  }

}
