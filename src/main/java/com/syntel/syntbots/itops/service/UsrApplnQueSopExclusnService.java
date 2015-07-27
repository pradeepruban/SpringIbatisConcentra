/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueSopExclusn;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to User
 * application queue SOP exclusion Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface UsrApplnQueSopExclusnService {

	List<UsrApplnQueSopExclusn> getCompleteUserApplicationQueueSopExclusionList()
			throws ApplicationException;

	List<SopDetails> getsopListNotAccessByUsr(UserDetails userDetails,
			IncidentDetails incidentDetailsForWrkFlw)
			throws ApplicationException;

	List<SopDetails> getSopListAccessByUsrforWrkflw(
			List<SopDetails> sopListForWorkflow,
			List<SopDetails> sopListNotAccessByUsr) throws ApplicationException;

}
