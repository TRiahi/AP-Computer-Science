// Reference.java
//  Created on December 10, 2004
//	Created by Shahein Tajmir
//	This class inherits from book and serves as a representation of a
//	reference book in a bookstore holding additional variables such as type of
//	reference--Dictionary, Encyclopedia, Almanac, or Thesaurus

public class Reference extends Book
{
    protected String typeOfReference;

    //  Constructor; sets member variables equal to parameters and calls
    // superclass constructor
    Reference(String title, String publisher, String publishedCity,
                    int totalPages, String author, int copyrightYear,
                    int typeOfReference)
    {
        super(title, publisher, publishedCity, totalPages, author,
                        copyrightYear);
        setTypeOfReference(typeOfReference);
    }

    //  Simple overriding of parent toString. Calls the parent toString (see
    // book) and attaches to the end of the string the "type of reference"
    public String toString()
    {
        return super.toString() + "\nType:\t\t\t" + typeOfReference;
    }

    //******************************************************************************************
    //  Methods that access variables during run-time
    //******************************************************************************************

    //  Member variable accessor: Returns the type of reference
    public String getTypeOfReference()
    {
        return typeOfReference;
    }
    
    //******************************************************************************************
    //  Methods that set variables when creating new objects during run-time
    //******************************************************************************************

    //  Member variable accessor: Sets the type of reference
    public void setTypeOfReference(int type)
    {
        //Integer Categories of References
        // 1 = Dictionary
        // 2 = Encyclopedia
        // 3 = Almanac
        // 4 = Thesarus
        
        if (type == 1)
            typeOfReference = "Dictionary";
        else if (type == 2)
            typeOfReference = "Encyclopedia";
        else if (type == 3)
            typeOfReference = "Alamanac";
        else if (type == 4)
            typeOfReference = "Thesarus";
        else 
        {
        }
    }

}