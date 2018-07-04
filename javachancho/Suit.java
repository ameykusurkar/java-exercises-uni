/**
 * An enumeration of card suit values present in a standard deck of playing
 * cards.
 * 
 * The Suit enum has the following implicitly declared methods:
 *     
 *  -- public boolean equals(Object other): Returns true if the specified object
 *     is equal to this enum constant.
 *     
 *  -- public int ordinal(): Returns the ordinal of this enumeration constant
 *     (its position in its enum declaration, where the initial constant is 
 *     assigned an ordinal of zero).
 *     
 *  -- public String name(): Returns the name of this enum constant, exactly as
 *     declared in its enum declaration.
 *     
 *  -- public static Suit[] values(): Returns an array of Suit values covered by
 *     the enumeration.
 * 
 * See java.lang.Enum<E> for a more comprehensive reference on enumerations.
 */
public enum Suit {
	CLUBS, DIAMONDS, HEARTS, SPADES
}
