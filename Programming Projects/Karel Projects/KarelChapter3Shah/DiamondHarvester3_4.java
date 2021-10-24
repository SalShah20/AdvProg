import kareltherobot.*;
import java.awt.Color;

/**
 * Karel harvests a diamond shaped field of crops(beepers).
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.17.2021 
 */
public class DiamondHarvester3_4 extends Harvester
{
    /**
     * Creates a DiamondHarvester3_4 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public DiamondHarvester3_4 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    /* DiamondHarvester3_4 methods: */
    /**
     * Karel moves diagonally up to the right.
     */
    @Override
    public void move() 
    {
        this.turnRight();
        super.move();
        this.turnLeft();
        super.move();
    }
    /**
     * Karel moves diagonally to the right and 
     * picks up a beeper.
     * 
     * @precondition The robot must be diagonally to
     * the left of the beeper.
     * 
     * @postcondition The robot will end up 
     * on the corner of the beeper.
     */
    @Override
    public void harvestOneCrop() 
    {
        this.move();
        this.pickBeeper();
    }
    /**
     * Karel harvests one row of crops(beepers).
     * 
     * @precondition The robot must be on top of a 
     * beeper at the bottom of a diagonal row.
     * 
     * @postcondition The robot will end on top of 
     * the last beeper of the row.
     */
    @Override
    public void harvestOneRow() 
    {
        this.pickBeeper();
        this.harvestOneCrop();
        this.harvestOneCrop();
        this.harvestOneCrop();
    }
    /**
     * Karel harvests two diagonal rows of crops(beepers).
     * 
     * @precondition Karel must be below the first beeper.
     * 
     * @postcondition Karel will end on the last beeper 
     * of the second row.
     */
    @Override
    public void harvestTwoRows() 
    {
        super.move();
        this.harvestOneRow();
        super.positionRobot();
        this.harvestOneRow();
    }
    /**
     * Karel harvests a diamond shaped field. 
     * 
     * @precondition Karel must be below the first beeper.
     * 
     * @postcondition Karel will end on the last beeper 
     * of the second row.
     */
    public void harvestField() 
    {
        this.harvestTwoRows();      
        super.positionForNextHarvest();
        this.harvestTwoRows();
    }
}
