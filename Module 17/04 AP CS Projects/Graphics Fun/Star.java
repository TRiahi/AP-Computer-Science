
import java.awt.*; // This library includes the graphics functions
import java.applet.Applet; // This library is needed for applets
import java.awt.event.*; // This library is needed for event handling

public class Star extends Applet implements Runnable
{

    // This creates the variable starThread of type Thread
    // using threads allows for different tasks to happen
    // at the same time.
    Thread starThread;

    // The variable out is used as a flag as to whether or not the
    // mouse cursor is in the game.
    // if out = 1 then the game is paused
    public int out = 0;

    // The following variables are used obvious
    public boolean gameover = false;

    public int kills = 0;

    public int health = 100;

    // This variable modifies how long the explosion sprite should be displayed
    public int deathWait = 12;

    // These three variable are used to determine the random time between
    // enemies appearing
    public int randomSeed = 50;

    public int randomTime = (int) (((Math.random() * randomSeed) + 1) + 50);

    public int timeInc = 0;

    // These arrays are used to hold varius data concerning the enemies
    // These could be grouped into a single object
    public int enemyX[];

    public int enemyY[];

    public int enemySpeed[];

    public int enemyOpen[];

    public int enemyType[];

    public int enemyDeath[];

    public int enemySlope[];

    // These arrays contain data about the bullets being fired from the ship
    // again they could be grouped into a single object
    public int bX[];

    public int bY[];

    public int bOpen[];

    public int bType[];

    public int numBullets = 20;

    public int numStars = 30;

    public int bulletShot = 0;

    // These are for the star field
    public int starsX[];

    public int starsY[];

    // These can modify the screen size
    public int xSize = 640, ySize = 480;

    // These variables can be changed to speed up or slow down the game
    public int speed = 6;

    public int sleepTime = 16;

    // These are the coordinates for the space ship
    public int shipX = (xSize / 2) - 17;

    public int shipY = ySize - 80;

    // This is used for image buffering
    Image imageBuffer;

    // These variables hold the images for the game
    Image ship;

    Image enemy1;

    Image enemy2;

    Image ex;

    Image b1;

    Image b2;

    // This method initializes the some of the variables to be use in the game

    public void init()
    {
        setSize(xSize, ySize);
        enemyX = new int[5]; // The number 5 indicates that there are 5 enemies
                             // that are going to be cycled through
        enemyY = new int[5];
        enemySpeed = new int[5];
        enemyOpen = new int[5];
        enemyType = new int[5];
        enemyDeath = new int[5];
        enemySlope = new int[5];
        bX = new int[numBullets];
        bY = new int[numBullets];
        bOpen = new int[numBullets];
        bType = new int[numBullets];
        ship = getImage(getCodeBase(), "ship.gif"); // This is how easy it is to
                                                    // load a graphic
        enemy1 = getImage(getCodeBase(), "enemy1.gif");
        enemy2 = getImage(getCodeBase(), "enemy2.gif");
        ex = getImage(getCodeBase(), "ex.gif");
        b1 = getImage(getCodeBase(), "b1.gif");
        b2 = getImage(getCodeBase(), "b2.gif");
        initStars();
        repaint();
        addMouseListener(new LocalMouseListener(this));
        addMouseMotionListener(new LocalMouseMotionListener(this));
    }

    // When the applet starts the thread starts!
    public void start()
    {
        if(starThread == null)
        {
            starThread = new Thread(this);
            starThread.setPriority(5);
            starThread.start();
        }
    }

    // When the applet stops the thread stops!
    public void stop()
    {
        if(starThread != null)
        {
            starThread.stop();
            starThread = null;
        }
    }

