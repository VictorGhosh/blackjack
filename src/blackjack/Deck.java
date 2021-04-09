package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This object represents a standard 52 card deck0
 */
public class Deck {

	/**
	 * List of cards in deck
	 */
	private List<Card> deck;

	/**
	 * Initialize a full deck. Cards are in order
	 */
	public Deck() {
		this.deck = new ArrayList<>();

		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				deck.add(new Card(rank, suit));
			}
		}
	}

	/**
	 * Shuffle this deck
	 */
	public void shuffle() {
		Collections.shuffle(this.deck);
	}

	/**
	 * Pulls the top card from the deck and returns that card
	 * 
	 * @return the card that was pulled
	 */
	public Card draw() {
		Card res = this.deck.get(0);
		this.deck.remove(0);
		return res;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (Card c : this.deck) {
			res.append(c + "\n");
		}
		return res.toString();
	}
}
