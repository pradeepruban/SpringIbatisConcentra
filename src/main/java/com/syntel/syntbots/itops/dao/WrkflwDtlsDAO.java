/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/	
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
*This interface  contains all the DAO layer methods related to Workflow Details.
*@author Syntel
*@version 1.0
*/
public interface WrkflwDtlsDAO {
	
	WorkflowDetails getWorkFlowDtls(WorkflowDetails workflowDtls) throws ApplicationException;

	List<WorkflowDetails> getWrkflwDtlsList() throws ApplicationException;

	WorkflowDetails getWrkflwDtlsByWrkflwName(WorkflowDetails workflowDtls) throws ApplicationException;

	int validateWrkflwName(WorkflowDetails workflowDtls)throws ApplicationException;

	void addWrkflwDtls(WorkflowDetails workflowDtls) throws ApplicationException;

	void updateWrkflwDtls(WorkflowDetails workflowDtls) throws ApplicationException;

}
