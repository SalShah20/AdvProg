
/**
 * Test the Pet and PetStore classes.
 * 
 * @author Saloni Shah
 * 
 * @version 07.13.2021
 */
public class PetStoreTester
{

    /**
     * Constructor for objects of class PetStoreTester
     */
    public PetStoreTester()
    {

    }

    /**
     * Tests the Pet and PetStore classes.
     * 
     * @param  args   information from the command line
     */
    public static void main(String[] args)
    {
        Pet[] pets = { new Pet("cat", "Siamese", "S104", 6.2),
                       new Pet("dog", "German Shepherd", "D2579", 82.5),
                       new Pet("dog", "Mix", "D85869", 24.5),
                       new Pet("dog", "German Shepherd", "D9864", 90.0),
                       new Pet("dog", "Alaskan Malamute", "D27932", 80.5),
                       new Pet("dog", "American Cocker Spaniel", "D21254", 14.0),
                       new Pet("fish", "ZEBRA FISH", "", 16) };
                       
        PetStoreArrayList myStore = new PetStoreArrayList(pets);
        //PetStore myStore = new PetStore(pets);
        
        System.out.println("List of pets in the inventory:"); 
        myStore.printInventory(pets);
        System.out.println("\n");
        
        System.out.println("The number of pets in the inventory = " + 
                           myStore.sizeOfInventory());
        System.out.println("\n");
        
        System.out.println("Is there a Zebra Fish in the inventory? " + 
                           myStore.isBreedInInventory("zebra fish"));
        System.out.println("\n");
        
        System.out.println("List of dogs in the inventory:"); 
        myStore.printInventoryOfAType("DOG");
        System.out.println("\n");
        
        System.out.println("The number of dogs in the inventory = " + 
                           myStore.countInventoryByType("dOG"));
        System.out.println("\n");
        
        System.out.println("The average weight of cats in the inventory = " + 
                           myStore.calcAverageWeightOfInventoryByType("CAT"));
        System.out.println("\n");
        
        System.out.println("The average weight of dogs in the inventory = " + 
                           myStore.calcAverageWeightOfInventoryByType("DOg"));
        System.out.println("\n");
        
        System.out.println("The average weight of parrots in the inventory = " + 
                           myStore.calcAverageWeightOfInventoryByType("parrot"));
        System.out.println("\n");
    }
}
