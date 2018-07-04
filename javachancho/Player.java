/**
 * The Player interface models a Chancho game player.
 * 
 * Developers must ensure the player is not in possession of more than HANDSIZE
 * cards on any occasion.
 */
public interface Player {

	// the maximum number of cards a Player may hold.
	public static final int HANDSIZE = 4;

	// select a card to discard from the player's hand and
	// place it on the CardPile to the player's left.
	public void discard();

	// pick up a card from the CardPile on the player's right and
	// add it to the player's hand.
	public void pickup();

	// returns true if this Player has won the game. i.e. if the player holds
	// all the suit values for a particular card rank.
	public boolean hasWon();

	// add the provided card to this player's hand.
	public boolean addToHand(Card card);
}