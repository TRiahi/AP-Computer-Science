
/**
 * 
 * Tests all of the terrains and their specs.
 * @author Bijan Tajmir
 * @version 3/1/2015
 */

public class TestTerrain
{
    public static void main(String[] args)
    {
        Terrain t1 = new Terrain(50, 50);
        Forest f1 = new Forest(100, 200, 100);
        Mountain m1 = new Mountain(300, 400, 25);
        WinterMountain wm1 = new WinterMountain(500, 600, 15, 10.0);
        System.out.println(t1.getTerrain());
        System.out.println("Forest " + f1.getTerrain() + " and has " + f1.getTrees() + " trees.");
        System.out.println("Mountain " + m1.getTerrain() + " and has " + m1.getMountains() + " mountains.");
        System.out.println("Forest " + wm1.getTerrain() + " and has temperature " +wm1.getTemp()+ " and " + wm1.getMountains() + " mountains.");
    }
}