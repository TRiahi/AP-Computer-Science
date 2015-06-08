/**
 * Calculuates annual gas mileage stats based on the information collected from my fill-ups worksheet.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */

public class AnnualFuelUse
{
    //initialize variables
    double gallonsUsed, pricePerGallon, startingMiles, endingMiles;

    //constructor
    AnnualFuelUse(int fillNumber, double endMiles, double startMiles, double galsUsed, double priceGal)
    {
        startingMiles = startMiles;
        endingMiles = endMiles;
        gallonsUsed = galsUsed;
        pricePerGallon = priceGal;
    }

    //distance method
    public double getDistance()
    {
        return endingMiles - startingMiles;
    }

    //MPG method
    public double getMPG()
    {
        return getDistance() / gallonsUsed;
    }

    //GPM method
    public double getGPM()
    {
        return gallonsUsed / getDistance();
    }

    //cost method
    public double getTotalCost()
    {
        return pricePerGallon * gallonsUsed;
    }

    //min method
    public static double min(double minMaxVariable[])
    {
        Double minVariable = Double.MAX_VALUE;
        for(int i = 0; i < minMaxVariable.length; i++)
        {
            if (minMaxVariable[i] < minVariable)
            {
                minVariable = minMaxVariable[i];
            }
        }
        return minVariable;
    }

    //max method
    public static double max(double minMaxVariable[])
    {
        Double maxVariable = Double.MIN_VALUE;
        for(int i = 0; i < minMaxVariable.length; i++)
        {
            if(minMaxVariable[i] > maxVariable)
            {
                maxVariable = minMaxVariable[i];
            }
        }
        return maxVariable;
    }

    //calculates array values for later calculation use
    public static double totalOf(double totalVariable[])
    {
        double totalValue = 0;
        for(double newValue : totalVariable)
        {
            totalValue += newValue;
        }
        return totalValue;
    }
    
    //projections method
    public static double annualProjection(double days[], double annualVariable)
    {
        double totalValue = 0;
        for(double newValue : days)
        {
            totalValue += newValue;
        }
        return 365 / (totalValue - 1) * annualVariable;
    }
}