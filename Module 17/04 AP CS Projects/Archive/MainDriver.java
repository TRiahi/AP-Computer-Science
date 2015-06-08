//  MainDriver.java
//  Created on Nov 15, 2004
//  Created by Shahein Tajmir
//  This uses the classes Book, reference, and Periodical in a nice little driver program

/**
 * @author Shahein Tajmir
 *
 * Created on Nov 15, 2004
 */
public class MainDriver
{

    public static void main(String[] args)
    {
        Book book1 = new Book("Rubaiyat", "Harvard Press", "Cambridge", 346, "Omar Khayyam",
                2003);
        Reference ref1 = new Reference("Webster's New World Dictionary", "Webster", 
                "New York", 1025, "Webster, Inc.", 2004, "Dictionary");
        Periodical time = new Periodical("Time", "Time Warner", "New York", 95, "Magazine",
                19, 2, 31);
        System.out.println(book1);
        System.out.println("-----------------------------------------------");
        System.out.println(ref1);
        System.out.println("-----------------------------------------------");
        System.out.println(time);
    }
}
