import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;
/**
 * A <code>PredatorBug</code> Eats all bug in front of 
 * it, then moves like a bug, if it moved 5 times without
 * eating, it dies. <br />
 * 
 * @author Saloni Shah
 * @version 07.19.2021
 */
public class PredatorBugRunner 
{
    /* PredatorBugRunner methods: */
    /**
     * Creates a world and populates the world with PredatorBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));

        PredatorBug alice = new PredatorBug();
        alice.setColor(Color.PINK);
        world.add(new Location(5, 5), alice);
        world.add(new Rock());
        world.show();
    }

}
