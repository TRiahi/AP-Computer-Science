// RGBColor.java
// Created by Shahein Tajmir
// Feb 19, 2005
// 


public class RGBColor
{
    //  pixel variables for initializing the pixel values
    //  a = transparency
    //  r = red component
    //  g = green component
    //  b = blue component
    private int a, r, g, b;
    
    RGBColor(int a, int r, int g, int b)
    {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
    public int getTransparency()
    {
        return a;
    }
    
    public int getRed()
    {
        return r;
    }
    
    public int getGreen()
    {
        return g;
    }
    
    public int getBlue()
    {
        return b;
    }
}
