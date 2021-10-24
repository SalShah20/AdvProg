import java.awt.Color;

/**
 * Indicates an individual piece of a game, like a checker piece.
 * 
 * @author  Saloni Shah
 * 
 * @version 07.21.2021
 */
public class Piece
{
    private Color color;

    /**
     * Creates a game piece of a specific color.
     * 
     * @param color color of this piece
     */
    public Piece(Color color)
    {
        this.color = color;
    }

    /**
     * Retrieves the color of this piece.
     * 
     * @return color of this piece
     * */
    public Color getColor()
    {
        return color;
    }
}
