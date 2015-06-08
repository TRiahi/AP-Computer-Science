/**
 * Determines CO2 Emissions from household waste and deductions from recycling activities.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */

import java.util.ArrayList;                                   
public class CO2FromWasteTester
{
    public static void main(String [] args)
    {
        ArrayList<CO2FromWaste> householdEmission = new ArrayList<CO2FromWaste>();
        householdEmission.add(new CO2FromWaste(1, true, true, true, true));
        householdEmission.add(new CO2FromWaste(3, true, false, true, true));
        householdEmission.add(new CO2FromWaste(4, false, false, false, false));
        householdEmission.add(new CO2FromWaste(1, true, true, true, true));
        householdEmission.add(new CO2FromWaste(1, true, true, true, true));
        
        CO2FromWaste dataRecord;
        
        for(int index = 0; index < householdEmission.size(); index++)
        {
            dataRecord = householdEmission.get(index);
            dataRecord.calcTotalWasteEmission();
            dataRecord.calcWasteDeduction();
            dataRecord.calcNetWasteDeduction();
        }
        
        System.out.println("|_______|________|_____ Household Waste Recycled _______|_______  Pounds of CO2  ___________|");
        System.out.println("|       |        |                                      | Total   |            |    Net    |");
        System.out.println("| Index | People |  Paper  |  Plastic  | Glass |  Cans  |Emission | Reduction  |  Emission |");
        System.out.println("|-------|--------|---------|-----------|-------|--------|---------|------------|-----------|");

        for(int index = 0; index < householdEmission.size(); index++)
        {
            dataRecord = householdEmission.get(index);
            
            System.out.printf("|%4d   |%4d    |%6s   |%7s   | %6s | %6s | %6.2f | %10.2f |%9.2f  |%n",
                      index, dataRecord.householdNumber(),
                      String.valueOf(dataRecord.getPaperRecycling()), String.valueOf(dataRecord.getPlasticRecycling()), String.valueOf(dataRecord.getGlassRecycling()), String.valueOf(dataRecord.getCansRecycling()),
                      dataRecord.getTotalWasteEmission(), dataRecord.getWasteDeduction(),
                      dataRecord.getNetWasteDeduction());
        }
        
        System.out.println("|-------|--------|---------|-----------|-------|--------|---------|------------|-----------|");
    }
}