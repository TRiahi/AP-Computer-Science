package imageprocessing;

import java.util.StringTokenizer;
import java.awt.*;
import java.awt.image.*;
import java.awt.geom.AffineTransform;
import java.net.*;
import javax.swing.*;
import java.io.Serializable;
import java.io.*;
import javax.imageio.ImageIO;

/**
 * <p>RGBImage is a class for images which is supposed to be easier to
 * use than the classes for image processing in the Java SDK API.  The
 * RGImage class contains three two-dimensional short arrays
 * (matrices) called red green and blue which contains the pixel
 * values of the image. Other colours then the three primary colours
 * are composed as a combination of red, green and blue.
 *
 * <p>In order to be viewed properly, the colour values must be set in
 * the interval from 0 to 255.
 *
 * <p>The RGBImage class contains methods for setting and getting the
 * color matrices, showing the image, saving the image to a file and
 * reading the images from a file or from a web-location.
 * 
 * <p>Here is a <a href="../../RGBImage.java">link</a> to
 * the source code.
 *
 * @see imageprocessing.IntensityImage
 * @see imageprocessing.BinaryImage
 * @see imageprocessing.HSIImage
 * @author Per-Olav Rus&aring;s
 */
public class RGBImage implements Serializable
{
   /**
    * The Matrix with the red component of the image.
    */
   protected short[][] red;

   /**
    * The Matrix with the green component of the image.
    */
   protected short[][] green;

   /**
    * The Matrix with the blue component of the image.
    */
   protected short[][] blue;

   protected int imageType;

   private static final int RED = 3;
   private static final int GREEN = 2;
   private static final int BLUE = 1;

   public static final int NN_INTERPOL = 10;
   public static final int BL_INTERPOL = 11;
   
   /**
    * Creates an empty RGBImage object.
    */
   public RGBImage()
   {
      setColorImage (true);
   }

   /**
    * A constructor that sets the color matrices.
    * @param red The red component of the image.
    * @param green The green component of the image.
    * @param blue The blue component of the image.
    */
   public RGBImage (short[][] red, short[][] green, short[][] blue)
   {
      this();
      this.red = red;
      this.green = green;
      this.blue = blue;
   }

   /**
    * A copy-constructor which copy another RGBImage.
    * @param otherImage Another RGBImage.
    */
   public RGBImage (RGBImage otherImage)
   {
      imageType = otherImage.imageType;
      red = copy (otherImage.red);
      green = copy (otherImage.green);
      blue = copy (otherImage.blue);
   }


   /**
    * Gets the reference to the matrix with the red colour component
    * of the image. This method does not make a copy of the the
    * matrix, but returns the reference to the RGBImage's colour
    * matrix. This means that the returned reference can be used to
    * manipulate the colour of the RGBImage.
    * @return The red colour matrix.
    */
   public short[][] getRed(){ return red; }

   /**
    * Gets the reference to the matrix with the green colour component
    * of the image. This method does not make a copy of the the
    * matrix, but returns the reference to the RGBImage's colour
    * matrix. This means that the returned reference can be used to
    * manipulate the colour of the RGBImage.
    * @return The green colour matrix.
    */
   public short[][] getGreen(){ return green; }

   /**
    * Gets the reference to the matrix with the blue colour component
    * of the image. This method does not make a copy of the the
    * matrix, but returns the reference to the RGBImage's colour
    * matrix. This means that the returned reference can be used to
    * manipulate the colour of the RGBImage.
    * @return The blue colour matrix.
    */
   public short[][] getBlue(){ return blue; }

  
   /**
    * Sets the red component of the image.
    * @param red Matrix with the red colour values.
    */
   public void setRed (short[][] red)
   {
      this.red = red;
   }


   /**
    * Sets the green component of the image.
    * @param green Matrix with the green colour values.
    */
   public void setGreen (short[][] green)
   {
      this.green = green;
   }

   /**
    * Sets the blue component of the image.
    * @param blue Matrix with the blue colour values.
    */
   public void setBlue (short[][] blue)
   {
      this.blue = blue;
   }
   

   /**
    * The weights of the colors are usually different when the image
    * is shown as a color image, or as a gray image. This method can
    * be used to force the image to be shown as a color or gray
    * image.
    * @param isColorImage true if image is to be shown as a colored image. 
    */
   public void setColorImage (boolean isColorImage)
   {
      if (isColorImage)
         imageType = BufferedImage.TYPE_INT_RGB;
      else
         imageType = BufferedImage.TYPE_BYTE_GRAY;
   }

   /**
    * Returns true if the image will be shown as a colored image.
    * @return true if image will be shown as a colored image. 
    */
   public boolean isColorImage()
   {
      return (imageType < BufferedImage.TYPE_BYTE_GRAY);
   }
   

