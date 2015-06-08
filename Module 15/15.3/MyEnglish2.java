/**
 *
 */
public class MyEnglish2 extends Homework2 implements Processing {

        public MyEnglish2(){
                super();
        }
        
        
        public void createAssignment(int p) {
                setPagesRead(p);
                setType("English");
        }
        
        public String toString(){
                return getType() + "-  must read " + getPagesRead() + " pages.";
        }


		@Override
		public void doReading() {
			System.out.println("Before Reading:");
			System.out.println(toString());
			System.out.println("After Reading:");
			int x = getPagesRead() - 1;
			System.out.println(getType() + " - Must Read " + x + " pages.");
			}

}