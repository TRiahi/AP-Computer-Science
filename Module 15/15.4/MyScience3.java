/**

 */
public class MyScience3 extends Homework3 {

        public MyScience3(){
                super();
        }
        
        
        public void createAssignment(int p) {
                setPagesRead(p);
                setType("Science");
        }
        
        public String toString(){
                return getType() + "-  must read " + getPagesRead() + " pages.";
        }


}