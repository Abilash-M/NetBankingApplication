//$Id$
package com.letsCode.service;

public class EncryptionService {
	public static String encrypt_password(String password){
        StringBuilder encrypted = new StringBuilder();
        for(int i=0;i<password.length();i++){
            char c=password.charAt(i);
            if(password.charAt(i)>'A' && password.charAt(i)<'Z'){
                encrypted.append((char)(c+1));
            }
            else if(c=='Z'){
                encrypted.append('A');
            }
            else if(c>='a' && c<'z'){
                encrypted.append((char)(c+1));
            }
            else if(c=='z'){
                encrypted.append('a');
            }
            else if(c>='0' && c<'9'){
                encrypted.append((char)(c+1));
            }
            else if(c=='9'){
                encrypted.append('0');
            }
            else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
}
