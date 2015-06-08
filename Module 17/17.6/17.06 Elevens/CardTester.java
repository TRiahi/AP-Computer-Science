/**
 * This is a class that tests the Card class.
 */
public class CardTester {
	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) 
	{
	    Card queen = new Card("Queen","Spades",12);
	    Card ace = new Card("Ace","Diamonds",1);
	    Card ten = new Card("10","Clubs",10);
	    System.out.println("Are Aces and Queens the same?");
	    System.out.println(ace.matches(queen));
	    System.out.println();
	    System.out.println(ace.toString());
	    System.out.println(ten.toString());
	    System.out.println(queen.toString());
	    System.out.println();
	    System.out.println("Are Tens the same?");
	    System.out.println(ten.matches(ten));
	}
}
