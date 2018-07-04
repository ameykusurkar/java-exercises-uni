/**
 * The Card class models a standard playing card. Cards are constant; their
 * values cannot be changed after they are created.
 * 
 * Access methods to the Card's rank value and suit value are provided.
 */
public final class Card {

	private final Rank rank;
	private final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}
		Card card = (Card) obj;
		return rank.equals(card.rank) && suit.equals(card.suit);
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 31 + (rank == null ? 0 : rank.hashCode());
		hash = hash * 31 + (suit == null ? 0 : suit.hashCode());
		return hash;
	}

	// Return a String representation of this card, i.e. a description of the
	// Card's rank and suit.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(rank);
		sb.append(" of ");
		sb.append(suit);
		return sb.toString();
	}

}