import java.util.*;
/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler 
{
    /**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 16;
	/**
	 * The number of values to shuffle.
	 */
	private static final int VALUE_COUNT = 4;
	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) 
	{
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = new int[VALUE_COUNT];
		for (int i = 0; i < values1.length; i++) {
			values1[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = new int[VALUE_COUNT];
		for (int i = 0; i < values2.length; i++) {
			values2[i] = i;
			}
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(flip());
		System.out.println();
		int[] a = {1,2,3,4};
		int[] b = {4,5,2,1};
		arePermutations(a,b);
	}
	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) 
	{
	    int k = 0;
	    int[] shuffled = new int[values.length];
	    for(int i=0; i < (values.length)/2; i++)
	    {
	        shuffled[k] = values[i];
	        k +=2;
	    }
	    k = 1;
	    for(int i= (values.length)/2; i < values.length; i++)
	    {
	        shuffled[k] = values[i];
	        k +=2;
	    }
	    for(int i = 0; i < shuffled.length; i++)
	    {
	        values[i] = shuffled[i];
	    }
	}
	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) 
	{
	    Random rnd = new Random();
	    int[] shuffled = new int[values.length];
	    for (int i = values.length - 1; i > 0; i--)
	    {
	        int index = rnd.nextInt(i + 1);
	        // Simple swap
	        int a = values[index];
	        values[index] = values[i];
	        values[i] = a;
	    }
	}
	public static String flip()
	{
	    Random rnd = new Random();
	    String side;
	    int n = rnd.nextInt(3);
	    if(n==0 | n==1)
	    {
	        side = "heads";
	    }
	    else
	    {
	        side = "tails";
	    }
	    return side;
	}
	public static void arePermutations(int[]a, int[] b)
	{
	    boolean[] perm = new boolean[a.length];
	    if(a.length == b.length)
	    {
	        for(int i = 0; i < a.length; i++)
	        {
	            perm[i] = false;
	            for(int j = 0; j < b.length; j++)
	            {
	                if(a[i] == b[j])
	                {
	                    perm[i] = true;
	                }
	            }
	        }
	        boolean isPerm = true;
	        for(int i=0; i < perm.length;i++)
	        {
	            if(perm[i] != true)
	            {
	                isPerm = false;
	                break;
	            }
	        }
	        if(isPerm == true)
	        {
	            System.out.println("They are permutations.");
	        }
	        else
	        {
	            System.out.println("There are not permutations.");
	        }
	    }
	}
}
