import kareltherobot.*;
import java.awt.Color;

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
public class CarpetLayer5_11Tester implements Directions
{
    /**
     * Creates and positions a robot.
     *
     * @param args arguments from the command line
     */
    public static void main(String [] args)
    {    
        /* Sets up the GUI for the Karel world. */
        
        WorldBuilder myBuilder = new WorldBuilder(false); 
        World.reset();
        //World.showSpeedControl(true); // use setDelay method
        //String pathPC = "C:/ProgramData/HarkerCS/worldFilesDOS/"; //Path for worlds on PC 
        String pathMac = "/Users/Shared/HarkerCS/worldFilesDOS/"; //Path for worlds on Mac  
        
        /* Read a world from a file in the given directory path. */
        // Edit to open the desired world
        World.readWorld(pathMac, "fig5-8.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(2);
        World.setSize(10,10);

        World.setVisible(true);

        /* Creates a robot */
        CarpetLayer5_11 karel = new CarpetLayer5_11(1, 1, East, 8);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        karel.carpetAllRooms();
    }
}