/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;

/**
*This class contains all the attributes related to User application queue link Details.
*@author Syntel
*@version 1.0
*/
public class UsrApplnQueLnk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long usrAppQLinkId;
	private long usrAppQLinkApplicationId;
	private long usrAppQLinkQueueId;
	private long usrAppQLinkUsrId;
	private String strUsrAppQLinkApplicationName;
	private String strUsrAppQLinkQueueName;
	private String strUsrAppQLinkUsrName;
	private int usrAppQLinkToViewFlag;
	private int usrAppQLinkToExecuteFlag;
	private int usrAppQLinkDeleteFlag;
	private int usrAppQLinkCreatedBy;//
	private int usrAppQLinkModifiedBy;//
	private String strUsrAppQLinkCreatedByShortUserName;
	private String strUsrAppQLinkModifiedByShortUserName;
	private Date usrAppQLinkCreatedDate;
	private Date usrAppQLinkModifiedDate;
	private String strUsrAppQLinkCreatedDate;
	private String strUsrAppQLinkModifiedDate;
	private String usrAppQLinkResAttribute1;
	private String usrAppQLinkResAttribute2;
	private String usrAppQLinkResAttribute3;
	private String usrAppQLinkResAttribute4;
	private String usrAppQLinkResAttribute5;
	private String usrAppQLinkActions;
	
	
	public String getUsrAppQLinkActions() {
		return usrAppQLinkActions;
	}
	public void setUsrAppQLinkActions(String usrAppQLinkActions) {
		this.usrAppQLinkActions = usrAppQLinkActions;
	}
	public long getUsrAppQLinkId() {
		return usrAppQLinkId;
	}
	public void setUsrAppQLinkId(long usrAppQLinkId) {
		this.usrAppQLinkId = usrAppQLinkId;
	}
	public long getUsrAppQLinkApplicationId() {
		return usrAppQLinkApplicationId;
	}
	public void setUsrAppQLinkApplicationId(long usrAppQLinkApplicationId) {
		this.usrAppQLinkApplicationId = usrAppQLinkApplicationId;
	}
	public long getUsrAppQLinkQueueId() {
		return usrAppQLinkQueueId;
	}
	public void setUsrAppQLinkQueueId(long usrAppQLinkQueueId) {
		this.usrAppQLinkQueueId = usrAppQLinkQueueId;
	}
	public long getUsrAppQLinkUsrId() {
		return usrAppQLinkUsrId;
	}
	public void setUsrAppQLinkUsrId(long usrAppQLinkUsrId) {
		this.usrAppQLinkUsrId = usrAppQLinkUsrId;
	}
	public String getStrUsrAppQLinkApplicationName() {
		return strUsrAppQLinkApplicationName;
	}
	public void setStrUsrAppQLinkApplicationName(
			String strUsrAppQLinkApplicationName) {
		this.strUsrAppQLinkApplicationName = strUsrAppQLinkApplicationName;
	}
	public String getStrUsrAppQLinkQueueName() {
		return strUsrAppQLinkQueueName;
	}
	public void setStrUsrAppQLinkQueueName(String strUsrAppQLinkQueueName) {
		this.strUsrAppQLinkQueueName = strUsrAppQLinkQueueName;
	}
	public String getStrUsrAppQLinkUsrName() {
		return strUsrAppQLinkUsrName;
	}
	public void setStrUsrAppQLinkUsrName(String strUsrAppQLinkUsrName) {
		this.strUsrAppQLinkUsrName = strUsrAppQLinkUsrName;
	}
	public int getUsrAppQLinkToViewFlag() {
		return usrAppQLinkToViewFlag;
	}
	public void setUsrAppQLinkToViewFlag(int usrAppQLinkToViewFlag) {
		this.usrAppQLinkToViewFlag = usrAppQLinkToViewFlag;
	}
	public int getUsrAppQLinkToExecuteFlag() {
		return usrAppQLinkToExecuteFlag;
	}
	public void setUsrAppQLinkToExecuteFlag(int usrAppQLinkToExecuteFlag) {
		this.usrAppQLinkToExecuteFlag = usrAppQLinkToExecuteFlag;
	}
	public int getUsrAppQLinkDeleteFlag() {
		return usrAppQLinkDeleteFlag;
	}
	public void setUsrAppQLinkDeleteFlag(int usrAppQLinkDeleteFlag) {
		this.usrAppQLinkDeleteFlag = usrAppQLinkDeleteFlag;
	}
	public int getUsrAppQLinkCreatedBy() {
		return usrAppQLinkCreatedBy;
	}
	public void setUsrAppQLinkCreatedBy(int usrAppQLinkCreatedBy) {
		this.usrAppQLinkCreatedBy = usrAppQLinkCreatedBy;
	}
	public int getUsrAppQLinkModifiedBy() {
		return usrAppQLinkModifiedBy;
	}
	public void setUsrAppQLinkModifiedBy(int usrAppQLinkModifiedBy) {
		this.usrAppQLinkModifiedBy = usrAppQLinkModifiedBy;
	}
	public String getStrUsrAppQLinkCreatedByShortUserName() {
		return strUsrAppQLinkCreatedByShortUserName;
	}
	public void setStrUsrAppQLinkCreatedByShortUserName(
			String strUsrAppQLinkCreatedByShortUserName) {
		this.strUsrAppQLinkCreatedByShortUserName = strUsrAppQLinkCreatedByShortUserName;
	}
	public String getStrUsrAppQLinkModifiedByShortUserName() {
		return strUsrAppQLinkModifiedByShortUserName;
	}
	public void setStrUsrAppQLinkModifiedByShortUserName(
			String strUsrAppQLinkModifiedByShortUserName) {
		this.strUsrAppQLinkModifiedByShortUserName = strUsrAppQLinkModifiedByShortUserName;
	}
	public Date getUsrAppQLinkCreatedDate() {
		return usrAppQLinkCreatedDate;
	}
	public void setUsrAppQLinkCreatedDate(Date usrAppQLinkCreatedDate) {
		this.usrAppQLinkCreatedDate = usrAppQLinkCreatedDate;
	}
	public Date getUsrAppQLinkModifiedDate() {
		return usrAppQLinkModifiedDate;
	}
	public void setUsrAppQLinkModifiedDate(Date usrAppQLinkModifiedDate) {
		this.usrAppQLinkModifiedDate = usrAppQLinkModifiedDate;
	}
	public String getStrUsrAppQLinkCreatedDate() {
		return strUsrAppQLinkCreatedDate;
	}
	public void setStrUsrAppQLinkCreatedDate(String strUsrAppQLinkCreatedDate) {
		this.strUsrAppQLinkCreatedDate = strUsrAppQLinkCreatedDate;
	}
	public String getStrUsrAppQLinkModifiedDate() {
		return strUsrAppQLinkModifiedDate;
	}
	public void setStrUsrAppQLinkModifiedDate(String strUsrAppQLinkModifiedDate) {
		this.strUsrAppQLinkModifiedDate = strUsrAppQLinkModifiedDate;
	}
	public String getUsrAppQLinkResAttribute1() {
		return usrAppQLinkResAttribute1;
	}
	public void setUsrAppQLinkResAttribute1(String usrAppQLinkResAttribute1) {
		this.usrAppQLinkResAttribute1 = usrAppQLinkResAttribute1;
	}
	public String getUsrAppQLinkResAttribute2() {
		return usrAppQLinkResAttribute2;
	}
	public void setUsrAppQLinkResAttribute2(String usrAppQLinkResAttribute2) {
		this.usrAppQLinkResAttribute2 = usrAppQLinkResAttribute2;
	}
	public String getUsrAppQLinkResAttribute3() {
		return usrAppQLinkResAttribute3;
	}
	public void setUsrAppQLinkResAttribute3(String usrAppQLinkResAttribute3) {
		this.usrAppQLinkResAttribute3 = usrAppQLinkResAttribute3;
	}
	public String getUsrAppQLinkResAttribute4() {
		return usrAppQLinkResAttribute4;
	}
	public void setUsrAppQLinkResAttribute4(String usrAppQLinkResAttribute4) {
		this.usrAppQLinkResAttribute4 = usrAppQLinkResAttribute4;
	}
	public String getUsrAppQLinkResAttribute5() {
		return usrAppQLinkResAttribute5;
	}
	public void setUsrAppQLinkResAttribute5(String usrAppQLinkResAttribute5) {
		this.usrAppQLinkResAttribute5 = usrAppQLinkResAttribute5;
	}
	@Override
	public String toString() {
		return "UsrApplnQueLnk [usrAppQLinkId=" + usrAppQLinkId
				+ ", usrAppQLinkApplicationId=" + usrAppQLinkApplicationId
				+ ", usrAppQLinkQueueId=" + usrAppQLinkQueueId
				+ ", usrAppQLinkUsrId=" + usrAppQLinkUsrId
				+ ", strUsrAppQLinkApplicationName="
				+ strUsrAppQLinkApplicationName + ", strUsrAppQLinkQueueName="
				+ strUsrAppQLinkQueueName + ", strUsrAppQLinkUsrName="
				+ strUsrAppQLinkUsrName + ", usrAppQLinkToViewFlag="
				+ usrAppQLinkToViewFlag + ", usrAppQLinkToExecuteFlag="
				+ usrAppQLinkToExecuteFlag + ", usrAppQLinkDeleteFlag="
				+ usrAppQLinkDeleteFlag + ", usrAppQLinkCreatedBy="
				+ usrAppQLinkCreatedBy + ", usrAppQLinkModifiedBy="
				+ usrAppQLinkModifiedBy
				+ ", strUsrAppQLinkCreatedByShortUserName="
				+ strUsrAppQLinkCreatedByShortUserName
				+ ", strUsrAppQLinkModifiedByShortUserName="
				+ strUsrAppQLinkModifiedByShortUserName
				+ ", usrAppQLinkCreatedDate=" + usrAppQLinkCreatedDate
				+ ", usrAppQLinkModifiedDate=" + usrAppQLinkModifiedDate
				+ ", strUsrAppQLinkCreatedDate=" + strUsrAppQLinkCreatedDate
				+ ", strUsrAppQLinkModifiedDate=" + strUsrAppQLinkModifiedDate
				+ ", usrAppQLinkResAttribute1=" + usrAppQLinkResAttribute1
				+ ", usrAppQLinkResAttribute2=" + usrAppQLinkResAttribute2
				+ ", usrAppQLinkResAttribute3=" + usrAppQLinkResAttribute3
				+ ", usrAppQLinkResAttribute4=" + usrAppQLinkResAttribute4
				+ ", usrAppQLinkResAttribute5=" + usrAppQLinkResAttribute5
				+ ", usrAppQLinkActions=" + usrAppQLinkActions + "]";
	}

}
