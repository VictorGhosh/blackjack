package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import blackjack.Card;
import blackjack.Player;

/**
 * This class represents a players GUI within GUIGame. 
 */
public class PlayerGUI {
	
	private Player player;

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
	public PlayerGUI(int x, int y, String title, Player p) {
		this.player = p;
		
		// Table color scheme
		Color tableColor = new Color(53, 101, 77);
		Color outlineColor = Color.WHITE;

		// Make the players panel
		this.playerPan = new JPanel();
		this.playerPan.setBounds(x, y, 320, 330);
		this.playerPan.setBackground(tableColor);
		this.playerPan.setBorder(makeBorder(outlineColor, 3, 20, title));
		this.playerPan.setLayout(null);

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
		String[][] cards = { { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, { "" } };
		this.cardTable = new JTable(cards, new String[] { "" });
		this.cardTable.setTableHeader(null);
		this.cardTable.setBackground(tableColor);
		this.cardTable.setBounds(0, 0, 50, 50);
		this.cardTable.setGridColor(tableColor);
		this.cardTable.setForeground(outlineColor);
		this.cardTable.setFont(new Font("arial", Font.BOLD, 15));
		
		// Center words in card pile
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.cardTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		
		this.scroller = new JScrollPane(this.cardTable);
		this.scroller.setBounds(10, 30, 300, 250);
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
	 * Update the wallet amount with the amount of cash player has
	 */
	public void update() {
		this.walletLab.setText(" Wallet: " + this.player.getCash() + "$");
		this.betLab.setText(" Bet: " + this.player.getBet() + "$");
				
		for (Card c : this.player.getHand()) {
			this.cardTable.setRowHeight(this.player.getHand().indexOf(c), 30);
			this.cardTable.setValueAt(c.toString(), this.player.getHand().indexOf(c), 0);
		}		
	}
	
	/**
	 * Put entities created in the constructor onto the panel
	 */
	public void buildPanel() {
		this.playerPan.add(this.walletLab);
		this.playerPan.add(this.betLab);
		this.playerPan.add(this.scroller);
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
