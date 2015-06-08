//  BossShip.java
//  Created by Shahein Tajmir
//  Feb 8, 2005
//  Last Updated:  3/8/05
//  This creates the Boss sprite by executing a humongous for-loop 
//    which sets all the necessary pixels to appropriate values. 
//    The humongous array is then converted into an image object for
//    use by the program.

import java.awt.*;

public class BossShip extends Sprite
{
    //********************************************************************
    //  Constant
    //********************************************************************
    //  Score for each kill of this type of ship
    final static int SCORE = 200;
    
    //  Class ID Variable Counter - Used mainly in debugging
    static int ID = 1;
    //  Each instance has its own ID variable
    private int myID;
    
    //  Images
    //    image1 = ship when it has 0 hits
    //    image2 = ship when it has 1 hit
    private Image image1, image2;

    //  Number of hits this ship has obtained
    private int hits = 0;

    //********************************************************************
    //  Constructor - Assigns Variables as needed and starts the massive
    //    for-loops that initialize the image
    //********************************************************************
    public BossShip(int x, int y)
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
        d = new Dimension(45, 48);

        // Assigns width and height
        int w = d.width;
        int h = d.height;

        //  Creates the two pixels arrays used for creating each
        //    image
        int[] pixels1 = new int[w * h];
        int[] pixels2 = new int[w * h];
        
        //  Creates the RGBColor array that holds all the RGBColor
        //    objects
        RGBColor[] RGBpixels = new RGBColor[w * h];

        //  Create colors needed for this class
        //      Colors when hits = 0;
        RGBColor teal = new RGBColor(255, 0, 157, 151);
        RGBColor red = new RGBColor(255, 222, 71, 0);
        RGBColor yellow = new RGBColor(255, 255, 255, 0);

