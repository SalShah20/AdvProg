import kareltherobot.*;
import java.awt.Color;

/**
 * The robot has to pick the room with less than infinity beepers based
 * on whether the pile its standing on has an odd or even number of beepers. 
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.22.2021
 */
public class Spy6_4 extends Robot
{
    /**
     * Creates a Spy6_4 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Spy6_4 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Spy6_4 methods: */
    /**
     * The robot turns right.
     */
    public void turnRight() 
    {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }
    /**
     * The robot turns around.
     */
    public void turnAround() 
    {
        this.turnLeft();
        this.turnLeft();
    }
    /**
     * The robot turns to face west.
     */
    public void faceWest() 
    {
        if (!facingWest()) 
        {
            if (facingNorth()) 
            {
                this.turnLeft();
            } 
            else if (facingEast()) 
            {
                this.turnAround();
            } 
            else 
            {
                this.turnRight();
            }
        }
    }
    /**
     * The robot turns to face east.
     */
    public void faceEast() 
    {
        if (!facingEast()) 
        {
            if (facingNorth()) 
            {
                this.turnRight();
            } 
            else if (facingSouth()) 
            {
                this.turnLeft();
            } 
            else 
            {
                this.turnAround();
            }
        }
    }
    /**
     * The robot checks the pile of beepers to see if its odd or even.
     * 
     * @precondition The robot must be standing on a pile of beepers.
     * 
     * @postcondition The robot will have picked up all the beepers.
     * 
     * @return It returns true if the pile is even, otherwise false.
     */
    public boolean checkPile() 
    {
        while (nextToABeeper()) 
        {
            this.pickBeeper();
            this.turnLeft();
        }
        return (facingSouth() || facingNorth()); 
    }
    /**
     * The robot checks the pile and picks a room to go to.
     */
    public void pickRoom() 
    {
        if (checkPile()) 
        {
            this.faceEast();
        } 
        else 
        {
            this.faceWest();
        }
        this.move();
        while (nextToABeeper()) 
        {
            this.pickBeeper();
        }
    }
}
