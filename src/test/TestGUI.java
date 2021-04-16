package test;

import game.GameGUI;

public class TestGUI {

	public static void main(String[] args) {
		GameGUI g = new GameGUI();
		g.buildFrame();
		g.update();

		g.deal();
		
		g.update();
	}
}
