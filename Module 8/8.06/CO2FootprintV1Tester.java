/**
 * 
 * Calculates C02 emissions in terms of pounds and tons given projected annual gas need in gallons, as
 * input by the user.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */
public class CO2FootprintV1Tester
{
		/**
		 * Initializing variables
		 */
		private double gallonsOfGas = 0;
		private double tonsOfCO2 = 0;
		private double metricTonsOfCO2 = 0;
		private double poundsOfCO2 = 0;
		private double mathCalc = (8.78 * Math.pow(10, -3));
		
		/**
		 * Default constructor
		 * @param a
		 */
		CO2FootprintV1Tester(double x)
		{
			gallonsOfGas = x;
		}
		
		/**
		 * Finds the CO2 emissions from the tank in various units
		 */
		public void C02EmissionsCalc(){metricTonsOfCO2 = mathCalc * gallonsOfGas;tonsOfCO2 = metricTonsOfCO2 * 1.10231;poundsOfCO2 = tonsOfCO2 * 2000;}
		
		/**
		 * Returns CO2 emissions in tons
		 * @return tonsOfCO2
		 */
		public double getTonsOfCO2(){return tonsOfCO2;}
		
		/**
		 * Returns CO2 emissions in pounds
		 * @return poundsOfCO2
		 */
		public double getPoundsOfCO2(){return poundsOfCO2;}
}