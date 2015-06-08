/**
 * the cash register
 * 
 * @author Bijan Tajmir
 * 
 */
public class CashRegister
{
    private int cashOnHand;
    public CashRegister()
    {
        cashOnHand = 500;
    }
    public CashRegister(int value)
    {
        if(value > 0)
        {
            cashOnHand = value;
        }
        else
        {
            throw new IllegalArgumentException("You must have some money, and you can't have negative money.");
        }
    }
    public void acceptAmount(int value)
    {
        if(value > 0)
        {
            cashOnHand += value;
        }
        else
        {
            throw new IllegalArgumentException("You can't add no money or take out money with the acceptAmount method");
        }
    }
    public int cashOnYou()
    {
        return cashOnHand;
    }
}
