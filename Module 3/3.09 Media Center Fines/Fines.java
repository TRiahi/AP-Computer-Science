/**
 * A program to calculate fines on overdue books for the CSA Media Center.
 * 
 * ©BMT 2014
 * @author Bijan Tajmir 
 * @version 10/07/2014
 */
import java.util.Scanner;                       
public class Fines
{
    public static void main(String[] args)
    {       
        Scanner in = new Scanner(System.in);
         
        //Prompt user for required info 
        System.out.print("Enter name (Last, First) and Social Security Number (###-##-####): "); 
        String lastName = in.next(); 
        String firstName = in.nextLine();
        String ssn = in.nextLine();
        System.out.print(lastName+firstName+ ssn);
        System.out.println("");
        System.out.println("");
    
        System.out.print("Enter the title of the book: ");
        String booktitle = in.next();
        System.out.print(booktitle);
        System.out.println("");
        System.out.println("");
        
        System.out.print("Enter the date checked out (mm/dd/yyyy): ");
        String checkoutdate = in.next();
        System.out.print(checkoutdate);
        System.out.println("");
        System.out.print("Days Late: ");
        String dayslate = in.next();
        System.out.println(dayslate);
        System.out.println("");
        System.out.print("Daily Fine: ");
        String dailyfine = in.next();
        System.out.println(dailyfine);
        System.out.println("");
        System.out.println("");

        //Calcualte the late fees
        int latedays = Integer.parseInt(dayslate);
        double finedaily = Double.parseDouble(dailyfine);
        double latefees = (latedays * finedaily);
        System.out.println("Total Fee: ");
        System.out.print(latefees);
        System.out.println("");
        System.out.println("");
        
        //Print email-like output
        System.out.print("To: ");
        System.out.print(lastName+firstName);
        System.out.print("                  Account: ");
        String acctname1 = firstName.substring(0,4);
        String acctname2 = ssn.substring(6,11);
        System.out.print(lastName+acctname1+acctname2);
        System.out.println("");
        System.out.print("From: Mona");
        System.out.println("");
        System.out.print("Subject: Overdue Notice");
        System.out.println("");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.print(booktitle); 
        System.out.print(" was checked out on: "); 
        System.out.print(checkoutdate);
        System.out.println("");
        System.out.print("This book is currently ");
        System.out.print(dayslate);
        System.out.print(" days late.");
        System.out.println("");
        System.out.print("Your fine has accumulated to: ");
        System.out.print(latefees); 
    }
}