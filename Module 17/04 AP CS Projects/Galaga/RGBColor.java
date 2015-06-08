//  RGBColor.java
//  Created by Shahein Tajmir
//  Feb 19, 2005
//  Class that encapsulates a color based on transparency, red, green, and
//    blue values.

public class RGBColor
{
    //  pixel variables for initializing the pixel values
    //  a = transparency
    //  r = red component
    //  g = green component
    //  b = blue component
    private int a, r, g, b;
    
    //******************************************************************************
    //  Constructor - Assigns the needed variables
    //******************************************************************************
    public RGBColor(int a, int r, int g, int b)
    {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    //******************************************************************************
    //  Returns the Transparency
    //******************************************************************************
    public int getTransparency()
    {
        return a;
    }
    
    //******************************************************************************
    //  Returns the Red Value
    //******************************************************************************
    public int getRed()
    {
        return r;
    }
    
    //******************************************************************************
    //  Returns the Green Value
    //******************************************************************************
    public int getGreen()
    {
        return g;
    }
    
    //******************************************************************************
    //  Returns the Blue Value
    //******************************************************************************
    public int getBlue()
    {
        return b;
    }
}
