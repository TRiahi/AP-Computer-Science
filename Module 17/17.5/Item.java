/**
 * Item Interface
 * 
 * @author Bijan Tajmir
 * 
 */
public class Item
{
    private String itemID;
    private String itemName;
    private int inStore;
    private double price;
    public Item(String itemID, String itemName, int inStore, double price)
    {
        this.itemID = itemID;
        this.itemName = itemName;
        this.inStore = inStore;
        this.price = price;
    }
    public String toString()
    {
        String string = itemID + "  " + itemName + "  " + inStore + "  $ " + price;
        return string;
    }
    public String getID()
    {
        return itemID;
    }
    public int getStore()
    {
        return inStore;
    }
    public String getName()
    {
        return itemName;
    }
    public double getPrice()
    {
        return price;
    }
}