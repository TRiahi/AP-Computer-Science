/**
 * 
 * Calculates C02 emissions in terms of pounds and tons given projected annual gas need in gallons, as
 * input by the user.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class CO2FootprintV1 
{
        public static void main(String[] args) 
        {
                /**
                 * Establishes a new scanner and prompts the user for their projected gas need input
                 */
                
                Scanner in = new Scanner(System.in);
                DecimalFormat four = new DecimalFormat(".####");
                System.out.println("Please enter the number of tanks you wish to calculate C02 Emissions for: ");
                int tanks = in.nextInt();
                double[] totalGallons = new double[tanks];
                for(int i=0;i<tanks;i++)
                {
                    System.out.println("Please enter how many gallons you are projected to need per year for one tank: ");
                    totalGallons[i] = in.nextDouble();
                }
                
                /**
                 * Creates the CO2FootprintV1Tester object per the assessment instructions
                 */
                double[] tons       = new double[tanks];
                double[] pounds     = new double[tanks];
                CO2FootprintV1Tester[] calc  = new CO2FootprintV1Tester[tanks];
                for(int i=0;i<calc.length;i++)
                {
                    calc[i] = new CO2FootprintV1Tester(totalGallons[i]);
                }
                for(int i=0;i<calc.length;i++)
                {
                    calc[i].C02EmissionsCalc();
                }
                for(int i=0;i<calc.length;i++)
                {
                    tons[i] = calc[i].getTonsOfCO2();
                    pounds[i] = calc[i].getPoundsOfCO2();
                }
                
                /**
                 * Shows output results to the user
                 */
                for(int i=0;i<calc.length;i++){
                    
                    System.out.println("          CO2 Emissions");  
                    System.out.println("Gallons         Tons        Pounds");  
                    System.out.println("of Gas        from Gas     from Gas");  
                    System.out.println("***********************************");  
          
                    System.out.printf("%1.1f%14.2f%15.3f%n",totalGallons[i],tons[i],pounds[i]);  
                }
                in.close();
        }
}