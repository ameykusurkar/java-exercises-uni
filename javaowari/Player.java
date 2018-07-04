
class Player {

	// Instance variable //
	private int score;

	// Initialises instance with a score of 0.
	public Player() {
		score = 0;
	}

	// Adds points to a player's score
	public void addToScore(int points) {
		assert points >= 0 : "Cannot add negative points";
		score += points;
	}

	// Returns the score of the player
	public int getScore() {
		return score;
	}

}