    // This will create a new enemy to scroll down the screen
    // Again there are only really 5 enemies that are cycled through
    // then enemyOpen[] array determines whether an enemy is currently "alive"
    public void newEnemy()
    {
        int r = 0;
        for(int a = 0; a < 5; a++)
        {
            if(r == 0 & enemyOpen[a] == 0)
            {
                enemyOpen[a] = 1;
                r = 1;
                enemySpeed[a] = (int) ((Math.random() * 5) + 1);
                enemyType[a] = (int) ((Math.random() * 2) + 1);
                enemySlope[a] = (int) (((Math.random() * 3) + 1) - 1);
                int t = (int) ((Math.random() * 2) + 1);
                if(t == 1)
                {
                    enemySlope[a] = -(enemySlope[a]);
                }
                enemyX[a] = (int) ((Math.random() * (xSize - 32)) + 1);
                enemyY[a] = -32;
                randomTime = (int) (((Math.random() * randomSeed) + 1) + 50);
                timeInc = 0;
            }
        }
    }

    // This is the heart of the program
    // It runs over and over again while the thread is active and the program is
    // going!
    public void run()
    {
        while(true)
        {
            if(health == 0)
            {
                kills = 0;
                health = 100;
                gameover = true;
            }
            timeInc++; // This will call the newEnemy method if a random time
                       // has elapsed for a new enemy to appear
            if(timeInc == randomTime)
            {
                newEnemy();
            }
            moveEnemys(); // These methods update the sprites positions
            moveStars();
            moveBullets();
            collisions();
            prepareImageBuffer(); // This method prepares the screen to be drawn
            repaint(); // This draws the graphics to the screen
            try
            { // This pauses the game
                starThread.sleep(sleepTime);
            }
            catch(InterruptedException e)
            {
            }
        }
    }

    // This creates the starfield in the background
    public void initStars()
    {
        imageBuffer = createImage(xSize, ySize);
        starsX = new int[numStars];
        starsY = new int[numStars];
        for(int a = 0; a < numStars; a++)
        {
            starsX[a] = (int) ((Math.random() * xSize - 1) + 1);
            starsY[a] = (int) ((Math.random() * ySize - 1) + 1);
        }
    }

    // This method moves the enemies
    public void moveEnemys()
    {
        for(int i = 0; i < 5; i++)
        {
            if(enemyX[i] + enemySlope[i] < 0)
            { // These statements move the enemies haphazardly left and right
                enemySlope[i] *= -1;
            }
            if(enemyX[i] + enemySlope[i] > xSize - 32)
            {
                enemySlope[i] *= -1;
            }
            enemyX[i] += enemySlope[i];
            int a = (int) ((Math.random() * 150) + 1);
            if(a == 3)
            {
                enemySlope[i] *= -1;
            }
            if(a == 5 & Math.abs(enemySlope[i]) < 8)
            {
                enemySlope[i] *= -2;
            }
            if(a == 6 & Math.abs(enemySlope[i]) > 0)
            {
                enemySlope[i] /= -2;
            }

            if(enemyOpen[i] > 0)
            {
                if(enemyOpen[i] == 2)
                {
                    if(enemyDeath[i] == deathWait)
                    {
                        enemyOpen[i] = 0;
                    }
                    else
                    {
                        enemyDeath[i]++;
                    }
                }
                if(enemyY[i] > ySize)
                {
                    enemyOpen[i] = 0;
                }
                else
                {
                    enemyY[i] += enemySpeed[i] + (speed - 6); // This moves the
                                                              // enemy down
                }
            }
        }
    }

