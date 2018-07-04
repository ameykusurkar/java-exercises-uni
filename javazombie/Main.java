import java.util.Arrays;

public class Main {
  
  private static void playTurn(Turn turn) {

		boolean play = true;

		do {

		  Outcome[] outcomes = turn.drawAndGetOutcomes();
			if (outcomes.length == 0) {
				System.out.println("You have exceeded the population!");
				return;
			}

			//Printing outcomes to console
			System.out.println("You got: " + Arrays.toString(outcomes));

			//Printing piles to console
			System.out.println("Current piles:");
			System.out.println(turn);

			if (turn.hasBeenBittenTooManyTimes()) {
				System.out.println("You have been bitten too many times!");
				return;
			}
			
			int decision;
			do {
				System.out.print("Enter 0 to score the turn, 1 to draw again: ");
				decision = IOUtil.readInt();
			} while (decision != 0 && decision != 1);

			if (decision == 0) play = false;

		} while (play);

  }

  public static void main(String[] args) {

  	System.out.println("\nWelcome to Zombie Survivor!");

  	int numPlayers;
  	do {
  		System.out.print("Enter number of survivors: ");
  		numPlayers = IOUtil.readInt();
  	} while (numPlayers < 1);
    
  	ZombieSurvivor game = new ZombieSurvivor(numPlayers);

  	while (!game.isGameOver()) {

  		System.out.println("\nIt's player " + game.getCurrentPlayer() + "'s turn!");


  		Turn currentTurn = game.startPlayerTurn();
  		playTurn(currentTurn);
  		game.scorePlayerTurn(currentTurn);

  		System.out.println("You scored " + currentTurn.getCurrentScore() + "!");
  		System.out.println("Current scores: " + game);
  		game.nextPlayer();
  	}

  	System.out.println("Player " + game.getWinningPlayer() + " won!");

  }

}

















