import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
import info.gridworld.actor.ActorWorld;

/**
 * Clones itself into an empty adjacent location, 
 * then moves.
 * 
 * @author  Saloni Shah 
 *
 * @version 07.14.2021 
 */
public class CloneBug extends Bug
{
    // instance variables - replace the example below with your own
    private Location loc;
    /**
     * Constructor for objects of class CloneBug
     */
    public CloneBug()
    {
        // initialise instance variables
    }
    
    /**
     * Clones itself around it, then moves.
     */
    public void act()
    {
        Grid<Actor> gr = getGrid();
        loc = getLocation();
        ArrayList<Location> neighbors = gr.getEmptyAdjacentLocations(loc);
        ArrayList<CloneBug> clones = new ArrayList<CloneBug>();
        for (int i = 0; i < neighbors.size(); i++) 
        {
            Location loca = neighbors.get(i); 
            CloneBug clone = new CloneBug();
            clone.putSelfInGrid(gr, loca);
        }
    }
}
