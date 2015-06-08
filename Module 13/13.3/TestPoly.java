
/**
 * Prints the centers of all of the shapes polymorphically.
 * 
 * @author Bijan Tajmir
 * @version 3/2/2015
 */
public class TestPoly
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(2, 4, 1);
        Cylinder cy1 = new Cylinder(3, 5, 2, 6);
        Oval o1 = new Oval(5, 7, 3, 4);
        OvalCylinder oc1 = new OvalCylinder(9, 11, 5, 6, 8);
        
        
        showCenter(c1);
        
        showCenter(cy1);
        
        showCenter(o1);
        
        showCenter(oc1);

    }
    
    private static void showCenter(Circle c){
        System.out.println("For " + c + c.center());
    }
}