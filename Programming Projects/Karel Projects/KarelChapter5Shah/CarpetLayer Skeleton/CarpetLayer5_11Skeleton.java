
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
 * @author Susan King
 * @author Alexandra Michael modified for Checkstyle
 * @author  <Add your documentation here>
 *      
 * @version July 7, 2016
 * @version   <Add your documentation here>
 */
public class CarpetLayer5_11Skeleton  extends Robot 
{
    /* 
     * Replace <Add your documentation here> with correct documentation.  
     * 
     * Replace <Add your code here> with correct code. 
     * 
     * Note that the code and the documentation must match.  Any design changes must  
     * 
     * Remember that the preconditions and post conditions help the methods work together.  
     */


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
    public CarpetLayer5_11Skeleton (int avenue, int street, 
                                    Direction direction, int beepers)
    {
        super (avenue, street, direction, beepers);
    }
    
    /** 
     * Makes a 90 degree turn clockwise.
     */
    public void turnRight()
    {
        //<Add your code here>
    }
    
    /**
     * Turns the robot 180 degrees.
     */
    public void turnAround( )
    {
        //<Add your code here>
    } 
    
    /**
     * Turns the robot to face south.
     */
    public void faceSouth( )
    {
        //<Add your code here>
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
    public void enterRoom( )
    {
        //<Add your code here>
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
    public void exitRoom( )
    {
        faceSouth( );
        
        //<Add your code here>
        
        turnLeft( );
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
        //<Add your code here>
        
        return true;
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
        //<Add your code here>
        
        return true;
    }
    
    /**
     * Determines whether there is a wall to the left and right.
     * 
     * @postcondition This robot is facing the same direction as it came in.
     * 
     * @return  true if walls exist to this robot's right & left; otherwise,
     *          false.
     */
    public boolean doBothSidesExist ( )
    {
        //<Add your code here>   
        
        return false;
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
     * Teacher's notes: this method is like "frontIsClear" question in 
     *                  Racer's raceStride 
     *                           
     */       
    public boolean canRoomBeCarpeted( )
    {
        enterRoom( );
        if ( doBothSidesExist()  )  //<Add your code here>
        {
            //<Add your code here>
            
        }
        exitRoom( );
        return false;  
    }
    
    
    /**
     * Lays the carpet down for the length of the room.
     * 
     * @precondition  This robot is in the room and has enough beepers.
     * 
     * @postcondition This robot is facing the end of the room.
     * 
     * Teacher's note:  this method is like Racer's jumpUp except the 
     *                  pre and post conditions are different
     */
    public void putDownCarpet( )
    {
        //<Add your code here>
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
     * Teacher's note:  this method is like Racer's jumpHurdle
     */
    public void carpetRoom ( )
    {
        enterRoom();
        putDownCarpet();
        exitRoom(); 
    }
    
    /**
     * Moves the robot forward one intersection, carpetting a room if
     * appropriate.
     * 
     * @postcondition  This robot has moved one intersection closer
     *                 to the end of the room.
     * 
     * Teacher's notes:  this method is like Racer's raceStride
     */
    public void checkAndCarpetRoom( )
    {
        if (canRoomBeCarpeted( ))
        {
            carpetRoom( );
        }
        move( );
    }
    
    /**
     * Carpets all the rooms.
     * 
     * @precondition This robot is at first intersection and facing the 
     *               end of the hallway, and this robot has enough beepers.
     */
    public void carpetAllRooms( )
    {
        //<Add your code here>
    }
}