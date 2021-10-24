
/**
 * Creates a specific pet that includes an id number, type, breed 
 * and weight.
 * 
 * @author Saloni Shah
 * @version 07.13.2021
 */
public class Pet
{
    // instance variables 
    private String type;  // cat, dog, fish, etc.  Stored all lower case
    private String breed; // Siamese, German Shepard, Zebra Fish
    private String id;    // id of the animal
    private double weight;

    /**
     * Constructor for objects of class Pet.
     * 
     * @param t     type of pet     (e.g., "dog")
     * @param b     breed of pet    (e.g., "German Shepard")
     * @param ident identification of the pet
     * @param w     current weight of pet
     */
    public Pet(String t, String b, String ident, double w)
    {
        this.type = t;
        this.breed = b;
        this.id = ident;
        setWeight(w);
    }

    /**
     * Retrieves the type of this pet.
     * 
     * @return     the type of this animal 
     */
    public String getType()
    {
        return type;
    }
    
    /**
     * Retrieves the breed of this pet.
     * 
     * @return     the breed of this animal 
     */
    public String getBreed()
    {
        return breed;
    }
    
    /**
     * Retrieves the identification number/character sequence of this pet.
     * 
     * @return     the id of this animal 
     */
    public String getId()
    {
        return id;
    }
    
    /**
     * Retrieves the weight of this pet.
     * 
     * @return     the weight of this animal 
     */
    public double getWeight()
    {
        return weight;
    }
    
    /**
     * Sets the new weight of this pet.
     * 
     * @param w     the new weight of animal 
     */
    public void setWeight(double w)
    {
        this.weight = w;
    }
    
    /**
     * Spaces out the lists for printing out.
     * 
     * @param text the text being printed out
     * 
     * @param chars the total number of characters in the string
     * 
     * @return spacer string with a specific number of spaces, acting 
     *                like a tab
     */
    public String spacer(String text, int chars) 
    {
        String result = new String("");
        for (int i = 0; i < chars - text.length(); i++) 
        {
            result += (" ");
        }
        return result;
    }
    
    /**
     * Returns information about this pet.
     * 
     * @return type, breed, id information and weight
     */
    public String toString()
    {
        return type.toUpperCase() + spacer(type, 5) + breed + spacer(breed, 25)
                    + id + spacer(id, 10) + weight;
    }
}
