package game;

import blackjack.Game;
import blackjack.Player;

public class GUIGame extends Game {
	
	private MainGUI display;
	
	public GUIGame() {
		super(3);
		this.display = new MainGUI(this.players, this.dealer);
	}
	
	public void play() throws InterruptedException {
		this.display.buildFrame();
		this.display.update();
		takeBet(this.players.get(0));
		this.display.update();
	}
	
	public void takeBet(Player p) throws InterruptedException {
		this.display.bettingView();
		
		String bet = null;
		while (bet == null) {
			bet = this.display.getBetText();
			Thread.sleep(500);
		}	
		p.bet(Integer.parseInt(bet));
	}
