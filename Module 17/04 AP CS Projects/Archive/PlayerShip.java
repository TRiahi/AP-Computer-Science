// PlayerShip.java
//  Created on Jan 31, 2005
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
        d = new Dimension(49, 50);
        
        //  assigns width and height
        int w = d.width;
        int h = d.height;
        int pixels[] = new int[w * h];
        int i = 0;

        //  pixel variables for initializing the pixel values
        //  a = transparency
        //  r = red component
        //  g = green component
        //  b = blue component
        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        
        //  Beginning of loop, starts with the rows
        for(int j = 0; j < h; j++)
        {
            // Inner loop, does the columns
            for(int k = 0; k < w; k++)
            {
                if(j <= 7) // first 8 rows:  skinny part of nose
                {
                    if(k <= 22)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                }
                else if(j <= 13) // next 6 rows
                {
                    if(k <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 27)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                }
                else if(j <= 19) // beginning of inner red pylons
                {
                    if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 27)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                }
                else if(j <= 22) // lines above center windows
                {
                    if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                }
                else if(j <= 23) // line containing top row of center window
                {
                    if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                }
                else if(j <= 25) // next 2 rows && beginning of outer red pylons
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                }
                else if(j <= 26) // next rows && ends outer red pylon
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                }
                
                else if(j <= 28) // next 2 rows 
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 31) // next 3 rows:  ends central windows
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 14)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 34) // next 3 rows: end inner pylon
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                
                else if(j <= 37) // next 3 rows: begin wing
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 8)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 33)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 36)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 42)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 40) // next 3 rows: beginning of thrusters
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 11)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 14)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 16)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 31)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 33)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 36)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 39)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 42)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 41) // next row: continue thruster
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 11)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 13)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 34)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 42)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 43) // next 2 row: continue thruster more
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 11)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 13)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 27)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 34)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 42)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 45)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 45) // next 2 row: continue thruster even more
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 13)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 22)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 27)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 28)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 34)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 42)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 45)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 46) // next row: continue thruster even more
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 13)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 23)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 24)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 27)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 28)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 34)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 42)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 45)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                else if(j <= 49) // last three lines: continue thruster even more
                {
                    if(k <= 2)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if(k <= 5)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 11)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 13)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 19)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 23)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 24)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (k <= 27)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 28)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 34)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 39)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (k <= 42)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 45)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if(k <= 48)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                }
                pixels[i++] = (a << 24) | (r << 16) | (g << 8) | b;
            }

        }
        image = makeImage(w, h, pixels);
    }
    
    public int getID()
    {
        return myID;
    }
}