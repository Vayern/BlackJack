import java.util.ArrayList;
import java.util.Scanner;

public class I_Promise_Its_Not_Rigged {
	
	private static Scanner gud = new Scanner(System.in);
	
	public static void main(String[] args) {
		Table table = new Table();
		Player player1 = new Player(false);
		Player player2 = new Player(false);
		Player player3 = new Player(false);
		Player dealer = new Player(true);
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(dealer);
		table.addPeeps(players);
		System.out.println("Welcome to Blackjack with The King Slayer.");
		String response = table.playGame();
		while (response.equals("yes")){
			response = table.playGame();
	}
		System.out.println("Thanks for playing!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			return;
		}
		gud.close();
		
	}
	public static Scanner getScanner() {
		
		return gud;
	}

}