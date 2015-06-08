/**

 */
public class MyMath3 extends Homework3 {

        public MyMath3(){
                super();
        }
        
        
        public void createAssignment(int p) {
                setPagesRead(p);
                setType("Math");
        }
        
        public String toString(){
                return getType() + "-  must read " + getPagesRead() + " pages.";
        }

}