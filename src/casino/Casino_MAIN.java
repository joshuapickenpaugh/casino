/*
Joshua Pickenpaugh
December 13th, 2016
FINAL PROJECT
"Casino" simulator. 
 */
package casino;
import java.util.Scanner;

public class Casino_MAIN 
{ 
    public static void main(String[] args) 
    {        
        
        //"main" variables:
        String strUserName;   
        int intUserAccount;
        char chrUserSelection;
        
        //create a Scanner object to read from the keyboard
	Scanner keyboard = new Scanner(System.in);  
        
        //Gets user's name, and then greets the user:
        System.out.println("Please enter your name: ");
        strUserName = keyboard.next();        
        System.out.println("Welcome to the casino, " + strUserName +". "
                + "Please deposit between $20 to $1000 to begin: ");
        
        //Gets user deposit amount, sees if it is enough or too much:
        do
        {
           intUserAccount = keyboard.nextInt();
           if (intUserAccount >= 20 && intUserAccount <= 1000)
           {
               Casino_BANK userAccount = new Casino_BANK(intUserAccount);
               System.out.print("Your account has been created, starting at: $");
               System.out.println(userAccount.GetAccountBalance());
           }
           else if (intUserAccount < 20 || intUserAccount > 1000)
           {
               System.out.println("TO REPEAT: Please deposit between $20 and $1000");
           }
        }
        while (intUserAccount < 20 || intUserAccount > 1000);
        
        //Game selection and user input:
        System.out.println("Please choose your game: ");
        System.out.println("PRESS '1' for BLACKJACK");
        System.out.println("PRESS '2' for SLOT MACHINE");
        System.out.println("PRESS 'Q' to QUIT");
        
        //accepts a char value:
        chrUserSelection = keyboard.next().charAt(0);
        
        switch(chrUserSelection)
                {
                    case '1':
                        Casino_BLACKJACK.BLACKJACK();
                        break;
                    
                    case '2':
                        Casino_SLOTMACHINE.SLOTMACHINE();
                        break;
                        
                    case 'q':
                    case 'Q':
                        break;                       
                    
                }
        
        
        
        
        
        

        
                 
    }
    
}
