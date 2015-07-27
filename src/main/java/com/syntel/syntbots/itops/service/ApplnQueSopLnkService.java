/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.ApplnQueSopLnk;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Applcation
 * Queue Sop Link Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface ApplnQueSopLnkService {

	List<SopDetails> getSopListByApplnNameAndQueueName(String incdntAppName,
			String incdntAssgnmntGrp) throws ApplicationException;

	List<ApplnQueSopLnk> getCompleteApplicationQueueSopLinkList()
			throws ApplicationException;

}
