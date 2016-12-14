package casino;

public class Casino_BANK 
{
    //Class variables:
    private int intUserAccount;
    
    //Accessor (Getter):
    public int GetAccountBalance()
    {
        return intUserAccount;
    }
    
    //Mutator (Setter); Adds winnings to user account:
    public void SetAccountBalance(int usraccnt)
    {
        intUserAccount += usraccnt;
    }
}
