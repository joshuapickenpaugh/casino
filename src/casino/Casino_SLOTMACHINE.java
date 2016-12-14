package casino;
import java.util.Scanner;
import java.util.Random;

public class Casino_SLOTMACHINE 
{
    //Local variable declarations:
    private static int intUserChoice;
    
    private static int intRandNum1;    
    private static int intRandNum2;    
    private static int intRandNum3; 
    
    private static String strFruit1;
    private static String strFruit2;
    private static String strFruit3;
    
    private static int intDoubleProfit;
    private static int intTripleProfit;
    
    //Main entry point for the slot machine game:
    public static void SLOTMACHINE()
    {
        System.out.println("WELCOME TO THE SLOTS.");
        do
        {
            System.out.println("Press 1 to pull the lever, press 2 to QUIT:");
        
            //create a Scanner object to read from the keyboard
	    Scanner keyboard = new Scanner(System.in); 
            intUserChoice = keyboard.nextInt();
        
            if (intUserChoice == 1)
            {
               intDoubleProfit = 0;
               intTripleProfit = 0;

               //Gets random number between 0 and 6 for Column 1, assigns to variable:
               intRandNum1 = GetRandomNumber();    

               //Gets random number between 0 and 6 for Column 2, assigns to variable:
               intRandNum2 = GetRandomNumber(); 
        
               //Gets random number between 0 and 6 for Column 3, assigns to variable:
               intRandNum3 = GetRandomNumber();
        
               //Converts random number to assigned fruit: 
               strFruit1 = GetFruitAssignment(intRandNum1);
               strFruit2 = GetFruitAssignment(intRandNum2);
               strFruit3 = GetFruitAssignment(intRandNum3);   
        
               //Displays the three columns of fruit:
               System.out.print(strFruit1 + ",");
               System.out.print(strFruit2 + ",");
               System.out.print(strFruit3 + ",");      
               
               System.out.println();
               
               //Compare fruite types and if two of a kind, double wager and return profit:
               intDoubleProfit = CompareTwoOfAKindAndDoubleWager(strFruit1,strFruit2, strFruit3);      
        
               //Compare fruite types and if three of a kind, triple wager and return profit:
               intTripleProfit = CompareThreeOfAKindAndTripleWager(strFruit1, strFruit2, strFruit3);
               
               //Add the intDoubleProfit and intTripleProfit to the userAccount in BANK:
               
            }   
            
        }while(intUserChoice == 1);  
        
        System.out.println("You are now leaving the slots.");
    }
    
    //Random number generator:
    public static int GetRandomNumber()
    {
        int randNum;
        
        Random randomNumber = new Random();
        
        randNum = randomNumber.nextInt(6);
        
        return randNum;
    }
    
    //Converts random int to assigned "fruit" string:
    public static String GetFruitAssignment(int rndnm)
    {
        String fruit = "";
        
        switch(rndnm)
        {
            case 0:
                fruit = "CHERRY";
                break;
            case 1:
                fruit = "ORANGE";
                break;
            case 2:
                fruit = "PLUM";
                break;
            case 3: 
                fruit = "BELL";
                break;
            case 4:
                fruit = "MELON";
                break;
            case 5:
                fruit = "BARS";
                break;
            default:
                break;
        }
        
        return fruit;
    }
    
    public static int CompareTwoOfAKindAndDoubleWager(String f1, String f2, String f3)
    {
        int wager = 0;
        
        //Compare fruit types (if two of a kind, double wager):
        if (f1.equals(f2))
        {
            System.out.println("***TWO OF A KIND, WAGER DOUBLED***");
            //Double the wager:
        }
        else if (f1.equals(f3))
        {
            System.out.println("***TWO OF A KIND, WAGER DOUBLED***");     
            //Double the wager:
        }
        else if (f2.equals(f3))
        {
            System.out.println("***TWO OF A KIND, WAGER DOUBLED***");  
            //Double the wager:
        }      
        
        //return the profit:
        return wager;
           
    }
    
    public static int CompareThreeOfAKindAndTripleWager(String f1, String f2, String f3)
    {
        int wager = 0;
        
        if (f3.equals(f1.equals(f2)))
        {
            System.out.println("!!!!!!!!!THREE OF A KIND, WAGER TRIPLED!!!!!!!!!");   
            //Triple the wager:
        }    
        
        //Return the profit:
        return wager;
    }
    
}
