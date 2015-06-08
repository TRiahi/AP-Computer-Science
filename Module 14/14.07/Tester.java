/**
*This class prints out the frequencies from the Plaintext and Ciphertext files.
*@author Bijan Tajmir
*@version 3/15/2015
*/

import java.io.IOException;
public class Tester {

        public static void main(String[] args) throws IOException{
                
                PlaintextScanner p = new PlaintextScanner("plaintext.txt");
                CiphertextScanner c = new CiphertextScanner("ciphertext.txt");
                
                
                int[] plainFrequencies = p.getFrequency();
                int[] cipherFrequencies = c.getFrequency();
                int plainSum = 0, cipherSum = 0;
                for(int i = 0; i < 26; i++){
                        plainSum += plainFrequencies[i];
                        cipherSum += cipherFrequencies[i];
                }
                
        for(int i = 0; i < 26; i++){
            System.out.print("(plaintext) The frequency of (" + (char)('a' + i)+ ") is ");
            System.out.printf("%1.2f%%        ", (100 * (plainFrequencies[i] / (double) plainSum)));
            
            System.out.print("(ciphertext) The frequency of (" + (char)('a' + i)+ ") is ");
            System.out.printf("%1.2f%%        \n", (100 * (cipherFrequencies[i] / (double) cipherSum)));
    }
        }
        
}