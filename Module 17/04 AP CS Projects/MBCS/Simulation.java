// AP(r) Computer Science Marine Biology Simulation:
// The Simulation class is copyright(c) 2002 College Entrance
// Examination Board (www.collegeboard.com).
//
// This class is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation.
//
// This class is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

/**
 *  AP&reg; Computer Science Marine Biology Simulation:<br>
 *  A <code>Simulation</code> object controls a simulation of fish
 *  movement in an <code>Environment</code>.
 *
 *  <p>
 *  The <code>Simulation</code> class is
 *  copyright&copy; 2002 College Entrance Examination Board
 *  (www.collegeboard.com).
 *
 *  @author Alyce Brady
 *  @version 1 July 2002
 *  @see Environment
 *  @see EnvDisplay
 *  @see Fish
 **/

public class Simulation
{
    // Instance Variables: Encapsulated data for each simulation object
    private Environment theEnv;
    private EnvDisplay  theDisplay;

    /** Constructs a <code>Simulation</code> object for a particular
     *  environment.
     *  @param env     the environment on which the simulation will run
     *  @param display an object that knows how to display the environment
     **/
    public Simulation(Environment env, EnvDisplay display)
    {
        theEnv = env;
        theDisplay = display;

        // Display the initial state of the simulation.
        //Debug.turnOn();
        theDisplay.showEnv();
        Debug.println("-------- Initial Configuration --------");
        Debug.println(theEnv.toString());
        Debug.println("---------------------------------------");
        //Debug.restoreState();
    }

    /** Runs through a single step of this simulation. **/
    public void step()
    {
        // Get all the fish in the environment and ask each
        // one to perform the actions it does in a timestep.
        Locatable[] theFishes = theEnv.allObjects();
        for ( int index = 0; index < theFishes.length; index++ )
        {
            ((Fish)theFishes[index]).act();
        }

        // Display the state of the simulation after this timestep.
        theDisplay.showEnv();
        Debug.turnOn();
        Debug.println(theEnv.toString());
        Debug.println("-------- End of Timestep --------");
        Debug.restoreState();
    }

}
