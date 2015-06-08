// Stars.java
// Created by Shahein Tajmir
// Feb 13, 2005
// Encapsulated class holding the methods relating to the starfield used in
// Galaga

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

public class Stars
{
    final int NUM_STARS = 28; // number of stars in background

    final int SPEED = 3;

    Vector stars = new Vector();

    Dimension d;

    public Stars(Dimension d)
    {
        this.d = d;

        for(int a = 0; a < NUM_STARS; a++)
        {
            int tempX, tempY;
            Point tempPoint;

            tempX = 25 + a * 25;
            tempY = (int) ((Math.random() * d.height - 1) + 1);

            tempPoint = new Point(tempX, tempY);

            stars.add(tempPoint);
        }
    }

    public void moveStars()
    {
        for(int a = 0; a < NUM_STARS; a++)
        {
            Point tempPoint;
            tempPoint = (Point) stars.get(a);

            //  If star is at the bottom of the screen, move it back up

            if(tempPoint.y + 1 > d.height - (SPEED * 2))
            {
                tempPoint.y = 0;
                stars.setElementAt(tempPoint, a);

            }
            else
            {
                tempPoint.y += SPEED;
                stars.setElementAt(tempPoint, a);
            }

        }
    }

    public void drawStars(Graphics g)
    {
        g.setColor(Color.blue);
        for(int a = 0; a < NUM_STARS; a++)
        {
            Point tempPoint = (Point) stars.get(a);
            g.drawRect(tempPoint.x, tempPoint.y, 1, 1);
        }
    }
}