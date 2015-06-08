/**
 * Determines the average number of bottles one needs to open to win a bottle cap prize.
 * 
 * @author Bijan Tajmir
 * @version 10/19/2014
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class BottleCapPrize
{
    public static void main(String [] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        
        PrintWriter outputFile = new PrintWriter(new File("trials.txt"));
        Random randNum = new Random();
        int numBottleCap = 0;
        int wins = 0;
        int bottlesOpened = 0;
        int input;
        
        System.out.print("How many trials would you like? ");
        input = in.nextInt();

        for(int i = 1; i <= input; i++)
        {
            numBottleCap = randNum.nextInt(5);
            while(numBottleCap != 0)
            {
                numBottleCap = randNum.nextInt(5);
                bottlesOpened++;
            }
            if(numBottleCap == 0)
            {
                bottlesOpened++;
                wins++;
            }
        }
        
        outputFile.println("The number of bottles opened was: " + bottlesOpened);
        outputFile.println("The number of winning bottle caps found was: " + wins);
        int averageNumberOfBottles = (bottlesOpened / wins);
        outputFile.println("The average number of bottles that need to be opened to win is: " + averageNumberOfBottles);    
        outputFile.close();

        Scanner inputFile = new Scanner(new File("trials.txt"));
        while(inputFile.hasNextLine())
        {
            String token = inputFile.nextLine();
            System.out.println(token);
        }
        
        inputFile.close();
    }
}
