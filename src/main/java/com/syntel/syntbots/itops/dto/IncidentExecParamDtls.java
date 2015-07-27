/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
/**
*This class contains all the attributes related to Incident Execution Param Details.
*@author Syntel
*@version 1.0
*/
public class IncidentExecParamDtls implements Serializable {

	private static final long serialVersionUID = 1L;
	private int incidentExecId;
	private String paramName;
	private String paramValue;
	private String paramCode;
	private int deleteFlag;
	private long createdBy;
	private long modifiedBy;
	private Date createdDate;
	private Date modifiedDate;
	private String resAttribute1;
	private String resAttribute2;
	private String resAttribute3;
	private String resAttribute4;
	private String resAttribute5;
	public int getIncidentExecId() {
		return incidentExecId;
	}
	public void setIncidentExecId(int incidentExecId) {
		this.incidentExecId = incidentExecId;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public int getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
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
		return "IncidentExecParamDtls [incidentExecId=" + incidentExecId
				+ ", paramName=" + paramName + ", paramValue=" + paramValue
				+ ", paramCode=" + paramCode + ", deleteFlag=" + deleteFlag
				+ ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy
				+ ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", resAttribute1=" + resAttribute1
				+ ", resAttribute2=" + resAttribute2 + ", resAttribute3="
				+ resAttribute3 + ", resAttribute4=" + resAttribute4
				+ ", resAttribute5=" + resAttribute5 + "]";
	}
	
	
	
	
	
}
