//  Account.java
//  Created by Shahein Tajmir
//  This is a class definition.  

import java.text.NumberFormat;

//*****************************************************************************************************************************
//  Class Name:  Account
//  Purpose:     This will create a bank-account type of class which will support deposits, withdrawals, and transfers of funds
//  Variables:   Account Name, Account Number, Account Balance
//  Methods:     Deposit, Withdrawal, Addition of Interest, Returning of Balance, Returning of Name, and a string descriptionof 
// 				  account.
//*****************************************************************************************************************************

public class Account
{
	private NumberFormat Format = NumberFormat.getCurrencyInstance();  //  Formats for currency
	
	private final double INTEREST_RATE = 0.035;  //  Interest rate on these accounts - 3.5%
	
	private long AccountNumber;
	private double Balance;
	private String Name;
	
	//************************************************************************************************************************
	//  Constructor Set Up
	//  This creates the account.  We will have two constructors: one that accepts Account Number, Name, and Initial Balance 
	//  and one that accepts only Account Number and Name with the default balance set at $0.00
	//************************************************************************************************************************
	
	public Account (String Owner, long Account, double InitialBalance)
	{
		Name = Owner;
		AccountNumber = Account;
		Balance = InitialBalance;
	}
	
	//  Constructor that defaults to 0
	
	public Account (String Owner, long Account)
	{
		Name = Owner;
		AccountNumber = Account;
		Balance = 0.00;
	}
	
	//************************************************************************************************************************
	//  Method Name:  Deposit
	//  Purpose:      Validates the deposit as an actual deposit.  If valid, deposits and updates the balance information
	//  Input:        A deposit (double)
	//  Returns:      Returns the updated balance (double)
	//************************************************************************************************************************
	
	public double Deposit (double DepositAmount)
	{
		if (DepositAmount < 0) // Checks for a negative deposit
		{
			System.out.println();
			System.out.println("The value entered is not a valid deposit.  Action not taken");
			System.out.println(AccountNumber + " " + Format.format(Balance) + " deposit not credited.");
		}
		else
		{
			Balance = DepositAmount + Balance;
		}
		
		return Balance;
	}
	
	//************************************************************************************************************************
	//  Method Name:  Withdrawal
	//  Purpose:      Validates the withdrawal as an actual withdrawal.  If valid, then checks to see if there are valid 
	//                funds for the withdrawal.  If so, updates the balance information.
	//  Input:        A withdrawal (double)
	//  Returns:      Returns the updated balance (double)
	//************************************************************************************************************************

	public double Withdrawal (double WithdrawalAmount)
	{
		if (WithdrawalAmount < 0)
		{
			System.out.println();
			System.out.println("The value entered is not a valid withdrawal.  Action not taken");
			System.out.println(AccountNumber + " " + Format.format(Balance) + " funds not withdrawn.");
		}
		else if (WithdrawalAmount > Balance)
		{
			System.out.println();
			System.out.println("Funds not available for withdrawal.  Action not taken");
			System.out.println(AccountNumber + " Balance: " + Format.format(Balance));
			System.out.println("Requested Amount: " + WithdrawalAmount); 
			System.out.println("Funds not withdrawn.");
		}
		else
		{
			Balance = Balance - WithdrawalAmount;
		}
		return Balance;
	}
	
	//************************************************************************************************************************
	//  Method Name:  Transfer
	//  Purpose:      Transfers from invoked account to the other.  Validates the withdrawal as possible.  If possible, then 
	//                deposits the money in the second account. 
	//  Input:        Account Money Comes From, Account Money Goes To, withdrawal (double)
	//  Returns:      Returns a string reflecting the new balances
	//************************************************************************************************************************

	public void Transfer (Account Act1, double Amount)
	{
		if (Amount > Balance )
		{
			System.out.println ("Transfer not possible.  Account " + AccountNumber + " does not have the requisite funds.");
			System.out.println ("Requested Amount:  " + Amount);
			System.out.println ("Actual Balance:    " + Balance );
		}
		else
		{
			Balance = Balance - Amount;
			Act1.Deposit(Amount);
			
			System.out.println ("Transfer successful!  New Account Information as follows:");
			System.out.println (AccountNumber + "\t" + Name + "\t" + Format.format(Balance) );
			System.out.println (Act1.Description() );
		}
	}
		
		
	
	//************************************************************************************************************************
	//  Method Name:  AddInterest
	//  Purpose:      Calculates and adds interest to an account
	//  Input:        None
	//  Returns:      Returns the updated balance (double)
	//************************************************************************************************************************

	public double AddInterest ()
	{
		Balance = Balance + (Balance * INTEREST_RATE);
		return Balance;
	}
	
	//************************************************************************************************************************
	//  Method Name:  GetBalance
	//  Purpose:      Gets the current balance of an account
	//  Input:        None
	//  Returns:      Returns the current balance (double)
	//************************************************************************************************************************
	
	public double GetBalance ()
	{
		return Balance;
	}
	
	//************************************************************************************************************************
	//  Method Name:  GetAccountNumber
	//  Purpose:      Gets the current Account Number of an account
	//  Input:        None
	//  Returns:      Returns the account number (long)
	//************************************************************************************************************************
	
	public long GetAccountNumber ()
	{
		return AccountNumber;
	}
	
	//************************************************************************************************************************
	//  Method Name:  Description
	//  Purpose:      Creates a string description of an account including Account Number, Owner, and Balance
	//  Input:        None
	//  Returns:      Returns the description (String)
	//************************************************************************************************************************
	
	public String Description ()
	{
		return (AccountNumber + "\t" + Name + "\t" + Format.format(Balance));
	}
}