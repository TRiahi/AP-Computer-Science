// Attempt1.java
//  Created by Shahein Tajmir
//  1/27/05
//  This program will replace the triangle of Attempt 1 with my ship

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;

public class Attempt2 extends JPanel implements Runnable
{
    //  Variable Declarations
    Graphics gr;

    PlayerShip ship = new PlayerShip(500, 500); // an object of the ship class
    Shape box = new Rectangle2D.Double(500, 500, 49, 50);

    boolean right = false, left = false;
    int x, y;

    Vector bullets = new Vector();

    JFrame frame;

    public Attempt2()
    {
        frame = new JFrame("Attempt 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setBackground(Color.BLACK);

        frame.addKeyListener(new gameControlListener());

        frame.pack();
        frame.getContentPane().add(this);
        frame.setSize(700, 700);

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
        Graphics2D g3 = (Graphics2D) gr;
        Shape test = new Rectangle2D.Double(ship.getXCoordinate(), ship.getYCoordinate(), 49, 50);
        g3.setColor(Color.black);
        g3.draw(test);
    }

    // redraw the ship
    private void drawShip()
    {
        Graphics2D g3 = (Graphics2D) gr;
        ship.draw(g3, ship.getXCoordinate(), ship.getYCoordinate());
    }

    // paint function -- for the first painting
    public void paint(Graphics g)
    {
        if(gr == null)
            gr = getGraphics();
        ship.draw(g, ship.getXCoordinate(), ship.getYCoordinate());
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
                    bullets.add(new Point(ship.getXCoordinate() + (49 / 2), ship.getYCoordinate() - 15));
            }
        }

        // key typed
        public void keyTyped(KeyEvent ke)
        {

        }
    }

    public static void main(String[] args)
    {
        Attempt2 hey = new Attempt2();
    }
}