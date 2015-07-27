/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
package com.syntel.syntbots.itops.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



/**
 * This class contains the utility functions used for Java Encryption in syntbotsitops application 
 * @author Syntel
 * @version 1.0
 */
public class SyntBotsITOpsEncryptionUtil {
	
	private static final String ALGO = "AES";
	private static final byte[] keyValue = SyntBotsITOpsConstants.MASTER_PASSWORD_JAVA.getBytes();
	
	 private static Key generateKey() throws Exception {
	     Key key = null;
	     key =   new SecretKeySpec(keyValue, ALGO);
	     return key;
	 }
	
	 /**
	  * This method is used for encrypting the given data 
	  * @param Data - data to be encrypted
	  * @return
	  * @throws Exception
	  */
	public static String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());        
        byte[] encryptedByteValue = new Base64(true).encode(encVal);
        String encryptedValue = new String(encryptedByteValue);
        if((encryptedValue != null) && (encryptedValue.endsWith("\n")))
		{
			encryptedValue = encryptedValue.substring(0, encryptedValue.length()-2);
		}       
        return encryptedValue;
    }

	/**
	  * This method is used for decrypting the given encrypted data 
	  * @param encryptedData - encrypted data i.e. to be decrypted
	  * @return
	  */
	public static String decrypt(String encryptedData) throws Exception {
		String decryptedValue =null;
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = new Base64(true).decode(encryptedData.getBytes());
        byte[] decValue = c.doFinal(decodedValue);
        decryptedValue = new String(decValue);
        return decryptedValue;
	}	
	
}
