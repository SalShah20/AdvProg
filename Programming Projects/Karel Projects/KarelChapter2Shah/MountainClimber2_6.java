import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must climb the mountain, 
 * place a flag(beeper) on top, 
 * and then come back down on the other side.
 * 
 * @author  Saloni Shah
 * with assistance from John Page
 *
 * @version 06.14.2021 
 */
public class MountainClimber2_6 extends Robot
{
    /**
     * Creates a MountainClimber2_6 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public MountainClimber2_6 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* MountainClimber2_6 methods: */
    /**
     * Climbs the mountain,
     * places the beeper on top,
     * and then climbs back down.
     * 
     * @precondition Robot starts at 1,2 facing East
     * 
     * @postcondition Robot ends at 1,8 facing West
     */
    public void climbMountain() 
    {
        move();
        //at 1,3
        
        turnLeft();
        //facing North
        
        move();
        move();
        //at 3,3
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing East
        
        move();
        //at 3,4
        
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
        //at 5,5
        
        putBeeper();
        //placed flag
        
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
        //facing East
        
        move();
        //at 3,7
        
        turnLeft();
        turnLeft();
        turnLeft();
        //facing South
        
        move();
        move();
        //at 1,7
        
        turnLeft();
        //facing East
        
        move();
        //at 1,8
    }
}
