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

public class PlayerPanel {

	public PlayerPanel(JFrame f) {
		// Table color scheme
		Color tableColor = new Color(53, 101, 77);
		Color outlineColor = Color.WHITE;
		
		// Make the players panel
		JPanel player1Pan = new JPanel();
		player1Pan.setBounds(10, 350, 320, 330);
		player1Pan.setBackground(tableColor);
		player1Pan.setBorder(makeBorder(outlineColor, 3, 20, "Player 1"));
		
		JLabel wallet1 = new JLabel(" Wallet ");
		wallet1.setBounds(10, 290, 145, 30);
		wallet1.setBackground(Color.BLACK);
		wallet1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		player1Pan.add(wallet1);
		
		JLabel bet1 = new JLabel(" Bet: ");
		bet1.setBounds(165, 290, 145, 30);
		bet1.setBackground(Color.BLACK);
		bet1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		player1Pan.add(bet1);
	
		
		
		
//		String[][] rec = {
//				   { "1", "Steve"},
//				   { "2", "Virat"},
//				   { "3", "Kane"},
//				};
//		String[] header = { "Rank", "Player"};
//		
//		JTable table = new JTable(rec, header);
//		table.setBounds(0, 0, 50, 50);
//		JScrollPane scroller = new JScrollPane(table);
//		scroller.setBounds(10, 30, 300, 250);
//        scroller.setPreferredSize(new Dimension(300, 250));
//        scroller.setBackground(tableColor);
//        
//        player1Pan.add(scroller);
	}
	
	private Border makeBorder(Color c, int thickness, int fontSize, String title) {
		Border b = BorderFactory.createLineBorder(c, thickness);
		TitledBorder res = BorderFactory.createTitledBorder(b, title);
		res.setTitleFont(new Font("Arial", Font.BOLD, fontSize));
		res.setTitleJustification(TitledBorder.CENTER);
		res.setTitleColor(c);
		return res;
	}
	
}
