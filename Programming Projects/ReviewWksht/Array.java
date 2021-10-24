
/**
 * Write a description of class Array here.
 *
 * @author Saloni Shah
 * @version 07.22.2021
 */
public class Array
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Array
     */
    public Array()
    {
        // initialise instance variables
    }
    
    public void printArray(int[] nums) {
        System.out.println("Printing Nums: ");
        for (Integer i : nums) {
            System.out.println(i);
        }
    }

    public void reverseElements(int[] nums) {
        int[] reverse = new int[nums.length];
        int pos = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            reverse[pos] = nums[i];
            pos++;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = reverse[i];
        }
    }
    
    public void shiftElements(int[] nums, int shift) {
        int[] s = new int[nums.length];
        for (int i = 0; i < nums.length - shift; i++) {
            s[i+shift] = nums[i];
        }
        for (int i = 0; i < shift; i++) {
            s[i] = nums[shift + i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = s[i];
        }
    }
}
