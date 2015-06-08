
/**
 * The purpose of this program is to demonstrate the use of escape sequences when printing literal constants.
 * 
 * Read the instructions in the comments in each block of code below so that you can experiment on your own.
 * 
 * ©FLVS 2007
 * @author Bill Jordan 
 * @version 01/22/07
 */
public class EscapeCharacters
{
	public static void main(String[] args)
	{
	    //use of the newline escape secquence
	    //what happens if you delete the n after the backslashes?
	    //what happens if you change println to print
	    System.out.println("This\ndemonstrates\nthe\nnewline\nescape\nsequence\n");
	    
	    //use of the tab escape sequence
	    //what happens if you delete the t after the backslahses
	    //what happens if you change print to println?
	    //try to discover how many tab positions it is practical to print across the screen by modifying the following print statement
	    //System.out.print("Tab\tTab\tTab\tTab\tTab\n");
	    //System.out.println();
	    
	    //The following println statments have been commented out.  Follow the instructions in comments above each println statement.
	    //You will need to uncomment each println statement to answer the questions.
	    
	    //uncomment the following println statement.
	    //it should print the following to the screen: Anna said, "Please use escape sequences correctly."
	    //there should be quotes around what Alberto said
	    //System.out.println("Alberto said, Please use escape sequences correctly.");
	    //System.out.println();
	   	    
	    //uncomment the following println statement.
	    //it should print the following to the screen: The file path is: "c:\JavaProjects\LiteralConstants.java"
	    //there should be quotes around the file path and there should be backslashes where indicated.
	    //System.out.println("The file path is: c:\\JavaProjects\\LiteralConstants.java");
	    
	}//end of main method
}//end of class
