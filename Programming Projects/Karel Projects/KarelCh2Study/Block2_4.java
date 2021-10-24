import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must walk around the block
 * 
 * @author  Saloni Shah
 * 
 * @version 06.15.2021
 */
public class Block2_4 extends Robot
{
    /**
     * Creates a Block2_4 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Block2_4 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Block2_4 methods: */
    /**
     * Karel will walk around the block
     * 
     */
    public void walkBlock ()
    {
        move();
        move();
        move();
        
        turnLeft();
        
        move();
        move();
        move();
        
        turnLeft();
        
        move();
        move();
        move();
        
        turnLeft();
        
        move();
        move();
        move();
        
        turnLeft();
    }
}
