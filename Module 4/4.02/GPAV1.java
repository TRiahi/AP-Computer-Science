
/**
 * This program illustrates the use of a boolean expression
 * to determine whether a player is elibile for competition.
 * 
 * ©FLVS 2007
 * @author B. Jordan 
 * @version 03/29/2007
 */
import java.util.Scanner;
public class GPAV1
{
    public static void main(String[] args)
    {
        String letterGrade = "";
        Scanner in = new Scanner(System.in);
        
        System.out.println("GPA Calculator");
        System.out.println();
        System.out.println("Please enter 5 grades separated by a space (e.g. 4 3 2 1 4)): ");
        int grade1 = in.nextInt();
        int grade2 = in.nextInt();
        int grade3 = in.nextInt();
        int grade4 = in.nextInt();
        int grade5 = in.nextInt();
        
        double average = (grade1 + grade2 + grade3 + grade4 + grade5)/5.0;
        boolean isEligible = average >= 2.0;                    //this is a boolean expression which evaluates to true or false      
            
        System.out.println("GPA: " + average);
        System.out.println("Eligible: " + isEligible);       
    }
}
