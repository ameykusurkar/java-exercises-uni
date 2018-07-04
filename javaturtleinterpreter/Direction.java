package turtle.util;

public enum Direction {

	NORTH      (0, 1),
	NORTH_EAST (1, 1),
	EAST       (1, 0),
	SOUTH_EAST (1, -1), 
	SOUTH      (0, -1),
	SOUTH_WEST (-1, -1),
	WEST       (-1, 0),
	NORTH_WEST (-1, 1);
	
	private int xMov;
	private int yMov;
	
	private static final int TURNS_TO_OPPOSITE = values().length / 2;
	
	private Direction(int xMov, int yMov) {
		this.xMov = xMov;
		this.yMov = yMov;
	}

	// Returns direction 45 degrees in the direction of rotation
	public Direction rotate(Rotation r) {

		switch (r) {

		case LEFT:
			// Fixes the negative value problem of modulus
			if (ordinal() == 0) {
				return NORTH_WEST;
			}
			
			return values()[(ordinal() - 1) % values().length];

		case RIGHT:
			return values()[(ordinal() + 1) % values().length];
			
		default:
			return this;

		}
	}
	
	// Returns the opposite direction
	public Direction turnBack() {
		return values()[(ordinal() + TURNS_TO_OPPOSITE) % values().length];
	}
	
	// Returns a tuple of the directional vector for movement
	public Tuple<Integer, Integer> getMovement() {
		return new Tuple<Integer, Integer>(xMov, yMov);
	}
	
	public static Direction newDirection(int x, int y) {
		assert Math.abs(x) <= 1 && Math.abs(y) <= 1 
				: "Must be between -1 and 1";
		
		switch(x) {
		
		case -1:
			switch (y) {
			
			case -1: return SOUTH_WEST;
			case 0: return WEST;
			case 1: return NORTH_WEST;
			}
		case 0:
			switch (y) {
			
			case -1: return SOUTH;
			case 1: return NORTH;
			}
		case 1:
			switch (y) {
			
			case -1: return SOUTH_EAST;
			case 0: return EAST;
			case 1: return NORTH_EAST;
			}
		}
		
		// Assert will prevent this case
		return null;
	}


}
