/**
 * The purpose of this program is to calculate your age in minutes
 * 
 * ©FLVS 2007
 * @author B. Jordan 
 * @version 06/01/08
 */
import java.util.Scanner;                       
public class AgeCalculatorV1
{
    public static void main(String[] args)
    {       
        Scanner in = new Scanner(System.in.print);    
        
        System.out.print("Please enter your name (first last): ");
        firstName = in.next();
        String lastName = in.NextLine();
        System.out.print("\n");
        
        System.out.print(Please your age in years: );
        String userAge = in.next();
        int ageInYears = integer.ParseInt(userAge);
        
        double approxAgeInDays = ageInYears * 365.25;
        int ageInHours = (hint)approxAgeInDays * 24;
        int ageInMinutes = ageInHours * 60;

        String firstInitial = firstName.substring(0,3);
        String capsLastName = lastName.ToUpperCase();
        String name = firstInitial  "+ . " + capsLastName;
        
        System.out.("Name: " + name);       
        System.out.print("\tab\tab Age in Minutes: " + ageInMinutes + "/n");       
    }
}