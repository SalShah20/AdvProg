import kareltherobot.*;
import java.awt.Color;

/**
 * The robot doubles the original avenue number of the beeper
 * and replaces the beeper.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Karel7_6 extends Karel7
{
    /**
     * Creates a Karel7_6 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Karel7_6 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Karel7_6 methods: */
    /**
     * The robot finds a beeper on the street and continues 
     * moving so it doubles the avenue number.
     * 
     * @postcondition The robot is facing East on 1st Street 
     * and 2Nth Avenue.
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
            faceEast();
        }
    }
    
    /**
     * The robot finds a beeper on the street and continues 
     * moving so it doubles the avenue number.
     * 
     * @postcondition The robot is facing East on 1st Street 
     * and 2Nth Avenue.
     */
    public void getBeeper() 
    {
        findBeeper();
        move();
        putBeeper();
    }
}
