/**
 * Calculates price, MPG, and GPM given first fill-up data from a 2010 Chevy Impala, as well as two additional cars.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */
import java.util.Scanner;
public class CarV7
{
    public class Car
    {
        //initialize variables
        String name;
        public int startMiles, endMiles;
        public double gallonsUsed, pricePerGallon;
        
        public Car(String name, int startMiles, int endMiles, double gallonsUsed, double pricePerGallon)
        {
            this.name = name; 
            this.startMiles = startMiles;
            this.endMiles = endMiles;
            this.gallonsUsed = gallonsUsed;
            this.pricePerGallon = pricePerGallon;
        }
    }
    public static void main(String[] args)
    {
        String name;
        int startMiles, endMiles;
        double gallonsUsed, pricePerGallon;
        
        //CarV7 car1 = new CarV7(name, endMiles, startMiles, gallonsUsed, pricePerGallon);
        CarV7 carV7 = new CarV7();
        Car car1 = carV7.new Car("10 Chevy Impala", 52678, 52992, 14.6, 3.5);
        Car car2 = carV7.new Car("13 Cadillac Escalade", 45678, 45935, 16.2, 3.5);
        Car car3 = carV7.new Car("10 Chevy Equinox", 35679, 36092, 13.5, 3.5);
        
        //Stats for cars
        int dist1 = calcDistance(car1.startMiles,car1.endMiles), dist2 = calcDistance(car2.startMiles,car2.endMiles), dist3 = calcDistance(car3.startMiles,car3.endMiles);
        double mpg1 = calcMPG(dist1,car1.gallonsUsed), mpg2 = calcMPG(dist2,car2.gallonsUsed), mpg3 = calcMPG(dist3,car3.gallonsUsed);
        double totalCost1 = calcCost(car1.pricePerGallon,car1.gallonsUsed), totalCost2 = calcCost(car2.pricePerGallon,car2.gallonsUsed), totalCost3 = calcCost(car3.pricePerGallon,car3.gallonsUsed);
        double totalGPM1 = calcGPM(dist1,car1.gallonsUsed), totalGPM2 = calcGPM(dist2,car2.gallonsUsed), totalGPM3 = calcGPM(dist3,car3.gallonsUsed);

        System.out.printf("%20s%20s%20s%20s%20s%20s%20s%20s%20s\n","Type of Car","Start Miles","End Miles","Distance","Gallons","Price","Cost","Miles/Gal","Gal/Mile");
        System.out.print("=========================================================================================================================================================================================\n");
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car1.name,car1.startMiles,car1.endMiles,dist1,car1.gallonsUsed,car1.pricePerGallon,totalCost1,mpg1,totalGPM1);
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car2.name,car2.startMiles,car2.endMiles,dist2,car2.gallonsUsed,car2.pricePerGallon,totalCost2,mpg2,totalGPM2);
        System.out.printf("%20s%20d%20d%20d%20.1f%20.1f%20.1f%20.1f%20.3f\n",car3.name,car3.startMiles,car3.endMiles,dist3,car3.gallonsUsed,car3.pricePerGallon,totalCost3,mpg3,totalGPM3);
    }
    public static int calcDistance(int sMiles, int eMiles) //given code
    { 
        return eMiles-sMiles;
    }
    public static double calcMPG(int dist, double gals) //given code
    { 
        return dist/gals;
    }
    public static double calcCost(double pricePerGallon, double gals) //given static method
    {
        return pricePerGallon*gals;
    }
    public static double calcGPM(int dist, double gals) //given static method
    {   
        return gals/dist;
    }
}