import java.util.Scanner;
/**
 * A two player dice game
 * First player to 100 wins
 * 
 * @author Saloni Shah
 * 
 * @version 07.21.2021
 */
public class PigGame
{
    //Instance Variables
    private PigGUI gui; //user interface
    private HumanPlayer p1; //first player
    private HumanPlayer p2; //second player

    /**
     * Constructor for objects of class PigGame
     * 
     * @param gui PigOut graphical user interface
     * @param p1 player 1
     * @param p2 player 2
     */
    public PigGame(PigGUI gui, HumanPlayer p1, HumanPlayer p2)
    {
        //complete
        //Don't forget to set the names in the gui
        this.gui = gui;
        this.p1 = p1;
        this.p2 = p2;
        gui.setPlayerNames(p1.getName(), p2.getName());
    }
    
    /**
     * Starts game and updates gui until p1 or p2's score is >=100
     */
    public void play()
    {
        //Create a 6 sided Dice object
        Dice die = new Dice();
        boolean turn1 = true; 
        String winner = "";
        
        //Continue giving p1 and p2 turns until one of their scores is >= 100   
        while (p1.getScore() < 100 && p2.getScore() < 100) {
            if (turn1) {
                gui.setTurnLabel(p1.getName());
                p1.turn(die);
                gui.setScore(1, p1.getScore());
                turn1 = false;
            } else if (!turn1) {
                gui.setTurnLabel(p2.getName());
                p2.turn(die);
                gui.setScore(2, p2.getScore());
                turn1 = true;
            }
        }
        /*
         * Check which players turn it is and do the following
         * 1. Set the Turn Label to their name
         * 2. Give them their turn
         * 3. Update the score on the gui
         * 4. Change the turn variable to the next player
         */
        if (p1.getScore() >= 100) {
            winner = p1.getName();
        } else if (p2.getScore() >= 100) {
            winner = p2.getName();
        }
        
        //Update the Turn Label to announce the winner
        gui.setTurnLabel(winner + " Wins!");
    }
}
