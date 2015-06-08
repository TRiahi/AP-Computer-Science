
/**
 * Creates an Isosceles Triangle, using the Triangle Class.
 * 
 * @author Bijan Tajmir  
 * @version 3/1/2015
 */
public class IsoscelesRight extends Triangle
{
    public IsoscelesRight(double sides)
    {
        super(sides, sides, (sides * Math.sqrt(2)));
    }
}