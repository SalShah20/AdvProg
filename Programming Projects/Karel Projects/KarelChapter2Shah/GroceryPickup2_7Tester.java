import kareltherobot.*;
import java.awt.Color;

/**
 * Karel dropped some groceries(beepers) 
 * and has to go back and get them 
 * and return to where he started.
 * 
 * @author  Saloni Shah
 * with assistance from John Page
 *
 * @version 06.14.2021 
 */
public class GroceryPickup2_7Tester implements Directions
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
        World.readWorld(pathMac, "fig2-10.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(1);
        World.setSize(10,10);

        World.setVisible(true);

        /* Creates a robot */
        GroceryPickup2_7 karel = new GroceryPickup2_7(5, 7, East, 0);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        karel.pickGroceries();
    }
}