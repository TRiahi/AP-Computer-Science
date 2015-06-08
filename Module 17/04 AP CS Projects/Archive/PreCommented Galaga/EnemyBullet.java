// EnemyBullet.java
// Created by Shahein Tajmir
// Feb 19, 2005
// This creates the EnemyBullet sprite by executing a humongous for-loop which
//  sets all the necessary pixels to appropriate values. The humongous array is 
//  then converted into an image object for use by the program.

import java.awt.*;

public class EnemyBullet extends Sprite
{
    int xSlope, ySlope;
    double intercept, slope;
    boolean debug = true;
    //int x, y;
    
    public EnemyBullet(Sprite enemyShip, Sprite playerShip)
    {
        // assigns position of upper left corner
        x = enemyShip.getXCenter();
        y = enemyShip.getYCoordinate() + enemyShip.getDimension().height;
        //x = 100;
        //y = 100;
        
        // sets up parametric equation
        xSlope = playerShip.getXCenter() - x;
        ySlope = playerShip.getYCenter() - y;
        
        slope =  ( (double) ySlope / xSlope);
        
        intercept = -(slope * x) + y;
        
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

        // creates dimension
        d = new Dimension(9, 24);

        // assigns width and height
        int w = d.width;
        int h = d.height;
        int[] pixels = new int[w * h];
        int i = 0;

        //  create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 255, 222);
        RGBColor red = new RGBColor(255, 204, 0, 0);
        RGBColor white = new RGBColor(255, 255, 255, 255);
        RGBColor black = new RGBColor(0, 0, 0, 0);
        
        //  Create temp variable for holding the color
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
                
                pixels[i++] = setPixel(color);
            }
        }
        image = makeImage(w, h, pixels);
    }
    
    public void updatePosition()
    {
        int xTemp;
        xTemp = x;
        
        if(slope == 0)
        {
            y += 2;
        }
        else if(slope < 0)
        {
            //x--;
            //yTemp = (int) (slope * x + intercept);
            y += 2;
            xTemp = (int) ((y - intercept) / slope);
            
        }
        else if(slope > 0)
        {
            //x++;
            //yTemp = (int) ((slope * x + intercept));
            y += 2;
            xTemp = (int) ((y - intercept) / slope);
        }
           
        if(xTemp == x)
        {
            x = xTemp + 1;
        }
        else
        {
            x = xTemp;
        }
        
    }
    public int getScore()
    {
        return 0;
    }
}

