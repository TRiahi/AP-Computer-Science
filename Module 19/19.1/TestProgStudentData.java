/**
 * run the program
 * 
 * author Bijan Tajmir
 * 
 */
public class TestProgStudentData
{
    public static void main(String[] args)
    {
        double[] scores1 = {89.00, 78.00, 95.00, 63.00, 94.00};
        StudentData john = new StudentData("John","Doe",scores1);
        System.out.println(john.toString(scores1));
        double[] scores2 = {88.00,  90.00, 100.00, 88.00, 90.00, 100.00};
        StudentData lindsay = new StudentData("Lindsay","Green",scores2);
        System.out.println(lindsay.toString(scores2));
    }
}