   /**
    * The width of the image. If some of the matrixes are missing, the
    * method returns -1.
    * @return The width of the image if all the matrices exist. 
    */ 
   public int getWidth()
   {
      if (red != null && green != null && blue != null)
         return red[0].length;
      else
         return -1;
   }

   /**
    * The height of the image. If some of the matrixes are missing, the
    * method returns -1.
    * @return The height of the image if all the matrices exist. 
    */ 
   public int getHeight()
   {
      if (red != null && green != null && blue != null)
         return red.length;
      else
         return -1;
   }

   /**
    * Returns a description of the image.
    * @return A description.
    */
   public String toString()
   {
      return "RGBImage-object:" +
         "\n\tWidth:  " + getWidth() +
         "\n\tHeight: " + getHeight() +
         "\n\tImage type: " + imageType;
   }

   /**
    * Set the BufferedImage of the RGBImage.
    * @param bImage the BufferedImage.
    */
   public void setBImage (BufferedImage bImage)
   {
      updateMatrices (bImage);
   }


   /**
    * Make a BufferedImage of the RGBImage
    * @return a BufferedImage representing the RGBImage.
    */
   public BufferedImage makeBufferedImage()
   {
      BufferedImage bImage = new BufferedImage (getWidth(), getHeight(),
                                                imageType);

      int shiftR = 8*(RED-1);
      int shiftG = 8*(GREEN-1);
      int shiftB = 1;

      int rows = getHeight();
      int cols = getWidth();
      int[] data = new int[rows*cols];
      int index;

      for (int row = 0; row < rows; row++)
      {
         for (int col = 0; col < cols; col++)
         {
            index = row*cols + col;

            data[index] = (red[row][col] << shiftR) |
               (green[row][col] << shiftG) |
               blue[row][col];
         }
      }
      
      setRGBData (bImage, data);
      return bImage;
   }


   private void updateMatrices (BufferedImage bImage)
   {
      
      int shiftR = 8*(RED-1);
      int shiftG = 8*(GREEN-1);
      int shiftB = 8*(BLUE-1);
      
      int bR = 255 << shiftR;
      int bG = 255 << shiftG;
      int bB = 255 << shiftB;
      
      int rows = bImage.getHeight();
      int cols = bImage.getWidth();
      
      red = new short[rows][cols];
      green = new short[rows][cols];
      blue = new short[rows][cols];
      
      int[] data = getRGBData (bImage);
      int index;
      
      for (int row = 0; row < rows; row++)
      {
         for (int col = 0; col < cols; col++)
         {
            index = row*cols + col;
            red[row][col] = (short)((data[index] & bR) >> shiftR);
            green[row][col] = (short)((data[index] & bG) >> shiftG);
            blue[row][col] = (short)((data[index] & bB) >> shiftB);
         }
      }
   }


   /**
    * Load an image from a URL.
    * @param url the URL of the web-location containing an image file
    */
   public void loadURL (String url) throws IOException
   {
      URL u;
      try
      {
         u = new URL (url);
      }
      catch (MalformedURLException mfu)
      {
         mfu.printStackTrace();
         return;
      }

      updateMatrices (ImageIO.read (u));
   }


   /**
    * Load an image from a file.
    * @param filename The name of the image file. 
    */
   public void loadFile (String filename)
      throws IOException
   {

      BufferedImage bImage = ImageIO.read (new File (filename));

      setColorImage (bImage.getType() < BufferedImage.TYPE_BYTE_GRAY);

      updateMatrices(bImage);
 
   }


   private static int[] getRGBData (BufferedImage bImage)
   {
      return bImage.getRGB (0, 0, 
                            bImage.getWidth(), bImage.getHeight(),
                            null, 0, bImage.getWidth());
   }

   
   private static void setRGBData (BufferedImage bImage, int[] data)
   {
      bImage.setRGB (0, 0, bImage.getWidth(), bImage.getHeight(), data, 
                     0, bImage.getWidth());
   }


   /**
    * Save the image to a file. The format of the file is determined
    * by the extension of the filename (jpg, gif or png).
    * @param filename the name of the file.
    */
   public void save (String filename) throws IOException
   {
      StringTokenizer st = new StringTokenizer (filename, ".");
      st.nextToken();
      String format = st.nextToken();

      ImageIO.write (makeBufferedImage(), format, new File (filename));
   }


   /**
    * Save the image to a JPEG-file.
    * @param filename the name of the file.
    * @param quality the quality of the image, between 0.0 and 1.0
    */
   public void saveAsJPEG (String filename, double quality)
      throws IOException
   {
      BufferedImage bImage = makeBufferedImage();
      ImageIOTools.saveAsJPEG (bImage, filename, (float)quality);
   }


