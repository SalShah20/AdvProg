import java.util.ArrayList;
/**
 * Write a concise summary of class Tester here.
 * 
 * @author  Saloni Shah 
 *
 * @version 07.22.2021
 */
public class Tester 
{
    /* Tester methods: */
    /**
     * Write a description of method here.
     *
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        // Write your code here
        /*ArrayList<Integer> stack = new ArrayList();
        for (int i = 0; i < 10; i++) {
            stack.add(i, i+2);
        }
        StackArrayList george = new StackArrayList();
        george.printStack(stack);
        int pop = george.pop(stack);
        System.out.println("Popped: " + pop);
        george.printStack(stack);
        george.push(stack, 20);
        System.out.println("Pushed: ");
        george.printStack(stack);
        boolean empty = george.isEmpty(stack);
        System.out.println("Is empty: " + empty);
        george.printStack(stack);
        int shift = george.shift(stack);
        System.out.println("Shifted: " + shift);
        george.printStack(stack);
        george.unshift(stack, 20);
        System.out.println("Unshifted: ");
        george.printStack(stack);
        StackArray fred = new StackArray();
        int[] stack2 = new int[10];
        for (int i = 0; i < stack2.length; i++) {
            stack2[i] = i+2;
        }
        fred.printStack(stack2);
        pop = fred.pop(stack2);
        System.out.println("Popped: " + pop);
        fred.printStack(stack2);
        fred.push(stack2, 20);
        System.out.println("Pushed: ");
        fred.printStack(stack2);
        empty = fred.isEmpty(stack2);
        System.out.println("Is empty: " + empty);
        fred.printStack(stack2);
        shift = fred.shift(stack2);
        System.out.println("Shifted: " + shift);
        fred.printStack(stack2);
        fred.unshift(stack2, 20);
        System.out.println("Unshifted: ");
        fred.printStack(stack2);
        */
        ArrayUtility bob = new ArrayUtility();
        int mod = bob.modulus(101, 10);
        System.out.println(mod);
        
        mod = bob.modulus(67, 4);
        System.out.println(mod);
        
        int div = bob.integerDiv(2, 10);
        System.out.println(div);
        
        div = bob.integerDiv(90, 10);
        System.out.println(div);
        
        /*Array aarini = new Array();
        int[] array = new int[]{1, 2, 3, 4};
        aarini.printArray(array);
        aarini.reverseElements(array);
        aarini.printArray(array);
        
        aarini.printArray(array);
        aarini.shiftElements(array, 2);
        aarini.printArray(array);*/
        
    }
}
