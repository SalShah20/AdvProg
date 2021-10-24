import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must do a figure eight 
 * around the 2 beepers and return 
 * to the same position.
 * 
 * @author  Saloni Shah
 * with assistance from John Page
 *
 * @version 06.14.2021 
 */
public class FigureEight2_9 extends Robot
{
    /**
     * Creates a FigureEight2_9 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public FigureEight2_9 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* FigureEight2_9 methods: */
    /**
     * Does a figure eight
     * around the two beepers
     * and then returns to original 
     * position.
     * 
     * @precondition Robot starts at 3,5 facing North
     * 
     * @postcondition Robot ends at 3,5 facing North
     */
    public void figureEight() 
    {
        turnLeft();
        //facing West
        
        move();
        //at 3,4
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing North
        
        move();
        move();
        //at 5,4
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing East
        
        move();
        move();
        //at 5,6
        
        turnLeft();
        //facing North
        
        move();
        move();
        //at 7,6
        
        turnLeft();
        //facing West
        
        move();
        move();
        //at 7,4
        
        turnLeft();
        //facing South
        
        move();
        move();
        //at 5,4
        
        turnLeft();
        //facing East
        
        move();
        move();
        //at 5,6
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing South
        
        move();
        move();
        //at 3,6
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing West
        
        move();
        //at 3,5
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing North
    }
}
