/**
 * Interface for a deck of playing cards. Single cards may only be added to the
 * bottom of the deck and removed from the top. Two card shuffling operations
 * are defined on any deck: the cut and the riffle-shuffle. Some standard
 * operations to query the size of the Deck are also made available.
 */
public interface Deck {

	// add the provided card to the bottom of this deck.
	public void addToBottom(Card card);

	// return the top half of this deck, leaving the bottom half as
	// this deck.
	public Deck cut();

	// returns true if this deck contains no cards.
	public boolean isEmpty();

	// remove and return the card from the top of this deck.
	public Card removeFromTop();

	// return a new deck representing the interleaving of this deck
	// with the parameter deck. The top card of the new deck should
	// be the top card of this deck.
	public Deck riffleShuffle(Deck deck);

	// return the number of cards in this deck.
	public int size();

}