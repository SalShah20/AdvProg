import kareltherobot.*;
/**
 * Karel goes on a big adventure to find a mine.
 * 
 * @author  Team 4 (Saloni Shah, Maggie Yan,  Ariana Gauba, Max Zhai,
 * Hima Thota)
 *
 * @version 06.29.2021 
 */
public class Adventure1SallyTiffanyTester implements Directions
{
    /**
     * Main Method
     * 
     * @param args arguments from the command line
     */
    public static void main(String[] args)
    {
        World.reset();
        World.readWorld("MapTest1SallyAndTiffany.kwld"); 
        WorldBuilder builder = new WorldBuilder(true);
        World.setDelay(2);
        World.setSize(30,30);
        World.setVisible(true);
        World.showSpeedControl(true);
        
        // Creates a robot.
        Adventurer karel = new Adventurer(1, 1, East, 0);
        // Pauses the robot.
        karel.setUserPause(true);
        karel.userPause("hit any key ...");
        long startTime = 0;
        long endTime;
        double elapsedTime;
        try
        {
            startTime = System.nanoTime();
            karel.findMine();
            endTime = System.nanoTime();
        }
        catch (Exception e)
        {
            endTime = System.nanoTime();
        }
        elapsedTime = (endTime - startTime)/ 1.0E9;
        System.out.println(elapsedTime + "elapsed time in seconds");     
    }
}