import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
/**
 * Destroys all objects near it and then moves.
 *
 * @author Saloni Shah
 * @version 07.14.2021
 */
public class TerminatorBug extends Bug
{
    // instance variables - replace the example below with your own
    private Location upperRight = new Location (0,19);
    
    /**
     * Constructor for objects of class TerminatorBug
     */
    public TerminatorBug()
    {
        // initialise instance variables
    }

    /**
     * Moves without leaving flowers.
     */
    @Override
    public void move()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        } else {
            turn();
        }
    }
    
    public void destroyNeighbors() {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        ArrayList<Actor> neighbors = gr.getNeighbors(loc);
        for (Actor actor : neighbors ) {
            if (! (actor instanceof TerminatorBug)) {
                actor.removeSelfFromGrid();
            } else {
                turn();
            }
        }
    }

    /**
     * Picks up all objects around it before moving.
     */
    public void act()
    {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        if(canMove()) {
            destroyNeighbors();
            move();
        } else {
            if (getDirection() == 45 && getLocation() == upperRight) {
                setDirection(270);
            } else {
                turn();
                turn();
                turn();
            }
        }
    }
}
