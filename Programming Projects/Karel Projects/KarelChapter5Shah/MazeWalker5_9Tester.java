import kareltherobot.*;
import java.awt.Color;

/**
 * The robots must follow the wall to their rights.
 * 
 * @author  Saloni Shah 
 * with assistance from John Page
 *
 * @version 06.21.2021  
 */
public class MazeWalker5_9Tester implements Directions
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
        World.readWorld(pathMac, "fig5-6.kwld");    // Use for Mac
        //World.readWorld(pathPC, "fig3-2.kwld");   // Use for PC 
        World.setDelay(2);
        World.setSize(10,10);

        World.setVisible(true);

        /* Creates a robot */
        MazeWalker5_9 batman = new MazeWalker5_9(7,3,North,0,Color.BLUE);
        MazeWalker5_9 superman = new MazeWalker5_9(7,7,North,0,Color.GREEN);
        MazeWalker5_9 pikachu = new MazeWalker5_9(2,3,North,0,Color.CYAN);
        MazeWalker5_9 spiderman= new MazeWalker5_9(2,7,North,0,Color.MAGENTA);

        batman.setUserPause(true); //enables use of userPause
        batman.userPause("start. Press [enter/return] to start");//pauses

        /* Calls the method(s)to be tested. */
        // for example:  karel.harvestField(); 
        batman.followWallRight();
        superman.followWallRight();
        pikachu.followWallRight();
        spiderman.followWallRight();
    }
}