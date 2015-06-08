/**
 * Simulates a guessing game in which the user enters a guess as to what a randomly generated guess is!
 * 
 * Bijan Tajmir
 * 10/14/2014
 */
import java.util.Scanner;

public class GuessingGameV1
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        
        int counter = 0;
        double randNum = Math.random();
        int randNumRange = (int)(randNum * 100.0);
        
        System.out.println("Your guess between 1 and 100: ");
        int guess = in.nextInt();
        
        while(guess != randNumRange)
        {
            if(guess < randNumRange)
            {
                System.out.println("Too low!");  
                System.out.print("Guess again: ");
                counter++;
                guess = in.nextInt();
            }
            else
            {
                System.out.println("Too high!");  
                System.out.print("Guess again: ");
                counter++;
                guess = in.nextInt();
                
            }
        }
   
        System.out.println("Congratulations! The randomly generated number was: " + randNumRange);
        System.out.println("guess of guesses: " + counter);
    }
}