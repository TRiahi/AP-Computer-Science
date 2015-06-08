
/**
 * This program uses String objects to replace five phrases in a message with standard cell phone text abbreviations.
 *
 * ©BMT 2014
 * @author Bijan Tajmir 
 * @version 10/5/2014
 */
public class TextMessageV1
{
    public static void main(String [ ] args)
    {
        //psuedocode
        //1.Declare the message as a string object;
        //2.Implement the appropriate abbreviations into the selected phrases;
        //3.Print Message;
        
        //local variables
         String phrase1= "i have to go study as much as possible because this test is a one in a million shot at a scholarship.";
         String Str = new String("i have to go study as much as possible because this test is a one in a million shot at a scholarship.");
       
        //Original Message
         System.out.println("Original Message:");
         System.out.println(phrase1);
         
         //calculating length of message 1 
         int stringLength = phrase1.length();
         System.out.print("Message Length: " + stringLength);
         System.out.print(" characters");
         System.out.println("");
         System.out.println("");
   
        //New Message
        System.out.println("New Message: " );
        String s1 = Str.replaceAll("have to go","G2G");
        String s2 = s1.replaceAll("as much as possible","ASMAP");
        String s3 = s2.replaceAll("because","BC");
        String s4 = s3.replaceAll("one in a million","1NAM");
        String s5 = s4.replaceAll("scholarship","Sch"); 
        System.out.println(s5);
        
        //calcualting length of message 2
        int stringLength2 = s5.length();
        System.out.print("Message Length: " + stringLength2);
        System.out.print(" characters");
        System.out.println("");
        System.out.println("");
       
        //String Method Samples 
        System.out.println("String Method Examples: ");
        
        //indexOf - Prints out zero
        System.out.print("indexOf 'i': ");
        System.out.print(s5.indexOf("i"));
        System.out.println("");
        
        //substring (two parameters)
        System.out.print("substring (two parameters): ");
        System.out.print(s5.substring(0,14));
        System.out.println("");

        //substring (one parameter)
        System.out.print("substring (one parameter): ");
        System.out.print(s5.substring(25));
        System.out.println("");
        
        //replaceAll
        System.out.print("replaceAll RNLSTE's: "); 
        String s6 = s5.replaceAll("t","");
        String s7 = s6.replaceAll("s","");
        System.out.print(s7);   
    }
} 