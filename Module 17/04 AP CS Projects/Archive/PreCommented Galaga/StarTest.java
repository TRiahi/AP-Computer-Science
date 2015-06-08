//  Stars.java
//  Created on Jan 11, 2005
//  Created by Shahein Tajmir
//

import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.*;

import javax.swing.*;
import java.lang.Math;

public class StarTest extends JPanel
{
    private static Color colors[] = { Color.blue, Color.green, Color.red };
    private JFrame appDisplay;
    private final int DELAY = 80;
    private Timer timer;
    //Sprite test = new BossShip(0, 0);
    int x = 20, y = 20, moveX = 40, moveY = 40;
    int[] xValues = new int[]  {10, 12, 20, 12, 10, 8, 0, 8};
    int [] yValues = new int[]  { 0, 7, 10, 13, 20, 13, 10, 8};
    int[] tempX = xValues, tempY = yValues, empty = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
    int counter = 0;
    
    Shape star = new Polygon(xValues, yValues, 8);
    Shape star2;
    
    public StarTest()
    {
        setPreferredSize(new Dimension(750, 750));
        setBackground(new Color(0, 86, 141));
        appDisplay = new JFrame("Stars");
        appDisplay.getContentPane().add(this);
        appDisplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appDisplay.pack();
        appDisplay.setVisible(true);
        timer = new Timer(DELAY, null);
        timer.addActionListener(new StarListener());
        timer.start();
        
        
        
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
        

        Graphics2D g2 = (Graphics2D) g;
       // test.draw(g, 0, 0);
        //Shape triangle = new Polygon(new int[] {15, 20, 10}, new int[] {0, 10, 10}, 3);
        
        
        Shape square = new Rectangle2D.Double(0, 0, 30, 30);
        
        g.setColor(Color.white);
        
        //g.translate(20, 20);
        //g.rotate(theta, 10, 10);
        //g.fill(star);
        
        //g.setColor(new Color(0, 86, 141));
        //g.fill(square);
        //if(star2 != null)
        //    g2.fill(star2);
        //Graphics2D g2 = (Graphics2D) g;
        Dimension d = getSize();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setBackground(getBackground());
        g2.clearRect(0, 0, d.width, d.height);
        drawDemo(d.width, d.height, g2);
        
        //Graphics2D g3 = (Graphics2D) g;
        //3.fill(star);
        
        //g.setStroke(new BasicStroke(1));
        //g.translate(x, y);
        //g.draw(line);
        //g.draw(line2);
    
    }
    
    protected void rotatePoints()
    {
        
        if (counter < 17)
        {
        for(int i = 0; i < xValues.length; i++)
            tempX[i] = (int) (xValues[i] * Math.cos(3.14159265/12) + yValues[i] * Math.sin(3.14159265/12));
        for(int i = 0; i < yValues.length; i++)
            tempY[i] = (int) (xValues[i] * (-Math.sin(3.14159265/12)) +  yValues[i] * Math.cos(3.14159265/12));
        counter++;
        }
        
        if(counter == 17)
        {
            tempX = xValues;
            tempY = xValues;
            counter = 0;
        }
        
        
        
        star2 = new Polygon(tempX, tempY, 8);
    }
    
    public void drawDemo(int w, int h, Graphics2D g2)
    {

        int y = 0;
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5.0f));

        // draws 3 quad curves and 3 cubic curves.
        for(int i = 0; i < 2; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                Shape shape = null;

                if(i == 0)
               {
                    shape = new CubicCurve2D.Float(700, 100, 0, 100, 600, 650, 600, 650);
               }
                else
                {
                    shape = new CubicCurve2D.Float(0, 0, 700, 0, 0, 700, 700, 700);
                }
                g2.setColor(colors[j]);
                if(j != 2)
                    g2.draw(shape);

                if(j == 1)
                {
                    g2.setColor(Color.lightGray);

                    /*
                     * creates an iterator object to iterate the boundary of the
                     * curve.
                     */
                    PathIterator f = shape.getPathIterator(null);

                    /*
                     * while iteration of the curve is still in process fills
                     * rectangles at the endpoints and control points of the
                     * curve.
                     */
                    while(!f.isDone())
                    {
                        float[] pts = new float[6];
                        switch(f.currentSegment(pts))
                        {
                            case PathIterator.SEG_MOVETO:
                            case PathIterator.SEG_LINETO:
                                g2.fill(new Rectangle2D.Float(pts[0], pts[1], 5, 5));
                                break;
                            case PathIterator.SEG_CUBICTO:
                            case PathIterator.SEG_QUADTO:
                                g2.fill(new Rectangle2D.Float(pts[0], pts[1], 5, 5));
                                if(pts[2] != 0)
                                {
                                    g2.fill(new Rectangle2D.Float(pts[2], pts[3], 5,
                                                    5));
                                }
                                if(pts[4] != 0)
                                {
                                    g2.fill(new Rectangle2D.Float(pts[4], pts[5], 5,
                                                    5));
                                }
                        }
                        f.next();
                    }

                }
                else if(j == 2)
                {
                    // draws red ellipses along the flattened curve.
                    PathIterator p = shape.getPathIterator(null);
                    FlatteningPathIterator f = new FlatteningPathIterator(p, 0.1);
                    while(!f.isDone())
                    {
                        float[] pts = new float[6];
                        switch(f.currentSegment(pts))
                        {
                            case PathIterator.SEG_MOVETO:
                            case PathIterator.SEG_LINETO:
                                g2.fill(new Ellipse2D.Float(pts[0], pts[1], 3, 3));
                        }
                        f.next();
                    }
                }
            }
        }
    }
    
    
    
    private class StarListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            
            rotatePoints();
            repaint();
        
        }
        
    }
    
    public static void main(String[] args)
    {
        StarTest moon = new StarTest();
    }
}
