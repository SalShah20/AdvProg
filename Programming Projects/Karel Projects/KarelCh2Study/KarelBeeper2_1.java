import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must go around the wall
 * get the beeper, and then
 * turn off
 * 
 * @author  Saloni Shah
 *
 * @version 06.15.2021 
 */
public class KarelBeeper2_1 extends Robot
{
    /**
     * Creates a KarelBeeper2_1 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public KarelBeeper2_1 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* KarelBeeper2_1 methods: */
    /**
     * Karel goes around the wall and picks up a beeper
     * 
     * @precondition Robot must be at 2,7 facing West
     * 
     * @postcondition Robot will be at 2,5 facing South
     */
    public void getBeeper() 
    {
        move();         //at 2,6
        
        turnLeft();
        turnLeft();
        turnLeft();     //facing North
        
        move();         //at 3,6
        
        turnLeft();     //facing West
        
        move();         //at 3,5
        
        turnLeft();     //facing South
        
        move();         //at 2,5
        
        pickBeeper();
    }
}
