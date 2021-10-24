import kareltherobot.*;
import java.awt.Color;

/**
 * Karel has to carpet taller rooms and must stop carpeting rooms when it
 * reaches a wall in the bottom row.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.24.2021 
 */
public class MoreComplexCarpetLayer6_22 extends ComplexCarpetLayer5_12
{
    /**
     * Creates a MoreComplexCarpetLayer6_27 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public MoreComplexCarpetLayer6_22 (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* MoreComplexCarpetLayer6_22 methods: */
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
        while(doBothSidesExist()) 
        {
            if (!frontIsClear()) 
            {
                exitRoom();
                return true;
            } 
            else if (frontIsClear()) 
            {
                exitRoom();
                return false;
            }
        }
        exitRoom();
        return false;
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
        turnAround();
        while (frontIsClear()) 
        {
            putBeeper();
            move();
        }
        turnLeft();
    }

    /**
     * Carpets all the rooms.
     * 
     * @precondition This robot is at first intersection and facing the 
     *               end of the hallway, and this robot has enough beepers.
     */
    @Override 
    public void carpetAllRooms() 
    {
        while (frontIsClear()) 
        {
            checkAndCarpetRoom();
        }
    }
}
