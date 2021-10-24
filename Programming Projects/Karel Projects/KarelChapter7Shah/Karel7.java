import kareltherobot.*;
import java.awt.Color;

/**
 * These are the basic commands used in Karel Chapter 7 projects.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Karel7 extends Robot
{
    /**
     * Creates a Karel7 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Karel7 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Karel7 methods: */
    /**
     * The robot turns 180 degrees.
     */
    public void turnAround() 
    {
        turnLeft();
        turnLeft();
    }

    /**
     * The robot turns right.
     */
    public void turnRight() 
    {
        for (int i = 0; i < 3; i ++) 
        {
            turnLeft();
        }
    }

    /**
     * The robot turns to face East.
     */
    public void faceEast() 
    {
        if (!facingEast()) 
        {
            turnLeft();
            faceEast();
        }
    }

    /**
     * The robot turns to face North.
     */
    public void faceNorth() 
    {
        if (!facingNorth()) 
        {
            turnLeft();
            faceNorth();
        }
    }

    /**
     * The robot turns to face West.
     */
    public void faceWest() 
    {
        if (!facingWest()) 
        {
            turnLeft();
            faceWest();
        }
    }

    /**
     * The robot turns to face South.
     */
    public void faceSouth() 
    {
        if (!facingSouth()) 
        {
            turnLeft();
            faceSouth();
        }
    }

    /**
     * The robot moves to the origin of the world.
     * 
     * @postcondition The robot ends up at 1,1 facing South.
     */
    public void goToOrigin() 
    {
        faceWest();
        if(frontIsClear()) 
        {
            //reductive case
            move();
            goToOrigin();
        }
        faceSouth();
        if (frontIsClear()) 
        {
            //reductive case
            move();
            goToOrigin();
        }
    }
    
    /**
     * Tests if there is a wall to the right of this robot.
     * 
     * @postcondition  This robot is facing the same direction 
     *                 as when it entered the method.
     * 
     * @return true if there is no wall to the right; 
     *         otherwise,false
     */
    public boolean rightIsClear( )
    {
        turnRight();
        if (frontIsClear()) 
        {
            turnLeft();
            return true;
        } 
        else 
        {
            turnLeft();
            return false;
        }
    }
    
    /**
     * Tests if there is a wall to the left of this robot.
     * 
     * @postcondition  This robot is facing the same 
     *                 direction as when it entered 
     *                 the method.
     * 
     * @return true if there is no wall to the left; otherwise,
     *         false
     */
    public boolean leftIsClear( )
    {
        turnLeft();
        if (frontIsClear()) 
        {
            turnRight();
            return true;
        } 
        else 
        {
            turnRight();
            return false;
        }
    }
}
