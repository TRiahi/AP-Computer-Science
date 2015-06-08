//  VowelCounter.java
//  Created by Shahein Tajmir
//  This program will ask the user for a string then count how many of each lower-case vowel is input and count non-vowel characters
//  	then it will print to the user how many vowels and non-vowels there were in the string.

import cs1.Keyboard;
import java.util.StringTokenizer;

public class VowelCounter
{
	public static void main (String [] args)
	{
		String input;
		int numA = 0, numE = 0, numI = 0, numO = 0, numU = 0, numNonVowel = 0;
		
		System.out.println();  // Lovely blank line
		System.out.println("~~~~~~~~~Vowel Counter~~~~~~~~~");
		System.out.println();
		System.out.println("Please type a sentence or string:  ");
		input = Keyboard.readString();

		for (int letter = 0; letter < input.length(); letter++)
		{
			if (input.charAt(letter) == 'a')
				numA++;
			else if (input.charAt(letter) == 'e')
				numE++;
			else if (input.charAt(letter) == 'i')
				numI++;
			else if (input.charAt(letter) == 'o')
				numO++;
			else if (input.charAt(letter) == 'u')
				numU++;
			else
				numNonVowel++;
		}
		
		System.out.println("Number of a's:  " + numA);
		System.out.println("Number of e's:  " + numE);
		System.out.println("Number of i's:  " + numI);
		System.out.println("Number of o's:  " + numO);
		System.out.println("Number of u's:  " + numU);
		System.out.println("Number of non-vowels:  " + numNonVowel);
	}
}