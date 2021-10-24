import kareltherobot.*;
import java.awt.Color;

/**
 * The Racer robot runs a one mile long race with hurdles, where
 * wall sections represent hurdles. The hurdles are different
 * sizes and are randomly placed between any two
 * corners in the race course.
 * 
 * @author Saloni Shah
 * with assistance from John Page
 * 
 * @version 06.18.2021
 */
public class SteepleChaser5_6 extends Racer
{
    /**
     * Creates a SteepleChaser5_6 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public SteepleChaser5_6 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* SteepleChaser5_6 methods: */
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
        move();
        if (rightIsClear()) 
        {
            turnRight();
        } 
        else 
        {
            turnRight();
            jumpUp();
        }
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
        move();
        if (frontIsClear()) 
        {
            turnLeft();
            glideDown();
        } 
        else 
        {
            turnLeft();
        }
    }
    /**
     * Checks if the right side is clear (has no walls).
     * 
     * @return boolean
     */
    public boolean rightIsClear() 
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
}
