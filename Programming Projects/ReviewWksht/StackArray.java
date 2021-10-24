
/**
 * Write a description of class StackArray here.
 *
 * @author Saloni Shah
 * @version 07.22.2021
 */
public class StackArray
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class StackArray
     */
    public StackArray()
    {
        // initialise instance variables
    }
    
    public int pop (int[] stack) {
        int first = stack[0];
        int[] stack2 = new int[stack.length - 1];
        for (int i = 1; i < stack2.length; i++) {
            stack2[i - 1] = stack[i];
        }
        stack = stack2;
        return first;
    }
    
    public void push (int[] stack, int val) {
        int[] stack2 = new int[stack.length + 1];
        stack2[0] = val;
        for (int i = 0; i < stack.length; i++) {
            stack2[i + 1] = stack[i];
        }
        stack = stack2;
    }
    
    public boolean isEmpty (int[] stack) {
        if (stack != null && stack.length > 0) {
            return false;
        } 
        return true;
    }
    
    public int shift (int[] stack) {
        int last = stack[stack.length - 1];
        int[] stack2 = new int[stack.length - 1];
        for (int i = 0; i < stack2.length; i++) {
            stack2[i] = stack[i];
        }
        stack = stack2;
        return last;
    }
    
    public void unshift (int[] stack, int val) {
        int[] stack2 = new int[stack.length + 1];
        for (int i = 0; i < stack.length; i++) {
            stack2[i] = stack[i];
        }
        stack2[stack.length] = val;
        stack = stack2;
    }
    
    public void printStack(int[] stack) {
        System.out.println("Stack: ");
        for (int i = 0; i < stack.length; i++) {
            System.out.println("\t Index: " + i + "\t"+ stack[i]);
        }
    }
}
