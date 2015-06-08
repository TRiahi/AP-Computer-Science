/**
 * Determines CO2 Emissions from annual electricity usage.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */

public class CO2FromElectricityTester
{
		private double CO2Emmisions = 0;
		private double avgElectricBill = 0;
		private double avgPrice = 0;
		private double CO2EmissionsMulti = 1.37;
		
		CO2FromElectricityTester(double x, double y)
		{
			avgElectricBill = x;
			avgPrice = y;
		}
		public void CO2Emmisions()
		{
		    CO2Emmisions = (avgElectricBill/avgPrice) * CO2EmissionsMulti * 12;
		}
		public double getCO2Emmisions()
		{
		    return CO2Emmisions;
		}
		public double getBill()
		{
		    return avgElectricBill;
		}
		public double getPrice()
		{
		    return avgPrice;
		}
}