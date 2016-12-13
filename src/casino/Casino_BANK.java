package casino;

public class Casino_BANK 
{
    private int intUserAccount;
    
    //Constructor; Sets intitial account balance for player:
    public Casino_BANK(int usraccnt)
    {
        intUserAccount = usraccnt;
    }
    
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
