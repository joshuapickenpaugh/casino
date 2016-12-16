package casino;
import java.util.Scanner;
import java.util.Random;

public class Casino_BLACKJACK {
    private static int intComputerTotal = 0;
    private static int intPlayerTotal = 0;
    private static int intUserChoice = 0;
    private static int intUserChoice2;

    public static void BLACKJACK() {
        
        System.out.println("WELCOME TO BLACKJACK.");
                    
        do {
            //Variable declaration:
            int intPlayerPoints = 0;
            int intComputerPoints = 0;

            //create a Scanner object to read from the keyboard
            Scanner keyboard = new Scanner(System.in);


            do {
                //Computer rolls the dice before player is asked if they wish to roll:
                intComputerPoints = RollDice();
                intComputerTotal += intComputerPoints;

                System.out.println("Press 1 to roll, press 2 to QUIT");

                intUserChoice = keyboard.nextInt();

                if (intUserChoice == 1) {
                    intPlayerPoints = RollDice();
                    intPlayerTotal += intPlayerPoints;
                }
                if (intUserChoice == 2) {
                    break;
                }

                System.out.println("You have " + intPlayerTotal + ".");

            } while (intPlayerTotal < 21);

            System.out.println("You have a total of " + intPlayerTotal + ".");
            System.out.println("The computer has a total of " + intComputerTotal + ".");

            //Method to compare the totals, annouce the winner:
            WhoWins(intPlayerTotal, intComputerTotal);

            //Reset player and computer totals:
            intPlayerTotal = 0;
            intComputerTotal = 0;

            //Ask player if they want to play again:
            System.out.println("Another game '1' for YES, '2' for NO");
            intUserChoice2 = keyboard.nextInt();

        } while (intUserChoice2 == 1);


    }

    public static int RollDice() {
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

    public static void WhoWins(int plyr, int cmptr) {
        //Player wins if they are less than or equal to 21, and great than computer's score:
        if (plyr <= 21 && plyr > cmptr) {
            System.out.println("The HUMAN wins!");
        }

        //Computer wins if it is less than or equal to 21 and greater than the player:
        if (cmptr <= 21 && cmptr > plyr) {
            System.out.println("The COMPUTER wins!");
        }

        //Tied game:
        if (cmptr <= 21 && cmptr == plyr) {
            System.out.println("The Human and Computer TIED.");
        }

        //If player and computer goes over 21, both loose:
        if (plyr > 21 && cmptr > 21) {
            System.out.println("You both went over, you both loose.");
        }

        //If player goes over, but computer stay under 21, computer wins:
        if (plyr > 21 && cmptr <= 21) {
            System.out.println("You went over 21, but the computer wins since they are under 21.");
        }

        //If computer goes over, but the player stays under 21, the player wins:
        if (cmptr > 21 && plyr <= 21) {
            System.out.println("The computer went over 21, but the human wins since they are under 21.");
        }
    }
}