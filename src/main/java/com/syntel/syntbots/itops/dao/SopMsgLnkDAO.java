/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/

package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to SopMsgLnk.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SopMsgLnkDAO {

	void saveSopMsgLnk(SopMsgLnk sopMsgLnk) throws ApplicationException;

	List<SopMsgLnk> getSopMsgLnkBySopId(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

	List<SopMsgLnk> getSopMsgLnkByMsgKeyword(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

	void updateSopMsglnk(SopMsgLnk sopMsgLnk) throws ApplicationException;

	List<SopMsgLnk> getCompleteSopMsgLnkList() throws ApplicationException;

	String getUserShortNameByUserId(int createdBy) throws ApplicationException;

	List<SopDetails> getListSopByMessageKey(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

}
