package com.proptiger.urlshortner.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
	public static int getHash(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hashtext value 
            String hashtext = no.toString(16); 
			/*
			 * if(input.contentEquals("abcddd")){ hashtext =
			 * "d1fdbdb90f35ac71894b67e83aa24702"; }
			 */
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            }
            int len = 32;
            long sum = 0;
            for(int i = len-1;i>=16;i--){
            if(hashtext.charAt(i)>='a' && hashtext.charAt(i)<='f'){
            sum= sum + (hashtext.charAt(i)-'a' + 10)*(long)Math.pow(16,len-1-i)%1000000;
            }
            else{
            sum = sum + (hashtext.charAt(i)-'0')*(long)(Math.pow(16,len-1-i)%1000000);

            }
            sum = sum %1000000;

            }
         //   System.out.println(sum);
            
            sum = sum %1000000;

            return (int)sum; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
}
