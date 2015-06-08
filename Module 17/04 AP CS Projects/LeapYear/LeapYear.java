//  LeapYear.java
//  Created by Shahein Tajmir
//  This program will ask the user for a year and then determine whether or not the year is a leap year.  It will then output if the 
//		year is leap or not.

import cs1.Keyboard;

public class LeapYear
{
	public static void main (String [] args)
	{
		final int EARLIEST_YEAR = 1582, SENTINEL = -1;
		int InputYear, DividedBy4, DividedBy100, DividedBy400;
		boolean LeapOrNot;
		Process p = Runtime.getRuntime().exec("cls");
		//  A nice title for telling the user what this program does
		System.out.println("~~~~~~~~Leap Year Calculator~~~~~~~~");
		System.out.println();
		do
		{
			System.out.println("Please type a year no earlier than " + EARLIEST_YEAR + " (-1 to quit):");
			InputYear = Keyboard.readInt();
			System.out.println(); // These blank lines improve readability

			if (InputYear != -1)  //  Prevents code from evaluating on sentinel value
			{
				if (InputYear < EARLIEST_YEAR)  //  Tests if input year is before 1582
				{
					System.out.println("That year is before the Gregorian Calendar was put in use.");
					System.out.println();
				}
		
				else
				{
		
					DividedBy4 = InputYear % 4;  // Determines if divisible by four
					DividedBy100 = InputYear % 100; //  Determines if divisible by 100
					DividedBy400 = InputYear % 400; // Determines if divisible by 400
			
					LeapOrNot = DividedBy4 == 0 && (DividedBy100 != 0 || DividedBy400 == 0); 
					//  This logic expression first determines if it is divisible by 4, if not it short-circuits and it is done
					//  Then it moves into the parenthesis expression.  If atleast one of these two are true, then the year is a leap year
			
					if (LeapOrNot == true)
					{
						System.out.println("The year " + InputYear + " is a leap year.");
						System.out.println();
					}
					else
					{
						System.out.println("The year " + InputYear + " is not a leap year.");
						System.out.println();
					}
				}
			}
		} while (InputYear != SENTINEL); // This checks for the sentinel to end the loop
	}
}