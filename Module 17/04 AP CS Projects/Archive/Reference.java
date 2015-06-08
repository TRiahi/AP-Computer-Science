//  Reference.java
//  Created on Nov 15, 2004
//  Created by Shahein Tajmir
//


public class Reference extends Book
{
    protected String typeOfReference;
    
    Reference(String title, String publisher, String publishedCity,
            int totalPages, String author, int copyrightYear, String typeOfReference)
    {
        super(title, publisher, publishedCity, totalPages, author, copyrightYear);
        this.typeOfReference = typeOfReference;
    }
    
    public String getTypeOfReference()
    {
        return typeOfReference;
    }
    
    public String toString()
    {
        return super.toString() + "\nType:\t\t\t" + typeOfReference;
    }
}
