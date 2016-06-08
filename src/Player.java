import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private boolean isDealer;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private static final Scanner SCANNER = I_Promise_Its_Not_Rigged
			.getScanner();

	public Player(boolean isDealer) {
		this.isDealer = isDealer;
	}

	public boolean isDealer() {
		return isDealer;
	}

	public void addToHand(Card card) {
		cards.add(card);

	}

	public int getHand() {
		int cardSum = 0;
		boolean containsAnAce = false;
		for (Card card : cards) {
			cardSum += card.getValue();
			if (card.getValue() == 11)
				containsAnAce = true;
		}
		if (cardSum > 21 && containsAnAce) {
			cardSum = 0;
			for (Card card : cards) {
				if (card.getValue() == 11)
					cardSum += 1;
				else
					cardSum += card.getValue();
			}
		}
		return cardSum;
	}

	public void score() {
		System.out.print("Your total is " + getHand());
	}

	public void decide() {
		if (!isDealer) {
			while (true) {
				StringBuilder builder = new StringBuilder();
				builder.append("You have the ");
				for (Card card : cards) {
					builder.append(card.getFaceValue() + " of "
							+ card.getSuit() + ", ");
				}
				System.out.println(builder.toString().substring(0,
						builder.length() - 2));
				System.out.println("Hit or Stay");
				String response = SCANNER.next();
				String string = response.trim();
				if (string.equalsIgnoreCase("hit")) {
					Card card = Deck.getNextCard();
					cards.add(card);
					System.out.println("Your new card is the "
							+ card.getFaceValue() + " of " + card.getSuit()
							+ ".");

					if (has21() || over21()) {
						System.out
								.println("I'm pleased to tell you that you cannot hit anymore.");
						break;
					}
				} else {
					System.out.println("Good, you didn't deserve it anyways.");
					break;
				}
			}

		} else {
			System.out.println("The dealer has " + cards.get(0).getFaceValue() + " and " + cards.get(1).getFaceValue());
			while (getHand() < 17) {
				Card card = Deck.getNextCard();
				cards.add(card);
				System.out.println("The dealer's new card is the "
						+ card.getFaceValue() + " of " + card.getSuit()
						+ ".");
				}
			}
		System.out.println("The dealer's total is " + getHand() + ".");
		}
	

	private boolean has21() {
		if (getHand() == 21) {
			System.out.println("You have 21, bravo!");
			return true;
		}
		return false;
	}

	private boolean over21() {
		if (getHand() > 21) {
			System.out.println("You have gone bust, sucks.");
			return true;
		}
		return false;
	}

}