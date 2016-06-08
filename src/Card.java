
public class Card {
	
	private String faceValue;
	private String suit;
	private int numberValue;
	
	public Card(String faceValue, String suit) {
		this.faceValue = faceValue;
		this.suit = suit;
		this.numberValue = getValue();
	}
	
	public int getValue() {
		if (numberValue == 0) {
			for (int i = 2; i <= 10; i++) {
				if (faceValue.equals("" + i)) {
					numberValue = i;
					return i;
				}
			}
			if (faceValue.equals("J") || faceValue.equals("Q") || faceValue.equals("K"))
				numberValue = 10;
			else
				numberValue = 11;
		}
		return numberValue;
	}
	public String getFaceValue(){
		return faceValue;
	}
	
	public String getSuit() {
		return suit;
	}

}