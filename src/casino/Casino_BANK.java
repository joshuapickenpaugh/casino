package casino;

public class Casino_BANK {
    //Class variables:
    private static int intUserAccount;

    //Accessor (Getter):
    public static int GetAccountBalance() {
        return intUserAccount;
    }

    //Adds winnings to user account:
    public static void AddToAccountBalance(int usraccnt) {
        intUserAccount += usraccnt;
    }

    //Withdrawls funds:
    public static void WithdrawlFromBalance(int wthdrwl) {
        intUserAccount -= wthdrwl;
    }
}