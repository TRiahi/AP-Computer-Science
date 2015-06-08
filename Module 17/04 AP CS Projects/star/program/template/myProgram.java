import java.awt.*;				
import java.applet.Applet;			
import java.awt.event.*;			

public class myProgram extends Applet implements Runnable {
Thread myThread;			


        public void init () {
         repaint();
         addMouseListener(new LocalMouseListener(this));
         addMouseMotionListener(new LocalMouseMotionListener(this));
        }
    

        public void start() {
         if(myThread==null) {
          myThread = new Thread(this);
          myThread.setPriority(5);
	  myThread.start();
         }
        }


        public void stop() {
         if(myThread!=null) {
          myThread.stop();
          myThread = null;
         }
        }


        public void run() {
         while (true) {
          prepareImageBuffer();		
          repaint();			
          try {				
           starThread.sleep(sleepTime);
          }
          catch(InterruptedException e) {}
         }
        } 

        public void prepareImageBuffer() {
         Graphics g = imageBuffer.getGraphics();
        }

        public void paint (Graphics g) {
         g.drawImage(imageBuffer, 0, 0, this);
        }


        public void update(Graphics g) {
         paint(g);
        }


        class LocalMouseMotionListener implements MouseMotionListener {
         myProgram parent;
         LocalMouseMotionListener(Star p) {parent = p;}
         public void mouseDragged (MouseEvent e) {} 
     	 public void mouseMoved (MouseEvent e) {}
	}
	

        class LocalMouseListener implements MouseListener {
         myProgram parent;
         LocalMouseListener(Star p) {parent = p;}
         public void mouseClicked (MouseEvent e) {}
         public void mouseReleased (MouseEvent e) {}
         public void mouseEntered (MouseEvent e) {}
         public void mouseExited (MouseEvent e) {}
         public void mousePressed (MouseEvent e) {}  
	}

}
