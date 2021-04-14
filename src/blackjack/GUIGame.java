package blackjack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GUIGame extends Game {
	
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
	}

	/**
	 * Build starting frame
	 */
	public void buildFrame() {
		Color tableColor = new Color(53, 101, 77);
		Color outlineColor = Color.WHITE;
		
		JFrame f = new JFrame("Blackjack");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1000 + 15 + 10, 750 + 35 + 10);
		f.setBackground(tableColor);
		f.getContentPane().setBackground(tableColor);
		f.getContentPane().setLayout(null);
		f.setVisible(true);
		
		JPanel dealerPan = new JPanel();
		dealerPan.setBounds(10, 10, 980, 330);
		dealerPan.setBackground(tableColor);
		dealerPan.setBorder(makeBorder(outlineColor, 3, 20, "Dealer"));
				
		
		
		
		
		
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
		
//		cards1.setBounds(10, 30, 300, 250);
		
		
		
		String[][] rec = {
				   { "1", "Steve"},
				   { "2", "Virat"},
				   { "3", "Kane"},
				};
		String[] header = { "Rank", "Player"};
		
		JTable table = new JTable(rec, header);
		table.setBounds(0, 0, 50, 50);
		JScrollPane scroller = new JScrollPane(table);
		scroller.setBounds(10, 30, 300, 250);
        scroller.setPreferredSize(new Dimension(300, 250));
        scroller.setBackground(tableColor);
        
        player1Pan.add(scroller);
		
		
		
		

        
		JPanel player2Pan = new JPanel();
		player2Pan.setBounds(340, 350, 320, 330);
		player2Pan.setBackground(tableColor);
		player2Pan.setBorder(makeBorder(outlineColor, 3, 20, "Player 2"));
		
		JPanel player3Pan = new JPanel();
		player3Pan.setBounds(670, 350, 320, 330);
		player3Pan.setBackground(tableColor);
		player3Pan.setBorder(makeBorder(outlineColor, 3, 20, "Player 3"));
		
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
		
		f.add(dealerPan);
		f.add(player1Pan);
		f.add(player2Pan);
		f.add(player3Pan);
		f.add(standButton);
		f.add(hitButton);
		f.add(bet);
		
//		f.revalidate();
		f.repaint();
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
