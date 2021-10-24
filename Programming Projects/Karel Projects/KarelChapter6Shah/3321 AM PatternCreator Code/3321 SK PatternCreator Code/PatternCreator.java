
import kareltherobot.*;
import java.awt.Color;

/**
 * Creates various patterns using beepers.
 * 
 * @author  Alexandra Michael 
 *   With assistance from the whole class
 *
 * @version 7/1/14
 */
public class PatternCreator extends Robot
{
    /**
     * Creates a PatternCreator object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public PatternCreator (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    /* PatternCreator methods: */
    /**
     * Rotates 180 degrees.
     */
    public void turnAround()
    {
        turnLeft();;
        turnLeft();
    }
    
    /**
     * Rotates 90 degrees right.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    /**
     * Drops to the row immediately beneath the robot in 
     * preparation to laydown another row of beepers.  The 
     * row of beepers is to start next to a wall.
     * 
     * @precondition  Wall must exist behind the robot.
     */
    public void goToNextRow()
    {
        turnAround();
        while (frontIsClear())
        {
            move();
        }
        turnLeft();
        move();
        turnLeft();
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown11()
    {
        System.out.println("Pattern 11");
        for (int i = 3; i > 0; i--)
        {
            for (int j = 3; j > 0; j--)
            {
                for (int k = 0; k < i; k++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown10()
    {
        System.out.println("Pattern 10");
        for (int x = 3; x > 0; x--)
        {
            for (int y = x; y > 0; y--)
            {
                for (int z = y; z > 0; z--)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown9()
    {
        System.out.println("Pattern 9");
        for (int j = 0; j < 3; j++)
        {
            for (int x = 3; x > j; x--)
            {
                for (int y = 0; y < x; y++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown8()
    {
        System.out.println("Pattern 8");
        for (int i = 0; i < 3; i++)
        {
            for (int j = i; j >= 0; j--)
            {
                for (int k = 0; k <= j; k++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown7()
    {
        System.out.println("Pattern 7");
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y <= x; y++)
            {
                for (int z = 0; z <= y; z++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown6()
    {
        System.out.println("Pattern 6");
        for (int a = 0; a < 3; a++)
        {
            for (int b = 0; b <= a; b++)
            {
                for (int z = 0; z < 3; z++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown5()
    {
        System.out.println("Pattern 5");
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                for (int z = 0; z <= x; z++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown4()
    {
        System.out.println("Pattern 4");
        for (int row = 0; row < 2; row++)
        {
            for (int col = 0; col < 4; col++)
            {
                for (int pile = 0; pile < 50; pile++)
                {
                    putBeeper();
                }
                move();
            }
            goToNextRow();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown3()
    {
        System.out.println("Pattern 3");
        for (int x = 4; x > 0; x--)
        {
            for (int y = 0; y < x; y++)
            {
                putBeeper();
            }
            move();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown2()
    {
        System.out.println("Pattern 2");
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                putBeeper();
            }
            move();
        }
    }
    
    /**
     * Puts down a pattern of beepers.  
     * Guesss the pattern.  Then run the
     * code.
     */
    public void putDown1()
    {
        System.out.println("Pattern 1");
        for (int x = 0; x < 5; x++)
        {
            for (int y = 0; y < 12; y++)
            {
                putBeeper();
            }
            move();
        }
    }
}
