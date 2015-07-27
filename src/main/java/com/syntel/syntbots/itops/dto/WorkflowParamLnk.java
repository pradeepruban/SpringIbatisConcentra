/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
*This class contains all the attributes related to Workflow param link Details.
*@author Syntel
*@version 1.0
*/
public class WorkflowParamLnk implements Serializable {

	private int wrkflwParamLnkId;
	private int wrkflwId;
	private String paramName;
	private String paramType;
	private String paramValidation;
	private String strParamValidation;
	private int paramOrder;
	private String paramCode;
	private String paramDesc;
	private byte paramMandatory;
	private String strParamMandatory;
	private String paramDefaultValue;
	private byte paramToBeStored;
	private String strParamToBeStored;
	private byte paramToBeEncrypted;
	private String strParamToBeEncrypted;
	private int paramToBeShown;
	private String strParamToBeShown;
	private int paramValToBeShown;
	private String strParamValToBeShown;
	private String paramTypeInWorkflow;
	private int considerSopParamDtl;
	private String strConsiderSopParamDtl;
	private int deleteFlag;
	private String strDeleteFlag;
	private int createdBy;
	private String createdByUsernameParam;
	private int modifiedBy;
	private String modifiedByUsernameParam;
	private Date createdDate;
	private String strCreatedDateParam;
	private Date modifiedDate;
	private String strModifiedDateParam;
	private String resAttribute1;
	private String resAttribute2;
	private String resAttribute3;
	private String resAttribute4;
	private String resAttribute5;
	private String wrkflwParamAction;
	
	
	
	public String getStrParamValToBeShown() {
		return strParamValToBeShown;
	}
	public void setStrParamValToBeShown(String strParamValToBeShown) {
		this.strParamValToBeShown = strParamValToBeShown;
	}
	public int getWrkflwParamLnkId() {
		return wrkflwParamLnkId;
	}
	public void setWrkflwParamLnkId(int wrkflwParamLnkId) {
		this.wrkflwParamLnkId = wrkflwParamLnkId;
	}
	public String getWrkflwParamAction() {
		return wrkflwParamAction;
	}
	public void setWrkflwParamAction(String wrkflwParamAction) {
		this.wrkflwParamAction = wrkflwParamAction;
	}
	public String getStrParamValidation() {
		return strParamValidation;
	}
	public void setStrParamValidation(String strParamValidation) {
		this.strParamValidation = strParamValidation;
	}
	public String getStrParamMandatory() {
		return strParamMandatory;
	}
	public void setStrParamMandatory(String strParamMandatory) {
		this.strParamMandatory = strParamMandatory;
	}
	public String getStrParamToBeStored() {
		return strParamToBeStored;
	}
	public void setStrParamToBeStored(String strParamToBeStored) {
		this.strParamToBeStored = strParamToBeStored;
	}
	public String getStrParamToBeEncrypted() {
		return strParamToBeEncrypted;
	}
	public void setStrParamToBeEncrypted(String strParamToBeEncrypted) {
		this.strParamToBeEncrypted = strParamToBeEncrypted;
	}
	public String getStrParamToBeShown() {
		return strParamToBeShown;
	}
	public void setStrParamToBeShown(String strParamToBeShown) {
		this.strParamToBeShown = strParamToBeShown;
	}
	public String getStrConsiderSopParamDtl() {
		return strConsiderSopParamDtl;
	}
	public void setStrConsiderSopParamDtl(String strConsiderSopParamDtl) {
		this.strConsiderSopParamDtl = strConsiderSopParamDtl;
	}
	public String getStrDeleteFlag() {
		return strDeleteFlag;
	}
	public void setStrDeleteFlag(String strDeleteFlag) {
		this.strDeleteFlag = strDeleteFlag;
	}
	
	public String getCreatedByUsernameParam() {
		return createdByUsernameParam;
	}
	public void setCreatedByUsernameParam(String createdByUsernameParam) {
		this.createdByUsernameParam = createdByUsernameParam;
	}
	public String getModifiedByUsernameParam() {
		return modifiedByUsernameParam;
	}
	public void setModifiedByUsernameParam(String modifiedByUsernameParam) {
		this.modifiedByUsernameParam = modifiedByUsernameParam;
	}
	
