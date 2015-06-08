
/**
 * Displays the sides of all the Triangles.
 * 
 * @author Bijan Tajmir
 * @version 3/1/2015
 */
public class TriangleTester
{
    public static void main(String[] args)
    {
        Triangle t1 = new Triangle(4.0, 5.0, 6.0);
        Equilateral e1 = new Equilateral(5.0);
        IsoscelesRight i1 = new IsoscelesRight(1.5);
        
        System.out.println("Triangle has sides A = " + t1.getSideA() + " B = " + t1.getSideB()
                + " C = " +t1.getSideC());
                
        System.out.println("Equilateral Triangle has sides A = " + e1.getSideA() + " B = " + e1.getSideB()
                + " C = " +e1.getSideC());
        
        System.out.println("Isosceles Right Triangle has sides A = " + i1.getSideA() + " B = " + i1.getSideB()
                + " C = " +i1.getSideC());
        
        
        
        
    }

}