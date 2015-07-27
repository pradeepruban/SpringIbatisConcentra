/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
*This interface contains all the Service layer methods related to Workflow param link Details.
*@author Syntel
*@version 1.0
*/
public interface WrkflwPrmLnkService {

	List<WorkflowParamLnk> getWorkflowParamListByWrkflwId(int wrkflwId) throws ApplicationException;

	List<WorkflowParamLnk> getEncryptedParamNamesByWrkflwId(WorkflowDetails workflowDtls) throws ApplicationException;

	List<WorkflowParamLnk> getEncryptedParamNamesByIncdntExecId(IncidentExecDtls incidentExecDtls) throws ApplicationException;
	
	public List<WorkflowParamLnk> getWorkflowParamListTobeShowToUserByWrkflwId(int wrkflwId) throws ApplicationException;

	List<WorkflowParamLnk> getWorkflwParamCodeListBySOPId(SopDetails sopDetails) throws ApplicationException;

	int validateWorkflowParamName(WorkflowParamLnk workflowParamLnk) throws ApplicationException;

	void saveWrkflwParamDtls(WorkflowParamLnk workflowParamLnk) throws ApplicationException;

}
