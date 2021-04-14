package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * This class represents a players GUI within GUIGame. 
 */
public class PlayerGUI {

	/**
	 * The panel this class is making
	 */
	private JPanel playerPan;

	/**
	 * The wallet field displayed in the panel
	 */
	private JLabel walletLab;

	/**
	 * The current bet field displayed in the panel
	 */
	private JLabel betLab;

	/**
	 * The table of cards displayed in the panel
	 */
	private JTable cardTable;

	// TODO: The JScrollPane field should probably be final
	/**
	 * The scroll pane that contains the table
	 */
	private JScrollPane scroller;

	/**
	 * Initialize a player GUI with its top left corner at {@code x, y}
	 * 
	 * @param x x value for top left corner of panel
	 * @param y y value for top left corner of panel
	 */
	public PlayerGUI(int x, int y) {
		// Table color scheme
		Color tableColor = new Color(53, 101, 77);
		Color outlineColor = Color.WHITE;

		// Make the players panel
		this.playerPan = new JPanel();
		this.playerPan.setBounds(x, y, 320, 330);
		this.playerPan.setBackground(tableColor);
		this.playerPan.setBorder(makeBorder(outlineColor, 3, 20, "Player 1"));

		// Make wallet
		this.walletLab = new JLabel(" Wallet: ");
		this.walletLab.setBounds(10, 290, 145, 30);
		this.walletLab.setBorder(BorderFactory.createLineBorder(outlineColor, 1));
		this.walletLab.setForeground(outlineColor);

		// Make bet
		this.betLab = new JLabel(" Bet: ");
		this.betLab.setBounds(165, 290, 145, 30);
		this.betLab.setBorder(BorderFactory.createLineBorder(outlineColor, 1));
		this.betLab.setForeground(outlineColor);
		
		// Make card pile
		String[][] rec = { { "", "" }, { "", "" }, { "", "" }};
		String[] header = { "Rank", "Face" };

		this.cardTable = new JTable(rec, header);
		this.cardTable.setBackground(tableColor);
		this.cardTable.setBounds(0, 0, 50, 50);
		this.cardTable.setGridColor(tableColor);

		
		this.scroller = new JScrollPane(this.cardTable);
		this.scroller.setBounds(10, 30, 300, 250);
		this.scroller.setPreferredSize(new Dimension(300, 250));
		this.scroller.getViewport().setBackground(tableColor);
		this.scroller.setBorder(BorderFactory.createEmptyBorder());
	}

	/**
	 * Returns the panel object that this object is concerned with
	 * 
	 * @return the panel object this class references
	 */
	public JPanel getPanel() {
		return this.playerPan;
	}

	/**
	 * Put entities created in the constructor onto the panel
	 */
	public void buildPanel() {
		this.playerPan.add(this.walletLab);
		this.playerPan.add(this.betLab);
		this.playerPan.add(scroller);
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
