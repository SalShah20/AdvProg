import java.util.Scanner;
/**
 * Creates a resident of Camelot then maintains and prints 
 * his or her information.
 * 
 * @author Saloni Shah
 * @version 07.12.2021
 */
public class CamelotResident
{
    // constant
    private static final String DOMAIN = "@Camelot.com";
    
    // instance variables
    private String lastName, firstName;
    private int age;
    private String city, state;
    private String zip;

    /**
     * Constructor for objects of class CamelotResident.
     * 
     * @param fName   first name of resident
     * @param lName   last name of resident
     * @param years   age of resident
     * @param town    city of resident
     * @param st      state of resident
     * @param zipCode zip code of resident
     */
    public CamelotResident(String fName, String lName, int years, 
                           String town, String st, String zipCode)
    {
        this.firstName = fName;
        this.lastName = lName;
        this.age = years;
        this.city = town;
        this.state = st;
        this.zip = zipCode;
    }
    
    /**
     * Constructor for objects of class CamelotResident.
     */
    public CamelotResident()
    {   
        askForName();
        askForAge();
        askForAddress();
    }
    
    /**
     * Checks if the name is valid
     * 
     * @param name is the name entered by user
     * 
     * @return true if the name is just letters; otherwise false
     */
    public boolean checkNameIsValid(String name) 
    {
        if ((0 <= name.compareTo("A") && name.compareTo("Z") >= 0) ||
                (0 <= name.compareTo("a") && name.compareTo("z") >= 0))
        {
            return false;
        }
        return true;
    }
    
    /**
     * Asks user for resident's name and stores the first and last names.
     */
    public void askForName( )
    {
        System.out.println("\n\n\nType in the resident's name in the format" +
            "\n\tLastname, Firstname");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine( );
        int comma = name.indexOf(",");
        if (comma == -1) 
        {
            System.out.println("Name invalid");
            askForName();
        } 
        lastName = name.substring(0, comma);
        lastName = lastName.trim();
        if (!checkNameIsValid(lastName))
        {
            System.out.println("Name invalid");
            System.out.println("The name must be only letters");
            askForName();
        }
        firstName = name.substring(comma+1);
        firstName = firstName.trim();
        if (!checkNameIsValid(firstName))
        {
            System.out.println("Name invalid");
            System.out.println("The name must be only letters");
            askForName();
        }
    }

    /**
     * Asks user for resident's age and stores it.
     */
    public void askForAge( )
    {
        System.out.println("\nType in the resident's age");
        Scanner in = new Scanner(System.in);
        age = in.nextInt( );
        in.nextLine( );
    }

    /**
     * Asks user for resident's address and stores the information.
     */
    public void askForAddress( )
    {
        System.out.println("\nType in the resident's address in the format" 
            + "\n\tCity, State Zip");
        Scanner in = new Scanner(System.in);
        String address = in.nextLine( );
        int comma = address.indexOf(",");
        if (comma == -1) 
        {
            System.out.println("\nAddress invalid");
            System.out.println("\nType in the resident's address in the format" 
                                  + "\n\tCity, State Zip");
            address = in.nextLine( );
        }
        address = address.trim();
        city = address.substring(0, comma);
        int space = address.lastIndexOf(" ");
        state = address.substring(comma+1, space);
        state = state.trim();
        zip = address.substring(space+1);
        if (zip.length() != 5) 
        {
            System.out.println("\nZipcode invalid");
            System.out.println("\n Type 5 digit zipcode");
            zip = in.nextLine();
        }
    }

    /**
     * Generates the resident's E-mail account.
     * 
     * @return E-mail account
     */
    public String generateEmailAccount( )
    {
        String email = "";
        String first = firstName.toLowerCase().substring(0, 1);
        String last = lastName.toLowerCase();
        email = first + last + DOMAIN;
        int space = email.indexOf(" ");
        if (space != -1) 
        {
            String mail = email;
            email = mail.substring(0, space);
            email += mail.substring(space+1);
        }
        return email;
    }

    /**
     * Retrieves the first name.
     * 
     * @return the resident's first name
     */
    public String getFirstName( )
    {
        return firstName;
    }

    /**
     * Sets the first name to a new first name.
     * 
     * @param fName the resident's new first name
     */
    public void setFirstName(String fName)
    {
        this.firstName = fName;
    }

    /**
     * Retrieves the last name.
     * 
     * @return the resident's last name
     */
    public String getLastName( )
    {
        return lastName;
    }

    /**
     * Sets the last name to a new last name.
     * 
     * @param lName the resident's new last name
     */
    public void setLastName(String lName)
    {
        this.lastName = lName;
    }

    /**
     * Retrieves the city. 
     * 
     * @return the resident's city
     */
    public String getCity( )
    {
        return city;
    }

    /**
     * Sets the city to a new city name.
     * 
     * @param town the resident's new city
     */
    public void setCity(String town)
    {
        this.city = town;
    }

    /**
     * Retrieves the state. 
     * 
     * @return the resident's state
     */
    public String getState( )
    {
        return state;
    }

    /**
     * Sets the state to a new state name.
     * 
     * @param st the resident's new state
     */
    public void setState(String st)
    {
        this.state = st;
    }

    /**
     * Retrieves the zip code. 
     * 
     * @return the resident's zip
     */
    public String getZip( )
    {
        return zip;
    }

    /**
     * Sets the zip to a new zip code.
     * 
     * @param zippy the resident's new zip code
     */
    public void setZip(String zippy)
    {
        this.zip = zippy;
    }

    /**
     * Retrieves the age.
     * 
     * @return the resident's age
     */
    public int getAge( )
    {
        return age;
    }

    /**
     * Sets the age to a new age.
     * 
     * @param oldness the resident's new age
     */
    public void setAge(int oldness)
    {
        this.age = oldness;
    }

    /**
     * Displays information about the resident.
     */
    public void printInformation( )
    {
        System.out.print ("\n\n\n" + firstName + " " + lastName);
        System.out.println ("\t\t Age: " + age);
        System.out.println ("\t" + generateEmailAccount( ));
        System.out.println ("\t\t" + city);
        System.out.println ("\t\t" + state + " " + zip);
    }
    
    /**
     * Overriding toString to store all information to print out.
     * 
     * @return string with all the information about the resident
     *                properly indented
     */
    @Override
    public String toString() 
    {
        String information = "";
        information += "\n\n\n" + firstName;
        information += " " + lastName;
        information += "\n" + "\t" + generateEmailAccount() + "\n";
        information += "\t\t" + city + "\n";
        information += "\t\t" + state + " " + zip;
        return information;
    }
}
