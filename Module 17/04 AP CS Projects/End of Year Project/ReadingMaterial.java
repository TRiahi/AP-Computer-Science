// ReadingMaterial.java
//  Created on December 10, 2004
//  Created by Shahein Tajmir
//  This abstract provides the base for an inheritence structure containing child
//  	classes Book, Periodical, and Reference (which is derived from the book class)

public abstract class ReadingMaterial
{
    protected String title, publisher, publishedCity;

    protected int totalPages;

    //  Constructor; sets member variables equal to parameters
    ReadingMaterial(String title, String publisher, String publishedCity,
            int totalPages)
    {
        this.title = title;
        this.publisher = publisher;
        this.totalPages = totalPages;
        this.publishedCity = publishedCity;
    }

    //  Simple overriding of toString: Returns a string with the title of the
    // 		reading material
    public String toString()
    {
        return "Title:\t\t\t" + title;
    }

    //  ******************************************************************************************
    //  Methods that access variables during run-time
    //********************************************************************************************
    
    //  Member variable accessor: Returns the title
    public String getTitle()
    {
        return title;
    }

    //  Member variable accessor: Returns the totalPages
    public int getPages()
    {
        return totalPages;
    }

    //  Member variable accessor: Returns the publisher
    public String getPublisher()
    {
        return publisher;
    }

    //  Member variable accessor: Returns the published city
    public String getPublishedCity()
    {
        return publishedCity;
    }

    //******************************************************************************************
    //  Methods that set variables when creating new objects during run-time
    //******************************************************************************************

    //  Member variable accessor: Sets the title
    public void setTitle(String title)
    {
        this.title = title;
    }

    //  Member variable accessor: Sets the total pages
    public void setPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    //  Member variable accessor: Sets the publisher
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    //  Member variable accessor: Sets the published city
    public void setPublishedCity(String publishedCity)
    {
        this.publishedCity = publishedCity;
    }
}