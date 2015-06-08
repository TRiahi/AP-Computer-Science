/**
 * The purpose of this program is to  calculate the (x, y) coordinates of points on a circle of radius 1.0.
 * 
 * @author Bijan Tajmir
 * @version 11/15/2014
 * 
 */

public class PointsOnACircleV1 {
    public static void main(String[ ] args)
    {
        double[] numList = { 1.0, 0.90, 0.80, 0.70, 0.60, 0.50, 0.40, 0.30, 0.20, 0.10, 0.00, -0.10, -0.20, -0.30, -0.40, -0.50, -0.60, -0.70,-0.80, -0.90, -1.00 };

        double radius = 1.0;

        System.out.println("      Points on a Circle of Radius 1.0");
        System.out.println("       x1        y1        x2        y2");
        System.out.println("---------------------------------------------");
        
        for (int i = 0; i < numList.length; i++) {
            double y1 = Math.sqrt(Math.pow(radius, 2) - Math.pow(numList[i], 2));
            double y2 = 0.00;
            
            if (y1 != 0.00)
            {
                y2 = (-y1);
            }
            System.out.printf("%10.2f%10.2f%10.2f%10.2f%n", numList[i], y1, numList[i], y2);
        }
        
        System.out.println("");
}
}