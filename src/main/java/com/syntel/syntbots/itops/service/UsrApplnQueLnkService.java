/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to User
 * application queue link Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface UsrApplnQueLnkService {

	List<UsrApplnQueLnk> getCompleteUserApplicationQueueLinkList()
			throws ApplicationException;

	UsrApplnQueLnk getUsrApplnQueLnkDetailsByAppnameandQueName(
			UserDetails userDetails, IncidentDetails incidentDetailsForWrkFlw)
			throws ApplicationException;

	int ValUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException;

	void addUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException;

	void updateUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException;

}
