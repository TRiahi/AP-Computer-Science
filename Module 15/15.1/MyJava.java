public class MyJava extends Homework {

        public MyJava(){
                super();
        }
        
        
        public void createAssignment(int p) {
                setPagesRead(p);
                setType("Java");
        }
        
        public String toString(){
                return getType() + "-  must read " + getPagesRead() + " pages.";
        }

}