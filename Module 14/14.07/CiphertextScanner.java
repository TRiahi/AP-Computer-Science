

/**
*This class reads the Ciphertext file, and calculates the frequency of the letters.
*@author Bijan Tajmir
*@version 3/15/2015
*
*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class CiphertextScanner {
	
	private String filename;
	public int counter;

	public CiphertextScanner(String filename){
		this.filename = filename;
		
	}
	/**
	 * This method returns an ArrayList<String> containing the .txt that is to be read.
	 * @return ArrayList<String> cipherTextMessage -
	 *  The entire text file, saved in an ArrayList<String>.
	 * @throws IOException
	 */
	public ArrayList<String> getCipherText() throws IOException{
		ArrayList<String> ciphertextMessage = new ArrayList<String>();
		Scanner inFile = new Scanner(new File(filename));
		while(inFile.hasNext()){
			ciphertextMessage.add(inFile.next() + " ");
		}
		inFile.close();
		return ciphertextMessage;
	}
	
	
    /**
     * This method returns the frequencies of each letter.
     * @return int[] frequencies - the frequency of each letter.
     */
    public int[] getFrequency() throws IOException{
            int[] frequencies = new int[26];
            ArrayList<String> plaintext = getCipherText();
            
            for(String s : plaintext){
                    for(int i = 0; i < s.length(); i++){
                    	char letter = Character.toLowerCase(s.charAt(i));
                    	if(letter >= 'a' && letter <= 'z'){
                    	
                            frequencies[letter - 'a']++;
                    	}
              }
            }
            return frequencies;
    }
	

}
    