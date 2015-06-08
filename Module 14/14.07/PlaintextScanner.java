
/**
* This class reads a Plaintext file, and calculates the frequency of the letters.
*@author Bijan Tajmir
*@version 3/13/2015
*/
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class PlaintextScanner {
	
	private String filename;
	public int counter;

	public PlaintextScanner(String filename){
		this.filename = filename;
		
	}
	/**
	 * This method returns an ArrayList<String> containing the .txt that is to be read.
	 * @return ArrayList<String> plainTextMessage -
	 *  The entire text file, saved in an ArrayList<String>.
	 * @throws IOException
	 */
	public ArrayList<String> getPlainText() throws IOException{
		ArrayList<String> plainTextMessage = new ArrayList<String>();
		Scanner inFile = new Scanner(new File(filename));
		while(inFile.hasNext()){
			plainTextMessage.add(inFile.next() + " ");
		}
		inFile.close();
		return plainTextMessage;
	}
	
	
    /**
     * This method returns the frequencies of each letter.
     * @return int[] frequencies - the frequency of each letter.
     */
    public int[] getFrequency() throws IOException{
            int[] frequencies = new int[26];
            ArrayList<String> plaintext = getPlainText();
            
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
    
    /**
     * This method prints the percentage of frequency of the letters.
     * 
     */
    public void printFrequencies() throws IOException{
        int[] frequencies = getFrequency();
        int sum = 0;
        for(int i = 0; i < 26; i++){
                sum += frequencies[i];
        }
        for(int i = 0; i < 26; i++){
                System.out.print("The frequency of (" + (char)('a' + i)+ ") is ");
                System.out.printf("%1.2f%%\n", (100 * (frequencies[i] / (double) sum)));
        }
      
}

	

}
    

	