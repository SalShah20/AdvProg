
import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must follow the clues (piles of beepers) 
 * and reach the treasure, a pile of five beepers.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.23.2021 
 */
public class TreasureHunter6_18 extends Robot
{
    /**
     * Creates a TreasureHunter6_18 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public TreasureHunter6_18 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* TreasureHunter6_18 methods: */
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
     */
    public void faceEast() 
    {
        while (!facingEast()) 
        {
            turnLeft();
        }
    }

    /**
     * Karel turns to face South.
     */
    public void faceSouth() 
    {
        while (!facingSouth()) 
        {
            turnLeft();
        }
    }

    /**
     * Karel turns to face West.
     */
    public void faceWest() 
    {
        while (!facingWest()) 
        {
            turnLeft();
        }
    }

    /**
     * Karel turns to face North.
     */
    public void faceNorth() 
    {
        while (!facingNorth()) 
        {
            turnLeft();
        }
    }

    /**
     * Karel counts the beepers and figures out what direction to move in.
     * 
     * @precondition Karel must be standing on a pile of beepers.
     * 
     * @postcondition Karel will turn and face the direction it has to go.
     */
    public void findDirection() 
    {
        faceNorth();
        if (nextToABeeper()) 
        {
            pickBeeper();
            turnLeft();
            if (nextToABeeper()) 
            {
                pickBeeper();
                turnLeft();
                if (nextToABeeper()) 
                {
                    pickBeeper();
                    turnLeft();
                    if (nextToABeeper()) 
                    {
                        pickBeeper();
                        turnLeft();
                    }   
                }
            }
        }
        if (facingNorth()) 
        {
            faceEast();
        } 
        else if (facingEast()) 
        {
            faceSouth();
        } 
        else if (facingSouth()) 
        {
            faceWest();
        } 
        else 
        {
            faceNorth();
        }
    }

    /**
     * Karel moves to the next beeper and turns if it needs to.
     * 
     * @postcondition Karel will be on the path one block closer to the end.
     */
    public void findTreasure() 
    {
        while (!nextToABeeper()) 
        {
            move();
        }
        findDirection();
    }

    /**
     * States whether Karel has reached the treasure or not.
     * 
     * @return true if Karel is at the treasure; otherwise false.
     */
    public boolean foundTreasure() 
    {
        if (nextToABeeper()) 
        {
            pickBeeper();
            return true;
        } 
        else 
        {
            return false;
        }
    }

    /**
     * Karel goes around the world and ends on the treasure.
     * 
     * @precondition Karel must be facing the first pile of beepers.
     * 
     * @postcondition Karel will be on the treasure.
     */
    public void getTreasure() 
    {
        while (!foundTreasure()) 
        {
            findTreasure();
        }
    }
}
