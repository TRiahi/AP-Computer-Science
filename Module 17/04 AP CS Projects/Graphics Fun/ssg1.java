/*
 * Created on Jan 23, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Shahein
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class ssg1 extends Applet implements KeyListener, Runnable
{
    Graphics gr;

    Polygon ship = new Polygon();

    boolean right = false;

    boolean left = false;

    Vector bulets = new Vector();

    public void init()
    {
        setSize(600, 600);
        setBackground(Color.black);
        addKeyListener(this);
        ship.addPoint(120, 550);
        ship.addPoint(135, 510);
        ship.addPoint(150, 550);
        Thread thread = new Thread(this);
        thread.start();
    }

    public void keyPressed(KeyEvent ke)
    {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
            right = true;
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
            left = true;
    }

    public void keyReleased(KeyEvent ke)
    {
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
            right = false;
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
            left = false;
        if (ke.getKeyCode() == KeyEvent.VK_SPACE)
        {
            bulets.add(new Point(ship.xpoints[1], ship.ypoints[1] - 6));
        }
    }

    public void keyTyped(KeyEvent ke)
    {
    }

    public void run()
    {
        while (true)
        {
            try
            {
                if (right && ship.xpoints[2] < 500)
                {
                    clearShip();
                    ship.translate(1, 0);
                    drowShip();
                }
                if (left && ship.xpoints[0] > 2)
                {
                    clearShip();
                    ship.translate(-1, 0);
                    drowShip();
                }
                moveBulets();
                Thread.sleep(5);
            }
            catch (Exception e)
            {
            }
        }
    }

    void moveBulets()
    {
        for (int b = 0; b < bulets.size(); b++)
        {
            Point bul = (Point) bulets.get(b);
            gr.setColor(Color.black);
            gr.fillRect(bul.x, bul.y--, 2, 7);
            if (bul.y < 1)
            {
                bulets.remove(b--);
            }
            else
            {
                gr.setColor(Color.orange);
                gr.fillRect(bul.x, bul.y, 2, 7);
            }
        }
    }

    void clearShip()
    {
        gr.setColor(Color.black);
        gr.drawPolygon(ship);
    }

    void drowShip()
    {
        gr.setColor(Color.red);
        gr.drawPolygon(ship);
    }

    public void paint(Graphics g)
    {
        if (gr == null)
            gr = getGraphics();
        g.setColor(Color.red);
        g.drawPolygon(ship);
    }
}

