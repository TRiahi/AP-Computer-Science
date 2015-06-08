
/**
 * The purpose of this program is to illustrate the use of keyboard
 * input methods of the Scanner class.
 * 
 * ©FLVS 2007
 * @author B. Jordan 
 * @version 03/05/07
 */
import java.util.Scanner;
public class KeyboardInput_v5
{
    public static void main(String [ ] args)
    {
        //construct a Scanner object with two lines
        Scanner in;
        in = new Scanner(System.in);
        
        //construct a Scanner object with one line
        //Scanner in = new Scanner(System.in);       
	    
        //use the nextInt() method to enter an integer value
        System.out.print("Please enter an integer value:  ");
        int intValue = in.nextInt();
        System.out.println("You entered: " + intValue);
        System.out.println();
        
        //use the nextDouble method to enter a decimal value
        System.out.print("Please enter a decimal value:  ");
        double decimalValue = in.nextDouble();
        System.out.println("You entered: " + decimalValue);
        System.out.println();
        
        //use the next() method to enter a word
        System.out.print("Please enter a single word:  ");
	    String word = in.next();
	    System.out.println("You entered: " + word);
        System.out.println();
        
        //uee the next() method to enter three words on a single line
        System.out.print("Enter three words separated by spaces: ");
        String word1 = in.next();
        String word2 = in.next();
        String word3 = in.next();
        System.out.println("Printing in reverse order");
        System.out.println(word3 + " " + word2 + " " + word1);
        
	     //use the nextLine method to enter a sentence
	    System.out.println("Please enter a sentence:  ");
	    String firstWord = in.next();
	    String restOfLine = in.nextLine();
	    System.out.println("First word: " + firstWord);
	    System.out.println("Rest of sentence: " + restOfLine);
	    String sentence = firstWord + restOfLine;
	    System.out.println("Whole sentence: " + sentence);
        System.out.println();
    }
}
