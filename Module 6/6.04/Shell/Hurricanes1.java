
/**
 * The purpose of this program is to assign the names of five
 * hurricanes to a String array and their corresponding categories
 * to a numeric array.  The program prints out the name and 
 * category of each hurricane and prints the average category.
 * 
 * @author B. Jordan 
 * @version 05/03/07
 */

public class Hurricanes1
{
    public static void main(String[] args)
    {    
        double categoryAverage = 0.0;
        int categorySum = 0;
        
        String [] hurricanes = {"Allen","Alicia","Diana","Bob","Danny"};
        int [] category = {3,3,3,1,1};
            
        for(int n = 0; n < hurricanes.length; n++)
        {
            categorySum += category[n];        
        }
        
        for(int n = 0; n < hurricanes.length; n++)
        {
            System.out.println("Hurricane " + hurricanes[n] + " was category: " + category[n]);
        }
        
        System.out.println();
        System.out.println("Average Cateogry: " + (double)categorySum/hurricanes.length);
    }
}
