import java.util.Scanner;
/**
 * A player in the game PigOut
 * Knows their name and score as well as the GUI
 * Can take a turn
 * 
 * @author Saloni Shah
 * 
 * @version 07.21.2021
 */
public class HumanPlayer
{
    //Instance Variables
    private String name; //name of player
    private PigGUI gui; //graphical user interface
    private int score; //player's score

    /**
     * Constructor for objects of class HumanPlayer
     * 
     * @param name player's name
     * @param gui game's user interface
     */
    public HumanPlayer(String name, PigGUI gui)
    {
        //complete
        this.name = name;
        this.gui = gui;
    }

    public HumanPlayer(PigGUI gui) {
        String n = askForName();
        this.name = n;
        this.gui = gui;
    }
    
    public String askForName() {
        System.out.println("Enter player name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine( );
        return name;
    }
    
    /**
     * Returns the name of the player
     * 
     * @return the player's name
     */
    public String getName()
    {
        //complete
        return name;
    }

    /**
     * Returns the player's score
     * 
     * @return the player's score
     */
    public int getScore()
    {
        //complete
        return score;
    }

    /**
     * Player takes a turn at PigOut
     * 
     * @param die Dice the player will roll
     */
    public void turn(Dice die)
    {
        //Enable the buttons
        gui.enableButtons(true);
        //Create variable to store turn score
        int turnScore = 0;

        //Create a forever loop
        boolean loop = true;
        while(loop)
        {
            //Wait for player to press Roll or Hold
            String press = gui.waitForButtonPress();
            /*
             * if they press hold
             * break the loop to end the turn
             */
            if (press.equalsIgnoreCase("hold")) {
                loop = false;
            } else if (press.equalsIgnoreCase("roll")) {
                int val = die.roll();
                gui.setDieImage(val);
                if (val == 1) {
                    turnScore = 0;
                    gui.setScore(0, turnScore);
                    loop = false;
                } else if (score + turnScore >= 100){
                    turnScore += val;
                    gui.setScore(0, turnScore);
                    loop = false;
                } else {
                    turnScore += val;
                    gui.setScore(0, turnScore);
                }
            }
            /*
             * if they press roll
             * 1. roll the die
             * 2. update the roll image
             * 3. if they rolled a 1 set their turn score to 0 and end their turn
             * 4. if they rolled 2-6 check if they have won
             * 5. if they won update their turn score and end their turn
             * 6. if they haven't won update their turn and score
             */
        }

        //Add turn score to total score
        score += turnScore;
        //Disable the buttons
        gui.enableButtons(false);
    }
}
