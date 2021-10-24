import kareltherobot.*;
import java.awt.Color;

/**
 * Karel goes on a big adventure to find a mine.
 * 
 * @author  Team 4 (Saloni Shah, Maggie Yan,  Ariana Gauba, Max Zhai,
 * Hima Thota)
 *
 * @version 06.29.2021 
 */
public class Adventurer extends Robot
{
    /**
     * Creates a Adventurer object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Adventurer (int street, int avenue, 
    Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }

    /* Adventurer methods: */
    /**
    * Walks one block North, then one block East
    *
    * @precondition The robot is turned on and at its starting position
    * 
    * @postcondition The robot has advanced one block North and one block East
    */

    public void starterStep()
    {
        faceNorth();
        move();
        faceEast();
        move();
    }

    /**
    * Walks to a wall
    *
    * @precondition There is not a wall in front of the robot
    * 
    * @postcondition The robot has walked to a wall
    */

    public void walkToWall()
    {
        while (frontIsClear())
        {
            move();
        }
    }

    /**
     * Determines if ther is a beeper on the intersection in front of the
     * robot.
     * 
     * @return True if ther is a beeper in front; otherwise false.
     */
    public boolean beeperInFront()
    {
        if (frontIsClear())
        {
            move();
            if (nextToABeeper())
            {
                turnAround();
                move();
                turnAround();
                return true;
            }
            else
            {
                turnAround();
                move();
                turnAround();
                return false;
            }
        }
        return false;
    }
    
    /**
     * The robot detects whether it is home or not.
     * 
     * @precondition  The robot must be on the same corner
     * as one or more beepers.
     * 
     * @postcondition  If the robot detects that it is home,
     * it has picked up the two "home" beepers. Otherwise, it has
     * put back the beeper it picked up.
     * 
     * @return true if the robot is on a pile with 2 beepers;
     * otherwise false.
     */
    public boolean atHome()
    {
        if (nextToABeeper())
        {
            pickBeeper();
            if (nextToABeeper())
            {
                pickBeeper();
                return true;
            }
            else
            {
                putBeeper();
            }
        }
        return false;
    }

    /**
     * Karel follows the beeper path all the way back home.
     * 
     * @precondition Karel must be one block before the beeper path.
     * 
     * @postcondition Karel will stop at home.
     */
    public void followPath()
    {
        move();
        if (!atHome())
        {
            while (nextToABeeper() && frontIsClear())
            {
                pickBeeper();
                move();
            }
            if (!nextToABeeper())
            {
                turnAround();
                move();
                turnAround();
            }
            findClearSide();
            while (!atHome() && !beeperInFront())
            {
                turnLeft();
            }
            followPath();
        }
    }

    /**
     * Determines whether karel has foun the treasure (pile of 5 beepers).
     * 
     * @return true if karel found the treasure; otherwise false.
     */
    public boolean foundTreasure()
    {
        if (nextToABeeper())
        {
            pickBeeper();
            if (nextToABeeper())
            {
                pickBeeper();
                if (nextToABeeper())
                {
                    pickBeeper();
                    if (nextToABeeper())
                    {
                        pickBeeper();
                        if (nextToABeeper())
                        {
                            return true;
                        }
                        putBeeper();
                    }
                    putBeeper();
                }
                putBeeper();
            }
            putBeeper();
        }
        return false;
    }

    /**
     * The robot counts the beeper pile and determines where to turn 
     * according to the pile.
     * 
     * @postcondition  The robot is facing in the direction of the 
     * next beeper pile.
     */
    public void countAndTurn() 
    {
        if (nextToABeeper()) 
        {
            pickBeeper();
            if (nextToABeeper()) 
            {
                pickBeeper();
                if (nextToABeeper()) 
                {
                    pickBeeper();
                    if (nextToABeeper()) 
                    {
                        pickBeeper();
                        if (nextToABeeper()) 
                        {
                            for (int i = 0; i < 4; i++) 
                            {
                                putBeeper();
                            }
                        } 
                        else 
                        {
                            faceEast();
                        }
                    } 
                    else 
                    {
                        faceSouth();
                    }
                } 
                else 
                {
                    faceWest();
                }
            } 
            else 
            { 
                faceNorth();
            }
        }
    }

    /**
     * The robot follows the beepers to the pile of 5 beepers, stopping
     * when it arrives at the treasure.
     * 
     * @precondition The beeper piles are laid out so that the robot 
     * may follow them.
     * 
     * @postcondition The robot had picked up all the beepers and is 
     * standing on the corner of the treasure pile.
     */
    public void findTreasure()
    {
        while (!foundTreasure())
        {
            while (!nextToABeeper())
            {
                move();
            }
            countAndTurn();
        }
    }

