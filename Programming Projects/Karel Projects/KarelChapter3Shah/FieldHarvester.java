import kareltherobot.*;
import java.awt.Color;

/**
 * Karel harvests all the crops (beepers) from a field
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.16.2021
 */
public class FieldHarvester extends Harvester
{
    /**
     * Creates a FieldHarvester object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public FieldHarvester (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* FieldHarvester methods: */
    /**
     * The robot harvests all the crops in the field
     * 
     * @precondition Karel must be facing East
     * in front of the bottom row of crops
     * 
     * @postcondition Karel will pick up all the beepers
     * and facing West at the top row of all the crops.
     */
    public void harvestField() 
    {
        move();
        harvestTwoRows();
        positionForNextHarvest();
        move();
        harvestTwoRows();
        positionForNextHarvest();
        move();
        harvestTwoRows();
    }
}
