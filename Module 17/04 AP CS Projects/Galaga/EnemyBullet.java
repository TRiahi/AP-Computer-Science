//  EnemyBullet.java
//  Created by Shahein Tajmir
//  Feb 19, 2005
//  Last Updated:  3/8/05
//  This creates the Enemy Bullet sprite by executing a humongous 
//    for-loop which sets all the necessary pixels to appropriate values. 
//    The humongous array is then converted into an image object for
//    use by the program.

import java.awt.*;

public class EnemyBullet extends Sprite
{
    //  Integer Variables that represent the X and Y Components of the
    //    slope of the line the bullet travels
    private int xSlope, ySlope;
    
    //  Double Variables that hold the x-intercept and actual slope of the
    //  line the bullet travels
    private double intercept, slope;
    
    //  Debug variable used for outputting debug-related information
    private boolean debug = false;

    //********************************************************************
    //  Constructor - Assigns Variables as needed and starts the massive
    //    for-loops that initialize the image
    //********************************************************************
    public EnemyBullet(Sprite enemyShip, Sprite playerShip)
    {
        //  Assigns position of upper-left corner
        //     X = Center of Enemy Ship that is firing this bullet
        x = enemyShip.getXCenter();
        //     Y = Bottom of Enemy Ship that is firing this bullet
        y = enemyShip.getYCoordinate() + enemyShip.getDimension().height;
        
        //********************************************************************
        // Sets up Parametric Equation
        //********************************************************************        
        xSlope = playerShip.getXCenter() - x;   //  X Slope Component
        ySlope = playerShip.getYCenter() - y;   //  Y Slope Component
        
        //  Calculated Slope Value
        slope =  ( (double) ySlope / xSlope);
        
        //  Calculated Intercept Value
        intercept = -(slope * x) + y;
        
        //  If the debug mode is on, output this data 
        if(debug == true)
        {
            System.out.println("------------------");
            System.out.println("X:  " + x);
            System.out.println("Y:  " + y);
            System.out.println("playerx:  " + playerShip.getXCenter());
            System.out.println("playery:  " + playerShip.getYCenter());
            System.out.println("XSlope:  " + xSlope);
            System.out.println("YSlope:  " + ySlope);
            System.out.println("Slope:   " + slope);
            System.out.println("Intercept:  " + intercept);
            
        }

        // Creates dimension
        d = new Dimension(9, 24);

        //  Assigns width and height
        int w = d.width;
        int h = d.height;

        //  Creates the pixels array used for creating each image
        int[] pixels = new int[w * h];

        //  Create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 255, 222);
        RGBColor red = new RGBColor(255, 204, 0, 0);
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
                    if(k <= 2)
                    {
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = white;
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
                        color = white;
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
                        color = black;
                    }
                    else if(k <= 5)
                    {
                        color = white;
                    }
                    else if(k <= 8)
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
                        color = white;
                    }
                    else if(k <= 8)
                    {
                        color = black;
                    }
                }
                else if(j <= 14)
                {
                    if(k <= 2)
                    {
                        color = red;
                    }
                    else if(k <= 5)
                    {
                        color = blue;
                    }
                    else if(k <= 8)
                    {
                        color = red;
                    }
                }
                else if(j <= 17)
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
    //  Method that updates the position of the bullet along its line
    //********************************************************************
    public void updatePosition()
    {
        //  If there is no slope, increment only the Y
        if(slope == 0)
        {
            y += 2;
        }
        //  Otherwise, increment y and recalculate X
        else 
        {
            y += 2;
            x = (int) ((y - intercept) / slope);
        }
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

