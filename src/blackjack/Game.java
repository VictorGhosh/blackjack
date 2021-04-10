package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {

	/**
	 * List of players in the game
	 */
	private List<Player> players;
	
	/**
	 * Game dealer
	 */
	private Dealer dealer;

	/**
	 * Deck the game is being played with
	 */
	private Deck deck;

	/**
	 * Initialize a game with one player
	 */
	public Game() {
		this(1);
	}

	/**
	 * Initialize a game with a specified number of players. All players have an
	 * empty hand and the deck is shuffled
	 * 
	 * @param numPlayers how many players in game in addition to dealer
	 * @throws IllegalArgumentException if numPlayers is less then 1
	 */
	public Game(int numPlayers) {
		if (numPlayers < 1) {
			throw new IllegalArgumentException("Illegal number of players");
		}

		this.players = new ArrayList<>();
		for (int i = 0; i < numPlayers + 1; i++) {
			this.players.add(new Player());
		}

		this.deck = new Deck();
		this.deck.shuffle();
	}

	/**
	 * Deals card from deck to specified player. Player must be in the game
	 * 
	 * @param p Player to deal the card to
	 * @throws IllegalArgumentException if player is not in this game
	 */
	public void hit(Player p) {
		if (!this.players.contains(p)) {
			throw new IllegalArgumentException("Player not in game");
		}
		p.take(this.deck.draw());
	}

	/**
	 * Deal each player and the dealer two cards to start the game
	 */
	public void start() {
		for (int i = 0; i < 2; i++) {
			for (Player p : this.players) {
				this.hit(p);
			}
		}
	}
	

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		for (Player p : this.players) {
			int index = this.players.indexOf(p);
			if (index == 0) {
				res.append("Dealer:\n");
			} else {
				res.append("\nPlayer " + index + "\n");
			}
			res.append(p);
		}
		return res.toString();
	}

}
