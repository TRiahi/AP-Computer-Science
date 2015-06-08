/**
 * The CurrencyConversion class converts an amount of money from a specific
 * country into the equivalent currency of another country given the current
 * exchange rate.
 *
 *
 * ©BMT 2014
 * @Author Bijan Tajmir
 * @version 09/30/2014
 */
public class CurrencyConversionV1
{
    public static void main(String [ ] args)
    {
        double startingUsDollars = 5000.00;		// local variable for US Dollars
        double pesosspent = 7210.25;            // local variable for Mexican pesos spent
        double pesoExchangeRate = 13.45;        // local variable for exchange rate of Pesos to one dollar
        double dollarsSpentInMexico = 0.0;      // local variable for dollars spent in Mexico
        double remainingUsDollarsM = 0.0;        // local variable for US Dollars remaining, Mexico
        double yenspent = 99939.75;             // local variable for Jappanese Yen spent
        double yenexchangerate = 109.87;        // local variable for exchange rate of yen to one dollar  
        double eurosspent = 624.95;             // local variable for Euros spent in France
        double euroexchangerate = .79;          // local variable for exchange rate of euros to one dollar
        double remainingUsDollarsJ = 0.0;        // local variable for US Dollars remaining, Japan
        double remainingUsDollarsE = 0.0;        // local variable for US Dollars remaining, Europe
        double remainingUsDollars = 0.0;         // local variable for US Dollars remaining 
         
        // purpose of program
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("This program converts an amount of money");
        System.out.println("from a specific country into the equivalent");
        System.out.println("currency of another country given the current");
        System.out.println("exchange rate.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        // conversion for Mexican pesos
        remainingUsDollarsM = pesosspent / pesoExchangeRate;

        // convesion for Japanese yen
        remainingUsDollarsJ = yenspent / yenexchangerate;
        
        // conversion for Euros
        remainingUsDollarsE = eurosspent / euroexchangerate;
         
        // remaiing U.S. dollars after purchases
        remainingUsDollars = startingUsDollars - remainingUsDollarsM - remainingUsDollarsJ - remainingUsDollarsE; 
          
        //print output to the screen
        System.out.println("Starting U.S. Dollars: " + startingUsDollars);
        System.out.println("U.S. Dollars spent in Mexico: " + remainingUsDollarsM);
        System.out.println("U.S. Dollars spent in Japan: " + remainingUsDollarsJ);
        System.out.println("U.S. Dollars spent in France: " + remainingUsDollarsE);  
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Remaining U.S. Dollars: " + remainingUsDollars);

        // Complete the code below. Replace th 0's for totalItem and fundsRemaining
        // with the proper calculations. Casting, integer division and the modulus
        // operator needed. Do not worry about extra decimal places for the dollar amounts.

 		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Souvenir Purchases");
		System.out.println(" (all values in US Dollars) ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		//Calculations for Souvenir #1
		int costItem1 = 4;  						//cost per item of first souvenir
		int budget1 = 50;   						//budget for first item
		int totalItem1 = 0; 		//how many items can be purchased
		double fundsRemaining1 = 0.0;  //how much of the budget is left
         
		totalItem1 = budget1 / costItem1;
      fundsRemaining1 = 50%4;
      
      System.out.println("Item 1");
		System.out.println("   Cost per item: $" + costItem1 );
		System.out.println("   Budget: $"+ budget1);
		System.out.println("   Total items purchased: " +  totalItem1);
		System.out.println("   Funds remaining: $"  +  fundsRemaining1);
      
		//Calculations for Souvenir #2
		double costItem2 = 32.55;  						//cost per item of second souvenir
		int budget2 = 713;   							//budget for second item
		int totalItem2 = 0; 	//how many items can be purchased
		double fundsRemaining2 = 0.0;  	//how much of the budget is left

      totalItem2 = budget2 / (int)costItem2;
      fundsRemaining2 = 713%32.55;
      
		System.out.println("Item 2");
		System.out.println("   Cost per item: $" + costItem2 );
		System.out.println("   Budget: $"+ budget2);
		System.out.println("   Total items purchased: " +  totalItem2);
		System.out.println("   Funds remaining: $"  +  fundsRemaining2);

    } // end of main method
} // end of class

