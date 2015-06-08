
/**
 * The Calculations class performs addition, subtraction,
 * multiplication, division, and modulus operations on integers and
 * decimals.
 * 
 * ©BMT 2014
 * @author Bijan Tajmir
 * @version 09/18/2014
 */
public class CalculationsV5
{
    public static void main(String[ ] args)
    {
        int iNum1=4;
        int iNum2=8;
        double dNum1=23.51;
        double dNum2=8.9325;
        int iNum3=9;
        int iNum4=33;
        double dNum3=98.6; 
        double dNum4=47.0038;
        int iNum5=15;
        int iNum6=3;
        int iNum7=201; 
        double dNum5=3.14;
        double dNum6=5.0;
        int iNum8=48;
        int iNum9=8;
        double dNum7=212.0;
        double dNum8=32.0;
        int iNum10=23;
        int iNum11=15;
        double dNum9=3298.7;
        double dNum10=243.1;
        
        // Addition
        System.out.println("Addition");
        System.out.print(iNum1 +" plus "+iNum2+ " =");
        System.out.println(iNum1+iNum2);
        System.out.print(dNum1 +" plus "+dNum2+ " =");
        System.out.println(dNum1+dNum2);
        System.out.println("");
        //System.out.println();
        
        // Subtraction
        System.out.println("Subtraction");
        System.out.print(iNum3 +" minus "+iNum4+ " =");
        System.out.println(iNum3-iNum4);
        System.out.print(dNum3 +" minus "+dNum4+ " =");
        System.out.println(dNum3-dNum4);
        System.out.println("");
        //System.out.println();
        
        // Multiplication
        System.out.println("Multiplication");
        System.out.print(iNum5 +" times "+iNum6+" times "+iNum7+ " =");
        System.out.println(iNum5*iNum6*iNum7);  
        System.out.print(dNum5+" times "+dNum6+" times "+dNum6+ " =");
        System.out.println(dNum5*dNum6*dNum6);
        System.out.println("");
        //System.out.println();
        
        // Division
        System.out.println("Division");
        System.out.print(iNum8 +" divided by "+iNum9+" =");
        System.out.println(iNum8/iNum9);
        System.out.print(dNum7 +" divided by "+dNum8+" =");
        System.out.println(dNum7/dNum8);
        System.out.println("");
        //System.out.println();
         
        // Modulus operator
        System.out.println("Modulus");
        System.out.print(iNum10+" modulus "+iNum11+" =");
        System.out.println(iNum10%iNum11);
        System.out.print(dNum9+ " modulus "+dNum10+" =");
        System.out.println(dNum9%dNum10); 
        System.out.println("");
        //System.out.println();
        
        // 2.02 Lab Equations
        System.out.println("Lab Equations");
        System.out.print(iNum1+" plus "+iNum2+" minus "+iNum3+" times "+iNum4+" =");
        System.out.println(iNum1+iNum2*iNum4);
        System.out.println("");
        System.out.print(iNum4+" minus "+iNum3+" divided by "+iNum6+" modulus "+iNum1+" =");
        System.out.println(iNum4-iNum3/iNum6%iNum1);
        System.out.println("");
        //System.out.println();
       
    } // end of main method
} // end of class
