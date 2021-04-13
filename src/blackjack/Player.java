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
	 * Current cash player has
	 */
	private int cash;

	/**
	 * Current bet of player
	 */
	private int bet;

	/**
	 * Initialize player with empty hand and 10 dollars
	 */
	public Player() {
		this(10);
	}

	/**
	 * Initialize player with empty hand and a specified number of dollars
	 * 
	 * @param cash amount of cash the player has
	 * @throws IllegalArgumentException if starting cash is less then 1 or more then
	 *                                  Integer.MAX_VALUE
	 */
	public Player(int cash) {
		if (cash < 1 || cash > Integer.MAX_VALUE) {
			throw new IllegalArgumentException("Illegal starting cash ammount");
		}
		this.hand = new ArrayList<>();
		this.cash = cash;
	}

	/**
	 * Returns the amount of cash player has
	 * 
	 * @return amount of cash player has
	 */
	public int getCash() {
		int res = this.cash;
		return res;
	}

	/**
	 * Add cash to this player
	 * 
	 * @param amount amount of cash to add to player
	 */
	public void pay(int amount) {
		this.cash += amount;
	}

	/**
	 * Bet a specific amount
	 * 
	 * @param amount amount to bet
	 * @throws IllegalArgumentException if amount is less then 1 or if final player
	 *                                  cash value will be less then 0
	 */
	public void bet(int amount) {
		if (amount < 1 || (this.cash - amount) < 0) {
			throw new IllegalArgumentException("Illegal betting amount");
		}
		this.bet = amount;
		this.cash -= amount;
	}
	
	/**
	 * Returns the amount player has bet
	 * @return amount player has bet
	 */
	public int getBet() {
		int res = this.bet;
		return res;
	}
	
	/**
	 * resets the bet. May be unnecessary
	 */
	//TODO: Check this out
	public void resetBet() {
		this.bet = 0;
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
