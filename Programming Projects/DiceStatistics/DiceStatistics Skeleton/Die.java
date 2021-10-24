
/**
 * A Die object may have its numbers of sides specified
 * and may be rolled to simulate rolling a real die. 
 * 
 * @author  Saloni Shah
 * 
 * @version 07.09.2021
 */
public class Die
{
    /**
     * number of sides for this die
     */
    private int sides;

    /**
     * Creates a Die object with six sides.
     */
    public Die()
    {
        this(6);    
    }
    
    /**
     * Creates a Die object with the number of sides
     * specified as a parameter.
     * 
     * @param s     number of sides of this die
     */
    public Die(int s)
    {
        setSides(s);
    }
    
    /**
     * Retrieve the number of sides.
     *
     * @return      number of sides of this die
     */
    public int getSides()
    {
        if (sides < 2) 
        {
            sides = 6;
        }
        return sides;
    }
    
    /**
     * Sets the number of sides of this die.
     * 
     * @param s     the new number of sides for this die
     */
    public void setSides(int s)
    {
        this.sides = s;
    }
    
    /**
     * Simulates the rolling of a die.
     * 
     * @return number between 1 and sides, inclusively
     */
    public int roll()
    {
        int random = (int)(Math.random() * (sides - 1 + 1) + 1);
        return random;
    }
}
