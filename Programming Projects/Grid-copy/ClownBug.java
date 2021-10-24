import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
import java.awt.Color;
/**
 * Paints all objects around it the same color.
 *
 * @author Saloni Shah
 * @version 07.14.2021
 */
public class ClownBug extends Bug
{
    // instance variables - replace the example below with your own
    private Color color;
    /**
     * Constructor for objects of class ClownBug
     * 
     * @param shade the desired color of the bug
     */
    public ClownBug(Color shade)
    {
        // initialise instance variables
        this.color = shade;
    }
    
    /**
     * Paints all objects around it the same color.
     */
    public void act()
    {
        setColor(color);
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        ArrayList<Actor> neighbors = gr.getNeighbors(loc);
        for (int i = 0; i < neighbors.size(); i++) 
        {
            neighbors.get(i).setColor(color);
        }
    }
}
