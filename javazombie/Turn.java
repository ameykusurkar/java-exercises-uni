import java.util.Arrays;

public class Turn {

  private static final int NUM_EASY_ZOMBIES = 20;
  private static final int NUM_MEDIUM_ZOMBIES = 20;
  private static final int NUM_HARD_ZOMBIES = 10;

  private static final int MAX_NUM_ZOMBIES = NUM_EASY_ZOMBIES
      + NUM_MEDIUM_ZOMBIES + NUM_HARD_ZOMBIES;

  private static final int BITE_LIMIT = 6;
  private static final int HAND_SIZE = 5;

  private final int player;

  private final Zombies zombiePopulation = new Zombies(MAX_NUM_ZOMBIES);
  private final Zombies destroyed = new Zombies(MAX_NUM_ZOMBIES);
  private final Zombies hit = new Zombies(HAND_SIZE);
  private final Zombies bitten = new Zombies(MAX_NUM_ZOMBIES);

  public Turn(int player) {
    this.player = player;

    for (int i = 0; i < NUM_EASY_ZOMBIES; i++) {
			zombiePopulation.addZombie(Zombie.EASY);
		}

		for (int i = 0; i < NUM_MEDIUM_ZOMBIES; i++) {
			zombiePopulation.addZombie(Zombie.MEDIUM);
		}

		for (int i = 0; i < NUM_HARD_ZOMBIES; i++) {
			zombiePopulation.addZombie(Zombie.HARD);
		}

  }

  public int getCurrentPlayer() {

    return player;
  }

  public boolean hasBeenBittenTooManyTimes() {

    return (bitten.getNumberOfZombies() >= BITE_LIMIT);
  }

  public int getCurrentScore() {

    if (hasBeenBittenTooManyTimes()) return 0;
    return destroyed.getNumberOfZombies();
  }

  private void addZombies(Zombies hand, int extraZombiesNeeded) {

    if (extraZombiesNeeded > zombiePopulation.getNumberOfZombies()) {
			hand.takeAllZombies(zombiePopulation);
		} else {
			for (int i = 0; i < extraZombiesNeeded; i++) {
        int index = 
          (int) (Math.random() * zombiePopulation.getNumberOfZombies());
				hand.addZombie(zombiePopulation.removeZombie(index));
			}
		}
  }

  private Outcome[] getOutcomesForHand(Zombies hand) {

    Outcome[] outcomes = new Outcome[hand.getNumberOfZombies()];
    int numZombies = hand.getNumberOfZombies();

    for (int i = 0; i < numZombies; i++) {

      Zombie currZom = hand.removeZombie(hand.getNumberOfZombies()-1);
      Outcome currentOutcome = currZom.randomOutcome();
      outcomes[i] = currentOutcome;

      switch(currentOutcome) {
        case BITTEN:    bitten.addZombie(currZom); 
                        break;
        case HIT:       hit.addZombie(currZom); 
                        break;
        case DESTROYED: destroyed.addZombie(currZom); 
                        break;
      }

    }


    return outcomes;
  }

  public Outcome[] drawAndGetOutcomes() {

    Zombies hand = new Zombies(HAND_SIZE);
	 	hand.takeAllZombies(hit);
    int zombiesNeeded = HAND_SIZE - hand.getNumberOfZombies();
    addZombies(hand, zombiesNeeded);
    return getOutcomesForHand(hand);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Destroyed: ");
    sb.append(destroyed);
    sb.append("\n");
    sb.append("Hits: ");
    sb.append(hit);
    sb.append("\n");
    sb.append("Bites: ");
    sb.append(bitten);
    return sb.toString();
  }

}
