//  Stars.java
//  Created on Jan 11, 2005
//  Created by Shahein Tajmir
//

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;
import java.lang.Math;

public class Stars extends JPanel
{
    private JFrame appDisplay;
    private final int DELAY = 80;
    private Timer timer;
    Graphic test = new Graphic();
    int x = 20, y = 20, moveX = 40, moveY = 40;
    int[] xValues = new int[]  {10, 12, 20, 12, 10, 8, 0, 8};
    int [] yValues = new int[]  { 0, 7, 10, 13, 20, 13, 10, 8};
    int[] tempX = xValues, tempY = yValues, empty = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
    int counter = 0;
    
    Shape star = new Polygon(xValues, yValues, 8);
    Shape star2;
    
    public Stars()
    {
        setPreferredSize(new Dimension(150, 150));
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
    
    protected void paintComponent(Graphics g2)
    {
        super.paintComponent(g2);
        
        
        

        Graphics2D g = (Graphics2D) g2;
        test.draw(g2, 0, 0);
        //Shape triangle = new Polygon(new int[] {15, 20, 10}, new int[] {0, 10, 10}, 3);
        
        
        Shape square = new Rectangle2D.Double(0, 0, 30, 30);
        
        g.setColor(Color.white);
        
        g.translate(20, 20);
        //g.rotate(theta, 10, 10);
        //g.fill(star);
        
        //g.setColor(new Color(0, 86, 141));
        //g.fill(square);
        if(star2 != null)
            g.fill(star2);
        
        
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
        Stars moon = new Stars();
    }
}
