import java.util.Arrays;

public class Zombies {

  private final Zombie[] zombies;
  private int numberOfZombies;

  public Zombies(int maxZombies) {

  	this.zombies = new Zombie[maxZombies];
	  this.numberOfZombies = 0;

  }

  public int getNumberOfZombies() {
    return this.numberOfZombies;
  }

  public void addZombie(Zombie zombie) {
		assert numberOfZombies < zombies.length : "Cannot add more zombies";

    zombies[numberOfZombies] = zombie;
    numberOfZombies++;
  }

  public Zombie removeZombie(int zombieIndex) {
		assert zombieIndex < numberOfZombies : "No zombie at current index"; 
    
		Util.swap(zombies, zombieIndex, numberOfZombies-1);
    int lastIndex = numberOfZombies -1;
    numberOfZombies--;
		return zombies[lastIndex];
    
  }

  public void takeAllZombies(Zombies other) {
    while (other.getNumberOfZombies() > 0) {

			this.addZombie(other.removeZombie(other.getNumberOfZombies()-1));
	
		}
  }

  public String toString() {
    Zombie[] smaller = Arrays.copyOf(zombies, numberOfZombies);
    return Arrays.toString(smaller);
  }

}
