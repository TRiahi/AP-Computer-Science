import java.util.ArrayList;

/*
 * Created on Oct 15, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author 23188
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Ch2Exercise1
{
    private static final int ENV_ROWS = 10;      // rows in environment
    private static final int ENV_COLS = 10;      // columns in environment

    public static void main(String[] args)
    {
        // Construct an empty environment 
        BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
        Location loc1 = new Location(7, 3);
        Location loc2 = new Location(7, 4);
        Direction dir1 = env.getDirection(loc1, loc2);
        Direction dir2 = dir1.toRight(90);
        Direction dir3 = dir2.reverse();
        Location loc3 = env.getNeighbor(loc1, dir3);
        Location loc4 = env.getNeighbor(new Location(5, 2), dir1);
        Direction north = new Direction("north");
        Direction south = new Direction("south");
        Direction east = new Direction("east");
        Direction west = new Direction("west");
        
        System.out.println(dir1);
        System.out.println(dir2);
        System.out.println(dir3);
        System.out.println(loc3);
        System.out.println(loc4);
        ArrayList Array = new ArrayList();
        Array = env.neighborsOf(loc1); 
        System.out.println(Array);
        System.out.println(north.inDegrees());
        System.out.println(south.inDegrees());
        System.out.println(east.inDegrees());
        System.out.println(west.inDegrees());
    }
}
