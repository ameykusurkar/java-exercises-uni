
class Game {

	// Instance variables //
	private Player p1;
	private Player p2;
	private Bowl[] board;
	private Player currPlayer;

	// Constants //
	private final int INIT_STONES = 4;

	// Initiates a new game
	public Game() {
		p1 = new Player();
		p2 = new Player();
		board = new Bowl[12];

		for (int i = 0; i < board.length; i++) {
			board[i] = new Bowl(INIT_STONES);
		}

		currPlayer = p1;
	}

	// Returns ID of the current player
	public int getCurrentPlayer() {
		if (currPlayer == p1) return 1;
		else return 2;
	}

	// Changes the current player
	public void swapPlayers() {
		if (currPlayer == p1) currPlayer = p2;
		else if (currPlayer == p2) currPlayer = p1;
	}

	// Returns true iff current player can play from given bowl
	public boolean isValidMove(int bowl) {
		if (1 > bowl || bowl > 12) return false;

		if (board[bowl-1].getStones() == 0) return false;

		if (currPlayer == p1) {
			return 0 < bowl && bowl <= 6;
		} else {
			return 6 < bowl && bowl <= 12;
		}
	}

	// Returns true iff current player has a valid move
	public boolean canCurrentPlayerMove() {

		for (int i = 0; i < board.length; i++) {
			if (isValidMove(i+1)) return true;
		}

		return false;
	}

	// Updates state of game with player moving given bowl
	public void move(int bowl) {

		if (canCurrentPlayerMove()) {
			assert isValidMove(bowl) : "Move is not valid";

			// Removes all stones from the given bowl
			// and gives them to numStones
			int numStones = board[bowl-1].takeAllStones();

			//For loop to deposit the stones into following pots
			for (int i = 0; i < numStones; i++) {
				int bowlNum = bowl + i + 1;
				if (bowlNum > 12) bowlNum -= 12;
				board[bowlNum-1].depositStone();
			}

			//Calculates score gained by current player
			int turnScore = 0;
			for (int i = 0; i < board.length; i++) {
				turnScore += board[i].updateAndGetScore();
			}
			currPlayer.addToScore(turnScore);

		}

		swapPlayers();
	}

	// Returns the leader player's ID
	public int getLeadingPlayer() {
		if (p1.getScore() > p2.getScore()) return 1;
		return 2;
	}

	// Returns true iff game is over
	public boolean isOver() {
		return p1.getScore() >= 24 || p2.getScore() >= 24;
	}

	// Prints the game board to console
	public void display() {

		System.out.println("");
		System.out.println("Player 2: " + p2.getScore());
		System.out.println("");

		for (int i = 12; i > 6; i--) {
			if (i > 9) {
				System.out.print("   " + i + "  ");
			} else {
				System.out.print("   " + i + "   ");
			}
		}
		System.out.println("");

		for (int i = 11; i > 5; i--) {
			if (board[i].getStones() > 9) {
				System.out.print("( " + board[i].getStones() + " ) ");
			} else {
				System.out.print("(  " + board[i].getStones() + " ) ");
			}
		}
		System.out.println("");
		System.out.println("");

		for (int i = 0; i < 6; i++) {
			if (board[i].getStones() > 9) {
				System.out.print("( " + board[i].getStones() + " ) ");
			} else {
				System.out.print("(  " + board[i].getStones() + " ) ");
			}
		}
		System.out.println("");

		for (int i = 1; i < 7; i++) {
			System.out.print("   " + i + "   ");
		}
		System.out.println("");
		System.out.println("");

		System.out.println("Player 1: " + p1.getScore());
		System.out.println("");

	}

	public int getBowlValue(int bowl) {
		return board[bowl-1].getStones();
	}

}