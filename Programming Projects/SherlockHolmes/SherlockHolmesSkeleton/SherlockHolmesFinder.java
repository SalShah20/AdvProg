/**
 * Find a Sherlock Holmes from a list of clues.
 * 
 * @author Saloni Shah
 *    
 * @version 07.08.2021
 */
public class SherlockHolmesFinder
{
    /**
     * Constructor for objects of class SherlockHolmes
     */
    public SherlockHolmesFinder()
    {
    }

    /**
     * Extracts the third and fourth characters in the string parameter.
     * 
     * @param str   a non-null word that is a clue
     * @return      the third and fourth characters in string parameter
     */
    public String getOddClue(String str)
    {
        String odd = "";
        odd = odd + str.substring(2, 3) + str.substring(3, 4);
        return odd;
    }
    
    /**
     * Extracts the fifth character in the string parameter.
     * 
     * @param st    a non-null word that is a clue
     * @return      the fifth character in the string parameter
     */
    public String getEvenClue(String st)
    {
        String even = "";
        even = even + st.substring(4, 5);
        return even;
    }
    
    /**
     * Extract clues from an array of strings.
     * 
     * @param clues     each element in this array holds a clue.
     *                  If the index is even, the clue is held in the fifth character.
     *                  If the index is odd, the clue is held in the third and fourth charaters.
     * @return          the hidden answer from the array of clues
     */
    public String extractClues(String[] clues)
    {
        String answer = "";
        for (int i = 0; i < clues.length; i++) 
        {
            String clue = clues[i];
            if (i % 2 == 0) 
            {
                answer = answer + getEvenClue(clue);
            } 
            else 
            {
                answer = answer + getOddClue(clue);
            }
        }
        return answer;
    }
    
    /**
     * Help Dr. Watson find Sherlock Holmes from a coded list of words.
     * 
     * @param args   arguments from the command line
     */
    public static void main(String[] args)
    {
        String[] data = {"Nexa2f5",  "Z52Bizlm", "Diskapr", 
                         "emkem9sD", "LaWYr4Us", "dAStn78L",
                         "mPTuriye", "aaeeiuUu", "IL8Ctmpn"}; 
                                  
        SherlockHolmesFinder watson = new SherlockHolmesFinder();
        String address = watson.extractClues(data);
        System.out.println("\n\nThe hidden location is " + address);
    }
}
