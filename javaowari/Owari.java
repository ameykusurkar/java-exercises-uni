
class Owari {

	public static void main(String[] args) {
		
		System.out.println("");
		System.out.println("Welcome to Owari!");
		Game game = new Game();
		boolean playComp = true;


		int gameMode;
		do {
			System.out.println("Press 1 for single player, 2 for multi-player.");
			gameMode = IOUtil.readInt();
		} while (gameMode != 1 && gameMode != 2);

		if (gameMode == 2) playComp = false; 

		while(!game.isOver()) {

			game.display();
			System.out.println("Player " + game.getCurrentPlayer() 
				+ " to play.");
			int bowl;

			if (playComp && game.getCurrentPlayer() == 2) {

				bowl = AI.bestMove(game);

			} else {

				do {
				//Testing AI
				System.out.println("Suggested move: " + AI.bestMove(game));

				System.out.print("Which bowl would you like play?: ");
				bowl = IOUtil.readInt();
				//if (bowl == -1) return;
				} while (!game.isValidMove(bowl));

			}
			
			
			System.out.println("Player " + game.getCurrentPlayer() 
				+ " picked bowl " + bowl + ".");
			game.move(bowl);

		}

		game.swapPlayers();
		System.out.println("\nPlayer " + game.getCurrentPlayer() 
			+ " wins!");

	}
	
}