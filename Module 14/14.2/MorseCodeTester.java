
/**
 * Class that prints the translated message.
 * 
 * @author Bijan Tajmir
 * @version 3/18/2015
 */
import java.io.*;
public class MorseCodeTester
{
    public static void main(String[] args) throws IOException
    {
        MorseCode m = new MorseCode("morsecodereference.txt");
        System.out.println(m.getMessage("morsecodemessage.txt"));
    }
}