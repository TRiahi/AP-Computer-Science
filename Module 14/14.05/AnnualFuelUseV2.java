/**
 * Write a description of class AnnualFuelUse here.
 * 
 * @author Gatlin Newhouse
 * @version 11/12/14
 */
import java.io.*;
import java.text.*;
import java.util.*;
public class AnnualFuelUseV2
{
    //instance variables
    private int fillup, day, startmiles, endmiles;
    private double dis, gallonsused, mpg, prices, cost;
    //constructor for objects
    AnnualFuelUseV2(int fillup, int day, int startmiles, int endmiles, double gallonsused, double prices)
    {
        this.fillup = fillup;
        this.day = day;
        this.startmiles = startmiles;
        this.endmiles = endmiles;
        this.gallonsused = gallonsused;
        this.prices = prices;
        dis = 0.0;
        mpg = 0.0;
        cost = 0.0;
    }
    //calculate distance
    public void calcDistance()
    {
        dis = this.endmiles - this.startmiles;
    }
    //return distance
    public double getDistance()
    {
        return dis;
    }
    //calculate mpg
    public void calcMPG()
    {
        mpg = dis / this.gallonsused;
    }
    //return mpg
    public double getMPG()
    {
        return mpg;
    }
    //calculate cost
    public void calcCost()
    {
        cost = this.prices * this.gallonsused;
    }
    //return cost
    public double getCost()
    {
        return cost;
    }
    //return all the other values
    public int getFill()
    {
        return this.fillup;
    }
    public int getDay()
    {
        return this.day;
    }
    public int getStart()
    {
        return this.startmiles;
    }
    public int getEnd()
    {
        return this.endmiles;
    }
    public double getGallons()
    {
        return this.gallonsused;
    }
    public double getPrice()
    {
        return this.prices;
    }
}