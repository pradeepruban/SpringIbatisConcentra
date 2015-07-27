/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.ApplnQueSopLnk;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Application
 * Queue SopLink
 *
 * @author Syntel
 * @version 1.0
 */
public interface ApplnQueSopLnkDAO {

	List<SopDetails> getSopListByApplnNameAndQueueName(String incdntAppName,
			String incdntAssgnmntGrp) throws ApplicationException;

	List<ApplnQueSopLnk> getCompleteApplicationQueueSopLinkList()
			throws ApplicationException;

	String getApplicationNameByApplicationId(long applicationId)
			throws ApplicationException;

	String getQueueNameByQueueId(long queueId) throws ApplicationException;

	String getSopNameBySopId(long sopId) throws ApplicationException;
}
