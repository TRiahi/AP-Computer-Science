//  PlayerShip.java
//  Created by Shahein Tajmir
//  Feb 21, 2005
//  Last Updated:  3/8/05
//  This creates the Player sprite by executing a humongous for-loop 
//    which sets all the necessary pixels to appropriate values. 
//    The humongous array is then converted into an image object for
//    use by the program.
import java.awt.*;

public class PlayerShip extends Sprite
{
    //********************************************************************
    //  Constructor - Assigns Variables as needed and starts the massive
    //    for-loops that initialize the image
    //********************************************************************
    public PlayerShip(int x, int y)
    {
        //  Assigns position of upper-left corner
        this.x = x;
        this.y = y;
        
        // Creates dimension
        d = new Dimension(45, 48);
        
        //  Assigns width and height
        int w = d.width;
        int h = d.height;

        //  Creates the pixels array used for creating each image
        int[] pixels1 = new int[w * h];
        
        //  Creates the RGBColor array that holds all the RGBColor
        //    objects
        RGBColor[] RGBpixels = new RGBColor[w * h];
        
        //  Create colors needed for this class
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor red = new RGBColor(255, 255, 0, 0);
        RGBColor white = new RGBColor(255, 255, 255, 255);
        
        //  Background color that is transparent
        RGBColor black = new RGBColor(0, 0, 0, 0);

        //  Placeholding variable:  black is default color
        RGBColor color = black;
        
        //  Tracking variable for each index of the pixels array
        int i = 0;

        //********************************************************************
        //  Start for-loops of pixel assignment
        //********************************************************************
        
        //  This iterates each row
        for(int j = 0; j < h; j++)
        {
            //  This iterates each column
            for(int k = 0; k < w; k++)
            {
                if(j <= 2) 
                {
                    if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 5) 
                {
                    if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else
                    {
                        color = black;
                    }
                }
                
                else if(j <= 8) 
                {
                    if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 11) // next 6 rows
                {
                    if(k <= 17)
                    {
                        color = black;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 14) 
                {
                    if(k <= 17)
                    {
                        color = black;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 17) 
                {
                    if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = red;
                    }
                    else if(k <= 14)
                    {
                        color = black;
                    }
                    else if(k <= 17)
                    {
                        color = black;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = red;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 20) 
                {
                    if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = red;
                    }
                    else if(k <= 14)
                    {
                        color = black;
                    }
                    else if(k <= 17)
                    {
                        color = black;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = red;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 23) 
                {
                    if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = white;
                    }
                    else if(k <= 14)
                    {
                        color = black;
                    }
                    else if(k <= 17)
                    {
                        color = white;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = white;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 26) 
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = white;
                    }
                    else if(k <= 14)
                    {
                        color = blue;
                    }
                    else if(k <= 17)
                    {
                        color = white;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = red;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = white;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
                    }
                    else if(k <= 35)
                    {
                        color = white;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                    else if(k <= 41)
                    {
                        color = black;
                    }
                    else if(k <= 44)
                    {
                        color = red;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 29) 
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = blue;
                    }
                    else if(k <= 14)
                    {
                        color = white;
                    }
                    else if(k <= 17)
                    {
                        color = white;
                    }
                    else if(k <= 20)
                    {
                        color = red;
                    }
                    else if(k <= 23)
                    {
                        color = red;
                    }
                    else if(k <= 26)
                    {
                        color = red;
                    }
                    else if(k <= 29)
                    {
                        color = white;
                    }
                    else if(k <= 32)
                    {
                        color = white;
                    }
                    else if(k <= 35)
                    {
                        color = blue;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                    else if(k <= 41)
                    {
                        color = black;
                    }
                    else if(k <= 44)
                    {
                        color = red;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                
                else if(j <= 32) 
                {
                    if(k <= 2)
                    {
                        color = white;
                    }
                    else if(k <= 5)
                    {
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = white;
                    }
                    else if(k <= 14)
                    {
                        color = white;
                    }
                    else if(k <= 17)
                    {
                        color = white;
                    }
                    else if(k <= 20)
                    {
                        color = red;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = red;
                    }
                    else if(k <= 29)
                    {
                        color = white;
                    }
                    else if(k <= 32)
                    {
                        color = white;
                    }
                    else if(k <= 35)
                    {
                        color = white;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                    else if(k <= 41)
                    {
                        color = black;
                    }
                    else if(k <= 44)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 35) 
                {
                    if(k <= 2)
                    {
                        color = white;
                    }
                    else if(k <= 5)
                    {
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = white;
                    }
                    else if(k <= 11)
                    {
                        color = white;
                    }
                    else if(k <= 14)
                    {
                        color = white;
                    }
                    else if(k <= 17)
                    {
                        color = white;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = white;
                    }
                    else if(k <= 32)
                    {
                        color = white;
                    }
                    else if(k <= 35)
                    {
                        color = white;
                    }
                    else if(k <= 38)
                    {
                        color = white;
                    }
                    else if(k <= 41)
                    {
                        color = black;
                    }
                    else if(k <= 44)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 38) 
                {
                    if(k <= 2)
                    {
                        color = white;
                    }
                    else if(k <= 5)
                    {
                        color = white;
                    }
                    else if(k <= 8)
                    {
                        color = white;
                    }
                    else if(k <= 11)
                    {
                        color = white;
                    }
                    else if(k <= 14)
                    {
                        color = white;
                    }
                    else if(k <= 17)
                    {
                        color = red;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = red;
                    }
                    else if(k <= 32)
                    {
                        color = white;
                    }
                    else if(k <= 35)
                    {
                        color = white;
                    }
                    else if(k <= 38)
                    {
                        color = white;
                    }
                    else if(k <= 41)
                    {
                        color = white;
                    }
                    else if(k <= 44)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                
                else if(j <= 41) 
                {
                    if(k <= 2)
                    {
                        color = white;
                    }
                    else if(k <= 5)
                    {
                        color = white;
                    }
                    else if(k <= 8)
                    {
                        color = white;
                    }
                    else if(k <= 11)
                    {
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = red;
                    }
                    else if(k <= 17)
                    {
                        color = red;
                    }
                    else if(k <= 20)
                    {
                        color = white;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = white;
                    }
                    else if(k <= 29)
                    {
                        color = red;
                    }
                    else if(k <= 32)
                    {
                        color = red;
                    }
                    else if(k <= 35)
                    {
                        color = black;
                    }
                    else if(k <= 38)
                    {
                        color = white;
                    }
                    else if(k <= 41)
                    {
                        color = white;
                    }
                    else if(k <= 44)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 44) 
                {
                    if(k <= 2)
                    {
                        color = white;
                    }
                    else if(k <= 5)
                    {
                        color = white;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = red;
                    }
                    else if(k <= 17)
                    {
                        color = red;
                    }
                    else if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = black;
                    }
                    else if(k <= 29)
                    {
                        color = red;
                    }
                    else if(k <= 32)
                    {
                        color = red;
                    }
                    else if(k <= 35)
                    {
                        color = black;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                    else if(k <= 41)
                    {
                        color = white;
                    }
                    else if(k <= 44)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                else if(j <= 47) 
                {
                    if(k <= 2)
                    {
                        color = white;
                    }
                    else if(k <= 5)
                    {
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = black;
                    }
                    else if(k <= 17)
                    {
                        color = black;
                    }
                    else if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = white;
                    }
                    else if(k <= 26)
                    {
                        color = black;
                    }
                    else if(k <= 29)
                    {
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = black;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                    else if(k <= 41)
                    {
                        color = black;
                    }
                    else if(k <= 44)
                    {
                        color = white;
                    }
                    else 
                    {
                        color = black;
                    }
                }
                //  Assigns each color to the RGBColor array
                RGBpixels[i++] = color;
            }
        }
        
        //  ********************************************************************
        //  Converts each RGBColor instance of a color to an integer 
        //    representation of the color
        //********************************************************************
        for(int n = 0; n < RGBpixels.length; n++)
        {
            if(RGBpixels[n] == blue)
            {
                pixels1[n] = setPixel(blue);
            }
            else if(RGBpixels[n] == red)
            {
                pixels1[n] = setPixel(red);
            }
            else if(RGBpixels[n] == white)
            {
                pixels1[n] = setPixel(white);
            }
        }
        
        //  Creates the image using the specified width, height, and pixel
        //    array
        image = makeImage(w, h, pixels1);
    }
    
    //********************************************************************
    //  Method only implemented to prevent the class from becoming 
    //    abstract.  It essentially does nothing since it is never called
    //********************************************************************
    public int getScore()
    {
        return 0;
    }
}