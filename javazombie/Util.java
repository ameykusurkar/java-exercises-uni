public class Util {

  public static Outcome calculateOutcome(double index, double biteChance,
      double hitChance, double destroyChance) {

    if (index <= biteChance) return Outcome.BITTEN;
		else if (index <= biteChance + destroyChance) return Outcome.HIT;
		else return Outcome.DESTROYED;

  }

  public static int findIndexGreaterThanOrEqualTo(int[] numbers, int target) {

    for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] >= target) return i;
		}
    return -1;

  }

  public static void swap(Zombie[] zombies, int x, int y) {
    assert x < zombies.length && y < zombies.length : "Index not in range";
		
		Zombie temp = zombies[x];
		zombies[x]  = zombies[y];
		zombies[y]  = temp;
		
  }

}
