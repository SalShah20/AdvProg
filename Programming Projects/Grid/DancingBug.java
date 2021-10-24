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
 * A <code>DancingBug</code> traces out a dance of a given size. <br />
 * 
 * @author Saloni Shah
 * @version 07.14.2021
 */
public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    private int[] array;
    /**
     * Constructs a dancing bug that turns the number of times instructed by the array, 
     * then acts like a bug.
     * 
     * @param length the side length
     * 
     * @param turns the array of turn values
     */
    public DancingBug(int length, int[] turns)
    {
        sideLength = length;
        array = turns;
    }

    /**
     * Moves along the length defined in the constructor, 
     * then turns the number of times defined in the array.
     */
    public void act()
    {
        for (int i = 0; i < array.length; i++) 
        {
            for (int j = 0; j < sideLength; j++) 
            { 
                move();
            }
            int turns = array[i];
            for (int x = 0; x < turns; x++) 
            {
                turn();
            }
        }
    }
}
