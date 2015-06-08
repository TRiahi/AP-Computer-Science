
/**
 * The Calculations class performs various problems which document knowledge and understanding of the order of operations.
 * 
 * ©FLVS 2007
 * @author Bill Jordan
 * @version 01/19/07
 */
public class CalculationsVx
{
    public static void main(String[ ] args)
    {
        // Problem 1
        System.out.println("Problem 1");
        System.out.println("15 divided by 2.5 times -2 plus 10/5 equals "+ (15/2.5*-2+10/5));
        System.out.println("");
        //System.out.println();
        
        // Problem 2
        System.out.println("Problem 2");
        System.out.println("234 minus (234 divided by 6 modulus 12)+3 equals "+ (234-(234/6%12)+3));
        System.out.println("");
        //System.out.println();
        
        // Problem 3
        System.out.println("Problem 3");
        System.out.println("(46.2 divided by 11) minus 3 plus 24 modulus (17 minus 2 times 3) equals "+ (46.2/11-3+24%(17-2*3)));  
        System.out.println("");
        //System.out.println();
        
        // Problem 4
        System.out.println("Problem 4");
        System.out.println("480 divided by 10 divided by 12 plus 200*.5 minus 20 modulus 8 "+ (480/10/12+200*.5-20%8)); 
        System.out.println("");
        //System.out.println() 
            
    } // end of main method
} // end of class

