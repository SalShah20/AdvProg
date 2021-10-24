import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must write "Hello" with beepers.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.17.2021 
 */
public class AlienWriter3_5 extends Robot
{
    /**
     * Creates a AlienWriter3_5 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public AlienWriter3_5 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* AlienWriter3_5 methods: */
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
     * Karel puts down a beeper and moves forward.
     */
    public void writeDot() 
    {
        this.putBeeper();
        this.move();
    }
    /**
     * Karel writes 1 line of 5 dots(beepers).
     * 
     * @precondition The robot must have at least 5 beepers in its bag.
     * 
     * @postcondition The robot will have used 5 beepers.
     */
    public void writeLine() 
    {
        this.writeDot();
        this.writeDot();
        this.writeDot();
        this.writeDot();
        this.putBeeper();
    }
    /**
     * Karel gets in position to write the next letter
     * 
     * @precondition The robot must be facing East.
     * 
     * @postcondition The robot will be facing North.
     */
    public void positionRobot() 
    {
        this.move();
        this.move();
        this.turnLeft();
    }
    /**
     * Karel writes the letter 'h'
     * 
     * @precondition The robot must have at least 12 beepers in its bag.
     * 
     * @postcondition The robot will have used 12 beepers.
     */
    public void writeH() 
    {
        this.writeLine();
        this.turnAround();
        this.positionRobot();
        this.move();
        this.writeDot();
        this.putBeeper();
        this.turnRight();
        this.positionRobot();
        this.move();
        this.turnLeft();
        this.writeLine();
        this.turnAround();
        this.move();
        this.move();
        this.positionRobot();
    }
    /**
     * Karel writes the letter 'e'
     * 
     * @precondition The robot must have at least 11 beepers in its bag.
     * 
     * @postcondition The robot will have used 11 beepers.
     */
    public void writeE() 
    {
        this.writeLine();
        this.turnRight();
        this.move();
        this.writeDot();
        this.putBeeper();
        this.turnRight();
        this.move();
        this.move();
        this.turnRight();
        this.writeDot();
        this.putBeeper();
        this.turnLeft();
        this.positionRobot();
        this.writeDot();
        this.putBeeper();
    }
    /**
     * Karel writes the letter 'l'
     * 
     * @precondition The robot must have at least 7 beepers in its bag.
     * 
     * @postcondition The robot will have used 7 beepers.
     */
    public void writeL() 
    {
        this.writeLine();
        this.turnAround();
        this.move();
        this.move();
        this.positionRobot();
        this.move();
        this.writeDot();
        this.putBeeper();
    }
    /**
     * Karel writes the letter 'o'
     * 
     * @precondition The robot must have at least 12 beepers in its bag. 
     * 
     * @postcondition The robot will have used 12 beepers.
     */
    public void write0() 
    {
        this.turnRight();
        this.move();
        this.writeDot();
        this.turnLeft();
        this.writeLine();
        this.turnLeft();
        this.move();
        this.writeDot();
        this.turnLeft();
        this.writeLine();
        this.turnLeft();
        this.move();
        this.move();
    }
    /**
     * Karel writes the word 'hello'
     * 
     * @precondition The robot must have at least
     * 49 beepers in its bag.
     * 
     * @postcondition The robot will have used 49 beepers.
     */
    public void writeHello()
    {
        this.writeL();
        this.positionRobot();
        this.write0();
        this.positionRobot();
        this.writeL();
        /*this.positionRobot();
        this.writeL();
        this.positionRobot();
        this.write0();
        this.positionRobot();*/
    }
}