   /**
    * Draw the image to a Graphics object at a given position.
    * @param g The Graphics object to draw on.
    * @param x The horizontal position of the image.
    * @param y The vertical position of the image.
    */
   public void draw (Graphics g, int x, int y)
   {
      BufferedImage bImage = makeBufferedImage();
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(bImage, new AffineTransform(1f,0f,0f,1f,x,y), null);
   }


   /**
    * Draw the image to a Graphics object at a given position with a
    * given scale and rotation.
    * @param g The Graphics object to draw on.
    * @param x The horizontal position of the image.
    * @param y The vertical position of the image.
    * @param scaleX The scale in x-direction. 1.0 means unscaled.
    * @param scaleY The scale in y-direction. 1.0 means unscaled.
    * @param rotateAngle Rotation of the image in degrees (0-360).
    */
   public void draw (Graphics g, int x, int y, double scaleX, double scaleY,
		     double rotateAngle)
   {
      BufferedImage bImage = makeBufferedImage();
      double rotateRadians = rotateAngle*Math.PI/180.0;
      AffineTransform transformer = new AffineTransform();
      transformer.scale (scaleX, scaleY);
      transformer.rotate (rotateRadians);

      AffineTransformOp transOp = new AffineTransformOp (transformer,
                                AffineTransformOp.TYPE_BILINEAR );

      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage (bImage, transOp, x, y);
   }


   /**
    * Show a JOptionPane-window including the image. The window is
    * modal, which means that the program waits until it is closed.
    * @param title A text placed on the bar on top of the window.
    */ 
   public void show (String title)
   {
      BufferedImage bImage = makeBufferedImage();
      if (bImage.getWidth() != 0)
      {
	 ImageIcon icon = new ImageIcon (bImage);
	 JOptionPane.showMessageDialog (null, "", title,
					JOptionPane.INFORMATION_MESSAGE,
                                        icon);
      }
      else
      {
	 JOptionPane.showMessageDialog (null,
					"Error: The RGBImage object is empty",
					"No image",
					JOptionPane.ERROR_MESSAGE);
      }
   }


   /**
    * Shows a JOptionPane-window including the image. The window is
    * modal, which means that the program waits until it is closed.
    */ 
   public void show()
   {
      show ("");
   }


   /**
    * Shows the RGBImage scaled with use of nearest neighbor
    * interpolation. This method utilizes an ImageScaler to perform
    * the scaling.
    * @param scale The scale.
    * @param title The title on top of the window.
    */
   public void show (double scale, String title)
   {
      createScaledImage (scale, NN_INTERPOL).show (title);
   }


   /**
    * Shows the RGBImage scaled with use of bilinear
    * interpolation. This method utilizes an ImageScaler to perform
    * the scaling.
    * @param scale The scale.
    * @param title The title on top of the window.
    */
   public void showBL (double scale, String title)
   {
      createScaledImage (scale, BL_INTERPOL).show (title);
   }

   
   /**
    * Creates a scaled image. This method utilizes an ImageScaler to
    * perform the scaling. The parameter interpolType may be one of
    * the constants RGBImage.NN_INTERPOL for nearest neighbor
    * interpolation or RGBImage.BL_INTERPOL for bilinear interpolation.
    * @param scale The scale.
    * @param interpolType The type of interpolation
    */    
   public RGBImage createScaledImage (double scale, int interpolType)
   {
      ImageScaler redScaler = new ImageScaler (red);
      ImageScaler greenScaler = new ImageScaler (green);
      ImageScaler blueScaler = new ImageScaler (blue);

      if (interpolType == NN_INTERPOL)
      {
         redScaler.scaleNN (scale);
         greenScaler.scaleNN (scale);
         blueScaler.scaleNN (scale);
      }
      else if (interpolType == BL_INTERPOL)
      {
         redScaler.scaleBL (scale);
         greenScaler.scaleBL (scale);
         blueScaler.scaleBL (scale);
      }
      else
      {
         throw new RuntimeException ("\n----------------\n"
                                     + "Error in HSIImage.createScaledImage."
                                     + "\nImpossible value of parameter "
                                     + "interpolType,\nshould be either "
                                     + "RGBImage.NN_INTERPOL or "
                                     + "RGBImage.BL_INTERPOL"
                                     + "\n----------------\n");
      }


      return new RGBImage (redScaler.getProcessedData(),
                           greenScaler.getProcessedData(),
                           blueScaler.getProcessedData());
   }      

      
   /**
    * A method for copying of two-dimensional arrays (matrices).
    * @param array The array to be copied.
    * @return A copy of the array.
    */
   public static short[][] copy (short[][] array)
   {
      short[][] copiedArray = new short[array.length][array[0].length];

      for (int row = 0; row < array.length; row++)
      {
         for (int col = 0; col < array[0].length; col++)
         {
            copiedArray[row][col] = array[row][col];
         }
      }

      return copiedArray;
   }

}
