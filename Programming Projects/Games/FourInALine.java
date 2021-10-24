import java.awt.Color;

import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

/**
 * FourInALine is like the game Connect 4 in which 2 players
 * are trying to be the first to have 4 Piece objects of the same 
 * color in a consecutive horizontal, vertical or diagonal pattern.
 * 
 * 
 * @author  Saloni Shah
 * 
 * @version 07.21.2021
 */
public class FourInALine extends World<Piece>
{
    // ... fill in your instance variables 
    private DropGame game;
    private Color currentColor;
    private boolean gameOver;
    /**
     * Document me!
     * 
     * @param rows  Document me!
     * @param cols  Document me!
     */
    public FourInALine(int rows, int cols)
    {
        // ... document and fill in this constructor
        super(new BoundedGrid<Piece>(rows, cols));
        game = new DropGame(getGrid());
        currentColor = Color.RED;
        flipTurn();
    }

    /**
     * Document me!
     */
    public void flipTurn()
    {
        // ... document and fill in this method 
        if (currentColor.equals(Color.RED))
        {
            // currentColor = ...;
            currentColor = Color.YELLOW;
            setMessage("Yellow's turn");
        }
        else
        {
            // fill in
            currentColor = Color.RED;
            setMessage("Red's turn");
        }   
    }

    /**
     * Document me!
     * 
     * @param loc   Document me!
     * @return      Document me!
     */
    @Override
    public boolean locationClicked(Location loc)
    {
        // ... fill in this 
        if (gameOver) {
            return false;
        }
        Location dropLoc = game.dropLocationForColumn(loc.getCol());
        if (dropLoc == null) {
            setMessage("Illegal drop location, try again");
        } else {
            getGrid().put(dropLoc, new Piece(currentColor));
            if (game.checkAllDirectionsForFour(loc, currentColor))
            {
                setMessage("Congratulations " + currentColor.toString() + " you won");
                gameOver = true;
            }
        }
        if (!gameOver) {
            flipTurn();
        }
        return true;

        // ... NOTE:  You need to move this line:
        // getGrid().put(dropLoc, new Piece(currentColor));  
        // ... before these lines
        //   if (game.checkAllDirectionsForFour(loc , currentColor))
        //   {
        //      setMessage("Congratulations--you won");
        //      gameOver = true;
        //  }   

    }     

    /**
     * Document me!
     * 
     * @param args  Document me!
     */
    public static void main(String[] args)
    {
        FourInALine world = new FourInALine(4, 6);
        world.show();
    }
}
