import java.util.ArrayList;

public class Deck {
	ArrayList<Cards> CardStack = new ArrayList<Cards>();
	ArrayList<Cards> GamePile = new ArrayList<Cards>();
	
	
	public Deck(ArrayList<Cards> CardStack , ArrayList<Cards> GamePile ){
	
		this.CardStack = CardStack;
		this.GamePile = GamePile;
			 
	}
	public void shuffleDeck() {
		ArrayList<Cards> swit = new ArrayList<Cards>();
		
		while(!CardStack.isEmpty()) {
			swit.add(CardStack.get((CardStack.size()/2)));
			CardStack.remove(CardStack.size()/2);
		}
		CardStack = swit;
	}
	public Cards TakeCard() {
		return CardStack.remove(0);
	}
	
	public void refill() {
		while(GamePile.size() != 1) {
			CardStack.add(GamePile.remove(0));
		}
	}
	
	public Cards TopCard() {
		return GamePile.get(GamePile.size()-1);
		
	}
	
	
	
	

	
	
	

}
