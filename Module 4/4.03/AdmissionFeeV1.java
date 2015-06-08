
/**
 * This program calculates the admission fee based on a person's age.
 * 
 * ©FLVS 2007
 * @author Bill Jordan 
 * @version 03/16/07
 */
import java.util.Scanner;                                       //import the Scanner class
public class AdmissionFeeV1                                       //class declaration
{
    public static void main(String [] args)                     //beginning of main method
    {
        String yearsOld;                                        //age entered as a String
        int age;                                                //age of person as an integer value
        boolean isChild ;                                //default, person is not a child                                                        
        double admissionFee = 6.00;                             //admission fee for adult
        double tax = 0.075;                                     //sales tax
        
        Scanner in = new Scanner(System.in);                    //create Scanner object to use input methods
        System.out.print("Please enter your age: ");            //prompt user for input            
        yearsOld = in.next();                                   //read input from keyboard as a String
        age = Integer.parseInt(yearsOld);                       //convert input from String to an int
        
        isChild = age <= 10;                                    //if person is a child, assign true to boolean variable
        
        if(isChild)                                             //evalueate if boolean is true or not
           admissionFee = 4.50;                                 //if person is a child, assign new admission fee
        
        admissionFee += admissionFee * tax;                     //calculate admission fee + tax
        
        System.out.println();                                   //print a blank line
        System.out.println("Discount: " + isChild);             //print status of person (are they a child or not)
        System.out.println("Please pay: " + admissionFee);      //print admission fee charged          
       }                                                        //end of main method
    }                                                           //end of class
