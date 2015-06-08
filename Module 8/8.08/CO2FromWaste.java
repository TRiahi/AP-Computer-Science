/**
 * Determines CO2 Emissions from household waste and deductions from recycling activities.
 * 
 * @author Bijan Tajmir
 * @version 12/17/2014
 */

import java.util.ArrayList;                                   
public class CO2FromWaste
{
    //Initializing variables
    private int householdNumber;                               
            boolean paperRecycling,                             
                    plasticRecycling,                          
                    glassRecycling,                             
                    cansRecycling;                              
            double totalWasteEmission,                        
                   wasteDeduction,                             
                   netWasteDeduction;                          
    
    //Constructor
    CO2FromWaste(int numHousehold, boolean paper,boolean plastic, boolean glass, boolean cans)
    {
        householdNumber = numHousehold;
        paperRecycling = paper;
        plasticRecycling = plastic;
        glassRecycling = glass;
        cansRecycling = cans;
    }
    /**
     * method calculates totalWasteEmission using householdNumber and multiplier figures
     */
    public void calcTotalWasteEmission()
    {
        totalWasteEmission = householdNumber * 1018;
    }
    /**
     * method returns value for totalWasteEmission
     */
    public double getTotalWasteEmission()
    {
        return totalWasteEmission;
    }
    /**
     * method calculates waste deduction from various sorts of recycling activities
     */
    public void calcWasteDeduction()
    {
        double a, b, c, d;
        if(paperRecycling == true)
        {
            a = 184;
        }
        else
        {
            a = 0;
        }
        if(plasticRecycling == true)
        {
            b = 25.6;
        }
        else
        {
            b = 0;
        }
        if(glassRecycling == true)
        {
            c = 46.6;
        }
        else
        {
            c = 0;
        }
        if(cansRecycling == true)
        {
            d = 165.8;
        }
        else
        {
            d = 0;
        }
        
        wasteDeduction = householdNumber * (a + b + c + d);
    }
    /**
     * method returns value for wasteDeduction
     */
    public double getWasteDeduction()
    {
        return wasteDeduction;
    }
    /**
     * method calculates netWasteDeduction using figures for totalWasteEmission and wasteDeduction
     */
    public void calcNetWasteDeduction()
    {
        netWasteDeduction = totalWasteEmission - wasteDeduction;
    }
    /**
     * method returns value for netWasteDeduction
     */
    public double getNetWasteDeduction()
    {
        return netWasteDeduction;
    }
    /**
     * method returns value for householdNumber
     */
    public int householdNumber()
    {
        return householdNumber;
    }
    /**
     * method returns boolean value for paperRecycling
     */
    public boolean getPaperRecycling()
    {
        return paperRecycling;
    }
    /**
     * method returns boolean value for plasticRecycling
     */
    public boolean getPlasticRecycling()
    {
        return plasticRecycling;
    }
    /**
     * method returns boolean value for glassRecycling
     */
    public boolean getGlassRecycling()
    {
        return glassRecycling;
    }
    /**
     * method returns boolean value for cansRecycling
     */
    public boolean getCansRecycling()
    {
        return cansRecycling;
    }
}