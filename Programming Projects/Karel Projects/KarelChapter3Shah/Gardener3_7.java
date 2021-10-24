import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must plant beepers all around the plus sign.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.17.2021 
 */
public class Gardener3_7 extends Robot
{
    /**
     * Creates a Gardener3_7 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Gardener3_7 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Gardener3_7 methods: */
    /**
     * Karel turns right.
     */
    public void turnRight() 
    {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }
    /**
     * Karel turns around.
     */
    public void turnAround() 
    {
        this.turnLeft();
        this.turnLeft();
    }
    /**
     * Karel plants a crop.
     * 
     * @precondition The robot must have at least 1 beeper
     * in its bag.
     * 
     * @postcondition The robot will have used 1 beeper.
     */
    public void plantCrop() 
    {
        this.move();
        this.putBeeper();
    }
    /**
     * Karel plants the middle row of beepers.
     * 
     * @precondition The robot must have at least 1 beeper
     * in its bag.
     * 
     * @postcondition The robot will have used 1 beeper.
     */
    public void plantMiddleRow() 
    {
        this.turnRight();
        this.plantCrop();
        this.turnRight();
    }
    /**
     * Karel plants one row.
     * 
     * @precondition The robot must have at least 3 
     * beepers in its bag.
     * 
     * @postcondition The robot will have used 3 beepers.
     */
    public void plantOneRow() 
    {
        this.plantCrop();
        this.plantCrop();
        this.plantCrop();
        this.turnLeft();
    }
    /**
     * Karel plants two rows.
     * 
     * @precondition The robot must have at least 7 beepers.
     * 
     * @postcondition The robot will have planted 7 beepers.
     */
    public void plantTwoRows() 
    {
        plantCrop();
        plantCrop();
        plantCrop();
        plantMiddleRow();
        plantOneRow();
    }
    /**
     * Karel plants the entire garden.
     * 
     * @precondition The robot must have at least 28 
     * beepers in its bag.
     * 
     * @postcondition The robot will have used 28 beepers.
     */
    public void plantGarden() 
    {
        this.turnAround();
        this.move();
        this.move();
        this.plantCrop();
        this.plantCrop();
        this.turnRight();
        this.plantOneRow();
        this.plantTwoRows();
        this.plantTwoRows();
        this.plantTwoRows();
        this.plantOneRow();
        this.pickBeeper();
        this.move();
    }
}
