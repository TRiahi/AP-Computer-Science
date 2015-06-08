// BossShip.java
// Created by Shahein Tajmir
// Feb 8, 2005
// This creates the BossShip sprite by executing a humongous for-loop which sets
// all the necessary
//  pixels to appropriate values. The humongous array is then converted into an
// image object for
//  use by the program.

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.PathIterator;
import java.util.*;

public class BossShip extends Sprite
{
    final static int SCORE = 200;
    static int ID = 1; // class ID variable

    private int myID;
    
    //  Images
    //    image1 = ship when it has 0 hits
    //    image2 = ship when it has 1 hit
    private Image image1, image2;

    //  Number of hits this ship has obtained
    private int hits = 0;
    private boolean expanding = true;

    public BossShip(int x, int y)
    {
        // assigns position of upper left corner
        this.x = x;
        this.y = y;
        this.initialX = x;
        this.initialY = y;

        myID = ID;
        ID++;

        // creates dimension
        d = new Dimension(45, 48);

        // assigns width and height
        int w = d.width;
        int h = d.height;

        int[] pixels1 = new int[w * h];
        int[] pixels2 = new int[w * h];
        RGBColor[] RGBpixels = new RGBColor[w * h];

        int i = 0;

        // Create colors needed for this image
        //      Colors when hits is 0;
        RGBColor teal = new RGBColor(255, 0, 157, 151);
        RGBColor red = new RGBColor(255, 222, 71, 0);
        RGBColor yellow = new RGBColor(255, 255, 255, 0);

        //      Colors when hits is 1
        RGBColor blue = new RGBColor(255, 0, 104, 222);
        RGBColor pink = new RGBColor(255, 255, 0, 222);
        RGBColor purple = new RGBColor(255, 151, 0, 222);

        //  Universal Color
        RGBColor black = new RGBColor(0, 0, 0, 0);

        //  Placeholding variable..black is default color
        RGBColor color = black;

        for(int j = 0; j < h; j++)
        {
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
                RGBpixels[i++] = color;
                //pixels[i++] = (255 << 24) | (r << 16) | (g << 8) | b;
            }
        }

        for(int n = 0; n < RGBpixels.length; n++)
        {
            //pixels1[n] = setPixel(RGBpixels[n]);
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

        image1 = makeImage(w, h, pixels1);
        image2 = makeImage(w, h, pixels2);
    }

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

    public int getHits()
    {
        return hits;
    }

    public void hit()
    {
        hits++;
    }

    public int getID()
    {
        return myID;
    }

    public void move()
    {
        int tempID = this.myID;
        int distance = 0;
        

        switch(tempID)
        {
            case 1:
                distance = initialX - 15;
                break;
            case 2:
                distance = initialX - 5;
                break;
            case 3:
                distance = initialX + 5;
                break;
            case 4:
                distance = initialX + 15;
                break;
        }

        if(tempID == 1)
        {
            if(expanding)
            {

                if(x > (distance))
                {
                    this.translate(-1, 0);
                }
                if(x == (distance))
                {
                    expanding = false;
                }
            }
            else
            {
                if(x < initialX)
                {
                    this.translate(1, 0);
                }
                if(x == initialX)
                {
                    expanding = true;
                }
            }
        }
        
        if(tempID == 2)
        {
            if(expanding)
            {

                if(x > (distance))
                {
                    this.translate(-1, 0);
                }
                if(x == (distance))
                {
                    expanding = false;
                }
            }
            else
            {
                if(x < initialX)
                {
                    this.translate(1, 0);
                }
                if(x == initialX)
                {
                    expanding = true;
                }
            }
        }
    }
    
    public void setCurve(Point[] points)
    {
        attackPoints = points;
        retreatPoints = new Point[points.length];
        
        int j = points.length - 1;
        for(int i = 0; i < points.length; i++)
        {
            retreatPoints[i] = points[j];
            j--;
        }
    }
    
    public void retreatShip(Vector enemyBullets, PlayerShip player)
    {
        for(int i = 0; i < retreatPoints.length; i++)
        {
            if(retreatPoints[i] != null)
            {
                x = retreatPoints[i].x;
                y = retreatPoints[i].y;
                retreatPoints[i] = null;
                i = attackPoints.length;
            }
            if(retreatPoints[retreatPoints.length / 2] == null)
            {
                if(randomFireTime > currentFireTime)
                {
                                                       
                }
                else
                {
                    
                }
            }
            if(retreatPoints[retreatPoints.length - 1] == null)
            {
                retreat = false;
                x = initialX;
                y = initialY;
            }
        }
    }
    
    public void attackShip(Vector enemyBullets, PlayerShip player)
    {
        for(int i = 0; i < attackPoints.length; i++)
        {
            if(attackPoints[i] != null)
            {
                x = attackPoints[i].x;
                y = attackPoints[i].y;
                attackPoints[i] = null;
                i = attackPoints.length;
            }
            if(attackPoints[attackPoints.length / 2] != null)
            {
                if(randomFireTime > currentFireTime)
                {
                                                            
                }
                else 
                {
                    currentFireTime = 0;
                    enemyBullets.add(new EnemyBullet(this, player));
                    randomFireTime = (int) (((Math.random() * randomFireSeed) + 1) + 60);
                }
            }
            if(attackPoints[attackPoints.length - 1] == null)
            {
                attack = false;
                retreat = true;
            }
        }
        currentFireTime++;
    }
    
    public void setAttack(boolean temp)
    {
        attack = temp;
    }
    
    public void setRetreat(boolean temp)
    {
        retreat = temp;
    }
    
    public boolean checkTime()
    {
        if(randomMoveTime == currentMoveTime)
        {
            randomMoveTime = (int) (((Math.random() * randomMoveSeed) + 1) + 50);
            currentMoveTime = 0;
            attack = true;
            return true;
        }
        else if(attack || retreat)
        {
            return true;
        }
        else
        {
            currentMoveTime++;
            return false;
        }
    }
    
    public boolean isAttacking()
    {
        return attack;
    }
    
    public boolean isRetreating()
    {
        return retreat;
    }
    
    public int getScore()
    {
        return SCORE;
    }
}