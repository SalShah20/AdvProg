import kareltherobot.*;
import java.awt.Color;

/**
 * Karel jumps steeples by picking up beepers in a mile long race.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.18.2021 
 */
public class DifferentSteeplechaser5_10 extends SteepleChaser5_6
{
    /**
     * Creates a DifferentSteeplechaser5_10 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public DifferentSteeplechaser5_10 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* DifferentSteeplechaser5_10 methods: */
    /**
     * Jumps up the hurdle of beepers.
     * 
     * @precondition     This robot is at the base of the race 
     *                   with a hurdle directly in front.
     *                  
     * @postcondition    This robot is just past the height of a 
     *                   hurdle and facing the end of the race.                                    
     */ 
    @Override
    public void jumpUp () 
    {
        turnLeft();
        if (nextToABeeper()) 
        {
            pickBeeper();
            move();
            if (nextToABeeper()) 
            {
                pickBeeper();
                move();
            }
            if (nextToABeeper()) 
            {
                pickBeeper();
                move();
            }
        }
        turnRight();
    }
    /**
     * Jumps a hurdle.
     * 
     * @precondition     This robot is at the base of the race  
     *                   with the hurdle directly in front.
     *                  
     * @postcondition    This robot is one hurdle closer to the 
     *                   end of the race (past hurdle) and 
     *                   facing the end of the race.                                            
     */ 
    @Override
    public void jumpHurdle () 
    {
        jumpUp();
        glideDown();
    }
    /**
     * Takes one stride to the next corner. If the front is clear, 
     * this robot merely moves to the next corner. If the front is 
     * blocked by a hurdle (beepers), this robot jumps the hurdle and
     * completes the jump on the next corner.
     * 
     * @precondition     This robot is at the base of the race and
     *                   facing the end of the race.
     *                  
     * @postcondition    This robot is at the base of the race and  
     *                   facing the end of the race.                                               
     */
    @Override
    public void raceStride () 
    {
        move();
        if (nextToABeeper()) 
        {
            jumpHurdle();
        }
    }
}
