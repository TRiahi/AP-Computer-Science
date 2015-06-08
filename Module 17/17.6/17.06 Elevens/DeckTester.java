/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {
    /**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
	    String[] suits = {"Hearts","Diamonds","Spades","Clubs"};
	    int[] values= {1,2,3,4,5,6,7,8,9,10,11,12,13};
	    String[] ranks = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	    Deck cards = new Deck(ranks,suits,values);
	    System.out.println("Is the deck full?");
	    System.out.println(cards.isEmpty());
	    System.out.println();
	    System.out.println("How large is the deck?");
	    System.out.println(cards.size());
	    cards.shuffle();
	    cards.deal();
	    System.out.println();
	    System.out.println(cards.toString());
	}
}
