/**
 * Calculates average temperature and precipitation over the year for Daytona Beach on the scale of the user's
 * choice: Fahrenheit/Celsius, inches/centimeters.
 * 
 * @author Bijan Tajmir
 * @version 11/7/14
 */
 
import java.util.Scanner;
public class AnnualClimate2
{
   public static void main (String [ ] args)
   {
        Scanner in = new Scanner(System.in);
        
        //Daytona Beach stats
        double[] temperature = {58.4, 60.0, 64.7, 68.9, 74.8, 79.7, 81.7, 81.5, 79.9, 74.0, 67.0, 60.8};
        double[] precipitation = {3.1, 2.7, 3.8, 2.5, 3.3, 5.7, 5.2, 6.1, 6.6, 4.5, 3.0, 2.7};
        
        //Second set of test data: West Palm Beach. To use, uncomment this section and comment the above one.
        //double[] temperature = {66.2, 67.2, 70.6, 73.8, 78.2, 81.2, 82.5, 82.8, 81.7, 78.1, 73.1, 68.3};
        //double[] precipitation = {3.8, 2.6, 3.7, 3.6, 5.4, 7.6, 6.0, 6.7, 8.1, 5.5, 5.6, 3.1};
        
        String tempUnit = "";
        String precipUnit = "";
        
        //Menu choices
        System.out.print("Choose temperature scale (1 = Farenheit, 2 = Celsius ): ");
        int tempChoice = in.nextInt();
        System.out.print("Choose precipitation scale (3 = inches, 4 = centimeters): ");
        int precipChoice = in.nextInt();
        
        if(tempChoice==1)  
        {
            tempUnit = "F";    
        }
        else if(tempChoice==2)
        {
            for(int i=0; i<12; i++) 
            {
                temperature[i] = temperature[i]-32; //convert Farenheit to Celsius
                temperature[i] = (.555)*(temperature[i]);
                temperature[i] = ((temperature[i]*10));
                temperature[i] = ((int)temperature[i]);
                temperature[i] = temperature[i]/10;
            }   
            tempUnit = "C";
        }
        else
        {
            System.out.println("Your input for the chosen temperature scale was invalid! Please try again.");
        }

        if(precipChoice==3)
        {
            precipUnit = "in.";
        }
        else if(precipChoice==4)
        {
            for(int i=0; i<12; i++) 
            {
                precipitation[i] = (precipitation[i]*2.54); //convert in. to cm
                precipitation[i] = ((precipitation[i]*10));
                precipitation[i] = ((int)precipitation[i]);
                precipitation[i] = precipitation[i]/10;
            }   
            precipUnit = "cm";
        }
        else
        {
            System.out.println("Your input for the chosen precipitation scale was invalid! Please try again.");
        }
        
        String[] year = {"Jan.","Feb.","Mar.","Apr.","May.","Jun.","Jul.","Aug.","Sep.","Oct.","Nov.","Dec."};
        double sum=0.0;
        
        for(int i=0; i<12; i++) 
        {
            sum=sum+temperature[i];
        }
        
        double avgTemp = sum/12; //Average temperature
        avgTemp = ((avgTemp*10));
        avgTemp = ((int)avgTemp);
        avgTemp = avgTemp/10;
        sum = 0.0;
        
        for(int i=0; i<12; i++) 
        {
            sum=sum+precipitation[i];
        }
        
        double avgPrecip = (sum*10); //Average precipitation
        avgPrecip = (int)avgPrecip;
        avgPrecip = avgPrecip/10;
        
        System.out.printf("%35s\n", "Climate Data");
        System.out.printf("%45s\n", "Location: Daytona Beach, Florida");
        System.out.println();
        System.out.printf("%8s%18s%24s\n", "Month", "Temperature " + tempUnit, "Precipitation " + precipUnit); 
        System.out.println("*****************************************************");
        
        for(int i=0; i<12; i++) 
        {
            System.out.printf("%8s%13s%20s\n", month[i], temperature[i], precipitation[i]);
        }
        
        System.out.println("*****************************************************");
        System.out.printf("%8s%18s\n", "Average: " + avgTemp , "Annual: " + avgPrecip); 
   } 
}