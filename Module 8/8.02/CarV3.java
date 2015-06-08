/**
 * Calculates MPG given first fill-up data from my mom's car, a 2010 Chevy Impala.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */
import java.util.Scanner;
public class CarV3 
{
	public class Car
	{
		//initialize variables
	    String name1;
		int startMiles1, endMiles1;
		double gallons;
		
		public Car(String name1, int startMiles1, int endMiles1, double gals1)
		{
			//format from later lecture notes; constructor parameter
		    this.name1 = name1; 
			this.startMiles1 = startMiles1;
			this.endMiles1 = endMiles1;
			this.gallons = gals1;
		}
	}
	public static void main(String[] args)
	{
		String name1;
		int startMiles1, endMiles1;
		double gallons;
	    
	    CarV3 carv3 = new CarV3(); //numbering format from lecture notes
		Car car1 = carv3.new Car("10 Chevy Impala", 52678, 52992, 14.6);
		
		int dist1 = calcDistance(car1.startMiles1,car1.endMiles1);
		double mpg1 = calcMPG(dist1, car1.gallons);
		
		System.out.printf("%20s%20s%20s%20s%20s%20s\n","Type of Car","Start Miles","End Miles","Distance","Gallons","Miles/Gal");
		System.out.print("===========================================================================================================================\n");
		System.out.printf("%20s%20d%20d%20d%20.1f%20.1f\n",car1.name1,car1.startMiles1,car1.endMiles1,dist1,car1.gallons,mpg1);
	}
	public static int calcDistance(int sMiles, int eMiles) //given code
	{ 
		return eMiles-sMiles;
	}
	public static double calcMPG(int dist, double gals) //given code
	{ 
		return dist/gals;
	}
}