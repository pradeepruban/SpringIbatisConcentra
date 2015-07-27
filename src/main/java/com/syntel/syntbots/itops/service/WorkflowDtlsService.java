/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Workflow
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface WorkflowDtlsService {

	List<WorkflowDetails> getWrkflwDtlsList() throws ApplicationException;

	
	int validateWrkflwName(WorkflowDetails workflowDtls) throws ApplicationException;

	void saveWrkflwDtls(WorkflowDetails workflowDtls) throws ApplicationException;
	
	WorkflowDetails getWrkflwDtlsByWrkflwName(WorkflowDetails workflowDtls)
			throws ApplicationException;

}
