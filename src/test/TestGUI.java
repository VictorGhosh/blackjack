package test;

import game.GUIGame;

public class TestGUI {

	public static void main(String[] args) throws InterruptedException {
		GUIGame g = new GUIGame();
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
