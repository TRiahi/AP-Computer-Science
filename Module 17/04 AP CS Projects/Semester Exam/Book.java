// Book.java
// Created by Shahein Tajmir
// May 15, 2005
// Class that encapsulates a book

import java.io.*;

public class Book implements Serializable 
{
    //  Bunches of data fields..  Self-explanator I think
    protected String author, title, genre, binding, catalogNum;
    protected int quantity, reorderPoint, tracker;
    protected double wholesalePrice, retailPrice;
    
    //  Constructor of doom!  Look at that evil paramater list!
    public Book(String author, String title, String genre, String binding, 
                    String catalogNum, int quantity, int reorderPoint, 
                    double wholesalePrice, double retailPrice)
    {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.binding = binding;
        this.catalogNum = catalogNum;
        this.quantity = quantity;
        this.reorderPoint = reorderPoint;
        this.tracker = 0;
        this.wholesalePrice = wholesalePrice;
        this.retailPrice = retailPrice;
    }
    
    //******************************************************************************
    //  Accessor methods - all self explanatory
    //******************************************************************************
    public String getAuthor()
    {
        return author;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getGenre()
    {
        return genre;
    }
    
    public String getBinding()
    {
        return binding;
    }
    
    public String getCatalogNum()
    {
        return catalogNum;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public int getReorderPoint()
    {
        return reorderPoint;
    }
    
    public int getTracker()
    {
        return tracker;
    }
    
    public double getWholesalePrice()
    {
        return wholesalePrice;
    }
    
    public double getRetailPrice()
    {
        return retailPrice;
    }
    
    public void setQuantity(int x)
    {
        quantity = x;
    }
    
    public void setTracker(int x)
    {
        tracker = x;
    }
    
    public String toString()
    {
        return author + " " + wholesalePrice + " " + retailPrice;
    }
}
