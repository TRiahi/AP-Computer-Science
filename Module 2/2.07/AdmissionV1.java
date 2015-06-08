
/**
 * The purpose of this program is to count the number of
 * tickets sold and the amount of money received.
 * 
 * ©FLVS 2007
 * @author B. Jordan 
 * @version 2/28/07
 */
public class AdmissionV1
{
    public static void main(String[ ] args)
    {
        //local variables       
        int counter = 0;            //total tickets sold
        double totalSales = 0.0;    //total sales
        double ticketPrice = 0.0;   //cost of student ticket
               
        //calculate total ticket sales at the game
        ticketPrice = 5.50;         //ticket price
        totalSales += ticketPrice;
        counter++;
        System.out.print(" Number of tickets = " + counter);
        System.out.println("   Total Sales: " + totalSales);   
        
        //calculate total ticket sales at the game
        ticketPrice = 5.50;         //ticket price
        totalSales += ticketPrice;
        counter++;
        System.out.print(" Number of tickets = " + counter);
        System.out.println("   Total Sales: " + totalSales);   
        
        //calculate total ticket sales at the game
        ticketPrice = 5.50;         //ticket price
        totalSales += ticketPrice;
        counter++;
        System.out.print(" Number of tickets = " + counter);
        System.out.println("   Total Sales: " + totalSales);   
               
    }//end of main method
}//end of class
