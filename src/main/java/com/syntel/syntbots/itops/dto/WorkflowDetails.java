/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
*This class contains all the attributes related to Workflow Details.
*@author Syntel
*@version 1.0
*/
public class WorkflowDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private int wrkflwId;
	private String wrkflwName;
	private String wrkflwDesc;
	private String wrkflwUrl;
	private String wrkflwVersion;
	private String wrkflwDeploymentId;
	private Date wrkflwDecomisionDate;
	private String strDecomisionDate;
	private String wrkflwListenQueue;
	private int deleteFlag;
	private String strDeleteFlag;
	private int createdBy;
	private String createdByUserName;
	private int modifiedBy;
	private String modifiedByUserName;
	private Date createdDate;
	private String strCreatedDate;
	private Date modifiedDate;
	private String strModifiedDate;
	private String resAttribute1;
	private String resAttribute2;
	private String resAttribute3;
	private String resAttribute4;
	private String resAttribute5;
	private String wrkflwDefinitionId;
	private String wrkflwUsername;
	private String wrkflwPassword;
	
	private List<WorkflowParamLnk> workflowParamLnkList;

	public int getWrkflwId() {
		return wrkflwId;
	}

	public void setWrkflwId(int wrkflwId) {
		this.wrkflwId = wrkflwId;
	}

	public String getWrkflwName() {
		return wrkflwName;
	}

	public void setWrkflwName(String wrkflwName) {
		this.wrkflwName = wrkflwName;
	}

	public String getWrkflwDesc() {
		return wrkflwDesc;
	}

	public void setWrkflwDesc(String wrkflwDesc) {
		this.wrkflwDesc = wrkflwDesc;
	}

	public String getWrkflwUrl() {
		return wrkflwUrl;
	}

	public void setWrkflwUrl(String wrkflwUrl) {
		this.wrkflwUrl = wrkflwUrl;
	}

	public String getWrkflwVersion() {
		return wrkflwVersion;
	}

	public void setWrkflwVersion(String wrkflwVersion) {
		this.wrkflwVersion = wrkflwVersion;
	}

	public String getWrkflwDeploymentId() {
		return wrkflwDeploymentId;
	}

	public void setWrkflwDeploymentId(String wrkflwDeploymentId) {
		this.wrkflwDeploymentId = wrkflwDeploymentId;
	}

	public Date getWrkflwDecomisionDate() {
		return wrkflwDecomisionDate;
	}

	public void setWrkflwDecomisionDate(Date wrkflwDecomisionDate) {
		this.wrkflwDecomisionDate = wrkflwDecomisionDate;
	}

	public String getWrkflwListenQueue() {
		return wrkflwListenQueue;
	}

	public void setWrkflwListenQueue(String wrkflwListenQueue) {
		this.wrkflwListenQueue = wrkflwListenQueue;
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

	public String getWrkflwDefinitionId() {
		return wrkflwDefinitionId;
	}

	public void setWrkflwDefinitionId(String wrkflwDefinitionId) {
		this.wrkflwDefinitionId = wrkflwDefinitionId;
	}

	public String getWrkflwUsername() {
		return wrkflwUsername;
	}

	public void setWrkflwUsername(String wrkflwUsername) {
		this.wrkflwUsername = wrkflwUsername;
	}

	public String getWrkflwPassword() {
		return wrkflwPassword;
	}

	public void setWrkflwPassword(String wrkflwPassword) {
		this.wrkflwPassword = wrkflwPassword;
	}

	public List<WorkflowParamLnk> getWorkflowParamLnkList() {
		return workflowParamLnkList;
	}

	public void setWorkflowParamLnkList(List<WorkflowParamLnk> workflowParamLnkList) {
		this.workflowParamLnkList = workflowParamLnkList;
	}
	
	public String getStrDecomisionDate() {
		return strDecomisionDate;
	}

	public void setStrDecomisionDate(String strDecomisionDate) {
		this.strDecomisionDate = strDecomisionDate;
	}

	public String getStrDeleteFlag() {
		return strDeleteFlag;
	}

	public void setStrDeleteFlag(String strDeleteFlag) {
		this.strDeleteFlag = strDeleteFlag;
	}

	public String getCreatedByUserName() {
		return createdByUserName;
	}

	public void setCreatedByUserName(String createdByUserName) {
		this.createdByUserName = createdByUserName;
	}

	public String getModifiedByUserName() {
		return modifiedByUserName;
	}

	public void setModifiedByUserName(String modifiedByUserName) {
		this.modifiedByUserName = modifiedByUserName;
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

	@Override
	public String toString() {
		return "WorkflowDtls [wrkflwId=" + wrkflwId + ", wrkflwName="
				+ wrkflwName + ", wrkflwDesc=" + wrkflwDesc + ", wrkflwUrl="
				+ wrkflwUrl + ", wrkflwVersion=" + wrkflwVersion
				+ ", wrkflwDeploymentId=" + wrkflwDeploymentId
				+ ", wrkflwDecomisionDate=" + wrkflwDecomisionDate
				+ ", strDecomisionDate=" + strDecomisionDate
				+ ", wrkflwListenQueue=" + wrkflwListenQueue + ", deleteFlag="
				+ deleteFlag + ", strDeleteFlag=" + strDeleteFlag
				+ ", createdBy=" + createdBy + ", createdByUserName="
				+ createdByUserName + ", modifiedBy=" + modifiedBy
				+ ", modifiedByUserName=" + modifiedByUserName
				+ ", createdDate=" + createdDate + ", strCreatedDate="
				+ strCreatedDate + ", modifiedDate=" + modifiedDate
				+ ", strModifiedDate=" + strModifiedDate + ", resAttribute1="
				+ resAttribute1 + ", resAttribute2=" + resAttribute2
				+ ", resAttribute3=" + resAttribute3 + ", resAttribute4="
				+ resAttribute4 + ", resAttribute5=" + resAttribute5
				+ ", wrkflwDefinitionId=" + wrkflwDefinitionId
				+ ", wrkflwUsername=" + wrkflwUsername + ", workflowParamLnkList="
				+ workflowParamLnkList + "]";
	}

	
	
	

}
