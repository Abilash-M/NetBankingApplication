//$Id$
package com.letsCode.service;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionService {
	private static final String ALGORITHM = "AES";
    private static final String SECRET_KEY = "mhSlp0HFiHgmrG3BCnhAUKHOzo0Ks3uzU3w77ee2OoE=";
//	public static String encrypt_password(String password){
//        StringBuilder encrypted = new StringBuilder();
//        for(int i=0;i<password.length();i++){
//            char c=password.charAt(i);
//            if(password.charAt(i)>'A' && password.charAt(i)<'Z'){
//                encrypted.append((char)(c+1));
//            }
//            else if(c=='Z'){
//                encrypted.append('A');
//            }
//            else if(c>='a' && c<'z'){
//                encrypted.append((char)(c+1));
//            }
//            else if(c=='z'){
//                encrypted.append('a');
//            }
//            else if(c>='0' && c<'9'){
//                encrypted.append((char)(c+1));
//            }
//            else if(c=='9'){
//                encrypted.append('0');
//            }
//            else {
//                encrypted.append(c);
//            }
//        }
//        return encrypted.toString();
//    }
	
	
	
	public static String encrypt(String string) throws Exception {
		string=AddPadding(string);
        Key key = getKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(string.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedstring) throws Exception {
//    	System.out.println( "the string is" +encryptedstring + "ends here");
    	if(encryptedstring.equals(null) || encryptedstring.equals("")) {
    		return "";
    	}
        Key key = getKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedstring));
        String decryptedString= new String(decryptedBytes);
//        return new String(decryptedBytes);
        return removePadding(decryptedString);
        
    }


	    private static SecretKey getKey() {
	        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
	        return new SecretKeySpec(decodedKey,0,decodedKey.length,ALGORITHM);
	    }
	    
	    public static String AddPadding(int number) {
	        String string = String.valueOf(number);
	        int paddingLength = 16 - (string.length() % 16);
	        StringBuilder paddedString = new StringBuilder(string);
	        for (int i = 0; i < paddingLength; i++) {
	            paddedString.append(' '); 
	        }
	        return paddedString.toString();
	    }
	    
	    public static String AddPadding(String string) {
	    	
	        int paddingLength = 16 - (string.length() % 16);
	        StringBuilder paddedstring = new StringBuilder(string);
	        for(int i = 0; i<paddingLength; i++) {
	        	paddedstring.append(' '); 
	        }
	        return paddedstring.toString();
	    }
	    
	    public static String removePadding(String string) {
	        String originalString = string.trim();
//	        int originalAccountNumber = Integer.parseInt(originalString);
	        return originalString;
	    }


}
