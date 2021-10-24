/**
 * Tests the CamelotResident class:
 *      Creates a few instances and 
 *      Calls CamelotResident methods:
 *           printInformation() 
 *           getName()  
 * 
 * @author Susan King
 * @author Marina Peregrino 
 * @version November 27, 2016 
 */
public class CamelotResidentTester
{
    /**
     * Tests the Camelot Resident class.
     * 
     * @param args   information from the command line
     */
    public static void main (String [ ] args)
    {
        CamelotResident arthur = new CamelotResident("Arthur", "Pendragon", 
                25, "Camelot", "Britain","12345" );
        CamelotResident lancelot = new CamelotResident("Lancelot", "du Lac", 
                22, "Camelot", "Britain","12345" );
        CamelotResident guinevere = new CamelotResident("Guinevere", "Pendragon", 
                24, "Camelot", "Britain","12345" );
        System.out.println("Input data for Merlin!");
        CamelotResident merlin = new CamelotResident();
        
         //Print out the 4 residents 
        arthur.printInformation();
        lancelot.printInformation();
        guinevere.printInformation();
        merlin.printInformation();

        //Create an array of five Camelot residents 
        CamelotResident[] residents = new CamelotResident[5];
        
        //Add the 4 residents to an array and print their information 
        //Caution!  Beware of null pointers.  
        residents[0] = arthur;
        residents[1] = lancelot;
        residents[2] = guinevere;
        residents[3] = merlin;
        for (int i = 0; i < residents.length; i++) 
        {
            if (residents[i] != null) 
            {
                residents[i].printInformation();
            }
        }
        
    }
}