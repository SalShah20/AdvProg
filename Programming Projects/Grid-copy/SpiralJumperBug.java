/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;
import info.gridworld.actor.*;
import java.util.ArrayList;
import info.gridworld.grid.*;
/**
 * A <code>SpiralJumperBug</code> traces out a spiral of a 
 * given size but skipes over rocks. <br />
 * 
 * @author Saloni Shah
 * @version 07.19.2021
 */
public class SpiralJumperBug extends Bug
{
    private int steps;
    private int sideLength;

    /**
     * Constructs a spiral bug that traces a spiral starting 
     * at a given side length and jumps over rocks.
     * 
     * @param length the side length
     */
    public SpiralJumperBug(int length)
    {
        steps = 0;
        sideLength = 1;
    }
    
    /**
     * Checks if there is a rock in front of the bug
     * 
     * @return true if there is a rock in front of the bug
     */
    public boolean ifRocks() 
    {
        Grid<Actor> gr = getGrid();
        int facing = getDirection();
        Location loca = getLocation();
        ArrayList<Location> occupados = gr.getOccupiedAdjacentLocations(loca);
        for (Location loc : occupados) 
        {
            Location next = loca.getAdjacentLocation(facing);
            if (gr.get(loc) instanceof Rock && loc.equals(next)) 
            {
                return true;
            } 
        }
        return false;
    }

    /**
     * Moves to the next location of the spiral.
     */
    public void act()
    {
        int facing = getDirection();
        Location loca = getLocation();
        Location next = loca.getAdjacentLocation(facing);
        Location jump = next.getAdjacentLocation(facing);
        if (steps < sideLength && !ifRocks())
        {
            move();
            steps++;
        } 
        else if (steps == sideLength - 1 && ifRocks()) 
        {
            turn();
            move();
            steps = 1;
            sideLength++;
            turn();
        }
        else if (steps < sideLength && ifRocks())
        {
            moveTo(jump);
            steps += 2;
        } 
        else 
        {
            turn();
            turn();
            steps = 0;
            sideLength++;
        }
    }
}
