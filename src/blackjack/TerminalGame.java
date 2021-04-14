package blackjack;

import java.util.Scanner;

/**
 * This object represents a game of blackjack in the terminal
 */
public class TerminalGame extends Game {

	/**
	 * Scanner object for use in the terminal with Strings
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
		boolean play = true;				
		while(play) {
			System.out.println("Taking Bets...\n");

			takeBets();

			System.out.println("\nDealing...\n");
			deal();

			System.out.println(this);

			for (Player p : this.players) {
				turn(p);
			}
			
			System.out.println("------\nDealer is playing...\n");
			playDealer();
			
			System.out.println(this);

			payout();

			System.out.println("Cash: ");
			for (Player p : this.players) {
				System.out.println("Player: " + (this.players.indexOf(p) + 1) + " has " + p.getCash() + "$");
			}
			
			
			System.out.println("Play a hand? (y/n)");
			String res = "";
			System.out.println("res is " + res);
			while (!res.equals("y") && !res.equals("n")) {
				res = getInput();
				if (res.equals("n")) {
					play = false;
				} 
				if (res.equals("y")) {
					play = true;
				}
			}
		}

		this.input.close();
	}

	/**
	 * Take bets from each player
	 */
	public void takeBets() {
		for (Player p : this.players) {
			System.out.println("Player " + (this.players.indexOf(p) + 1) + " has " + p.getCash() + "$");
			System.out.println("Input bet (whole numbers only): ");
			int bet = Integer.parseInt(getInput());
			p.bet(bet);
		}
	}

	/**
	 * Offer a player p a turn
	 * 
	 * @param p player who's turn it is
	 */
	// TODO: move should not return a Player. its more work then its worth
	private void turn(Player p) {
		System.out.println("------");
		System.out.println("Player " + (players.indexOf(p) + 1));
		Player trash = new Player();
		boolean bust = false;

		while (!bust && trash != null) {
			System.out.println("Your hand is now: \n" + p);
			System.out.println("Enter s to stand or h to hit");
			String s = getInput();
			trash = move(p, s);
			bust = isBust(p);
		}
		if (isBust(p)) {
			System.out.println("Your hand is now: \n" + p);
			System.out.println("You bust.\n");
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