/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
*This class contains all the attributes related to Tools.
*@author Syntel
*@version 1.0
*/
public class IncidentDetails implements Serializable {

	private int incdntDtlsId;
	private String incdntId;
	private String incdntAppName;
	private String incdntSrtDsc;
	private String incdntCtgory;
	private String incdntPriority;
	private String incdntState;
	private String incdntAssgnmntGrp;
	private String incdntAssgndTo;
	private String incdntStatus;
	private String incdntActlElapsdTime;
	private String incdntDesc;
	private int incdntDltFlag;
	private int incdntcreatedBy;
	private int incdntmodifiedBy;
	private Date incdntmodifiedDate;
	private Date incdntcreatedDate;
	private String incdntrstAttr1;
	private String incdntrstAttr2;
	private String incdntrstAttr3;
	private String incdntrstAttr4;
	private String incdntrstAttr5;
	private String incdntAction;
	private String incidentOriginalSeverity;
	private String incidentMadeSla;
	private Date incidentOpenedDate;
	private Date incidentClosedDate;
	private String incidentExecStatus;
	private int openIncidents;
	private int severeIncidents;
	private Date startDate;
	private Date endDate; 
	private long usrId;
	//private List<UserDetails> userDetails;
	
	private String strIncidentOpenedDate;
	private String strIncidentClosedDate;
	private String strExecStartDate;
	private String incidentExecRemarks;
	private List<SopDetails> sopList;
	private List<WorkflowDetails> workFlowList;
	private List<WorkflowParamLnk> workFlowParamList;
	private List<SopParamDetails> SopParamDetails;
	
	private UsrApplnQueLnk usrApplnQueLnk;
	
