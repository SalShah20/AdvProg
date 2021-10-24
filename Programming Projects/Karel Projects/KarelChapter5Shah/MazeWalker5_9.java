import kareltherobot.*;
import java.awt.Color;

/**
 * The robots must follow the wall to their rights.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.21.2021 
 */
public class MazeWalker5_9 extends Robot
{
    /**
     * Creates a MazeWalker5_9 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * 
     * @param beepers    specifies this robot's number of beepers.
     * 
     * @param color      specifies the color of the robot.
     */
    public MazeWalker5_9 (int street, int avenue, 
           Direction direction, int beepers, Color color)
    {
        super(street, avenue, direction, beepers, color);
    }
    
    /* MazeWalker5_9 methods: */
    /**
     * The robot turns right.
     */
    public void turnRight() 
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    /**
     * Checks if the right side is clear.
     * 
     * @return true if there is no wall to the right, otherwise false.
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
    /**
     * The robots must follow the wall to their right.
     * 
     * @precondition There must be a wall to the robot's right.
     * 
     * @postcondition There will be a wall to the robot's right.
     */
    public void followWallRight() 
    {
        if (frontIsClear()) 
        {
            // when there is no wall in front, the robot moves forward
            move();       
            if (rightIsClear()) 
            {
                //if there is no wall on the right, it turns right and moves
                turnRight();
                move();
                if (rightIsClear()) 
                {
                    //if there is now wall on the right it turns right and moves
                    turnRight();
                    move();
                
                } 
            } 
        } 
        else if (!frontIsClear()) 
        {
            //if there is a wll in the front, it turns left
            turnLeft();
        }
    }
}
