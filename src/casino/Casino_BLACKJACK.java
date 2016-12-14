package casino;
import java.util.Scanner;
import java.util.Random;

public class Casino_BLACKJACK 
{             
    private static int intComputerTotal = 0;
    private static int intPlayerTotal = 0;
    private static int intUserChoice = 0;

    public static void BLACKJACK()
    {
        //Variable declaration:
        int intPlayerPoints = 0;
        int intComputerPoints = 0;
    
        System.out.println("WELCOME TO BLACKJACK.");     
        do
        {
            System.out.println("Press 1 to roll, press 2 to QUIT");
            
            //create a Scanner object to read from the keyboard
	    Scanner keyboard = new Scanner(System.in); 
            intUserChoice = keyboard.nextInt();
            
            if (intUserChoice == 1)
            {
                intPlayerPoints = RollDice();
                intPlayerTotal += intPlayerPoints;
                
                intComputerPoints = RollDice();
                intComputerTotal += intComputerPoints;
                
                System.out.println("You have " + intPlayerTotal + ".");
                
            }
            
        }while (intUserChoice == 1);
        
        System.out.println("You have a total of " + intPlayerTotal + ".");
        System.out.println("The computer as a total of " + intComputerTotal + ".");
        
        //Method to compare the totals, annouce the winner:
        
    }
    
    public static int RollDice()
    {
        int dice1 = 0;
        int dice2 = 0;
        int total = 0;
        
        Random diceObj1 = new Random();
        Random diceObj2 = new Random();
        
        dice1 = diceObj1.nextInt(6);
        dice1 += 1;
        
        dice2 = diceObj2.nextInt(6);
        dice2 += 1;
        
        total = dice1 + dice2;
        
        return total;
    }
}
