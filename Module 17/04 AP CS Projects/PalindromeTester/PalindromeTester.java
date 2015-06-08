//  PalindromeTester.java
//  Created by Shahein Tajmir
//  This program will read in a string from the user, then tokenize the string to remove spaces/puncuation and compare each value 
//		to determine if it is a palindrome or not.

import cs1.Keyboard;
import java.util.StringTokenizer;

public class PalindromeTester
{
	public static void main (String [] args)
	{
		String Input, EditedInput = "", Word, Continue = "y";
		StringTokenizer tokenizer; 
		int left = 0, right;
		
		System.out.println ();	// Blank line
		System.out.println ("\n~~~~~~~~~~~~~~Palindrome Tester~~~~~~~~~~~~~~~~");

		while (Continue.equalsIgnoreCase("y")) // Keeps program going until user quits
		{
			System.out.println ();
			System.out.println ("Please type a string to be tested:");
			Input = Keyboard.readString();
		
			tokenizer = new StringTokenizer(Input, " \t\n\r.,!?;':()-"); // Tokenizes string, ignoring puncuation and spaces
		
			while (tokenizer.hasMoreTokens())
			{
				Word = tokenizer.nextToken();
				EditedInput = EditedInput + Word;  // Makes a string of text with no punctuation/spacing
			}
		
			right = EditedInput.length() - 1; 
			EditedInput = EditedInput.toUpperCase(); // Removes all case issues

			while ((EditedInput.charAt(left) == EditedInput.charAt(right)) && left < right)
			{
				left++;
				right--;
			}
		
			if (left < right)
				System.out.println("That string is NOT a palindrome!");
			else
				System.out.println("That string IS a palindrome!");
			
			System.out.println ();
			System.out.println ("Test another ( Y for yes, N for no):  ");
			Continue = Keyboard.readString();
		}
	}
}