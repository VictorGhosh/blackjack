package blackjack;

public class GUIGame extends Game {

	/**
	 * Initialize a game with the GUI with one player
	 */
	public GUIGame() {
		this(1);
	}

	/**
	 * Initialize a game in the GUI with a specified number of players
	 * 
	 * @param numPlayers number of players in the game
	 */
	public GUIGame(int numPlayers) {
		super(numPlayers);
	}
	
	
}
