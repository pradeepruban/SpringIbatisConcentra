/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
/**
*This class contains all the attributes related to Encryption Details.
*@author Syntel
*@version 1.0
*/
public class EncryptionDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String data;
	private String encryptedData;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	
	
	
	
}
