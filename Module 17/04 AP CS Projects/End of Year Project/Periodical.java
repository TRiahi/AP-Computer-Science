// Periodical.java
//  Created on December 10, 2004
//  Created by Shahein Tajmir
//  This class inherits from ReadingMaterial and serves as a representation of a
//  periodical in a bookstore holding additional variables such as type of
// periodical--Magazine, Newspaper, or Journal--, number of articles, issue, and
// volume

public class Periodical extends ReadingMaterial
{
    protected String typeOfPeriodical;

    protected int numberOfArticles;
    
    String issue, volume;

    //  Constructor; sets member variables equal to parameters and calls
    // superclass constructor
    Periodical(String title, String publisher, String publishedCity,
                    int totalPages, int typeOfPeriodical,
                    int numberOfArticles, String volume, String issue)
    {
        super(title, publisher, publishedCity, totalPages);
        setTypeOfPeriodical(typeOfPeriodical);
        this.numberOfArticles = numberOfArticles;
        this.issue = issue;
        this.volume = volume;
    }

    //  Much more complicated over-riding of toString that prints out a string in
    // the following format
    //Title: <Title>
    //Publisher: <Publisher>
    //Publishing City: <City>
    //Number of Articles: <Number>
    //Pages: <Pages>
    //Volume: <Volume>
    //Issue: <Issue>
    public String toString()
    {
        return super.toString() + "\nPublisher:\t\t" + publisher
                        + "\nPublishing City:\t" + publishedCity + "\n\t\t\t"
                        + typeOfPeriodical + "\nArticles:\t\t"
                        + numberOfArticles + "\nPages:\t\t\t" + totalPages
                        + "\nVolume:\t\t\t" + volume + "\nIssue:\t\t\t" + issue;
    }

    //******************************************************************************************
    //  Methods that access variables during run-time
    //******************************************************************************************

    //  Member variable accessor: Returns the type of periodical
    public String getType()
    {
        return typeOfPeriodical;
    }

    //  Member variable accessor: Returns the number of articles
    public int getNumberOfArticles()
    {
        return numberOfArticles;
    }

    //  Member variable accessor: Returns the issue number
    public String getIssue()
    {
        return issue;
    }

    //  Member variable accessor: Returns the volume number
    public String getVolume()
    {
        return volume;
    }

    //******************************************************************************************
    //  Methods that set variables when creating new objects during run-time
    //******************************************************************************************

    //  Member variable accessor: Sets the type of Periodical
    public void setTypeOfPeriodical(int type)
    {
        // Integer Categories of Periodicals
        // 1 = Magazine
        // 2 = Newspaper
        // 3 = Journal
        if (type == 1)
            typeOfPeriodical = "Magazine";
        else if (type == 2)
            typeOfPeriodical = "Newspaper";
        else if (type == 3)
            typeOfPeriodical = "Journal";
        else
        {
        }
    }

    //  Member variable accessor: Sets the number of articles
    public void setNumberOfArticles(int numberOfArticles)
    {
        this.numberOfArticles = numberOfArticles;
    }

    //  Member variable accessor: Sets the type of Periodical
    public void setIssue(String issue)
    {
        this.issue = issue;
    }

    //  Member variable accessor: Sets the type of Periodical
    public void setVolume(String volume)
    {
        this.volume = volume;
    }
}