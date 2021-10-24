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
import java.awt.Color;

/**
 * A <code>ColorTextPiece</code> is the game piece placed in the Grid.
 * <p>
 * copyright&copy; 2007 Dave Wittry (http://apcomputerscience.com)
 * @author  Dave Wittry
 * 
 * @author  Saloni Shah 
 * 
 * @version 07.20.2021
 */
public class ColorTextPiece
{
    private String str;
    private Color col;

    /**
     * Constructs a game piece with a String.
     * 
     * @param str a String to be displayed for this piece
     */      
    public ColorTextPiece(String str) 
    { 
        this.str = str; 
        this.col = Color.WHITE;  // *** change this method for fun ***
    }

    /**
     * Returns the text for this piece.
     * 
     * @return text the string for this piece
     */     
    public String getText() 
    { 
        return str;
    }

    /**
     * Returns the color of this piece.
     * 
     * @return the color of this piece
     */        
    public Color getColor()
    {
        return col;
    }

    /**
     * Gets whether or not this piece is being used as an 
     * "empty" background cell for the gui
     * 
     * @return <code>true</code> if piece is being used as an "empty"
     *                           background cell for the gui; otherwise,
     *         <code>false</code> 
     */ 
    public boolean isBackground() 
    { 
        return (getColor().equals(Color.WHITE));
    }

    /**
     * Determines if the text for one tile is the same as the 
     * input parameter's tile's text.
     * 
     * @param obj  the Tile object whose text is being compared 
     *             to this object
     * @return <code>true</code> if texts of both tiles are the same;  otherwise,
     *         <code>false</code> 
     */
    public boolean equals(Object obj)
    {
        String other = obj.toString();
        if(str.equals(other)) {
            return true;
        }
        return false;
    }

    /**
     * Returns the text of the tile.
     * 
     * @return the text of the tile
     */
    public String toString() 
    {
        return str;
    }
}