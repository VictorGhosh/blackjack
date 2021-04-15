package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import blackjack.Game;

public class GUIGame extends Game {
	
	private PlayerGUI p1GUI;
	private PlayerGUI p2GUI;
	private PlayerGUI p3GUI;
	
	/**
	 * Initialize a game in the GUI with a specified number of players
	 * 
	 * @param numPlayers number of players in the game
	 */
	public GUIGame() {
		super(3);
	}

	/**
	 * Build starting frame
	 */
	public void buildFrame() {
		Color tableColor = new Color(53, 101, 77);
		Color outlineColor = Color.WHITE;
		
		JFrame f = new JFrame("Blackjack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000 + 15, 750 + 35);
		f.setBackground(tableColor);
		f.getContentPane().setBackground(tableColor);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		this.p1GUI = new PlayerGUI(10, 350, "Player 1", this.players.get(0));
		this.p2GUI = new PlayerGUI(340, 350, "Player 2", this.players.get(1));
		this.p3GUI = new PlayerGUI(670, 350, "Player 3", this.players.get(2));
		
		// TODO: DealerGUI should probably extend some sort of player GUI or something
		// ACTUALY I THINK IT SHOULD BE AN INTERFACE
		DealerGUI dGUI = new DealerGUI(10, 10);

		p1GUI.buildPanel();
		p2GUI.buildPanel();
		p3GUI.buildPanel();
		dGUI.buildPanel();

		JPanel bet = new JPanel();
		bet.setBounds(340, 690, 320, 50);
		bet.setBackground(tableColor);
		bet.setBorder(makeBorder(outlineColor, 1, 10, "Bet"));
		
		JButton standButton = new JButton();
		standButton.setText("Stand");
		standButton.setBounds(10, 690, 320, 50);
		
		JButton hitButton = new JButton();
		hitButton.setText("Hit");
		hitButton.setBounds(670, 690, 320, 50);
		
		f.add(p1GUI.getPanel());
		f.add(p2GUI.getPanel());
		f.add(p3GUI.getPanel());
		f.add(dGUI.getPanel());
		
		f.add(standButton);
		f.add(hitButton);
		f.add(bet);
		
		f.repaint();
	}
	
	/**
	 * Update the GUI values and cards
	 */
	public void update() {
		this.p1GUI.update();
		this.p2GUI.update();
		this.p3GUI.update();
	}
	
	/**
	 * Makes a Border object with the given specifications
	 * 
	 * @param c         Color of border and title
	 * @param thickness Thickness of border
	 * @param fontSize  Size of title font
	 * @param title     Title for border to display
	 * @return The new border
	 */
	private Border makeBorder(Color c, int thickness, int fontSize, String title) {
		Border b = BorderFactory.createLineBorder(c, thickness);
		TitledBorder res = BorderFactory.createTitledBorder(b, title);
		res.setTitleFont(new Font("Arial", Font.BOLD, fontSize));
		res.setTitleJustification(TitledBorder.CENTER);
		res.setTitleColor(c);
		return res;
	}
}
