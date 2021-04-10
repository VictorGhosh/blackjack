package blackjack;

public class Blackjack {

	public static void main(String[] args) {
		Game g = new Game(3);
		g.start();
		System.out.println(g);
	}

}
