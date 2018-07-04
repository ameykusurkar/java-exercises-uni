
/**
 * This class provides a skeletal implementation of the Player interface. A
 * complete implementation is given for the methods addToHand(Card), pickup()
 * and hasWon(). The discard() method calls an abstract method selectCard()
 * which implements the player's card selection strategy.
 * 
 * The developer need only subclass this abstract class and define the
 * selectCard() method.
 */

public abstract class AbstractPlayer implements Player {

	protected final Card[] cards;

	private final String name;
	private CardPile pickupPile;
	private CardPile discardPile;

	AbstractPlayer(CardPile left, CardPile right, String name) {
		this.discardPile = left;
		this.pickupPile = right;
		this.name = name;
		cards = new Card[HANDSIZE];
	}

	// A card selection strategy that will determine which card will be
	// discarded by this player. The method returns an index into the
	// 'cards' array.
	protected abstract int selectCard();

	public boolean addToHand(Card card) {
		assert card != null : "Cannot add 'null' to the player's hand.";

		for (int i = 0; i < cards.length; i++) {
			if (cards[i] == null) {
				cards[i] = card;
				return true;
			}
		}
		return false;
	}

	public void discard() {
		int selected = selectCard();
		discardPile.put(cards[selected]);
		cards[selected] = null;
	}

	public void pickup() {
		assert !pickupPile.isEmpty() : "No cards to pick up from card pile.";
		addToHand(pickupPile.get());
	}

	public boolean hasWon() {
		assert cards[0]!=null : "Card 0 of player's hand contains a 'null' reference.";

		Rank rank = cards[0].getRank();
		for (int i = 1; i < cards.length; i++) {
			assert cards[i]!=null : "Card " + i + " of player's hand contains a 'null' reference.";
			
			if (!cards[i].getRank().equals(rank)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Player ");
		sb.append(name);
		sb.append(". Cards in hand:\n");
		int i = 0;
		for (Card card : cards) {
			sb.append(i++);
			sb.append(") ");
			sb.append(card);
			sb.append("\n");
		}
		return sb.toString();
	}

}