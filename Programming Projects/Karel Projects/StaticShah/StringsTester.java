/**
 * Write a concise summary of class StringsTester here.
 * 
 * @author  (your name) 
 *   With assistance from 
 *
 * @version (a version number or a date) 
 */
public class StringsTester 
{
    /* StringsTester methods: */
    /**
     * Write a description of method here.
     *
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        // Write your code here
        String name = new String("Saloni");
        String friendName = new String("Maggie");
        System.out.println(friendName.length());
        System.out.println(name.indexOf("A"));
        System.out.println(name.substring(2));
        System.out.println(name.substring(2, name.length()-1));
        System.out.println(name.equals(friendName));
        System.out.println(name + " and " + friendName + " are buddies!");
        System.out.println(name.toUpperCase());
        System.out.println(name);
        System.out.println(name.toLowerCase());
        System.out.println(name);
        /********************************************************************/
        String str = "Hello World!";
        System.out.println(str);
        str.toLowerCase();
        System.out.println(str);
        str = str.toLowerCase();
        System.out.println(str);
        System.out.println(str.indexOf("ell"));
        System.out.println(str.indexOf("Hahaha"));
        System.out.println(str.indexOf("o"));
        System.out.println(str.indexOf("o", 6));
        System.out.println(str.equals("HELLO WORLD!"));
        System.out.println(str.equals("Hello World!"));
        System.out.println(str.equalsIgnoreCase("HELLO WORLD!"));
        System.out.println(str == "Hello World!");
        /********************************************************************/
        String s = "It is time";
        System.out.println(s.length());
        System.out.println(s.substring(1));
        System.out.println(s.substring(1,4));
        System.out.println(s.substring(1,5));
        System.out.println(s.indexOf("time"));
        System.out.println(s.indexOf("bye"));
        System.out.println(s.indexOf("i"));
        System.out.println(s.indexOf("i",4));
        /********************************************************************/
        String myGreeting = "Hello, ";
        String yourGreeting = "Hello, ";
        String ourGreeting = new String("Hello, ");
        System.out.println(myGreeting == yourGreeting);
        System.out.println(myGreeting == ourGreeting);
        System.out.println(myGreeting.equals(yourGreeting));
        System.out.println(myGreeting.equals(ourGreeting));
        /********************************************************************/
        String hello = "I say \"hello\" to you";
        System.out.println(hello);
        /********************************************************************/
        String d = "Daisy";
        String str1 = "Daisy";
        System.out.println(d.compareTo(str1));
    }
}
