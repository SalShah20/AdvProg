import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must draw a clock.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.17.2021 
 */
public class DigitalClock3_2 extends AlienWriter3_5
{
    /**
     * Creates a DigitalClock3_2 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public DigitalClock3_2 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* DigitalClock3_2 methods: */
    /**
     * Karel writes the number '1'
     * 
     * @precondition The robot must have at least 5 beepers in its bag.
     * 
     * @postcondition The robot will have used 5 beepers.
     */
    public void write1() 
    {
        super.writeLine();
        super.turnAround();
        this.move();
        this.move();
        super.positionRobot();
    }
    /**
     * Karel writes the number '2'
     * 
     * @precondition The robot must have at least 11 beepers in its bag.
     * 
     * @postcondition The robot will have used 11 beepers.
     */
    public void write2() 
    {
        this.move();
        this.move();
        this.move();
        this.move();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        super.writeDot();
        super.writeDot();
        this.putBeeper();
    }
    /**
     * Karel writes the number '3'
     * 
     * @precondition The robot must have at least 11 beepers in its bag.
     * 
     * @postcondition The robot will have used 11 beepers.
     */
    public void write3() 
    {
        this.move();
        this.move();
        this.move();
        this.move();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnAround();
        super.writeDot();
        this.move();
        super.turnRight();
        this.move();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnAround();
        super.writeDot();
        this.move();
    }
    /**
     * Karel writes the number '4' 
     * 
     * @precondition The robot must have at least 9 beepers in its bag.
     * 
     * @postcondition The robot will have used 9 beepers.
     */
    public void write4() 
    {
        this.move();
        this.move();
        this.move();
        this.move();
        super.turnAround();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        this.move();
        this.move();
        super.turnAround();
        super.writeLine();
        this.turnLeft();
    }
    /**
     * Karel writes the number '5'
     * 
     * @precondition The robot must have at least 11 beepers in its bag.
     * 
     * @postcondition The robot will have used 11 beepers.
     */
    public void write5() 
    {
        super.turnRight();
        super.positionRobot();
        this.move();
        this.move();
        super.positionRobot();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        super.writeDot();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        this.turnRight();
        super.writeDot();
        super.writeDot();
        this.turnAround();
        super.writeDot();
        this.move();
    }
    /**
     * Karel writes the number '6'
     * 
     * @precondition The robot must have at least 12 beepers in its bag.
     * 
     * @postcondition The robot will have used 12 beepers.
     */
    public void write6() 
    {
        super.turnRight();
        super.positionRobot();
        this.move();
        this.move();
        super.positionRobot();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        super.writeLine();
        this.turnLeft();
        this.move();
        super.writeDot();
        this.turnLeft();
        super.writeDot();
        super.writeDot();
        this.turnLeft();
        this.move();
        super.turnAround();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        this.move();
        this.turnLeft();
    }
    /**
     * Karel writes the number '7'
     * 
     * @precondition The robot must have at least 7 beepers in its bag.
     * 
     * @postcondition The robot will have used 7 beepers.
     */
    public void write7() 
    {
        this.move();
        this.move();
        this.move();
        this.move();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        this.putBeeper();
        super.turnRight();
        super.writeLine();
        this.turnLeft();
    }
    /**
     * Karel writes the number '8'
     * 
     * @precondition The robot must have at least 13 beepers in its bag.
     * 
     * @postcondition The robot will have used 13 beepers.
     */
    public void write8() 
    {
        super.writeLine();
        super.turnRight();
        this.move();
        super.writeDot();
        super.turnRight();
        super.writeLine();
        super.turnRight();
        this.move();
        super.writeDot();
        super.turnRight();
        this.move();
        this.move();
        super.turnRight();
        this.move();
        super.turnRight();
        super.writeDot();
        this.move();
        this.turnLeft();
        this.move();
    }
    /**
     * Karel writes the numer '9'
     * 
     * @precondition The robot must have at least 12 beepers in its bag.
     * 
     * @postcondition The robot will have used 12 beepers.
     */
    public void write9() 
    {
        this.move();
        this.move();
        this.move();
        this.move();
        super.turnRight();
        super.writeDot();
        super.writeDot();
        super.turnRight();
        super.writeLine();
        super.turnRight();
        this.move();
        super.writeDot();
        super.turnRight();
        super.writeDot();
        this.move();
        super.writeDot();
        super.turnAround();
        super.writeDot();
        this.turnLeft();
        this.move();
        super.turnRight();
        super.writeDot();
        this.move();
        this.turnLeft();
        this.move();
    }
    /**
     * Karel writes a colon.
     * 
     * @precondition The robot must have at least 2 beepers in its bag.
     * 
     * @postcondition The robot will have used 2 beepers.
     */
    public void writeColon() 
    {
        this.move();
        this.putBeeper();
        this.move();
        this.move();
        this.putBeeper();
        super.turnAround();
        this.move();
        this.move();
        this.move();
        this.turnLeft();
    }
    /**
     * Karel writes the time.
     * 
     * @precondition The robot must have at least 54 beepers in its bag.
     * 
     * @postcondition The robot will have used around 50 beepers.
     */
    public void writeTime() 
    {
        this.write0();
        super.positionRobot();
        this.write3();
        super.positionRobot();
        this.writeColon();
        super.positionRobot();
        this.write1();
        super.positionRobot();
        this.write8();
        super.positionRobot();
    }
}
