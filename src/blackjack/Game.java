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
		for (int i = 0; i < numPlayers; i++) {
			this.players.add(new Player());
		}

		this.dealer = new Dealer();

		this.deck = new Deck();
		this.deck.shuffle();
	}

	/**
	 * Returns list of players on board. First player is dealer. Note, the getHand()
	 * function for dealer will not return second card until it has been flipped.
	 * 
	 * @return list of players on board. First player is dealer.
	 */
	public List<Player> getBoard() {
		List<Player> res = new ArrayList<>();
		res.add(dealer);
		res.addAll(this.players);
		return res;
	}

	/**
	 * Executes move for player p. Move is a specified int value, 0 for stand 2 for
	 * hit. Player must be in this game.
	 * 
	 * @param p player to make move
	 * @param move move to make
	 * @return player that made move
	 * @throws IllegalArgumentException if player is not in game
	 * @throws IllegalArgumentException if move is not legal
	 */
	public Player turn(Player p, int move) {
		Player player;
		if (this.players.contains(p)) {
			player = this.players.get(this.players.indexOf(p));
		}
		else if (p == this.dealer) {
			player = this.dealer;
		} else {
			throw new IllegalArgumentException("Player not in game");
		}
		
		switch (move) {
		case 0:
			stand(player);
			break;
		case 1:
			hit(player);
			break;
		default:
			throw new IllegalArgumentException("Illegal move");
		}
		return player;
	}

	/**
	 * Deal each player and the dealer two cards to start the game
	 */
	public void deal() {
		for (int i = 0; i < 2; i++) {
			for (Player p : this.players) {
				this.hit(p);
			}
			this.hit(dealer);
		}
	}

	/**
	 * Player stands. Returns player
	 * 
	 * @param p Player to stand
	 * @return Player that stood
	 */
	public Player stand(Player p) {
		return p;
	}

	/**
	 * Deals card from deck to specified player. Player must be in the game
	 * 
	 * @param p Player to deal the card to
	 * @return The player that was hit
	 * @throws IllegalArgumentException if player is not in this game
	 */
	public Player hit(Player p) {
		p.take(this.deck.draw());
		return p;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("Dealer:\n" + this.dealer);
		for (Player p : this.players) {
			int index = this.players.indexOf(p) + 1;
			res.append("\nPlayer " + index + ":\n" + p);
		}
		return res.toString();
	}

}
