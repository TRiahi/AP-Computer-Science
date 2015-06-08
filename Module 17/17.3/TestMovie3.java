/**
 * run the program
 * 
 * @author Bijan Tajmir
 * 
 */
import java.lang.*;
public class TestMovie3
{
    public static void main(String[] args)
    {
        Movie3 muppets = new Movie3("The Muppets Take Mahattan",2001,"Columbia Tristar");
        Movie3 mulan = new Movie3("Mulan Special Edition",2004,"Disney");
        Movie3 shrek = new Movie3("Shrek 2",2004,"Dreamworks");
        Movie3 incredibles = new Movie3("The Incredibles",2004,"Pixar");
        Movie3 nanny = new Movie3("Nanny McPhee",2006,"Universal");
        Movie3 rabbit = new Movie3("The Curse of Were-Rabbit", 2006,"Aardman");
        Movie3 iceage = new Movie3("Ice Age",2002,"20th Century Fox");
        Movie3 lilo = new Movie3("Lilo & Stitch",2002,"Disney");
        Movie3 robots = new Movie3("Robots",2005,"20th Century Fox");
        Movie3 monsters = new Movie3("Monsters Inc.",2001,"Pixar");
        Movie3[] movies = new Movie3[] {muppets, mulan, shrek, incredibles, nanny, rabbit, 
                                        iceage, lilo, robots, monsters};
        Movie3[] newmovies = new Movie3[movies.length];
        System.out.println("Before Sorting:");
        printMovies(movies);
        System.out.println();
        System.out.println("Sorted by Title - ascending:");
        sortTitles(movies,1);
        printMovies(movies);
        System.out.println();
        System.out.println("Sorted by Year - descending:");
        sortYears(movies,2);
        printMovies(movies);
        System.out.println();
        System.out.println("Sorted by Studios:");
        sortStudios(movies,1);
        printMovies(movies);
    }
    public static void printMovies(Movie3[] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            System.out.println(a[i].toString());
        }
    }
    public static void sortTitles(Movie3[] a, int b)
    {
        if(b==1)
        {
            for (int i = 0; i < a.length - 1; ++i)
            {
                int minIndex = i;
                for (int j = i + 1; j < a.length; ++j)
                {
                    if ((a[j].getStudio()).compareTo(a[minIndex].getStudio()) < 0)
                    {
                        minIndex = j;
                    }
                }
                Movie3 temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        else if (b==2)
        {
            for (int i = 0; i < a.length - 1; ++i)
            {
                int minIndex = i;
                for (int j = i + 1; j < a.length; ++j)
                {
                    if ((a[j].getStudio()).compareTo(a[minIndex].getStudio()) > 0)
                    {
                        minIndex = j;
                    }
                }
                Movie3 temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        else
        {
            System.out.println("ERROR");
        }
    }
    public static void sortYears(Movie3[] a, int b)
    {
        Movie3 temp;
        int i;
        int k;
        int posmax;
        if(b==1)
        {
            for ( i = a.length - 1 ; i > 0 ; i-- )
            {
                posmax = 0;
                for ( k = 1 ; k <= i ; k++ )
                {
                    if ( a[ k ].getYear() > a[ posmax ].getYear() )
                    {
                        posmax = k;
                    }
                }
                temp = a[ i ];
                a[ i ] = a[posmax ];
                a[ posmax ] = temp;
            }
        }
        else if (b==2)
        {
            for ( i = a.length - 1 ; i > 0 ; i-- )
            {
                posmax = 0;
                for ( k = 1 ; k <= i ; k++ )
                {
                    if ( a[ k ].getYear() < a[ posmax ].getYear() )
                    {
                        posmax = k;
                    }
                }
                temp = a[ i ];
                a[ i ] = a[posmax ];
                a[ posmax ] = temp;
            }
        }
        else
        {
            System.out.println("ERROR");
        }
    }
    public static void sortStudios(Movie3[] a, int b)
    {
        if(b==1)
        {
            for (int i = 0; i < a.length - 1; ++i)
            {
                int minIndex = i;
                for (int j = i + 1; j < a.length; ++j)
                {
                    if ((a[j].getStudio()).compareTo(a[minIndex].getStudio()) < 0)
                    {
                        minIndex = j;
                    }
                }
                Movie3 temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        else if (b==2)
        {
            for (int i = 0; i < a.length - 1; ++i)
            {
                int minIndex = i;
                for (int j = i + 1; j < a.length; ++j)
                {
                    if ((a[j].getStudio()).compareTo(a[minIndex].getStudio()) > 0)
                    {
                        minIndex = j;
                    }
                }
                Movie3 temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        else
        {
            System.out.println("ERROR");
        }
    }
}
