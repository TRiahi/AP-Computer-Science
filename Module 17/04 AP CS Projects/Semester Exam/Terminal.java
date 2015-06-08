// Terminal3.java
// Created by Shahein Tajmir
// May 15, 2005
// This class doesn't really encapsulate anything really well. It serves as a
//   class that represents the terminal aspect of the requisite application. 
//   It has a buyBook and lookUp methods that do what it seems like they would do

//  Necessary import statements of doom
import java.util.*;
import java.io.*;
import cs1.Keyboard;
import java.text.*;

public class Terminal
{
    //  Necessary Vectors of Doom
    Vector availableBooks = new Vector(), purchasedBooks = new Vector();
    //  Menu Choice variable of doom
    int mainMenuChoice;

    //  Constructor - 
    //    Reads all books from inventory.dat and makes objects of them
    public Terminal()
    {
        //  Lovely tokenizer of doom
        StringTokenizer token;
        String line, file = "inventory.dat";

        //  Book temp data fields
        String author, title, genre, binding, catalogNum;
        int quantity, reorderPoint, tracker;
        double wholesalePrice, retailPrice;

        try // Error prevention of doom
        {
            FileReader fr = new FileReader(file);
            BufferedReader inFile = new BufferedReader(fr);

            line = inFile.readLine();

            //  Gets every line of the data file
            while(line != null)
            {
                // Extract the info
                token = new StringTokenizer(line, ";");

                author = token.nextToken();
                title = token.nextToken();
                genre = token.nextToken();
                binding = token.nextToken();
                catalogNum = token.nextToken();
                try // Prevent numberformat issues
                {
                    quantity = Integer.parseInt(token.nextToken());
                    reorderPoint = Integer.parseInt(token.nextToken());
                    wholesalePrice = Double.parseDouble(token.nextToken());
                    retailPrice = Double.parseDouble(token.nextToken());
                    availableBooks.add(new Book(author, title, genre, binding,
                                    catalogNum, quantity, reorderPoint,
                                    wholesalePrice, retailPrice));
                }
                catch(NumberFormatException e)
                {
                    System.out
                                    .println("Number Format Exception - Usually a data type conflict");
                }
                line = inFile.readLine();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("inventory.dat - File does not exist");
        }
        catch(IOException e)
        {
            System.out.println("Interrupted access to inventory.dat");
        }

        mainMenu();
    }

    //******************************************************************************
    //  Method that encapsulates the main menu functions
    //******************************************************************************
    public void mainMenu()
    {
        System.out.println("\t\t~~~~Shahein's Stacks (of Books)~~~~");
        System.out.println("Main Menu:");
        System.out.println("\t1)  Buy Books");
        System.out.println("\t2)  Look Up Inventory");
        System.out.println("\t3)  Exit");
        mainMenuChoice = Keyboard.readInt();

        if(mainMenuChoice == 1)
            buyBooks();
        else if(mainMenuChoice == 2)
            lookUp();
        else if(mainMenuChoice == 3)
            return;
    }

    //******************************************************************************
    //  Method that encapsulates all the code involved in buying books
    //******************************************************************************
    public void buyBooks()
    {
        int buyBookChoice = 0, catalogNum, place = 0;
        String key;
        Book[] tempArray = new Book[availableBooks.size()];

        System.out.println("~~~~The Cash Register~~~~");

        while(buyBookChoice != -1)
        {
            if(purchasedBooks.size() != 0)
            {
                System.out.println();
                System.out.println("~~~~~~~~~~~~~~~Shopping Cart~~~~~~~~~~~~~~~~~:");
                for(int i = 0; i < purchasedBooks.size(); i++)
                {
                    Book temp = (Book) purchasedBooks.get(i);
                    System.out.println(temp.getTitle());
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println();
            }
            System.out.println();
            System.out.println("\t1)  Buy Book by Catalog Number");
            System.out.println("\t2)  Buy Book by Title");
            System.out.println("\t3)  Buy Book by Author");
            System.out.println("\t4)  Remove a Title");
            System.out.println("\t5)  Check Out");
            System.out.println("\t6)  Return to Main Menu");
            buyBookChoice = Keyboard.readInt();

            for(int i = 0; i < tempArray.length; i++)
            {
                tempArray[i] = (Book) availableBooks.get(i);
            }

            if(buyBookChoice == 1)
            {
                System.out.println("Type the Book's Catalog Number:  ");
                key = Keyboard.readString();
                MergeSort.sort(tempArray, 0, tempArray.length, 0);
                place = BinarySearch.search(key, tempArray, tempArray.length - 1, 0,
                                0);
            }
            else if(buyBookChoice == 2)
            {
                System.out.println("Type the Book's Title:  ");
                key = Keyboard.readString();
                MergeSort.sort(tempArray, 0, tempArray.length, 2);
                place = BinarySearch.search(key, tempArray, tempArray.length - 1, 0,
                                2);
            }
            else if(buyBookChoice == 3)
            {
                System.out.println("Type the Author's Name:  ");
                key = Keyboard.readString();
                MergeSort.sort(tempArray, 0, tempArray.length, 1);
                place = BinarySearch.search(key, tempArray, tempArray.length - 1, 0,
                                1);

            }
            else if(buyBookChoice == 4)
            {
                System.out.println("Type the Title you'd like to remove:  ");
                key = Keyboard.readString();
                MergeSort.sort(tempArray, 0, tempArray.length, 2);
                place = BinarySearch.search(key, tempArray, tempArray.length - 1, 0,
                                2);
                if(place >= 0)
                {
                    purchasedBooks.remove(tempArray[place]);
                }
            }
            else if(buyBookChoice == 5)
            {
                checkOut();
                buyBookChoice = -1;
            }
            else if(buyBookChoice == 6)
            {
                mainMenu();
                buyBookChoice = -1;
            }

            if(place >= 0 && buyBookChoice != 4)
            {
                purchasedBooks.add(tempArray[place]);
            }
            else if(place < 0 && buyBookChoice != 4)
            {
                System.out.println("**************");
                System.out.println("Book not found");
                System.out.println("**************");
            }
        }
    }

    //******************************************************************************
    //  Method that encapsulates the junk on looking up books
    //******************************************************************************
    public Book lookUp()
    {
        int lookUpChoice = 0, place = 0;
        String key;
        Book[] tempArray = new Book[availableBooks.size()];

        while(lookUpChoice != 3)
        {
            System.out.println("~~~~Inventory Looker Upper~~~~");
            System.out.println("\t1)  By Author");
            System.out.println("\t2)  By Title");
            System.out.println("\t3)  Return to Main Menu");
            lookUpChoice = Keyboard.readInt();

            for(int i = 0; i < tempArray.length; i++)
            {
                tempArray[i] = (Book) availableBooks.get(i);
            }

            if(lookUpChoice == 1)
            {
                System.out.println("Type the Author's Name:  ");
                key = Keyboard.readString();
                MergeSort.sort(tempArray, 0, tempArray.length, 1);
                place = BinarySearch.search(key, tempArray, tempArray.length - 1, 0,
                                1);
                System.out.println("Entries for " + key);
                System.out.println();

                if(place >= 0)
                {
                    System.out.println("Title:  " + tempArray[place].getTitle());
                    System.out.println("Retail Price:  "
                                    + tempArray[place].getRetailPrice());
                    System.out.println("Quantity:  "
                                    + tempArray[place].getQuantity());
                    System.out.println("Catalog Number:  "
                                    + tempArray[place].getCatalogNum());
                }
            }

            else if(lookUpChoice == 2)
            {
                System.out.println("Type the Book's Title:  ");
                key = Keyboard.readString();
                MergeSort.sort(tempArray, 0, tempArray.length, 2);
                place = BinarySearch.search(key, tempArray, tempArray.length - 1, 0,
                                2);
                System.out.println();
                System.out.println("Entries for " + key);

                if(place >= 0)
                {
                    System.out.println("Author:  " + tempArray[place].getAuthor());
                    System.out.println("Retail Price:  "
                                    + tempArray[place].getRetailPrice());
                    System.out.println("Quantity:  "
                                    + tempArray[place].getQuantity());
                    System.out.println("Catalog Number:  "
                                    + tempArray[place].getCatalogNum());
                }
            }

            else if(lookUpChoice == 3)
            {
                mainMenu();
            }

            if(place <= 0)
            {
                System.out.println("**************");
                System.out.println("Book not found");
                System.out.println("**************");
            }

            System.out.println();
        }
        return tempArray[place];
    }

    //******************************************************************************
    //  Method that checks out and prints a receipt
    //******************************************************************************
    public void checkOut()
    {
        double sum = 0;
        String choice;
        DecimalFormat fmt = new DecimalFormat("0.##");

        System.out.println();
        System.out.println("~~~~Sales Receipt of Doom~~~~");
        System.out.println();
        for(int i = 0; i < purchasedBooks.size(); i++)
        {
            Book temp = (Book) purchasedBooks.get(i);
            System.out.println(temp.getTitle() + "\n\t" + temp.getRetailPrice());
            sum += temp.getRetailPrice();
        }
        System.out.println();
        System.out.println("Subtotal:  \t\t" + fmt.format(sum));
        System.out.println("Tax:       \t\t" + fmt.format(sum * .09));
        System.out.println("Total:     \t\t" + fmt.format(sum * 1.09));
        System.out.println();
        System.out.println("Return to Main Menu (Y or N):  ");
        choice = Keyboard.readString();

        if(choice.equalsIgnoreCase("y"))
        {
            mainMenu();
            purchasedBooks.clear(); // empties purchased vector
        }
    }
}