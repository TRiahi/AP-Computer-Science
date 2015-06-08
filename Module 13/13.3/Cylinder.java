
/**
 * Cylinder class that extends circle
 * 
 * 
 */
public class Cylinder extends Circle
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class cylinder
	 */
	public Cylinder(int x, int y, int rad, int h)
	{
		super(x, y, rad);
	    // initialise instance variables
		height = h;
	}

	public int getHeight()
	{
		
		return height;
	}
}