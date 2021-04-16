package blackjack;

/**
 * This class represents a playing card object
 */
public final class Card {

	/**
	 * The rank or face of the card
	 */
	private final Rank rank;

	/**
	 * The suit of the card
	 */
	private final Suit suit;

	/**
	 * Initializes this card with specified rank and suit
	 * 
	 * @param rank rank of the card
	 * @param suit suit of the card
	 * @throws NullPointerException if rank or suit are null
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

	/**
	 * Returns value of card in blackjack. Note a 11 is returned for ace and 0 is
	 * returned in error
	 * 
	 * @return the value of this card or a 11 for ace or a 0 in an error
	 */
	public int getValue() {
		int index = this.getRank().ordinal();

		if (index < 9) {
			return index + 2;
		}
		if (index > 8 && index < 12) {
			return 10;
		}
		if (this.getRank() == Rank.ACE) {
			return 11;
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder rank = new StringBuilder(this.rank.toString().toLowerCase());
		StringBuilder suit = new StringBuilder(this.suit.toString().toLowerCase());
		rank.replace(0, 1, String.valueOf(rank.charAt(0)).toUpperCase());
		suit.replace(0, 1, String.valueOf(suit.charAt(0)).toUpperCase());
		return rank + " of " + suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Card)) {
			return false;
		}

		Card other = (Card) obj;
		if (this.getRank() == other.getRank()) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int res = Double.hashCode(this.getValue());
		return res * 31;
	}
}
