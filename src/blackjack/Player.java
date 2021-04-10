package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * This object represents a player in blackjack
 */
public class Player {

	/**
	 * List of cards in players hand
	 */
	protected List<Card> hand;

	/**
	 * Initialize player with empty hand
	 */
	public Player() {
		this.hand = new ArrayList<>();
	}

	/**
	 * Add card to players hand
	 * 
	 * @param card to add to players hand
	 */
	public void take(Card c) {
		hand.add(c);
	}

	/**
	 * Returns list of all visible cards in the players hand
	 * 
	 * @return list of visible cards in hand
	 */
	public List<Card> getHand() {
		return new ArrayList<>(this.hand);
	}

	/**
	 * Returns the total value of the players hand. Currently values ace at 11
	 * 
	 * @return value of this players hand
	 * @throws IllegalStateException if the players hand is empty
	 */
	public int getValue() {
		if (this.hand.isEmpty()) {
			throw new IllegalStateException("Player hand is empty");
		}

		int res = 0;
		for (Card card : hand) {
			res += card.getValue();
		}
		return res;
	}

	/**
	 * Returns true if player has specified card and false if not
	 * 
	 * @param c card to check if p)layer has
	 * @return true if player has card and false otherwise
	 */
	public boolean hasA(Card c) {
		for (Card card : hand) {
			if (card.equals(c)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove all cards from hand
	 */
	public void clear() {
		this.hand.clear();
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (Card c : this.getHand()) {
			res.append(c + "\n");
		}
		return res.toString();
	}
}
