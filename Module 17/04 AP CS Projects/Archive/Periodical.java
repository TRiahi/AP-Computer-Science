//  Periodical.java
//  Created on Nov 15, 2004
//  Created by Shahein Tajmir
//

/**
 * @author Shahein Tajmir
 * 
 * Created on Nov 15, 2004
 */
public class Periodical extends ReadingMaterial
{
    protected String typeOfPeriodical;
    protected int numberOfArticles;
    protected int issue, volume;

    Periodical(String title, String publisher, String publishedCity,
            int totalPages, String typeOfPeriodical, int numberOfArticles,
            int issue, int volume)
    {
        super (title, publisher, publishedCity, totalPages);
        this.typeOfPeriodical = typeOfPeriodical;
        this.numberOfArticles = numberOfArticles;
        this.issue = issue;
        this.volume = volume;
    }
    
    public String getType()
    {
        return typeOfPeriodical;
    }
    
    public int getNumberOfArticles()
    {
        return numberOfArticles;
    }
    
    public int getIssue()
    {
        return issue;
    }
    
    public int getVolume()
    {
        return volume;
    }
    
    public String toString()
    {
        return super.toString() + "\nPublisher:\t\t" + publisher + "\nPublishing City:\t"
        	+ publishedCity + "\n\t\t\t" + typeOfPeriodical + "\nAritcles:\t\t" 
        	+ numberOfArticles + "\nPages:\t\t\t" + totalPages + "\nVolume:\t\t\t" + volume 
        	+ "\nIssue:\t\t\t" + issue + "\n--------------------------------------";
    }
}