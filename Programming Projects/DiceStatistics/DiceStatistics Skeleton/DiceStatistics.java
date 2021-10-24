
/**
 * Includes several activities that can be done with a set of dice,
 * such as rolling 3 of a kind, rolling N of a kind, rolling 3 unique
 * values, rolling N unique value, and frequencies of rolls.
 *
 * The activities demonstrate some basic random statistics for a die 
 * and for a set of dice.
 * 
 * @author  Saloni Shah
 * 
 * @version 07.09.2021
 */
public class DiceStatistics
{

    /**
     * Creates a DieStatistics object that can be used to
     * run activities that demonstrate some statistics with dice.
     */
    public DiceStatistics()
    {
    }
    
    /**
     * Rolls n number of dice and returns their sum.
     * 
     * @param diceArr     an array with non-null Die objects
     * @return the sum of the rolls of the array of dice
     */
    public static int sumOfRoll(Die[] diceArr)
    {
        int sum = 0;
        for (int i = 0; i < diceArr.length; i++) 
        {
            int val = diceArr[i].roll();
            sum += val;
        }
        return sum;
    }
    
    /**
     * Rolls a set of dice a given number of times, keeping
     * track of the frequencies of the sums of the rolls.
     * Then the method outputs their frequences.
     * 
     * @param diceArr           a non-empty array with non-null Die objects
     * @param numberOfTrials    number of trials that are going to be run
     * 
     */
    public static void getFrequencyOfSumsOfRolls(Die[] diceArr , 
                                                 int numberOfTrials)
    {
        // Sums the sides from all the dice.
        int sumOfSides = 0;
        for (int i = 0; i < diceArr.length; i++) 
        {
            sumOfSides += diceArr[i].getSides();
        }
        
        // Sets up the data structures to hold the "tally marks". 
        int [ ] frequency = new int [sumOfSides+1];
        for (int i = 0; i < numberOfTrials; i++) 
        {
            frequency[sumOfRoll(diceArr)] += 1;
        }
        
        // Outputs the frequencies.
        System.out.println("Sum\tFrequency");
        for (int f = diceArr.length ; f < frequency.length ; f++)
        {
            System.out.println(f + "\t" + frequency[f]);
        }
        System.out.println("\n");
    }    

    /**
     * Rolls three dice until all rolls have the same value.
     * 
     * @param die1 a non-null Die
     * @param die2 a non-null Die
     * @param die3 a non-null Die
     * @return     the number of times three dice are rolled 
     *             before all three rolled values are equal
     */
    public static int rollThreeOfAKind(Die die1, Die die2 , Die die3)
    {
        int roll1 = die1.roll();
        int roll2 = die2.roll();
        int roll3 = die3.roll();
        int counter = 1; 
        System.out.println("\n" + roll1 + "\t" + roll2 + 
                           "\t" + roll3 + "\troll count = " + counter);
               
        while (!(roll1 == roll2 && roll2 == roll3))
        {
            roll1 = die1.roll();
            roll2 = die2.roll();
            roll3 = die3.roll();
            counter++;
            System.out.println(roll1 + "\t" + roll2 + "\t" + 
                               roll3 + "\troll count = " + counter);
        }
        return counter;
    }
    
    /**
     * Rolls three dice until all are unique.
     * 
     * @param die1 a non-null Die
     * @param die2 a non-null Die
     * @param die3 a non-null Die
     * @return     the number of times three dice are rolled 
     *             before all three rolled values are unique
     */
    public static int rollThreeUnique(Die die1, Die die2 , Die die3 )
    {
        int roll1 = die1.roll();
        int roll2 = die2.roll();
        int roll3 = die3.roll();
        int counter = 1; 
        System.out.println("\n" + roll1 + "\t" + roll2 + 
                           "\t" + roll3 + "\troll count = " + counter);
               
        while (roll1 == roll2 || roll2 == roll3 || roll1 == roll3)
        {
            roll1 = die1.roll();
            roll2 = die2.roll();
            roll3 = die3.roll();
            counter++;
            System.out.println(roll1 + "\t" + roll2 + "\t" + 
                               roll3 + "\troll count = " + counter);
        }
        return counter;
    }
    
    /**
     * Rolls "N" dice until all the roll values are the same.
     *   
     * @param diceArray a non-empty array with non-null Die objects
     * 
     * @return the number of times N dice are rolled 
     *         before all N rolled values are the same
     */
    public static int rollNOfAKind(Die[] diceArray)
    {
        // Checks that the array has a length.
        if (diceArray == null) 
        {
            return 0;
        }
        
        int number = diceArray.length;
        if (number == 0) 
        {
            return 0;
        }
        
        // Creates an array to hold the roll value of each die.
        int[] rollOfDice = new int [number];
           
        // Initialize a counter that keeps track of the rolls.
        int count = 0;
        
        // The same variable is a flag with the following meaning:
        //     once one die's value does not match one other's value,
        //     "same" becomes false; otherwise, it is true.
        // Note: same starts out as false.
        boolean same = false;
        while (! same)
        {
            count++;
            
            // Stores and prints the rolled values in rollOfDice.
            for (int index = 0; index < number; index++)
            {
                rollOfDice[index] = diceArray[index].roll();
                System.out.print("\t" + rollOfDice[index]);
            }
            System.out.println("\troll count = " + count);
            
            // Tests to see if all other rolled values 
            // are the same as "match".
            int match = rollOfDice[0];
            int counter = 0;
            for (int i = 0; i < number; i++) 
            {
                if(rollOfDice[i] == match) 
                {
                    counter++;
                }
            }
            if (counter == number) 
            {
                same = true;
            } 
            else 
            {
                same = false;
            }
        }
        return count;
    }
    
    /**
     * Rolls "N" dice until all the rolled values are unique.
     * 
     * @param diceArray   a non-empty array with non-null Die objects
     * @return     the number of times N dice are rolled 
     *             before all N rolled values are unique
     */
    public static int rollNUnique( Die[] diceArray )
    {
        // Checks that the array has a length.
        
        if (diceArray == null) 
        {
            return 0;
        }
        
        int length = diceArray.length;
        if (length == 0) 
        {
            return 0;
        }
        
        // Creates an array to hold the roll value of each die.
        int[] rollOfDice = new int [length];
           
        // Initialize a counter that keeps track of the rolls.
        int count = 0;
        
        //if all the rolls are different, diff is true.
        boolean diff = false;
        while (!diff)
        {
            count++;
            // Stores and prints the rolled values in rollOfDice.
            for (int i = 0; i < length; i++)
            {
                rollOfDice[i] = diceArray[i].roll();
                System.out.print("\t" + rollOfDice[i]);
            }
            System.out.println("\troll count = " + count);
            
            // Tests to see if all other rolled values 
            // are different from "match".
            int match = rollOfDice[0];
            int counter = 0;
            boolean dice = true;
            for (int i = 0; i < length; i++) 
            {
                for (int j = length - 1; j > i; j--) 
                {
                    match = rollOfDice[j];
                    if(rollOfDice[i] != match) 
                    {
                        dice = dice && true;
                    } 
                    else 
                    {
                        dice = false;
                    }
                }
                if (dice) 
                {
                    counter++;
                }
            }
            if (counter == length) 
            {
                diff = true;
            }  
        }
        return count;
    }
}

