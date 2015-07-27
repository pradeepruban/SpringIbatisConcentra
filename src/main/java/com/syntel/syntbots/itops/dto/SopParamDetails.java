/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
*This class contains all the attributes related to Sop param details.
*@author Syntel
*@version 1.0
*/
public class SopParamDetails implements Serializable{
	private int sopId;
	private int sopParamId;
	private String paramCode;
	private String paramValue;
	private int deleteFlag;
	private int createdBy;
	private Date createdDate;
	private int modifiedBy;
	private Date modifiedDate;
	private String resAttribute1;
	private String resAttribute2;
	private String resAttribute3;
	private String resAttribute4;
	private String resAttribute5;
	
	private String strCreatedDate;
	private String strModifiedDate;
	private String createdUser;
	private String modifiedUser;
	private String sopParamAction;
	
	
	public int getSopParamId() {
		return sopParamId;
	}
	public void setSopParamId(int sopParamId) {
		this.sopParamId = sopParamId;
	}
	public String getSopParamAction() {
		return sopParamAction;
	}
	public void setSopParamAction(String sopParamAction) {
		this.sopParamAction = sopParamAction;
	}
	public String getStrCreatedDate() {
		return strCreatedDate;
	}
	public void setStrCreatedDate(String strCreatedDate) {
		this.strCreatedDate = strCreatedDate;
	}
	public String getStrModifiedDate() {
		return strModifiedDate;
	}
	public void setStrModifiedDate(String strModifiedDate) {
		this.strModifiedDate = strModifiedDate;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public int getSopId() {
		return sopId;
	}
	public void setSopId(int sopId) {
		this.sopId = sopId;
	}
	
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getResAttribute1() {
		return resAttribute1;
	}
	public void setResAttribute1(String resAttribute1) {
		this.resAttribute1 = resAttribute1;
	}
	public String getResAttribute2() {
		return resAttribute2;
	}
	public void setResAttribute2(String resAttribute2) {
		this.resAttribute2 = resAttribute2;
	}
	public String getResAttribute3() {
		return resAttribute3;
	}
	public void setResAttribute3(String resAttribute3) {
		this.resAttribute3 = resAttribute3;
	}
	public String getResAttribute4() {
		return resAttribute4;
	}
	public void setResAttribute4(String resAttribute4) {
		this.resAttribute4 = resAttribute4;
	}
	public String getResAttribute5() {
		return resAttribute5;
	}
	public void setResAttribute5(String resAttribute5) {
		this.resAttribute5 = resAttribute5;
	}
	@Override
	public String toString() {
		return "SopParamDetails [sopId=" + sopId + ", sopParamId=" + sopParamId
				+ ", paramCode=" + paramCode + ", paramValue=" + paramValue
				+ ", deleteFlag=" + deleteFlag + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy
				+ ", modifiedDate=" + modifiedDate + ", resAttribute1="
				+ resAttribute1 + ", resAttribute2=" + resAttribute2
				+ ", resAttribute3=" + resAttribute3 + ", resAttribute4="
				+ resAttribute4 + ", resAttribute5=" + resAttribute5
				+ ", strCreatedDate=" + strCreatedDate + ", strModifiedDate="
				+ strModifiedDate + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + ", sopParamAction="
				+ sopParamAction + "]";
	}
	
	
	

}