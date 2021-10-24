
/**
 * Write a description of class StaticMethod here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StaticMethod
{
    // instance variables - replace the example below with your own
     int x;
     int y;
    /**
     * Constructor for objects of class StaticMethod
     */
    public StaticMethod()
    {
        // initialise instance variables
        x = 5;
        y = 10;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static int sum(int x, int y)
    {
        // put your code here
        return x * y;
    }
    
    public  void sophia () {
        int sum1 = sum(x, y);
        System.out.println("Sum 1 = " + sum1);
    }
}
