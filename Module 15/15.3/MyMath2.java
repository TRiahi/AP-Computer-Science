/**

 */
public class MyMath2 extends Homework2 implements Processing {

        public MyMath2(){
                super();
        }
        
        
        public void createAssignment(int p) {
                setPagesRead(p);
                setType("Math");
        }
        
        public String toString(){
                return getType() + "-  must read " + getPagesRead() + " pages.";
        }


		@Override
		public void doReading() {
			System.out.println("Before Reading:");
			System.out.println(toString());
			System.out.println("After Reading:");
			int x = getPagesRead() - 2;
			System.out.println(getType() + " - Must Read " + x + " pages.");
			}

}