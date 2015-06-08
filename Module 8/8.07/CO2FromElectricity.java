/**
 * Determines CO2 Emissions from annual electricity usage.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class CO2FromElectricity
{
	public static void main(String[] args) 
	{
			Scanner in = new Scanner(System.in);
			DecimalFormat two = new DecimalFormat(".##");
			ArrayList<Double> electricityArray = new ArrayList<Double>();
			System.out.print("Please input your average monthly electricity bill, without the dollar sign: ");
			electricityArray.add(in.nextDouble());
			System.out.print("\nPlease input the average price, without the dollar sign, per kilowatt hour: ");
			electricityArray.add(in.nextDouble());
			in.close();
			CO2FromElectricityTester construct1 = new CO2FromElectricityTester(electricityArray.get(0), electricityArray.get(1));
			construct1.CO2Emmisions();
			System.out.println("Average Monthly Electricity Bill:      " + two.format(construct1.getBill()));
			System.out.println("Average Monthly Electricity Price:     " + two.format(construct1.getPrice()));
			System.out.println("Annual CO2 Emmisions from Electricity Usage: " + two.format(construct1.getCO2Emmisions()) + " pounds");
	}
}