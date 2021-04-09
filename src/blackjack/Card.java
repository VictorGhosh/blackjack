package blackjack;

/**
 * This class represents a playing card object
 */
public final class Card {

	/**
	 * The rank or face of the card
	 */
	private Rank rank;

	/**
	 * The suit of the card
	 */
	private Suit suit;

	/**
	 * Initializes this card with specified rank and suit
	 * 
	 * @param rank rank of the card
	 * @param suit suit of the card
	 */
	public Card(Rank rank, Suit suit) {
		if (rank == null || suit == null) {
			throw new NullPointerException();
		}
		this.rank = rank;
		this.suit = suit;
	}

	/**
	 * Returns rank of card object
	 * 
	 * @return rank of card
	 */
	public Rank getRank() {
		return this.rank;
	}

	/**
	 * Returns suit of card object
	 * 
	 * @return suit of card
	 */
	public Suit getSuit() {
		return this.getSuit();
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suit;
	}
}
