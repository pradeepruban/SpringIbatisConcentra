/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/

package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopWrkflwLnk;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to SopWorkFlowLink.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SopWrkFlwLnkDAO {

	public List<WorkflowDetails> getWorkFlowListBySopId(int sopId)
			throws ApplicationException;

	public List<SopWrkflwLnk> getCompleteSopWorkflowLnkList()
			throws ApplicationException;

	public String getWorkFlowNameByWorkflowId(long workfLowId)
			throws ApplicationException;

}
