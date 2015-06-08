
/**
 * The purpose of this program is to accurately and efficiently caluclate your heart basal metabolic rate.
 * 
 * @author Bijan Tajmir
 * @version 10/18/2014
 */
import java.util.Scanner;
public class BMR
{
    public static void main(String[] args)
    {
        //Initialize and declare variables
        String target = "within";
        Scanner in = new Scanner(System.in);
        double BMR;
        double kilograms;
        double poundsperkilogram = 0.453592; 
        double centimeters;
        //Print program function/description
        System.out.println("Determine Your heart basal metabolic rate.");
        //Prompt user for input
        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.println(name);
        System.out.println("");
        System.out.print("Enter your gender (M or F): ");
        String gender = in.next();
        System.out.println(gender);
        System.out.println("");
        System.out.print("Enter your age: ");
        String age = in.next();
        System.out.println(age);
        System.out.println("");
        System.out.print("Enter your height in inches: ");
        String height = in.next();
        System.out.println(height);
        System.out.println("");
        System.out.print("Weight in pounds: ");
        String weight = in.next();
        System.out.println(weight);
        System.out.println("");
        //Parse Strings
        int age1 = Integer.parseInt(age); 
        int height1 = Integer.parseInt(height);
        int weight1 = Integer.parseInt(weight); 
        //Unit Conversions
        kilograms= weight1 * poundsperkilogram;
        centimeters= (height1 * 2.54);  
        //Determine if man or woman to caluclate BMR
        char gander = gender.charAt(0);
        boolean isMale = gander == 'M';
        
        if(isMale)
               BMR = (10 * kilograms + 6.25 * centimeters - 5 * age1 + 5);
        else
               BMR = (10 * kilograms + 6.25 * centimeters - 5 * age1 - 161);
        
        // Spacing
        System.out.println("");
        System.out.println("");
        System.out.println("");
        //Print Output
        System.out.println("Calculate Your Basal Metabolism");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.print("Name: ");
        System.out.print(name);
        System.out.println("");
        System.out.print("Gender: ");
        System.out.print(gender);
        System.out.println("");
        System.out.print("Age: ");
        System.out.print(age);
        System.out.println("");
        System.out.print("Weight (kg): ");
        System.out.print(kilograms);
        System.out.println("");
        System.out.print("Height (cm): ");
        System.out.print(centimeters);
        System.out.println("");
        System.out.print("Basal Metabolic Rate: ");
        System.out.print(BMR);
    } //end main
}//end class TargetZone