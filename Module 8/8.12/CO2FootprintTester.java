/**
 * CO2Footprint main method and ArrayList.
 * 
 * @author Bijan Tajmir
 * @version 12/18/2014
 */
import java.util.ArrayList;
public class CO2FootprintTester
{
   public static void main(String[] args)
   {
       ArrayList<CO2Footprint> waste = new ArrayList<CO2Footprint>();
       waste.add(new CO2Footprint(3225.60, 0.12611, 199.69, 4, true, true, true, false, 21));
       waste.add(new CO2Footprint(6785.91, 0.12617, 301.25, 7, false, false, false, false, 6));
       
       
       System.out.println("|             Pounds of CO2                |       Pounds of CO2         |                     |");
       System.out.println("|             Emitted From                 |       Reduced From          |                     |");
       System.out.println("|   Gas      |   Electricity   |   Waste   |  Recycling   | New Bulbs    |    CO2 Footprint    |");
       CO2Footprint dataRecord;
       for(int index = 0; index < waste.size(); index++)
       {
           dataRecord = waste.get(index);
           dataRecord.calcGrossWasteEmission();
           dataRecord.calcWasteReduction();
           dataRecord.calcNetWasteEmission();
        }
           
           
       for(int index = 0; index < waste.size(); index++)
       {
           dataRecord = waste.get(index);
           System.out.printf("| %10.2f | %13.2f   | %9.2f | %12.2f | %10.2f   |     %10.2f     |\n", dataRecord.calcPoundsCO2FromGas(),
               dataRecord.calcElectricityCO2(), dataRecord.calcGrossWasteEmission(), 
               dataRecord.calcWasteReduction(), dataRecord.calcBulbReduc(), 
               dataRecord.calcNetWasteEmission());
       }
       
    }
       
}