// Galaga.java
//  Created by Shahein Tajmir
//  1/27/05
//  This program will be the beginnings of Galaga with my ship and really bad title screens

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

public class Galaga extends JPanel implements Runnable
{
    //  Variable Declarations
    Graphics gr;

    Ship ship = new Ship(500, 500); // an object of the ship class

    Shape box = new Rectangle2D.Double(500, 500, 49, 50);

    boolean right = false, left = false;

    boolean intro, game, gameOver;

    int x, y;
    
    int shots = 0;
    int kills = 0;

    Vector bullets = new Vector();

    JFrame frame;

    public Galaga()
    {
        frame = new JFrame("Galaga");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setBackground(Color.BLACK);

        frame.addKeyListener(new gameControlListener());

        frame.pack();
        frame.getContentPane().add(this);
        frame.setSize(700, 700);

        intro = true;
        game = false;
        gameOver = false;
        
        Thread thread = new Thread(this);
        thread.start();
        frame.show();
    }

    //  This is the function that is executed each time the thread is called
    // (repeatedly)
    public void run()
    {
        while(true)
        {
            try
            {

                if(gameOver)
                {
                    //gameOver();
                }

                if(game)
                {

                    if(right && ship.getRightSide() < 600)
                    {
                        clearShip();
                        ship.translate(2, 0);
                        drawShip();
                    }
                    if(left && ship.getLeftSide() > 2)
                    {
                        clearShip();
                        ship.translate(-2, 0);
                        drawShip();
                    }
                    moveBullets();
                    Thread.sleep(5);
                }
            }
            catch(Exception e)
            {

            }
        }
    }

    //  This moves the bullets
    private void moveBullets()
    {
        int tempY;
        for(int i = 0; i < bullets.size(); i++)
        {
            Point bul = (Point) bullets.get(i);
            gr.setColor(Color.black);
            gr.fillRect(bul.x, bul.y--, 2, 15);
            bul.y--;
            bul.y--;
            bul.y--;
            bul.y--;
            if(bul.y < 1)
                bullets.remove(i--);
            else
            {
                gr.setColor(Color.white);
                gr.fillRect(bul.x, bul.y, 2, 15);
            }
        }
    }

    //  Clear the ship - used when moving left and right
    private void clearShip()
    {
        //Graphics2D g3 = (Graphics2D) gr;
        //Shape test = new Rectangle2D.Double(ship.getXCoordinate(), ship.getYCoordinate(), 49, 50);
        gr.setColor(Color.black);
        gr.fillRect(ship.getXCoordinate(), ship.getYCoordinate(), 49, 50);
    }

    // redraw the ship
    private void drawShip()
    {
       // Graphics2D g3 = (Graphics2D) gr;
        ship.draw(gr, ship.getXCoordinate(), ship.getYCoordinate());
    }

    // paint function -- for the first painting
    public void paint(Graphics g)
    {
        if(gr == null)
            gr = getGraphics();
        if(intro)
        {
            Font galaga = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
            Font title = new Font("Papyrus", Font.PLAIN, 18);
            Font instructions = new Font("Arial", Font.PLAIN, 12);
            g.setFont(galaga);
            g.setColor(Color.ORANGE);
            g.drawString("Galaga", 300, 100);
            g.setFont(title);
            g.drawString("Basic Instructions", 200, 275);
            g.setFont(instructions);
            g.setColor(Color.white);
            g.drawString("Use the arrow keys to move left and right.  Press Spacebar to fire.", 200, 300);
            g.drawString("This is not even an Alpha version of Galaga--more like version -1.", 200, 315);
            g.drawString("So, there is no actual game present.  Thus, you can't normally access the closing screen..", 200, 330);
            g.drawString("To do that, you must press escape during the game.  Yes...ESCAPE!", 200, 345);
            g.drawString("However, if you want to see my \"game\", press enter.  Understood?", 200, 360);

        }
        if(game)
        {
            Dimension d = frame.getSize();
            g.setColor(Color.black);
            g.fillRect(0, 0, d.width, d.height);
            ship.draw(g, ship.getXCoordinate(), ship.getYCoordinate());
        }
        if(gameOver)
        {
            Font gameOver = new Font("Papyrus", Font.BOLD | Font.ITALIC, 26);
            Font title = new Font("Papyrus", Font.PLAIN, 18);
            Font text = new Font("Papyrus", Font.PLAIN, 14);
            
            Dimension d = frame.getSize();
            gr.setColor(Color.black);
            g.fillRect(0, 0, d.width, d.height);
            
            g.setFont(gameOver);
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
            String string3 = "" + ((kills / shots) * 100) + '%';
            g.drawString(string3, 340, 260);
        }
    }

    public class gameControlListener implements KeyListener
    {
        public gameControlListener()
        {

        }

        //  key pressing
        public void keyPressed(KeyEvent ke)
        {
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                right = true;
            if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                left = true;
            if(intro && ke.getKeyCode() == KeyEvent.VK_ENTER)
            {
                intro = false;
                game = true;
                repaint();
            }
            if(game && ke.getKeyCode() == KeyEvent.VK_ESCAPE)
            {
                game = false;
                gameOver = true;
                repaint();
                
            }
        }

        // key released
        public void keyReleased(KeyEvent ke)
        {
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
                right = false;
            if(ke.getKeyCode() == KeyEvent.VK_LEFT)
                left = false;
            if(ke.getKeyCode() == KeyEvent.VK_SPACE)
            {
                if(bullets.size() < 2)
                {
                    bullets.add(new Point(ship.getXCoordinate() + (49 / 2), ship.getYCoordinate() - 15));
                    shots++;
                }
            }
        }

        // key typed
        public void keyTyped(KeyEvent ke)
        {
            
        }
    }

    public static void main(String[] args)
    {
        Galaga hey = new Galaga();
    }
}