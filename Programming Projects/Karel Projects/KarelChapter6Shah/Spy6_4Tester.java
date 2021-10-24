import kareltherobot.*;
import java.awt.Color;

/**
 *  The robot has to pick the room with less than infinity beepers based
 * on whether the pile its standing on has an odd or even number of beepers. 
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.22.2021 
 */
public class Spy6_4Tester implements Directions
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
        World.readWorld(pathMac, "fig6-17.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(2);
        World.setSize(10,10);

        World.setVisible(true);

        /* Creates a robot */
        Spy6_4 karel = new Spy6_4(5, 5, North, 0);
        //Spy6_4 fred = new Spy6_4(7, 5, North, 0);
        //Spy6_4 george = new Spy6_4(3, 5, North, 0);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        karel.pickRoom();
        //fred.pickRoom();
        //george.pickRoom();
    }
}