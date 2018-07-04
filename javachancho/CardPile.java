import java.util.Stack;

/**
 * The CardPile class models a pile of playing cards. The maximum number of cards
 * allowed in the pile is determined when the class is initialised. Operations
 * are provided that allow a Card to be added and removed from the card pile.
 */
public final class CardPile {

	private Stack<Card> pile; // the cards currently in the pile
	private final int maximumSize; // the maximum number of cards allowed in

	CardPile(int maximumSize) {
		this.maximumSize = maximumSize;
		this.pile = new Stack<Card>();
	}
	
	public boolean isEmpty(){
		return pile.isEmpty();
	}

	// add a card to the top of the pile if there is enough space.
	// returns true if the card was successfully added to the pile, otherwise
	// returns false.
	public boolean put(Card card) {
		if (pile.size() < maximumSize) {
			pile.push(card);
			return true;
		}
		return false;
	}

	// remove and return the card at the top of the pile.
	public Card get() {
		return pile.pop();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CardPile{ maxSize=");
		sb.append(maximumSize);
		sb.append(", cards=");
		sb.append(pile.toString());
		sb.append("}");
		return sb.toString();
	}
}