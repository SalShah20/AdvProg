import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must follow the path of beepers back home.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.23.2021 
 */
public class PathOfBeepers6_14 extends Robot
{
    /**
     * Creates a PathOfBeepers6_14 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public PathOfBeepers6_14 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* PathOfBeepers6_14 methods: */
    /**
     * Karel turns 180 degrees.
     */
    public void turnAround() 
    {
        turnLeft();
        turnLeft();
    }
    /**
     * Karel turns right.
     */
    public void turnRight() 
    {
        for (int i = 0; i < 3; i++) 
        {
            turnLeft();
        }
    }
    /**
     * Karel turns to face East.
     * 
     * @postcondition Karel ends up facing East.
     */
    public void faceEast() 
    {
        while (!facingEast()) 
        {
            turnLeft();
        }
    }
    /**
     * Karel turns around and goes back to it's last spot on the path.
     * 
     * @precondition Karel must be one block away from the path.
     * 
     * @postcondition Karel will be back on the path in the same 
     * position it was just in.
     */
    public void goBack() 
    {
        turnAround();
        move();
        turnAround();
    }
    /**
     * Tests to see if Karel is at home (has 2 beepers under it instead of 1).
     * 
     * @return true if Karel reached the end of the path; otherwise false.
     */
    public boolean findHome() 
    {
        if (nextToABeeper()) 
        {
            pickBeeper();
            if (nextToABeeper()) 
            {
                return true;
            }
            return false;
        } 
        else 
        {
            return false;
        }
    }
    /**
     * Karel turns in all four directions to find the path.
     * 
     * @precondition Karel must have at least one beeper one block away from it.
     * 
     * @postcondition Karel will be back on the path.
     */
    public void findPath() 
    {
        if (!nextToABeeper()) 
        {
            goBack();
            turnLeft();
            move();
            if (!nextToABeeper()) {
                goBack();
                turnLeft();
                move();
                if(!nextToABeeper()) {
                    goBack();
                    turnLeft();
                    move();
                }
            }
        }
    }
    /**
     * Karel follows the beeper path all the way back home.
     * 
     * @precondition Karel must be one block before the beeper path.
     * 
     * @postcondition Karel will stop at home.
     */
    public void followTheBeeperPath() 
    {
        move();
        while (!findHome()) 
        {
            move();
            if (!nextToABeeper()) 
            {
                findPath();
            }
        }
    }
}
