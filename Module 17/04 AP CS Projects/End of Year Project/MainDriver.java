// MainDriver.java
//  Created on Nov 15, 2004
//  Created by Shahein Tajmir
//  This uses the classes Book, reference, and Periodical in a nice little driver
// program

import cs1.Keyboard;

public class MainDriver
{

    public static void main(String[] args)
    {
        int menuInput; // Used for Main Menu Input
        String title; // Title input by user used for searching
        ReadingMaterial temp = null; // Used in testing if the title is in the
        // array
        int index; // holds the value that tells where a sought after book is in
        // the array
        int newMaterialType; //Used when creating new reading material
        // instances
        BookList stuff = new BookList(); // class that holds the array and many
        // functions dealing with it
        String mainMenu;

        do
        {
            System.out.println("\t\t\tShahein's Book Store");
            System.out.println("Main Menu:");
            System.out.println("\t1)\tView Books");
            System.out.println("\t2)\tSearch for Book");
            System.out.println("\t3)\tAdd Books");
            System.out.println("\t4)\tExit");
            menuInput = Keyboard.readInt();

            if (menuInput == 1)
            {
                System.out.println(); // blank line
                System.out.println("Titles Available for Searching:  ");
                System.out.println(); // blank line
                stuff.viewContents(); // print out the titles
                //"pause" code - This asks the user if he wants to go back to
                // the main menu. It provides a pause function so the program
                // stops and lets the user read the output.
                System.out.print("Return to Main Menu?  Y or N:  ");
                mainMenu = Keyboard.readString();
                if (mainMenu.equalsIgnoreCase("y"))
                {
                }
                else
                    menuInput = 4;

            }

            else if (menuInput == 2)
            {
                System.out.println(); // white empty line
                System.out
                                .println("Please type the title of the material you are looking for; case does matter:");
                title = Keyboard.readString();

                stuff.sortArray(); //sort array within the Booklist object
                // "stuff"
                index = BinarySearch.search(title, stuff.getArray(),
                                stuff.getArray().length, 0);
                if (index != -1)
                    temp = stuff.get(index);

                System.out.println(); // pretty white space
                System.out.println("Data on \"" + title + "\":");
                if (temp == null)
                {
                    System.out.println("Sorry, that title has not been indexed.  "
                                    + "Please try another title.");
                    System.out.println();
                }
                else
                {
                    System.out.println(temp);
                    System.out.println();
                }
                //              "pause" code
                System.out.print("Return to Main Menu?  Y or N:  ");
                mainMenu = Keyboard.readString();
                if (mainMenu.equalsIgnoreCase("y"))
                {
                }
                else
                    menuInput = 4;
            }

            else if (menuInput == 3)
            {
                System.out.println();
                System.out.println("Please choose the type of Reading Material:");
                System.out.println("\t1)\tBook");
                System.out.println("\t2)\tPeriodical");
                System.out.println("\t3)\tReference");
                System.out.println("\t4)\tReturn to Menu");
                newMaterialType = Keyboard.readInt();

                if (newMaterialType == 1)
                {
                    stuff.createNewBook();
                }
                else if (newMaterialType == 2)
                {
                    stuff.createNewPeriodical();
                }
                else if (newMaterialType == 3)
                {
                    stuff.createNewReference();
                }
                else
                {
                    System.out.println("Invalid Input.  Returning to Main Menu");
                }

                // "pause" code
                System.out.print("Return to Main Menu?  Y or N:  ");
                mainMenu = Keyboard.readString();
                if (mainMenu.equalsIgnoreCase("y"))
                {
                }
                else
                    menuInput = 4;
            }
            else if (menuInput == 4)
            {

            }
            else
            {
                menuInput = 5;
                System.out.println("Invalid Input.  Returning to Main Menu.");
            }

        } while (menuInput != 4);
    }
}