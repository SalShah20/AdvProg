import java.util.ArrayList;
/**
 * Write a description of class Stack here.
 *
 * @author Saloni Shah
 * @version 07.22.2021
 */
public class StackArrayList
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Stack
     */
    public StackArrayList()
    {
        // initialise instance variables
    }

    public int pop (ArrayList<Integer> stack) {
        int first = stack.get(0);
        stack.remove(0);
        return first;
    }

    public void push (ArrayList<Integer> stack, int val) {
        stack.add(0, val);
    }

    public boolean isEmpty(ArrayList<Integer> stack) {
        if (stack != null && stack.size() > 0) {
            return false;
        }
        return true;
    }
    
    public int shift(ArrayList<Integer> stack) {
        int last = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return last;
    }
    
    public void unshift(ArrayList<Integer> stack, int val) {
        stack.add(stack.size(), val);
    }
    
    public void printStack(ArrayList<Integer> stack) {
        System.out.println("Stack: ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("\t Index: " + i + "\t"+ stack.get(i));
        }
    }
}
