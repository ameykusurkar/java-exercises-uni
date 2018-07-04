package videogame;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TransportUnit extends Entity {
	
	private static final int DAMAGE_MODIFIER = 2;
	private final Set<Entity> entities;

	public TransportUnit(String name, int lifePoints) {
		super(name, lifePoints);
		entities = new HashSet<Entity>();
	}
	
	public void add(Entity e) {
		entities.add(e);
	}

	@Override
	protected int propagateDamage(int damageAmount) {
		assert damageAmount >= 0 : "Damage amount has to be positive";
		
		int damageCounter = 0;
		
		// Handles damage for the TransportUnit
		damageCounter += super.propagateDamage(damageAmount);
		
		// Handles damage for its set of entities
		for (Entity e : entities) {
			damageCounter += e.propagateDamage(damageAmount / DAMAGE_MODIFIER);
		}
		
		return damageCounter;
	}

	@Override
	public int minimumStrikeToDestroy() {
		int strikeNeeded = 0;
		for (Entity e : entities) {
			strikeNeeded += e.minimumStrikeToDestroy();
		}
		return strikeNeeded + lifePoints;
	}
	
	@Override
	public String toString() {
		String result = super.toString() + " transporting: [";
		Iterator<Entity> it = entities.iterator();
		if (it.hasNext()) {
			result += it.next();
		}
		while (it.hasNext()) {
			result += ", " + it.next();
		}
		return result + "]";
	}
}
