import kareltherobot.*;
import java.awt.Color;

/**
 * The robot goes around its world laying beepers on each
 * intersection. It makes sure to put only one beeper on each 
 * intersection.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Carpet7_2 extends Karel7
{
    /**
     * Creates a Carpet7_2 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Carpet7_2 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Carpet7_2 methods: */
    /**
     * Determines whether there is a beeper to the 
     * right of the robot.
     * 
     * @postcondition The robot is facing the same direction 
     *                as it started.
     * 
     * @return true if there is a beeper to the right of the 
     *         robot, otherwise false.
     */
    public boolean beeperToRight() 
    {
        if(rightIsClear()) 
        {
            turnRight();
            move();
            if(nextToABeeper()) 
            {
                turnAround();
                move();
                turnRight();
                return true;
            } 
            else 
            {
                turnAround();
                move();
                turnRight();
                return false;
            }
        } 
        else 
        {
            return true;
        }
    }

    /**
     * Determines whether there is a beeper to the left of
     * the robot.
     * 
     * @postcondition The robot is facing the same direction 
     *                as it started.
     *                
     * @return true if there is a beeper to the left of the
     *         robot, otherwise false.
     */
    public boolean beeperToLeft() 
    {
        if (leftIsClear()) 
        {
            turnLeft();
            move();
            if (nextToABeeper()) 
            {
                turnAround();
                move();
                turnLeft();
                return true;
            } 
            else 
            {
                turnAround();
                move();
                turnLeft();
                return false;
            }
        } 
        else 
        {
            return true;
        }
    }

    /**
     * Determines whether there is a beeper in front of
     * the robot.
     * 
     * @postcondition The robot is facing the same direction 
     *                as it started.
     * 
     * @return true if there is a beeper in front of 
     *         the robot, otherwise false.
     */
    public boolean beeperToFront() 
    {
        if (frontIsClear()) 
        {
            move();
            if (nextToABeeper()) 
            {
                turnAround();
                move();
                turnAround();
                return true;
            } 
            else 
            {
                turnAround();
                move();
                turnAround();
                return false;
            }
        } 
        else 
        {
            return true;
        }
    }
    
    /**
     * The robot turns around and comes back an intersection.
     */
    public void comeBack() 
    {
        turnAround();
        move();
        turnAround();
    }
    
    /**
     * Determines whether there needs to be a beeper on a 
     * specific intersection.
     * 
     * @return True if there is no beeper, otherwise false.
     */
    public boolean needsCarpet() 
    {
        if (frontIsClear()) 
        {
            move();
            if (!nextToABeeper()) 
            {
                comeBack();
                return true;
            } 
            else 
            {
                comeBack();
                return false;
            }
        } 
        else 
        {
            return false;
        }
    }
    
    /**
     * The robot checks each side and then lays a carpet.
     */
    public void checkEachSide() 
    {
        if (needsCarpet()) 
        {
            move();
            putDownCarpet();
            comeBack();
        }
    }
    
    /**
     * The robot lays the carpet.
     * 
     * @postcondition The robot is at the point where it 
     * started with beepers all over the world.
     */
    public void putDownCarpet() 
    {
        if (!nextToABeeper()) 
        {
            putBeeper();
        }
        if (frontIsClear()) 
        {
            checkEachSide();
        }
        if (leftIsClear()) 
        {
            turnLeft();
            checkEachSide();
            turnRight();
        } 
        if (rightIsClear()) 
        {
            turnRight();
            checkEachSide();
            turnLeft();
        } 
        turnAround();
        if (frontIsClear())
        {
            checkEachSide();
            turnAround();
        }
    }
}
