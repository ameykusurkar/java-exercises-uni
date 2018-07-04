
class Bowl {

	// Instance variables //
	private int numStones;
	private int pendingDeps;

	// Initiates a bowl with given number of stones
	public Bowl(int stones) {
		assert stones >= 0 : "Needs postive number of stones";
		numStones = stones;
		pendingDeps = 0;
	}

	// Returns the number of stones in the bowl
	public int getStones() {
		return numStones;
	}

	// Returns number of stones in bowl and empties it
	public int takeAllStones() {
		int temp = numStones;
		numStones = 0;
		return temp;
	}

	// Records the deposit of a new stone in bowl
	public void depositStone() {
		pendingDeps++;
	}

	// Updates the stones in the bowl with pending deposits
	// Returns the aquired score from the bowl
	public int updateAndGetScore() {

		if (numStones == 1 && pendingDeps > 0) {

			int result = numStones + pendingDeps;
			numStones = 0;
			pendingDeps = 0;
			return result;

		} else {

			numStones += pendingDeps;
			pendingDeps = 0;
			return 0;

		}

	}

}