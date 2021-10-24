
/**
 * Write a description of class ArrayMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayUtility
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class ArrayMethods
     */
    public ArrayUtility()
    {
        // initialise instance variables
    }

    public int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public double average(int[] array) {
        int sum = sum(array);
        double average = (double) sum/array.length;
        return average;
    }

    public int getMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int findMinIndex(int[] array) {
        int min = getMin(array);
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                index = i;
            }
        }
        return index;
    }

    public int findMaxIndex(int[] array) {
        int max = getMax(array);
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                index = i;
            }
        }
        return index;
    }

    public int[] fillWithRandomNumsTen(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * (10 - 1 + 1) + 1);
            array[i] = value;
        }
        return array;
    }

    public int[] fillWithRandomNums(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            int value = (int) (Math.random() * (max - min + 1) + min);
            array[i] = value;
        }
        return array;
    }
    
    public int modulus (int m, int n) {
        if (m < n) {
            return m;
        } else {
            return modulus(m - n, n);
        }
    }
    
    public int integerDiv(int m, int n) {
        if (m < n) {
            return 0;
        } else {
            return 1 + integerDiv(m - n, n);
        }
    }
}
