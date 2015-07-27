/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;

/**
*This class contains all the attributes related to SOP workflow link Details.
*@author Syntel
*@version 1.0
*/
public class SopWrkflwLnk implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private long sopId;
	private String sopName;
	private long workFlowId;
	private String workflowName;
	private int sopWrkflwLnkDeleteFlag;
	private int sopWrkflwLnkDefaultFlag;
	private int sopWrkflwLnkCreatedBy;
	private int sopWrkflwLnkModifiedBy;
	private String strSopWrkflwLnkCreatedByShortUserName;
	private String strSopWrkflwLnkModifiedByShortUserName;
	private Date sopWrkflwLnkCreatedDate;
	private Date sopWrkflwLnkModifiedDate;
	private String strSopWrkflwLnkCreatedDate;
	private String strSopWrkflwLnkModifiedDate;
	private String sopWrkflwLnkResAttribute1;
	private String sopWrkflwLnkResAttribute2;
	private String sopWrkflwLnkResAttribute3;
	private String sopWrkflwLnkResAttribute4;
	private String sopWrkflwLnkResAttribute5;
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
	public long getWorkFlowId() {
		return workFlowId;
	}
	public void setWorkFlowId(long workFlowId) {
		this.workFlowId = workFlowId;
	}
	public String getWorkflowName() {
		return workflowName;
	}
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
	public int getSopWrkflwLnkDeleteFlag() {
		return sopWrkflwLnkDeleteFlag;
	}
	public void setSopWrkflwLnkDeleteFlag(int sopWrkflwLnkDeleteFlag) {
		this.sopWrkflwLnkDeleteFlag = sopWrkflwLnkDeleteFlag;
	}
	public int getSopWrkflwLnkDefaultFlag() {
		return sopWrkflwLnkDefaultFlag;
	}
	public void setSopWrkflwLnkDefaultFlag(int sopWrkflwLnkDefaultFlag) {
		this.sopWrkflwLnkDefaultFlag = sopWrkflwLnkDefaultFlag;
	}
	public int getSopWrkflwLnkCreatedBy() {
		return sopWrkflwLnkCreatedBy;
	}
	public void setSopWrkflwLnkCreatedBy(int sopWrkflwLnkCreatedBy) {
		this.sopWrkflwLnkCreatedBy = sopWrkflwLnkCreatedBy;
	}
	public int getSopWrkflwLnkModifiedBy() {
		return sopWrkflwLnkModifiedBy;
	}
	public void setSopWrkflwLnkModifiedBy(int sopWrkflwLnkModifiedBy) {
		this.sopWrkflwLnkModifiedBy = sopWrkflwLnkModifiedBy;
	}
	public String getStrSopWrkflwLnkCreatedByShortUserName() {
		return strSopWrkflwLnkCreatedByShortUserName;
	}
	public void setStrSopWrkflwLnkCreatedByShortUserName(
			String strSopWrkflwLnkCreatedByShortUserName) {
		this.strSopWrkflwLnkCreatedByShortUserName = strSopWrkflwLnkCreatedByShortUserName;
	}
	public String getStrSopWrkflwLnkModifiedByShortUserName() {
		return strSopWrkflwLnkModifiedByShortUserName;
	}
	public void setStrSopWrkflwLnkModifiedByShortUserName(
			String strSopWrkflwLnkModifiedByShortUserName) {
		this.strSopWrkflwLnkModifiedByShortUserName = strSopWrkflwLnkModifiedByShortUserName;
	}
	public Date getSopWrkflwLnkCreatedDate() {
		return sopWrkflwLnkCreatedDate;
	}
	public void setSopWrkflwLnkCreatedDate(Date sopWrkflwLnkCreatedDate) {
		this.sopWrkflwLnkCreatedDate = sopWrkflwLnkCreatedDate;
	}
	public Date getSopWrkflwLnkModifiedDate() {
		return sopWrkflwLnkModifiedDate;
	}
	public void setSopWrkflwLnkModifiedDate(Date sopWrkflwLnkModifiedDate) {
		this.sopWrkflwLnkModifiedDate = sopWrkflwLnkModifiedDate;
	}
	public String getStrSopWrkflwLnkCreatedDate() {
		return strSopWrkflwLnkCreatedDate;
	}
	public void setStrSopWrkflwLnkCreatedDate(String strSopWrkflwLnkCreatedDate) {
		this.strSopWrkflwLnkCreatedDate = strSopWrkflwLnkCreatedDate;
	}
	public String getStrSopWrkflwLnkModifiedDate() {
		return strSopWrkflwLnkModifiedDate;
	}
	public void setStrSopWrkflwLnkModifiedDate(String strSopWrkflwLnkModifiedDate) {
		this.strSopWrkflwLnkModifiedDate = strSopWrkflwLnkModifiedDate;
	}
	public String getSopWrkflwLnkResAttribute1() {
		return sopWrkflwLnkResAttribute1;
	}
	public void setSopWrkflwLnkResAttribute1(String sopWrkflwLnkResAttribute1) {
		this.sopWrkflwLnkResAttribute1 = sopWrkflwLnkResAttribute1;
	}
	public String getSopWrkflwLnkResAttribute2() {
		return sopWrkflwLnkResAttribute2;
	}
	public void setSopWrkflwLnkResAttribute2(String sopWrkflwLnkResAttribute2) {
		this.sopWrkflwLnkResAttribute2 = sopWrkflwLnkResAttribute2;
	}
	public String getSopWrkflwLnkResAttribute3() {
		return sopWrkflwLnkResAttribute3;
	}
	public void setSopWrkflwLnkResAttribute3(String sopWrkflwLnkResAttribute3) {
		this.sopWrkflwLnkResAttribute3 = sopWrkflwLnkResAttribute3;
	}
	public String getSopWrkflwLnkResAttribute4() {
		return sopWrkflwLnkResAttribute4;
	}
	public void setSopWrkflwLnkResAttribute4(String sopWrkflwLnkResAttribute4) {
		this.sopWrkflwLnkResAttribute4 = sopWrkflwLnkResAttribute4;
	}
	public String getSopWrkflwLnkResAttribute5() {
		return sopWrkflwLnkResAttribute5;
	}
	public void setSopWrkflwLnkResAttribute5(String sopWrkflwLnkResAttribute5) {
		this.sopWrkflwLnkResAttribute5 = sopWrkflwLnkResAttribute5;
	}
	@Override
	public String toString() {
		return "SopWorkflowLink [sopId=" + sopId + ", workFlowId=" + workFlowId
				+ ", sopWrkflwLnkDeleteFlag=" + sopWrkflwLnkDeleteFlag
				+ ", sopWrkflwLnkCreatedBy=" + sopWrkflwLnkCreatedBy
				+ ", sopWrkflwLnkModifiedBy=" + sopWrkflwLnkModifiedBy
				+ ", strSopWrkflwLnkCreatedByShortUserName="
				+ strSopWrkflwLnkCreatedByShortUserName
				+ ", strSopWrkflwLnkModifiedByShortUserName="
				+ strSopWrkflwLnkModifiedByShortUserName
				+ ", sopWrkflwLnkCreatedDate=" + sopWrkflwLnkCreatedDate
				+ ", sopWrkflwLnkModifiedDate=" + sopWrkflwLnkModifiedDate
				+ ", strSopWrkflwLnkCreatedDate=" + strSopWrkflwLnkCreatedDate
				+ ", strSopWrkflwLnkModifiedDate="
				+ strSopWrkflwLnkModifiedDate + ", sopWrkflwLnkResAttribute1="
				+ sopWrkflwLnkResAttribute1 + ", sopWrkflwLnkResAttribute2="
				+ sopWrkflwLnkResAttribute2 + ", sopWrkflwLnkResAttribute3="
				+ sopWrkflwLnkResAttribute3 + ", sopWrkflwLnkResAttribute4="
				+ sopWrkflwLnkResAttribute4 + ", sopWrkflwLnkResAttribute5="
				+ sopWrkflwLnkResAttribute5 + "]";
	}
	
	

}
