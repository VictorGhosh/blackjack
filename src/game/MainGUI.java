package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import blackjack.Dealer;
import blackjack.Game;
import blackjack.Player;

public class MainGUI extends Frame implements ActionListener {

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
	 * The stand button
	 */
	private JButton standButton;
	
	/**
	 * The hit button
	 */
	private JButton hitButton;

	/**
	 * The bet input field
	 */
	private JFormattedTextField betInput;
	
	
	private String betText;

	/**
	 * Initialize a game with three players
	 * 
	 * @param numPlayers number of players in the game
	 */
	public MainGUI(List<Player> p, Dealer d) {
		this.p1GUI = new PlayerGUI("Player 1", p.get(0));
		this.p2GUI = new PlayerGUI("Player 2", p.get(1));
		this.p3GUI = new PlayerGUI("Player 3", p.get(2));
		this.dGUI = new PersonGUI(d);
	}
	
	public void bettingView() {
		this.standButton.setVisible(false);
		this.hitButton.setText("Bet");
	}
	
	public String getBetText() {
		String res = this.betText;
		this.betText = null;
		return res;
	}

	/**
	 * Build starting frame
	 */
	public void buildFrame() {
		JFrame f = new JFrame("Blackjack");
		JPanel bet = new JPanel();
		this.standButton = new JButton();
		this.hitButton = new JButton();
		
		try {
			this.betInput = new JFormattedTextField(new MaskFormatter("#"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000 + 15, 750 + 35);
		f.setBackground(tableColor);
		f.getContentPane().setBackground(tableColor);
		f.getContentPane().setLayout(null);
		f.setVisible(true);

		bet.setBounds(340, 690, 320, 50);
		bet.setBackground(tableColor);
		bet.setBorder(makeBorder(outlineColor, 1, 10, "Bet"));

		this.standButton.setText("Stand");
		this.standButton.setBounds(10, 690, 320, 50);

		this.hitButton.setText("Hit");
		this.hitButton.setBounds(670, 690, 320, 50);
		this.hitButton.setMnemonic(KeyEvent.VK_ENTER);
		this.hitButton.addActionListener(this);

		this.betInput.setBounds(0, 0, 320, 20);
		this.betInput.setBorder(null);
		this.betInput.setBackground(tableColor);
		this.betInput.setForeground(outlineColor);
		this.betInput.setFont(new Font("arial", Font.PLAIN, 20));
		this.betInput.setHorizontalAlignment(JTextField.CENTER);
		this.betInput.setColumns(18);
		bet.add(this.betInput);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		this.betText = this.betInput.getText();
	}
}
