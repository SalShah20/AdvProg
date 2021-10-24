import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Supports games in which a checker-like piece is dropped into
 * one of the slots at a top, and the piece dropped as low as
 * it can.  It cannot move to a location in which another piece
 * already occupies.  It is used by games like FourNeighbors and
 * FourInALine.
 * 
 * @author  Saloni Shah
 * 
 * @version 07.21.2021
 */
public class DropGame
{
    private Grid<Piece> theGrid;
    
    /**
     * Creates a grid in which to play the game.
     * 
     * @param gr    the grid in which to play this game
     */
    public DropGame(Grid<Piece> gr)
    {
        theGrid = gr;
    }

    /** 
     * Retrieves the location a Piece object can drop to
     * at the bottom of a column.
     * 
     * Precondition: 0 <= column < theGrid.getNumCols()
     * 
     * @param column the column position the user is trying to drop
     *               a Piece object
     * 
     * @return       null if no empty locations exist in the column;
     *               otherwise, the empty location with the
     *               largest row index within the specified column;
     */
    public Location dropLocationForColumn(int column)
    {
        for (int r = theGrid.getNumRows() - 1; r >= 0; r--)
        {
            Location nextLoc = new Location(r, column);
            if (theGrid.get(nextLoc) == null)
            {
                return nextLoc;
            }
        }
        return null;
    }

    /**
     * Tests if new piece has four or more surrounding
     * neighbors of the same color.
     *
     * Precondition:     0 <= column < theGrid.getNumCols()
     * 
     * @param column      the column position the user is trying to drop
     *                    a Piece object
     * @param pieceColor  the color being matched
     * 
     * @return <code>true</code> if dropping a Piece object of the given
     *                   color into the specified column matches color with 
     *                   four neighbors;
     *         <code>false</code> otherwise
     */
    public boolean countNeighbors(int column, Color pieceColor)
    {
        Location loc = dropLocationForColumn(column);
        if (loc == null)
        {
            return false;
        }

        // ArrayList<Piece> neighbors = ...;
        ArrayList<Piece> neighbors = theGrid.getNeighbors(loc);
        int colorCount = 0;
        // loop to determine if neighbors have the same color
        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).getColor().equals(pieceColor)) {
                colorCount++;
            }
        }
        return (colorCount >= 4);
    }
    
    /**
     * Checks a line to see if there are 4 in a row
     * 
     * @return true if the line has 4 in a row
     */
    public int checkLine(Color pieceColor, int dir, Location loc) {
        int consecutive = 1;
        Location nextLoc = loc.getAdjacentLocation(dir);
        while (theGrid.isValid(nextLoc) && theGrid.get(nextLoc).getColor().equals(pieceColor)) {
            consecutive++;
            nextLoc = nextLoc.getAdjacentLocation(dir);
        }
        dir += Location.HALF_CIRCLE;
        nextLoc = loc.getAdjacentLocation(dir);
        System.out.println("The color: " + pieceColor);
        while (theGrid.isValid(nextLoc) && theGrid.get(nextLoc).getColor().equals(pieceColor)) {
            consecutive++;
            nextLoc = nextLoc.getAdjacentLocation(dir);
        }
        return consecutive;
    }

    /**
     * Tests whether there are four or more of the same color
     * in a row based upon a location.
     * 
     * Precondition:     0 <= column < theGrid.getNumCols()
     * 
     * @param loc       the location based upon which to check for four
     * @param pieceColor    the color of the piece being dropped
     * 
     * @return <code>true</code> if dropping a Piece object of the 
     *                   given color into the specified column 
     *                   matches color with four in a line;
     *         <code>false</code> otherwise
     */
    public boolean checkAllDirectionsForFour(Location loc, Color pieceColor)
    {
        // ... write code to count how many Piece objects are in a row:
        // ... horizontally, vertically, or diagonal (both directions).
        //
        //You will want to write support method(s) to do this, so plan
        //this well.  This structure might help you.  It includes useful
        //debug statements.

        // Check the vertical, horizontal, and both diagonals. 
        // Pick the maximum.
        int backDiagonal = checkLine(pieceColor, Location.NORTHEAST, loc);
        int diagonal     = checkLine(pieceColor, Location.NORTHWEST, loc);
        int vertical     = checkLine(pieceColor, Location.NORTH, loc);
        int horizontal   = checkLine(pieceColor, Location.WEST, loc);
        int count        = Math.max (Math.max(backDiagonal,diagonal),
        Math.max(vertical,horizontal) );
        System.out.println("\nPiece Color "    + pieceColor   + 
        "\n\tVertical   = " + vertical     +
        "\n\tHorizontal = " + horizontal   +
        "\n\tBack Diagon= " + backDiagonal +
        "\n\tDiagonal   = " + diagonal);             
        if (count >= 4) {
            return true;
        }
        return false; // remove this when you write this method
    }
}
