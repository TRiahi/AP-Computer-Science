/**
 * Calculates weight on various planets given mass and surface gravity data from the specified text file. 
 * 
 * @author Bijan Tajmir 
 * @version 12/17/2014
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class WeightOnPlanetsV1
{				   
    public static double [] gravity()throws IOException {	  
		int iterate = 0;
		double [] gravities = new double[9]; //initialize array
		File fileName = new File("gravity1.txt");
		Scanner inFile = new Scanner(fileName);
		while (inFile.hasNext()){
			gravities[iterate] = inFile.nextDouble();
			iterate++;
		}
		inFile.close(); //close file writing to end loop
		return gravities; //requires return statement to execute
   }
    public static double [] pounds(double[]gravities, double[]weight) {
		for (int iterate = 0; iterate < 9; iterate++){
			weight[iterate] = 150 * gravities[iterate];
		}
		return weight; //requires return statement to execute
   }
   public static void print(double [] gravities, double [] weight, String [] planetNames) {
	    System.out.printf("%21s\n","My Weight on the Planets");
	    System.out.println("Planet	Gravity	 Weight(lbs)");
	    for (int iterate = 0; iterate< 9; iterate ++){
	        System.out.printf(planetNames[iterate] + "	 %4.1f	%4.1f",gravities[iterate],weight[iterate]);
	        System.out.println();
	    }
   }
   public static void main()throws IOException {
        String [] planet = {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune","Pluto"};
	    double gravities[] = gravity();
	    double[] weight = new double[9]; //initialize array
	    weight = pounds(gravities, weight);
	    print(gravities, weight, planet);
   }
}