import java.util.ArrayList;

public class Player {
 ArrayList<Cards> hand;
	String name;
	boolean skipped;
	Player next;
	Player prev;
	
	
	public Player(String name, ArrayList<Cards> hand, Player next, Player prev) {
		this.name = name;
		this.hand = hand;
		skipped = false;
		this.next = next;
		this.prev = prev;
	}
	

	
	
}
