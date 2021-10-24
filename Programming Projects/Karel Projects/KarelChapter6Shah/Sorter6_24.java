import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must sort the columns of beepers by height.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.24.2021 
 */
public class Sorter6_24 extends Robot
{
    /**
     * Creates a Sorter6_24 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Sorter6_24 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Sorter6_24 methods: */
    /**
     * The robot turns around 180 degrees.
     */
    public void turnAround() 
    {
        turnLeft();
        turnLeft();
    }

    /**
     * The robot turns to face North.
     */
    public void faceNorth() 
    {
        while (!facingNorth()) 
        {
            turnLeft();
        }
    }

    /**
     * The robot turns to face East.
     */
    public void faceEast() 
    {
        while (!facingEast()) 
        {
            turnLeft();
        }
    }

    /**
     * The robot turns to face South.
     */
    public void faceSouth() 
    {
        while (!facingSouth()) 
        {
            turnLeft();
        }
    }

    /**
     * The robot picks up one row of beepers.
     * 
     * @precondition The robot must be facing the beepers (West)
     * 
     * @postcondition The robot will be facing the direction it came from (East)
     */
    public void pickUpRow() 
    {
        while (frontIsClear()) 
        {
            if (nextToABeeper()) 
            {
                pickBeeper();
            }
            move();
        } 
        if (nextToABeeper()) 
        {
            pickBeeper();
        }
        turnAround();
    }

    /**
     * The robot goes to the end of the row of beepers.
     * 
     * @precondition The robot must be standing on the first beeper.
     * 
     * @postcondition The robot will be at the end of the row.
     */
    public void goToEndOfRow() 
    {
        faceEast();
        while (nextToABeeper()) 
        {
            move();
        }
    }

    /**
     * Karel puts down all the beepers in its bag.
     * 
     * @precondition There must be some beepers in the robot's bag.
     * 
     * @postcondition The robot will have planted a row of beepers.
     */
    public void replaceRow() 
    {
        while (anyBeepersInBeeperBag()) 
        {
            putBeeper();
            move();
        }
        turnAround();
        move();
    }

    /**
     * The robot repositions itself at the right end of the next row.
     * 
     * @precondition The robot must be at the left end of the previous row.
     * 
     * @postcondition The robot will be at the right end of the next row.
     */
    public void positionRobot() 
    {
        faceSouth();
        while (frontIsClear()) 
        {
            move();
        }
        goToEndOfRow();
        moveToNextRow();
    }

    /**
     * The robot moves to the next row.
     * 
     * @precondition The robot must be on the right side of the previous row.
     * 
     * @postcondition The robot will be at the right end of the next row.
     */
    public void nextRow() 
    {
        faceNorth();
        move();
        turnLeft();
    }

    /**
     * The robot moves to the next row of beepers it must pick and plant.
     * 
     * @precondition The robot must be at the right end of the bottom row.
     * 
     * @postcondition The robot will be at the right end of the next row.
     */
    public void moveToNextRow() 
    {
        turnAround();
        move();
        faceNorth();
        while (nextToABeeper()) 
        {
            move();
        }
        turnLeft();
    }

    /**
     * The robot positions itself to start picking up a new row.
     * 
     * @precondition The robot must be at the start of the bottom row.
     * 
     * @postcondition The robot will be at the end of the next row.
     */
    public void startRow() 
    {
        goToEndOfRow();
        nextRow();
    }

    /**
     * The robot picks up one row of beepers.
     * 
     * @postcondition The robot will have picked up one row and 
     * positioned itslef to replant the row.
     * 
     * @return true if there are still more rows of beepers to collect; 
     * otherwise false.
     */
    public boolean pickOneRow() 
    {
        startRow();
        pickUpRow();
        positionRobot();
        return anyBeepersInBeeperBag();
    }

    /**
     * The robot sorts all the rows of beepers.
     * 
     * @postcondition The robot will have sorted all the rows of beepers.
     */
    public void sortRows() 
    {
        while (pickOneRow()) 
        {
            replaceRow();
        }
    }
}
