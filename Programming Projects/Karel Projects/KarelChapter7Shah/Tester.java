import kareltherobot.*;
import java.awt.Color;

/**
 * The robot does many actions with beepers and recursion.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.28.2021 
 */
public class Tester implements Directions
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
        String pathPC = "C:/ProgramData/HarkerCS/worldFilesDOS/"; //Path for worlds on PC 
        String pathMac = "/Users/Shared/HarkerCS/worldFilesDOS/"; //Path for worlds on Mac  
        
        /* Read a world from a file in the given directory path. */
        // Edit to open the desired world
        World.readWorld(pathMac, "fig3-6.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(2);
        World.setSize(10,20);

        World.setVisible(true);

        /* Creates a robot */
        Karel7_4 karel = new Karel7_4(2, 2, East, 0);
        //Karel7_5 fred = new Karel7_5(1, 1, East, 2);
        //Karel7_6 george = new Karel7_6(1, 1, East, 0);
        Karel7_7 bob = new Karel7_7(1,1, East, infinity);
        

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        //karel.getBeeper();
        //fred.getBeeper();
        //george.getBeeper();
        bob.getBeeper();
    }
}