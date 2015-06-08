// Galaga.java
//  Created by Shahein Tajmir
//  3/8/05
//  This is the "final" version of Galaga.  I have finished.  All of it.  Yes.

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.PathIterator;
import java.util.*;

public class Galaga extends JPanel implements Runnable
{
    //******************************************************************************
    //  Constants
    //******************************************************************************
    final int SCREEN_WIDTH = 700;
    final int SCREEN_HEIGHT = 700;

    //******************************************************************************
    //  Variable Declarations
    //******************************************************************************
    
    //  Booleans that deal with positioning the player ship
    private boolean right, left;
    //  Booleans that deal with game state
    private boolean intro, game, ready, gameOver, win;
    //  Boolean for if the game is never ending
    private boolean neverEnding;

    //  Integer Variables
    private int shots;       //  Holds the number of shots fired
    private int kills;       //  Holds the number of kills
    private int delay = 200; //  Holds the number of frames to be displayed 
                             //      during "Ready"
    private int time = 0;    //  Holds the number of frames that have been advanced
    private int level = 1;   //  Holds the current level--used in never ending mode
    private int score = 0;   //  Holds the current player score
    
    //  Vectors that hold Sprite-Derived Objects
    private Vector players = new Vector();       //  Vector of Player Ships
    private Vector bosses = new Vector();        //  Vector of Boss Ships
    private Vector butterflies = new Vector();   //  Vector of Butterfly Ships
    private Vector bees = new Vector();          //  Vector of Bee Ships
    private Vector playerBullets = new Vector(); //  Vector of Player Bullets
    private Vector enemyBullets = new Vector();  //  Vector of Enemy Bullets

    //  Object of class Starfield which manages the starfield in the background
    private Stars starfield;
    //  Object that holds the image buffer
    private Image imageBuffer;
    //  Dimension object that holds the screen size
    private Dimension d;
    //  Object of JFrame that holds the game
    private JFrame frame;
    //  Declaration of Thread Object for Timing
    private Thread thread;

