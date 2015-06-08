//  BeeShip.java
//  Created by Shahein Tajmir
//  Feb 21, 2005
//  Last Updated:  3/8/05
//  This creates the Bee sprite by executing a humongous for-loop 
//    which sets all the necessary pixels to appropriate values. 
//    The humongous array is then converted into an image object for
//    use by the program.

import java.awt.*;

public class BeeShip extends Sprite
{
    //********************************************************************
    //  Constant
    //********************************************************************
    //  Score for each kill of this type of ship
    final static int SCORE = 100;
    
    //  Class ID Variable Counter - Used mainly in debugging
    static int ID = 1;
    //  Each instance has its own ID variable
    private int myID;

    //********************************************************************
    //  Constructor - Assigns Variables as needed and starts the massive
    //    for-loops that initialize the image
    //********************************************************************
    public BeeShip(int x, int y)
    {
        // Assigns position of upper-left corner
        this.x = x;
        this.y = y;
        
        //  Assigns positions of the initial position of this on screen
        this.initialX = x;
        this.initialY = y;

        //  Assigns and updates the ID Variables
        myID = ID;
        ID++;

        // Creates dimension
        d = new Dimension(39, 30);

        // Assigns width and height
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
        RGBColor yellow = new RGBColor(255, 255, 255, 0);

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
                //  Assigns each color to the RGBColor array
                RGBpixels[i++] = color;
            }
        }
        
        //********************************************************************
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
            else if(RGBpixels[n] == yellow)
            {
                pixels1[n] = setPixel(yellow);
            }
        }
        
        //  Creates the image using the specified width, height, and pixel
        //    array
        image = makeImage(w, h, pixels1);
    }

    //********************************************************************
    //  Method that returns the individual ID of this class
    //********************************************************************
    public int getID()
    {
        return myID;
    }
    
    //********************************************************************
    //  Method that returns the score for killing one instance of this
    //    class
    //********************************************************************
    public int getScore()
    {
        return SCORE;
    }
}