
public class AI {

	public static int bestMove(Game game) {
		int currPlayer = game.getCurrentPlayer();
		int resultBowl;
		if (currPlayer == 1) {
			resultBowl = getBestMove(game, 1, 6);
		} else {
			resultBowl = getBestMove(game, 7, 12);
		}

		return resultBowl;
	}


	private static int getBestMove(Game game, int st, int fin) {

		int bestBowl = 0;
		int bestScore = -1;

		for (int i = st; i <= fin; i++) {

			if (!game.isValidMove(i)) continue;

			Bowl[] board = copyBoard(game);

			int numStones = board[i-1].takeAllStones();

			for (int j = 0; j < numStones; j++) {
				int bowlNum = i + j + 1;
				if (bowlNum > 12) bowlNum -= 12;
				board[bowlNum-1].depositStone();

			}

			int turnScore = 0;
			for (int k = 0; k < board.length; k++) {
				turnScore += board[k].updateAndGetScore();
			}

			if (turnScore > bestScore) {
				bestBowl = i;
				bestScore = turnScore;
			}

		}

		return bestBowl;
	}

	private static Bowl[] copyBoard(Game game) {
		Bowl[] newBowl = new Bowl[12];
		for (int i = 0; i < 12; i++) {
			newBowl[i] = new Bowl(game.getBowlValue(i+1));
		}
		return newBowl;
	}



}