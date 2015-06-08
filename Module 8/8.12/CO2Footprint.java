/**
 * Methods and constructor for calculating the CO2 emitted from waste.
 * 
 * @author Bijan Tajmir
 * @version 12/18/2014
 */
public class CO2Footprint
{
   private int numBulbs, numPeople; //Bulbs, Waste
   private double bulbReduc; //Bulbs
   private double pricePerKWH, monthlyBill, electricityCO2; //Electricity
   private double grossWasteEmission, netWasteEmission, wasteReduction;   //..and waste
   private double myGallonsUsed, myPoundsCO2FromGas; //Gasoline
   private boolean recyclePaper, recyclePlastic, recycleGlass, recycleCans; //Waste Reduction
    
    /**
     * Default constructor for the CO2FromWaste class.
     * 
     */
    public CO2Footprint(double gallons, double kwh, double bill, int people, boolean paper, 
            boolean plastic, boolean glass, boolean cans, int bulbamt){
        myGallonsUsed = gallons;
        pricePerKWH = kwh;
        monthlyBill = bill;
        numPeople = people;
        recyclePaper = paper;
        recyclePlastic = plastic;
        recycleGlass = glass;
        recycleCans = cans;
        numBulbs = bulbamt;
    }
    
    
    //Calculation of new bulbs
    public double calcBulbReduc(){
       bulbReduc = (((double)(numBulbs)) * 1.37 * 73);
       return bulbReduc;
    }
    
    
    //start Gasoline emission
    
    public double getGallonUsed(){
        return myGallonsUsed;
    }
    
    
    public double calcPoundsCO2FromGas(){
        myPoundsCO2FromGas = (myGallonsUsed * (8.78E-3) * 2000);
        return myPoundsCO2FromGas;
    }
    
    //end Gasoline emission
    
    
    
    //Start electricity emission
    
    double calcElectricityCO2(){
        electricityCO2 = (monthlyBill / pricePerKWH) * 1.37 * 12;
        return electricityCO2;
    }
    //End electricity emission
    
    
    
    
    
    //start waste emission
    public int getNumPeople(){
        return numPeople;
    }
    
    public boolean getRecyclingPaper(){
        return recyclePaper;
    }
    
    public boolean getRecyclingPlastic(){
         return recyclePlastic;   
    }
    
    public boolean getRecyclingGlass(){
        return recycleGlass;
    }
    
    public boolean getRecyclingCans(){
       return recycleCans;
    }
    
    
    /**
     * Method to calculate Gross Waste Emission of CO2.
     * 
     */
    public double calcGrossWasteEmission(){
        return (numPeople * 1018);
    }
    
        /**
     * Method to calculate Waste Reduction.
     */
    public double calcWasteReduction(){
        wasteReduction = 0;
        
        if(recyclePaper == true){
         wasteReduction += (numPeople * 184);
        }
        if(recyclePlastic == true){
         wasteReduction += (numPeople * 25.6);
        }
        if(recycleGlass == true){
         wasteReduction += (numPeople * 46.6);
        }
        if(recycleCans == true){
         wasteReduction += (numPeople * 165.8);
        } 
        return wasteReduction;
    }
    /**
     * Method to calculate the Net Waste Reduction using the last two methods.
     */
    public double calcNetWasteEmission(){
        calcGrossWasteEmission();
        calcWasteReduction();
        return netWasteEmission = calcGrossWasteEmission() + calcPoundsCO2FromGas() + calcElectricityCO2() - calcWasteReduction() - calcBulbReduc();
    }
    
        public double getGrossWasteEmission() {
        return grossWasteEmission;
    }

    public double getWasteReduction() {
        return wasteReduction;
    }

    public double getNetWasteEmission() {
        return netWasteEmission;
    }
    
    //end Waste portion
    
}
