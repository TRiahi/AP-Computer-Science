public class MyMath extends Homework {

        public MyMath(){
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