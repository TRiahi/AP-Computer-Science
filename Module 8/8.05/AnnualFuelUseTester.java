/**
 * Tests the AnnualFuelUse class.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */

public class AnnualFuelUseTester
{
    public static void main(String[] args)
    {
        //initialize variables
        String header = "Annual Gas Mileage Calculations",
               headerLine = "===============================";
        String[] headerInfo = { "Fill Up" , "   Days" , "    Start Miles" , "   End Miles" , "Distance" , "Gallons" , "     Price" , "Cost" , "  Miles/Gal" , "Gal/Mile" };
        int[] fillNumber = {1, 2, 3, 4};
        
        //storing data in arrays
        double[] daysSinceFill = {1, 9, 10, 8},
                 startMiles = {52678, 52903, 53201, 53435},
                 endMiles = { 52903, 53201, 53435, 53665},
                 gallonsUsed = { 20.4, 21.7, 19.7, 22.4},
                 milesPerGallon = new double[startMiles.length],
                 gallonsPerMile = new double[startMiles.length],
                 priceGal = {3.32, 3.26, 3.46, 3.63},
                 totalCost = new double[startMiles.length],
                 distance = new double[startMiles.length];
                 
        //initializing calculation variables         
        double minMPG, minPrice,
               maxMPG, maxPrice,
               minDistance, maxDistance,
               totalDistance, annualDistance,
               totalGallonsUsed, totalCostSum,
               totalMilesPerGallonAverage, totalDaysSinceLastFill,
               annualGallonsUsed, annualCost, annualMPG;
               
        //store arrays in arrays, so meta
        AnnualFuelUse[] car = {new AnnualFuelUse(fillNumber[0], endMiles[0], startMiles[0], gallonsUsed[0], priceGal[0]),
                               new AnnualFuelUse(fillNumber[1], endMiles[1], startMiles[1], gallonsUsed[1], priceGal[1]),
                               new AnnualFuelUse(fillNumber[2], endMiles[2], startMiles[2], gallonsUsed[2], priceGal[2]),
                               new AnnualFuelUse(fillNumber[3], endMiles[3], startMiles[3], gallonsUsed[3], priceGal[3])};
        
        //create methods
        for(int index = 0; index < car.length; index++)
        {
            distance[index] = car[index].getDistance();
            milesPerGallon[index] = car[index].getMPG();
            gallonsPerMile[index] = car[index].getGPM();
            totalCost[index] = car[index].getTotalCost();
        }
        
        //min/max calculations assignments
        minDistance = AnnualFuelUse.min(distance);
        minMPG = AnnualFuelUse.min(milesPerGallon);
        minPrice = AnnualFuelUse.min(priceGal);
        maxDistance = AnnualFuelUse.max(distance);
        maxMPG = AnnualFuelUse.max(milesPerGallon);
        maxPrice = AnnualFuelUse.max(priceGal);
        
        //totals calculations assignments
        totalDistance = AnnualFuelUse.totalOf(distance);
        totalGallonsUsed = AnnualFuelUse.totalOf(gallonsUsed);
        totalCostSum = AnnualFuelUse.totalOf(totalCost);
        totalMilesPerGallonAverage = AnnualFuelUse.totalOf(milesPerGallon) / milesPerGallon.length;
        totalDaysSinceLastFill = AnnualFuelUse.totalOf(daysSinceFill) - 1;
        
        //annuals calculation assignments
        annualDistance = AnnualFuelUse.annualProjection(daysSinceFill, totalDistance);
        annualGallonsUsed = AnnualFuelUse.annualProjection(daysSinceFill, totalGallonsUsed);
        annualCost = AnnualFuelUse.annualProjection(daysSinceFill, totalCostSum);
        annualMPG = AnnualFuelUse.annualProjection(daysSinceFill, totalMilesPerGallonAverage) / totalDaysSinceLastFill;
        
        //print stats
        System.out.printf("%74s%n", header);
        System.out.printf("%74s%n", headerLine);
        
        for(String info : headerInfo)
        {
            System.out.print(info + "\t");
        }
        
        System.out.println("\n=========================================================================================================================");
        
        for(int index = 0; index < car.length; index++)
        {
            System.out.printf("%4d%10.0f%14.0f%14.0f%12.0f%16.1f%11.2f%12.2f%12.2f%13.3f%n", fillNumber[index], daysSinceFill[index], startMiles[index], endMiles[index], distance[index], gallonsUsed[index], priceGal[index], totalCost[index], milesPerGallon[index], gallonsPerMile[index]);
        }
        
        System.out.println("=========================================================================================================================\n");
        
        System.out.printf("Minimum:%46.0f%27.2f%24.2f%n", minDistance, minPrice, minMPG);
        System.out.printf("Maximum:%46.0f%27.2f%24.2f%n%n", maxDistance, maxPrice, maxMPG);
        System.out.printf("Totals:%47.0f%16.1f%23.2f%n", totalDistance, totalGallonsUsed, totalCostSum);
        System.out.printf("Annual Projection:%36.0f%16.1f%23.2f%12.2f%n", annualDistance, annualGallonsUsed, annualCost, annualMPG);
    }
}