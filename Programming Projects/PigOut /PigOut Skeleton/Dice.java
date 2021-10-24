
/**
 * A Dice object represents a real world dice
 * it can be rolled and knows how many sides it has
 * 
 * @author Saloni Shah
 * 
 * @version 07.21.2021
 */
public class Dice
{
    //instance variables
    private int sides; //number of sides

    /**
     * Constructor for objects of class Dice
     * Dice objects have a default of 6 sides
     */
    public Dice()
    {
        this(6);
    }
    
    /**
     * Constructor for objects of class Dice
     * 
     * @param sides number of sides
     */
    public Dice(int sides)
    {
        this.sides = sides;
    }

    /**
     * Accessor for sides
     * @return number of sides
     */
    public int getSides()
    {
        //complete
        if (sides < 2) {
            sides = 6;
        }
        return sides;
    }
    
    /**
     * Simulates rolling the die
     * 
     * @return a random roll between 1 and sides
     */
    public int roll()
    {
        //complete
        int random = (int)(Math.random() * (sides - 1 + 1) + 1);
        return random;
    }
}
