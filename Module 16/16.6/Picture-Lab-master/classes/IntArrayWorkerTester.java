public class IntArrayWorkerTester
{
  /** method to test setMatrix */
  public static void testSetMatrix()
  {
    IntArrayWorker worker = new IntArrayWorker();
    int[][] nums = {{1, 1, 1} ,{2,2,2}};
    worker.setMatrix(nums);
    System.out.println("This should have all 1's in first row and all 2's in second");
    worker.print();
  }
  
  /** Method to test fillPattern1 */
  public static void testFillPattern1()
  {
    IntArrayWorker worker = new IntArrayWorker();
    int[][] nums = new int[3][4];
    worker.setMatrix(nums);
    worker.fillPattern1();
    System.out.println("fills with 2's on diagonal, 3's to left, and 1's to right");
    worker.print();
  }
  
  /** Method to test getCount*/
 public static void testGetCount()
 {
   IntArrayWorker worker = new IntArrayWorker();
   int[][] nums = new int[3][4];
   worker.setMatrix(nums);
   worker.fillPattern1();
   int count = worker.getCount(1);
   System.out.println("Count should be 6 and count is " + count);
 }
  
  /** Method to test getTotal */
  public static void testGetTotal()
  {
    IntArrayWorker worker = new IntArrayWorker();
    int [][] nums2 = {{1, 2, 3}, {4, 5, 6}};
    worker.setMatrix(nums2);
    int total = worker.getTotal();
    System.out.println("Total should be 21 and is " + total);
  }
  
  /** Method to test getTotalNested */
  public static void testGetTotalNested()
  {
    IntArrayWorker worker = new IntArrayWorker();
    int [][] nums2 = {{1, 2, 3}, {4, 5, 6}};
    worker.setMatrix(nums2);
    int total = worker.getTotalNested();
    System.out.println("Total should be 21 and is " + total);
  }
  
  /** Method to test getLargest */
 public static void testGetLargest()
 { // test when largest is last
   IntArrayWorker worker = new IntArrayWorker();
   int [][] nums2 = {{1, 2, 3}, {4, 5, 6}};
   worker.setMatrix(nums2);
   int largest = worker.getLargest();
   System.out.println("Largest should be 6 and is " + largest); 
   // test when largest is first
   int[][] nums3 = {{6, 2, 3}, {4, 5, 1}};
   worker.setMatrix(nums3);
   largest = worker.getLargest();
   System.out.println("Largest should be 6 and is " + largest); 
   // test when largest is in the middle
   int[][] nums4 = {{1, 2, 3}, {6, 5, 1}};
   worker.setMatrix(nums4);
   largest = worker.getLargest();
   System.out.println("Largest should be 6 and is " + largest);
   // test when duplicate largest
   int[][] nums5 = {{6, 2, 6}, {4, 5, 1}};
   worker.setMatrix(nums5);
   largest = worker.getLargest();
   System.out.println("Largest should be 6 and is " + largest);
 }
  
  /** Method to test getColTotal */
 public static void testGetColTotal()
 {
   IntArrayWorker worker = new IntArrayWorker();
   int [][] nums2 = {{1, 2, 3}, {4, 5, 6}};
   worker.setMatrix(nums2);
   int total = worker.getColTotal(0);
   System.out.println("Total for column 0 should be 5 and is " + total);
   total = worker.getColTotal(1);
   System.out.println("Total for column 1 should be 7 and is " + total);
   total = worker.getColTotal(2);
   System.out.println("Total for column 2 should be 9 and is " + total);
 }
  
  public static void main(String[] args)
  {
    testSetMatrix();
    testFillPattern1();
    testGetCount(); 
    testGetTotal();
    testGetTotalNested();
    testGetLargest();
    testGetColTotal();
  }
}