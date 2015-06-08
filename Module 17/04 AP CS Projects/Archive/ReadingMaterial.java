//  ReadingMaterial.java
//  Created on Nov 15, 2004
//  Created by Shahein Tajmir
//  

/**
 * @author Shahein Tajmir
 *
 * Created on Nov 15, 2004
 */
public abstract class ReadingMaterial
{
    protected String title;
    protected String publisher;
    protected String publishedCity;
    protected int totalPages;
    
    ReadingMaterial(String title, String publisher, String publishedCity, int totalPages)
    {
        this.title = title;
        this.publisher = publisher;
        this.totalPages = totalPages;
        this.publishedCity = publishedCity;
    }
    
    public String toString()
    {
        return "Title:\t\t\t" + title;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    protected int getPages()
    {
        return totalPages;
    }
    
    protected String getPublisher()
    {
        return publisher;
    }
}
