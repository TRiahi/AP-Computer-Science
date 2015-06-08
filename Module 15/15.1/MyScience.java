public class MyScience extends Homework {

        public MyScience(){
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