	public String getStrCreatedDateParam() {
		return strCreatedDateParam;
	}
	public void setStrCreatedDateParam(String strCreatedDateParam) {
		this.strCreatedDateParam = strCreatedDateParam;
	}
	public String getStrModifiedDateParam() {
		return strModifiedDateParam;
	}
	public void setStrModifiedDateParam(String strModifiedDateParam) {
		this.strModifiedDateParam = strModifiedDateParam;
	}
	public String getParamCode() {
		return paramCode;
	}
	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}
	public String getParamDesc() {
		return paramDesc;
	}
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}
	public int getConsiderSopParamDtl() {
		return considerSopParamDtl;
	}
	public void setConsiderSopParamDtl(int considerSopParamDtl) {
		this.considerSopParamDtl = considerSopParamDtl;
	}
	public int getWrkflwId() {
		return wrkflwId;
	}
	public void setWrkflwId(int wrkflwId) {
		this.wrkflwId = wrkflwId;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamType() {
		return paramType;
	}
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}
	public String getParamValidation() {
		return paramValidation;
	}
	public void setParamValidation(String paramValidation) {
		this.paramValidation = paramValidation;
	}
	public int getParamOrder() {
		return paramOrder;
	}
	public void setParamOrder(int paramOrder) {
		this.paramOrder = paramOrder;
	}
	public byte getParamMandatory() {
		return paramMandatory;
	}
	
	public int getParamValToBeShown() {
		return paramValToBeShown;
	}
	public void setParamValToBeShown(int paramValToBeShown) {
		this.paramValToBeShown = paramValToBeShown;
	}
	public String getParamTypeInWorkflow() {
		return paramTypeInWorkflow;
	}
	public void setParamTypeInWorkflow(String paramTypeInWorkflow) {
		this.paramTypeInWorkflow = paramTypeInWorkflow;
	}
	
	public void setParamMandatory(byte paramMandatory) {
		this.paramMandatory = paramMandatory;
	}
	public String getParamDefaultValue() {
		return paramDefaultValue;
	}
	public void setParamDefaultValue(String paramDefaultValue) {
		this.paramDefaultValue = paramDefaultValue;
	}
	public byte getParamToBeStored() {
		return paramToBeStored;
	}
	public void setParamToBeStored(byte paramToBeStored) {
		this.paramToBeStored = paramToBeStored;
	}
	public byte getParamToBeEncrypted() {
		return paramToBeEncrypted;
	}
	public void setParamToBeEncrypted(byte paramToBeEncrypted) {
		this.paramToBeEncrypted = paramToBeEncrypted;
	}
	
	public int getParamToBeShown() {
		return paramToBeShown;
	}
	public void setParamToBeShown(int paramToBeShown) {
		this.paramToBeShown = paramToBeShown;
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
		return "WorkflowParamLnk [wrkflwParamLnkId=" + wrkflwParamLnkId
				+ ", wrkflwId=" + wrkflwId + ", paramName=" + paramName
				+ ", paramType=" + paramType + ", paramValidation="
				+ paramValidation + ", strParamValidation="
				+ strParamValidation + ", paramOrder=" + paramOrder
				+ ", paramCode=" + paramCode + ", paramDesc=" + paramDesc
				+ ", paramMandatory=" + paramMandatory + ", strParamMandatory="
				+ strParamMandatory + ", paramDefaultValue="
				+ paramDefaultValue + ", paramToBeStored=" + paramToBeStored
				+ ", strParamToBeStored=" + strParamToBeStored
				+ ", paramToBeEncrypted=" + paramToBeEncrypted
				+ ", strParamToBeEncrypted=" + strParamToBeEncrypted
				+ ", paramToBeShown=" + paramToBeShown + ", strParamToBeShown="
				+ strParamToBeShown + ", paramValToBeShown="
				+ paramValToBeShown + ", strParamValToBeShown="
				+ strParamValToBeShown + ", paramTypeInWorkflow="
				+ paramTypeInWorkflow + ", considerSopParamDtl="
				+ considerSopParamDtl + ", strConsiderSopParamDtl="
				+ strConsiderSopParamDtl + ", deleteFlag=" + deleteFlag
				+ ", strDeleteFlag=" + strDeleteFlag + ", createdBy="
				+ createdBy + ", createdByUsernameParam="
				+ createdByUsernameParam + ", modifiedBy=" + modifiedBy
				+ ", modifiedByUsernameParam=" + modifiedByUsernameParam
				+ ", createdDate=" + createdDate + ", strCreatedDateParam="
				+ strCreatedDateParam + ", modifiedDate=" + modifiedDate
				+ ", strModifiedDateParam=" + strModifiedDateParam
				+ ", resAttribute1=" + resAttribute1 + ", resAttribute2="
				+ resAttribute2 + ", resAttribute3=" + resAttribute3
				+ ", resAttribute4=" + resAttribute4 + ", resAttribute5="
				+ resAttribute5 + ", wrkflwParamAction=" + wrkflwParamAction
				+ "]";
	}
	
	
}
