import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.lang.*;
import java.util.Collections;
public class CaesarCipher {
	public static void main(String[] args){
		String originalMessage;		//user input the original message
		char[] ciphertext;			
		char[] plaintext;
		int keyNumber;
		
		Scanner key = new Scanner(System.in);
		System.out.println("Enter the original message: ");
		originalMessage = key.nextLine();
		System.out.println("Ener the key: ");
		keyNumber = key.nextInt();
		
		
		//Calling Encrypt method
		ciphertext = Encrypt(originalMessage,keyNumber);
		System.out.print("Encrypt Message: ");
		System.out.println(ciphertext);
		
		//Call Decrypt method
		plaintext = Decrypt(ciphertext,keyNumber);
		System.out.print("Decrypt Message: ");
		System.out.println(plaintext);
		
	}//END MAIN FUNCTION
	
	//Encrypt method to convert original message to ciphertext
	public static char[] Encrypt(String originalMessage, int keyNumber){
		
		//Declaring the alphebet array
		char[] alphebetArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] encryptArray = new char[originalMessage.length()];
		for(int i = 0; i < originalMessage.length(); i++){
			for(int j = 0; j < alphebetArray.length; j++){
				if(originalMessage.charAt(i)== alphebetArray[j]){
					int shiftNumber;
					int alphebetIndex = j;
					shiftNumber = j + keyNumber;
					if(shiftNumber > 25)
						shiftNumber = shiftNumber % 26;
					char encryptLetter = alphebetArray[shiftNumber];
					encryptArray[i]=encryptLetter;
					//System.out.print(encryptLetter);
				}
			}
		}		
		return encryptArray;
	}//END ENCRYPT FUNCTION
	
	//Decrypt method to convert ciphertext to original message
	public static char[] Decrypt(char[] ciphertext, int keyNumber){
		char[] alphebetArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] decryptArray = new char[ciphertext.length]; 
		for(int i = 0 ; i < ciphertext.length; i++){
			for(int j = 0; j < alphebetArray.length; j++){
				if(ciphertext[i]== alphebetArray[j]){
					int shiftNumber;
					int alphebetIndex = j;
					shiftNumber = j - keyNumber;
					if(shiftNumber < 0)
						shiftNumber = shiftNumber + 26;
					char decryptLetter = alphebetArray[shiftNumber];
					decryptArray[i] = decryptLetter;
					//System.out.print(decryptLetter);
				}
			}
			
		}
		return decryptArray;
	}//END DECYPT FUNCTION
	
	
}//END CEASER CHIPER CLASS

