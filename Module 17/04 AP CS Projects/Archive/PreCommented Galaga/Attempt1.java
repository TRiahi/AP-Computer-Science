// Attempt1.java
//  Created by Shahein Tajmir
//  1/27/05
//  This program will attempt to rewrite the code for the basic basic basic
// shooter into a JFrame

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Attempt1 extends JPanel implements Runnable
{
    //  Variable Declarations
    Graphics gr;

    Polygon ship = new Polygon();

    boolean right = false, left = false;

    Vector bullets = new Vector();

    JFrame frame;

    public Attempt1()
    {
        frame = new JFrame("Attempt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setBackground(Color.BLACK);

        frame.addKeyListener(new gameControlListener());
        ship.addPoint(120, 550);
        ship.addPoint(135, 510);
        ship.addPoint(150, 550);

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
                if(right && ship.xpoints[2] < 500)
                {
                    clearShip();
                    ship.translate(1, 0);
                    drawShip();
                }
                if(left && ship.xpoints[0] > 2)
                {
                    clearShip();
                    ship.translate(-1, 0);
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
            gr.fillRect(bul.x, bul.y--, 2, 7);
            bul.y--;
            bul.y--;
            if(bul.y < 1)
                bullets.remove(i--);
            else
            {
                gr.setColor(Color.orange);
                gr.fillRect(bul.x, bul.y, 2, 7);
            }
        }
    }

    //  Clear the ship - used when moving left and right
    private void clearShip()
    {
        gr.setColor(Color.black);
        gr.drawPolygon(ship);
    }

    // redraw the ship
    private void drawShip()
    {
        gr.setColor(Color.RED);
        gr.drawPolygon(ship);
    }

    // paint function -- for the first painting
    public void paint(Graphics g)
    {
        if(gr == null)
            gr = getGraphics();
        g.setColor(Color.red);
        g.drawPolygon(ship);
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
                    bullets.add(new Point(ship.xpoints[1], ship.ypoints[1] - 6));
            }
        }

        // key typed
        public void keyTyped(KeyEvent ke)
        {

        }
    }

    public static void main(String[] args)
    {
        Attempt1 hey = new Attempt1();
    }
}