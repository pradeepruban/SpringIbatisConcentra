/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueSopExclusn;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to
 * UserApplicationQueueSopExclusion.
 *
 * @author Syntel
 * @version 1.0
 */
public interface UsrApplnQueSopExclusnDAO {

	List<UsrApplnQueSopExclusn> getCompleteUserApplicationQueueSopExclusionList()
			throws ApplicationException;

	List<SopDetails> getsopListNotAccessByUsr(long usrId, String incdntAppName,
			String incdntAssgnmntGrp) throws ApplicationException;

}
