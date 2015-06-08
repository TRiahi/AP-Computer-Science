/**
 * Movie Interface
 * 
 * @author Bijan Tajmir
 * 
 */
public class Movie4
{
    private String title;
    private int year;
    private String studio;
    public Movie4(String title, int year, String studio)
    {
        this.title = title;
        this.year = year;
        this.studio = studio;
    }
    public String toString()
    {
        String string = title + ", " + year + ", " + studio;
        return string;
    }
    public String getTitle()
    {
        return title;
    }
    public int getYear()
    {
        return year;
    }
    public String getStudio()
    {
        return studio;
    }
    public void setStudio(String a)
    {
        studio = a;
    }
}