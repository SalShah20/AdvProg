import kareltherobot.*;
import java.awt.Color;

/**
 * The Racer robot runs a one mile long race with hurdles, where
 * wall sections represent hurdles. The hurdles are only one
 * block high and are randomly placed between any two
 * corners in the race course.
 * 
 * @author Saloni Shah
 * with assistance from John Page
 * 
 *  
 * @version 06.18.2021
 */
public class Racer extends Robot
{
    /**
     * Creates a Racer object at a particular location 
     * and direction with a given number of beepers.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot
     * @param direction  specifies the direction of this robot
     * @param beepers    specifies this robot's number of beepers
     */
    public Racer (int street, int avenue, Direction direction, 
                  int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /** 
     * Makes a 90 degree turn clockwise.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    /**
     * Jumps up just past the height of a hurdle.
     * 
     * @precondition     This robot is at the base of the race 
     *                   with a hurdle directly in front.
     *                  
     * @postcondition    This robot is just past the height of a 
     *                   hurdle and facing the end of the race.                                    
     */ 
    public void jumpUp()
    {
        turnLeft();
        move();
        turnRight();
    }
    
    /**
     * Glides down the side of the hurdle facing the end of the 
     * race.
     * 
     * @precondition    This robot is above and one corner past 
     *                  the hurdle facing the rnd of the race.
     *
     * @postcondition   This robot is one corner past the hurdle, 
     *                  at the base of the race, and facing the
     *                  end of the race.
     */
    public void glideDown()
    {
        turnRight();
        move();
        turnLeft();
    }
    
    /**
     * Moves across the hurdle facing the end of the race.
     * 
     * @precondition    This robot is above the hurdle and 
     *                  one corner before the top of the hurdle.
     *                  This robot is facing the end of the 
     *                  race.
     *
     * @postcondition   This robot is one corner past the top 
     *                  hurdle and facing the end of the race.
     */
    public void moveAcross()
    {
        move();
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
    public void jumpHurdle()
    {
        jumpUp();
        moveAcross();
        glideDown();
    }
    
    /**
     * Takes one stride to the next corner. If the front is clear, 
     * this robot merely moves to the next corner. If the front is 
     * blocked by a hurdle (wall), this robot jumps the hurdle and
     * completes the jump on the next corner.
     * 
     * @precondition     This robot is at the base of the race and
     *                   facing the end of the race.
     *                  
     * @postcondition    This robot is at the base of the race and  
     *                   facing the end of the race.                                               
     */ 
    public void raceStride()
    {
        if (frontIsClear()) 
        {
            move();
        } 
        else 
        {
            jumpHurdle();
        }
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
    public void runRace()
    {
        raceStride();
        raceStride();
        raceStride();
        raceStride();
        raceStride();
        raceStride();
        raceStride();
        raceStride();
    }
}
