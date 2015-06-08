/**
 * Tests Music2
 * 
 * 
 * @author Bijan Tajmir
 * 
 */
public class TestMusic2
{
    public static void main(String[] args)
    {
        int test = 0;
        Music2[] myMusic2 = new Music2[10];
        myMusic2[0] = new Music2("Pieces of You", 1994, "Jewel");
        myMusic2[1] = new Music2("Jagged Little Pill", 1995, "Alanis Morissette");        
        myMusic2[2] = new Music2("What If It's You", 1995, "Reba McEntire");     
        myMusic2[3] = new Music2("Misunderstood", 2001, "Pink");
        myMusic2[4] = new Music2("Laundry Service", 2001, "Shakira");     
        myMusic2[5] = new Music2("Taking the Long Way", 2006, "Dixie Chicks");        
        myMusic2[6] = new Music2("Under My Skin", 2004, "Avril Lavigne");
        myMusic2[7] = new Music2("Let Go", 2002, "Avril Lavigne");     
        myMusic2[8] = new Music2("Let It Go", 2007, "Tim McGraw");     
        myMusic2[9] = new Music2("White Flag", 2004, "Dido");
        printMusic2(myMusic2);
        myMusic2 = insertionSort(myMusic2);
        test = searchTitle(myMusic2, "Misunderstood");
        System.out.println("Search - Title - Misunderstood");
        if (test != -1)
        {
            System.out.println("Found: " + myMusic2[test].gettitle() + ", " + myMusic2[test].getyear() + ", " + myMusic2[test].getsinger());
        }
        else
        {   
            System.out.println("Not found.");
        }
        System.out.println();
        test = searchTitle(myMusic2, "Under Paid");
        System.out.println("Search - Title - Under Paid");
        if (test != -1)
        {
            System.out.println("Found: " + myMusic2[test].gettitle() + ", " + myMusic2[test].getyear() + ", " + myMusic2[test].getsinger());
        }
        else
        {   
            System.out.println("Not found.");
        }
        System.out.println();
        searchYear(myMusic2, 2005);
        searchYear(myMusic2, 2006);
        searchSinger(myMusic2, "Darth Maul");
        searchSinger(myMusic2, "Dido");
    }
    public static void printMusic2(Music2[] r)
    {
        System.out.printf("%-25s%-6s%-20s\n", "Title", "Year", "Singer");
        System.out.println("---------------------------------------------------");
        for(int i = 0; i < r.length; i++)
        {
           System.out.println(r[i]);
        }
        System.out.println();
    }
    public static Music2[] insertionSort(Music2[] r)
    {        
        Music2[] sorted = new Music2[r.length];
        for ( int i = 0 ; i < r.length ; i++ )
        {
            String next = r[i].gettitle();
            int insertindex = 0;
            int k = i;
            while ( k > 0 && insertindex == 0 )
            {
                if ( next.compareTo( sorted[k - 1].gettitle() ) > 0 )
                {
                    insertindex = k;
                }
                else
                {
                    sorted[k] = sorted[k - 1];
                }
                k--;
            }
            sorted[ insertindex ] = r[i];
        }
        return sorted;
    }
    public static int searchTitle(Music2[] r, String toFind )
    {
        int high = r.length;
        int low = -1;
        int probe;

        while ( high - low > 1 )
        {
            probe = ( high + low ) / 2;
            if ( r[probe].gettitle().compareTo(toFind) > 0)
            {    
                high = probe;
            }
            else
            {
                low = probe;
            }
        }
        if ( (low >= 0) && (r[low].gettitle().compareTo(toFind) == 0 ))
        {
            return low;
        }
        else
        {
            return -1;
        }
    }
    public static void searchYear(Music2[] r, int toFind)
    {
        int found = 0;
        
        System.out.println("Search - Year - " + toFind);
        for(int i = 0; i < r.length; i++)
        {
            if (r[i].getyear() == toFind)
            {
                System.out.println("Found: " + r[i].gettitle() + ", " + r[i].getyear() + ", " + r[i].getsinger());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("Not found.");
        }
        System.out.println();
    }
    public static void searchSinger(Music2[] r, String toFind)
    {
        int found = 0;
        
        System.out.println("Search - Singer - " + toFind);
        for(int i = 0; i < r.length; i++)
        {
            if (r[i].getsinger().compareTo(toFind) == 0)
            {
                System.out.println("Found: " + r[i].gettitle() + ", " + r[i].getyear() + ", " + r[i].getsinger());
                found++;
            }
        }
        if (found == 0)
        {
            System.out.println("Not found.");
        }
        System.out.println();
    }
}