import kareltherobot.*;
import java.awt.Color;

/**
 * Karel dropped some groceries(beepers) 
 * and has to go back and get them and 
 * return to where he started.
 * 
 * @author  Saloni Shah
 * with assistance from John Page
 *
 * @version 06.14.2021 
 */
public class GroceryPickup2_7 extends Robot
{
    /**
     * Creates a GroceryPickup2_7 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public GroceryPickup2_7 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* GroceryPickup2_7 methods: */
    /**
     * Picks up beepers and gets back to where it started
     * 
     * @precondition Robot starts at 5,7 facing East
     * 
     * @postcondition Robot ends at 5,7 facing East
     */
    public void pickGroceries() 
    {
        turnLeft();
        turnLeft();
        //facing West
        
        move();
        move();
        //at 5,5
        
        pickBeeper();
        //picked up beeper
        
        move();
        //at 5,4
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing North
        
        move();
        //at 6,4
        
        pickBeeper();
        //picked up beeper
        
        turnLeft();
        //facing West
        
        move();
        //at 6,3
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing North
        
        move();
        //at 7,3
        
        pickBeeper();
        //picked up beeper
        
        move();
        //at 8,3
        
        pickBeeper();
        //picked up beeper
        
        turnLeft();
        turnLeft();
        //facing South
        
        move();
        move();
        move();
        //at 5,3
        
        turnLeft();
        //facing East
        
        move();
        move();
        move();
        move();
        //at 5,7
    }
}
