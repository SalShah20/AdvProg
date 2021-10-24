import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;
/**
 * A <code>StrongEasterlyBug</code> Pushes away all objects to 
 * the west of the bug then moves like a bug. <br />
 * 
 * @author Saloni Shah
 * @version 07.15.2021
 */
public class StrongEasterlyBugRunner 
{
    /* HurricaneBugRunner methods: */
    /**
     * Creates a world and populates the world with StrongEasterlyBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));

        StrongEasterlyBug alice = new StrongEasterlyBug();
        alice.setColor(Color.PINK);
        world.add(new Location(5, 5), alice);
        world.add(new Rock());
        world.show();
        
    }

}