
/**
 * @author Bijan Tajmir
 * @version 3/18/2015
 *
 */
import java.util.Scanner;
public class CaesarCipher {
	public static boolean running = true;
	public static Scanner in = new Scanner(System.in);

	/**
	 * This method encrypts the given String, by "shift" amount of Characters.
	 * @param message - The String that is to be Encrypted.
	 * @param shift - The amount of Characters that the String is to be shifted.
	 * @return The Encrypted String.
	 */
    public static String encrypt(String message, int shift)
    {
        char shiftedChar;
        String encryptedMessage = "";
    	if(!(shift > 26) && !(shift < 0)){
        for(int i = 0; i < message.length(); i++){
            char nextChar = message.charAt(i);
            if((0 <= (nextChar + shift)) && ('a' + 25 >= (nextChar + shift))){
                shiftedChar = (char)(nextChar + (shift));
                encryptedMessage += shiftedChar;
            }
            else{
                shiftedChar = (char)((nextChar + shift) - 26);
                encryptedMessage += shiftedChar;
            }
        }
        return encryptedMessage;
    	}
    	
    	else{
    		System.out.println("Sorry, the number chosen was greater than 26, or less than one!");
    		return "Unable to Encrypt";
    	}
    }
	
	/**
	 * This method Decrypts the given String, by "shift" amount of Characters.
	 * @param message - The String that is to be Decrypted.
	 * @param shift - The amount of Characters that the String is to be shifted.
	 * @return The Decrypted String.
	 */
	public static String decrypt(String message, int shift)
	{
		String decryptedMessage = "";
		char shiftedChar;
    	if(!(shift > 26) && !(shift < 0)){
		for(int i = 0; i < message.length(); i++){
			char nextChar = message.charAt(i);
			if((0 <= (nextChar + shift)) && ('a' + 25 >= (nextChar + shift))){
			shiftedChar = (char)(nextChar - shift);
			decryptedMessage += shiftedChar;
			}
			else{
				shiftedChar = (char)((nextChar - shift) + 26);
				decryptedMessage += shiftedChar;
			}
		}
		return decryptedMessage;
		}
		else{
    		System.out.println("Sorry, the number chosen was greater than 26, or less than one!");
    		return "Unable to Decrypt!";
		}
	}
	/**
	 * Main method for the CaesarCipher Class.
	 * @param args
	 */
	public static void main(String[] args)
	{
		while(running == true){
		System.out.println("Press 1 to Encrypt, 2 to Decrypt, or 3 to quit.");
        int input = Integer.valueOf(in.nextLine());
			if(input == 3){
				break;
			}
			if(input == 1){
				System.out.println("Enter your message: ");
				String message = in.nextLine();
				System.out.println("Enter the amount of characters you want to shift by (1-26): ");
				int shift = Integer.valueOf(in.nextLine());
				String encryptedMessage = encrypt(message, shift);
				System.out.println("Your Encrypted Message is: " + encryptedMessage);
				tryAgain();
		    }
		else if(input == 2){
			System.out.println("Enter your encrypted message: ");
			String message = in.nextLine();
			System.out.println("Enter the amount of characters the encrypted string is shifted by (1-26): ");
			int shift = Integer.valueOf(in.nextLine());
			String encryptedMessage = decrypt(message, shift);
			System.out.println("Your Decrypted Message is: " + encryptedMessage);
			tryAgain();

		}
		else{
			System.out.println("Your input is invalid! Please try again!");
		 }
	   }
	}
	
	public static void tryAgain(){
		System.out.println("Would you like to do anything else? \"Y\" or \"N\"");
		String input = in.nextLine();
		if(input.equalsIgnoreCase("y")){
			running = true;
		}
		else{
			running = false;
		}
	}
}
	