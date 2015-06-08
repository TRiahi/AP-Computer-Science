//  Ch2AnalysisQuestion3.java
//  Created on Oct 15, 2004
//  Created by Shahein Tajmir
//

/**
 * @author 23188
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Ch2Exercise2
{
   private static final int ENV_ROWS = 20;
   private static final int ENV_COLS = 20;
   
    
    public static void main(String[] args)
    {
        //  Make an environment
        BoundedEnv env = new BoundedEnv(ENV_ROWS, ENV_COLS);
        
        //  Declarations
        Location loc1 = new Location(7, 3);
        Location loc2 = new Location(2, 6);
        Location loc3 = new Location(4, 8);
        Fish f1 = new Fish(env, loc1);
        Fish f2 = new Fish(env, loc2);
        
        System.out.println(env.numObjects());
        System.out.println(env.allObjects());
        System.out.println(env.isEmpty(loc1));
        System.out.println(env.isEmpty(loc3));
        System.out.println(env.objectAt(loc2));
        System.out.println(env.objectAt(loc3));
        
        Location loc4 = new Location(5, 9); // adds two more fish
        Fish f3 = new Fish(env, loc4);
        Location loc5 = new Location(3, 3);
        Fish f4 = new Fish(env, loc5);
        System.out.println("  " + f4.isInEnv());
        
        System.out.println(env.numObjects()); // test of methods
        System.out.println(env.allObjects());
        
        env.remove(f1); // removes fish1
        
        System.out.println(env.numObjects()); // test of methods
        System.out.println(env.allObjects());
        
        System.out.println(env.isEmpty(loc1)); // test of isEmpty where fish1 was removed
        //env.add(f2);
        
        System.out.println(env.numObjects()); // test of methods
        System.out.println(env.allObjects());
        
        //*************************************************************************
        //  Modifications called for in Exercise Set 3
        //*************************************************************************
        
        System.out.println(env.neighborsOf(new Location(0, 0)));
        System.out.println(env.neighborsOf(new Location(0, 1)));
        System.out.println(env.neighborsOf(new Location(1, 1)));
        
        
    }
}
