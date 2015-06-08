// ButterflyShip.java
// Created by Shahein Tajmir
// Feb 21, 2005
// This creates the ButterflyShip sprite by executing a humongous for-loop which
// sets all the necessary pixels to appropriate values. The humongous array is
// then converted into an image object for use by the program.

import java.awt.*;
import java.awt.image.*;

public class ButterflyShip extends Sprite
{
    final static int SCORE = 150;
    static int ID = 1; // class ID variable
    
    private int myID;
    
    public ButterflyShip(int x, int y)
    {
        // assigns position of upper left corner
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;

        myID = ID;
        ID++;

        // creates dimension
        d = new Dimension(39, 30);

        // assigns width and height
        int w = d.width;
        int h = d.height;
        
        int[] pixels1 = new int[w * h];
        // int[] pixels2 = new int[w * h];
        RGBColor[] RGBpixels = new RGBColor[w * h];
        //int[] pixels = new int[w * h];
        int i = 0;

        // create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor red = new RGBColor(255, 204, 0, 0);
        RGBColor white = new RGBColor(255, 255, 255, 255);
        RGBColor black = new RGBColor(0, 0, 0, 0);
        
        RGBColor color = black;

        for(int j = 0; j < h; j++)
        {
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
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = red;
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
                        color = blue;
                    }
                    else if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = blue;
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
                }
                else if(j <= 5)
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = red;
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
                        color = blue;
                    }
                    else if(k <= 20)
                    {
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = blue;
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
                        color = red;
                    }
                    else if(k <= 35)
                    {
                        color = red;
                    }
                    else if(k <= 38)
                    {
                        color = red;
                    }
                }
                else if(j <= 8)
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = black;
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
                        color = red;
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
                        color = red;
                    }
                    else if(k <= 35)
                    {
                        color = red;
                    }
                    else if(k <= 38)
                    {
                        color = red;
                    }
                }
                else if(j <= 11)
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = black;
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
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = red;
                    }
                    else if(k <= 35)
                    {
                        color = red;
                    }
                    else if(k <= 38)
                    {
                        color = red;
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
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = red;
                    }
                    else if(k <= 14)
                    {
                        color = red;
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
                        color = red;
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
                        color = red;
                    }
                    else if(k <= 38)
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
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = red;
                    }
                    else if(k <= 14)
                    {
                        color = red;
                    }
                    else if(k <= 17)
                    {
                        color = blue;
                    }
                    else if(k <= 20)
                    {
                        color = blue;
                    }
                    else if(k <= 23)
                    {
                        color = blue;
                    }
                    else if(k <= 26)
                    {
                        color = red;
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
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = red;
                    }
                    else if(k <= 14)
                    {
                        color = red;
                    }
                    else if(k <= 17)
                    {
                        color = blue;
                    }
                    else if(k <= 20)
                    {
                        color = blue;
                    }
                    else if(k <= 23)
                    {
                        color = blue;
                    }
                    else if(k <= 26)
                    {
                        color = red;
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
                        color = red;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                }
                else if(j <= 23)
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = red;
                    }
                    else if(k <= 14)
                    {
                        color = red;
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
                        color = red;
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
                        color = red;
                    }
                    else if(k <= 38)
                    {
                        color = red;
                    }
                }
                else if(j <= 26)
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
                        color = red;
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
                        color = blue;
                    }
                    else if(k <= 20)
                    {
                        color = blue;
                    }
                    else if(k <= 23)
                    {
                        color = blue;
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
                        color = red;
                    }
                    else if(k <= 38)
                    {
                        color = black;
                    }
                }
                else if(j <= 29)
                {
                    if(k <= 2)
                    {
                        color = black;
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
                        color = black;
                    }
                    else if(k <= 23)
                    {
                        color = black;
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
        return SCORE;
    }
}