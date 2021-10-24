import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must cross a mile long race course with hurdles of 
 * differing heights and widths.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.23.2021 
 */
public class SuperDuperSteeplechaser6_11 extends SuperSteeplechaser6_10
{
    /**
     * Creates a SuperDuperSteeplechaser6_11 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public SuperDuperSteeplechaser6_11 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* SuperDuperSteeplechaser6_11 methods: */
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
    @Override
    public void moveAcross() 
    {
        move();
        while (!rightIsClear()) 
        {
            move();
        }
    }
}
