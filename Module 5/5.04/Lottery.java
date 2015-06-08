/**
 * A program to determine if a user has correctly chosen a randomly selected 
three digit number.
 * 
 * @author Bijan Tajmir
 * @version 10/19/2014
 */
import java.util.Scanner;
public class Lottery
{
	public static void main(String[] args)
	{
		//initialize scanner
		Scanner in = new Scanner(System.in);
		
		String randomLotteryNum = "";
		String userGuess = "";
	
		//Generates pseudorandom, three-digit numbers for the lottery by looping
		for(int i = 0; i < 3; i++) {
			int randomNum = (int)(Math.random()*10);
			randomLotteryNum += Integer.toString(randomNum);
		}
		
		//Prompt the user to enter a three-digit number
		System.out.print("Please enter your three numbers (e.g. 123): ");
		userGuess = in.nextLine();
		
		System.out.println("    Winning Lottery Number: " + randomLotteryNum);
		
		//Testing for matches between pseudorandomly generated numbers and user guesses.
		if(userGuess.equals(randomLotteryNum)){
			//Full match
			System.out.print("        Congratulations, both pairs matched.");
			
		}else if(userGuess.substring(0, 2).equals(randomLotteryNum.substring(0, 2))){
			//Partial match--front pair
			System.out.print("        Congratulations, the front pair matched.");
			
		}else if(userGuess.substring(1, 3).equals(randomLotteryNum.substring(1, 3))){
			//Partial match--end pair
			System.out.print("        Congratulations, the end pair matched.");
			
		}else{
			//No matches
			System.out.print("        Sorry, no matches.");
			
		}
	} //end main
}//end class Lottery