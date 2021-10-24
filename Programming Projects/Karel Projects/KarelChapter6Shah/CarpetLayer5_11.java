import kareltherobot.*;

/**
 * The robot carpets small rooms if the room has walls
 * on three sides with an opening for the entrance.
 * 
 * There is a series of rooms that are both "in-line" and
 * connected by a hallway that is on Street 1.  
 * 
 * As written, the rooms run north and south, with the
 * entrance at the most southern point on Street 2.
 * 
 * This version models itself after Racer.
 * 
 * @author  Saloni Shah
 *      
 * @version   06.21.2021
 */
public class CarpetLayer5_11  extends Robot 
{
    /**
     * Creates a Carpet5_11 object at a particular location and
     * direction with a given number of beepers. 
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot
     * @param direction  specifies the direction of this robot
     * @param beepers    specifies this robot's number of beepers
     */
    public CarpetLayer5_11 (int avenue, int street, 
    Direction direction, int beepers)
    {
        super (avenue, street, direction, beepers);
    }

    /** 
     * Makes a 90 degree turn clockwise.
     */
    public void turnRight()
    {
        this.turnLeft();
        this.turnLeft();
        this.turnLeft();
    }

    /**
     * Turns the robot 180 degrees.
     */
    public void turnAround()
    {
        this.turnLeft();
        this.turnLeft();
    } 

    /**
     * Turns the robot to face south.
     */
    public void faceSouth()
    {
        if (!facingSouth()) 
        {
            if (facingWest()) 
            {
                this.turnLeft();
            } 
            else if (facingNorth()) 
            {
                this.turnAround();
            } 
            else if (facingEast()) 
            {
                this.turnRight();
            }
        }
    }

    /**
     * Enters the room.
     * 
     * @precondition   This robot's position is at the base of the room 
     *                 with the potential room to the robot's left.
     * 
     * @postcondition  This robot's position is in the room's entrance 
     *                 facing the hypothetical back wall.
     */
    public void enterRoom()
    {
        turnLeft();
        move();
        while (doBothSidesExist() && frontIsClear()) 
        {
            move();
        }
    }

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
     * Tests if there is a wall to the left of this robot.
     * 
     * @postcondition  This robot is facing the same direction as
     *                 when it entered the method.
     * 
     * @return true if there is no wall to the left; otherwise,
     *         false
     */
    public boolean leftIsClear( )
    {
        turnLeft();
        if (frontIsClear()) 
        {
            turnRight();
            return true;
        } 
        else 
        {
            turnRight();
            return false;
        }
    }

    /**
     * Tests if there is a wall to the right of this robot.
     * 
     * @postcondition  This robot is facing the same direction as
     *                 when it entered the method.
     * 
     * @return true if there is no wall to the right; otherwise,
     *         false
     */
    public boolean rightIsClear( )
    {
        turnRight();
        if (frontIsClear()) 
        {
            turnLeft();
            return true;
        } 
        else 
        {
            turnLeft();
            return false;
        }
    }

    /**
     * Determines whether there is a wall to the left and right.
     * 
     * @postcondition This robot is facing the same direction as it came in.
     * 
     * @return  true if walls exist to this robot's right & left; otherwise,
     *          false.
     */
    public boolean doBothSidesExist ()
    {   
        return (!rightIsClear() && !leftIsClear());
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
    public boolean canRoomBeCarpeted()
    {
        enterRoom();
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

    /**
     * Lays the carpet down for the length of the room.
     * 
     * @precondition  This robot is in the room and has enough beepers.
     * 
     * @postcondition This robot is facing the end of the room.
     * 
     */
    public void putDownCarpet( )
    {
        putBeeper();
    }

    /**
     * Carpets room that has an opening at the entrance.
     * 
     * @precondition  This robot is not in the room, is facing
     *                the end of the hallway, and has enough beepers.
     * 
     * @postcondition This robot has carpeted the room, 
     *                has exited the room, and is facing the 
     *                end of the hallway.
     * 
     */
    public void carpetRoom ()
    {
        putDownCarpet();
    }

    /**
     * Moves the robot forward one intersection, carpetting a room if
     * appropriate.
     * 
     * @postcondition  This robot has moved one intersection closer
     *                 to the end of the room.
     * 
     */
    public void checkAndCarpetRoom()
    {
        if (canRoomBeCarpeted()) 
        {
            enterRoom();
            carpetRoom();
            //exitRoom();
            move();
        } 
        else 
        {
            move();
        }
    }

    /**
     * Carpets all the rooms.
     * 
     * @precondition This robot is at first intersection and facing the 
     *               end of the hallway, and this robot has enough beepers.
     */
    public void carpetAllRooms()
    {
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
        checkAndCarpetRoom();
    }
}