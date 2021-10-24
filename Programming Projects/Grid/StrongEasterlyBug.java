import info.gridworld.actor.Bug;
import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
/**
 * Write a description of class StrongEasterlyBug here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StrongEasterlyBug extends Bug
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class StrongEasterlyBug
     */
    public StrongEasterlyBug()
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
     * Pushes away all objects except to the west.
     */
    public void blowAway() {
        this.setDirection(270);
        Grid<Actor> gr = getGrid();
        Location loca = this.getLocation();
        ArrayList<Location> occupados = gr.getOccupiedLocations();
        for (Location loc : occupados) {
            if (loc.getCol() < loca.getCol()) {
                Actor actor = gr.get(loc);
                Location next = loc.getAdjacentLocation(270);
                if (!gr.isValid(next)) {
                    actor.removeSelfFromGrid();
                } else {
                    actor.moveTo(next);
                }
            }
        }
    }
}
