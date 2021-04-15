package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class DealerGUI {
	
	/**
	 * The panel this class is making
	 */
	private JPanel dealerPan;
	
	/**
	 * The table of cards displayed in the panel
	 */
	private JTable cardTable;
	
	// TODO: The JScrollPane field should probably be final
	/**
	 * The scroll pane that contains the table
	 */
	private JScrollPane scroller;
	
	public DealerGUI(int x, int y) {
		// Table color scheme
		Color tableColor = new Color(53, 101, 77);
		Color outlineColor = Color.WHITE;
		 
		// Make dealers panel
		this.dealerPan = new JPanel();
		this.dealerPan.setBounds(10, 10, 980, 330);
		this.dealerPan.setBackground(tableColor);
		this.dealerPan.setBorder(makeBorder(outlineColor, 3, 20, "Dealer"));
		this.dealerPan.setLayout(null);
		
		// Make card pile
		// Make card pile
		String[][] rec = { { "", "" }, { "", "" }, { "", "" }};
		String[] header = { "Rank", "Face" };

		this.cardTable = new JTable(rec, header);
		this.cardTable.setBackground(tableColor);
		this.cardTable.setBounds(0, 0, 50, 50);
		this.cardTable.setGridColor(tableColor);

				
		this.scroller = new JScrollPane(this.cardTable);
		this.scroller.setBounds(336, 30, 300, 250);
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
		return this.dealerPan;
	}

	/**
	 * Put entities created in the constructor onto the panel
	 */
	public void buildPanel() {
		this.dealerPan.add(this.scroller);
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
