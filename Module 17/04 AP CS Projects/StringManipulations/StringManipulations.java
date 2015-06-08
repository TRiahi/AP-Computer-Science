//  StringManipulations.java
//  Created by Shahein Tajmir
//  This program will ask for a string and then manipulate it all over the place.

import cs1.Keyboard;

public class StringManipulations
{
	public static void main (String [] args)
	{

		String Input = "Hello", UpperCase, LowerCase, Greeting = "Hello";
		int InputLength;

		System.out.println();
		System.out.println(Input + ", please type your first name:  ");
		Input = Keyboard.readString();

		UpperCase = Input.toUpperCase();
		LowerCase = Input.toLowerCase();
		
		System.out.println();
		System.out.println(Greeting + ' ' + Input + "!");
		System.out.println("Uppercased:  " + UpperCase);
		System.out.println("Lowercased:  " + LowerCase);
		
		for (int Letter = 0; Letter < Input.length(); Letter++)
		{
			System.out.println(Input.charAt(Letter));
		}
	}
}

				