import kareltherobot.*;
import java.awt.Color;

/**
 * Karel is in bed and must get the newspaper and come back to bed.
 * 
 * @author  Saloni Shah
 * with assistance from John Page
 *
 * @version 06.14.2021 
 */
public class Newspaper2_5 extends Robot
{
    /**
     * Creates a Newspaper2_5 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Newspaper2_5 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Newspaper2_5 methods: */
    /**
     * Gets out of bed, 
     * picks up the newspaper,
     * and comes back to bed.
     * 
     * @precondition Robot starts at 3,4 facing West.
     * 
     * @postcondition Robot ends at 3,4 facing West
     */
    public void getPaper() 
    {
        //turn left 3 times to turn right
        turnLeft();
        turnLeft();
        turnLeft();
        //facing North
        
        move();
        move();
        //at 5,4 
        
        turnLeft();
        //facing West
        
        move();
        move();
        //at 5,2
        
        turnLeft();
        //facing South
        
        move();
        move();
        //at 3,2
        
        turnLeft();
        //facing East
        
        move();
        pickBeeper();
        turnLeft();
        turnLeft();
        //facing East
        
        move();
        //at 3,2
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing North
        
        move();
        move();
        //at 5,2
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing East
        
        move();
        move();
        //at 5,4
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing South
        
        move();
        move();
        //at 3,4
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing West
    }
}
