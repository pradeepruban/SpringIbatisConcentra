/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;
/**
*This class is related to DataTableObject.
*@author Syntel
*@version 1.0
*/
public class DataTableObject<T> {

	
	private int iTotalRecords;
	
	private int iTotalDisplayRecords;
	
	private String 	sEcho;
	
	private String sColumns;
	
	private T aaData;
	
	public T getAaData() {
		return aaData;
	}

	public void setAaData(T aaData) {
		this.aaData = aaData;
	}

	public int getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}



	
	
	
}
