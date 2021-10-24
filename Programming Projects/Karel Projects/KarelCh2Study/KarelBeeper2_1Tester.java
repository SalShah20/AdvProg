import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must go around the wall
 * get the beeper, and then
 * turn off
 * 
 * @author  Saloni Shah
 *
 * @version 06.15.2021 
 */
public class KarelBeeper2_1Tester implements Directions
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
        World.readWorld(pathMac, "fig2-6.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(2);
        World.setSize(10,10);

        World.setVisible(true);

        /* Creates a robot */
        KarelBeeper2_1 karel = new KarelBeeper2_1(2, 7, West, 0);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        karel.getBeeper();
    }
}