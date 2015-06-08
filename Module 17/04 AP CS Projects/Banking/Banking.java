//  Banking.java
//  Created By Shahein Tajmir
//  This program is a nice testing of the Account Class I have written up

public class Banking
{
	public static void main (String [] args)
	{
		//  Creates a few instances of the Account Class
	
		Account Account1 = new Account ("Ted Murphy", 72354, 102.56);
		Account Account2 = new Account ("Jane Smith", 69713, 40.00);
		Account Account3 = new Account ("Edward Demsey", 93757, 759.32);
		Account Account4 = new Account ("Shahein Tajmir", 13678);
		
		Account1.Deposit (25.85);
	
		double SmithBalance = Account2.Deposit(500.00);
		System.out.println ("Smith balance after deposit:  " + SmithBalance);
	
		System.out.println ("Smith balance after withdrawal:  " + Account2.Withdrawal(430.75));
	
		Account3.Withdrawal (800.00);  //  Exceeds Balance Test
		Account3.Transfer(Account4, 759.32);
		
		Account1.AddInterest();
		Account2.AddInterest();
		Account3.AddInterest();
	
		System.out.println ();
		System.out.println (Account1.Description() );
		System.out.println (Account2.Description() );
		System.out.println (Account3.Description() );
		System.out.println (Account4.Description() );
	}
}