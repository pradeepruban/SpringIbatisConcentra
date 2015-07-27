/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
*This class contains all the attributes related to Applcation Details.
*@author Syntel
*@version 1.0
*/
public class ApplicationDetails implements Serializable{
private int applnId;
private String applnCode;
private String applnName;
private String applnShortDesc;
private String applnDesc;
private String applnContextPath;
private int deleteFlag;
private int createdBy;
private int modifiedBy;
private Date createdDate;
private Date modifiedDate;
private String resAttribute1;
private String resAttribute2;
private String resAttribute3;
private String resAttribute4;
private String resAttribute5;
private String createdUser;
private String strCreatedDate;
private String strModifiedDate;
private String modifiedUser;
private String applicationActions;
public String getApplicationActions() {
	return applicationActions;
}
public void setApplicationActions(String applicationActions) {
	this.applicationActions = applicationActions;
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
public int getApplnId() {
	return applnId;
}
public void setApplnId(int applnId) {
	this.applnId = applnId;
}
public String getApplnCode() {
	return applnCode;
}
public void setApplnCode(String applnCode) {
	this.applnCode = applnCode;
}
public String getApplnName() {
	return applnName;
}
public void setApplnName(String applnName) {
	this.applnName = applnName;
}
public String getApplnShortDesc() {
	return applnShortDesc;
}
public void setApplnShortDesc(String applnShortDesc) {
	this.applnShortDesc = applnShortDesc;
}
public String getApplnDesc() {
	return applnDesc;
}
public void setApplnDesc(String applnDesc) {
	this.applnDesc = applnDesc;
}
public String getApplnContextPath() {
	return applnContextPath;
}
public void setApplnContextPath(String applnContextPath) {
	this.applnContextPath = applnContextPath;
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
public int getModifiedBy() {
	return modifiedBy;
}
public void setModifiedBy(int modifiedBy) {
	this.modifiedBy = modifiedBy;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
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
	return "ApplicationDetails [applnId=" + applnId + ", applnCode="
			+ applnCode + ", applnName=" + applnName + ", applnShortDesc="
			+ applnShortDesc + ", applnDesc=" + applnDesc
			+ ", applnContextPath=" + applnContextPath + ", deleteFlag="
			+ deleteFlag + ", createdBy=" + createdBy + ", modifiedBy="
			+ modifiedBy + ", createdDate=" + createdDate + ", modifiedDate="
			+ modifiedDate + ", resAttribute1=" + resAttribute1
			+ ", resAttribute2=" + resAttribute2 + ", resAttribute3="
			+ resAttribute3 + ", resAttribute4=" + resAttribute4
			+ ", resAttribute5=" + resAttribute5 + ", createdUser="
			+ createdUser + ", strCreatedDate=" + strCreatedDate
			+ ", strModifiedDate=" + strModifiedDate + ", modifiedUser="
			+ modifiedUser + ", applicationActions=" + applicationActions + "]";
}


}