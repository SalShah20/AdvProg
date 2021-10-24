import info.gridworld.actor.Bug;
import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
/**
 * Eats bugs in front of it, then moves like a bug. If
 * it moved 5 times without eating, it dies.
 *
 * @author Saloni Shah
 * @version 07.19.2021
 */
public class PredatorBug extends Bug
{
    // instance variables - replace the example below with your own
    private int moves = 0;
    /**
     * Constructor for objects of class PredatorBug
     */
    public PredatorBug()
    {
        // initialise instance variables
    }

    /**
     * Eats bugs in front of it, then moves like a bug. If
     * it moved 5 times without eating, it dies.
     */
    public void act() 
    {
        if (moves < 5) 
        {
            boolean eat = this.eat();
            move();
            if (!eat) 
            {
                moves++;
            } 
            else 
            {
                moves = 0;
            }
        } 
        else 
        {
            removeSelfFromGrid();
        }
    }
    
    /**
     * Eats any bug right in front of it.
     * 
     * @return true if it ate a bug; otherwise false.
     */
    public boolean eat() 
    {
        Grid<Actor> gr = getGrid();
        int facing = getDirection();
        Location loca = getLocation();
        ArrayList<Actor> neighbors = gr.getNeighbors(loca);
        for (Actor n : neighbors) 
        {
            Location next = loca.getAdjacentLocation(facing);
            if (n instanceof Bug && n.getLocation() == next) 
            {
                n.removeSelfFromGrid();
                return true;
            } 
            else 
            {
                return false;
            }
        }
        return false;
    }
}