    /** 
    * The robot turns to face South if it is facing North, North if it 
    * is facing West, and East otherwise.
    */
    public void endOfTrail()
    {
        if(facingNorth())
        {
            faceSouth();
        } 
        else if (facingWest())
        {
            faceNorth();
        }
        else if (facingSouth() || facingEast())
        {
            faceEast();
        }
    }

    /**
    * The robot moves ten steps forward
    *
    * @postcondition robot has advanced 10 squares
    */
    public void walkTenBlocks ()
    {
        for (int i=0; i<10; i++)
        {   
            move();
        }
    }

    /**
    * The robot turns left until the front is clear.
    *
    * @precondition The robot is at any position, 
    * facing any direction, with at least one side having a clear front.
    * 
    * @postcondition The robot is at the same position, facing a clear 
    * front.
    */
    public void findClearSide()
    {
        while(!frontIsClear())
        {
            turnLeft();
        }   
    }

    /**
     * The robot determines whether it should move to the 
     * next wall or move ten blocks.
     */
    public void chooseOne() 
    {
        if (leftIsClear()) 
        {
            walkToWall();
        } 
        else 
        {
            walkTenBlocks();
        }
    }

    /**
    * The robot moves North a distance that is half the distance 
    * it just walked from the wall to the beeper, and then it moves 
    * East a distance that is equal to the distance just walked from 
    * the wall to the beeper.
    *
    * @precondition The robot is at the wall.
    * 
    * @postcondition The robot is at the beeper mine.
    */

    public void moveHalfDistanceNorth()
    {
        move();
        move();
        if(!nextToABeeper())
        {
            moveHalfDistanceNorth();
            move();
            faceEast();
            move();
            move();
            faceNorth();
        }  
        else
        {
            pickBeeper();
            moveNorth();
            moveEast();
            faceNorth();
        }    
    }  

    /**
    * The robot moves one space North
    *
    * @precondition The robot is at any position, facing any direction, 
    * and North is clear.
    * 
    * @postcondition The robot has advanced one space North.
    */
    public void moveNorth()
    {
        faceNorth();
        move();
    }

    /**
    * The robot moves two blocks to the East
    * 
    * @postcondition The robot is facing East and has moved 2 spaces.
    */
    public void moveEast() 
    {
        faceEast();
        move();
        move();
    }

    /**
    *  The robot picks up all beepers at the mine
    *
    * @precondition The robot is next to a finite pile of beepers.
    * 
    * @postcondition The robot has picked up said pile of beepers.
    */
    public void pickMine() 
    {
        while (nextToABeeper()) 
        {
            pickBeeper();
        }
    }

    /**
    * The Robot finds the mine and picks up all the beepers.
    *
    * @precondition The robot is at the origin, facing an unknown 
    * direction.
    *
    * @postcondition The robot is on top of the mine and picks the beepers 
    * on it. 
    */
    public void findMine() 
    {
        starterStep();
        faceNorth();
        followPath();
        walkToWall();
        faceEast();
        walkToWall();
        findTreasure();
        endOfTrail();
        walkTenBlocks();
        findClearSide();
        chooseOne();
        turnRight();
        walkToWall();
        faceEast();
        moveHalfDistanceNorth();
        pickMine();
        System.out.println("Team 4");
    }

    /**
     * The robot turns 180 degrees.
     */
    public void turnAround() 
    {
        turnLeft();
        turnLeft();
    }

    /**
     * The robot turns right.
     */
    public void turnRight() 
    {
        for (int i = 0; i < 3; i ++) 
        {
            turnLeft();
        }
    }

    /**
     * The robot turns to face East.
     */
    public void faceEast() 
    {
        if (!facingEast()) 
        {
            turnLeft();
            faceEast();
        }
    }

    /**
     * The robot turns to face North.
     */
    public void faceNorth() 
    {
        if (!facingNorth()) 
        {
            turnLeft();
            faceNorth();
        }
    }

    /**
     * The robot turns to face South.
     */
    public void faceSouth() 
    {
        if (!facingSouth()) 
        {
            turnLeft();
            faceSouth();
        }
    }
    
    /**
     * The robot turns to face West.
     */
    public void faceWest() 
    {
        if (!facingWest()) 
        {
            turnLeft();
            faceWest();
        }
    }

    /**
     * Tests if there is a wall to the left of this robot.
     * 
     * @postcondition  This robot is facing the same 
     *                 direction as when it entered 
     *                 the method.
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
}

