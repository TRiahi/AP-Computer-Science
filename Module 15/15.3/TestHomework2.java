
import java.util.ArrayList;
/**

 */
public class TestHomework2 {
        public static void main(String[] args){
                MyMath2 m = new MyMath2();
                m.createAssignment(8);
                
                MyScience2 s = new MyScience2();
                s.createAssignment(7);
                
                MyEnglish2 e = new MyEnglish2();
                e.createAssignment(19);
                
                MyJava2 j = new MyJava2();
                j.createAssignment(5);
                
                
                ArrayList<Homework2> hw = new ArrayList<Homework2>();
                hw.add(m);
                hw.add(s);
                hw.add(e);
                hw.add(j);
                for(Homework2 c : hw){
                        c.doReading();   
                }
                
        }
}