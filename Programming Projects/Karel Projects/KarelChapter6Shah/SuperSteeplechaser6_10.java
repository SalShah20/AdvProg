import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must cross the one mile long row of 
 * steeples of differing heights.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.23.2021 
 */
public class SuperSteeplechaser6_10 extends SteepleChaser5_6
{
    /**
     * Creates a SuperSteeplechaser6_10 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public SuperSteeplechaser6_10 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* SuperSteeplechaser6_10 methods: */
    /**
     * Jumps up just past the height of a hurdle.
     * 
     * @precondition     This robot is at the base of the race 
     *                   with a hurdle directly in front.
     *                  
     * @postcondition    This robot is just past the height of a 
     *                   hurdle and facing the end of the race.                                    
     */
    @Override
    public void jumpUp() 
    {
        turnLeft();
        while (!rightIsClear()) 
        {
            move();
        }
        turnRight();
    }

    /**
     * Glides down the side of the hurdle facing the end of the 
     * race.
     * 
     * @precondition    This robot is above and one corner past 
     *                  the hurdle facing th eend of the race.
     *
     * @postcondition   This robot is one corner past the hurdle, 
     *                  at the base of the race, and facing the
     *                  end of the race.
     */
    @Override
    public void glideDown() 
    {
        turnRight();
        while (frontIsClear()) 
        {
            move();
        }
        turnLeft();
    } 

    /**
     * Runs the entire race.
     * 
     * @precondition    This robot is facing the end of race.
     *
     * @postcondition   This robot has completed race and is past 
     *                  final hurdle.  This robot is facing the same
     *                  direction as it started.
     */
    @Override
    public void runRace() 
    {
        while (!nextToABeeper()) 
        {
            raceStride();
        }
        if (nextToABeeper()) 
        {
            pickBeeper();
        }
    }
}
