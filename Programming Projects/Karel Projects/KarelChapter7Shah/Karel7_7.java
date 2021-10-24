import kareltherobot.*;
import java.awt.Color;

/**
 * The robot finds a beeper on the 1st Street and Nth Avenue,
 * the robot leaves N beepers at the origin.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Karel7_7 extends Karel7
{
    /**
     * Creates a Karel7_7 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Karel7_7 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Karel7_7 methods: */
    /**
     * The robot finds a beeper on the street and returns to
     * the origin to put down beepers.
     * 
     * @postcondition The robot is facing West on 1st Street 
     *                and 1st Avenue.
     */
    public void findBeeper() 
    {
        if(!nextToABeeper()) 
        {
            move();
            findBeeper();
            goToOrigin();
            putBeeper();
        } 
        else 
        {
            pickBeeper();
        }
    }

    /**
     * The robot finds a beeper on the street and returns to
     * the origin to put down beepers.
     * 
     * @postcondition The robot is facing East on 1st Street 
     *                and 2nd Avenue.
     */
    public void getBeeper() 
    {
        goToOrigin();
        faceEast();
        findBeeper();
        putBeeper();
        turnLeft();
        move();
    }
}
