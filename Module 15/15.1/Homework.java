
public abstract class Homework {
        
        private int pagesRead;
        private String typeHomework;
        
        public Homework(){
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
                
}
