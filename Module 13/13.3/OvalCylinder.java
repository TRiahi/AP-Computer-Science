
/**
 * OvalCylinder class extends Oval.
 * 
 * 
 */
public class OvalCylinder extends Oval
{
	// instance variables 
	private int height;

	/**
	 * Constructor for objects of class ovalCylinder
	 */
	public OvalCylinder(int x, int y, int rad1, int rad2, int h)
	{
		super(x, y, rad1, rad2);
	    // initialise instance variables
		height = h;
	}

	
	public int getHeight()
	{
		
		return height;
	}
}