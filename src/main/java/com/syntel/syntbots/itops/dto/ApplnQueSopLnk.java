/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
/**
*This class contains all the attributes related to Application Queue Sop Link.
*@author Syntel
*@version 1.0
*/
public class ApplnQueSopLnk implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private long applicationId;
	private long queueId;
	private long sopId;
	private String strAppQSopLnkApplicationName;
	private String strAppQSopLnkQueueName;
	private String strAppQSopLnkSopName;
	private int appQSopLnkDefaultFlag;
	private int appQSopLnkDeleteFlag;
	private int appQSopLnkCreatedBy;
	private int appQSopLnkModifiedBy;
	private String strAppQSopLnkCreatedByShortUserName;
	private String strAppQSopLnkModifiedByShortUserName;
	private Date appQSopLnkCreatedDate;
	private Date appQSopLnkModifiedDate;
	private String strAppQSopLnkCreatedDate;
	private String strAppQSopLnkModifiedDate;
	private String appQSopLnkResAttribute1;
	private String appQSopLnkResAttribute2;
	private String appQSopLnkResAttribute3;
	private String appQSopLnkResAttribute4;
	private String appQSopLnkResAttribute5;
	public long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}
	public long getQueueId() {
		return queueId;
	}
	public void setQueueId(long queueId) {
		this.queueId = queueId;
	}
	public long getSopId() {
		return sopId;
	}
	public void setSopId(long sopId) {
		this.sopId = sopId;
	}
	public String getStrAppQSopLnkApplicationName() {
		return strAppQSopLnkApplicationName;
	}
	public void setStrAppQSopLnkApplicationName(String strAppQSopLnkApplicationName) {
		this.strAppQSopLnkApplicationName = strAppQSopLnkApplicationName;
	}
	public String getStrAppQSopLnkQueueName() {
		return strAppQSopLnkQueueName;
	}
	public void setStrAppQSopLnkQueueName(String strAppQSopLnkQueueName) {
		this.strAppQSopLnkQueueName = strAppQSopLnkQueueName;
	}
	public String getStrAppQSopLnkSopName() {
		return strAppQSopLnkSopName;
	}
	public void setStrAppQSopLnkSopName(String strAppQSopLnkSopName) {
		this.strAppQSopLnkSopName = strAppQSopLnkSopName;
	}
	public int getAppQSopLnkDefaultFlag() {
		return appQSopLnkDefaultFlag;
	}
	public void setAppQSopLnkDefaultFlag(int appQSopLnkDefaultFlag) {
		this.appQSopLnkDefaultFlag = appQSopLnkDefaultFlag;
	}
	public int getAppQSopLnkDeleteFlag() {
		return appQSopLnkDeleteFlag;
	}
	public void setAppQSopLnkDeleteFlag(int appQSopLnkDeleteFlag) {
		this.appQSopLnkDeleteFlag = appQSopLnkDeleteFlag;
	}
	public int getAppQSopLnkCreatedBy() {
		return appQSopLnkCreatedBy;
	}
	public void setAppQSopLnkCreatedBy(int appQSopLnkCreatedBy) {
		this.appQSopLnkCreatedBy = appQSopLnkCreatedBy;
	}
	public int getAppQSopLnkModifiedBy() {
		return appQSopLnkModifiedBy;
	}
	public void setAppQSopLnkModifiedBy(int appQSopLnkModifiedBy) {
		this.appQSopLnkModifiedBy = appQSopLnkModifiedBy;
	}
	public String getStrAppQSopLnkCreatedByShortUserName() {
		return strAppQSopLnkCreatedByShortUserName;
	}
	public void setStrAppQSopLnkCreatedByShortUserName(
			String strAppQSopLnkCreatedByShortUserName) {
		this.strAppQSopLnkCreatedByShortUserName = strAppQSopLnkCreatedByShortUserName;
	}
	public String getStrAppQSopLnkModifiedByShortUserName() {
		return strAppQSopLnkModifiedByShortUserName;
	}
	public void setStrAppQSopLnkModifiedByShortUserName(
			String strAppQSopLnkModifiedByShortUserName) {
		this.strAppQSopLnkModifiedByShortUserName = strAppQSopLnkModifiedByShortUserName;
	}
	public Date getAppQSopLnkCreatedDate() {
		return appQSopLnkCreatedDate;
	}
	public void setAppQSopLnkCreatedDate(Date appQSopLnkCreatedDate) {
		this.appQSopLnkCreatedDate = appQSopLnkCreatedDate;
	}
	public Date getAppQSopLnkModifiedDate() {
		return appQSopLnkModifiedDate;
	}
	public void setAppQSopLnkModifiedDate(Date appQSopLnkModifiedDate) {
		this.appQSopLnkModifiedDate = appQSopLnkModifiedDate;
	}
	public String getStrAppQSopLnkCreatedDate() {
		return strAppQSopLnkCreatedDate;
	}
	public void setStrAppQSopLnkCreatedDate(String strAppQSopLnkCreatedDate) {
		this.strAppQSopLnkCreatedDate = strAppQSopLnkCreatedDate;
	}
	public String getStrAppQSopLnkModifiedDate() {
		return strAppQSopLnkModifiedDate;
	}
	public void setStrAppQSopLnkModifiedDate(String strAppQSopLnkModifiedDate) {
		this.strAppQSopLnkModifiedDate = strAppQSopLnkModifiedDate;
	}
	public String getAppQSopLnkResAttribute1() {
		return appQSopLnkResAttribute1;
	}
	public void setAppQSopLnkResAttribute1(String appQSopLnkResAttribute1) {
		this.appQSopLnkResAttribute1 = appQSopLnkResAttribute1;
	}
	public String getAppQSopLnkResAttribute2() {
		return appQSopLnkResAttribute2;
	}
	public void setAppQSopLnkResAttribute2(String appQSopLnkResAttribute2) {
		this.appQSopLnkResAttribute2 = appQSopLnkResAttribute2;
	}
	public String getAppQSopLnkResAttribute3() {
		return appQSopLnkResAttribute3;
	}
	public void setAppQSopLnkResAttribute3(String appQSopLnkResAttribute3) {
		this.appQSopLnkResAttribute3 = appQSopLnkResAttribute3;
	}
	public String getAppQSopLnkResAttribute4() {
		return appQSopLnkResAttribute4;
	}
	public void setAppQSopLnkResAttribute4(String appQSopLnkResAttribute4) {
		this.appQSopLnkResAttribute4 = appQSopLnkResAttribute4;
	}
	public String getAppQSopLnkResAttribute5() {
		return appQSopLnkResAttribute5;
	}
	public void setAppQSopLnkResAttribute5(String appQSopLnkResAttribute5) {
		this.appQSopLnkResAttribute5 = appQSopLnkResAttribute5;
	}
	@Override
	public String toString() {
		return "ApplicationQueueSopLink [applicationId=" + applicationId
				+ ", queueId=" + queueId + ", sopId=" + sopId
				+ ", appQSopLnkDefaultFlag=" + appQSopLnkDefaultFlag
				+ ", appQSopLnkDeleteFlag=" + appQSopLnkDeleteFlag
				+ ", appQSopLnkCreatedBy=" + appQSopLnkCreatedBy
				+ ", appQSopLnkModifiedBy=" + appQSopLnkModifiedBy
				+ ", strAppQSopLnkCreatedByShortUserName="
				+ strAppQSopLnkCreatedByShortUserName
				+ ", strAppQSopLnkModifiedByShortUserName="
				+ strAppQSopLnkModifiedByShortUserName
				+ ", appQSopLnkCreatedDate=" + appQSopLnkCreatedDate
				+ ", appQSopLnkModifiedDate=" + appQSopLnkModifiedDate
				+ ", strAppQSopLnkCreatedDate=" + strAppQSopLnkCreatedDate
				+ ", strAppQSopLnkModifiedDate=" + strAppQSopLnkModifiedDate
				+ ", appQSopLnkResAttribute1=" + appQSopLnkResAttribute1
				+ ", appQSopLnkResAttribute2=" + appQSopLnkResAttribute2
				+ ", appQSopLnkResAttribute3=" + appQSopLnkResAttribute3
				+ ", appQSopLnkResAttribute4=" + appQSopLnkResAttribute4
				+ ", appQSopLnkResAttribute5=" + appQSopLnkResAttribute5 + "]";
	}
	
	
}
