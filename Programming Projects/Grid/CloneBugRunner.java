import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;
/**
 * Clones itself into an empty adjacent location, then moves.
 * 
 * @author  Saloni Shah 
 *
 * @version 07.14.2021 
 */
public class CloneBugRunner 
{
    /* CloneBugRunner methods: */

    /**
     * Creates a world and populates the world with CloneBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));

        Location loc = new Location (5, 5);
        CloneBug alice = new CloneBug();
        world.add(new Location(5, 5), alice);
        world.show();
    }
}
