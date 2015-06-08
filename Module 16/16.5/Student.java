/**
 * Student interface (not technically an interface)
 * 
 * @author Bijan Tajmir
 * @version 
 */
import java.util.*;
public class Student
{
    private String name;
    private int qz1;
    private int qz2;
    private int qz3;
    private int qz4;
    private int qz5;
    public Student(String name, int qz1, int qz2, int qz3, int qz4, int qz5)
    {
        this.name = name;
        this.qz1 = qz1;
        this.qz2 = qz2;
        this.qz3 = qz3;
        this.qz4 = qz4;
        this.qz5 = qz5;
    }
    public int getQuiz(int numqz)
    {
        if(numqz == 1)
        {
            return qz1;
        }
        else if(numqz == 2)
        {
            return qz2;
        }
        else if(numqz == 3)
        {
            return qz3;
        }
        else if(numqz == 4)
        {
            return qz4;
        }
        else if(numqz == 5)
        {
            return qz5;
        }
        return 0;
    }
    public void setQuiz(int numqz, int score)
    {
        if(numqz == 1)
        {
            qz1 = score;
        }
        else if(numqz == 2)
        {
            qz2 = score;
        }
        else if(numqz == 3)
        {
            qz3 = score;
        }
        else if(numqz == 4)
        {
            qz4 = score;
        }
        else if(numqz == 5)
        {
            qz5 = score;
        }
        else
        {
            System.out.println("ERROR WRONG QUIZ NUMBER");
        }
    }
    public String getName()
    {
        return name;
    }
    public int getQz1()
    {
        return qz1;
    }
    public int getQz2()
    {
        return qz2;
    }
    public int getQz3()
    {
        return qz3;
    }
    public int getQz4()
    {
        return qz4;
    }
    public int getQz5()
    {
        return qz5;
    }
    public String toString()
    {
        String printme = String.format("%-1s %s %5d %5d %5d %5d %5d \n", getName(),":",getQz1(),getQz2(),getQz3(),getQz4(),getQz5());
        return printme;
    }
    public void replaceName(String newname)
    {
        name = newname;
    }
    public void replaceQuiz(int qznum, int newscore)
    {
        setQuiz(qznum, newscore);
    }
    public void replaceStudent(String newname, int q1, int q2, int q3, int q4, int q5)
    {
        name = newname;
        qz1 = q1;
        qz2 = q2;
        qz3 = q3;
        qz4 = q4;
        qz5 = q5;
    }
}