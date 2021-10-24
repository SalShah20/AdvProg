import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;
/**
 * Paints all objects around it the same color.
 *
 * @author Saloni Shah
 * @version 07.14.2021
 */
public class ClownBugRunner 
{
    /* ClownBugRunner methods: */
    /**
     * Creates a world and populates the world with ClownBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));

        ClownBug alice = new ClownBug(Color.blue);
        world.add(new Location(5, 5), alice);
        world.add(new Rock());
        world.show();
    }
}
