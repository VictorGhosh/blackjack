package test;

import game.GameGUI;

public class TestGUI {

	public static void main(String[] args) throws InterruptedException {
		GameGUI g = new GameGUI();
		g.buildFrame();
		g.update();
//
//		Thread.sleep(3000);
//		System.out.println("Dealing...");
//		Thread.sleep(3000);
		g.deal();
		
		g.update();
	}
}
