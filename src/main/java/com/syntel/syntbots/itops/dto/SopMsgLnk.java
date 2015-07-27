/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
/**
*This class contains all the attributes related to SOP message link.
*@author Syntel
*@version 1.0
*/

public class SopMsgLnk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long sopId;
	private String sopName;
	private String msgKeyword;
	private int deleteFlag;
	private int createdBy;
	private int modifiedBy;
	private String strCreatedByShortUserName;
	private String strModifiedByShortUserName;
	private Date createdDate;
	private Date modifiedDate;
	private String strSopMsgLnkCreatedDate;
	private String strSopMsgLnkModifiedDate;
	private String resAttribute1;
	private String resAttribute2;
	private String resAttribute3;
	private String resAttribute4;
	private String resAttribute5;
	
	
	public long getSopId() {
		return sopId;
	}
	public void setSopId(long sopId) {
		this.sopId = sopId;
	}
	public String getSopName() {
		return sopName;
	}
	public void setSopName(String sopName) {
		this.sopName = sopName;
	}
	public String getMsgKeyword() {
		return msgKeyword;
	}
	public void setMsgKeyword(String msgKeyword) {
		this.msgKeyword = msgKeyword;
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
	public String getStrCreatedByShortUserName() {
		return strCreatedByShortUserName;
	}
	public void setStrCreatedByShortUserName(String strCreatedByShortUserName) {
		this.strCreatedByShortUserName = strCreatedByShortUserName;
	}
	public String getStrModifiedByShortUserName() {
		return strModifiedByShortUserName;
	}
	public void setStrModifiedByShortUserName(String strModifiedByShortUserName) {
		this.strModifiedByShortUserName = strModifiedByShortUserName;
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
	public String getStrSopMsgLnkCreatedDate() {
		return strSopMsgLnkCreatedDate;
	}
	public void setStrSopMsgLnkCreatedDate(String strSopMsgLnkCreatedDate) {
		this.strSopMsgLnkCreatedDate = strSopMsgLnkCreatedDate;
	}
	public String getStrSopMsgLnkModifiedDate() {
		return strSopMsgLnkModifiedDate;
	}
	public void setStrSopMsgLnkModifiedDate(String strSopMsgLnkModifiedDate) {
		this.strSopMsgLnkModifiedDate = strSopMsgLnkModifiedDate;
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
		return "SopMsgLnk [sopId=" + sopId + ", msgKeyword=" + msgKeyword
				+ ", deleteFlag=" + deleteFlag + ", createdBy=" + createdBy
				+ ", modifiedBy=" + modifiedBy + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", resAttribute1="
				+ resAttribute1 + ", resAttribute2=" + resAttribute2
				+ ", resAttribute3=" + resAttribute3 + ", resAttribute4="
				+ resAttribute4 + ", resAttribute5=" + resAttribute5 + "]";
	}
	
	
	
	
	

}
