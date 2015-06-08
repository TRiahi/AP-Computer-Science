// PlayerShip.java
//  Created on February 21, 2005
//  Created by Shahein Tajmir
//  This creates the user-controlled ship by going through a massive for-loop and initializing the 
//  pixels as needed.  Then the entire array is converted into an image object.   

import java.awt.*;
import java.awt.image.*;

public class PlayerShip extends Sprite
{
    static int ID = 1; // class ID variable
    
    private int myID;
    
    public PlayerShip(int x, int y)
    {
        
        //  assigns position of upper left corner
        this.x = x;
        this.y = y;
        
        // creates dimension
        d = new Dimension(45, 48);
        
        //  assigns width and height
        int w = d.width;
        int h = d.height;
        int[] pixels1 = new int[w * h];
        // int[] pixels2 = new int[w * h];
        RGBColor[] RGBpixels = new RGBColor[w * h];
        //int[] pixels = new int[w * h];
        int i = 0;

        //  create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor red = new RGBColor(255, 255, 0, 0);
        RGBColor white = new RGBColor(255, 255, 255, 255);
        RGBColor black = new RGBColor(0, 0, 0, 0);
        
        RGBColor color = black;
        
        //  Beginning of loop, starts with the rows
        for(int j = 0; j < h; j++)
        {
            // Inner loop, does the columns
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
                RGBpixels[i++] = color;
            }
        }
        for(int n = 0; n < RGBpixels.length; n++)
        {
            //pixels1[n] = setPixel(RGBpixels[n]);
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
        
        image = makeImage(w, h, pixels1);

    }
    
    public int getID()
    {
        return myID;
    }
    public int getScore()
    {
        return 0;
    }
}