    //******************************************************************************
    //  Constructor of Galaga
    //******************************************************************************
    public Galaga()
    {
        //  Create JFrame and set it to close when the X is pressed in upper
        //    right corner
        frame = new JFrame("Galaga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  Sets JFrame background to black
        frame.setBackground(Color.BLACK);

        //  Adds the key listener.  The class is defined below
        frame.addKeyListener(new gameControlListener());

        //  This sizes the frame
        frame.pack();
        //  Adds JPanel (Galaga is a child class of JPanel) into JFrame
        frame.getContentPane().add(this);
        
        //  Dimension Initialization:  holds the window size
        d = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
        //  sets window to correct dimensions
        frame.setSize(d);

        //  Initialize some variables
        //     Booleans for tracking where in "game stage" we are
        intro = true;
        game = false;
        ready = false;
        gameOver = false;
        //     Booleans for tracking whether the player ship is moving
        right = false;
        left = false;
        
        //  Initializes the image buffer
        imageBuffer = createImage(d.width, d.height);

        //  Instantiates an object of the Stars class, which creates the
        //      starfield
        starfield = new Stars(d);

        //  Calls the function that assigns all the ship coordinates 
        //      of the main enemy formation
        createShips();
        
        //  Adds player ship objects to the players vector
        //     This essentially adds the extra lives and their placement onscreen
        players.add(new PlayerShip(d.width / 2, 500));
        players.add(new PlayerShip(50 + 50, 600));
        players.add(new PlayerShip(50, 600));
        
        //  Thread Initialization
        thread = new Thread(this);
        thread.setPriority(5);
        //  Thread Start
        thread.start();

        //  Set JFrame visible
        frame.show();
    }

    //******************************************************************************
    //  Heart of the Game.  The Central Infinite Loop, known as run()
    //******************************************************************************
    public void run()
    {
        while(true)
        {
            starfield.moveStars(); //  Update star positions in the star field
            collisions();          //  Perform all sorts of collision detection
            prepareImageBuffer();  //  Draw the next frame of the game
            repaint();             //  Paint that next frame to the screen
            try
            {
                Thread.sleep(8);   //  Sleep the thread for 8 milliseconds
            }
            catch(InterruptedException e)
            {
                //  Catch the potential interrupted exception and do nothing
            }
        }
    }
    
    //------------------------------------------------------------------------------
    //  Collision Methods Located Below Here
    //------------------------------------------------------------------------------

    //******************************************************************************
    //  Consolidating method that combines all the collision detection into one 
    //******************************************************************************
    protected void collisions()
    {
        enemyBulletPlayerCollision();
        playerBulletEnemyCollision();
        playerEnemyShipCollision(bosses);      //  Ship collisions - Bosses
        playerEnemyShipCollision(butterflies); //  Ship collisions - Butterflies
        playerEnemyShipCollision(bees);        //  Ship collisions - Bees
    }

    //******************************************************************************
    //  Tests for collisions between enemy bullets and player ship
    //******************************************************************************
    protected void enemyBulletPlayerCollision()
    {
        //  a = each bullet in the vector
        for(int a = 0; a < enemyBullets.size(); a++)
        {
            //  Makes sure there are no out of bounds exceptions
            if(enemyBullets.size() > 0)
            {
                //  If no player ships remain in the vector, it is game over
                if(players.size() == 0)
                {
                    gameOver = true;
                    game = false;
                }
                
                //  Makes sure there there are player ships and that the game is 
                //		not in the ready stage
                if(players.size() > 0 && !ready)
                {
                    //  Temp variable for accessing each bullet
                    EnemyBullet tempBullet = (EnemyBullet) enemyBullets.get(a);
                    //  Temp variable for accessing the current player ship
                    PlayerShip currentPlayer = (PlayerShip) players.get(0);
    
                    //  If the bullet's y-coordinate is greater than the player
                    //    ship's top coordinate, and the bullet's top y-coordinate
                    //    is less than the player ship's bottom coordinate.
                    if(tempBullet.getYCoordinate()
                                    + tempBullet.getDimension().height > 
                                    currentPlayer.getYCoordinate()
                                    && tempBullet.getYCoordinate() < currentPlayer
                                    .getYCoordinate() + currentPlayer
                                    .getDimension().height)
                    {
                        //  If the bullet's right x-coordinate is greater than
                        //    the player ship's left coordinate, and the bullet's
                        //    left coordinate is less than the player ship's
                        //    right coordinate.
                        if(tempBullet.getXCoordinate() > currentPlayer
                                        .getXCoordinate()
                                        & tempBullet.getXCoordinate() < 
                                        currentPlayer.getXCoordinate() 
                                        + currentPlayer.getDimension().width)
                        {
                            //  Remove the enemy bullet
                            enemyBullets.remove(a);
                            //  Remove the player ship
                            players.remove(0);
    
                            //  If there are still lives left
                            if(players.size() != 0)
                            {
                                //  Start the Ready stage
                                ready = true;
                                //  Stop the game temporarily
                                game = false;
                                //  Take the next ship and move it to the center
                                Sprite tempShip = (Sprite) players.get(0);
                                tempShip.setPosition(d.width / 2, 500);
                            }
                            //  Forced frame repaint
                            repaint();
                        }
                    }
                }
            }
        }
    }

    //******************************************************************************
    //  Tests for collisions between player bullets and enemy ships
    //******************************************************************************
    protected void playerBulletEnemyCollision()
    {
        //**************************************************************************
        //  Tests for collisions with Boss Ships
        //**************************************************************************
        
        //  i = each boss ship in the vector
        for(int i = 0; i < bosses.size(); i++)
        {
            // a = each bullet in the vector
            for(int a = 0; a < playerBullets.size(); a++)
            {
                //  Makes sure that the vectors are not empty
                if(playerBullets.size() != 0 && bosses.size() != 0)
                {
                    //  Temp variable for accessing each bullet
                    PlayerBullet tempBullet = (PlayerBullet) playerBullets.get(a);
                    //  Temp variable for accessing each BossShip
                    BossShip tempShip = (BossShip) bosses.get(i);
                    //  If the bullet's top y-coordinate is below the enemy's top 
                    //    y-coordinate and the bullet's top y-coordinate is above
                    //    the enemy's bottom y-coordinate
                    if(tempBullet.getYCoordinate() > tempShip.getYCoordinate()
                                    & tempBullet.getYCoordinate() < tempShip
                                    .getYCoordinate() + tempShip.getDimension().
                                    height)
                    {
                        //  If the bullet's left x-coordinate is right of the 
                        //    enemy's left x-coordinate and the bullet's left 
                        //    x-coordinate is left of the enemy's right 
                        //    x-coordinate
                        if(tempBullet.getXCoordinate() > tempShip.getXCoordinate()
                                        && tempBullet.getXCoordinate() < 
                                        tempShip.getXCoordinate() + tempShip
                                        .getDimension().width)
                        {
                            //  If the Boss Ship has no hits
                            if(tempShip.getHits() < 1)
                            {
                                //  Increment its hit counter
                                tempShip.hit();
                                //  Remove the PlayerBullet from the Vector
                                playerBullets.remove(a);
                                //  Increment the score value
                                score += tempShip.getScore() / 2;
                            }
                            //  If the Boss Ship has 1 hit
                            else if(tempShip.getHits() == 1)
                            {
                                //  Remove the BossShip from the Vector
                                bosses.remove(i);
                                //  Remove the PlayerBullet from the Vector
                                playerBullets.remove(a);
                                //  Increment the kills
                                kills++;
                                //  Increment the score value
                                score += tempShip.getScore();
                            }
                        }
                    }
                }
            }
        }
        
        //**************************************************************************
        //  Tests for collisions with ButterflyShips
        //**************************************************************************
        
        //  i = each ButterflyShip in the vector
        for(int i = 0; i < butterflies.size(); i++)
        {
            //  a = each bullet in the vector
            for(int a = 0; a < playerBullets.size(); a++)
            {
                //  Makes sure that the vectors are not empty
                if(playerBullets.size() != 0 && butterflies.size() != 0)
                {
                    //  Temp variable for accessing each bullet
                    PlayerBullet tempBullet = (PlayerBullet) playerBullets.get(a);
                    //  Temp variable for accessing each ButterflyShip
                    Sprite tempShip = (Sprite) butterflies.get(i);
                    
                    //  If the bullet's top y-coordinate is below the enemy's top 
                    //    y-coordinate and the bullet's top y-coordinate is above
                    //    the enemy's bottom y-coordinate
                    if(tempBullet.getYCoordinate() > tempShip.getYCoordinate()
                                    & tempBullet.getYCoordinate() < tempShip
                                    .getYCoordinate() + tempShip.getDimension().
                                    height)
                    {
                        //  If the bullet's left x-coordinate is right of the 
                        //    enemy's left x-coordinate and the bullet's left 
                        //    x-coordinate is left of the enemy's right 
                        //    x-coordinate
                        if(tempBullet.getXCoordinate() > tempShip.getXCoordinate()
                                        && tempBullet.getXCoordinate() < 
                                        tempShip.getXCoordinate() + tempShip
                                        .getDimension().width)
                        {
                            //  Remove the Butterfly from the Vector
                            butterflies.remove(i);
                            //  Remove the Bullet from the Vector
                            playerBullets.remove(a);
                            //  Increment the Kills Value
                            kills++;
                            //  Increment the Score Value
                            score += tempShip.getScore();
                        }
                    }
                }
            }
        }
        
        //**************************************************************************
        //  Tests for collisions with BeeShips
        //**************************************************************************
        
        //  i = each BeeShip in the vector
        for(int i = 0; i < bees.size(); i++)
        {
            //  a = each bullet in the vector
            for(int a = 0; a < playerBullets.size(); a++)
            {
                //  Makes sure that the vectors are not empty
                if(playerBullets.size() != 0 && bees.size() != 0)
                {
                    //  Temp variable for accessing each bullet
                    PlayerBullet tempBullet = (PlayerBullet) playerBullets.get(a);
                    //  Temp variable for accessing each BeeShip
                    Sprite tempShip = (Sprite) bees.get(i);
                    //  If the bullet's top y-coordinate is below the enemy's top 
                    //    y-coordinate and the bullet's top y-coordinate is above
                    //    the enemy's bottom y-coordinate
                    if(tempBullet.getYCoordinate() > tempShip.getYCoordinate()
                                    & tempBullet.getYCoordinate() < tempShip
                                    .getYCoordinate() + tempShip.getDimension().
                                    height)
                    {
                        //  If the bullet's left x-coordinate is right of the 
                        //    enemy's left x-coordinate and the bullet's left 
                        //    x-coordinate is left of the enemy's right 
                        //    x-coordinate
                        if(tempBullet.getXCoordinate() > tempShip.getXCoordinate()
                                        && tempBullet.getXCoordinate() < 
                                        tempShip.getXCoordinate() + tempShip
                                        .getDimension().width)
                        {
                            //  Remove the Bee from the Vector
                            bees.remove(i);
                            //  Remove the Bullet from the Vector
                            playerBullets.remove(a);
                            //  Increment the kills value
                            kills++;
                            //  Increment the score value
                            score += tempShip.getScore();
                        }
                    }
                }
            }
        }
    }

    //******************************************************************************
    //  Method that tests for collisions between player and enemy ships
    //******************************************************************************
    protected void playerEnemyShipCollision(Vector tempVector)
    {
        //  i = each enemy in the Vector
        for(int i = 0; i < tempVector.size(); i++)
        {
            //  Test for an empty enemy vector
            if(tempVector.size() > 0)
            {
                //  If no players exist, its game over
                if(players.size() == 0)
                {
                    gameOver = true;
                    game = false;
                }
    
                //  Test for an empty player vector and makes sure we are not in
                //    the Ready state
                if(players.size() > 0 && !ready)
                {
                    //  Temp sprite for accessing each enemy ship
                    Sprite tempShip = (Sprite) tempVector.get(i);
                    //  Temp ship for accessing the current player ship
                    PlayerShip currentPlayer = (PlayerShip) players.get(0);
    
                    //  If the current player's right x-coordinate is right of the
                    //    enemy's left coordinate, and the players x-coordinate is
                    //    left of the enemy's right x-coordinate
                    if((currentPlayer.getXCoordinate()
                               + currentPlayer.getDimension().width > 
                               tempShip.getXCoordinate())
                               && (currentPlayer.getXCoordinate() < tempShip
                               .getXCoordinate() + tempShip.getDimension().width))
                    {
                        //  If the current player's bottom y-coordinate is below
                        //    the enemy's top y-coordinate, and the current player's
                        //    top y-coordinate is above the enemy's bottom 
                        //    y-coordinate
                        if(((currentPlayer.getYCoordinate() + currentPlayer
                                    .getDimension().height) > (tempShip
                                    .getYCoordinate()))
                                    && ((currentPlayer.getYCoordinate() < tempShip
                                    .getYCoordinate() + tempShip.getDimension()
                                    .height)))
                        {
                            //  Remove the player ship from the vector
                            players.remove(0);
                            //  Remove the enemy ship from the vector
                            tempVector.remove(i);
    
                            //  If there are still lives for the player
                            if(players.size() != 0)
                            {
                                //  Enter the Ready state
                                ready = true;
                                //  Temporarily exit the Game state
                                game = false;
                                //  Move the next ship in the vector to the
                                //    playable area
                                Sprite tempShip2 = (Sprite) players.get(0);
                                tempShip2.setPosition(d.width / 2, 500);
                            }
                            //  Forced repaint to update any disappearing ships
                            repaint();
                        }
                    }
                }
            }
        }
    }
    
    //------------------------------------------------------------------------------
    //  Methods that deal with Curve Generation Located Below Here
    //------------------------------------------------------------------------------

    //******************************************************************************
    //  Method that goes through the process of moving each ship.  
    //    It either moves a ship along its vector of points  OR
    //    It calls for the creation of a curve and the assignment of the points  OR
    //    It simply updates the timer for the ship
    //******************************************************************************
    protected boolean moveShips(Vector tempVector, Graphics g)
    {
        //  Number of ships of a given class that are moving
        int counter = 0;
        
        //  Check how many ships are moving at a given time
        //    i = each ship in the Vector
        for(int i = 0; i < tempVector.size(); i++)
        {
            //  Temp variable for accessing the ship from the Vector
            Sprite tempShip = (Sprite) tempVector.get(i);
            
            //  If the ship is moving or attacking
            if(tempShip.isAttacking() || tempShip.isRetreating())
                //  Update the counter
                counter++;
        }
        
        //  For each ship in the vector
        for(int i = 0; i < tempVector.size(); i++)
        {
            //  Temp variable for accessing the ship from the Vector
            Sprite tempShip = (Sprite) tempVector.get(i);
            
            //  Calls the CheckTime method of each ship.  This goes through and
            //    checks if enough time has passed for a ship to start moving.  
            //    If it has, the ship will be set to attack, and it will 
            //    return true.
            if(tempShip.checkTime())
            {
                //  If the ship is attacking and a null array
                if(tempShip.isAttacking() && tempShip.attackPoints == null)
                {
                    //  If there are fewer ships on screen than the level
                    if(counter < level && !ready)
                        assignCurve(g, tempShip);     //  Assign a curve
                    
                    //  Move the ship along its curve
                    tempShip.attackShip(enemyBullets, (PlayerShip) players.get(0));
                }
                //  If the ship is attacking and has no points assigned
                if(tempShip.isAttacking() && tempShip
                           .attackPoints[tempShip.attackPoints.length - 1] == null)
                {
                    //  If there are fewer ships on screen than the level
                    if(counter < level && !ready)
                        assignCurve(g, tempShip);     //  Assign a curve
                    
                    //  Move the ship along its curve
                    tempShip.attackShip(enemyBullets, (PlayerShip) players.get(0));
                }
                //  If the ship is attacking
                if(tempShip.isAttacking())
                {
                    //  Move the ship along its curve
                    tempShip.attackShip(enemyBullets, (PlayerShip) players.get(0));
                }
                //  If the ship is retreating
                if(tempShip.isRetreating())
                {
                    //  Move the ship along its curve
                    tempShip.retreatShip();
                }
            }
        }
        if(counter == 0)   //  If no ships are moving, return true
            return true;
        else       		   //  Otherwise, return false
            return false;
    }

    //******************************************************************************
    //  Method that assigns the curve to the enemy ship 
    //******************************************************************************
    protected void assignCurve(Graphics g, Sprite tempShip)
    {
        Vector tempPoints = new Vector(); //  Creates a temporary vector of points
    	Point points2[];                  //  Creates a temporary array of points
    	
    	//  Creates a temporary Graphics2D Context used to fill in the path
        Graphics2D g2 = (Graphics2D) g;
        
        //  Sets the enemy ship moving
        tempShip.setMoving(true);
        
        //  Creates the Bezier Curve into a Shape Object
        Shape curve = generateCurve((PlayerShip) players.get(0), tempShip);
        
        //  Creates a path iterator which will go point by point over the boundary
        PathIterator p = curve.getPathIterator(null);
        //  Creates a flattening path iterator which extracts the points
        FlatteningPathIterator f = new FlatteningPathIterator(p, 0.02);
        
        //  While it is not done iterating
        while(!f.isDone())
        {
            //  Create a temp object to extract the points
            double[] points = new double[6];
            switch(f.currentSegment(points))
            {
                //  When the iterator has found a point
                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                    //  Fill a circle at the point
                    g2.fill(new Ellipse2D.Double(points[0], points[1], 3, 3));
                    // Add the point to the vector
                    tempPoints.add(new Point((int) points[0], (int) points[1]));
            }
            //  Go to the next point
            f.next();
        }
        //  Creates an array based on the size of the Vector
        points2 = new Point[tempPoints.size()];
        
        //  Goes through the Vector and assigns the points to the array
        for(int i = 0; i < tempPoints.size(); i++)
        {
            points2[i] = (Point) tempPoints.get(i);
        }
        
        //  Passes the array to the ship, which will set the attack and 
        //    retreat points
        tempShip.setCurve(points2);
        //  Sets ship to attack
        tempShip.setAttack(true);
    }

    //******************************************************************************
    //  Generates the Curve when passed the player and enemy ships
    //******************************************************************************
    protected Shape generateCurve(Sprite player, Sprite enemy)
    {
        //  Sets a null curve:  Temporary
        Shape curve = null;
        
        //  If the Enemy is on the left side of the screen, 
        //    use one set of control points
        if(enemy.getXCenter() < d.width / 2)
            curve =  new CubicCurve2D.Double(enemy.getXCenter(), enemy.getYCenter(), 
                            d.width, enemy.getYCenter(),
                            enemy.getXCenter(), d.height, 
                            player.getXCenter(), player.getYCenter());
        
        //  If the enemy is on the right side of the screen, 
        //    use an alternate set of points
        if(enemy.getXCenter() >= d.width / 2)
            curve =  new CubicCurve2D.Double(enemy.getXCenter(), enemy.getYCenter(),
                            0, enemy.getYCenter(),
                            enemy.getXCenter(), d.height,
                            player.getXCenter(), player.getYCenter());
        
        return curve;       //  Return the generate curve
    }

    //------------------------------------------------------------------------------
    //  Methods that move Bullets Located Below Here
    //------------------------------------------------------------------------------
    
    //******************************************************************************
    //  Consolidating Method that puts the bullet managing into one Method
    //******************************************************************************
    protected void moveBullets(Graphics g)
    {
        movePlayerBullets(g);		//  Player Bullets
        moveEnemyBullets(g);		//  Enemy Bullets
    }

    //*****************************************************************************************
    //  Method that updates the position of the player bullets
    //*****************************************************************************************
    protected void movePlayerBullets(Graphics g)
    {
        for(int i = 0; i < playerBullets.size(); i++)
        {
            //  i = each player bullet in the vector

            //  Temp variable for accessing each player bullet in the vector
            PlayerBullet temp = (PlayerBullet) playerBullets.get(i);
            
            //  Move the bullet up 12 pixels
            temp.translate(0, -12);
    
            //  If the bullet has passed the top of the screen, remove the bullet
            if(temp.getYCoordinate() < 1)
            {
                playerBullets.remove(i--);
            }
            //  Otherwise, draw the bullet
            else
            {
                temp.draw(g, temp.getXCoordinate(), temp.getYCoordinate());
            }
        }
    }

    //*****************************************************************************************
    //  Method that updates the position of the enemy bullets
    //*****************************************************************************************
    protected void moveEnemyBullets(Graphics g)
    {
        for(int i = 0; i < enemyBullets.size(); i++)
        {
            //  i = each bullet in the vector
            
            //  Temp variable for accessing each bullet in the Vector
            EnemyBullet temp = (EnemyBullet) enemyBullets.get(i);
            //  Update each bullet's position in the vector
            temp.updatePosition();

            //  If the bullet has gone beyond the bottom edge of the screen, remove it
            if(temp.getYCoordinate() > d.height)
            {
                enemyBullets.remove(i--);
            }
            //  Otherwise, draw the bullet at its new updated location
            else
            {
                temp.draw(g, temp.getXCoordinate(), temp.getYCoordinate());
            }
        }
    }

    //------------------------------------------------------------------------------
    //  Assorted Helper-Methods Located Below Here
    //------------------------------------------------------------------------------
    
    //*****************************************************************************************
    //  Method that draws the vector of ships passed to it
    //*****************************************************************************************
    protected void drawShip(Graphics g, Vector tempVector)
    {
        for(int i = 0; i < tempVector.size(); i++)
        {
            //  i = each individual ship in the Vector
            
            //  Temp variable for accessing each ship in the Vector
            Sprite tempShip = (Sprite) tempVector.get(i);
            
            //  Draws each ship
            tempShip.draw(g, tempShip.getXCoordinate(), tempShip.getYCoordinate());
        }
    }

    //******************************************************************************
    //  Method that Initializes all the enemy vectors
    //******************************************************************************
    protected void createShips()
    {
        clearVectors();    //  Clear all the vectors in the game
        
        //  Row of Boss Ships
        bosses.add(new BossShip((d.width / 2) - 2 * 45, 100));
        bosses.add(new BossShip((d.width / 2) - 1 * 45, 100));
        bosses.add(new BossShip((d.width / 2) + 0 * 45, 100));
        bosses.add(new BossShip((d.width / 2) + 1 * 45, 100));
    
        //  Row 1 of Butterflies
        butterflies.add(new ButterflyShip((d.width / 2) - 4 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) - 3 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) - 2 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) - 1 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) + 0 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) + 1 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) + 2 * 45, 100 + 48));
        butterflies.add(new ButterflyShip((d.width / 2) + 3 * 45, 100 + 48));
    
        //  Row 2 of Butterflies
        butterflies.add(new ButterflyShip((d.width / 2) - 4 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) - 3 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) - 2 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) - 1 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) + 0 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) + 1 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) + 2 * 45, 100 + 48 + 30));
        butterflies.add(new ButterflyShip((d.width / 2) + 3 * 45, 100 + 48 + 30));
    
        //  Row 1 of Bees
        bees.add(new BeeShip((d.width / 2) - 5 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 4 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 3 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 2 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 1 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 0 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 1 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 2 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 3 * 45, 100 + 48 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 4 * 45, 100 + 48 + 30 + 30));
    
        //  Row 2 of Bees
        bees.add(new BeeShip((d.width / 2) - 5 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 4 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 3 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 2 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 1 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) - 0 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 1 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 2 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 3 * 45, 100 + 48 + 30 + 30 + 30));
        bees.add(new BeeShip((d.width / 2) + 4 * 45, 100 + 48 + 30 + 30 + 30));
    }

    //******************************************************************************
    //  Method that clears all the vectors and reinitializes the player ships
    //******************************************************************************
    protected void clearVectors()
    {
        //  Clear the vectors
        bees.clear();			//  Bees
        bosses.clear();			//  Bosses
        butterflies.clear();	//  Butterflies
        
        //  This is how the player's lives are replenished on each level in 
        //    never-ending mode
        players.clear();
        players.add(new PlayerShip(d.width / 2, 500));
        players.add(new PlayerShip(50 + 50, 600));
        players.add(new PlayerShip(50, 600));
        
        //  Clear the bullet vectors as well
        enemyBullets.clear();
        playerBullets.clear();
    }

    //------------------------------------------------------------------------------
    //  Painting Functions Located Below Here
    //------------------------------------------------------------------------------
    
    //******************************************************************************
    //  Overridden Paint Method that paints the buffer to the screen
    //******************************************************************************
    public void paint(Graphics g)
    {
        g.drawImage(imageBuffer, 0, 0, null);
    }

    //******************************************************************************
    //  Overridden Update Method that calls paint() for smoother animation
    //******************************************************************************
    public void update(Graphics g)
    {
        paint(g);
    }

    //******************************************************************************
    //  Method that creates the image buffer. Think of this method as the 
    //    "paint" method.
    //******************************************************************************
    protected void prepareImageBuffer()
    {
        //  Gets a graphical context -- the buffered image
        Graphics g = imageBuffer.getGraphics();
    
        //  Clears screen
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
    
        //  Calls the method of starfield that draws the stars to the buffer
        starfield.drawStars(g);
    
        if(intro)     //  If in intro stage of game, call the paintIntro() method
        {
            paintIntro(g);
        }
        
        if(game)      //  If in game stage of game, call the paintGame() method
        {
            paintGame(g);
        }
        
        if(ready)     //  If in ready stage of game, call the paintReady() method
        {
            paintReady(g);
        }
        
        if(gameOver)  //  If in over stage of game, call the paintGameOver() method
        {
            paintGameOver(g); 
        }
        
        if(win)       //  If in win stage of game, call the paintWin() method
        {
            paintWin(g);   
        }
    }

    //******************************************************************************
    //  Paints the Intro Screen
    //******************************************************************************
    protected void paintIntro(Graphics g)
    {
        //  Vector of the sprites on screen for scoring
        Vector sprites = new Vector();
        
        //  Fonts used on screen
        Font galaga = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
        Font title = new Font("Papyrus", Font.PLAIN, 18);
        Font scores = new Font("Arial", Font.PLAIN, 18);
        Font instructions = new Font("Arial", Font.PLAIN, 12);
        
        //  Adds one of each sprite to the Sprites Vector
        sprites.add(new BossShip(250, 150));
        sprites.add(new ButterflyShip(253, 205));
        sprites.add(new BeeShip(253, 240));
        
        //  Draws Vector contents
        drawShip(g, sprites);
        
        //  Draws title of game
        g.setFont(galaga);
        g.setColor(Color.ORANGE);
        g.drawString("Galaga", 310, 50);
        
        //  Draws scoring info
        g.setFont(title);
        g.drawString("Scoring", 320, 140);
        g.setFont(title);
        g.setColor(Color.white);
        g.drawString("-----------   200", 320, 180);
        g.drawString("-----------   150", 320, 220);
        g.drawString("-----------   100", 320, 255);
        
        //  Draws instructions
        g.setColor(Color.ORANGE);
        g.drawString("Instructions", 50, 300);
        
        g.setFont(instructions);
        g.setColor(Color.white);
        g.drawString("Use the arrow keys to move left and right.  " +
        		     "Press Spacebar to fire.", 200, 300);
        g.drawString("This game is merely a clone of the famous game " +
        		     "with the same name.", 200, 315);
        g.drawString("As such, certain aspects of the original have not " +
        		     "been implemented.", 200, 330);
        g.drawString("However, this is still fun and rather difficult.", 200, 345);
        g.drawString("There are two game options:  " +
        		     "Never Ending and Single-Level", 200, 375);
        g.drawString("Press 1 to play Never Ending Mode", 210, 390);
        g.drawString("Press 2 to play Single-Level Mode", 210, 405);
    }
    
    //******************************************************************************
    //  Paints the Game Screens
    //******************************************************************************
    protected void paintGame(Graphics g)
    {
        //  Makes sure that there are lives for the player
        if(players.size() != 0)
        {
            //  Draw the score and level information
            Font text = new Font("Papyrus", Font.PLAIN, 14);
            g.setColor(Color.white);
            g.setFont(text);
            g.drawString("Score:  " + score, 20, 20);
            g.drawString("Level:  " + level, d.width - 100, 20);
            g.setColor(Color.blue);
            
            //  Move the bullets
            moveBullets(g);
           
            drawShip(g, players);             //  Draw all the player ships

            drawShip(g, bosses);			  //  Draw the Boss Ships
            moveShips(bosses, g);			  //  Move the Boss Ships
            drawShip(g, butterflies);		  //  Draw the Butterfly Ships
            moveShips(butterflies, g);		  //  Move the Butterfly Ships
            drawShip(g, bees);				  //  Draw the Bee Ships
            moveShips(bees, g);				  //  Move the Bee Ships

            //  Temp Variable for accessing the current player ship
            PlayerShip currentPlayer = (PlayerShip) players.get(0);

            //  If ship is moving right and it's right side is less than the 
            //    right edge
            if(right && (currentPlayer.getRightSide() < 680))
            {
                //  Move ship 5 pixels right
                currentPlayer.translate(5, 0);
            }
            //  If ship is moving left and it's left side is greater than the 
            //    left edge
            if(left && currentPlayer.getLeftSide() > 2)
            {
                //  Move ship 5 pixels right
                currentPlayer.translate(-5, 0);
            }
            //  If in never-ending mode, and all the enemies are gone, 
            //    advance to the next level
            if(neverEnding)
            {
                if(bosses.size() == 0 && bees.size() == 0 && butterflies.size() == 0)
                {
                    game = false;
                    ready = true;
                    level++;
                    createShips();
                }
            }
            //  Otherwise, end the game when all the enemies are gone
            else
            {
                if(bosses.size() == 0 && bees.size() == 0 && butterflies.size() == 0)
                {
                    game = false;
                    win = true;
                }
            }
        }
    }
    
    //******************************************************************************
    //  Paints the Ready Screens
    //******************************************************************************
    protected void paintReady(Graphics g)
    {
        //  Booleans for determining if any ships are moving
        boolean boss, bee, fly;
        
        //  Draw Score and Level information
        Font text = new Font("Papyrus", Font.PLAIN, 14);
        g.setColor(Color.white);
        g.setFont(text);
        g.drawString("Score:  " + score, 20, 20);
        g.drawString("Level:  " + level, d.width - 100, 20);
        g.setColor(Color.blue);
        
        // Move all bullets on screen
        moveBullets(g);
        
        //  Draw the remaining player ships
        if(players.size() != 0)
            for(int i = 1; i < players.size(); i++)
            {
                Sprite tempShip = (Sprite) players.get(i);
                tempShip.draw(g, tempShip.getXCoordinate(), tempShip
                                .getYCoordinate());
            }
        
        drawShip(g, bosses);			//  Draw the Boss Ships
        boss = moveShips(bosses, g);	//  Determine if any bosses are moving
        drawShip(g, butterflies);		//  Draw the Butterfly Ships
        fly = moveShips(butterflies, g);//  Determine if any butterflies are moving
        drawShip(g, bees);				//  Draw the Bee Ships
        bee = moveShips(bees, g);		//  Determine if any bees are moving
        
        //  If no ships are moving:  Ready was triggered by a player loss of life        
        if(boss && bee && fly)
        {
            //  Draw "ready"
            g.drawString("Ready", d.width / 2, d.height / 2);

            //  Draw player ships
            drawShip(g, players);
            
            //  If the screen has shown long enough, go back to game
            if(time == delay)
            {
                ready = false;
                game = true;
                time = 0;
            }
            else	//  Otherwise, increment time
            {
                time++;
            }
        }
        //  If no ships are moving:  Ready was triggered by completion of level
        if(bosses.size() == 0 && bees.size() == 0 && butterflies.size() == 0)
        {
            //  If the screen has shown long enough, go back to game
            if(time == delay)
            {
                ready = false;
                game = true;
                time = 0;
            }
            else	//  Otherwise, increment time
            {
                time++;
            }
        }
    }

    //******************************************************************************
    //  Paints the GameOver Screen
    //******************************************************************************
    protected void paintGameOver(Graphics g)
    {
        //  Font declarations
        Font galaga = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
        Font title = new Font("Papyrus", Font.PLAIN, 18);
        Font text = new Font("Papyrus", Font.PLAIN, 14);

        //  Clear the screen
        Dimension d = frame.getSize();
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

        // Draw the relevant statistics
        g.setFont(galaga);
        g.setColor(Color.ORANGE);
        g.drawString("Game Over", 300, 100);
        g.setFont(title);
        g.setColor(Color.white);
        g.drawString("Shots:  ", 200, 200);
        g.setFont(text);
        String string = "" + shots;
        g.drawString(string, 275, 200);
        g.drawString("Enemies Destroyed:  ", 200, 230);
        g.setFont(text);
        String string2 = "" + kills;
        g.drawString(string2, 350, 230);
        g.drawString("Hit Percentage:  ", 200, 260);
        g.setFont(text);
        if(shots == 0)
            shots = 1;
        String string3 = "" + (((double) kills / shots) * 100) + '%';
        g.drawString(string3, 340, 260);
        g.drawString("Score:  ", 200, 290);
        g.drawString("" + score, 340, 290);

        //  If enough time has passed, return to the intro screen
        if(time > delay)
        {
            gameOver = false;
            intro = true;
            clearVectors();
            time = 0;
            score = 0;
        }
        //  Otherwise, increment the counter
        else
        {
            time++;
        }
    }
    //******************************************************************************
    //  Paints the Win Screens
    //******************************************************************************
    protected void paintWin(Graphics g)
    {
        //  Font declarations
        Font gameOver = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
        Font title = new Font("Papyrus", Font.PLAIN, 18);
        Font text = new Font("Papyrus", Font.PLAIN, 14);
        
        //  Clear the screen
        Dimension d = frame.getSize();
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        
        // Draw the relevant statistics
        g.setFont(gameOver);
        g.setColor(Color.ORANGE);
        g.drawString("You Won", 300, 100);
        g.setFont(title);
        g.setColor(Color.white);
        g.drawString("Shots:  ", 200, 200);
        g.setFont(text);
        String string = "" + shots;
        g.drawString(string, 275, 200);
        g.drawString("Enemies Destroyed:  ", 200, 230);
        g.setFont(text);
        String string2 = "" + kills;
        g.drawString(string2, 350, 230);
        g.drawString("Hit Percentage:  ", 200, 260);
        g.setFont(text);
        if(shots == 0)
            shots = 1;
        String string3 = "" + (((double) kills / shots) * 100) + '%';
        g.drawString(string3, 340, 260);
        g.drawString("Score:  ", 200, 290);
        g.drawString("" + score, 340, 290);
        
        //  If enough time has passed, return to the intro screen
        if(time > delay)
        {
            win = false;
            intro = true;
            clearVectors();
            time = 0;
            score = 0;
        }
        //  Otherwise, increment the counter
        else
        {
            time++;
        }
    }
    

    //******************************************************************************
    //  gameControlListener Class - Encapsulates the key listener as a seperate
    //     class
    //******************************************************************************
    public class gameControlListener implements KeyListener
    {
        //******************************************************************************
        //  Empty Constructor that does nothing
        //******************************************************************************
        public gameControlListener()
        {

        }

        //******************************************************************************
        //  Keys Pressed
        //******************************************************************************
        public void keyPressed(KeyEvent ke)
        {
            //  Left and Right controls
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                right = true;
            if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                left = true;
            
            //  Game Start Controls:  Never-Ending
            if((intro || win || gameOver) && (ke.getKeyCode() == KeyEvent.VK_1 || 
                            ke.getKeyCode() == KeyEvent.VK_NUMPAD1))
            {
                neverEnding = true;
                intro = false;
                win = false;
                gameOver = false;
                ready = true;
                createShips();
                players.clear();
                players.add(new PlayerShip(d.width / 2, 500));
                players.add(new PlayerShip(50 + 50, 600));
                players.add(new PlayerShip(50, 600));
                level = 1;
                repaint();
            }
            //  Game Start Controls:  1 Level
            if((intro || win || gameOver) && (ke.getKeyCode() == KeyEvent.VK_2 || 
                            ke.getKeyCode() == KeyEvent.VK_NUMPAD2))
            {
                neverEnding = false;
                intro = false;
                win = false;
                gameOver = false;
                ready = true;
                players.clear();
                players.add(new PlayerShip(d.width / 2, 500));
                players.add(new PlayerShip(50 + 50, 600));
                players.add(new PlayerShip(50, 600));
                createShips();
                repaint();
            }
        }

        //******************************************************************************
        //  Keys Released
        //******************************************************************************
        public void keyReleased(KeyEvent ke)
        {
            //  Left and Right controls
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                right = false;
            if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                left = false;
            
            //  Player firing of bullets
            if(ke.getKeyCode() == KeyEvent.VK_SPACE && !ready)
            {
                //  Allows for only 2 bullets on screen at a time
                if(playerBullets.size() < 2)
                {
                    //  Temp Player Bullet
                    PlayerBullet temp = new PlayerBullet(0, 0);
                    //  Temp variable to access current player
                    PlayerShip currentPlayer = (PlayerShip) players.get(0);
                    
                    //  Create X and Y coordinates based on player position
                    int x = currentPlayer.getXCenter();
                    int y = currentPlayer.getYCoordinate() 
                            - temp.getDimension().height;

                    //  Create new bullet
                    temp = new PlayerBullet(x, y);
                    //  Add bullet to vector
                    playerBullets.add(temp);
                    //  Increment Shots Value
                    shots++;
                }
            }
            
        }

        //******************************************************************************
        //  Keys Typed - I have no idea what this does...  So it does nothing
        //******************************************************************************
        public void keyTyped(KeyEvent ke)
        {

        }
    }

    //******************************************************************************
    //  Hey, there is that main method!!!  I know you've been looking for it...
    //******************************************************************************
    public static void main(String[] args)
    {
        //  Creates a new instance of the class Galaga
        
        Galaga SHAHEIN_HAS_FINISHED_THIS_GAME_FINALLY = new Galaga();
        
        //  I think that line is rather self-explanatory...
    }
}