/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
*This class contains all the attributes related to Incident Execution Details.
*@author Syntel
*@version 1.0
*/
public class IncidentExecDtls implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int incidentExecId;
	private String incidentId;
	private long usrId;
	private String usrName;
	private int applnId;
	private String applnName;
	private int queId;
	private String queName;
	private int sopId;
	private String sopName;
	private int wrkflwId;
	private String wrkflwName;
	private Date incidentExecStartDate;
	private Date incidentExecEndDate;
	private String strIncidentExecStartDate;
	private String strIncidentExecEndDate;
	private String incidentExecStatus;
	private String incidentExecRemarks;
	public String getStrIncidentExecStartDate() {
		return strIncidentExecStartDate;
	}

	public void setStrIncidentExecStartDate(String strIncidentExecStartDate) {
		this.strIncidentExecStartDate = strIncidentExecStartDate;
	}

	public String getStrIncidentExecEndDate() {
		return strIncidentExecEndDate;
	}

	public void setStrIncidentExecEndDate(String strIncidentExecEndDate) {
		this.strIncidentExecEndDate = strIncidentExecEndDate;
	}

	private String incidentExecExcpMsg;
	private String incidentExecExcpDtls;
	private String incidentExecExcpStcktrce;
	private int incdntDtlsId;
	
	
	private List<IncidentExecParamDtls> incidentExecParamDtlsList;

	
	public int getIncdntDtlsId() {
		return incdntDtlsId;
	}

	public void setIncdntDtlsId(int incdntDtlsId) {
		this.incdntDtlsId = incdntDtlsId;
	}

	public String getApplnName() {
		return applnName;
	}

	public void setApplnName(String applnName) {
		this.applnName = applnName;
	}

	public String getQueName() {
		return queName;
	}

	public void setQueName(String queName) {
		this.queName = queName;
	}

	public String getSopName() {
		return sopName;
	}

	public void setSopName(String sopName) {
		this.sopName = sopName;
	}

	public String getWrkflwName() {
		return wrkflwName;
	}

	public void setWrkflwName(String wrkflwName) {
		this.wrkflwName = wrkflwName;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public int getIncidentExecId() {
		return incidentExecId;
	}

	public void setIncidentExecId(int incidentExecId) {
		this.incidentExecId = incidentExecId;
	}

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public long getUsrId() {
		return usrId;
	}

	public void setUsrId(long usrId) {
		this.usrId = usrId;
	}

	public int getApplnId() {
		return applnId;
	}

	public void setApplnId(int applnId) {
		this.applnId = applnId;
	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public int getSopId() {
		return sopId;
	}

	public void setSopId(int sopId) {
		this.sopId = sopId;
	}

	public int getWrkflwId() {
		return wrkflwId;
	}

	public void setWrkflwId(int wrkflwId) {
		this.wrkflwId = wrkflwId;
	}

	public Date getIncidentExecStartDate() {
		return incidentExecStartDate;
	}

	public void setIncidentExecStartDate(Date incidentExecStartDate) {
		this.incidentExecStartDate = incidentExecStartDate;
	}

	public Date getIncidentExecEndDate() {
		return incidentExecEndDate;
	}

	public void setIncidentExecEndDate(Date incidentExecEndDate) {
		this.incidentExecEndDate = incidentExecEndDate;
	}

	public String getIncidentExecStatus() {
		return incidentExecStatus;
	}

	public void setIncidentExecStatus(String incidentExecStatus) {
		this.incidentExecStatus = incidentExecStatus;
	}

	public String getIncidentExecRemarks() {
		return incidentExecRemarks;
	}

	public void setIncidentExecRemarks(String incidentExecRemarks) {
		this.incidentExecRemarks = incidentExecRemarks;
	}

	public String getIncidentExecExcpMsg() {
		return incidentExecExcpMsg;
	}

	public void setIncidentExecExcpMsg(String incidentExecExcpMsg) {
		this.incidentExecExcpMsg = incidentExecExcpMsg;
	}

	public String getIncidentExecExcpDtls() {
		return incidentExecExcpDtls;
	}

	public void setIncidentExecExcpDtls(String incidentExecExcpDtls) {
		this.incidentExecExcpDtls = incidentExecExcpDtls;
	}

	public String getIncidentExecExcpStcktrce() {
		return incidentExecExcpStcktrce;
	}

	public void setIncidentExecExcpStcktrce(String incidentExecExcpStcktrce) {
		this.incidentExecExcpStcktrce = incidentExecExcpStcktrce;
	}

	public List<IncidentExecParamDtls> getIncidentExecParamDtlsList() {
		return incidentExecParamDtlsList;
	}

	public void setIncidentExecParamDtlsList(
			List<IncidentExecParamDtls> incidentExecParamDtlsList) {
		this.incidentExecParamDtlsList = incidentExecParamDtlsList;
	}

	@Override
	public String toString() {
		return "IncidentExecDtls [incidentExecId=" + incidentExecId
				+ ", incidentId=" + incidentId + ", usrId=" + usrId
				+ ", usrName=" + usrName + ", applnId=" + applnId
				+ ", applnName=" + applnName + ", queId=" + queId
				+ ", queName=" + queName + ", sopId=" + sopId + ", sopName="
				+ sopName + ", wrkflwId=" + wrkflwId + ", wrkflwName="
				+ wrkflwName + ", incidentExecStartDate="
				+ incidentExecStartDate + ", incidentExecEndDate="
				+ incidentExecEndDate + ", strIncidentExecStartDate="
				+ strIncidentExecStartDate + ", strIncidentExecEndDate="
				+ strIncidentExecEndDate + ", incidentExecStatus="
				+ incidentExecStatus + ", incidentExecRemarks="
				+ incidentExecRemarks + ", incidentExecExcpMsg="
				+ incidentExecExcpMsg + ", incidentExecExcpDtls="
				+ incidentExecExcpDtls + ", incidentExecExcpStcktrce="
				+ incidentExecExcpStcktrce + ", incdntDtlsId=" + incdntDtlsId
				+ ", incidentExecParamDtlsList=" + incidentExecParamDtlsList
				+ "]";
	}
	
	

}