    // This method simply tests for collisions between the sprites on the screen
    public void collisions()
    {
        if(out == 0)
        {
            for(int i = 0; i < 5; i++)
            {
                // Tests for collission between bullet and player ship
                for(int a = 0; a < numBullets; a++)
                {
                    if(bOpen[a] == 1)
                    {
                        if(bY[a] > shipY & bY[a] < shipY + 32)
                        {
                            if(bX[a] > shipX & bX[a] < shipX + 32)
                            {
                                bOpen[a] = 0;
                                health -= 5;
                            }
                        }
                    }
                    //  Tests for collision between bullets and enemy ships
                    if(bOpen[a] == 1 & enemyOpen[i] == 1)
                    {
                        if(bY[a] > enemyY[i] & bY[a] < enemyY[i] + 32)
                        {
                            if(bX[a] > enemyX[i] & bX[a] < enemyX[i] + 32)
                            {
                                enemyDeath[i] = 0;
                                enemyOpen[i] = 2;
                                bOpen[a] = 0;
                                kills++;
                            }
                        }
                    }
                }
                //  Tests for colision between enemy and player ship
                if(enemyOpen[i] == 1)
                {
                    if((shipX + 32 > enemyX[i]) & (shipX < enemyX[i] + 32))
                    {
                        if((shipY + 32 > enemyY[i]) & (shipY < enemyY[i] + 36))
                        {
                            enemyDeath[i] = 0;
                            enemyOpen[i] = 2;
                            health -= 5;
                        }
                    }
                }
            }
        }
    }

    // If a bullet has been fired this will move it
    public void moveBullets()
    {
        for(int i = 0; i < numBullets; i++)
        {
            if(bOpen[i] == 1)
            {
                if(bY[i] < 5)
                {
                    bOpen[i] = 0;
                }
                else
                {
                    if(bType[i] == 1)
                    {
                        bY[i] -= 2;
                    }
                    else
                    {
                        bY[i] -= 4;
                    }
                }
            }
        }
    }

    // If a star in the background reaches the bottome then it will go back to
    // the top
    public void moveStars()
    {
        for(int a = 0; a < numStars; a++)
        {
            if(starsY[a] + 1 > ySize - (speed * 2))
            {
                starsY[a] = 0;
            }
            else
            {
                starsY[a] += speed;
            }
        }
    }

    // This prepares the graphics to being drawn to the screen
    public void prepareImageBuffer()
    {
        Graphics g = imageBuffer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, xSize, ySize);
        g.setColor(Color.blue);
        for(int a = 0; a < numStars; a++)
        {
            g.drawRect(starsX[a], starsY[a], 1, 1);
        }

        g.setColor(Color.yellow);
        g.drawString("Kills = " + kills, 5, 20);
        g.drawString("Health = " + health + "%", xSize - 80, 20);
        if(out == 0)
        {
            if(gameover == true)
            {
                g.drawString("Game Over", (xSize / 2) - 15, ySize / 2);
            }
        }
        else
        {
            g.drawString("Game Paused", (xSize / 2) - 23, ySize / 2);
        }
        g.setXORMode(Color.black); // This allows sprites to preserve the
                                   // background

        for(int q = 0; q < numBullets; q++)
        {
            if(bOpen[q] == 1)
            {
                if(bType[q] == 1)
                {
                    g.drawImage(b1, bX[q] - (b1.getWidth(this) / 2), bY[q] - b1.getHeight(this), this);
                }
                else
                {
                    g.drawImage(b2, bX[q] - (b1.getWidth(this) / 2), bY[q] - b1.getHeight(this), this);
                }
            }
        }

        for(int i = 0; i < 5; i++)
        {
            if(enemyOpen[i] == 2)
            {
                g.drawImage(ex, enemyX[i], enemyY[i], this);
            }
            if(enemyOpen[i] == 1)
            {
                if(enemyType[i] == 1)
                {
                    g.drawImage(enemy1, enemyX[i], enemyY[i], this);
                }
                else
                {
                    g.drawImage(enemy2, enemyX[i], enemyY[i], this);
                }
            }
        }

