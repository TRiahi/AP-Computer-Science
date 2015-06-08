import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.io.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
         pixelObj.setRed(0);
         pixelObj.setGreen(0);
      }
    }
  }

  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
         pixelObj.setBlue(0);
         pixelObj.setRed(0);
      }
    }
  }
  
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
         pixelObj.setBlue(0);
         pixelObj.setGreen(0);
      }
    }
  }
  
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(pixelObj.getRed() - 255);
        pixelObj.setGreen(pixelObj.getGreen() - 255);
        pixelObj.setBlue(pixelObj.getBlue() - 255);
      }
    }
  }
  
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {   
        int avg = (int)((pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3);
        pixelObj.setRed(avg);
        pixelObj.setBlue(avg);
        pixelObj.setGreen(avg);
      }
    }
  }
  
  public void invert()
  {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length; row++)
      {
          for (int col = 0; col < pixels[0].length; col++)
          {
              int red = 255 - pixels[row][col].getRed();
              int green = 255 - pixels[row][col].getGreen();
              int blue = 255 - pixels[row][col].getBlue();
              
              Color newColor = new Color(red, green, blue);
              
              pixels[row][col].setColor(newColor);
          }
      }
  }
  
  public void darken(int amount)
  {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length; row++)
      {
          for (int col = 0; col < pixels[0].length; col++)
          {
              int red = pixels[row][col].getRed() - amount;
              int green = pixels[row][col].getGreen() - amount;
              int blue = pixels[row][col].getBlue() - amount;
              
              Color newColor = new Color(red, green, blue);
              
              pixels[row][col].setColor(newColor);
          }
      }
  }
  
  /**
   * Method to fix the fish
   * Takes a sample and adjust the image
   * to better see the fish
   */
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    
    int redAverage = 0;
    int greenAverage = 0;
    int blueAverage = 0;
    int totalPixels = 0;
    
    int maxRed = 0;
    int minRed = 255;
    int maxGreen = 0;
    int minGreen = 255;
    int maxBlue = 0;
    int minBlue = 255;
    
    // takes a sample from a fish and finds the average color value and range of colors
    for (int row = 26; row < 36; row++)
    {
        for (int col = 178; col < 198; col++)
        {
            totalPixels++;
            
            Pixel myPixel = pixels[row][col];
            
            redAverage += myPixel.getRed();
            greenAverage += myPixel.getGreen();
            blueAverage += myPixel.getBlue();
            
            if (myPixel.getRed() > maxRed) { maxRed = myPixel.getRed(); }
            if (myPixel.getRed() < minRed) { minRed = myPixel.getRed(); }
            if (myPixel.getGreen() > maxGreen) { maxGreen = myPixel.getGreen(); }
            if (myPixel.getGreen() < minGreen) { minGreen = myPixel.getGreen(); }
            if (myPixel.getBlue() > maxBlue) { maxBlue = myPixel.getBlue(); }
            if (myPixel.getGreen() < minBlue) { minBlue = myPixel.getBlue(); }
            
        }
    }
    
    redAverage = redAverage / totalPixels;
    greenAverage = greenAverage / totalPixels;
    blueAverage = blueAverage / totalPixels;
    
    Color averageColor = new Color(redAverage, greenAverage, blueAverage);
    
    // calculates the range
    int redRange = (maxRed - minRed);
    int greenRange = (maxGreen - minGreen);
    int blueRange = (maxBlue - minBlue);
    
    int redDistance = redRange;
    int greenDistance = greenRange;
    int blueDistance = blueRange;
    
    double maxDistance = Math.sqrt(redDistance * redDistance +
                                   greenDistance * greenDistance +
                                   blueDistance * blueDistance);
    
    double tolerance = 1.7; // higher tolerance means more pixels will be identified as "fish"
    
    // changes the image based on calculated distance from sample value
    for (int row = 0; row < pixels.length; row++) // Pixel[] rowArray : pixels)
    {
      for (int col = 0; col < pixels[0].length; col++) // Pixel pixelObj : rowArray)
      {
          Pixel myPixel = pixels[row][col]; //
          
          boolean closeEnough = myPixel.colorDistance(averageColor) < maxDistance * tolerance; // stopped here, define this***
          // System.out.println(myPixel.colorDistance(averageColor));
          if (closeEnough)
          {
              myPixel.setBlue(myPixel.getBlue() + 50);
          }
          else
          {
              myPixel.setBlue(myPixel.getBlue() - 50);
          }
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }
  
  public void mirrorHorizontal()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      int height = pixels.length;
      for (int row = 0; row < height; row++)
      {
          for (int col = 0; col < pixels[0].length; col++)
          {
              topPixel = pixels[row][col];
              bottomPixel = pixels[height - 1 - row][col];
              bottomPixel.setColor(topPixel.getColor());
          }
      }
  }
  
  public void mirrorHorizontalBottomToTop()
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topPixel = null;
      Pixel bottomPixel = null;
      int height = pixels.length;
      for (int row = 0; row < height; row++)
      {
          for (int col = 0; col < pixels[0].length; col++)
          {
              topPixel = pixels[row][col];
              bottomPixel = pixels[height - 1 - row][col];
              topPixel.setColor(bottomPixel.getColor());
          }
      }
  }
  
  public void mirrorDiagonal() // mirrors from top right to bottom left
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel topRightPixel = null;
      Pixel bottomLeftPixel = null;
      int maxLength;
      if (pixels.length < pixels[0].length) { maxLength = pixels.length; }
      else {maxLength = pixels[0].length; }
      
      for (int row = 0; row < maxLength; row++)
      {
          for (int col = row; col < maxLength; col++)
          {
              topRightPixel = pixels[row][col];
              bottomLeftPixel = pixels[col][row];
              bottomLeftPixel.setColor(topRightPixel.getColor());
          }
      }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  /** Mirrors the arms of the snowman */
  public void mirrorArms()
  {
    int mirrorPoint = 193;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // Left arm
    for (int row = 158; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 103; col < 170; col++)
      {
        topPixel = pixels[row][col];      
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
    
    int mirrorPoint2 = 198;
    Pixel topPixel2 = null;
    Pixel bottomPixel2 = null;
    
    // Right arm
    for (int row = 171; row < mirrorPoint2; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < 294; col++)
      {
        topPixel2 = pixels[row][col];      
        bottomPixel2 = pixels[mirrorPoint2 - row + mirrorPoint2][col];
        bottomPixel2.setColor(topPixel2.getColor());
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 345;
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    Pixel[][] pixels = this.getPixels2D();   
    
    // Seagull
    for (int row = 235; row < 323; row++)
    {
      for (int col = 238; col < mirrorPoint; col++)
      {
        rightPixel = pixels[row][col];      
        leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
        System.out.println("Fromrow " + fromRow + " toRow " + toRow + " fromCol" + fromCol + " toCol " + toCol);
      }
    }   
  }
  
  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < endRow;
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < endCol;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
        //System.out.println("Fromrow " + fromRow + " toRow " + toRow + " fromCol" + fromCol + " toCol " + toCol);
        //System.out.println(fromPixels[0].length);
      }
    } 
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
   
    //this.copy(flower1,100,0);
    this.copy2(flower1,0,100, 0, 100);
    //flower1.explore();
    //this.copy(flower1,200,0);
    // Mirroring
    int mirrorPoint = 98;
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    Pixel[][] pixels = this.getPixels2D();   
    for (int row = 0; row < 98; row++)
    {
      for (int col = 0; col < 88; col++)
      {
        rightPixel = pixels[row][col];      
        leftPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy2(flowerNoBlue,300,350,80,500);
    
    Picture flowerinverse = new Picture(flower2);
    flowerinverse.invert();
    this.copy2(flowerinverse, 100, 300, 80, 300);
    //this.copy(flowerNoBlue,300,0);
    //this.copy(flower1,400,0);
    //this.copy(flower2,500,0);
    //this.mirrorVertical();
   
    
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
      Picture flower1 = new Picture("flower1.jpg");
      this.copy2(flower1,10,20, 0, 100);
      this.write("mycollage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    
    Pixel[][] pixels = this.getPixels2D();
    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        topPixel = pixels[row][col];
        bottomPixel = pixels[row + 1][col];
        if (leftPixel.colorDistance(rightPixel.getColor()) > edgeDist ||
            topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  /**
   * Method for edge detection, my way.
   * Handy methods used in this method are below.
   * 
   * 
   * 
   */
  
  public void edgeDetection2(int edgeDist)
  {
      Pixel currentPixel = null, testPixel = null;
      
      // width and height of pixel cluster
      int testWidth = 3;
      int testHeight = 3;
      
      Pixel[][] pixels = this.getPixels2D();
      double[][] edgeAngle = new double[Math.round(pixels.length / testHeight)][Math.round(pixels[0].length / testWidth)];
          // the 2D array edgeAngle will store the perceived angle (in radians) of the edge
      
      for (int row = 0; row < pixels.length - testHeight; row += testHeight)
      {
          for (int col = 0; col < pixels[0].length - testWidth; col += testWidth)
          {
              Pixel[][] currentPixels = this.getPixelCluster(pixels, row, col, testWidth, testHeight);
              
              double greatestDistance = -10;
              double greatestAngle = -1; // not actually the greatest value, but corresponding to greatest distance
              // I may need to determin which of the two partial clusters is darker, for filling in purposes
              for (double angle = 0; angle < Math.PI + 0.1; angle += Math.PI / 8)
              {
                  ArrayList<Pixel> group1 = this.getPartialArray(currentPixels, angle, 0);
                  Color group1Color = this.getAverageColor(this.getPixelColors(group1));
                  ArrayList<Pixel> group2 = this.getPartialArray(currentPixels, angle, 1);
                  Color group2Color = this.getAverageColor(this.getPixelColors(group2));
                  
                  double currentColorDistance = this.colorDistance(group1Color, group2Color);
                  
                  if (currentColorDistance > greatestDistance)
                  {
                      greatestDistance = currentColorDistance;
                      greatestAngle = angle;
                  }
                  
              }
              
              greatestAngle = Math.round(greatestAngle * 100.0) / 100.0;
              edgeAngle[row / testHeight][col / testWidth] = greatestAngle;
              
              
              if (greatestDistance > edgeDist)
              {
                  ArrayList<Pixel> group1 = this.getPartialArray(currentPixels, greatestAngle, 0);
                  ArrayList<Pixel> group2 = this.getPartialArray(currentPixels, greatestAngle, 1);
                  
                  for (Pixel pixel : group1)
                  {
                      pixel.setColor(Color.BLACK);
                  }
                  
                  for (Pixel pixel : group2)
                  {
                      pixel.setColor(Color.WHITE);
                  }
              }
              else
              {
                  for (Pixel[] pixelArray : currentPixels)
                  {
                      for (Pixel pixel : pixelArray)
                      {
                          pixel.setColor(Color.WHITE);
                      }
                  }
              }
          }
      }
      
      File file = new File("outputAngles.txt");
      try{
      PrintWriter writer = new PrintWriter(file, "UTF-8");
      
      
      for (int row = 0; row < edgeAngle.length; row++)
      {
          for (int col = 0; col < edgeAngle[0].length; col++)
          {
              writer.print(edgeAngle[row][col]);
              writer.print(" ");
          }
          writer.print("\n");
      }
      writer.close();
      }
      catch(Exception e){ e.printStackTrace(); }
  }
  
  public double colorDistance(Color testColor1, Color testColor2)
  {
      double redDistance = testColor2.getRed() - testColor1.getRed();
      double greenDistance = testColor2.getGreen() - testColor1.getGreen();
      double blueDistance = testColor2.getBlue() - testColor1.getBlue();
      double distance = Math.sqrt(redDistance * redDistance + 
                                  greenDistance * greenDistance +
                                  blueDistance * blueDistance);
      return distance;
  }
  
  public Color getAverageColor(Color[] myColors)
  {
      int totalRed = 0;
      int totalGreen = 0;
      int totalBlue = 0;
      
      int total = 0;
      
      for (Color currentColor : myColors)
      {
          totalRed += currentColor.getRed();
          totalGreen += currentColor.getGreen();
          totalBlue += currentColor.getBlue();
          total++;
      }
      
      return new Color(totalRed / total, totalGreen / total, totalBlue / total);
      
  }
  
  public Color[] getPixelColors(ArrayList<Pixel> pixels)
  {
      Color[] myColors = new Color[pixels.size()];
      int count = 0;
      for (Pixel currentPixel : pixels)
      {
          myColors[count] = currentPixel.getColor();
          count++;
      }
      
      return myColors;
  }
  
  public Pixel[][] getPixelCluster(Pixel[][] pixels, int startRow, int startCol,
                                   int width, int height)
  {
      Pixel[][] pixelCluster = new Pixel[height][width];
      
      if (pixels.length < startRow + height || pixels[0].length < startCol + width)
      {
          return pixelCluster;
      }
      
      for (int row = startRow; row < startRow + height; row++)
      {
          for (int col = startCol; col < startCol + width; col++)
          {
              pixelCluster[row - startRow][col - startCol] = pixels[row][col];
          }
      }
      
      return pixelCluster;
  }
  
  /**
   * Method getPartialArray takes an array of pixels,
   * an angle to divide the array, and the "type of" that
   * determines whether it returns the top/right (0) or
   * the bottom/left (1)
   * 
   * This one only takes the elements that lie on the line of division
   * 
   * Need to update this method to match the one below ********
   * 
   * @param pixels 
   * @param angle the angle to divide, given in radians (0 to pi)
   */
  public ArrayList<Pixel> getPartialArrayLine(Pixel[][] fullArray, double angle, int typeOf)
  {
      int rows = fullArray.length, cols = fullArray[0].length;
          int centerRow = rows / 2, centerCol = cols / 2;
          int arrayLength = (rows * cols);
          ArrayList<Pixel> tempList = new ArrayList<Pixel>();
          
          double slope = Math.tan(angle);
          if (slope == 0) slope = 0.001;
          double newSlope = -1 / slope;
          
          for (int i = 0; i < arrayLength; i++)
          {
              int currentRow = i / cols, currentCol = i % cols;
              //System.out.println(i + "\t" + currentRow + " " + currentCol);
              if (currentCol == (newSlope * (currentRow - centerRow) + centerCol))
                      // this tests whether the current cell is above/below the "line"
              {
                  if (typeOf == 1)
                  {
                      tempList.add(fullArray[currentRow][currentCol]);
                      //System.out.println("added " + i);
                  }
              }
              else
              {
                  if (typeOf == 0)
                  {
                      tempList.add(fullArray[currentRow][currentCol]);
                      //System.out.println("added " + i);
                  }
              }
          }
          
          return tempList;
  }
  
  
  /**
   * Method getPartialArray takes an array of pixels,
   * an angle to divide the array, and the "type of" that
   * determines whether it returns the top/right (0) or
   * the bottom/left (1)
   * 
   * Need to update this method to match the one below ********
   * 
   * @param pixels 
   * @param angle the angle to divide, given in radians (0 to pi)
   */
  public ArrayList<Pixel> getPartialArray(Pixel[][] fullArray, double angle, int typeOf)
  {
      int rows = fullArray.length, cols = fullArray[0].length;
          int centerRow = rows / 2, centerCol = cols / 2;
          int arrayLength = (rows * cols);
          ArrayList<Pixel> tempList = new ArrayList<Pixel>();
          
          double slope = Math.tan(angle);
          if (slope == 0) slope = 0.001;
          double newSlope = -1 / slope;
          
          for (int i = 0; i < arrayLength; i++)
          {
              int currentRow = i / cols, currentCol = i % cols;
              //System.out.println(i + "\t" + currentRow + " " + currentCol);
              if (currentCol < (newSlope * (currentRow - centerRow) + centerCol))
                      // this tests whether the current cell is above/below the "line"
              {
                  if (typeOf == 1)
                  {
                      tempList.add(fullArray[currentRow][currentCol]);
                      //System.out.println("added " + i);
                  }
              }
              else
              {
                  if (typeOf == 0)
                  {
                      tempList.add(fullArray[currentRow][currentCol]);
                      //System.out.println("added " + i);
                  }
              }
          }
          
          return tempList;
  }
  
  public static ArrayList<Integer> getPartialArray(int[][] fullArray, double angle, int typeOf)
      {
          int rows = fullArray.length, cols = fullArray[0].length;
          int centerRow = rows / 2, centerCol = cols / 2;
          int arrayLength = (rows * cols);
          ArrayList<Integer> tempList = new ArrayList<Integer>();
          
          double slope = Math.tan(angle);
          if (slope == 0) slope = 0.001;
          double newSlope = -1 / slope;
          
          for (int i = 0; i < arrayLength; i++)
          {
              int currentRow = i / cols, currentCol = i % cols;
              System.out.println(i + "\t" + currentRow + " " + currentCol);
              if (currentCol < (newSlope * (currentRow - centerRow) + centerCol))
              {
                  if (typeOf == 1)
                  {
                      tempList.add(fullArray[currentRow][currentCol]);
                      System.out.println("added " + i);
                  }
              }
              else
              {
                  if (typeOf == 0)
                  {
                      
                      tempList.add(fullArray[currentRow][currentCol]);
                      System.out.println("added " + i);
                  }
              }
          }
          
          return tempList;
      }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("caterpillar.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
