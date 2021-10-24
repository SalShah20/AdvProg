import info.gridworld.actor.Bug;
import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
/**
 * A <code>EasterlyBug</code> Pushes away all objects to 
 * the west of the bug then moves like a bug. <br />
 * 
 * @author Saloni Shah
 * @version 07.15.2021
 */
public class EasterlyBug extends Bug
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class EasterlyBug
     */
    public EasterlyBug()
    {
        // initialise instance variables
    }
    
    /**
     * Pushes away all objects, then moves like a bug.
     */
    public void act() 
    {
        this.blowAway();
        super.act();
    }
    
    /**
     * Pushes away all objects to the west.
     */
    public void blowAway() 
    {
        Grid<Actor> gr = getGrid();
        Location loca = this.getLocation();
        ArrayList<Location> occupados = gr.getOccupiedLocations();
        ArrayList<Location> west = new ArrayList();
        for (Location loc : occupados) 
        {
            if (loc.getDirectionToward(loca) == 90) 
            {
                west.add(loc);
            }
        }
        for (Location loc : west) 
        {
            if (loc.getRow() == loca.getRow()) 
            {
                Actor actor = gr.get(loc);
                if (loc == loca) 
                {
                    actor.setDirection(270);
                } 
                else 
                {
                    actor.setDirection(loc.getDirectionToward(loca) + 180);
                    Location next = loc.getAdjacentLocation(actor.getDirection());
                    if (!gr.isValid(next)) 
                    {
                        actor.removeSelfFromGrid();
                    } 
                    else 
                    {
                        actor.moveTo(next);
                    }
                }
            }
        }
    }
}
