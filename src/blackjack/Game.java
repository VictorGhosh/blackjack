package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Game {

	/**
	 * List of players in the game. The last player is the dealer
	 */
	private List<Player> players;

	/**
	 * Deck the game is being played with
	 */
	private Deck deck;

	/**
	 * Initialize a game with a 1 player.
	 * 
	 * @param numPlayers
	 */
	public Game() {
		this(1);
	}

	/**
	 * Initialize a game with a specified number of players
	 * 
	 * @param numPlayers
	 */
	public Game(int numPlayers) {
		if (numPlayers < 1) {
			throw new IllegalArgumentException("Illegal number of players");
		}

		// Initialize players and dealer
		this.players = new ArrayList<>();
		for (int i = 0; i < numPlayers + 1; i++) {
			this.players.add(new Player());
		}

		// Initialize deck
		this.deck = new Deck();
		this.deck.shuffle();
	}

	public void deal() {
		for (int i = 0; i < 2; i++) {
			for (Player p : this.players) {
				p.take(deck.draw());
			}
		}
	}
}
