/**
 * Rectangle3 demo
 * 
 *
 */
public class Rectangle3
{
    // instance variables 
    private int length;
    private int width;

    /**
     * Constructor for objects of class rectangle
     */
    public Rectangle3(int l, int w)
    {
        // initialise instance variables
        length = l;
        width = w;
    }

    // return the height
    public int getLength()
    {
        return length;
    }
    public int getWidth()
    {
        return width;
    }
    
    public boolean equals(Rectangle3 r)
    {
        if (length == r.getLength()){
            if (width == r.getWidth()){
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        return "Rectangle - " + length + " x " + width;
        }
    }