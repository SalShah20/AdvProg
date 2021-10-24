import kareltherobot.*;
import java.awt.Color;

/**
 * Karel harvests all the crops (beepers) in the field.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.16.2021 
 */
public class Harvester extends Robot
{
    /**
     * Creates a Harvester object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Harvester (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Harvester methods: */
    /**
     *  The robot can turn right.
     */
    public void turnRight() 
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    /**
     * Karel harvests one crop(beeper) and moves.
     * 
     * @precondition Karel must already be on a beeper.
     * 
     * @postcondition Karel will move off the beeper
     */
    public void harvestOneCrop() 
    {
        pickBeeper();
        move();
    }
    /**
     * Karel harvest one row of crops
     * 
     * @precondition Karel must be on the first beeper.
     * 
     * @postcondition Karel ends standing on the last beeper.
     */
    public void harvestOneRow() 
    {
        harvestOneCrop();
        harvestOneCrop();
        harvestOneCrop();
        harvestOneCrop();
        pickBeeper();
    }
   /**
     * Karel repositions himself at the beginning
     * of the next row of crops.
     * 
     * @precondition Karel must be in the row right below facing East
     * at the end of the row.
     * 
     * @postcondition Karel will end on the first beeper
     * of the next row.
     */
    public void positionRobot() 
    {
        super.move();
        this.turnLeft();
        super.move();
        this.turnLeft();
    }
    /**
     * Karel harvests two rows of crops.
     * 
     * @precondition Karel must start west of the crops facing East.
     * 
     * @postcondition Karel will end up on the last beeper 
     * of the second row.
     */
    public void harvestTwoRows() 
    {
        this.harvestOneRow();
        this.positionRobot();
        this.move();
        this.harvestOneRow();
        this.move();
    }
    /**
     * Karel repositions himslef for the next two rows
     * of harvesting.
     * 
     * @precondition Karel must be on the last beeper on the west of 
     * the field.
     * 
     * @postcondition Karel will end up on the first beeper of the next row
     * on the west side.
     */
    public void positionForNextHarvest() 
    {
        this.turnRight();
        super.move();
        this.turnRight();
    }
}
