
import java.util.ArrayList;
public class testHomework {
        public static void main(String[] args){
                MyMath m = new MyMath();
                m.createAssignment(5);
                
                MyScience s = new MyScience();
                s.createAssignment(7);
                
                MyEnglish e = new MyEnglish();
                e.createAssignment(9001);
                
                MyJava j = new MyJava();
                j.createAssignment(1);
                
                
                ArrayList<Homework> hw = new ArrayList<Homework>();
                hw.add(m);
                hw.add(s);
                hw.add(e);
                hw.add(j);
                for(Homework c : hw){
                        System.out.println(c.toString());
                        
                }
                
        }
}
