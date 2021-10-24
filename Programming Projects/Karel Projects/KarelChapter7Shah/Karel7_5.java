import kareltherobot.*;
import java.awt.Color;

/**
 * The robot goes to the beeper on Sth Street and Ath Avenue
 * ,the robot places a beeper on 1st Street and Ath Avenue, 
 * and Sth Street and 1st Avenue.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Karel7_5 extends Karel7
{
    /**
     * Creates a Karel7_5 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Karel7_5 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Karel7_5 methods: */
    /**
     * The robot goes travels to find a beeper in a stair 
     * step pattern.
     * 
     * @postcondition The robot will be on the beeper.
     */
    public void findBeeper() 
    {
        goToOrigin();
        faceWest();
        while(!nextToABeeper()) 
        {
            if (facingWest()) 
            {
                zigMove();
            } 
            else 
            {
                zagMove();
            }
        }
    }

    /**
     * The robot picks up the beeper and takes it to the 
     * 1st Avenue and Nth Street.
     * 
     * @postcondition The robot will be against the left wall
     *                facing the beeper.
     */
    public void moveBeeper() 
    {
        if (facingWest()) 
        {
            if (frontIsClear()) 
            {
                move();
                moveBeeper();
                move();
            } 
            else 
            {
                putBeeper();
                turnAround();
            }
        }
    }

    /**
     * The robot returns to the beeper.
     * 
     * @postcondition The robot will be on the beeper.
     */
    public void goBackToBeeper() 
    {
        if (!nextToABeeper()) 
        {
            move();
            goBackToBeeper();
        }
    }

    /**
     * The robot takes a beeper to the 1st Street and Ath 
     * Avenue.
     * 
     * @postcondition The robot will be facing the center
     *                beeper.
     */
    public void beeperTwo() 
    {
        faceSouth();
        if (frontIsClear()) 
        {
            move();
            beeperTwo();
            move();
        } 
        else 
        {
            putBeeper();
            turnAround();
        }
    }

    /**
     * The robot moves diagonally up to the left, or it 
     * moves to a new line.
     * 
     * @precondition The robot must be facing West.
     */
    public void zigMove() 
    {
        if (frontIsClear()) 
        {
            zigLeftUp();
        } 
        else 
        {
            advanceToNextDiagonal();
        }
    }

    /**
     * The robot moves diagonally down to the right, or it 
     * moves to a new line.
     * 
     * @precondition The robot must be facing South.
     */
    public void zagMove() 
    {
        if (frontIsClear()) 
        {
            zagDownRight();
        } 
        else 
        {
            advanceToNextDiagonal();
        }
    }

    /**
     * The robot moves to another diagonal line.
     */
    public void advanceToNextDiagonal() 
    {
        if (facingWest()) 
        {
            faceNorth();
        } 
        else 
        {
            faceEast();
        }
        move();
        turnAround();
    }

    /**
     * The robot moves up to the left.
     * 
     * @precondition The robot must be facing West and front must be clear.
     * 
     * @postcondition The robot will be facing West.
     */
    public void zigLeftUp() 
    {
        move();
        turnRight();
        move();
        turnLeft();
    }

    /**
     * The robot moves down to the right.
     * 
     * @precondition The robot must be facing South and front must be clear.
     * 
     * @postcondition The robot will be facing South.
     */
    public void zagDownRight() 
    {
        move();
        turnLeft();
        move();
        turnRight();
    }

    /**
     * The robot gets goes to the center beeper and places 
     * another 2 beepers on the axes of the grid.
     * 
     * @postcondition The robot will be on 1st Street facing
     *                the center beeper.
     */
    public void getBeeper() 
    {
        findBeeper();
        moveBeeper();
        goBackToBeeper();
        beeperTwo();
    }
}
