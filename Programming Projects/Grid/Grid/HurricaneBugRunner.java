import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;
/**
 * A <code>HurricaneBug</code> Pushes away all objects except 
 * rock, then moves like a bug.. <br />
 * 
 * @author Saloni Shah
 * @version 07.15.2021
 */
public class HurricaneBugRunner 
{
    /* HurricaneBugRunner methods: */
    /**
     * Creates a world and populates the world with HurricaneBug objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(20,20));

        HurricaneBug alice = new HurricaneBug();
        alice.setColor(Color.PINK);
        world.add(new Location(5, 5), alice);
        world.add(new Rock());
        world.show();
    }

}
