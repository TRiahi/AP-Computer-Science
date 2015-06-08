/** 
 * 
 * Calculates the probability of each possible sum when two 11-sided dice are thrown. Also enabled
 * the ability in input the number of sides as desired.
 * 
 * @author Bijan Tajmir
 * @version 10/19/2014
 */

import java.util.Scanner; 
import java.util.Random; 
import java.text.DecimalFormat; 

public class DiceProbability { 
    public static void main(String[] args) { 
        Random random; 
        random = new Random(); 

        Scanner in = new Scanner(System.in); 
        int die1, die2; 
        int sides; 
        int dieRolls; 
        int sum; 
        int sumOfDie; 
        double numOfRolls; 
        double allMatches = 0; 
        
        //Went ahead and asks users for number of sides input
        System.out.print("Please enter the amount of sides you want on the dice: "); 
        sides = in.nextInt(); 
        
        System.out.print("Please enter the amount of times you want to roll the dice: "); 
        dieRolls = in.nextInt(); 
        
        System.out.println("Sum of dice\tProbability\n"); 
        
        //**************************************
        //Using nested loops, cycle through the possible sums of the dice. 
        //Roll the dice the given number of times for each sum. 
        //Count how many times the sum of the dice match the current sum being looked for. 
        //**************************************

        for(sum = 2; sum <= 2 * sides; sum ++) { 
            for(numOfRolls = 0; numOfRolls <= dieRolls; numOfRolls ++) { 
                die1 = random.nextInt(sides) + 1; 
                die2 = random.nextInt(sides) + 1; 
                sumOfDie = die1 + die2; 
                if(sumOfDie == sum) { 
                    allMatches += 1; 
                } 
            } 
            double probability = (allMatches / numOfRolls) * 100; 
            System.out.println(sum + "\t\t" + probability); 
            allMatches = 0; 
        } 
    } 
}