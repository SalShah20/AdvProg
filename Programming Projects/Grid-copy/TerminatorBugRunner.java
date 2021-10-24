import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;

/**
 * Destroys all objects near it and then moves.
 * 
 * @author  Saloni Shah 
 *
 * @version 07.14.2021 
 */
public class TerminatorBugRunner 
{
    /* TerminatorBugRunner methods: */
    /**
     * Creates a world and populates the world with TerminatorBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));

        TerminatorBug alice = new TerminatorBug();
        alice.setColor(Color.PINK);
        world.add(new Location(0, 0), alice);
        world.add(new Rock());
        world.show();
    }
}
