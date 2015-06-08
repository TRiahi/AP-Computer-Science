// AP(r) Computer Science Marine Biology Simulation:
// The UnboundedEnv class is copyright(c) 2002 College Entrance
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

import java.util.ArrayList;

/**
 *  AP&reg; Computer Science Marine Biology Simulation:<br>
 *  The <code>UnboundedEnv</code> class models an unbounded, two-dimensional,
 *  grid-like environment containing locatable objects.  For example, it
 *  could be an environment of fish for a marine biology simulation.
 *
 *  <p>
 *  Modification History:
 *  - Created to support multiple environment representations:
 *    this class represents a second implementation of the
 *    <code>Environment</code> interface.
 *
 *  <p>
 *  The <code>UnboundedEnv</code> class is
 *  copyright&copy; 2002 College Entrance Examination Board
 *  (www.collegeboard.com).
 *
 *  @author Alyce Brady
 *  @author APCS Development Committee
 *  @version 1 July 2002
 *  @see Locatable
 *  @see Location
 **/

public class UnboundedEnv extends SquareEnvironment
{
    // Instance Variables: Encapsulated data for each UnboundedEnv object
    private ArrayList objectList;   // list of Locatable objects in environment


  // constructors

    /** Constructs an empty UnboundedEnv object.
     **/
    public UnboundedEnv()
    {
        // Construct and initialize inherited attributes.
        super();

        objectList = new ArrayList();
    }


  // accessor methods

    /** Returns number of rows in this environment.
     *  @return   the number of rows, or -1 if the environment is unbounded
     **/
    public int numRows()
    {
        return -1;
    }

    /** Returns number of columns in this environment.
     *  @return   the number of columns, or -1 if the environment is unbounded
     **/
    public int numCols()
    {
        return -1;
    }

    /** Verifies whether a location is valid in this environment.
     *  @param  loc    location to check
     *  @return <code>true</code> if <code>loc</code> is valid;
     *          <code>false</code> otherwise
     **/
    public boolean isValid(Location loc)
    {
        // All non-null locations are valid in an unbounded environment.
        return loc != null;
    }

    /** Returns the number of objects in this environment.
     *  @return   the number of objects
     **/
    public int numObjects()
    {
        return objectList.size();
    }

    /** Returns all the objects in this environment.
     *  @return    an array of all the environment objects
     **/
    public Locatable[] allObjects()
    {
        Locatable[] objectArray = new Locatable[objectList.size()];

        // Put all the environment objects in the list.
        for ( int index = 0; index < objectList.size(); index++ )
        {
            objectArray[index] = (Locatable) objectList.get(index);
        }

        return objectArray;
    }

    /** Determines whether a specific location in this environment is
     *  empty.
     *  @param loc  the location to test
     *  @return     <code>true</code> if <code>loc</code> is a
     *              valid location in the context of this environment
     *              and is empty; <code>false</code> otherwise
     **/
    public boolean isEmpty(Location loc)
    {
        return (objectAt(loc) == null);
    }

    /** Returns the object at a specific location in this environment.
     *  @param loc    the location in which to look
     *  @return       the object at location <code>loc</code>;
     *                <code>null</code> if <code>loc</code> is empty
     **/
    public Locatable objectAt(Location loc)
    {
        int index = indexOf(loc);
        if ( index == -1 )
            return null;

        return (Locatable) objectList.get(index);
    }

    /** Creates a single string representing all the objects in this
     *  environment (not necessarily in any particular order).
     *  @return    a string indicating all the objects in this environment
     **/
    public String toString()
    {
        Locatable[] theObjects = allObjects();
        String s = "Environment contains " + numObjects() + " objects: ";
        for ( int index = 0; index < theObjects.length; index++ )
            s += theObjects[index].toString() + " ";
        return s;
    }


  // modifier methods

    /** Adds a new object to this environment at the location it specifies.
     *  (Precondition: <code>obj.location()</code> is a valid empty location.)
     *  @param obj the new object to be added
     *  @throws    IllegalArgumentException if the precondition is not met
     **/
    public void add(Locatable obj)
    {
        // Check precondition.  Location should be empty.
        Location loc = obj.location();
        if ( ! isEmpty(loc) )
            throw new IllegalArgumentException("Location " + loc +
                                    " is not a valid empty location");

        // Add object to the environment.
        objectList.add(obj);
    }

    /** Removes the object from this environment.
     *  (Precondition: <code>obj</code> is in this environment.)
     *  @param obj     the object to be removed
     *  @throws    IllegalArgumentException if the precondition is not met
     **/
    public void remove(Locatable obj)
    {
        // Find the index of the object to remove.
        int index = indexOf(obj.location());
        if ( index == -1 )
            throw new IllegalArgumentException("Cannot remove " +
                                               obj + "; not there");

        // Remove the object.
        objectList.remove(index);
    }

    /** Updates this environment to reflect the fact that an object moved.
     *  (Precondition: <code>obj.location()</code> is a valid location
     *  and there is no other object there.
     *  Postcondition: <code>obj</code> is at the appropriate location
     *  (<code>obj.location()</code>), and either <code>oldLoc</code> is 
     *  equal to <code>obj.location()</code> (there was no movement) or
     *  <code>oldLoc</code> is empty.)
     *  @param obj       the object that moved
     *  @param oldLoc    the previous location of <code>obj</code>
     *  @throws    IllegalArgumentException if the precondition is not met
     **/
    public void recordMove(Locatable obj, Location oldLoc)
    {
        int objectsAtOldLoc = 0;
        int objectsAtNewLoc = 0;

        // Look through the list to find how many objects are at old
        // and new locations.
        Location newLoc = obj.location();
        for ( int index = 0; index < objectList.size(); index++ )
        {
            Locatable thisObj = (Locatable) objectList.get(index);
            if ( thisObj.location().equals(oldLoc) )
                objectsAtOldLoc++;
            if ( thisObj.location().equals(newLoc) )
                objectsAtNewLoc++;
        }

        // There should be one object at newLoc.  If oldLoc equals
        // newLoc, there should be one at oldLoc; otherwise, there
        // should be none.
        if ( ! ( objectsAtNewLoc == 1 &&
                 ( oldLoc.equals(newLoc) || objectsAtOldLoc == 0 ) ) )
        {
            throw new IllegalArgumentException("Precondition violation moving "
                + obj + " from " + oldLoc);
        }
    }


  // internal helper method

    /** Get the index of the object at the specified location.
     *  @param loc    the location in which to look
     *  @return       the index of the object at location <code>loc</code>
     *                if there is one; -1 otherwise
     **/
    protected int indexOf(Location loc)
    {
        // Look through the list to find the object at the given location.
        for ( int index = 0; index < objectList.size(); index++ )
        {
            Locatable obj = (Locatable) objectList.get(index);
            if ( obj.location().equals(loc) )
            {
                // Found the object -- return its index.
                return index;
            }
        }

        // No such object found.
        return -1;
    }

}
