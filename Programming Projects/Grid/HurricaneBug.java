import info.gridworld.actor.Bug;
import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
/**
 * A <code>HurricaneBug</code> Pushes away all objects except 
 * rock, then moves like a bug.. <br />
 * 
 * @author Saloni Shah
 * @version 07.15.2021
 */
public class HurricaneBug extends Bug
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class HurricaneBug
     */
    public HurricaneBug()
    {
        // initialise instance variables
    }

    /**
     * Pushes away all objects, then moves like a bug.
     */
    public void act() {
        this.blowAway();
        super.act();
    }

    /**
     * Pushes away all objects except rocks.
     */
    public void blowAway() {
        Grid<Actor> gr = getGrid();
        Location loca = getLocation();
        ArrayList<Actor> neighbors = gr.getNeighbors(loca);
        for (Actor actor : neighbors) {
            if (! (actor instanceof Rock)) {
                Location loc = actor.getLocation();
                actor.setDirection(loc.getDirectionToward(loca) + 180);
                Location next = loc.getAdjacentLocation(actor.getDirection());
                if (!gr.isValid(next)) {
                    actor.removeSelfFromGrid();
                } else {
                    actor.moveTo(next);
                }
            }
        }
    }
}
