//  Book.java
//  Created on Nov 15, 2004
//  Created by Shahein Tajmir
//

/**
 * @author Shahein Tajmir
 *
 * Created on Nov 15, 2004
 */
public class Book extends ReadingMaterial
{
    protected String author;
    protected int copyrightYear;
    
    Book(String title, String publisher, String publishedCity, int totalPages, 
         String author, int copyrightYear)
    {
        super (title, publisher, publishedCity, totalPages);
        this.author = author;
        this.copyrightYear = copyrightYear;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public int getCopyright()
    {
        return copyrightYear;
    }
    
    public String toString()
    {
        return super.toString() + "\nAuthor:\t\t\t" + author + "\nPublisher:\t\t" + publisher
        	+ "\nPublishing City:\t" + publishedCity + "\nCopyright:\t\t" + copyrightYear 
        	+ "\nPages:\t\t\t" + totalPages;
    }
}
