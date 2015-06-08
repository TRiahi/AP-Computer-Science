/**
 * This class tests the Catapult class. 
 * 
 * @author Bijan Tajmir
 * 
 */
import java.util.*;
import java.text.*;
public class CatapultTesterV2
{   
    public static void main(String[] args)
    {
        int [] speed = {20,25,30,35,40,45,50};
        int [] angle = {25,30,35,40,45,50};
        CatapultV2 catapult = new CatapultV2(speed, angle);
        catapult.calcDistance();
        System.out.println("                                                  Projectile Distance (feet) ");
        System.out.println("    MPH          25 deg            30 deg            35 deg            40 deg            45 deg          50 deg");
        System.out.println("=================================================================================================================");
        catapult.print();
    }
}
