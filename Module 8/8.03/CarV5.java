/**
 * Calculates price, MPG, and GPM given first fill-up data from a 2010 Chevy Impala.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */
import java.util.Scanner;
public class CarV5
{
    public class Car
    {
        //initialize variables
        String name1;
        int startMiles1, endMiles1;
        double gallonsUsed1, pricePerGallon1;
        
        public Car(String name1, int startMiles1, int endMiles1, double gallonsUsed1, double pricePerGallon1)
        {
            this.name1 = name1; 
            this.startMiles1 = startMiles1;
            this.endMiles1 = endMiles1;
            this.gallonsUsed1 = gallonsUsed1;
            this.pricePerGallon1 = pricePerGallon1;
        }
    }
    public static void main(String[] args)
    {
        String name1;
        int startMiles1, endMiles1;
        double gallonsUsed1, pricePerGallon1;
        
        //CarV5 car1 = new CarV5(name1, endMiles1, startMiles1, gallonsUsed1, pricePerGallon1);
        CarV5 carv5 = new CarV5();
        Car car1 = carv5.new Car("10 Chevy Impala", 52678, 52992, 14.6, 3.5);
        
        int dist1 = calcDistance(car1.startMiles1,car1.endMiles1);
        double mpg1 = calcMPG(dist1,car1.gallonsUsed1);
        double totalCost1  = calcCost(car1.pricePerGallon1,car1.gallonsUsed1);
        double totalGPM1   = calcGPM(dist1,car1.gallonsUsed1);

        System.out.printf("%20s%20s%20s%20s%20s%20s%20s%20s%20s\n","Type of Car","Start Miles","End Miles","Distance","Gallons","Price","Cost","Miles/Gal","Gal/Mile");
        System.out.print("=========================================================================================================================================================================================\n");
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car1.name1,car1.startMiles1,car1.endMiles1,dist1,car1.gallonsUsed1,car1.pricePerGallon1,totalCost1,mpg1,totalGPM1);
    }
    public static int calcDistance(int sMiles, int eMiles) //given code
    { 
        return eMiles-sMiles;
    }
    public static double calcMPG(int dist, double gals) //given code
    { 
        return dist/gals;
    }
    public static double calcCost(double pricePerGallon1, double gals) //given static method
    {
        return pricePerGallon1*gals;
    }
    public static double calcGPM(int dist, double gals) //given static method
    {   
        return gals/dist;
    }
}