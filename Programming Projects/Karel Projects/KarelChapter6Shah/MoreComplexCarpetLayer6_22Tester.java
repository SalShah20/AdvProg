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
public class MoreComplexCarpetLayer6_22Tester implements Directions
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
        World.readWorld(pathMac, "fig6-30.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(2);
        World.setSize(20,20);

        World.setVisible(true);

        /* Creates a robot */
        CarpetLayer5_11 karel = new MoreComplexCarpetLayer6_22(1, 1, East, 25);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        karel.carpetAllRooms();
    }
}