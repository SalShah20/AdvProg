import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must pass through the maze.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.22.2021 
 */
public class MazeWalker6_16 extends MazeWalker5_9
{
    /**
     * Creates a MazeWalker6_16 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * 
     * @param beepers    specifies this robot's number of beepers.
     * 
     * @param color      specifies the robot's color.
     */
    public MazeWalker6_16 (int street, int avenue, 
           Direction direction, int beepers, Color color)
    {
        super(street, avenue, direction, beepers, color);
    }
    
    /* MazeWalker6_16 methods: */
    /**
     * The robot walks through the maze.
     * 
     * @precondition It must always have a wall to its right.
     * 
     * @postcondition It will stop on the beeper.
     */
    public void walkMaze() 
    {
        while (!nextToABeeper()) 
        {
            if (nextToABeeper()) 
            {
                pickBeeper();
            }
            followWallRight();
        }
    }
}
