// BookList.java
//	Created on December 10, 2004
//	Created by Shahein Tajmir
//	This class holds the array of books and the methods involved with
// manipulating the array such as: resizing, adding additional elements,
// printing the contents, returning the array inside, returning an object held
// in the array, sorting the array, and creating new instances of the book,
// periodical, and reference classes

import cs1.Keyboard;

public class BookList
{
    private ReadingMaterial[] list;

    //  Constructor: Gives default values for 8 items of reading
    BookList()
    {
        list = new ReadingMaterial[8];

        list[0] = new Book("Rubaiyat", "Harvard Press", "Cambridge", 346, "Omar Khayyam",
                        2003);
        list[1] = new Periodical("Time", "Time Warner", "New York", 95, 1, 19, "II", "31");
        list[2] = new Periodical("The Birmingham News", "The Birmingham News",
                        "Birmingham", 18, 2, 21, "IV", "18");
        list[3] = new Periodical("The New England Journal of Medicine",
                        "New England Corp.", "Boston", 28, 3, 20, "VII", "15");
        list[4] = new Reference("Webster's New World Dictionary", "Webster", "New York",
                        1025, "Webster, Inc.", 2004, 1);
        list[5] = new Reference("WorldBook Encyclopedia", "WorldBook", "New York", 21852,
                        "WorldBook, Inc.", 2003, 2);
        list[6] = new Reference("Poor Richard's Almanack", "Benjamin Franklin",
                        "Philadelphia", 876, "Classic Books, Inc.", 1796, 3);
        list[7] = new Reference("Roget's New World Thesarus", "Roget", "Chicago", 1039,
                        "Roget's Inc.", 2004, 4);
    }

    //  Increases the Array by one slot by copying to a temp array, then
    // reassigning the original handle to the new array
    private void resizeArray()
    {
        ReadingMaterial[] temp = new ReadingMaterial[list.length + 1];

        for (int i = 0; i < list.length; i++)
            temp[i] = list[i];

        list = temp;
    }

    //  Adds the passed reading material instance to the array that holds all the
    // instances
    public void addElement(ReadingMaterial x)
    {
        resizeArray(); // makes an empty spot for the new object

        list[list.length - 1] = x; // adds to array
    }

    //  Prints out the titles of the contents of the array
    public void viewContents()
    {
        for (int i = 0; i < list.length; i++)
            System.out.println(list[i].getTitle());
        System.out.println();//blank line
    }

    //  Return the array held inside
    public ReadingMaterial[] getArray()
    {
        return list;
    }

    //Returns item at that index in the array
    public ReadingMaterial get(int index)
    {
        return list[index];
    }

    //  Public accessor function that sorts the array
    public void sortArray()
    {
        MergeSort.sort(list, 0, list.length);
    }

    //*************************************************************************************
    //Functions for creating new books, periodicals, and references
    //*************************************************************************************
    //Asks user for a book data field information
    public void createNewBook()
    {
        String title, publisher, publishedCity;
        int totalPages;
        String author;
        int copyrightYear;
        Book temp;

        //Get info
        System.out.println();
        System.out.println("Please fill in the following fields:");
        System.out.print("Title:  ");
        title = Keyboard.readString();
        System.out.print("Publisher:  ");
        publisher = Keyboard.readString();
        System.out.print("Publishing City:  ");
        publishedCity = Keyboard.readString();
        System.out.print("Page Total:  ");
        totalPages = Keyboard.readInt();
        System.out.print("Author:  ");
        author = Keyboard.readString();
        System.out.print("Copyright Year:  ");
        copyrightYear = Keyboard.readInt();

        //Create book
        temp = new Book(title, publisher, publishedCity, totalPages, author,
                        copyrightYear);
        //Add book to array
        addElement(temp);
    }

    //  Asks user to fill in periodical data fields
    public void createNewPeriodical()
    {
        String title, publisher, publishedCity;
        int totalPages, typeOfPeriodical, numberOfArticles;
        String volume, issue;
        Periodical temp;

        //Get info
        System.out.println();
        System.out.println("Please fill in the following fields:");
        System.out.println("Type of Periodical:  ");
        System.out.println("\t1)\tMagazine");
        System.out.println("\t2)\tNewspaper");
        System.out.println("\t3)\tJournal");
        typeOfPeriodical = Keyboard.readInt();
        System.out.print("Title:  ");
        title = Keyboard.readString();
        System.out.print("Publisher:  ");
        publisher = Keyboard.readString();
        System.out.print("Publishing City:  ");
        publishedCity = Keyboard.readString();
        System.out.print("Page Total:  ");
        totalPages = Keyboard.readInt();
        System.out.print("Number of Articles:  ");
        numberOfArticles = Keyboard.readInt();
        System.out.print("Volume Number:  ");
        volume = Keyboard.readString();
        System.out.print("Copyright Year:  ");
        issue = Keyboard.readString();

        //Create book
        temp = new Periodical(title, publisher, publishedCity, totalPages,
                        typeOfPeriodical, numberOfArticles, volume, issue);
        //Add book to array
        addElement(temp);
    }

    //  Asks user to fill in periodical data fields
    public void createNewReference()
    {
        String title, publisher, publishedCity;
        int totalPages;
        String author;
        int copyrightYear, typeOfReference;
        Reference temp;

        //Get info
        System.out.println();
        System.out.println("Please fill in the following fields:");
        System.out.println("Type of Reference:  ");
        System.out.println("\t1)\tDictionary");
        System.out.println("\t2)\tEncyclopedia");
        System.out.println("\t3)\tAlmanac");
        System.out.println("\t4)\tThesarus");
        typeOfReference = Keyboard.readInt();
        System.out.print("Title:  ");
        title = Keyboard.readString();
        System.out.print("Publisher:  ");
        publisher = Keyboard.readString();
        System.out.print("Publishing City:  ");
        publishedCity = Keyboard.readString();
        System.out.print("Page Total:  ");
        totalPages = Keyboard.readInt();
        System.out.print("Author:  ");
        author = Keyboard.readString();
        System.out.print("Copyright Year:  ");
        copyrightYear = Keyboard.readInt();

        //Create book
        temp = new Reference(title, publisher, publishedCity, totalPages, author,
                        copyrightYear, typeOfReference);
        //Add reference to array
        addElement(temp);
    }
}