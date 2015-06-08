// PlayerBullet.java
// Created by Shahein Tajmir
// Feb 19, 2005
// This creates the PlayerBullet sprite by executing a humongous for-loop which
//  sets all the necessary pixels to appropriate values. The humongous array is 
//  then converted into an image object for use by the program.

import java.awt.*;

public class PlayerBullet extends Sprite
{
    public PlayerBullet(int x, int y)
    {
        // assigns position of upper left corner
        this.x = x;
        this.y = y;

        // creates dimension
        d = new Dimension(9, 24);

        // assigns width and height
        int w = d.width;
        int h = d.height;
        int[] pixels = new int[w * h];
        int i = 0;

        //  create colors needed for this image
        RGBColor blue = new RGBColor(255, 0, 104, 222);
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
                
                pixels[i++] = setPixel(color);
            }
        }
        image = makeImage(w, h, pixels);
    }
    public int getScore()
    {
        return 0;
    }
}

