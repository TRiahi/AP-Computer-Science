// Galaga.java
//  Created by Shahein Tajmir
//  3/6/05
//  This is the "final" version of Galaga.  With the great exception of commenting, the 
//  game is now done.

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

    //******************************************************************************
    //  Consolidating method that combines all the collision detection into one 
    //******************************************************************************
    public void collisions()
    {
        enemyBulletPlayerCollision();
        playerBulletEnemyCollision();
        playerEnemyShipCollision(bosses);
        playerEnemyShipCollision(butterflies);
        playerEnemyShipCollision(bees);
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
    public void playerBulletEnemyCollision()
    {
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
                    //  Temp variable for accessing each boss ship
                    BossShip tempShip = (BossShip) bosses.get(i);
                    //  If the bullet's top y-coordinate is below the ship's
                    if(tempBullet.getYCoordinate() > tempShip.getYCoordinate()
                                    & tempBullet.y < tempShip.getYCoordinate() + 48)
                    {
                        if(tempBullet.x > tempShip.getXCoordinate()
                                        & tempBullet.x < tempShip.getXCoordinate() + 45)
                        {
                            if(tempShip.getHits() < 1)
                            {
                                tempShip.hit();
                                playerBullets.remove(a);
                                score += tempShip.getScore() / 2;
                            }
                            else if(tempShip.getHits() == 1)
                            {
                                bosses.remove(i);
                                playerBullets.remove(a);
                                kills++;
                                System.out.println(tempShip.getID());
                                
                                score += tempShip.getScore();
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < butterflies.size(); i++)
        {
            // Tests for collission between enemy bullet and player ship
            // a - refers to the individual bullet coordinates
            for(int a = 0; a < playerBullets.size(); a++)
            {
                //  Tests for collision between player bullets and enemy ships
                if(playerBullets.size() != 0 && butterflies.size() != 0)
                {
                    PlayerBullet tempBullet = (PlayerBullet) playerBullets.get(a);
                    Sprite tempShip = (Sprite) butterflies.get(i);
                    if(tempBullet.y > tempShip.getYCoordinate()
                                    & tempBullet.y < tempShip.getYCoordinate() + 48)
                    {
                        if(tempBullet.x > tempShip.getXCoordinate()
                                        & tempBullet.x < tempShip.getXCoordinate() + 45)
                        {
                            butterflies.remove(i);
                            playerBullets.remove(a);
                            kills++;
                            score += tempShip.getScore() / 2;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < bees.size(); i++)
        {
            // Tests for collission between enemy bullet and player ship
            // a - refers to the individual bullet coordinates
            for(int a = 0; a < playerBullets.size(); a++)
            {
                //  Tests for collision between player bullets and enemy ships
                if(playerBullets.size() != 0 && bees.size() != 0)
                {
                    PlayerBullet tempBullet = (PlayerBullet) playerBullets.get(a);
                    Sprite tempShip = (Sprite) bees.get(i);
                    if(tempBullet.y > tempShip.getYCoordinate()
                                    & tempBullet.y < tempShip.getYCoordinate() + 48)
                    {
                        if(tempBullet.x > tempShip.getXCoordinate()
                                        & tempBullet.x < tempShip.getXCoordinate() + 45)
                        {
                            bees.remove(i);
                            playerBullets.remove(a);
                            kills++;
                            score += tempShip.getScore() / 2;
                        }
                    }
                }
            }
        }
    }

    //******************************************************************************
    //  Tests for collision between player and enemy ship
    //******************************************************************************
    public void playerEnemyShipCollision(Vector tempVector)
    {
        //  i - refers to the number of enemies on screen
        for(int i = 0; i < tempVector.size(); i++)
        {
            if(tempVector.size() > 0)
            {
                if(players.size() == 0)
                {
                    gameOver = true;
                    game = false;
                }
    
                if(players.size() > 0 && !ready)
                {
                    Sprite tempShip = (Sprite) tempVector.get(i);
                    PlayerShip currentPlayer = (PlayerShip) players.get(0);
    
                    if((currentPlayer.getXCoordinate()
                                    + currentPlayer.getDimension().width > tempShip
                                    .getXCoordinate())
                                    && (currentPlayer.getXCoordinate() < tempShip
                                                    .getXCoordinate()
                                                    + tempShip.getDimension().width))
                    {
                        if(((currentPlayer.getYCoordinate() + currentPlayer
                                        .getDimension().height) > (tempShip
                                        .getYCoordinate()))
                                        && ((currentPlayer.getYCoordinate() < tempShip
                                                        .getYCoordinate()
                                                        + tempShip.getDimension().height)))
                        {
                            //  Initialize explosion graphic
                            players.remove(0);
                            tempVector.remove(i);
    
                            if(players.size() != 0)
                            {
                                ready = true;
                                game = false;
                                Sprite tempShip2 = (Sprite) players.get(0);
                                tempShip2.setPosition(d.width / 2, 500);
                            }
                            repaint();
                        }
                    }
                }
            }
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
        bees.clear();
        bosses.clear();
        butterflies.clear();
        
        players.clear();
        players.add(new PlayerShip(d.width / 2, 500));
        players.add(new PlayerShip(50 + 50, 600));
        players.add(new PlayerShip(50, 600));
        
        enemyBullets.clear();
        playerBullets.clear();
    }
    
    public boolean moveShips(Vector tempVector, Graphics g)
    {
        int counter = 0;
        
        for(int i = 0; i < tempVector.size(); i++)
        {
            Sprite tempShip = (Sprite) tempVector.get(i);
            
            if(tempShip.isAttacking() || tempShip.isRetreating())
                counter++;
        }
        
        for(int i = 0; i < tempVector.size(); i++)
        {
            Sprite tempShip = (Sprite) tempVector.get(i);
            
            if(tempShip.checkTime())
            {
                
                if(tempShip.isAttacking() && tempShip.attackPoints == null)
                {
                    if(counter < level && !ready)
                    assignCurve(g, tempShip);
                    tempShip.attackShip(enemyBullets, (PlayerShip) players.get(0));
                }
                if(tempShip.isAttacking()
                                && tempShip.attackPoints[tempShip.attackPoints.length - 1] == null)
                {
                    if(counter < level && !ready)
                    assignCurve(g, tempShip);
                    tempShip.attackShip(enemyBullets, (PlayerShip) players.get(0));
                }
                if(tempShip.isAttacking())
                {
                    tempShip.attackShip(enemyBullets, (PlayerShip) players.get(0));
                }
                if(tempShip.isRetreating())
                {
                    tempShip.retreatShip(enemyBullets);
                }
            }
        }
        if(counter == 0)
            return true;
        else
            return false;
    }

    //******************************************************************************
    //  Creates the image buffer. Think of this method as the "paint" method.
    //******************************************************************************
    public void prepareImageBuffer()
    {
        //  Gets a graphical context -- the buffered image
        Graphics g = imageBuffer.getGraphics();
        Font instructions = new Font("Arial", Font.PLAIN, 12);
    
        //  Clears screen
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
    
        //  Calls the method of starfield that draws the stars to the buffer
        starfield.drawStars(g);
    
        //  Info such as score, etc will be written in here
    
        //  This preserves the sprites
        //g.setXORMode(Color.BLACK);
    
        if(intro)
        {
            paintIntro(g);
        }
        if(game)
        {
            if(players.size() != 0)
            {
                //  Draw Player Sprites
                Font text = new Font("Papyrus", Font.PLAIN, 14);
                g.setColor(Color.white);
                g.setFont(text);
                g.drawString("Score:  " + score, 20, 20);
                g.drawString("Level:  " + level, d.width - 100, 20);
                g.setColor(Color.blue);
                moveBullets(g);
                drawShip(g, players);
    
                drawShip(g, bosses);
                moveShips(bosses, g);
                drawShip(g, butterflies);
                moveShips(butterflies, g);
                drawShip(g, bees);
                moveShips(bees, g);
    
                PlayerShip currentPlayer = (PlayerShip) players.get(0);
    
                if(right && (currentPlayer.getRightSide() < 650))
                {
                    currentPlayer.translate(5, 0);
                }
                if(left && currentPlayer.getLeftSide() > 2)
                {
                    currentPlayer.translate(-5, 0);
                }
                if(neverEnding)
                {
                    if(bosses.size() == 0 && bees.size() == 0
                                    && butterflies.size() == 0)
                    {
                        game = false;
                        ready = true;
                        level++;
                        createShips();
                    }
                }
                else
                {
                    if(bosses.size() == 0 && bees.size() == 0
                                    && butterflies.size() == 0)
                    {
                        game = false;
                        win = true;
                    }
                }
            }      
        }
        if(ready)
        {
            boolean boss, bee, fly;
            Font text = new Font("Papyrus", Font.PLAIN, 14);
            g.setColor(Color.white);
            g.setFont(text);
            g.drawString("Score:  " + score, 20, 20);
            g.drawString("Level:  " + level, d.width - 100, 20);
            g.setColor(Color.blue);
            
            moveBullets(g);
            
            if(players.size() != 0)
                for(int i = 1; i < players.size(); i++)
                {
                    Sprite tempShip = (Sprite) players.get(i);
                    tempShip.draw(g, tempShip.getXCoordinate(), tempShip
                                    .getYCoordinate());
                }
            
            
            drawShip(g, bosses);
            boss = moveShips(bosses, g);
            drawShip(g, butterflies);
            fly = moveShips(butterflies, g);
            drawShip(g, bees);
            bee = moveShips(bees, g);
            
            
            if(boss && bee && fly)
            {
                g.drawString("Ready", d.width / 2, d.height / 2);
    
                drawShip(g, players);
                
                if(time == delay)
                {
                    ready = false;
                    game = true;
                    time = 0;
                }
                else
                {
                    time++;
                }
            }
            if(bosses.size() == 0 && bees.size() == 0 && butterflies.size() == 0)
            {
                if(time == delay)
                {
                    ready = false;
                    game = true;
                    time = 0;
                }
                else
                {
                    time++;
                }
            }
    
        }
        if(gameOver)
        {
            paintGameOver(g);
            
        }
        if(win)
        {
            paintWin(g);
            
        }
    }
    
    public void assignCurve(Graphics g, Sprite tempShip)
    {
        Vector tempPoints = new Vector();
    	Point points2[];
        Graphics2D g2 = (Graphics2D) g;
        //BossShip tempShip = (BossShip) bosses.get(0);
        tempShip.setMoving(true);
        Shape curve = generateCurve((PlayerShip) players.get(0), tempShip);
        
        PathIterator p = curve.getPathIterator(null);
        FlatteningPathIterator f = new FlatteningPathIterator(p, 0.02);
        
        while(!f.isDone())
        {
            double[] points = new double[6];
            switch(f.currentSegment(points))
            {
                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                    g2.fill(new Ellipse2D.Double(points[0], points[1], 3, 3));
                    tempPoints.add(new Point((int) points[0], (int) points[1]));
            }
            f.next();
        }
        points2 = new Point[tempPoints.size()];
        for(int i = 0; i < tempPoints.size(); i++)
        {
            points2[i] = (Point) tempPoints.get(i);
        }
        
        tempShip.setCurve(points2);
        tempShip.setAttack(true);
    }
    
    public Shape generateCurve(Sprite player, Sprite enemy)
    {
        Shape curve = null;
        if(enemy.getXCenter() < d.width / 2)
            curve =  new CubicCurve2D.Double(enemy.getXCenter(), enemy.getYCenter(), d.width, enemy.getYCenter(), enemy.getXCenter(), d.height, player.getXCenter(), player.getYCenter());
        if(enemy.getXCenter() >= d.width / 2)
            curve =  new CubicCurve2D.Double(enemy.getXCenter(), enemy.getYCenter(), 0, enemy.getYCenter(), enemy.getXCenter(), d.height, player.getXCenter(), player.getYCenter());
        return curve;
    }

    private void moveBullets(Graphics g)
    {
        movePlayerBullets(g);
        moveEnemyBullets(g);
    }

    //*****************************************************************************************
    //  BulletManaging - This moves the bullets
    //*****************************************************************************************
    private void movePlayerBullets(Graphics g)
    {
        for(int i = 0; i < playerBullets.size(); i++)
        {
            PlayerBullet temp = (PlayerBullet) playerBullets.get(i);
            temp.translate(0, -12);
    
            if(temp.getYCoordinate() < 1)
            {
                playerBullets.remove(i--);
            }
            else
            {
                temp.draw(g, temp.getXCoordinate(), temp.getYCoordinate());
            }
        }
    }

    private void moveEnemyBullets(Graphics g)
    {
        for(int i = 0; i < enemyBullets.size(); i++)
        {
            EnemyBullet temp = (EnemyBullet) enemyBullets.get(i);
            temp.updatePosition();
            //temp.draw(g, temp.getXCoordinate(), temp.getYCoordinate());

            if(temp.getYCoordinate() > d.height)
            {
                enemyBullets.remove(i--);
            }
            else
            {
                temp.draw(g, temp.getXCoordinate(), temp.getYCoordinate());
            }
        }
    }

    //*****************************************************************************************
    //  Draw the player ship
    //*****************************************************************************************
    private void drawShip(Graphics g, Vector tempVector)
    {
        for(int i = 0; i < tempVector.size(); i++)
        {
            Sprite tempShip = (Sprite) tempVector.get(i);
            tempShip.draw(g, tempShip.getXCoordinate(), tempShip.getYCoordinate());
        }
    }

    //*****************************************************************************************
    //  Painting Functions Located Below Here
    //*****************************************************************************************
    public void paint(Graphics g)
    {
        g.drawImage(imageBuffer, 0, 0, null);
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    //*****************************************************************************************
    //  Paints the Intro Screen
    //*****************************************************************************************
    private void paintIntro(Graphics g)
    {
        Vector sprites = new Vector();
        Font galaga = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
        Font title = new Font("Papyrus", Font.PLAIN, 18);
        Font scores = new Font("Arial", Font.PLAIN, 18);
        Font instructions = new Font("Arial", Font.PLAIN, 12);
        
        sprites.add(new BossShip(250, 150));
        sprites.add(new ButterflyShip(253, 205));
        sprites.add(new BeeShip(253, 240));
        drawShip(g, sprites);
        
        g.setFont(galaga);
        g.setColor(Color.ORANGE);
        g.drawString("Galaga", 310, 50);
        
        g.setFont(title);
        g.drawString("Scoring", 320, 140);
        g.setFont(title);
        g.setColor(Color.white);
        g.drawString("-----------   200", 320, 180);
        g.drawString("-----------   150", 320, 220);
        g.drawString("-----------   100", 320, 255);
        
        g.setColor(Color.ORANGE);
        g.drawString("Instructions", 50, 300);
        
        g.setFont(instructions);
        g.setColor(Color.white);
        g.drawString("Use the arrow keys to move left and right.  Press Spacebar to fire.",
                                        200, 300);
        g.drawString("This game is merely a clone of the famous game with the same name.",
                        200, 315);
        g.drawString("As such, certain aspects of the original have not been implemented.",
                                        200, 330);
        g.drawString("However, this is still fun and rather difficult.",
                                        200, 345);
        g.drawString("There are two game options:  Never Ending and Single-Level", 200,
                        375);
        g.drawString("Press 1 to play Never Ending Mode", 210,
                        390);
        g.drawString("Press 2 to play Single-Level Mode", 210,
                        405);
    }

    //*****************************************************************************************
    //  Paints the GameOver Screen
    //*****************************************************************************************
    private void paintGameOver(Graphics g)
    {
        //time = 0;
        Font galaga = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
        Font title = new Font("Papyrus", Font.PLAIN, 18);
        Font text = new Font("Papyrus", Font.PLAIN, 14);

        Dimension d = frame.getSize();
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

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

        if(time > delay)
        {
            gameOver = false;
            intro = true;
            clearVectors();
            time = 0;
            score = 0;
        }
        else
        {
            time++;
        }
    }
    
    private void paintWin(Graphics g)
    {
        //time = 0;
        Font gameOver = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
        Font title = new Font("Papyrus", Font.PLAIN, 18);
        Font text = new Font("Papyrus", Font.PLAIN, 14);
        
        Dimension d = frame.getSize();
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);
        
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
        
        if(time > delay)
        {
            win = false;
            intro = true;
            clearVectors();
            time = 0;
            score = 0;
        }
        else
        {
            time++;
        }
    }
    

    //*****************************************************************************************
    //  gameControlListener Class - Encapsulates the key listener as a seperate
    // class
    //*****************************************************************************************
    public class gameControlListener implements KeyListener

    {
        public gameControlListener()
        {

        }

        //*****************************************************************************************
        //  keys pressed
        //*****************************************************************************************
        public void keyPressed(KeyEvent ke)
        {
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                right = true;
            if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                left = true;
            if(intro && ke.getKeyCode() == KeyEvent.VK_ENTER)
            {
                
            }
            if((intro || win || gameOver) && (ke.getKeyCode() == KeyEvent.VK_1 || ke.getKeyCode() == KeyEvent.VK_NUMPAD1))
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
            if((intro || win || gameOver) && (ke.getKeyCode() == KeyEvent.VK_2 || ke.getKeyCode() == KeyEvent.VK_NUMPAD2))
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
            if(game && ke.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                game = false;
                gameOver = true;
                repaint();

            }
        }

        //*****************************************************************************************
        //  keys released
        //*****************************************************************************************
        public void keyReleased(KeyEvent ke)
        {
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                right = false;
            if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                left = false;
            if(ke.getKeyCode() == KeyEvent.VK_SPACE && !ready)
            {
                if(playerBullets.size() < 2)
                {
                    PlayerBullet temp;
                    PlayerShip currentPlayer = (PlayerShip) players.get(0);
                    
                    int x = currentPlayer.getXCoordinate();
                    int y = currentPlayer.getYCoordinate();

                    temp = new PlayerBullet(x + (49 / 2), y - 24);

                    playerBullets.add(temp);
                    shots++;
                }
            }
            
        }

        //*****************************************************************************************
        //  keys typed
        //*****************************************************************************************
        public void keyTyped(KeyEvent ke)
        {

        }
    }

    public static void main(String[] args)
    {
        Galaga hey = new Galaga();
    }
}