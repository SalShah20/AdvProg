import kareltherobot.*;
import java.awt.Color;

/**
 * Karel harvests wider rows of crops (beepers).
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.16.2021
 */
public class WideHarvester extends FieldHarvester
{
    /**
     * Creates a WideHarvester object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public WideHarvester (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    /* WideFieldHarvester methods: */
    /**
     * Karel harvests a wider row of crops (beepers).
     * 
     * @precondition Karel must be on the first beeper.
     * 
     * @postcondition Karel ends standing on the last beeper.
     */
    public void harvestOneRow() 
    {
        super.harvestOneRow();
        move();
        pickBeeper();
        move();
        pickBeeper();
    }
}
