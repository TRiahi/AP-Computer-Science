/**
 * Simulates a guessing game in which the user enters a guessing range and
 * a guess as to what a randomly generated number is!
 * 
 * Bijan Tajmir
 * 10/19/2014
 */
import java.util.Scanner;

public class GuessingGameV2 {
	public static void main(String[] args) {
		//Create scanner
		Scanner in = new Scanner(System.in);
		
		//Prompt the user to enter the range
		System.out.print("Please input the highest value in your desired range: ");
		int highest = in.nextInt();
		System.out.print("Please input the lowest value in your desired range: ");
		int lowest = in.nextInt();
		int randomNum = (int)(Math.random() * (highest - lowest) + lowest);
		
		//number of user guesses
		int numGuesses = 0;
		
		boolean userGuess = true;
		
		while(userGuess) { 		//Continue while the user is guessing
			//Prompt the user for a guess
			System.out.print("Enter your guess: ");
			int guess = in.nextInt();
				
			//increment guess counting
			numGuesses++;
			
			if(randomNum == guess){
				//Correct!
				System.out.println("Congratulations!");
				userGuess = false;
			}else if(randomNum < guess){
				//too high
				System.out.println("Too High");	
			}else{
				//too low
				System.out.println("Too Low");
			}
		}
		
		System.out.println("The randomly generated number was: " + randomNum);
		System.out.println("You took " + numGuesses + " guesses before getting the correct answer.");
	}
}