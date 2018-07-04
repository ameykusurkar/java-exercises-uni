package videogame;

public class Magician extends Entity implements SpellCaster {

	private static final int STRENGTH_MULTIPLIER = 2;

	public Magician(String name, int lifePoints) {
		super(name, lifePoints);
	}

	@Override
	public int getStrength() {
		return lifePoints * STRENGTH_MULTIPLIER;
	}

	@Override
	public int minimumStrikeToDestroy() {
		return lifePoints;
	}
	
}
