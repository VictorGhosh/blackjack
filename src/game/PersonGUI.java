package game;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import blackjack.Card;
import blackjack.Player;

/**
 * This class represents a GUI panel for a player. In this form it is used for
 * the dealer's GUI is extended for players.
 */
public class PersonGUI {

	/**
	 * The player object this GUI is displaying
	 */
	protected Player player;

	/**
	 * The panel this class is making
	 */
	protected JPanel personPan;

	/**
	 * The table of cards displayed in the panel
	 */
	protected JTable cardTable;

	/**
	 * The scroll pane that contains the table
	 */
	protected JScrollPane scroller;

	/**
	 * Displays game info
	 */
	private JLabel infoLab;

	/**
	 * Initialize the GUI panel for player {@code p}
	 * 
	 * @param p the player this GUI will represent
	 */
	public PersonGUI(Player p) {
		String[][] cards = { { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, { "" }, { "" } };

		this.player = p;
		this.personPan = new JPanel();
		this.cardTable = new JTable(cards, new String[] { "" });
		this.scroller = new JScrollPane(this.cardTable);
	}

	/**
	 * Build the initial GUI panel at a given location
	 * 
	 * @param x the x coordinate for the top left corner of the panel
	 * @param y the y coordinate for the top left corner of the panel
	 */
	public void buildPanel(int x, int y) {
		this.personPan.setBounds(x, y, 980, 330);
		this.personPan.setBackground(MainGUI.tableColor);
		this.personPan.setBorder(MainGUI.makeBorder(MainGUI.outlineColor, 3, 20, "Dealer"));
		this.personPan.setLayout(null);

		this.cardTable.setBackground(MainGUI.tableColor);
		this.cardTable.setBounds(0, 0, 50, 50);
		this.cardTable.setGridColor(MainGUI.tableColor);

		this.infoLab = new JLabel();
		this.infoLab.setBounds(95, 150, 145, 30);
		this.infoLab.setForeground(MainGUI.outlineColor);

		this.cardTable.setTableHeader(null);
		this.cardTable.setBackground(MainGUI.tableColor);
		this.cardTable.setBounds(0, 0, 50, 50);
		this.cardTable.setGridColor(MainGUI.tableColor);
		this.cardTable.setForeground(MainGUI.outlineColor);
		this.cardTable.setFont(new Font("arial", Font.BOLD, 15));

		// Center words in card pile
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		this.cardTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

		this.scroller.setBounds(336, 30, 300, 250);
		this.scroller.getViewport().setBackground(MainGUI.tableColor);
		this.scroller.setBorder(BorderFactory.createEmptyBorder());

		this.personPan.add(this.infoLab);
		this.personPan.add(this.scroller);
	}

	/**
	 * Returns the panel object that this object is concerned with
	 * 
	 * @return the panel object this class references
	 */
	public JPanel getPanel() {
		return this.personPan;
	}

	/**
	 * Set the info field to a specified string. Note the panel must be updated
	 * before change will be shown.
	 * 
	 * @param info what to display in info field
	 */
	public void setInfo(String info) {
		this.infoLab.setText(info);
	}

	/**
	 * Update the display fields in the GUI
	 */
	public void update() {
		for (Card c : this.player.getHand()) {
//			this.cardTable.setRowHeight(this.player.getHand().indexOf(c), 30);
			this.cardTable.setValueAt(c.toString(), this.player.getHand().indexOf(c), 0);
		}
	}
}
