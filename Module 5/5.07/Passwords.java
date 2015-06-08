/**
 * Generates a password based on user input selections (menu selection, length selection).
 * 
 * @author Bijan Tajmir
 * @version 10/19/2014
 */

import java.util.Random;
import java.util.Scanner;

public class Passwords {
	public static void main(String[] args) {
		//Create scanner
		Scanner in = new Scanner(System.in);
		Random randNum = new Random();
		Random randSelection = new Random();
		
		//Initialize variables
		int userSelection = 0;
		int length = 0;
		int loopSelection = 0;
		String lowercase = "abcdefghijklmnopqrstuvwxyz";
		String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "1234567890";
		String punctuation = "={}|[]:;@\\<>?`/~^_";
		String password = "";
		
		//Create menu
		System.out.println("\n Password Generation Menu");
		System.out.println("**********************************************************");
		System.out.println("* [1] Lowercase Letters *");
		System.out.println("* [2] Lowercase & Uppercase Letters *");
		System.out.println("* [3] Lowercase, Uppercase, and Numbers *");
		System.out.println("* [4] Lowercase, Uppercase, Numbers, and Punctuation *");
		System.out.println("* [5] Quit *");
		System.out.println("**********************************************************");
		System.out.println("");
		
		//Prompt user for input
		System.out.print("Please enter a menu selection (1-5):  ");
		userSelection = in.nextInt();
		System.out.println("");
		System.out.println("Please choose a password length (1-14):  ");
		length = in.nextInt();
		
		//Conditional and loop for selection 1
		if(userSelection == 1)
		{
			for(int i = 0; i < length; i++)
			{
				password += lowercase.charAt(randNum.nextInt(lowercase.length()));
			}
		}
		//Conditional and loop for selection 2
		else if(userSelection == 2)
		{
			for(int i = 0; i < length; i++)
			{
				loopSelection = randSelection.nextInt(2);
				if(loopSelection == 0)
				{
					password += lowercase.charAt(randNum.nextInt(lowercase.length()));
				}
				else if(loopSelection == 1)
				{
					password += uppercase.charAt(randNum.nextInt(uppercase.length()));
				}
			}
		}
		//Conditional and loop for selection 3
		else if(userSelection == 3)
		{
			for(int i = 0; i < length; i++)
			{
				loopSelection = randSelection.nextInt(3);
				if(loopSelection == 0)
				{
					password += lowercase.charAt(randNum.nextInt(lowercase.length()));
				}
				else if(loopSelection == 1)
				{
					password += uppercase.charAt(randNum.nextInt(uppercase.length()));
				}
				else if(loopSelection == 2)
				{
					password += numbers.charAt(randNum.nextInt(numbers.length()));
				}
			}
		}
		//Conditional and loop for selection 4
		else if(userSelection == 4)
		{
			for(int i = 0; i < length; i++)
			{
				loopSelection = randSelection.nextInt(4);
				if(loopSelection == 0)
				{
					password += lowercase.charAt(randNum.nextInt(lowercase.length()));
				}
				else if(loopSelection == 1)
				{
					password += uppercase.charAt(randNum.nextInt(uppercase.length()));
				}
				else if(loopSelection == 2)
				{
					password += numbers.charAt(randNum.nextInt(numbers.length()));
				}
				else if(loopSelection == 3)
				{
					password += punctuation.charAt(randNum.nextInt(punctuation.length()));
				}
			}
		}
		//Selection 5 execution
		else if(userSelection == 5)
		{
			System.out.println("You selected option 5, Quit. The program has now ended.");
		}
		//Selection invalid notice
		else
		{
			System.out.println("Selection invalid. Please select a number from 1 through 5 next time!");
		}
		System.out.println("The password generated based on your selections is: " + password);
	}
}