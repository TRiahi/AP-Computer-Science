public class MyEnglish extends Homework {

        public MyEnglish(){
                super();
        }
        
        
        public void createAssignment(int p) {
                setPagesRead(p);
                setType("English");
        }
        
        public String toString(){
                return getType() + "-  must read " + getPagesRead() + " pages.";
        }

}