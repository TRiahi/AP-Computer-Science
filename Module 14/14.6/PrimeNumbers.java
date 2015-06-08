/** 
* This program finds the highest prime number with a user-set limit.
*
* @author Bijan Tajmir 
* @version 3/18/2015
*/ 
import java.util.Scanner;
public class PrimeNumbers { 

        private int upperLimit;
        public int counter;
        
        public PrimeNumbers(int upperLimit){
            this.upperLimit = upperLimit;
        }            
       
            
            public int calculatePrimes(){
            int first, second, primeCheck = 0; 
            for (first = 1; first < upperLimit; first++) { 
                for (second = 2; second < first; second++) { 

                    primeCheck = first % second; 

                        if (primeCheck == 0) 
                           break; 
                    } 
                if (first == second){ 
                System.out.println(first); 
                counter++;
            }
            } 
            return counter;
        }

        

}