public class DoNotMeltTheSnowman {

  public static void main(String[] args) {
    System.out.println("Do not melt the Snowman!");
    int levelNum;
    do {
    	System.out.println("Which level would you like to play? (0 to 10)");
    	levelNum = IOUtil.readInt();
    } while(levelNum < 0 || levelNum > 10);

    Level level = Levels.getLevels()[levelNum];

    Board board = new Board(PieceUtils.charsToPieces(level.getCharArray(), 
    		level.getWidth(), level.getHeight()));

    System.out.println("Level " + levelNum);
    System.out.println();
    Result result = board.fireLaser();
    board.renderBoard();

    while(result == Result.MISS) {

    	int row;
    	int column;

    	do {
    		System.out.println("Please enter the row then the column " + 
    			"of the piece you'd like to rotate.");
    		row = IOUtil.readInt();
    		column = IOUtil.readInt();
    	} while (!rowInRange(level, row) || !colInRange(level, column));

    	board.rotatePiece(new Coordinate(column, row));
    	board.clearLasers();
    	result = board.fireLaser();
    	board.renderBoard();
    	
    }

    if (result == Result.HIT_TARGET) {
    	System.out.println("You hit the target, you win!");
    } else if (result == Result.MELT_SNOWMAN) {
    	System.out.println("You hit the snowman, you lose!");
    }

  }

private static boolean rowInRange(Level level, int r) {
	return 0 <= r && r < level.getHeight();
}

private static boolean colInRange(Level level, int c) {
	return 0 <= c && c < level.getWidth();
}

}
