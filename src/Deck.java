import java.util.Random;

public class Deck {
	
	private static final String[] SUITS = {"Diamonds", "Hearts", "Spades", "Clubs"};
	private static final String[] FACE_VALUES = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	private static final Card[] DECK = makeDeck();
	
	public Deck() {}

	public static Card[] makeDeck() {
		Card[] singleDeck = new Card[52];
		for (int faces = 0; faces < FACE_VALUES.length; faces++) {
			for (int suits = 0; suits < SUITS.length; suits++) {
				singleDeck[suits * 13 + faces] = new Card(FACE_VALUES[faces], SUITS[suits]);
			}
		}
		return singleDeck;
	}
	
	public static Card getNextCard() {
		Random random = new Random();
		int randomInt = random.nextInt(DECK.length);
		return DECK[randomInt];
	}
}