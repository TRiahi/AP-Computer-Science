/**
 * MeasuermentConverter_v1 converts to and from Metric and English
 * units of measure.
 *
 *      Sample Calculation:
 *        1 mile = 5280 ft,
 *        therefore    6230 ft / 5280 = 1.17992 miles
 *          and    1.179 miles * 5280 = 6225.12 ft
 *
 * ©FLVS 2007
 * @author B. Jordan
 * @version 01/19/07
 *
 * Modified by Bijan Tajmir
 * Date: (9/19/2014)
 */
public class MeasurementConverterV1
{
    public static void main(String[ ] args)
    {
        //local variable declarations 
        double miles;             // distance in miles
        double feet;                    // distance in feet
        double feetPerMile = 5280;      //number of feet per 1 mile
        double milesperkilometer = 1.609;      //number of miles in 1 kilometer
        double kilometers;               // distance in kilometers
        double pounds;                // weight in pounds
        double kilograms;             // weight in kilograms 
        double poundsperkilogram = 0.453592;     //number of pounds in 1 kilogram         
        double gallons;               // amount in gallons
        double liters;                // amount in liters
        double literspergallon = 3.78541;    // number of liters per gallon
        double inches;                       // distance in inches
        double inchesperfoot= 12;           // amount of inches in one foot  
        
        //convert feet to miles
        feet = 6230;
        miles = feet / feetPerMile;
        System.out.println(feet + " ft. = " + miles + " mi.");


        //convert miles to feet
        miles = 5.0;
        feet = miles * feetPerMile;
        System.out.println(miles+" mi. = "+ feet +" ft. "); 
        

        //convert miles to kilometers
        miles = 7.0;
        kilometers= miles * milesperkilometer;
        System.out.println(miles+" mi. = "+ kilometers +" km. ");   


        //convert kilometers to miles
        kilometers= 8.7;
        miles= kilometers / milesperkilometer;
        System.out.println(kilometers+" km. = "+ miles +" mi. ");  
        
        
        //convert pounds to kilograms
        pounds= 12.0;
        kilograms= pounds * poundsperkilogram;
        System.out.println(pounds+" Ibs. = "+ kilograms +" kg. "); 
        
        
       //convert kilograms to pounds 
       kilograms= 1997.0;
       pounds= kilograms / poundsperkilogram;
       System.out.println(kilograms+" kg. = "+ pounds +" Ibs. "); 

        
      //convert gallons to liters
      gallons= 1988.0;
      liters= gallons * literspergallon;
      System.out.println(gallons+" gal. ="+ liters +" L. ");
      
      //convert liters to gallons
      liters= 1981.0;
      gallons= liters / literspergallon;
      System.out.println(liters+" L. ="+ gallons +" L. ");
      
      //convert feet to inches
      feet= 1952.0;
      inches= feet * inchesperfoot;
      System.out.println(feet+" ft. ="+ inches +" in. ");
      
      
      //convert inches to feet
      inches= 1995.0;
      feet= inches / inchesperfoot;
      System.out.println(inches+" in. ="+ feet +" ft. ");
      
      
       }//end of main method
}//end of class

