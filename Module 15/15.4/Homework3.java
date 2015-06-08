
public abstract class Homework3 implements Comparable<Homework3>{
        
        private int pagesRead;
        private String typeHomework;
        
        public Homework3(){
            pagesRead = 0;
            typeHomework = "None";
            }
        
        
        public int getPagesRead(){
                return pagesRead;
           }
           
        public void setPagesRead(int pages){
            pagesRead = pages;
        }
        
        public String getType(){
                return typeHomework;
        }
        
        public void setType(String type){
            typeHomework = type;
            }
        
        public abstract void createAssignment(int p);
        
        public int compareTo(Homework3 obj){
        	if(pagesRead < obj.pagesRead){
        		return 1;
        	}
        	else if(pagesRead == obj.pagesRead){
        		return 0;
        	}
        	else return -1;
        }
        
        public abstract String toString();
                
}
