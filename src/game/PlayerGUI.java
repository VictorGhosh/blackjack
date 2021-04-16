package game;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

import blackjack.Card;
import blackjack.Player;

/**
 * This class represents a players GUI within GameGUI.
 */
public class PlayerGUI extends PersonGUI {

	/**
	 * The wallet field displayed in the panel
	 */
	private JLabel walletLab;

	/**
	 * The current bet field displayed in the panel
	 */
	private JLabel betLab;

	/**
	 * The name to be displayed for the player in the GUI
	 */
	private String displayName;

	/**
	 * Initialize the GUI panel for player {@code p}. The GUI will be titled with
	 * {@code title}
	 * 
	 * @param title the name to be displayed on the GUI
	 * @param p     the player this GUI will represent
	 */
	public PlayerGUI(String title, Player p) {
		super(p);

		String[][] cards = { { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, { "" } };

		this.displayName = title;
		this.walletLab = new JLabel(" Wallet: ");
		this.betLab = new JLabel(" Bet: ");
	}

	/**
	 * Build the initial GUI panel at a given location
	 * 
	 * @param x the x coordinate for the top left corner of the panel
	 * @param y the y coordinate for the top left corner of the panel
	 */
	@Override
	public void buildPanel(int x, int y) {
		this.personPan.setBounds(x, y, 320, 330);
		this.personPan.setBackground(GameGUI.tableColor);
		this.personPan.setBorder(makeBorder(GameGUI.outlineColor, 3, 20, this.displayName));
		this.personPan.setLayout(null);

		this.walletLab.setBounds(10, 290, 145, 30);
		this.walletLab.setBorder(BorderFactory.createLineBorder(GameGUI.outlineColor, 1));
		this.walletLab.setForeground(GameGUI.outlineColor);

		this.betLab.setBounds(165, 290, 145, 30);
		this.betLab.setBorder(BorderFactory.createLineBorder(GameGUI.outlineColor, 1));
		this.betLab.setForeground(GameGUI.outlineColor);

		this.cardTable.setTableHeader(null);
		this.cardTable.setBackground(GameGUI.tableColor);
		this.cardTable.setBounds(0, 0, 50, 50);
		this.cardTable.setGridColor(GameGUI.tableColor);
		this.cardTable.setForeground(GameGUI.outlineColor);
		this.cardTable.setFont(new Font("arial", Font.BOLD, 15));

		// Center words in card pile
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.cardTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		this.scroller.setBounds(10, 30, 300, 250);
		this.scroller.getViewport().setBackground(GameGUI.tableColor);
		this.scroller.setBorder(BorderFactory.createEmptyBorder());

		this.personPan.add(this.walletLab);
		this.personPan.add(this.betLab);
		this.personPan.add(this.scroller);
	}

	/**
	 * Update the display fields in the GUI
	 */
	@Override
	public void update() {
		this.walletLab.setText(" Wallet: " + this.player.getCash() + "$");
		this.betLab.setText(" Bet: " + this.player.getBet() + "$");

		for (Card c : this.player.getHand()) {
			this.cardTable.setRowHeight(this.player.getHand().indexOf(c), 30);
			this.cardTable.setValueAt(c.toString(), this.player.getHand().indexOf(c), 0);
		}
	}
}
