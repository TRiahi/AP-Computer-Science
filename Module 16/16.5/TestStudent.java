/**
 * Run the student grade program
 * 
 * @author Bijan Tajmir
 * @version 
 */
import java.util.*;
public class TestStudent
{
    public static void main(String[] args)
    {
        //start original results
        System.out.println("Starting Gradebook:");
        System.out.println();
        ArrayList<Student> myClass = new ArrayList<Student>();
        Student mark = new Student("Mark Kennedy",70,80,90,100,90);
        myClass.add(mark);
        Student max = new Student("Max Gerard",80,85,90,85,80);
        myClass.add(max);
        Student jean = new Student("Jean Smith",50,79,89,99,100);
        myClass.add(jean);
        Student betty = new Student("Betty Farm",85,80,85,88,89);
        myClass.add(betty);
        Student dilbert = new Student("Dilbert Gamma",70,70,90,70,80);
        myClass.add(dilbert);
        printBook(myClass);
        //end of original results
        //replaced name results
        System.out.println();
        System.out.println("Changing Betty's name to Betty Boop:");
        betty.replaceName("Betty Boop");
        System.out.println();
        printBook(myClass);
        //replace quiz results
        System.out.println();
        System.out.println("Changing Jean's quiz 1 score to 80:");
        jean.replaceQuiz(1, 80);
        System.out.println();
        printBook(myClass);
        //replace student results
        System.out.println();
        System.out.println("Replacing Dilbert with Mike Kappa: 80, 80, 80, 90, 90:");
        dilbert.replaceStudent("Mike Kappa",80,80,80,90,90);
        System.out.println();
        printBook(myClass);
        //insert new student
        System.out.println();
        System.out.println("Inserting Lily Mu: 85, 95, 70, 0, 100 before Betty:");
        insertStudent(myClass, "Betty Boop", "Lily Mu", 85, 95, 70, 0, 100);
        System.out.println();
        printBook(myClass);
        //delete a student
        System.out.println();
        System.out.println("Deleting Max Gerard:");
        deleteStudent(myClass, "Max Gerard");
        System.out.println();
        printBook(myClass);
    }
    public static void printBook(ArrayList<Student> classScores)
    {
        System.out.printf("%s %5s %5s %5s %5s %5s \n","Student name","Q1","Q2","Q3","Q4","Q5");
        System.out.println("-------------------------------------------");
        for(Student t : classScores)
        {
            System.out.print(t.toString());
        }
    }
    public static void insertStudent(ArrayList<Student> classlist, String find, String newname,
                                     int q1, int q2, int q3, int q4, int q5)
    {
        int location = 0;
        for(int i=0; i<classlist.size();i++)
        {
            if(classlist.get(i).getName().equals(find))
            {
                location = i;
                break;
            }
        }
        classlist.add(location, new Student(newname, q1, q2, q3, q4, q5));
    }
    public static void deleteStudent(ArrayList<Student> classlist, String find)
    {
        int location = 0;
        int i;
        for(i=0;i<classlist.size();i++)
        {
            if(classlist.get(i).getName().equals(find))
            {
                location = i;
                break;
            }
        }
        if(i != classlist.size())
        {
            classlist.remove(location);
        }
    }
}