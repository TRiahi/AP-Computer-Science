
/**
 * Converts Morse Code into English.
 * 
 * @author Bijan Tajmir
 * @version 3/18/2015
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class MorseCode
{
 public static ArrayList<Character> chars;
 public static ArrayList<String> codes;
 
 /**
  * This Constructor actually imports the list of Morse Code Characters and adds it to an ArrayList.
  */
 public MorseCode(String fileName) throws IOException
 {
    Scanner inFile = new Scanner(new File(fileName));
    char c;
    String code = "";
    String line;
    chars = new ArrayList<Character>();
    codes = new ArrayList<String>();
     while(inFile.hasNext()){
         line = inFile.nextLine();
         c = line.charAt(0);
         code = line.substring(3);
         chars.add(c);
         codes.add(code);
        }
 }
 
 /**
  * This method converts a morse code "char" into an English char.
  * @param String s - The letter of morse code that is being inputted in.
  * @returns char in English.
  */
 public static char getChar(String s){
    int index = codes.indexOf(s);
    return chars.get(index);
 }
 
 /**
  * This method gets the message that is to be converted into English, then converts it.
  * @param String fileName - needs the name of the file it is getting it from.
  * @returns String - The message, in English.
  */
 public static String getMessage(String fileName) throws IOException{
     Scanner inFile = new Scanner(new File(fileName));
     String message = "";
     while(inFile.hasNext()){
     message += getChar(inFile.nextLine());
    }
     return message;
 }
}