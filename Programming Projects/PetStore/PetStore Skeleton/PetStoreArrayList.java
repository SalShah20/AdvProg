import java.util.ArrayList;
/**
 * Generate a pet store with a fixed length pet inventory.
 * Gather information about the inventory.
 * 
 * @author Saloni Shah
 * @version 07.13.2021
 */
public class PetStoreArrayList
{
    // instance variables
    private ArrayList<Pet> petInventory = new ArrayList<Pet>();
    /**
     * Constructor for objects of class PetStore.
     * 
     * @param animals   inventory of animals for the pet store
     */
    public PetStoreArrayList(Pet[]animals)
    {
        for (Pet pet : animals) 
        {
            petInventory.add(pet);
        }
    }

    /**
     * Returns the size of the pet inventory.
     * 
     * @return     the number of animals in the inventory
     */
    public int sizeOfInventory()
    {
        return petInventory.size();
    }

    /**
     * Returns whether a particular breed is found in the inventory
     * The comparison is done all in lower case letters.
     * 
     * @param   breed  the breed being searched for
     * @return  true if the breed is in the inventory; otherwise,
     *          false 
     */
    public boolean isBreedInInventory(String breed)
    {
        for (int i = 0; i < petInventory.size(); i++) 
        {
            if (petInventory.get(i).getBreed().equalsIgnoreCase(breed)) 
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Prints a list of animal in the pet inventory of a particular type.
     * 
     * @param pets the array of pets in the store
     */
    public void printInventory(Pet[] pets)
    {
        ArrayList<Pet> petInventory = new ArrayList<Pet>();
        for (Pet pet : pets) 
        {
            petInventory.add(pet);
        }
        for (int i = 0; i < petInventory.size(); i++) 
        {
            System.out.println(petInventory.get(i));
        }
    }

    /**
     * Prints a list of animal in the pet inventory of a particular type.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     */
    public void printInventoryOfAType(String type)
    {
        for (int i = 0; i < petInventory.size(); i++) 
        {
            if (petInventory.get(i).getType().equalsIgnoreCase(type)) 
            {
                System.out.println(petInventory.get(i));
            }
        }
    }

    /**
     * Returns the number of occurrences of a type in the pet inventory.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     * @return     the number of occurrences of a type in the inventory
     */
    public int countInventoryByType(String type)
    {
        int occur = 0;
        for (int i = 0; i < petInventory.size(); i++) 
        {
            if (petInventory.get(i).getType().equalsIgnoreCase(type)) 
            {
                occur++;
            }
        }
        return occur;
    }

    /**
     * Returns the weight of all the animals of a certain type
     * 
     * @return     the weight of all the animals of a certain type
     */
    private double calcTotalWeightOfInventoryByType(String type)
    {
        double weight = 0.0;
        for(int i = 0; i < petInventory.size(); i++) 
        {
            if (petInventory.get(i).getType().equalsIgnoreCase(type)) 
            {
                weight += petInventory.get(i).getWeight();
            }
        }
        return weight;
    }

    /**
     * Returns the average weight of a particular type of animal in the pet inventory.  
     * If the type is not found in the inventory, returns 0.0.
     * 
     * @param type  the type of animal, such as a dog, cat, fish, etc.
     * @return      the average weight
     */
    public double calcAverageWeightOfInventoryByType(String type)
    {
        double sum = calcTotalWeightOfInventoryByType(type);
        int count = countInventoryByType(type);
        if (count == 0) 
        {
            return 0.0;
        }
        double average = (double) (sum/count);
        return average;
    }
}
