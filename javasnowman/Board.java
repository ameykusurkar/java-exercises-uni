public class Board {

  private Piece[][] board;
  private Coordinate emitter;

  public Board(Piece[][] board) {
    this.board    = board;
    this.emitter  = PieceUtils.findEmitter(board);
  }

  public boolean laserEnds(Coordinate c) {
    if (c.getX() < 0 || c.getY() < 0) return true;
    if (c.getY() > board[0].length-1 || c.getX() > board.length-1) {
      return true;
    }
    Piece p = board[c.getX()][c.getY()];
    return (p == Piece.WALL || p == Piece.TARGET || p == Piece.SNOWMAN ||
      p == Piece.EMITTER_NORTH || p == Piece.EMITTER_EAST 
      || p == Piece.EMITTER_SOUTH || p == Piece.EMITTER_WEST);
  }

  public Result calculateResult(Coordinate c) {
    boolean inBound1 = c.getX() >= 0 && c.getY() >= 0;
    boolean inBound2 = c.getY() < board[0].length && c.getX() < board.length;
    if (inBound1 && inBound2) {
      Piece p = board[c.getX()][c.getY()];
      if (p == Piece.TARGET) return Result.HIT_TARGET;
      if (p == Piece.SNOWMAN) return Result.MELT_SNOWMAN;
      return Result.MISS;
    }
    return Result.MISS;
  }


  public Result fireLaser() {
    // Coordinate current = emitter;
    Coordinate current = new Coordinate(emitter.getX(), emitter.getY());
    int xVel = 0;
    int yVel = 0;

    do {

      board[current.getX()][current.getY()] 
        = PieceUtils.addLaser(board[current.getX()][current.getY()], 
          yVel == 0);

      Coordinate next = PieceUtils.move(board[current.getX()][current.getY()],
                            current, xVel, yVel);

      xVel = next.getX() - current.getX();
      yVel = next.getY() - current.getY();
      current = next;

    } while (!laserEnds(current));

    return calculateResult(current);
  }

  public void rotatePiece(Coordinate c) {
    assert c.getX() >= 0 && c.getX() < board.length
        && c.getY() >= 0 && c.getY() < board[0].length;

    board[c.getX()][c.getY()]
      = PieceUtils.rotate(board[c.getX()][c.getY()]);
  }

  public void clearLasers() {
    for (int i = 0; i < board.length ; i++) {
      for (int j = 0; j < board[i].length ; j++) {
        board[i][j] = PieceUtils.hideLaser(board[i][j]);
      }
    }
  }


  private static final char ESC = 27;

  public void renderBoard() {

    System.out.print(ESC + "[30;47m  ");
    for (int i = 0 ; i < board.length ; i++) {
      System.out.print(i);
    }
    System.out.println(" ");

    System.out.print(" ┏");
    for (int i = 0 ; i < board.length ; i++) {
      System.out.print("━");
    }
    System.out.println("┓");

    for (int j = board[0].length - 1 ; j >= 0 ; j--) {
      System.out.print(ESC + "[30m" + j +"┃");
      for (int i = 0 ; i < board.length ; i++ ) {
        System.out.print(renderPiece(board[i][j]));
      }
      System.out.println(ESC + "[30m┃");
    }
    System.out.print(ESC + "[30m ┗");
    for (int i = 0 ; i < board.length ; i++) {
      System.out.print("━");
    }
    System.out.println("┛");

  }

  private static String renderPiece(Piece p) {
    switch (p) {
      case EMITTER_NORTH:
        return ESC + "[32m↑";
      case EMITTER_EAST:
        return ESC + "[32m→";
      case EMITTER_SOUTH:
        return ESC + "[32m↓";
      case EMITTER_WEST:
        return ESC + "[32m←";

      case LASER_VERTICAL:
        return ESC + "[31m│";
      case LASER_HORIZONTAL:
        return ESC + "[31m─";
      case LASER_CROSSED:
        return ESC + "[31m┼";

      case MIRROR_SW_NE:
        return ESC + "[34m╱";
      case MIRROR_NW_SE:
        return ESC + "[34m╲";

      case WALL:
        return ESC + "[36m█";

      case TARGET:
        return ESC + "[35m☼";

      case EMPTY:
        return " ";

      case SNOWMAN:
        return ESC + "[30m☃";
    }
    return "!";
  }

}
