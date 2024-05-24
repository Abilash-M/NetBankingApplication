//$Id$
package com.letsCode.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CardService {
	    public static int generateRandomNumber(int n) {
	        Random random = new Random();
	        int min = (int) Math.pow(10,n - 1); 
	        int max = (int) Math.pow(10,n) - 1; 
	        return random.nextInt(max - min + 1) + min;
	    }
	    
	    public static String generateExpiryDate() {
	        LocalDate today = LocalDate.now();
	        LocalDate ExpiryDate = today.plusYears(5);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        return ExpiryDate.format(formatter);
	    }

    
}