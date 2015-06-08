//  BinarySearch.java
//  Created on Nov 16, 2004
//  Created by Shahein Tajmir
//

/**
 * @author Shahein Tajmir
 * 
 * Created on Nov 16, 2004
 */
public class BinarySearch
{

    public static void main(String[] args)
    {
        int integers[] = new int[10];

        for (int i = 0; i < 10; i++)
            integers[i] = 10 * i;

        int a = BinarySearch.search(10, integers, integers.length, 0);
        System.out.println(a);

    }

    static int search(int num, int[] array, int upper, int lower)
    {
        if (array[(upper + lower) / 2] == num)
            return ((upper + lower) / 2);
        if (lower == upper && num != array[(upper + lower) / 2])
            return -1;
        if (array[(upper + lower) / 2] > num
                || array[(upper + lower) / 2] < num)
        {
            if (array[(upper + lower) / 2] > num)
                upper = (upper + lower) / 2;
            else
                lower = (upper + lower) / 2;
        }
        if (upper - lower == 1)
        {
            if (array[upper] == num)
                return upper;
            else if (array[lower] == num)
                return lower;
            else
                return -1;
        }
        return search(num, array, upper, lower);

    }
}