        g.drawImage(ship, shipX, shipY, this);
    }

    // This draws the graphics to the screen
    public void paint(Graphics g)
    {
        g.drawImage(imageBuffer, 0, 0, this);
    }

    // This overides the update method for smooth animation
    public void update(Graphics g)
    {
        paint(g);
    }

    // This class listens for the mouse to be moved or dragged
    // when the mouse is dragged than a bullet is fired!
    // Also, when shift is held down then the ship goes wherever the mouse goes.
    // If alt is held down than a different bullet is fired!
    class LocalMouseMotionListener implements MouseMotionListener
    {
        Star parent;

        LocalMouseMotionListener(Star p)
        {
            parent = p;
        }

        public void mouseDragged(MouseEvent e)
        {
            int r = 0;

            if(bulletShot == 4)
            {
                if(gameover == true)
                {
                    gameover = false;
                }
                for(int a = 0; a < numBullets; a++)
                {
                    if(bOpen[a] == 0 & r == 0)
                    {
                        if(e.isAltDown() == true)
                        {
                            bType[a] = 2;
                        }
                        else
                        {
                            bType[a] = 1;
                        }
                        bX[a] = shipX + 16;
                        bY[a] = shipY - 1;
                        bOpen[a] = 1;
                        r = 1;
                    }
                }
                bulletShot = 0;
            }
            else
            {
                bulletShot++;
            }

            int xx = e.getX();
            int yy = e.getY();

            if(yy < shipY - 32)
            {
                speed = 9;
            }
            else
            {
                speed = 6;
            }

            if(e.isShiftDown() == true)
            {
                if(yy < ySize & yy > 100)
                {
                    shipY = yy - 16;
                }
            }

            if(xx < xSize & xx > 1)
            {
                shipX = xx - 16;
            }
        }

        public void mouseMoved(MouseEvent e)
        {
            int xx = e.getX();
            int yy = e.getY();

            if(yy < shipY - 32)
            {
                speed = 9;
            }
            else
            {
                speed = 6;
            }

            if(e.isShiftDown() == true)
            {
                if(yy < ySize & yy > 100)
                {
                    shipY = yy - 16;
                }
            }

            if(xx < xSize & xx > 1)
            {
                shipX = xx - 16;
            }
        }
    }

    // This class handles mouse clicking and whether or not the mouse is in the
    // game!
    // Again if alt is down a different bullet is fired.
    // I trap for all events that involve clicking and releasing the mouse
    // button to ensure that the bullet is fired.
    class LocalMouseListener implements MouseListener
    {
        Star parent;

        LocalMouseListener(Star p)
        {
            parent = p;
        }

        public void mouseClicked(MouseEvent e)
        {
            int r = 0;
            if(gameover == true)
            {
                gameover = false;
            }
            for(int a = 0; a < numBullets; a++)
            {
                if(bOpen[a] == 0 & r == 0)
                {
                    if(e.isAltDown() == true)
                    {
                        bType[a] = 2;
                    }
                    else
                    {
                        bType[a] = 1;
                    }
                    bX[a] = shipX + 16;
                    bY[a] = shipY - 1;
                    bOpen[a] = 1;
                    r = 1;
                }
            }
        }

        public void mouseReleased(MouseEvent e)
        {
            int r = 0;
            if(gameover == true)
            {
                gameover = false;
            }
            for(int a = 0; a < numBullets; a++)
            {
                if(bOpen[a] == 0 & r == 0)
                {
                    if(e.isAltDown() == true)
                    {
                        bType[a] = 2;
                    }
                    else
                    {
                        bType[a] = 1;
                    }
                    bX[a] = shipX + 16;
                    bY[a] = shipY - 1;
                    bOpen[a] = 1;
                    r = 1;
                }
            }
        }

        public void mouseEntered(MouseEvent e)
        {
            out = 0;
        }

        public void mouseExited(MouseEvent e)
        {
            out = 1;
        }

        public void mousePressed(MouseEvent e)
        {
            int r = 0;
            if(gameover == true)
            {
                gameover = false;
            }
            for(int a = 0; a < numBullets; a++)
            {
                if(bOpen[a] == 0 & r == 0)
                {
                    if(e.isAltDown() == true)
                    {
                        bType[a] = 2;
                    }
                    else
                    {
                        bType[a] = 1;
                    }
                    bX[a] = shipX + 16;
                    bY[a] = shipY - 1;
                    bOpen[a] = 1;
                    r = 1;
                }
            }
        }
    }

}