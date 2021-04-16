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

public class GameGUI extends Game {

	/**
	 * The color of background or "table" in game
	 */
	public final static Color tableColor = new Color(53, 101, 77);

	/**
	 * The secondary color of the table
	 */
	public final static Color outlineColor = Color.WHITE;

	/**
	 * The three player GUI panels
	 */
	private PlayerGUI p1GUI;
	private PlayerGUI p2GUI;
	private PlayerGUI p3GUI;

	/**
	 * The dealer GUI panel
	 */
	private PersonGUI dGUI;

	/**
	 * Initialize a game with three players
	 * 
	 * @param numPlayers number of players in the game
	 */
	public GameGUI() {
		super(3);
		
		this.p1GUI = new PlayerGUI("Player 1", this.players.get(0));
		this.p2GUI = new PlayerGUI("Player 2", this.players.get(1));
		this.p3GUI = new PlayerGUI("Player 3", this.players.get(2));
		this.dGUI = new PersonGUI(this.dealer);
	}

	/**
	 * Build starting frame
	 */
	public void buildFrame() {
		JFrame f = new JFrame("Blackjack");
		JPanel bet = new JPanel();
		JButton standButton = new JButton();
		JButton hitButton = new JButton();
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000 + 15, 750 + 35);
		f.setBackground(tableColor);
		f.getContentPane().setBackground(tableColor);
		f.getContentPane().setLayout(null);
		f.setVisible(true);

		bet.setBounds(340, 690, 320, 50);
		bet.setBackground(tableColor);
		bet.setBorder(makeBorder(outlineColor, 1, 10, "Bet"));

		standButton.setText("Stand");
		standButton.setBounds(10, 690, 320, 50);

		hitButton.setText("Hit");
		hitButton.setBounds(670, 690, 320, 50);
		
		p1GUI.buildPanel(10, 350);
		p2GUI.buildPanel(340, 350);
		p3GUI.buildPanel(670, 350);
		dGUI.buildPanel(10, 10);

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
		this.dGUI.update();
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
	public static Border makeBorder(Color c, int thickness, int fontSize, String title) {
		Border b = BorderFactory.createLineBorder(c, thickness);
		TitledBorder res = BorderFactory.createTitledBorder(b, title);
		res.setTitleFont(new Font("Arial", Font.BOLD, fontSize));
		res.setTitleJustification(TitledBorder.CENTER);
		res.setTitleColor(c);
		return res;
	}
}
