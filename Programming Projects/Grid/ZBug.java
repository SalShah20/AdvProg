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

/**
 * A <code>ZBug</code> traces out a Z of a given size. <br />
 * 
 * @author Saloni Shah
 * @version 07.14.2021
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int count;
    
    /**
     * Constructs a Z bug that traces a Z of a given side length.
     * 
     * @param length the side length
     */
    public ZBug(int length)
    {
        steps = 0;
        count = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the Z.
     */
    public void act()
    {
        while (count < (sideLength*3)) 
        {
            if (steps < sideLength && canMove())
            {
                move();
                steps++;
                count++;
            }   
            else if (getDirection() == 225) 
            {
                turn();
                turn();
                turn();
                turn();
                turn();
                steps = 0;
            }
            else
            {
                turn();
                turn();
                turn();
                steps = 0;
            }
        }
    }
}
