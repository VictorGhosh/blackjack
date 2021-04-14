package blackjack;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GUIGame extends Game {

	private List<JPanel> playerPans;
	private JPanel dealerPan;

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
		this.playerPans = new ArrayList<>();
		dealerPan = new JPanel();
	}

	public void buildFrame() {
		JFrame f = new JFrame("Blackjack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000 + 15, 750 + 35);
		f.setLayout(null);
		f.setVisible(true);
		
		JPanel dealer = new JPanel();
		dealer.setBounds(10, 10, 980, 330);
		dealer.setBackground(Color.YELLOW);
		f.add(dealer);
		
		JPanel player1 = new JPanel();
		player1.setBounds(10, 350, 320, 330);
		player1.setBackground(Color.YELLOW);
		f.add(player1);
		
		JPanel player2 = new JPanel();
		player2.setBounds(340, 350, 320, 330);
		player2.setBackground(Color.YELLOW);
		f.add(player2);
		
		JPanel player3 = new JPanel();
		player3.setBounds(670, 350, 320, 330);
		player3.setBackground(Color.YELLOW);
		f.add(player3);
		
		JButton standButton = new JButton();
//		standButton.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
//		standButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		standButton.setBounds(10, 690, 320, 50);
		standButton.setText("Stand");
		f.add(standButton);
		
		JButton hitButton = new JButton();
//		hitButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
//		hitButton.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.BOLD));
		hitButton.setText("Hit");
		hitButton.setBounds(670, 690, 320, 50);
		f.add(hitButton);
		
		JButton bet = new JButton();
		bet.setBounds(340, 690, 320, 50);
		bet.setBackground(Color.YELLOW);
		f.add(bet);
	}
}
