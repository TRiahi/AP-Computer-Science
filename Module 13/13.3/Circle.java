
/**
 * Circle demo
 * 
 *
 */
public class Circle
{
	// instance variables 
	private int x;
	private int y;
	private int radius;

	/**
	 * Constructor for objects of class circle
	 */
	public Circle(int p_x, int p_y, int r)
	{
		// initialise instance variables
		x = p_x;
		y = p_y;
		radius = r;
	}

	public int getRadius()
	{
		
		return radius;
	}
	public String center()
	{
	     return " center is at (" + x + "," + y + ")";
	}
	public int getX()
	{
	    return x;
	   }
	   
	public int getY()
	{
	    return y;
	   }
}