import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public static void CardSelection(Deck UnoDeck, ArrayList<Cards> PlayerHand, Player players, int pick2) {
	System.out.println("Choose your cards to throw, one at a time. Type '0' when you are finished");
		int x = 1000;
			Scanner a = new Scanner(System.in);
			x = Integer.parseInt(a.nextLine());
			
			if(PlayerHand.get(x-1).getCardValue() == UnoDeck.TopCard().getCardValue() || PlayerHand.get(x-1).getCardColor() == UnoDeck.TopCard().getCardColor() ) {
				if(pick2 > 0) {
					if(PlayerHand.get(x-1).getCardValue() == UnoDeck.TopCard().getCardValue()) {
						pick2 += 2;
						UnoDeck.GamePile.add(PlayerHand.remove(x-1));	
					}else {
						System.out.println("Pick 2 cards were thrown, you failed to match the value of those cards. Draw " + pick2 + " cards");
						while(pick2 != 0) {
							PlayerHand.add(UnoDeck.CardStack.remove(0));
							pick2--;
						}
					}
				}else {
				UnoDeck.GamePile.add(PlayerHand.remove(x-1));	
				}
				if(UnoDeck.TopCard().getCardValue() == -3) {
					players.next.skipped = true;
				}
			}else {
				System.out.println("The card you threw doesn't match the last card, you must pick 2 cards from deck and you lose your turn");
				PlayerHand.add(UnoDeck.TakeCard()); PlayerHand.add(UnoDeck.TakeCard());
				return;		
			}
			
			while(x != 0) {
			 System.out.println("Anymore cards to throw? Make sure they have the same value.");
			 x = Integer.parseInt(a.nextLine());
			 if(x==0) { 
				 return;
			 }
			 if(PlayerHand.get(x-1).getCardValue() == UnoDeck.TopCard().getCardValue() ) {
				 if(PlayerHand.get(x-1).getCardValue() == -2) {
					 pick2 +=2;
				 }
					UnoDeck.GamePile.add(PlayerHand.remove(x-1));
					Player play = players;
					
				while(players.next.skipped != false || players.next != play) {
					players = players.next;
				}
				if(players.next != play) {
					players.skipped = true;
				}
				}else {
					System.out.println("The card you threw doesn't match the last card's value, you must pick 2 cards from deck");
					PlayerHand.add(UnoDeck.TakeCard()); PlayerHand.add(UnoDeck.TakeCard());
					return;		
				} 
			 
			
			 
			}
			
	}
	public static int GamePlay(Player players, Deck UnoDeck, int pick2) {
		
		System.out.println("The Card to match is " + UnoDeck.TopCard().getCardColor() + " " + UnoDeck.TopCard().getCardValue()) ;
		System.out.println();
		System.out.println(players.name + " it's your turn."  + " Here are your cards: ");
		
		int x =1;
		for(Cards card : players.hand) {
			System.out.println( "Card.... " + x);
			System.out.println(card.getCardColor() + " " + card.getCardValue());
			x++;
		}
		
		CardSelection(UnoDeck,players.hand, players, pick2);
		
		if(players.hand.isEmpty()) {
			return 1;
		}else {
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Cards> CardStack = new ArrayList<Cards>();
		ArrayList<Cards> GamePile = new ArrayList<Cards>();
		
		Cards black4 = new Cards(0,4); //blACK pick 4 
		 Cards blackColorChange = new Cards(0,1); //black color change
		 for(int i = 1; i< 5; i++) {
			 for(int a = -3; a < 10; a++) {
				 Cards card = new Cards(i,a);
				 CardStack.add(card);
			 }
			 CardStack.add(black4);
			 CardStack.add(blackColorChange);
		 }
		

		System.out.println("We are playing Uno, how many players are participating?");
		
		Scanner x = new Scanner(System.in);
		int amount = Integer.parseInt(x.nextLine());
		
		System.out.println("So we have " + amount + " players playing");
		

		Deck UnoDeck = new Deck(CardStack,GamePile);
		
		UnoDeck.shuffleDeck();
		
		
		Player[] players = new Player[amount];
		for(int i = 0; i < players.length; i++) {
			
			ArrayList<Cards> hand = new ArrayList<Cards>();
			hand.add(UnoDeck.TakeCard());
			hand.add(UnoDeck.TakeCard());
			hand.add(UnoDeck.TakeCard());
			hand.add(UnoDeck.TakeCard());
			hand.add(UnoDeck.TakeCard());
			
			System.out.println("What's the name of Player " + (i+1));
			Scanner a = new Scanner(System.in);
			players[i] =new Player(a.nextLine(), hand, null, null);	
		}
	
		for(int i = 0; i < players.length -1; i++) {
			players[i].next = players[i+1];
		}
		players[players.length-1].next = players[0];
		for(int i = players.length -1; i > 0; i--) {
			players[i].prev = players[i-1];
		}
		players[0].prev = players[players.length-1];
	
		
		UnoDeck.GamePile.add(UnoDeck.TakeCard());
		
		
	
	
System.out.println("Let The Game Begin, the card to Match is: " + UnoDeck.TopCard().getCardColor() + " "  + UnoDeck.TopCard().getCardValue());
int uno = 0;
int pick2 = 0;
boolean reverse = false;
		Player ptr = players[0];
		while(uno == 0) {
			if(ptr.skipped == true) {
				ptr.skipped = false;
				if(reverse == false) {
					ptr = ptr.next;
					continue;
				}else {
					ptr = ptr.prev;
				}
			}
		System.out.println(GamePlay(ptr,UnoDeck, pick2));
		
		if(ptr.hand.isEmpty()) {
			System.out.println(ptr.name + " has won the game");
			uno =1;
		}
		
		if(reverse == false) {
			ptr = ptr.next;
		}else {
			if(players.length == 2) {
				ptr.next.skipped = true;
				continue;
			}
			ptr = ptr.prev;
		}
		
		}
		
		
	}
}
