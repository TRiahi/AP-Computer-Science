import java.awt.*;

import javax.swing.*;

public class MyClass extends JFrame implements Render//, Runnable
{

   private int x1, y1, x2, y2, level;
   Image imageBuff;
   
   public MyClass(){
      super("Contour Drawing");
      x1=0;
      x2=0;
      y1=0;
      y2=0;
      level=0;
      setSize(400, 600);
      show();
      imageBuff = createImage(400, 600);
      //thread = new Thread(this);
 //     thread.setPriority(5);
  //    thread.start();
   }

   public void drawContour(double startX, double startY, double endX, double endY, double contourLevel){

      x1 = (int)((startX+1.5)/3.0*400);
      y1 = (int)((startY+1.5)/3.0*600);
      x2 = (int)((endX+1.5)/3.0*400);
      y2 = (int)((endY+1.5)/3.0*600);
      level = (int) contourLevel; //corresponds to contour levels in array named "level" in Main

      //System.out.println(x1 + ", " + y1 + ", " + x2 + ", " + y2 + ", " + level + "\n");
      buffer();
   }
   
   /*public void run()
   {
       while(true)
           {
           		repaint();
                
           		try
                {
                    Thread.sleep(8);   //  Sleep the thread for 8 milliseconds
                }
                catch(InterruptedException e)
                {
                    //  Catch the potential interrupted exception and do nothing
                }
           		
           }
       
   }*/

   public void buffer()
   {
       Graphics g = imageBuff.getGraphics();
       
       //g.setColor(Color.lightGray);
      // g.fillRect(0, 0, 400, 600);
       
       int red=0;
       int blue=255;
       int green=0;

       red = 0;
       blue = 10 * level;
       green = 0;
       Color cc = new Color(red, green, blue);
       g.setColor(cc);
       g.drawLine(x1, y1, x2, y2);
       
       repaint();
   }
   

   public void paint(Graphics g)
   {
       g.drawImage(imageBuff, 0, 0, null);
   }


   public void update(Graphics g)
   {
       paint(g);
   }

}
