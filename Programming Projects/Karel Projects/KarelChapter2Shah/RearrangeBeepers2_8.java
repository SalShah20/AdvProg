import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must pick up all the beepers 
 * and rearrange them from a 
 * vertical line to horizontal.
 * 
 * @author  Saloni Shah
 * with assistance from John Page
 *
 * @version 06.14.2021 
 */
public class RearrangeBeepers2_8 extends Robot
{
    /**
     * Creates a RearrangeBeepers2_8 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public RearrangeBeepers2_8 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* RearrangeBeepers2_8 methods: */
    /**
     * Picks up all the beepers and 
     * rearranges them into a horizontal line.
     * 
     * @precondition Robot starts at 4,3 facing East
     * 
     * @postcondition Robot ends at 2,5 facing North
     */
    public void rearrangeBeepers() 
    {
        move();
        move();
        //at 4,5
        
        pickBeeper();
        turnLeft();
        //facing North
        
        move();
        //at 5,5
        
        pickBeeper();
        move();
        //at 6,5
        
        pickBeeper();
        turnLeft();
        turnLeft();
        //facing South
        
        move();
        move();
        move();
        //at 3,5
        
        pickBeeper();
        move();
        //at 2,5
        
        pickBeeper();
        turnLeft();
        //facing East
        
        move();
        move();
        //at 2,7
        
        turnLeft();
        //facing North
        
        move();
        move();
        //at 4,7
        
        putBeeper();
        turnLeft();
        //facing West
        
        move();
        //at 4,6
        
        putBeeper();
        move();
        //at 4,5
        
        putBeeper();
        move();
        //at 4,4
        
        putBeeper();
        move();
        //at 4,3
        
        putBeeper();
        turnLeft();
        //facing South
        
        move();
        move();
        //at 2,3
        turnLeft();
        //facing East
        move();
        move();
        //at 2,5
        
        turnLeft();
        //facing North
    }
}
