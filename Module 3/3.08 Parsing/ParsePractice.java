
/**
 * This program demonstrates how to accept user input as a String
 * with the next() method, then convert the String into a double value
 * or an int value
 * 
 * ©FLVS 2007 
 * @author B. Jordan 
 * @version 03/07/07
 */
import java.util.Scanner;           //import methods of the Scanner class
public class ParsePractice
{
    public static void main(String[ ] args)
    {
        //declare local variables
        String userInput;           //user input as String
        double doubleValue;         //String converted to double     
        double doubleAnswer = 0;    //answer to calculation with doubleValue
        
        int intValue;               //String converted to int
        int intAnswer;              //answer to calculation with int
        
        //construct a Scanner object called in
        Scanner in = new Scanner(System.in);
        
        //parse a String to a double
        System.out.println("Enter a decimal value: ");                                          //request user to enter a decimal number
        userInput = in.next();                                                                  //input accepted as a String
        System.out.println("Try to add the userInput variable: " + (userInput + userInput));    //try to add the userInput variable      
        doubleValue = Double.parseDouble(userInput);                                            //String parsed to a double
        System.out.println("Try to add the parsed input: " + (doubleValue + doubleValue));      //try to add the parsed input data
        System.out.println();
        
        
        //parse a String to an int
        System.out.println("Enter an integer value: ");                                         //request user to enter a decimal number
        userInput = in.next();                                                                  //input accepted as a String
        System.out.println("Try to add the userInput variable: " + (userInput + userInput));    //try to add the userInput variable      
        intValue = Integer.parseInt(userInput);                                                 //String parsed to a double        
        System.out.println("Try to add the parsed input: " + (intValue + intValue));   //print answer to arithmetic expression
             
    }//end of main method
}//end of class
