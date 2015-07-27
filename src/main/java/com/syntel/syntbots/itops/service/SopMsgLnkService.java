/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to SOP Msg link
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SopMsgLnkService {

	public void saveSopMsgLnk(SopMsgLnk sopMsgLnk) throws ApplicationException;

	public List<SopMsgLnk> getSopMsgLnkBySopId(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

	public List<SopMsgLnk> getSopMsgLnkByMsgKeyword(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

	public void updateSopMsglnk(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

	public List<SopMsgLnk> getCompleteSopMsgLnkList()
			throws ApplicationException;

	public List<SopDetails> getListSopByMessageKey(SopMsgLnk sopMsgLnk)
			throws ApplicationException;

	public List<SopDetails> getSortedSopBySopMsg(
			List<SopDetails> sopListForWorkflow,
			List<SopDetails> sopListByMsgKey) throws ApplicationException;

}
