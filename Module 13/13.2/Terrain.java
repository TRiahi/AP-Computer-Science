/**
 * Blank terrain.
 * 
 * @author Bijan Tajmir
 * @version 3/1/2015
 */
public class Terrain
{
    // instance variables 
    private int length, width;

    /**
     * Constructor for objects of class terrain
     */
    public Terrain(int l, int w)
    {
        // initialise instance variables
        length = l;
        width = w;
    }


    public String getTerrain()
    {
        return "Land has dimensions " + length + " X " + width;
    }


       
}