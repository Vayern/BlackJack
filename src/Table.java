import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {
	
	private List<Player> poutine = new ArrayList<Player>();
	private static final Scanner SCANNER = I_Promise_Its_Not_Rigged.getScanner();
	
	public void addPeeps(ArrayList<Player> players) {
		for (Player player : players)
			poutine.add(player);
	}
	
	public void addUnoPeep(Player player) {
		poutine.add(player);
	}
	
	public String playGame() {
		dealStartingCards();
		int dealerIndex = 0;
		for (Player player : poutine){
			if (player.isDealer()) {
				dealerIndex = poutine.indexOf(player);
				continue;
			}
			// #OnlyJavaThings5
			player.decide();
		}
		
		poutine.get(dealerIndex).decide();
		for(int i = 1; i <= poutine.size(); i++){
			if(poutine.get(dealerIndex).getHand() > poutine.get(i - 1).getHand()){
				System.out.println("The dealer has lost to player " + i);
			}
		}
		System.out.println("Hey LOSER wanna play again? Y/N");
		String response = SCANNER.next();
		String string = response.trim();
		return string.toLowerCase();
	}
	
	private void dealStartingCards() {
		for (Player player : poutine) {
			player.addToHand(Deck.getNextCard());
			player.addToHand(Deck.getNextCard());
		}
	}
}