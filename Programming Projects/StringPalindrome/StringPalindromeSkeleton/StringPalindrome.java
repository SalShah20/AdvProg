import java.util.Scanner;
/**
 * String Palindrome takes an input and returns whether 
 * it is a palindrome or not.
 * 
 * @author Saloni Shah
 * 
 * @version 07.06.2021
 */
public class StringPalindrome
{
    // You may not create any instance variables
    // for this assignment.
    /**
     * Creates a StringPalindrome object.
     */
    public StringPalindrome()
    {
    }

    /**
     * Asks user for input, reads it, and returns the input.
     * 
     * @return  a line of user input
     */
    public String getUserInput( )
    {
        System.out.println("\nPlease type in a palindrome and find out " +
            "whether or not it is a palindrome." +
            "\n\tType in the word quit when done.");
        Scanner in = new Scanner (System.in);
        String str = in.nextLine( );
        return str;
    }

    /**
     * Takes a string of characters and returns only the characters 
     * from the alphabet as well as numbers.
     * 
     * @param  str  non-null string of charaters
     * 
     * @return the alphanumeric characters from the parameter str
     */
    public String stripPunctuation(String str)
    {
        String stripped = "";  // empty string
        for (int index = 0 ; index < str.length( ) ; index++)
        {
            String c = str.substring(index,index+1);
            if ( (0 <= c.compareTo("0") && c.compareTo("9") <= 0) ) 
            {
                stripped = stripped + c;
            } 
            else if ( (0 <= c.compareTo("A") && c.compareTo("Z") <= 0) ) 
            {
                stripped = stripped + c;
            } 
            else if ( (0 <= c.compareTo("a") && c.compareTo("z") <= 0) ) 
            {
                stripped = stripped + c;
            }
        }
        return stripped;
    }

    /**
     * Reverses the characters in a str.  
     * For example, if str is equal to "cat", then return  "tac".
     *
     * @param  str  non-null string of characters      
     * 
     * @return a string in which the characters are reversed
     */
    public String reverseString(String str)
    {
        String reverse = "";
        int length = str.length();
        for (int i = length; i > 0; i--) 
        {
            String first = str.substring(i - 1);
            str = str.substring(0, i - 1);
            reverse = reverse + first;
        }
        return reverse;
    }

    /**
     * Determines if a series of letters makes a palindrome.
     * 
     * @param  str   non-null string in which all punctuation and  
     *               spaces have been removed before this method 
     *               is called.  
     *               
     * @return true  if phrase is a palindrome, false otherwise.
     */
    public boolean isPalindrome(String str)
    {
        return (str.equals(reverseString(str)));
    }

    /**
     * Checks whether a non-null String object is a palindrome and 
     * outputs the answer. 
     * 
     * @param str   non-null string of characters
     */
    public void determineIfPalindrome(String str)
    {
        String palString = str.toLowerCase( );
        palString = stripPunctuation(palString);

        System.out.println("\"" + palString + "\"");
        if (isPalindrome(palString))
        {
            System.out.println( " is a palidrome.");
        }
        else
        {
            System.out.println( " is NOT a palidrome.");
        }
    }

    /**
     * Create a StringPalindrome object then it asks the user for
     * a string of characters and replies whether the input is a
     * palindrome.  This interaction with the user continues until
     * the user types in the word quit.
     * 
     * @param args  arguments from the command line
     */
    public static void main (String [] args)
    {
        StringPalindrome pal = new StringPalindrome( );
        String userInput = "" ; // empty String
        while ( ! userInput.equalsIgnoreCase("quit") )
        {
            userInput = pal.getUserInput( );
            pal.determineIfPalindrome(userInput);
        }
    }
}
