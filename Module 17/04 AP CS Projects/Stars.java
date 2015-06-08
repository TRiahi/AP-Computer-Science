//  Stars.java
//  Created by Shahein Tajmir
//  Feb 13, 2005
//  Encapsulated class holding the methods relating to the starfield used in
//    Galaga

import java.awt.*;
import java.util.*;

public class Stars
{
    //******************************************************************************
    //  Constants
    //******************************************************************************
    
    //  Number of Stars on Screen at Once
    final int NUM_STARS = 28;
    //  Speed at which the stars move down the screen
    final int SPEED = 3;

    //  Vector that holds the points used for drawing the pixels
    Vector stars = new Vector();

    //  Dimension of the screen
    Dimension d;

    //******************************************************************************
    //  Constructor:  Creates the array of star points
    //******************************************************************************
    public Stars(Dimension d)
    {
        //  Assigns dimension
        this.d = d;
        //  Create points and add to vector
        for(int a = 0; a < NUM_STARS; a++)
        {
            int tempX, tempY;
            Point tempPoint;

            //  Assign the x-value
            tempX = 25 + a * 25;
            //  Assign the y-values randomly from 1 to the screen height
            tempY = (int) ((Math.random() * d.height - 1) + 1);

            //  Creates a new point
            tempPoint = new Point(tempX, tempY);

            //  Adds the point to the vector
            stars.add(tempPoint);
        }
    }

    //******************************************************************************
    //  Method that updates the star's points
    //******************************************************************************
    public void moveStars()
    {
        for(int a = 0; a < NUM_STARS; a++)
        {
            //  Temp Point used for accessing each point
            Point tempPoint = (Point) stars.get(a);

            //  If star is at the bottom of the screen, move it back up
            if(tempPoint.y + 1 > d.height - (SPEED * 2))
            {
                tempPoint.y = 0;
            }
            //  Otherwise increment its y-coordinate
            else
            {
                tempPoint.y += SPEED;
            }
        }
    }

    //******************************************************************************
    //  Method that draws each star to the screen
    //******************************************************************************
    public void drawStars(Graphics g)
    {
        g.setColor(Color.blue);
        for(int a = 0; a < NUM_STARS; a++)
        {
            //  Temp Variable for accessing each point object
            Point tempPoint = (Point) stars.get(a);
            //  Draw a square at each point with dimensions 1 by 1
            g.drawRect(tempPoint.x, tempPoint.y, 1, 1);
        }
    }
}