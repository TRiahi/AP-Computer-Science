
/**
 * This program prints the ASCII characters that correspond to ASCII values, and
 * prints the ASCII values that correspond to specific ASCII characters.
 * 
 * Notice that (int) is used to cast a character literal to its corresponding ASCII value, and
 * that (char) is used to cast an ASCII value to its corresponding character literal.
 * 
 * ©FLVS 2007
 * @author B. Jordan
 * @version 01/19/07
 */
public class ShowASCII
{
    public static void main(String[ ] args)
    {   
        // Local Variable Declarations 
        char letterA = 'A';
        char aDash = '-';
        char blankSpace = ' '; //there is a blank space between quotes
        char eighthDigit = '8';
        System.out.println(letterA);
        System.out.println(aDash);
        System.out.println(blankSpace);
        System.out.println(eighthDigit);
        System.out.println();
      
        //cast a character literal to its integer ASCII value
        System.out.println("The ASCII code for " + 'A' + " is " + (int)'A');
        System.out.println("The ASCII code for " + '9' + " is " + (int)'9');
        System.out.println("The ASCII code for " + 'B' + " is " + (int)'B'); 
        System.out.println("The ASCII code for " + 'I' + " is " + (int)'I'); 
        System.out.println("The ASCII code for " + 'J' + " is " + (int)'J'); 
        System.out.println("The ASCII code for " + 'A' + " is " + (int)'A'); 
        System.out.println("The ASCII code for " + 'N' + " is " + (int)'N');
        System.out.println();
        
        //cast an integer ASCII value to its corresponding character literal
        System.out.println("83 is the ASCII code for " + (char)83);
        System.out.println("101 is the ASCII code for " + (char)101);
        System.out.println("110 is the ASCII code for " + (char)110);
        System.out.println("100 is the ASCII code for " + (char)100);
        System.out.println("32 is the ASCII code for " + (char)32);
        System.out.println("121 is the ASCII code for " + (char)121);
        System.out.println("111 is the ASCII code for " + (char)111);
        System.out.println("117 is the ASCII code for " + (char)117);
        System.out.println("114 is the ASCII code for " + (char)114);
        System.out.println("32 is the ASCII code for " + (char)32);
        System.out.println("116 is the ASCII code for " + (char)116);
        System.out.println("101 is the ASCII code for " + (char)101);
        System.out.println("97 is the ASCII code for " + (char)97);
        System.out.println("99 is the ASCII code for " + (char)99);
        System.out.println("104 is the ASCII code for " + (char)104);
        System.out.println("101 is the ASCII code for " + (char)101);
        System.out.println("114 is the ASCII code for " + (char)114);
        System.out.println("97 is the ASCII code for " + (char)97);
        System.out.println("110 is the ASCII code for " + (char)110);
        System.out.println("32 is the ASCII code for " + (char)32);
        System.out.println("101 is the ASCII code for " + (char)101);
        System.out.println("109 is the ASCII code for " + (char)109);
        System.out.println("97 is the ASCII code for " + (char)97);
        System.out.println("105 is the ASCII code for " + (char)105);
        System.out.println("108 is the ASCII code for " + (char)108);
        System.out.println("32 is the ASCII code for " + (char)32);
        System.out.println("116 is the ASCII code for " + (char)116);
        System.out.println("111 is the ASCII code for " + (char)111);
        System.out.println("100 is the ASCII code for " + (char)100);
        System.out.println("97 is the ASCII code for " + (char)97);
        System.out.println("121 is the ASCII code for " + (char)121);

        
        
        
        
        
        
        System.out.println();
        
    }//end of main method
}//end of class
