import kareltherobot.*;
import java.awt.Color;

/**
 * Karel harvests more rows of crops (beepers).
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.16.2021 
 */
public class TallHarvester extends FieldHarvester
{
    /**
     * Creates a TallHarvester object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public TallHarvester (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* TallFieldHarvester methods: */
    /**
     * Karel harvest two extra rows of crops (beepers).
     * 
     * @precondition Karel must be facing East
     * in front of the bottom row of crops
     * 
     * @postcondition Karel will pick up all the beepers
     * and facing West at the top row of all the crops.
     */
    @Override
    public void harvestField() 
    {
        super.harvestField();
        positionForNextHarvest();
        move();
        harvestTwoRows();
    }
}
