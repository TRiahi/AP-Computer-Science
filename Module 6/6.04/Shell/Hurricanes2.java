/**
 * 
 *
 * Bijan Tajmir
 * 12/19/2014
 *
 */

//importing required libs
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Hurricanes2
{
    
    public static void main(String[] args)throws IOException
    {
        
        //declare and initialize variables
        int i = 0;
        int arrayLength = 59;
        int [] wind = new int[arrayLength];
        int [] year = new int[arrayLength];
        int [] category = new int[arrayLength];
        int [] pressure = new int[arrayLength];
        int windAvg = 0;
        int windMax = 0;
        int pressureAvg = 0;
        int pressureMax = 0;
        int catAvg = 0;
        int catMax = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int c4 = 0;
        int c5 = 0;
        String [] name = new String[arrayLength];
        String [] month = new String[arrayLength];
        double [] windMPH = new double[arrayLength];
        
        //importing file into the scanner
        File fileName = new File("data1.txt");
        Scanner inFile = new Scanner(fileName);
        
        //load all the info into the array
        while (inFile.hasNext()){
           
           year[i] = inFile.nextInt();
           month[i] = inFile.next();
           pressure[i] = inFile.nextInt();
           wind[i] = inFile.nextInt();
           name[i] = inFile.next();
           i++;
            
        }
        
        //getting the first value 
        int pressureMin = pressure[0];
        int windMin = wind[0];
        
        //resetting i and closing file stream
        i = 0;
        inFile.close();
        
        //loop to find category and adding to total for each category
        for (i = 0; i < wind.length; i++){
            
            windMPH[i] = wind[i] * 1.15;
            windAvg += windMPH[i];
            
            pressureAvg += pressure[i];
            
            if (windMPH[i] > 74 && windMPH[i] < 95){
            
                category[i] = 1;
                catAvg += category[i];
                c1++;
                
            }else if(windMPH[i] > 96 && windMPH[i] < 110){
                
                category[i] = 2;
                catAvg += category[i];
                c2++;
                
            }else if(windMPH[i] > 111 && windMPH[i] < 129){
                
                category[i] = 3;
                catAvg += category[i];
                c3++;
                
            }else if(windMPH[i] > 130 && windMPH[i] < 156){
                
                category[i] = 4;
                catAvg += category[i];
                c4++;
                
            }else if(windMPH[i] > 157){
                
                category[i] = 5;
                catAvg += category[i];
                c5++;
                
            }
            
        }
        
        int catMin = category[0];
        
        //getting max and mins
        for (i = 0; i < pressure.length; i++){
            
            if (pressure[i] > pressureMax){
                
                pressureMax = pressure[i];
                
            }
            
        }
        
        for (i = 0; i < wind.length; i++){
            
            if (wind[i] > windMax){
                
                windMax = wind[i];
                
            }
            
        }
        
        for (i = 0; i < category.length; i++){
            
            if (category[i] > catMax){
                
                catMax = category[i];
                
            }
            
        }
        
        for (i = 0; i < pressure.length; i++){
            
            if (pressure[i] < pressureMin){
                
                pressureMin = pressure[i];
                
            }
            
        }
        
        for (i = 0; i < wind.length; i++){
            
            if (wind[i] < windMin){
                
                windMin = wind[i];
                
            }
            
        }
        
        for (i = 0; i < category.length; i++){
            
            if (category[i] < catMin){
                
                catMin = category[i];
                
            }
            
        }
        
        //printing out the correct structure
        System.out.println("                      Hurricanes 1980 - 2006");
        System.out.println();
        System.out.println("Year     Hurricane    Category     Pressure (mb)     Wind Speed (mph)");
        System.out.println("=====================================================================");

        for (i = 0; i < year.length; i++){
            
            System.out.printf("%d%13s%10d%16d%18d\n" , year[i] , name[i] , category[i] , pressure[i] , (int)windMPH[i]);
            
        }
        
        windAvg = windAvg / windMPH.length;
        catAvg = catAvg / category.length;
        pressureAvg = pressureAvg / pressure.length;
        System.out.println("=====================================================================");
        System.out.printf("%s%20d%16d%18d\n" , "Average" , catAvg , pressureAvg , windAvg / 2);
        System.out.printf("%s%20d%16d%18d\n" , "Maximum" , catMax , pressureMax , windMax);
        System.out.printf("%s%20d%16d%18d\n" , "Minimum" , catMin , pressureMin , windMin);
        System.out.println();
        System.out.println("Number of Cateogry 1: " + c1);
        System.out.println("Number of Cateogry 2: " + c2);
        System.out.println("Number of Cateogry 3: " + c3);
        System.out.println("Number of Cateogry 4: " + c4);
        System.out.println("Number of Cateogry 5: " + c5);
        
   
for (i = 0; i <= 10; i++) {
if ((i % 3) == 1) {
System.out.print(i + " ");
}
}
    }//end main()
}//end Hurricanes