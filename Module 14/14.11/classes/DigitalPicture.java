import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * Interface to describe a digital picture.  A digital picture can have an 
 * associated file name.  It can have a title.  It has pixels 
 * associated with it and you can get and set the pixels.  You 
 * can get an Image from a picture or a BufferedImage.  You can load
 * it from a file name or image.  You can show a picture.  You can 
 * explore a picture.  You can create a new image for it.
 * 
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public interface DigitalPicture 
{
  public String getFileName(); // get the file name that the picture came from
  public String getTitle(); // get the title of the picture
  public void setTitle(String title); // set the title of the picture
  public int getWidth(); // get the width of the picture in pixels
  public int getHeight(); // get the height of the picture in pixels
  public Image getImage(); // get the image from the picture
  public BufferedImage getBufferedImage(); // get the buffered image
  public int getBasicPixel(int x, int y); // get the pixel information as an int   
  public void setBasicPixel(int x, int y, int rgb); // set the pixel information
  public Pixel getPixel(int x, int y); // get the pixel information as an object
  public Pixel[] getPixels(); // get all pixels in row-major order
  public Pixel[][] getPixels2D(); // get 2-D array of pixels in row-major order
  public void load(Image image); // load the image into the picture
  public boolean load(String fileName); // load the picture from a file
  public void show(); // show the picture 
  public void explore(); // explore the picture
  public boolean write(String fileName); // write out a file
}
