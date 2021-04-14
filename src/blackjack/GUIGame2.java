package blackjack;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIGame2 extends Game {

	private List<JPanel> playerPans;
	private JPanel dealerPan;

	/**
	 * Initialize a game with the GUI with one player
	 */
	public GUIGame2() {
		this(1);
	}

	/**
	 * Initialize a game in the GUI with a specified number of players
	 * 
	 * @param numPlayers number of players in the game
	 */
	public GUIGame2(int numPlayers) {
		super(numPlayers);
		this.playerPans = new ArrayList<>();
		dealerPan = new JPanel();
	}

	public void buildFrame() {
		int numPlayers = this.players.size();
		int border = 20;
		int fX = 1000;
		int fY = 1000;
		int dX = fX - (int) (2.5 * border);
		int dY = (fY - (4 * border)) / 2;
		int pX = (dX / numPlayers) - ((numPlayers - 1) * (border));
		int index = 0;

		// Making Frame
		JFrame f = new JFrame("BlackJack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(fX, fY);
		f.setLayout(null);
		f.setVisible(true);

		// Adding panels
		this.dealerPan.setBackground(Color.GREEN);
		this.dealerPan.setBounds(border, border, dX, dY);
		f.add(this.dealerPan);
		for (int i = 0; i < numPlayers; i++) {
			JPanel p = new JPanel();
			p.setBackground(Color.gray);
			p.setBounds(border + index, dY + (2 * border), pX, dY);
			index += (i + 1) * (pX + border);
			
			playerPans.add(p);
			f.add(p);
		}
	}
}
