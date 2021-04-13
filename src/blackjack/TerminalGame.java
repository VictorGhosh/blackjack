package blackjack;

import java.util.Scanner;

/**
 * This object represents a game of blackjack in the terminal
 */
public class TerminalGame extends Game {

	/**
	 * Scanner object for use in the terminal
	 */
	private Scanner input;

	/**
	 * Initialize a game with the terminal with one player
	 */
	public TerminalGame() {
		this(1);
	}

	/**
	 * Initialize a game in the terminal with a specified number of players
	 * 
	 * @param numPlayers number of players in the game
	 */
	public TerminalGame(int numPlayers) {
		super(numPlayers);
		this.input = new Scanner(System.in);
	}

	/**
	 * Play the game
	 */
	public void play() {
		System.out.println("Dealing...\n");
		deal();
		System.out.println(this);

		for (Player p : this.players) {
			turn(p);
		}

		this.input.close();
	}

	/**
	 * Offer a player p a turn
	 * 
	 * @param p player who's turn it is
	 */
	private void turn(Player p) {
		System.out.println("Player " + (this.players.indexOf(p) + 1));
		System.out.println("Enter s to stand or h to hit");
		
		String s = getInput();
		while (move(p, s) != null && !this.isBust(p)) {
			System.out.println("Your hand is now: \n" + p);
			System.out.println("Enter s to stand or h to hit");
			s = getInput();
		}
		if (this.isBust(p))  {
			System.out.println("Your hand is now: \n" + p);
			System.out.println("You bust.");
		}
	}

	/**
	 * Returns string input from user
	 * 
	 * @return string input from user
	 */
	private String getInput() {
		String res = "";

		if (input.hasNextLine()) {
			res = input.nextLine();
		}
		return res;
	}

}