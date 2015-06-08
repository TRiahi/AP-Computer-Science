
/**
 * The purpose of this program is to calculate the average grade each time new grades are added to the total.
 * 
 * ©BMT 2014
 * @author B. Tajmir 
 * @version 9/23/2014
 */
public class GradesV2
{
    public static void main(String[ ] args)
    {
        //local variables       
        int numTests = 0;            //counts number of tests
        int testgrade = 0;           //individual test grade
        int totalpoints = 0;        //total points for all tests   
        double average = 0.0;         //average grade
             
                
        //calculate the average grade of test 1
        testgrade = 97;         //test grade 
        totalpoints += testgrade;  //add the test grade to the toal points
        numTests++;             //number of tests increased by one
        average = ((double)totalpoints / (double)numTests);  //calculate the average by dividing the totalpoints by the numTests
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average);
        
        //calcualte the average grade of test 2
        testgrade = 79;          
        totalpoints += testgrade;
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average);   
        
        //calcualte the average grade of test 3
        testgrade = 83;           
        totalpoints += testgrade;
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average);
        
        //calcualte the average grade of test 4
        testgrade = 88;           
        totalpoints += testgrade; 
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average);  
        
        //calcualte the average grade of test 5
        testgrade = 81;           
        totalpoints += testgrade; 
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average);   
   
        //calcualte the average grade of test 6
        testgrade = 78;           
        totalpoints += testgrade; 
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average); 
   
   
        //calcualte the average grade of test 7
        testgrade = 100;           
        totalpoints += testgrade; 
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average); 
       
        //calcualte the average grade of test 8
        testgrade = 93;           
        totalpoints += testgrade; 
        numTests++;
        average = ((double)totalpoints / (double)numTests);
        System.out.print(" Number of tests = " + numTests);
        System.out.print("   New Test Grade: " + testgrade);
        System.out.print("   Total Points: " + totalpoints);
        System.out.println("   Average Score: " + average); 
    
    }//end of main method
}//end of class
