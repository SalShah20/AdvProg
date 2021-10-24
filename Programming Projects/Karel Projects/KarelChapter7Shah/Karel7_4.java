import kareltherobot.*;
import java.awt.Color;

/**
 * The robot must pick up a beeper from 1st Street and Nth Avenue, and deposit
 * it on Nth Street and 1st Avenue.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Karel7_4 extends Karel7
{
    /**
     * Creates a Karel7_4 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Karel7_4 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Karel7_4 methods: */
    /**
     * The robot finds a beeper on the street and moves North 
     * to a new street with the same avenue number.
     * 
     * @postcondition The robot is facing North on Nth Street and Nth Avenue.
     */
    public void findBeeper() 
    {
        if(!nextToABeeper()) 
        {
            move();
            findBeeper();
            move();
        } 
        else 
        {
            pickBeeper();
            faceNorth();
        }
    }

    /**
     * The robot moves to the first avenue and deposits a beeper.
     * 
     * @postcondition The robot is facing West on 1st Avenue and Nth Street.
     */
    public void moveBeeper() 
    {
        faceWest();
        if(frontIsClear()) 
        {
            move();
            moveBeeper();
        }
        if (anyBeepersInBeeperBag()) 
        {
            putBeeper();
        }
    }

    /**
     * The robot picks up the beeper from 1st Street and Nth Avenue and deposits
     * it on Nth Street and 1st Avenue.
     * 
     * @postcondition The robot is facing West on 1st Avenue and Nth Street on top of
     * a Beeper.
     */
    public void getBeeper() 
    {
        goToOrigin();
        faceEast();
        findBeeper();
        moveBeeper();
    }
}