	public UsrApplnQueLnk getUsrApplnQueLnk() {
		return usrApplnQueLnk;
	}
	public void setUsrApplnQueLnk(UsrApplnQueLnk usrApplnQueLnk) {
		this.usrApplnQueLnk = usrApplnQueLnk;
	}
	public List<SopParamDetails> getSopParamDetails() {
		return SopParamDetails;
	}
	public void setSopParamDetails(List<SopParamDetails> sopParamDetails) {
		SopParamDetails = sopParamDetails;
	}
	public long getUsrId() {
		return usrId;
	}
	public void setUsrId(long usrId) {
		this.usrId = usrId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getIncidentExecStatus() {
		return incidentExecStatus;
	}
	public void setIncidentExecStatus(String incidentExecStatus) {
		this.incidentExecStatus = incidentExecStatus;
	}
	public String getStrIncidentOpenedDate() {
		return strIncidentOpenedDate;
	}
	public void setStrIncidentOpenedDate(String strIncidentOpenedDate) {
		this.strIncidentOpenedDate = strIncidentOpenedDate;
	}
	public String getStrExecStartDate() {
		return strExecStartDate;
	}
	public void setStrExecStartDate(String strExecStartDate) {
		this.strExecStartDate = strExecStartDate;
	}

	public String getStrIncidentClosedDate() {
		return strIncidentClosedDate;
	}
	public void setStrIncidentClosedDate(String strIncidentClosedDate) {
		this.strIncidentClosedDate = strIncidentClosedDate;
	}
	
	public String getIncdntAction() {
		return incdntAction;
	}
	public void setIncdntAction(String incdntAction) {
		this.incdntAction = incdntAction;
	}
	public List<SopDetails> getSopList() {
		return sopList;
	}
	public void setSopList(List<SopDetails> sopList) {
		this.sopList = sopList;
	}
	public List<WorkflowDetails> getWorkFlowList() {
		return workFlowList;
	}
	public void setWorkFlowList(List<WorkflowDetails> workFlowList) {
		this.workFlowList = workFlowList;
	}
	public List<WorkflowParamLnk> getWorkFlowParamList() {
		return workFlowParamList;
	}
	public void setWorkFlowParamList(List<WorkflowParamLnk> workFlowParamList) {
		this.workFlowParamList = workFlowParamList;
	}
	public int getIncdntDtlsId() {
		return incdntDtlsId;
	}
	public void setIncdntDtlsId(int incdntDtlsId) {
		this.incdntDtlsId = incdntDtlsId;
	}
	public String getIncdntId() {
		return incdntId;
	}
	public void setIncdntId(String incdntId) {
		this.incdntId = incdntId;
	}
	public String getIncdntAppName() {
		return incdntAppName;
	}
	public void setIncdntAppName(String incdntAppName) {
		this.incdntAppName = incdntAppName;
	}
	public String getIncdntSrtDsc() {
		return incdntSrtDsc;
	}
	public void setIncdntSrtDsc(String incdntSrtDsc) {
		this.incdntSrtDsc = incdntSrtDsc;
	}
	public String getIncdntCtgory() {
		return incdntCtgory;
	}
	public void setIncdntCtgory(String incdntCtgory) {
		this.incdntCtgory = incdntCtgory;
	}
	public String getIncdntPriority() {
		return incdntPriority;
	}
	public void setIncdntPriority(String incdntPriority) {
		this.incdntPriority = incdntPriority;
	}
	public String getIncdntState() {
		return incdntState;
	}
	public void setIncdntState(String incdntState) {
		this.incdntState = incdntState;
	}
	public String getIncdntAssgnmntGrp() {
		return incdntAssgnmntGrp;
	}
	public void setIncdntAssgnmntGrp(String incdntAssgnmntGrp) {
		this.incdntAssgnmntGrp = incdntAssgnmntGrp;
	}
	public String getIncdntAssgndTo() {
		return incdntAssgndTo;
	}
	public void setIncdntAssgndTo(String incdntAssgndTo) {
		this.incdntAssgndTo = incdntAssgndTo;
	}
	public String getIncdntStatus() {
		return incdntStatus;
	}
	public void setIncdntStatus(String incdntStatus) {
		this.incdntStatus = incdntStatus;
	}
	public String getIncdntDesc() {
		return incdntDesc;
	}
	public void setIncdntDesc(String incdntDesc) {
		this.incdntDesc = incdntDesc;
	}
	public String getIncdntActlElapsdTime() {
		return incdntActlElapsdTime;
	}
	public void setIncdntActlElapsdTime(String incdntActlElapsdTime) {
		this.incdntActlElapsdTime = incdntActlElapsdTime;
	}
	public int getIncdntDltFlag() {
		return incdntDltFlag;
	}
	public void setIncdntDltFlag(int incdntDltFlag) {
		this.incdntDltFlag = incdntDltFlag;
	}
	
	public int getIncdntmodifiedBy() {
		return incdntmodifiedBy;
	}
	public void setIncdntmodifiedBy(int incdntmodifiedBy) {
		this.incdntmodifiedBy = incdntmodifiedBy;
	}
	public Date getIncdntcreatedDate() {
		return incdntcreatedDate;
	}
	public void setIncdntcreatedDate(Date incdntcreatedDate) {
		this.incdntcreatedDate = incdntcreatedDate;
	}
	public Date getIncdntmodifiedDate() {
		return incdntmodifiedDate;
	}
	public void setIncdntmodifiedDate(Date incdntmodifiedDate) {
		this.incdntmodifiedDate = incdntmodifiedDate;
	}
	public String getIncdntrstAttr1() {
		return incdntrstAttr1;
	}
	public void setIncdntrstAttr1(String incdntrstAttr1) {
		this.incdntrstAttr1 = incdntrstAttr1;
	}
	public String getIncdntrstAttr2() {
		return incdntrstAttr2;
	}
	public void setIncdntrstAttr2(String incdntrstAttr2) {
		this.incdntrstAttr2 = incdntrstAttr2;
	}
	public String getIncdntrstAttr3() {
		return incdntrstAttr3;
	}
	public void setIncdntrstAttr3(String incdntrstAttr3) {
		this.incdntrstAttr3 = incdntrstAttr3;
	}
	public String getIncdntrstAttr4() {
		return incdntrstAttr4;
	}
	public void setIncdntrstAttr4(String incdntrstAttr4) {
		this.incdntrstAttr4 = incdntrstAttr4;
	}
	public String getIncdntrstAttr5() {
		return incdntrstAttr5;
	}
	public void setIncdntrstAttr5(String incdntrstAttr5) {
		this.incdntrstAttr5 = incdntrstAttr5;
	}
	
	public String getIncidentOriginalSeverity() {
		return incidentOriginalSeverity;
	}
	public void setIncidentOriginalSeverity(String incidentOriginalSeverity) {
		this.incidentOriginalSeverity = incidentOriginalSeverity;
	}
	public String getIncidentMadeSla() {
		return incidentMadeSla;
	}
	public void setIncidentMadeSla(String incidentMadeSla) {
		this.incidentMadeSla = incidentMadeSla;
	}
	public Date getIncidentOpenedDate() {
		return incidentOpenedDate;
	}
	public void setIncidentOpenedDate(Date incidentOpenedDate) {
		this.incidentOpenedDate = incidentOpenedDate;
	}
	public Date getIncidentClosedDate() {
		return incidentClosedDate;
	}
	public void setIncidentClosedDate(Date incidentClosedDate) {
		this.incidentClosedDate = incidentClosedDate;
	}
	public int getIncdntcreatedBy() {
		return incdntcreatedBy;
	}
	public void setIncdntcreatedBy(int incdntcreatedBy) {
		this.incdntcreatedBy = incdntcreatedBy;
	}
	
	public int getOpenIncidents() {
		return openIncidents;
	}
	public void setOpenIncidents(int openIncidents) {
		this.openIncidents = openIncidents;
	}
	public int getSevereIncidents() {
		return severeIncidents;
	}
	public void setSevereIncidents(int severeIncidents) {
		this.severeIncidents = severeIncidents;
	}
	public String getIncidentExecRemarks() {
		return incidentExecRemarks;
	}
	public void setIncidentExecRemarks(String incidentExecRemarks) {
		this.incidentExecRemarks = incidentExecRemarks;
	}
	@Override
	public String toString() {
		return "IncidentDetails [incdntDtlsId=" + incdntDtlsId + ", incdntId="
				+ incdntId + ", incdntAppName=" + incdntAppName
				+ ", incdntSrtDsc=" + incdntSrtDsc + ", incdntCtgory="
				+ incdntCtgory + ", incdntPriority=" + incdntPriority
				+ ", incdntState=" + incdntState + ", incdntAssgnmntGrp="
				+ incdntAssgnmntGrp + ", incdntAssgndTo=" + incdntAssgndTo
				+ ", incdntStatus=" + incdntStatus + ", incdntActlElapsdTime="
				+ incdntActlElapsdTime + ", incdntDesc=" + incdntDesc
				+ ", incdntDltFlag=" + incdntDltFlag + ", incdntcreatedBy="
				+ incdntcreatedBy + ", incdntmodifiedBy=" + incdntmodifiedBy
				+ ", incdntmodifiedDate=" + incdntmodifiedDate
				+ ", incdntcreatedDate=" + incdntcreatedDate
				+ ", incdntrstAttr1=" + incdntrstAttr1 + ", incdntrstAttr2="
				+ incdntrstAttr2 + ", incdntrstAttr3=" + incdntrstAttr3
				+ ", incdntrstAttr4=" + incdntrstAttr4 + ", incdntrstAttr5="
				+ incdntrstAttr5 + ", incdntAction=" + incdntAction
				+ ", incidentOriginalSeverity=" + incidentOriginalSeverity
				+ ", incidentMadeSla=" + incidentMadeSla
				+ ", incidentOpenedDate=" + incidentOpenedDate
				+ ", incidentClosedDate=" + incidentClosedDate
				+ ", incidentExecStatus=" + incidentExecStatus
				+ ", openIncidents=" + openIncidents + ", severeIncidents="
				+ severeIncidents + ", startDate=" + startDate + ", endDate="
				+ endDate + ", usrId=" + usrId + ", strIncidentOpenedDate="
				+ strIncidentOpenedDate + ", strIncidentClosedDate="
				+ strIncidentClosedDate + ", strExecStartDate="
				+ strExecStartDate + ", incidentExecRemarks="
				+ incidentExecRemarks + ", sopList=" + sopList
				+ ", workFlowList=" + workFlowList + ", workFlowParamList="
				+ workFlowParamList + ", SopParamDetails=" + SopParamDetails
				+ ", usrApplnQueLnk=" + usrApplnQueLnk + "]";
	}
	
	
	
}
