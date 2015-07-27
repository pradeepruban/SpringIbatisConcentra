/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to User Application
 * Queue Link.
 *
 * @author Syntel
 * @version 1.0
 */
public interface UsrApplnQueLnkDAO {

	List<UsrApplnQueLnk> getCompleteUserApplicationQueueLinkList()
			throws ApplicationException;

	UsrApplnQueLnk getUsrApplnQueLnkDetailsByAppnameandQueName(long usrId,
			String incdntAppName, String incdntAssgnmntGrp)
			throws ApplicationException;

	int ValUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException;

	void addUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException;

	void updateUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException;

}
