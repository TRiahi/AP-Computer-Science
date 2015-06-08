//  Student.java
//  Created by Shahein Tajmir
//  Student Class Definition

//  Class Name:  Student
//  Purpose:     To create an object that represents a student
//  Variables:   (String): First Name, Last Name | (Address): Home, School | 
//               (double) TestScore1, TestScore2, TestScore3
//  Methods:     (String) ToString, (Void) SetTestScore, (double) GetTestScore, (double) Average

import java.text.DecimalFormat;

public class Student
{
	private String FirstName, LastName;
	private Address Home, School;
	private double TestScore1, TestScore2, TestScore3;
	private DecimalFormat Format = new DecimalFormat ( "0.##");
	
	
	//  Constructors:  4
	//  There are tons of constructors because of the large amount of information required to make this class.  
	//  Entry of a TestScore when this class is created is intended to be optional, so there must be 4 constructors.
	//  Unentered Scores automatically default to 0.
	
	public Student (String First, String Last, Address AddressHome, Address AddressSchool) // No Test Scores Input
	{
		FirstName = First;
		LastName = Last;
		Home = AddressHome;
		School = AddressSchool;
		TestScore1 = 0;
		TestScore2 = 0;
		TestScore3 = 0;
	}
	
	//  1 Test Score Input
	public Student (String First, String Last, Address AddressHome, Address AddressSchool, double Score1) 
	{
		FirstName = First;
		LastName = Last;
		Home = AddressHome;
		School = AddressSchool;
		TestScore1 = Score1;
		TestScore2 = 0;
		TestScore3 = 0;
	}

	//  2 Test Scores Input
	public Student (String First, String Last, Address AddressHome, Address AddressSchool, double Score1, double Score2) 
	{
		FirstName = First;
		LastName = Last;
		Home = AddressHome;
		School = AddressSchool;
		TestScore1 = Score1;
		TestScore2 = Score2;
		TestScore3 = 0;
	}

	//  3 Test Scores Input
	public Student (String First, String Last, Address AddressHome, Address AddressSchool, double Score1, double Score2, 
	                double Score3) 
	{
		FirstName = First;
		LastName = Last;
		Home = AddressHome;
		School = AddressSchool;
		TestScore1 = Score1;
		TestScore2 = Score2;
		TestScore3 = Score3;
	}

	//*************************************************************************************
	//  Method Name:  SetTestScore
	//  Purpose:      Set a value into a test score variable
	//  Input:        (int) Test Score Number and (double) Test Score
	//  Output:			Void
	//*************************************************************************************
	
	public void SetTestScore(int TestNumber, double Score)
	{
		
		switch (TestNumber)
		{
		   case 1:	
				TestScore1 = Score;
		      break;
		   case 2:
		     	TestScore2 = Score;
		      break;
			case 3:
				TestScore3 = Score;
				break;
			default:
				System.out.println ();
				System.out.println ("Invalid Test Number.  Please use a number from 1 to 3.");
		}
	}
	
	//*************************************************************************************
	//  Method Name:  GetTestScore
	//  Purpose:      Returns the test score when given the number of test
	//  Input:        (int) Test Score Number 
	//  Output:			(double) Test Score 
	//*************************************************************************************
	
	public double GetTestScore (int Test)
	{
		double Score = 0;
		
		switch (Test)
		{
		   case 1:	
				Score = TestScore1;
		      break;
		   case 2:
		     	Score = TestScore2;
		      break;
			case 3:
				Score = TestScore3;
				break;
			default:
				System.out.println ();
				System.out.println ("Invalid Test Number.  Please use a number from 1 to 3.");
		}
		
		return Score;
	}

	//*************************************************************************************
	//  Method Name:  Average
	//  Purpose:      Returns the average of the test scores
	//  Input:        None 
	//  Output:			(double) Test Average
	//*************************************************************************************
	
	public double Average()
	{
		double Avg;
		
		Avg = (TestScore1 + TestScore2 + TestScore3) / 3;
		
		return Avg;
	}
	
	//*************************************************************************************
	//  Method Name:  ToString
	//  Purpose:      Returns a string with the student data 
	//  Input:        None
	//  Output:			(String) String of student data
	//*************************************************************************************
	
	public String toString()
	{
		String Data;
		
		Data = (FirstName + " " + LastName + "\n" + Home + "\n" + School + "\n" +
		        "Test Score 1:  " + Format.format(TestScore1) + "\n" + "Test Score 2:  " + Format.format(TestScore2) + 
				  "\n" + "Test Score 3:  " + Format.format(TestScore3) + "\n");
				  
		return Data;
	}
}