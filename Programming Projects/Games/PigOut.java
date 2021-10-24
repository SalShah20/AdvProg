
/**
 * Plays the game PigOut
 * 
 * @author Kelsey Giusti
 * @author Alexandra Michael modified for Checkstyle
 * @version June 7, 2018
 */
public class PigOut
{
    /**
     * Constructor for objects of class PigOut
     */
    public PigOut()
    {
       
    }
    
    /**
     * Creates and plays a game of Pig Out
     * 
     * @param args input for main method
     */
    public static void main(String[] args)
    {
        PigGUI gui = new PigGUI();
        HumanPlayer p1 = new HumanPlayer(gui);
        HumanPlayer p2 = new HumanPlayer(gui);
        Dice die = new Dice(6);
        PigGame pigout = new PigGame(gui, p1, p2);
        pigout.play();
    }

}
