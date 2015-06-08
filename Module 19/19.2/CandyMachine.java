/**
 * the machine
 * 
 * @author Bijan Tajmir
 * 
 */
public class CandyMachine
{
    public static void main(String[] args)
    {
        Dispenser d = new Dispenser(100,50);
        CashRegister c = new CashRegister(75);
        sellProduct(d,c);
    }
    public static void sellProduct(Dispenser dis, CashRegister cash)
    {
        if(dis.getCount() != 0 && ((double)dis.getProductCost() / (double)cash.cashOnYou()) > 0)
        {
            System.out.println("Collect your item at the bottom and enjoy.");
        }
        else
        {
            System.out.println("You do not have enough money or they are sold out of candy.");
        }
    }
}
