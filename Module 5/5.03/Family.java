/**
 * Reads text in from a file and calculates the probability of family combinations
 * from the given data.
 * 
 * @author Bijan Tajmir
 * @version 10/19/2014
 */

import java.util.Scanner; 
import java.io.File; 
import java.io.FileReader; 
import java.io.IOException; 
public class Family 
{
    public static void main(String[] args) throws IOException {
        //initialize variables
		int bothBoys = 0;
		int bothGirls = 0;
		int boyAndGirl = 0;
		int sampleSize = 0;
		int counter=0; 
		double probabilityOfBothBoy=0;
		double probabilityOfBoyAndGirl = 0;
		double probabilityOfBothGirl =0; 
		String token = ""; 
		Scanner inFile = new Scanner(new File("MaleFemaleInFamily.txt"));
		
		while(inFile.hasNext()){
			token = inFile.next();
			System.out.println(token); //this part may be commented out to demonstrate consistent results
				if(token.equals("BB")){
					bothBoys++;
					counter++;
				}else if(token.equals("GG")){
					bothGirls++;
					counter++;
				}else if(token.equals("BG")){
					boyAndGirl++;
					counter++;
				}else if(token.equals("GB")){
				    boyAndGirl++;
				    counter++;	
				}  
				 
		}
		
		sampleSize = counter;
		
		System.out.println("Sample size: " + sampleSize);
		System.out.println("Number of families with two boys: "+ bothBoys);
		System.out.println("Number of families with one boy and one girl: "+ boyAndGirl);
		System.out.println("Number of families with two girls: "+ bothGirls);
		
		inFile.close();
		probabilityOfBothBoy = (double)bothBoys / (double)sampleSize; 
		probabilityOfBothGirl = (double)bothGirls / (double)sampleSize; 
		probabilityOfBoyAndGirl = (double)boyAndGirl / (double)sampleSize; 
		System.out.println("Probability of Two Boys: "+ probabilityOfBothBoy); 
		System.out.println("Probability of One Boy One Girl: "+ probabilityOfBoyAndGirl); 
		System.out.println("Probability of Two Girls: " + probabilityOfBothGirl); 
	}
}