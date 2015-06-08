// Book.java
//  Created on December 10, 2004
//  Created by Shahein Tajmir
//	This class inherits from ReadingMaterial and serves as a representation of a
//    book in a bookstore holding additional variables such as author and
//    copyrightyear

public class Book extends ReadingMaterial
{
    protected String author;

    protected int copyrightYear;

    //Constructor; sets member variables equal to parameters and calls
    // superclass constructor
    Book(String title, String publisher, String publishedCity, int totalPages,
                    String author, int copyrightYear)
    {
        super(title, publisher, publishedCity, totalPages);
        this.author = author;
        this.copyrightYear = copyrightYear;
    }

    //Much more complicated over-riding of toString that prints out a string in
    // the following format
    //Title: <Title>
    //Author: <Author>
    //Publisher: <Publisher>
    //Publishing City: <City>
    //Copyright: <Year>
    //Pages: <Pages>
    public String toString()
    {
        return super.toString() + "\nAuthor:\t\t\t" + author
                        + "\nPublisher:\t\t" + publisher
                        + "\nPublishing City:\t" + publishedCity
                        + "\nCopyright:\t\t" + copyrightYear + "\nPages:\t\t\t"
                        + totalPages;
    }

    //******************************************************************************************
    //  Methods that access variables during run-time
    //******************************************************************************************

    //  Member variable accessor: Returns the author
    public String getAuthor()
    {
        return author;
    }

    //  Member variable accessor: Returns the copyrightYear
    public int getCopyrightYear()
    {
        return copyrightYear;
    }

    //******************************************************************************************
    //  Methods that set variables when creating new objects during run-time
    //******************************************************************************************

    //  Member variable accessor: Sets the author
    public void setAuthor(String author)
    {
        this.author = author;
    }

    //  Member variable accessor: Sets the copyright year
    public void setCopyrightYear(int copyrightYear)
    {
        this.copyrightYear = copyrightYear;
    }
}