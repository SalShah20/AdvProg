import kareltherobot.*;
import java.awt.Color;

/**
 * Karel has longer rooms to place the carpets in.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.21.2021 
 */
public class ComplexCarpetLayer5_12 extends CarpetLayer5_11
{
    /**
     * Creates a ComplexCarpetLayer5_12 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public ComplexCarpetLayer5_12 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* CompexCarpetLayer5_12 methods: */
    /**
     * Exits the room.  
     * 
     * @precondition   This robot's position is somewhere in the room and 
     *                 its direction is not predescribed.
     * 
     * @postcondition  This robot's position is just outside of the 
     *                 room's entrance on 1st Street.  The room is to the
     *                 robot's left and this robot is facing the end of 
     *                 the row of rooms.
     *                  
     * Teacher's notes: this method is like glideDown except the 
     *                  precondition is very different           
     */
    @Override 
    public void exitRoom() 
    {
        faceSouth();
        move();
        if (frontIsClear()) 
        {
            move();
            if (frontIsClear()) 
            {
                move();
                if (frontIsClear()) 
                {
                    move();
                }
            }
        }
        turnLeft();
    }

    /**
     * Determines whether the room can be carpeted.
     * 
     * @precondition   This robot's position is on the 1st Street and 
     *                 facing the end of the row of rooms.
     * 
     * @postcondition  This robot's position is just outside of the 
     *                 room's entrance on 1st Street.  The room is to this
     *                 robot's left and this robot is facing the end of the 
     *                 row of rooms.
     *                 
     * @return  true if the room can be carpeted; otherwise, false                    
     *                           
     */
    @Override
    public boolean canRoomBeCarpeted() 
    {
        enterRoom();
        if (doBothSidesExist() && !frontIsClear()) 
        {
            exitRoom();
            return true;
        } 
        else if (doBothSidesExist() && frontIsClear()) 
        {
            move();
            if (doBothSidesExist() && !frontIsClear()) 
            {
                exitRoom();
                return true;
            } 
            else if (doBothSidesExist() && frontIsClear()) 
            {
                move();
                if (doBothSidesExist() && !frontIsClear()) 
                {
                    exitRoom();
                    return true;
                } 
                else 
                {
                    exitRoom();
                    return false;
                }
            } 
            else 
            {
                exitRoom();
                return false;
            }
        } 
        else 
        {
            exitRoom();
            return false;
        }
    }

    /**
     * Lays the carpet down for the length of the room.
     * 
     * @precondition  This robot is in the room and has enough beepers.
     * 
     * @postcondition This robot is facing the end of the room.
     * 
     */
    @Override
    public void putDownCarpet() 
    {
        putBeeper();
        turnAround();
        move();
        if (doBothSidesExist()) 
        {
            putBeeper();
            move();
            if (doBothSidesExist()) 
            {
                putBeeper();
                move();
            }
        }
        turnAround();
        move();
        if (frontIsClear()) 
        {
            move();
            if (frontIsClear()) 
            {
                move();
                if (frontIsClear()) 
                {
                    move();
                }
            }
        }
    }
}
