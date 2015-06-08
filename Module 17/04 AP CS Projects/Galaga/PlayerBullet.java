//  PlayerBullet.java
//  Created by Shahein Tajmir
//  Feb 19, 2005
//  Last Updated:  3/8/05
//  This creates the PlayerBullet sprite by executing a humongous 
//      for-loop which sets all the necessary pixels to appropriate 
//      values. The humongous array is then converted into an image 
//      object for use by the program.

import java.awt.*;

public class PlayerBullet extends Sprite
{
    //********************************************************************
    //  Constructor - Assigns Variables as needed and starts the massive
    //    for-loops that initialize the image
    //********************************************************************
    public PlayerBullet(int x, int y)
    {
        // Assigns position of upper-left corner
        this.x = x;
        this.y = y;

        // Creates dimension
        d = new Dimension(9, 24);

        // Assigns width and height
        int w = d.width;
        int h = d.height;
        //  Integer array for holding the pixel data
        int[] pixels = new int[w * h];
        
        //  Create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor red = new RGBColor(255, 204, 0, 0);
        RGBColor white = new RGBColor(255, 255, 255, 255);
        RGBColor black = new RGBColor(0, 0, 0, 0);
        
        //  Create temp variable for holding the color
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
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = blue;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                else if(j <= 5)
                {
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = blue;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                else if(j <= 8)
                {
                    if(k <= 2)
                    {
                        color = blue;
                    }
                    else if(k <= 5)
                    {
                        color = blue;
                    }
                    else if(k <= 8)
                    {
                        color = blue;
                    }
                }
                else if(j <= 11)
                {
                    if(k <= 2)
                    {
                        color = blue;
                    }
                    else if(k <= 5)
                    {
                        color = white;
                    }
                    else if(k <= 8)
                    {
                        color = blue;
                    }
                }
                else if(j <= 14)
                {
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                else if(j <= 17)
                {
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                else if(j <= 20)
                {
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                else if(j <= 23)
                {
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                //  Assigns the integer representation of the color to
                //    the pixels array
                pixels[i++] = setPixel(color);
            }
        }
        //  Creates the image using the specified width, height, and pixel
        //    array
        image = makeImage(w, h, pixels);
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

