
import kareltherobot.*;
import java.awt.Color;

/**
 * Tests PatternCreator.
 * 
 * @author  Alexandra Michael 
 *   With assistance from the whole class
 *
 * @version 7/1/14 
 */
public class PatternCreatorTester implements Directions
{
    /**
     * Creates and positions a robot.
     *
     * @param args arguments from the command line
     */
    public static void main(String [] args)
    {    
        World.reset();
        World.readWorld("C:/worldFilesDOS/fig3-6.kwld");  // use for PC
        //World.readWorld("/worldFilesDOS/fig3-2.kwld");    // use for MAC 
        
        /* Sets up the GUI for the Karel world. */
        World.setVisible(true);
        World.setDelay(2);
        World.setSize(10,10);
        //World.showSpeedControl(true); // use setDelay method as above
        WorldBuilder myBuilder = new WorldBuilder(false); 
        
        /* Creates a robot */
        PatternCreator karel = new PatternCreator(4, 1, East, infinity);
        
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses
        
        /* Calls the method(s)to be tested. */
        karel.putDown9();
    }
}