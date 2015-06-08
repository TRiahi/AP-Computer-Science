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
    //  Holds the generated image
    protected Image image; 

    //  Integers for dealing with the image's placement
    protected int x, y;               //  Current X, Y Coordinates
    protected int initialX, initialY; //  Initial X, Y Coordinates
    
    //  Boolean for determining if the ship is moving along a curve
    protected boolean moving = false;  
    protected boolean attack = false;  //  Boolean for an attacking ship
    protected boolean retreat = false; //  Boolean for a retreating ship

    //  Defines the dimensions of the image
    protected Dimension d; 
    
    //  Creates an temporarily initializes the point arrays used by the curve
    protected Point[] attackPoints = new Point[1], retreatPoints = new Point[1];
    
    //  Constants - Random Number Generator Seeds
    final static int RANDOM_MOVE_SEED = 50;  //  Seed for moving
    final static int RANDOM_FIRE_SEED = 30;  //  Seed for firing a bullet

    //  Declares and initializes the random move time from 1 to 101
    protected int randomMoveTime = (int) (((Math.random() * RANDOM_MOVE_SEED) + 1) 
                                   + 50);
    protected int currentMoveTime = 0;  //  Time tracking variable
    
    //  Declares and initializes the random firing time from 1 to 61
    protected int randomFireTime = (int) (((Math.random() * RANDOM_FIRE_SEED) + 1) 
                                   + 30);
    protected int currentFireTime = 0;  //  Time tracking variable

    //******************************************************************************
    //  Constructor that does nothing - Abstract Class...
    //******************************************************************************
    public Sprite()
    {

    }

    //******************************************************************************
    //  Method that draws the image held within all Sprite-derived classes
    //******************************************************************************
    public void draw(Graphics g, int x, int y)
    {
        g.drawImage(image, x, y, null);
    }

    //******************************************************************************
    //  Method returns the value of the right edge of the Sprite
    //******************************************************************************
    public int getRightSide()
    {
        return x + d.width;
    }

    //******************************************************************************
    //  Method returns the value of the left edge of the Sprite
    //******************************************************************************
    public int getLeftSide()
    {
        return x;
    }

    //******************************************************************************
    //  Method shifts the Sprite depending on the parameters passed
    //******************************************************************************
    public void translate(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    //******************************************************************************
    //  Method returns the dimension of the Sprite image
    //******************************************************************************
    public Dimension getDimension()
    {
        return d;
    }

    //******************************************************************************
    //  Method returns the x-coordinate of the upper left of Sprite image
    //******************************************************************************
    public int getXCoordinate()
    {
        return x;
    }

    //******************************************************************************
    //  Method returns the y-coordinate of the upper left of the Sprite image
    //******************************************************************************
    public int getYCoordinate()
    {
        return y;
    }
    
    //******************************************************************************
    //  Method that returns the center x-coordinate
    //******************************************************************************
    public int getXCenter()
    {
        return x + (d.width / 2);
    }
    
    //******************************************************************************
    //  Method that returns the center y-coordinate
    //******************************************************************************
    public int getYCenter()
    {
        return y + (d.height / 2);
    }

    //******************************************************************************
    //  Method creates an image when passed in the width, height, and pixel array
    //  Returns the image generated from the Pixel Array
    //******************************************************************************
    protected Image makeImage(int w, int h, int[] pixels)
    {
        return Toolkit.getDefaultToolkit().createImage(
                new MemoryImageSource(w, h, pixels, 0, w));
    }
    
    //******************************************************************************
    //  Method that takes an RGBColor object and converts it to an integer for 
    //    use in a integer array of pixel data
    //******************************************************************************
    protected int setPixel(RGBColor color)
    {
        //  Pixel variables for initializing the pixel values
        //  a = transparency
        //  r = red component
        //  g = green component
        //  b = blue component
        int a, r, g, b;
        //  Temp integer for holding the pixel
        int tempPixel;
        
        a = color.getTransparency();
        r = color.getRed();
        g = color.getGreen();
        b = color.getBlue();
        
        //  Performs bit shifts to obtain an integer with the correct data
        tempPixel = (a << 24) | (r << 16) | (g << 8) | b;
        
        return tempPixel;
    }
    
    //******************************************************************************
    //  Method that returns whether the sprite is moving
    //******************************************************************************
    public boolean isMoving()
    {
        return moving;
    }
    
    //******************************************************************************
    //  Method that sets whether the sprite is moving
    //******************************************************************************
    public void setMoving(boolean yes)
    {
        moving = yes;
    }
    
    //******************************************************************************
    //  Method that initializes the two curve point-arrays
    //******************************************************************************
    public void setCurve(Point[] points)
    {
        attackPoints = points;
        retreatPoints = new Point[points.length];
        
        int j = points.length - 1;
        //  Reverses the order of points so the sprite can retreat if necessary
        for(int i = 0; i < points.length; i++)
        {
            retreatPoints[i] = points[j];
            j--;
        }
    }
    
    //******************************************************************************
    //  Method that iterates the ship's X and Y coordinates along the retreating
    //   curve
    //******************************************************************************
    public void retreatShip()
    {
        for(int i = 0; i < retreatPoints.length; i++)
        {
            //  Find the first non-null entry in the array
            if(retreatPoints[i] != null)
            {
                //  Set the coordinates
                x = retreatPoints[i].x;
                y = retreatPoints[i].y;
                //  Set this entry null
                retreatPoints[i] = null;
                //  Break out of the loop
                i = attackPoints.length;
            }
            //  If all entries in the curve are null
            if(retreatPoints[retreatPoints.length - 1] == null)
            {
                //  Stop retreating
                setRetreat(false);
                //  Set the coordinates back to their initial points
                x = initialX;
                y = initialY;
            }
        }
    }
    
    //******************************************************************************
    //  Method that iterates the ship's X and Y coordinates along the retreating
    //   curve
    //******************************************************************************
    public void attackShip(Vector enemyBullets, PlayerShip player)
    {
        for(int i = 0; i < attackPoints.length; i++)
        {
            //  Find the first non-null entry in the array
            if(attackPoints[i] != null)
            {
                //  Set the coordinates	
                x = attackPoints[i].x;
                y = attackPoints[i].y;
                //  Set this entry null
                attackPoints[i] = null;
                //  Break out of the loop
                i = attackPoints.length;
            }
            //  If the ship is in the first half of its curving path
            if(attackPoints[attackPoints.length / 2] != null)
            {
                //  If the current time is less than the preset firing time
                if(randomFireTime > currentFireTime)
                {
                     //  Do nothing
                }
                else 
                {
                    //  Otherwise, set the current time to zero
                    currentFireTime = 0;
                    //  Fire a bullet
                    enemyBullets.add(new EnemyBullet(this, player));
                    //  Reset the random time
                    randomFireTime = (int) (((Math.random() * RANDOM_FIRE_SEED) + 1)
                            + 60);
                }
            }
            //  If all entries in the curve are null
            if(attackPoints[attackPoints.length - 1] == null)
            {
                //  Stop attacking
                setAttack(false);
                //  Start retreating
                setRetreat(true);
            }
        }
        //  Increment the firing time
        currentFireTime++;
    }
    
    
    //******************************************************************************
    //  Method that checks the time for moving.  If the random time has passed,
    //    return true.  If the ship is already attacking or retreating, return true.
    //    Otherwise, increment the move time and return false.
    //******************************************************************************
    public boolean checkTime()
    {
        //  If the random time is equal to the current time counter
        if(randomMoveTime == currentMoveTime)
        {
            //  Generate a new random time
            randomMoveTime = (int) (((Math.random() * RANDOM_MOVE_SEED) + 1) + 50);
            //  Reset the current time counter
            currentMoveTime = 0;
            //  Set attack to true
            setAttack(true);
            return true;
        }
        //  If the ship is already attacking or retreating
        else if(attack || retreat)
        {
            return true;
        }
        //  Otherwise, increment the moving time and return false
        else
        {
            currentMoveTime++;
            return false;
        }
    }
    //******************************************************************************
    //  Method that returns whether a sprite is attacking or not
    //******************************************************************************
    public boolean isAttacking()
    {
        return attack;
    }
    
    //******************************************************************************
    //  Method that returns where a sprite is retreating or not
    //******************************************************************************
    public boolean isRetreating()
    {
        return retreat;
    }
    
    //******************************************************************************
    //  Method that sets whether a sprite is attacking
    //******************************************************************************
    public void setAttack(boolean temp)
    {
        attack = temp;
    }
    
    //******************************************************************************
    //  Method that sets whether a sprite is retreating
    //******************************************************************************
    public void setRetreat(boolean temp)
    {
        retreat = temp;
    }
    
    //******************************************************************************
    //  Method that sets the position of a sprite
    //******************************************************************************
    public void setPosition(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    //******************************************************************************
    //  Method that returns whether a sprite is at its initial location
    //******************************************************************************
    public boolean isAtInitialLocation()
    {
        if(x == initialX && y == initialY)
            return true;
        else
            return false;
    }
    
    //******************************************************************************
    //  Abstract method that is to be implemented by the child classes
    //******************************************************************************
    public abstract int getScore();
}