
/**
 * The following program calculates a person's salary based on
 * the numbers of hours worked and the hourly pay rate.
 * If the person works more than 40 hours, the pay rate is one-
 * and-a-half times the regular hourly rate for the overtime
 * hours.
 * 
 * ©FLVS 2007
 * @author B. Jordan 
 * @version 03/19/07
 */
import java.util.Scanner;
public class SalaryV1
{
    public static void main(String[] args)
    {   
        Scanner in = new Scanner(System.in);
    
        System.out.print("Please enter your name (first last): ");
        String firstName = in.next();
        String lastName = in.next();
        
        System.out.print("\nWhat is your hourly rate of pay: ");
        String rateOfPay = in.next();
        double payRate = Double.parseDouble(rateOfPay);
        
        System.out.print("\nHow many hours did you work: ");
        String totalHoursWorked = in.next();
        double totalHours = Double.parseDouble(totalHoursWorked);
        System.out.println();
        
        double totalSalary = totalHours * payRate;
        
        boolean isOvertime = totalHours > 40;
        
        if(isOvertime)
            totalSalary += (totalHours - 40) * payRate / 2;
        
        System.out.println("Employee Name: " + lastName + ", " + firstName);
        System.out.print("Hourse worked: " + totalHours);
        System.out.print("\t\tOvertime: " + isOvertime + "\n");
        System.out.println("Salary: " + totalSalary);    
    }
}
