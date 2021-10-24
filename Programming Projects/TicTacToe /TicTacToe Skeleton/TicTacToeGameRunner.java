/*
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
import info.gridworld.world.World;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * The <code>TicTacToeGameRunner</code> starts and oversees
 * the TicTacToe game. 
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 * <p> 
 * copyright&copy; 2007 Dave Wittry (http://apcomputerscience.com)
 * 
 * @author  Dave Wittry
 * @author  Saloni Shah
 * 
 * @version 07.20.2021
 */
public class TicTacToeGameRunner extends World<ColorTextPiece>
{
    private boolean isXTurn;
    private boolean winner;
    /**
     * Constructs a TicTacToe Game.
     */
    public TicTacToeGameRunner() 
    {
        isXTurn = true;
        winner = false;
        makeBoard();
        setMessage("Tic Tac Toe - X Goes First");
    }

    /**
     * Initializes the board to white, empty tiles.
     */
    private void makeBoard() 
    {
        setGrid(new BoundedGrid<ColorTextPiece>(3, 3)); // gameboard size
        Grid gr = getGrid();
        /*
         * Students, write nested for loops to set the text for all the tiles to an
         * empty string and add them to the World/Grid.
         */
        for (int j = 0; j < gr.getNumRows(); j++) {
            for (int x = 0; x < gr.getNumCols(); x++) {
                ColorTextPiece fred = new ColorTextPiece("");
                Location loca = new Location(j, x);
                gr.put(loca, fred);
            }
        }
    }
    
    /**
     * Checks a line to see if there are 3 in a row
     * 
     * @return true if the line has 3 in a row
     */
    public boolean checkLine(Grid<ColorTextPiece> gr, int dir, Location loc) {
        int consecutive = 0;
        Location nextLoc = loc.getAdjacentLocation(dir);
        while (gr.isValid(nextLoc) && gr.get(nextLoc).getText().equals(gr.get(loc).getText())) {
            consecutive++;
            nextLoc = nextLoc.getAdjacentLocation(dir);
        }
        dir += Location.HALF_CIRCLE;
        nextLoc = loc.getAdjacentLocation(dir);
        while (gr.isValid(nextLoc) && gr.get(nextLoc).getText().equals(gr.get(loc).getText())) {
            consecutive++;
            nextLoc = nextLoc.getAdjacentLocation(dir);
        }
        return consecutive == 2;
    }

    /**
     * Determines the winner. Currently written in O(1), independent of N, 
     * the number of pieces currently played.
     * 
     * @param loc    location of the last piece just played
     * @return true  if the piece just played at position <code>loc</code> completes
     *               a win for the player who just moved; otherwise,
     *         false 
     */
    private boolean determineWinner(Location loc) 
    {
        // only need to check if 3 in a row from the current loc (last move made)
        int dir = Location.AHEAD; 
        int consecutive = 0;
        Location nextLoc = loc;
        Grid<ColorTextPiece> gr = getGrid();

        /*
         * Students: There are 3 main axes from the current loc to check for 
         * 3-in-a-row.
         * 
         * To help you write this code, you should first look at the constants 
         * within the Location class to see what is available to you. You will 
         * find Location.HALF_CIRCLE and Location.HALF_RIGHT of possible use. 
         * 
         * Essentially, for each of the 4 exes (the vertical, the horizontal, 
         * the major diagonal and the minor diagonal), you need to keep count 
         * of the number of consecutive pieces that match the piece played at 
         * location loc.  You can, for example, go up from the current loc 
         * until you either run off the board or you get to a piece that
         * doesn't match the one played, keeping count of the consecutive ones 
         * while you go upward.  Then switch direction and go downward adding 
         * on to your consecutive count. That will take care of the vertical axis. 
         * You can check at that point whether your count is >= 3 and, if so, 
         * return true. Otherwise, check the other 3 axes in a similar manner.
         */
        
        for (int i = 0; i < 4; i++) {
            if (checkLine(gr, dir, loc)) {
                return true;
            }
            dir += Location.HALF_RIGHT;
        }
        return false;
    }

    /**
     * Determines whether it is a legal move and, if so, places a piece 
     * and calls determineWinner.  This method is called when the 
     * current player clicks and attempts to place a piece.
     * 
     * @param  loc location passed from the GUI where the use just clicked
     * @return true 
     */
    public boolean locationClicked(Location loc)
    {
        if (winner) {
            return true; 
        }
        if (getGrid().get(loc).isBackground()) // player making a legal move
        {
            if (isXTurn) 
            {
                add(loc, new ColorTextPiece("X"));
                setMessage("O's Turn - X moved to " + loc);
            }
            else
            {
                add(loc, new ColorTextPiece("O"));
                setMessage("X's Turn - O moved to " + loc);
            }
            if (determineWinner(loc)) 
            {
                winner = true;
                if (isXTurn) {
                    setMessage("X WINS");
                }
                else {
                    setMessage("O WINS");
                }
            }
            isXTurn = !isXTurn;
        }
        else // player making an illegal move
        {
            if ( isXTurn ) {
                setMessage("Occupied Cell - X, it's still your turn");
            }
            else {
                setMessage("Occupied Cell - O, it's still your turn");
            }
        }
        return true;      
    }

    /**
     * Sets up the game and starts it.
     * 
     * @param args  information from the command line
     */
    public static void main(String[] args)
    {
        World ttt = new TicTacToeGameRunner();
        /*
         * Gets rid of focus indicator on the gui.
         */
        System.setProperty("info.gridworld.gui.selection", "hide"); 
        ttt.show();
    }
}