        //      Colors when hits = 1
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor pink = new RGBColor(255, 255, 0, 222);
        RGBColor purple = new RGBColor(255, 151, 0, 222);

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
                if(j <= 5)
                {
                    if(k <= 17)
                    {
                        color = black;
                    }
                    else if(k <= 20)
                    {
                        color = teal;
                    }
                    else if(k <= 23)
                    {
                        color = black;
                    }
                    else if(k <= 26)
                    {
                        color = teal;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 8)
                {
                    if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = teal;
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
                        color = teal;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else
                    {
                        color = black;
                    }
                }
                else if(j <= 11)
                {
                    if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = teal;
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
                        color = teal;
                    }
                    else if(k <= 35)
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
                    if(k <= 8)
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
                        color = teal;
                    }
                    else if(k <= 20)
                    {
                        color = teal;
                    }
                    else if(k <= 23)
                    {
                        color = teal;
                    }
                    else if(k <= 26)
                    {
                        color = teal;
                    }
                    else if(k <= 29)
                    {
                        color = teal;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
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
                    if(k <= 8)
                    {
                        color = black;
                    }
                    else if(k <= 11)
                    {
                        color = black;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = teal;
                    }
                    else if(k <= 26)
                    {
                        color = yellow;
                    }
                    else if(k <= 29)
                    {
                        color = yellow;
                    }
                    else if(k <= 32)
                    {
                        color = teal;
                    }
                    else if(k <= 35)
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
                    if(k <= 5)
                    {
                        color = black;
                    }
                    else if(k <= 8)
                    {
                        color = teal;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = yellow;
                    }
                    else if(k <= 32)
                    {
                        color = teal;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = teal;
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
                        color = teal;
                    }
                    else if(k <= 5)
                    {
                        color = teal;
                    }
                    else if(k <= 8)
                    {
                        color = teal;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = yellow;
                    }
                    else if(k <= 32)
                    {
                        color = teal;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = teal;
                    }
                    else if(k <= 41)
                    {
                        color = teal;
                    }
                    else if(k <= 44)
                    {
                        color = teal;
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
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = teal;
                    }
                    else if(k <= 8)
                    {
                        color = teal;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = yellow;
                    }
                    else if(k <= 32)
                    {
                        color = teal;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = teal;
                    }
                    else if(k <= 41)
                    {
                        color = teal;
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
                else if(j <= 29)
                {
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = teal;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
                    }
                    else if(k <= 14)
                    {
                        color = teal;
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
                        color = red;
                    }
                    else if(k <= 29)
                    {
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = teal;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = red;
                    }
                    else if(k <= 41)
                    {
                        color = teal;
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
                else if(j <= 32)
                {
                    if(k <= 2)
                    {
                        color = teal;
                    }
                    else if(k <= 5)
                    {
                        color = teal;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
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
                        color = red;
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
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = red;
                    }
                    else if(k <= 41)
                    {
                        color = teal;
                    }
                    else if(k <= 44)
                    {
                        color = teal;
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
                        color = teal;
                    }
                    else if(k <= 5)
                    {
                        color = red;
                    }
                    else if(k <= 8)
                    {
                        color = teal;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
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
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = teal;
                    }
                    else if(k <= 41)
                    {
                        color = red;
                    }
                    else if(k <= 44)
                    {
                        color = teal;
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
                        color = teal;
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
                        color = teal;
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
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = red;
                    }
                    else if(k <= 41)
                    {
                        color = red;
                    }
                    else if(k <= 44)
                    {
                        color = teal;
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
                        color = teal;
                    }
                    else if(k <= 5)
                    {
                        color = teal;
                    }
                    else if(k <= 8)
                    {
                        color = teal;
                    }
                    else if(k <= 11)
                    {
                        color = teal;
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
                        color = black;
                    }
                    else if(k <= 32)
                    {
                        color = black;
                    }
                    else if(k <= 35)
                    {
                        color = teal;
                    }
                    else if(k <= 38)
                    {
                        color = teal;
                    }
                    else if(k <= 41)
                    {
                        color = teal;
                    }
                    else if(k <= 44)
                    {
                        color = teal;
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
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = teal;
                    }
                    else if(k <= 8)
                    {
                        color = teal;
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
                        color = black;
                    }
                    else if(k <= 38)
                    {
                        color = teal;
                    }
                    else if(k <= 41)
                    {
                        color = teal;
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
                //  Assigns each color to the RGBColor array
                RGBpixels[i++] = color;
            }
        }

        //********************************************************************
        //  Converts each RGBColor instance of a color to an integer 
        //    representation of the color
        //********************************************************************

        //  For image 1
        for(int n = 0; n < RGBpixels.length; n++)
        {
            if(RGBpixels[n] == teal)
            {
                pixels1[n] = setPixel(teal);
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

        //  For image 2
        for(int n = 0; n < RGBpixels.length; n++)
        {
            if(RGBpixels[n] == teal)
            {
                pixels2[n] = setPixel(blue);
            }
            else if(RGBpixels[n] == red)
            {
                pixels2[n] = setPixel(pink);
            }
            else if(RGBpixels[n] == yellow)
            {
                pixels2[n] = setPixel(purple);
            }
        }

        //  Creates the images using the specified width, height, and pixel
        //    array
        image1 = makeImage(w, h, pixels1);
        image2 = makeImage(w, h, pixels2);
    }

    //********************************************************************
    //  Overridden draw method that draws an image dependent upon the
    //    number of hits the ship has acquired
    //********************************************************************
    public void draw(Graphics g, int x, int y)
    {
        if(hits == 0)
        {
            g.drawImage(image1, x, y, null);
        }
        if(hits == 1)
        {
            g.drawImage(image2, x, y, null);
        }
    }

    //********************************************************************
    //  Method that returns the number of hits a ship has
    //********************************************************************
    public int getHits()
    {
        return hits;
    }

    //********************************************************************
    //  Method that increments the number of hits a ship has
    //********************************************************************
    public void hit()
    {
        hits++;
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