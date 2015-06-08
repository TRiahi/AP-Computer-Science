
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{

    public static void main(String agrs[])
    {

        double[][] d = new double[300][300]; //2x2 DATA ARRAY
        //DATA MATRIX BOUNDS
        int ilb = 0; //x lower bound
        int iub = 99; //x upper bound
        int jlb = 0; //y lower bound
        int jub = 99; //y upper bound

        double[] xcoord = new double[300]; //DATA MATRIX COLUMN COORDS: X
        double[] ycoord = new double[300]; //DATA MATRIX ROW COORDS: Y
        int nl = 25; //number of levels to be contoured
        double[] level = new double[25]; //array storing values to be contoured

        MyClass r = new MyClass();
        //stops the program when window is closed
        r.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        Conrec c = null;
        try
        {
            c = new Conrec(r);
        }
        catch(Exception e)
        {
            
        }

        int i, j;
        for(i = 0; i < nl; i++)
        {
            level[i] = i + 1;
        }

        for(i = ilb; i <= iub; i++)
        {
            xcoord[i] = -1.5 + 0.05 * i;
        }

        for(i = jlb; i <= jub; i++)
        {
            ycoord[i] = -1.5 + 0.05 * i;
        }

        for(i = ilb; i <= iub; i++)
        {
            for(j = jlb; j <= jub; j++)
            {
                d[i][j] = 1 / ((xcoord[i] * xcoord[i] + (ycoord[j] - 0.842)
                                * (ycoord[j] + 0.842))
                                * (xcoord[i] * xcoord[i] + (ycoord[j] - 0.842)
                                                * (ycoord[j] + 0.842)) + (xcoord[i]
                                * (ycoord[j] - 0.824) * 2)
                                * (xcoord[i] * (ycoord[j] - 0.824) * 2));
                //d[i][j] = Math.pow(xcoord[i],2) + Math.pow(ycoord[j], 2);
            }
        }
        c.contour(d, ilb, iub, jlb, jub, xcoord, ycoord, nl, level);

    }

}