/**
 * the dispenser
 * 
 * @author Bijan Tajmir
 * 
 */
public class Dispenser
{
    private int numberOfItem;
    private int cost;
    public Dispenser()
    {
        numberOfItem = 50;
        cost = 50;
    }
    public Dispenser(int items, int cst)
    {
        if(items > 0)
        {
            numberOfItem = items;
        }
        else
        {
            throw new IllegalArgumentException("You must have more than zero items");
        }
        if(cst > 0)
        {
            cost = cst;
        }
        else
        {
            throw new IllegalArgumentException("They can't be free!");
        }
    }
    public int getCount()
    {
        return numberOfItem;
    }
    public int getProductCost()
    {
        return cost;
    }
    public void makeSale()
    {
        numberOfItem--;
    }
}
