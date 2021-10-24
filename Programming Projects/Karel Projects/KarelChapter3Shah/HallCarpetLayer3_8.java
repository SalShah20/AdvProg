import kareltherobot.*;
import java.awt.Color;

/**
 * Karel makes a square carpet of beepers.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page.
 *
 * @version 06.17.2021 
 */
public class HallCarpetLayer3_8 extends Robot
{
    /**
     * Creates a HallCarpetLayer3_8 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public HallCarpetLayer3_8 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* HallCarpetLayer3_8 methods: */
    /**
     * Karel plants one beepers and moves.
     * 
     * @precondition The robot must have at least 1 beeper
     * in its bag.
     * 
     * @postcondition The robot will have used 1 beeper.
     */
    @Override
    public void putBeeper() 
    {
        super.putBeeper();
        this.move();
    }
    /**
     * Karel makes one row of the carpet.
     * 
     * @precondition The robot must have at least 7 beepers.
     * 
     * @postcondition The robot will have used 7 beepers.
     */
    public void makeOneRow() 
    {
        this.putBeeper();
        this.putBeeper();
        this.putBeeper();
        this.putBeeper();
        this.putBeeper();
        this.putBeeper();
        this.putBeeper();
        this.turnLeft();
    }
    /**
     * Karel makes a carpet.
     * 
     * @precondition The robot must have at least 
     * 28 beepers in its bag.
     * 
     * @postcondition The robot will have used 28 beepers.
     */
    public void makeCarpet() 
    {
        this.makeOneRow();
        this.makeOneRow();
        this.makeOneRow();
        this.makeOneRow();
        this.move();
    }
}
