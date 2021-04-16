package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * This object represents the dealer
 */
public class Dealer extends Player {

	/**
	 * Whether or not the second card should be shown
	 */
	private boolean showCard2;

	/**
	 * Initialize dealer with empty hand
	 */
	public Dealer() {
		super();
		this.showCard2 = false;
	}

	/**
	 * Display the second card
	 */
	public void flipCard() {
		this.showCard2 = true;
	}

	/**
	 * Returns list of all cards in dealers hand minus the second dealt card if it
	 * has not been flipped yet
	 * 
	 * @return list of visible cards in hand
	 */
	//THIS IS NOT IN ORDER BECAUSE IT IS IMPLEMENT IN GameGUI.java. NEEDS TO BE FIXED
//	@Override
//	public List<Card> getHand() {
//		List<Card> res = new ArrayList<>(this.hand);
//		if (!showCard2) {
//			res.remove(1);
//		}
//		return res;
//	}

}
