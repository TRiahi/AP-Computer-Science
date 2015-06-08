// BeeShip.java
// Created by Shahein Tajmir
// Feb 21, 2005
// This creates the BeeShip sprite by executing a humongous for-loop which sets
// all the necessary pixels to appropriate values. The humongous array is then
// converted into an image object for use by the program.

import java.awt.*;
import java.awt.image.*;

public class BeeShip extends Sprite
{
    final static int SCORE = 100;
    
    static int ID = 1; // class ID variable
    

    private int myID;

    public BeeShip(int x, int y)
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

        //  create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor red = new RGBColor(255, 255, 0, 0);
        RGBColor yellow = new RGBColor(255, 255, 255, 0);

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
                        color = blue;
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
                        color = yellow;
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
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
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
                        color = black;
                    }
                    else
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
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = blue;
                    }
                    else if(k <= 11)
                    {
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = yellow;
                    }
                    else if(k <= 17)
                    {
                        color = red;
                    }
                    else if(k <= 20)
                    {
                        color = yellow;
                    }
                    else if(k <= 23)
                    {
                        color = red;
                    }
                    else if(k <= 26)
                    {
                        color = yellow;
                    }
                    else if(k <= 29)
                    {
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
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
                        color = black;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 8)
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
                        color = blue;
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
                        color = yellow;
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
                        color = blue;
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
                        color = black;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 11)
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
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = yellow;
                    }
                    else if(k <= 17)
                    {
                        color = yellow;
                    }
                    else if(k <= 20)
                    {
                        color = yellow;
                    }
                    else if(k <= 23)
                    {
                        color = yellow;
                    }
                    else if(k <= 26)
                    {
                        color = yellow;
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
                        color = black;
                    }
                    else
                    {
                        color = black;
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
                        color = blue;
                    }
                    else if(k <= 17)
                    {
                        color = yellow;
                    }
                    else if(k <= 20)
                    {
                        color = yellow;
                    }
                    else if(k <= 23)
                    {
                        color = yellow;
                    }
                    else if(k <= 26)
                    {
                        color = blue;
                    }
                    else if(k <= 29)
                    {
                        color = blue;
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
                        color = black;
                    }
                    else
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
                        color = blue;
                    }
                    else if(k <= 11)
                    {
                        color = blue;
                    }
                    else if(k <= 14)
                    {
                        color = blue;
                    }
                    else if(k <= 17)
                    {
                        color = red;
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
                        color = blue;
                    }
                    else if(k <= 29)
                    {
                        color = blue;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
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
                        color = black;
                    }
                    else
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
                        color = blue;
                    }
                    else if(k <= 8)
                    {
                        color = blue;
                    }
                    else if(k <= 11)
                    {
                        color = blue;
                    }
                    else if(k <= 14)
                    {
                        color = black;
                    }
                    else if(k <= 17)
                    {
                        color = red;
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
                        color = black;
                    }
                    else if(k <= 29)
                    {
                        color = blue;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
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
                        color = black;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 23)
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
                    else if(k <= 11)
                    {
                        color = blue;
                    }
                    else if(k <= 14)
                    {
                        color = black;
                    }
                    else if(k <= 17)
                    {
                        color = yellow;
                    }
                    else if(k <= 20)
                    {
                        color = yellow;
                    }
                    else if(k <= 23)
                    {
                        color = yellow;
                    }
                    else if(k <= 26)
                    {
                        color = black;
                    }
                    else if(k <= 29)
                    {
                        color = blue;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
                    }
                    else if(k <= 35)
                    {
                        color = blue;
                    }
                    else if(k <= 38)
                    {
                        color = blue;
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
                        color = red;
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
                        color = black;
                    }
                    else if(k <= 29)
                    {
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
                    }
                    else if(k <= 35)
                    {
                        color = blue;
                    }
                    else if(k <= 38)
                    {
                        color = blue;
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
                        color = red;
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
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = blue;
                    }
                    else if(k <= 35)
                    {
                        color = blue;
                    }
                    else if(k <= 38)
                    {
                        color = blue;
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
            else if(RGBpixels[n] == yellow)
            {
                pixels1[n] = setPixel(yellow);
            }
        }
        
        image = makeImage(w, h, pixels1);
        
        //image = makeImage(w, h, pixels);
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