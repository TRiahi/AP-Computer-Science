/**
 * Box3 Class
 * 
 * @author Bijan Tajmir
 * @version 3/2/2015
 */
public class Box3 extends Rectangle3
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class box
	 */
	public Box3(int l, int w, int h)
	{
		// call superclass
		super(l, w);
	    // initialise instance variables
		height = h;
	}

	// return the height
	public int getHeight()
	{
		return height;
	}

    public boolean equals(Box3 b)
     {
        if (getLength() == b.getLength()){
            if (getWidth() == b.getWidth()){
                if(height == b.getHeight()){                    
                return true;
                }
            }
        }
        return false;
     }
     
   public String toString(){
   return "Box - " + getLength() + " x " + getWidth() + " x " + getHeight();
   }
}