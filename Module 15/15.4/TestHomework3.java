
import java.util.ArrayList;
/**
 
 */
public class TestHomework3 {
        public static void main(String[] args){
                MyMath3 m = new MyMath3();
                m.createAssignment(8);
                
                MyScience3 s = new MyScience3();
                s.createAssignment(8);
                
                MyEnglish3 e = new MyEnglish3();
                e.createAssignment(19);
                
                MyJava3 j = new MyJava3();
                j.createAssignment(5);
                
                
                ArrayList<Homework3> hw = new ArrayList<Homework3>();
                hw.add(m);
                hw.add(s);
                hw.add(e);
                hw.add(j);
                for(Homework3 c : hw){
                        System.out.println(c.toString());
                }
                int compare = s.compareTo(m);
                if(compare == 0)
                	System.out.println(m.getType() + " and " + s.getType() + " have the same assignment Length!");
                else if(compare == 1)
                	System.out.println(m.getType() + " has more work than " + s.getType());
                else
                	System.out.println(m.getType() + " has less work than " + s.getType());
        }
}