/*
Joshua Pickenpaugh
December 13th, 2016
FINAL PROJECT
"Casino" simulator. 
 */
package casino;
import java.util.Scanner;

public class Casino_MAIN {
    public static void main(String[] args) {
        //"main" variables:
        String strUserName;
        int intUserDeposit;
        char chrUserSelection;
        boolean bolDoLoopControl = true;

        //create a Scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        //Gets user's name, and then greets the user:
        System.out.print("Please enter your name: ");
        strUserName = keyboard.next();
        System.out.print("Welcome to the casino, " + strUserName + ". " +
            "Please deposit between $20 to $1000 to begin: ");

        //Gets user initial deposit amount, sees if it is enough or too much:
        do {
            intUserDeposit = keyboard.nextInt();
            if (intUserDeposit >= 20 && intUserDeposit <= 1000) {
                Casino_BANK.AddToAccountBalance(intUserDeposit);
                System.out.print("Your account has been created, starting at: " +
                    "$");
                System.out.println(Casino_BANK.GetAccountBalance());
            } else if (intUserDeposit < 20 || intUserDeposit > 1000) {
                System.out.print("TO REPEAT: Please deposit between $20 and " +
                    "$1000: ");
            }
        }
        while (intUserDeposit < 20 || intUserDeposit > 1000);

        do {
            //If account below $20, ask player to add to it to bring it up 
            //above $20:
            if (Casino_BANK.GetAccountBalance() < 20) {
                do {
                    System.out.print("Your account is below $20, it is at: $");
                    System.out.println(Casino_BANK.GetAccountBalance());
                    System.out.println("Please deposit enough funds to bring it " +
                        "to or above $20.");
                    intUserDeposit = keyboard.nextInt();
                    Casino_BANK.AddToAccountBalance(intUserDeposit);
                } while (Casino_BANK.GetAccountBalance() < 20);
            }
            //Game selection and user input:
            System.out.println("_________________________");
            System.out.print("ACCOUNT BALANCE: $");
            System.out.println(Casino_BANK.GetAccountBalance());
            System.out.println("Please choose your game: ");
            System.out.println("PRESS '1' for BLACKJACK");
            System.out.println("PRESS '2' for SLOT MACHINE");
            System.out.println("PRESS 'Q' to QUIT");
            System.out.println("_________________________");

            //accepts a char value:
            chrUserSelection = keyboard.next().charAt(0);

            //Game selection, and return greeting to player after game has ended:
            switch (chrUserSelection) {
                case '1':
                    Casino_BLACKJACK.BLACKJACK();
                    System.out.println("__________________________");
                    System.out.println("Welcome back to the lobby.");
                    System.out.print("Your account balance is: $");
                    System.out.println(Casino_BANK.GetAccountBalance());

                    break;

                case '2':
                    Casino_SLOTMACHINE.SLOTMACHINE();
                    System.out.println("__________________________");
                    System.out.println("Welcome back to the lobby.");
                    System.out.print("Your account balance is: $");
                    System.out.println(Casino_BANK.GetAccountBalance());
                    break;

                case 'q':
                case 'Q':
                    bolDoLoopControl = false;
                    break;

            }
        } while (bolDoLoopControl == true);

        //Final goodbye to player when leaves casino simulation:
        System.out.print("You end your tenure at the casino with : $");
        System.out.println(Casino_BANK.GetAccountBalance());
    }

}