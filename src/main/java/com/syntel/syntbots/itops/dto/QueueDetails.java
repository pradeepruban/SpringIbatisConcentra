/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
/**
*This class contains all the attributes related to Queue Details.
*@author Syntel
*@version 1.0
*/
public class QueueDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int queId;
	private String queName;
	private String queDesc;
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
	private String modifiedUser;
	
	private String strCreatedDate;
	private String strModifiedDate;
	private String queueAction;
	public String getQueueAction() {
		return queueAction;
	}
	public void setQueueAction(String queueAction) {
		this.queueAction = queueAction;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	public String getQueName() {
		return queName;
	}
	public void setQueName(String queName) {
		this.queName = queName;
	}
	public String getQueDesc() {
		return queDesc;
	}
	public void setQueDesc(String queDesc) {
		this.queDesc = queDesc;
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
		return "QueueDetails [queId=" + queId + ", queName=" + queName
				+ ", queDesc=" + queDesc + ", deleteFlag=" + deleteFlag
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", resAttribute1=" + resAttribute1
				+ ", resAttribute2=" + resAttribute2 + ", resAttribute3="
				+ resAttribute3 + ", resAttribute4=" + resAttribute4
				+ ", resAttribute5=" + resAttribute5 + ", createdUser="
				+ createdUser + ", modifiedUser=" + modifiedUser
				+ ", strCreatedDate=" + strCreatedDate + ", strModifiedDate="
				+ strModifiedDate + ", queueAction=" + queueAction + "]";
	}
	
	
}
