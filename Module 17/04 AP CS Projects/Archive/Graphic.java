// Graphic.java
//  Created on Jan 31, 2005
//  Created by Shahein Tajmir
//

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class Graphic
{
    Image image; //  holds generated image

    public Graphic()
    {
        Dimension d = new Dimension(50, 50);
        int w = d.width;
        int h = d.height;
        int pixels[] = new int[w * h];
        int i = 0;

        int a = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        for (int y = 0; y < h; y++)
        {
            for (int x = 0; x < w; x++)
            {
                if (y <= 4)
                {
                    if (x < 23)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    } else if (x <= 25)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    } else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                } 
                else if (y <= 13)
                {
                    if (x < 21)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    } else if (x <= 27)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    } else
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                }
                else if (y <= 19) // beginning of red pylons
                {
                    if (x <= 8)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (x <= 11)
                    {
                        a = 255;
                        r = 200;
                        g = 0;
                        b = 0;
                    }  else if (x <= 20)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (x <= 27)
                    {
                        a = 255;
                        r = 255;
                        g = 255;
                        b = 255;
                    }
                    else if (x <= 36)
                    {
                        a = 0;
                        r = 0;
                        g = 0;
                        b = 0;
                    }
                    else if (x <= 39)
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

                pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }
        image = Toolkit.getDefaultToolkit().createImage(
                new MemoryImageSource(w, h, pixels, 0, w));
    }

    public void draw(Graphics g, int x, int y)
    {
        g.drawImage(image, x, y, null);
    }

}