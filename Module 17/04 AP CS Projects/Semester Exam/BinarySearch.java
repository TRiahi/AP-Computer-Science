// BinarySearch.java
//  Created on December 10, 2004; Recycled May 19, 2005
//  Created by Shahein Tajmir
//	This class implements a recursive Binary Search that will search using
//     integer bounds of an array for a given string. The modifications for this
//     project include searching by specific fields of a book. These porbably
//     could have been implemented much more stylistically, but time
//     interests have prevented this.

public class BinarySearch
{

    // The search method is located below. As arguments, it takes the text to
    //   sought after, the array to look inside, the upper limit, the lower
    //   limit, and the type of search involveed: catalog number, author, or title

    public static int search(String text, Book[] array, int upper, int lower,
                    int type)
    {
        //  Catalog Num Search
        if(type == 0)
        {
            // If the middle term is the sought after value, return the index!
            if(array[(upper + lower) / 2].getCatalogNum().equals(text))
                return ((upper + lower) / 2);

            //  If the search is exhausted and the bugger can't be found
            if(lower == upper && (!text.equals(array[(upper + lower) / 2]
                                            .getCatalogNum())))
                return -1;

            //  Assignment of variables for testing of string lexicography
            boolean before = false, after = false, equal = false;

            //If string at middle of search area is after the search string
            if(array[(upper + lower) / 2].getCatalogNum().compareTo(text) > 0)
                after = true;
            //If string at the middle is before the search string
            else if(array[(upper + lower) / 2].getCatalogNum().compareTo(text) < 0)
                before = true;
            //If string is the same as the search string
            else
                equal = true;

            // If either before or after
            if(after || before)
            {
                if(after)
                    upper = (upper + lower) / 2;
                else
                    lower = (upper + lower) / 2;
            }
            
            //  If the search area contains only two elements
            if(upper - lower == 1) 
            {
                if(array[upper].getCatalogNum().equals(text))
                    return upper;
                else if(array[lower].getCatalogNum().equals(text))
                    return lower;
                else
                    return -1;
            }
        }

        //  Author Search
        else if(type == 1)
        {
            // If the middle term is the sought after value, return the index!
            if(array[(upper + lower) / 2].getAuthor().equals(text))
                return ((upper + lower) / 2);

            //  If the search is exhausted and the bugger can't be found
            if(lower == upper
                            && (!text.equals(array[(upper + lower) / 2].getAuthor())))
                return -1;

            //  Assignment of variables for testing of string lexicography
            boolean before = false, after = false, equal = false;

            //If string at middle of search area is after the search string
            if(array[(upper + lower) / 2].getAuthor().compareTo(text) > 0)
                after = true;
            //If string at the middle is before the search string
            else if(array[(upper + lower) / 2].getAuthor().compareTo(text) < 0)
                before = true;
            //If string is the same as the search string
            else
                equal = true;

            // If either before or after
            if(after || before)
            {
                if(after)
                    upper = (upper + lower) / 2;
                else
                    lower = (upper + lower) / 2;
            }
            //  If the search area contains only two elements
            if(upper - lower == 1)
            {
                if(array[upper].getAuthor().equals(text))
                    return upper;
                else if(array[lower].getAuthor().equals(text))
                    return lower;
                else
                    return -1;
            }
        }
        
        //  Title Search
        else if(type == 2)
        {
            // If the middle term is the sought after value, return the index!
            if(array[(upper + lower) / 2].getTitle().equals(text))
                return ((upper + lower) / 2);

            //  If the search is exhausted and the bugger can't be found
            if(lower == upper
                            && (!text.equals(array[(upper + lower) / 2].getTitle())))
                return -1;

            //  Assignment of variables for testing of string lexicography
            boolean before = false, after = false, equal = false;

            //If string at middle of search area is after the search string
            if(array[(upper + lower) / 2].getTitle().compareTo(text) > 0)
                after = true;
            //If string at the middle is before the search string
            else if(array[(upper + lower) / 2].getTitle().compareTo(text) < 0)
                before = true;
            //If string is the same as the search string
            else
                equal = true;

            // If either before or after
            if(after || before)
            {
                if(after)
                    upper = (upper + lower) / 2;
                else
                    lower = (upper + lower) / 2;
            }
            //  If the search area contains only two elements
            if(upper - lower == 1) 
            {
                if(array[upper - 1].getTitle().equals(text))
                    return upper - 1;
                else if(array[lower].getTitle().equals(text))
                    return lower;
                else
                    return -1;
            }
        }
        // Recursive call of FUN
        return search(text, array, upper, lower, type);

    }
}