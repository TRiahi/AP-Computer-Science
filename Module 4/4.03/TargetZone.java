
/**
 * The purpose of this program is to accurately and efficiently caluclate your target heart rate.
 * 
 * @author Bijan Tajmir
 * @version 10/18/2014
 */
import java.util.Scanner;
public class TargetZone
{
    public static void main(String[] args)
    {
        //Initialize and declare variables
        String target = "within";
        Scanner in = new Scanner(System.in);
        
        //Print program function/description
        System.out.println("Determine Your Target Heart Rate Zone for Cardiovascular Excercise (50%-85%)");
        //Prompt user for input
        System.out.print("Enter your age: ");
        String age = in.next();
        System.out.println(age);
        System.out.println("");
        System.out.print("Enter your resting heart rate: ");
        String restingheartrate = in.next();
        System.out.println(restingheartrate);
        System.out.println("");
        System.out.print("Enter your heart rate after excercising: ");
        String postexcerciseheartrate = in.next();
        System.out.println(postexcerciseheartrate);
        System.out.println("");
        //Calculate heart rate target zone min and max
        int age1 = Integer.parseInt(age); 
        int restingheartrate1 = Integer.parseInt(restingheartrate);
        int postexcerciseheartrate1 = Integer.parseInt(postexcerciseheartrate); 
        int Maximumheartrate = (220 - age1); 
        int heartratereserve = (Maximumheartrate - restingheartrate1);
        double targetmax = ((heartratereserve*.85) + restingheartrate1); 
        double targetmin = ((heartratereserve *.50) + restingheartrate1);
        //Determine if heart rate after exercise is between the min and max
        boolean isWithin = postexcerciseheartrate1 >= targetmin;
        if(isWithin)                                             
            target = "Within";
        //If the heart rate is below, change the value of target to "below".
        boolean isBelow = postexcerciseheartrate1 <= targetmin;
        if(isBelow)
           target = "Below";
       //If the heart rate is above, change the value of target to "above".
        boolean isAbove = postexcerciseheartrate1 >= targetmax;
        if(isAbove)
           target = "Above";
        //Print two output statements
        //The first stating the heart rate target zone
        System.out.print("Your heart rate target zone is between "+ targetmin);
        System.out.print(" and " + targetmax);
        System.out.println("");
        //The second stating if the heart rate after exercise  was within, above or below
        //the target zone. The variable "target" will have a value of within, above or below
        System.out.print("After exercising, your heart rate is " + target);
        System.out.print(" your target zone");    
    } //end main
}//end class TargetZone