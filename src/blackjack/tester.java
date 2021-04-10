package blackjack;

public class tester {

	public static void main(String[] args) {
		Player p = new Player();
		Dealer d = new Dealer();
		Deck deck = new Deck();

		p.take(deck.draw());
		p.take(deck.draw());
		
		d.take(deck.draw());
		d.take(deck.draw());
		
		System.out.println(p);
		System.out.println(d);
	}

}
