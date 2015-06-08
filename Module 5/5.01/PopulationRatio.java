/**  
  * This program simulates the gender ratio in the Russian Federation. 
  *   
  * @author Bijan Tajmir
  * @version 10/19/2014
  */    
 import java.util.Scanner;    
 import java.util.Random;  
 
 public class PopulationRatio  
 {    
   public static void main(String [] args)  
   {  
       Scanner in;    
       in = new Scanner(System.in);    
             
       System.out.println("Enter the total population of the Russian Federation (please note that the computation might take a while depending on the population): ");   
       int population = in.nextInt();    
       int numberOfMen = 0;    
       int numberOfWomen = 0;   
       double randomNumber = 0;    
       int counter = 0;          
           
       System.out.println("\n");  
           
       while(counter <= population)    
       {    
         randomNumber = Math.random();   
         numberOfWomen = population - numberOfMen;  
         counter ++;    
                   
         boolean isFemale = randomNumber >= .4785;    
                 
         if (isFemale)  {    
               //System.out.print("\nW: " + randomNumber);    
               numberOfWomen++;  
         }    
         else {     
               //System.out.print("\nM: " + randomNumber);    
               numberOfMen++;  
                }  
             }  
       
       //System.out.print("\n");  
       System.out.println("The number of Men equals: " + numberOfMen);  
       System.out.println("The number of Women equals: " + numberOfWomen);  
        }        
 } 