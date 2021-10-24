
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
public class PatternCreatorTestAll implements Directions
{
    /**
     * Creates and positions a robot.
     *
     * @param args arguments from the command line
     */
    public static void main(String [] args)
    {    
        setWorld();

        PatternCreator karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 1");//pauses
        karel.putDown1();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 2");//pauses
        karel.putDown2();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 3");//pauses
        karel.putDown3();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 4");//pauses
        karel.putDown4();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 5");//pauses
        karel.putDown5();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 6");//pauses
        karel.putDown6();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 7");//pauses
        karel.putDown7();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 8");//pauses
        karel.putDown8();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 9");//pauses
        karel.putDown9();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 10");//pauses
        karel.putDown10();
        karel.userPause("Press [enter/return] to start another pattern");//pauses
        
        setWorld();
        karel = new PatternCreator(4, 1, East, infinity);
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to see Pattern 11");//pauses
        karel.putDown11();
    }
    
    /**
     * Set upt the world for a test.
     */
    public static void setWorld()
    {
        World.reset();
        //World.readWorld("C:/worldFilesDOS/fig3-6.kwld");  // use for PC
        World.readWorld("/worldFilesDOS/fig3-6.kwld");    // use for MAC 
        
        /* Sets up the GUI for the Karel world. */
        World.setVisible(true);
        World.setDelay(2);
        World.setSize(10,10);
    }

}