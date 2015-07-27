/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/

package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
*This interface  contains all the DAO layer methods related to WorkflowParamLnk.
*@author Syntel
*@version 1.0
*/
public interface WrkflwPrmLnkDAO {
	
	public List<WorkflowParamLnk> getWorkflowParamLinkDtls(WorkflowDetails workflowDtls) throws ApplicationException;

	public List<WorkflowParamLnk> getWorkflowParamListByWrkflwId(long wrkflwId) throws ApplicationException;

	public List<WorkflowParamLnk> getEncryptedParamNamesByWrkflwId(WorkflowDetails workflowDtls) throws ApplicationException;

	public List<WorkflowParamLnk> getEncryptedParamNamesByIncdntExecId(IncidentExecDtls incidentExecDtls) throws ApplicationException;
	
	public List<WorkflowParamLnk> getWorkflowParamListTobeShowToUserByWrkflwId(long wrkflwId) throws ApplicationException;

	public List<WorkflowParamLnk> getWorkflwParamCodeListBySOPId(SopDetails sopDetails) throws ApplicationException;

	public int validateWorkflowParamName(WorkflowParamLnk workflowParamLnk) throws ApplicationException;

	public void addWrkflwParamDtls(WorkflowParamLnk workflowParamLnk) throws ApplicationException;

	public void updateWrkflwparamDtls(WorkflowParamLnk workflowParamLnk) throws ApplicationException;

}
