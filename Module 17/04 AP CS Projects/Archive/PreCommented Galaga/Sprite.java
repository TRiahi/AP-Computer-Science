// Sprite.java
// Created by Shahein Tajmir
// Feb 9, 2005
// An abstract class that holds each of the types of sprites in the game. All the
//  game's sprites are derived from this class, so we can implement some fun
//  polymorphic mess through this class.
//    Child Classes:  
//       Ships:  PlayerShip, BeeShip, BossShip, ButterflyShip
//       Bullets:  PlayerBullet, Enemy Bullet

import java.awt.*;
import java.awt.image.*;
import java.util.Vector;

public abstract class Sprite
{
    protected Image image; // Holds the generated image

    protected int x, y; // Used when dealing with the image's placement
    protected int initialX, initialY;
    protected boolean moving = false;

    protected Dimension d; // Defines the dimensions of the image
    
    public boolean attack = false, retreat = false;
    public Point[] attackPoints = new Point[1], retreatPoints = new Point[1];
    
    //private boolean expanding = true;
    
    public int randomMoveSeed = 50;
    public int randomFireSeed = 30;

    public int randomMoveTime = (int) (((Math.random() * randomMoveSeed) + 1) + 50);
    public int currentMoveTime = 0;
    
    public int randomFireTime = (int) (((Math.random() * randomFireSeed) + 1) + 30);
    public int currentFireTime = 0;

    //  **********************************************************************************************
    //  Constructor that does nothing - Abstract Class...
    //  **********************************************************************************************
    public Sprite()
    {

    }

    //  **********************************************************************************************
    //  Method that draws the image held within all Sprite-derived classes
    //  Requires: the graphics context - Graphics g
    //            X and Y Value representing where it is to be drawn
    //  **********************************************************************************************
    public void draw(Graphics g, int x, int y)
    {
        g.drawImage(image, x, y, null);
    }

    //  **********************************************************************************************
    //  Method returns the value of the right edge of the Sprite
    //  **********************************************************************************************
    public int getRightSide()
    {
        return x + d.width;
    }

    //  **********************************************************************************************
    //  Method returns the value of the left edge of the Sprite
    //  **********************************************************************************************
    public int getLeftSide()
    {
        return x;
    }

    //  **********************************************************************************************
    //  Method shifts the Sprite depending on the parameters passed
    //  **********************************************************************************************
    public void translate(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    //  **********************************************************************************************
    //  Method returns the dimension of the Sprite image
    //  **********************************************************************************************
    public Dimension getDimension()
    {
        return d;
    }

    //  **********************************************************************************************
    //  Method returns the x-coordinate of the upper left of Sprite image
    //  **********************************************************************************************
    public int getXCoordinate()
    {
        return x;
    }

    //  **********************************************************************************************
    //  Method returns the y-coordinate of the upper left of the Sprite image
    //  **********************************************************************************************
    public int getYCoordinate()
    {
        return y;
    }
    
    public int getXCenter()
    {
        return x + (d.width / 2);
    }
    
    public int getYCenter()
    {
        return y + (d.height / 2);
    }

    //  **********************************************************************************************
    //  Method creates an image when passed in the width, height, and pixel array
    //  Returns the image generated from the Pixel Array
    //  **********************************************************************************************
    protected Image makeImage(int w, int h, int[] pixels)
    {
        return Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(w, h, pixels, 0, w));
    }
    
    protected int setPixel(RGBColor color)
    {
        int a, r, g, b;
        int tempPixel;
        
        a = color.getTransparency();
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();
        
        tempPixel = (255 << 24) | (r << 16) | (g << 8) | b;
        
        return tempPixel;
    }
    
    public boolean isMoving()
    {
        return moving;
    }
    
    public void setMoving(boolean yes)
    {
        moving = yes;
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
    
    public void retreatShip(Vector enemyBullets)
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
    
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public boolean isAtInitialLocation()
    {
        if(x == initialX && y == initialY)
            return true;
        else
            return false;
    }
    
    public abstract int getScore();
}