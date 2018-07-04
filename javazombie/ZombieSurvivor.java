import java.util.Arrays;

public class ZombieSurvivor {

  private static final int ENDGAME_SCORE = 13;
  
  private final int[] playerScores;
  
  private int currentPlayer;
 
  public ZombieSurvivor(int numPlayers) {
    this.playerScores = new int[numPlayers];
    this.currentPlayer = 0;
  }
  
  public boolean isGameOver() {
    int index = Util.findIndexGreaterThanOrEqualTo(playerScores, ENDGAME_SCORE);
    return index >= 0;
  }
  
  public int getCurrentPlayer() {
    return currentPlayer;
  }

  public Turn startPlayerTurn() {
    return new Turn(currentPlayer);
  }
  
  public void scorePlayerTurn(Turn turn) {
    assert turn.getCurrentPlayer() == currentPlayer :
      "Turn is for the wrong player";
    playerScores[currentPlayer] += turn.getCurrentScore();
  }
  
  public void nextPlayer() {
    currentPlayer++;
    currentPlayer %= playerScores.length;
  }

  public int getWinningPlayer() {
    int index = Util.findIndexGreaterThanOrEqualTo(playerScores, ENDGAME_SCORE);
    return index;
  }
  
  public String toString() {
    return Arrays.toString(playerScores);
  }
  
 
}
