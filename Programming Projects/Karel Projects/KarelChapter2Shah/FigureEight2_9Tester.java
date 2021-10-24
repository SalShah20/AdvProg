import kareltherobot.*;
import java.awt.Color;

/**
 * Karel must do a figure eight 
 * around the 2 beepers and return 
 * to the same position.
 * 
 * @author  Saloni 
 * with assistance from John Page.
 *
 * @version 06.14.2021 
 */
public class FigureEight2_9Tester implements Directions
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
        World.readWorld(pathMac, "fig2-12.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(1);
        World.setSize(10,10);

        World.setVisible(true);

        /* Creates a robot */
        FigureEight2_9 karel = new FigureEight2_9(3, 5, North, 0);

        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField();
        karel.figureEight();
    }
}