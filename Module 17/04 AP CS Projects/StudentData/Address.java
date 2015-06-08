//  Address.java
//  Created by Shahein Tajmir
//  This is a class definition

//  Class Name:  Address
//  Purpose:     Represent an address as a object
//  Variables:   (String): Street Address, City, and State | (Long): Zip Code
//  Methods:     toString - Returns a string of the address data

public class Address
{
	// Variables of class
	private String StreetAddress, City, State;
	private long ZipCode;
	
	//  1 Constructor
	//  1 Requires values for  Street Address, City, State, and Zip
	
	public Address (String Address, String Area, String StateOfPerson, long Zip)
	{
		StreetAddress = Address;
		City = Area;
		State = StateOfPerson;
		ZipCode = Zip;
	}
	
	//*********************************************************************************
	//  Method Name:  toString
	//  Purpose:      Return a string of data of person
	//  Input:        None
	//  Returns:      A string with the data of the person
	//*********************************************************************************
	
	public String toString()
	{
		String Data;
		
		Data = (StreetAddress + "\n" + City + ", " + State + "\n" + ZipCode);
		
		return Data;
	}
}