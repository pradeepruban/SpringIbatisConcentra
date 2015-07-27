/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.ApplnQueSopLnkDAO;
import com.syntel.syntbots.itops.dao.SopMsgLnkDAO;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * SOP message Link Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("sopMsgLnkService")
public class SopMsgLnkServiceImpl implements SopMsgLnkService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SopMsgLnkDAO sopMsgLnkDAO;

	@Autowired
	private ApplnQueSopLnkDAO applicationQueueSopLinkDAO;

	/**
	 * This method is called to save SOP message link details
	 *
	 * @param sopmessageLinkDetails
	 * 
	 * @return void
	 * @exception - ApplicationException in case of error
	 */
	public void saveSopMsgLnk(SopMsgLnk sopMsgLnk) throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: saveSopMsgLnk() ");
		try {
			sopMsgLnkDAO.saveSopMsgLnk(sopMsgLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.saveSopMsgLnk", e);
		}
		log.info("Just before leaving  SopMsgLnkServiceImpl: saveSopMsgLnk() method");
	}

	/**
	 * This method is called to get list of SOP message link details based on
	 * SOP IdS
	 *
	 * @param sopmessageLinkDetails
	 *            
	 * @return List of SOP message link details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopMsgLnk> getSopMsgLnkBySopId(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: getSopMsgLnkBySopId() ");
		List<SopMsgLnk> sopMsgLnkBySopId = null;
		try {
			sopMsgLnkBySopId = sopMsgLnkDAO.getSopMsgLnkBySopId(sopMsgLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getSopMsgLnkBySopId", e);
		}
		log.info("Just before leaving  SopMsgLnkServiceImpl: getSopMsgLnkBySopId() method");

		return sopMsgLnkBySopId;
	}

	/**
	 * This method is called to get list of SOP message link details based
	 * message keyword
	 *
	 * @param sopmessageLinkDetails
	 *            
	 * @return List of SOP message link details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopMsgLnk> getSopMsgLnkByMsgKeyword(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: getSopMsgLnkByMsgKeyword() ");
		List<SopMsgLnk> sopMsgLnkByMsgKeyword = null;
		try {
			sopMsgLnkByMsgKeyword = sopMsgLnkDAO
					.getSopMsgLnkByMsgKeyword(sopMsgLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getSopMsgLnkByMsgKeyword", e);
		}
		log.info("Just before leaving  SopMsgLnkServiceImpl: getSopMsgLnkByMsgKeyword() method");
		return sopMsgLnkByMsgKeyword;
	}

	/**
	 * This method is called to update SOP message link details
	 *
	 * @param sopmessageLinkDetails
	 *           
	 * @return void
	 * @exception - ApplicationException in case of error
	 */
	public void updateSopMsglnk(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: updateSopMsglnk() ");
		try {
			sopMsgLnkDAO.updateSopMsglnk(sopMsgLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.updateSopMsglnk", e);
		}
		log.info("Just before leaving  SopMsgLnkServiceImpl: updateSopMsglnk() method");
	}

	/**
	 * This method is called to get list of SOP message link details
	 *
	 * @return List of SOP message link details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopMsgLnk> getCompleteSopMsgLnkList()
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkServiceImpl::getCompleteSopMsgLnkList() method");
		List<SopMsgLnk> sopMsgLnkList = null;
		try {
			sopMsgLnkList = sopMsgLnkDAO.getCompleteSopMsgLnkList();
			for (SopMsgLnk sopMsgLnk : sopMsgLnkList) {
				String strCreatedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(sopMsgLnk.getCreatedBy());
				sopMsgLnk
						.setStrCreatedByShortUserName(strCreatedByShortUserName);
				String strModifiedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(sopMsgLnk.getModifiedBy());
				sopMsgLnk
						.setStrModifiedByShortUserName(strModifiedByShortUserName);
				String sopName = applicationQueueSopLinkDAO
						.getSopNameBySopId(sopMsgLnk.getSopId());
				sopMsgLnk.setSopName(sopName);
			}

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getCompleteSopMsgLnkList", e);
		}
		log.info("Just before leaving SopMsgLnkServiceImpl::getCompleteSopMsgLnkList()"
				+ sopMsgLnkList);
		return sopMsgLnkList;
	}

	/**
	 * This method is called to get SOP List based on the message key link
	 * details
	 *
	 * @param messageKey
	 * @return List of SOP message link details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopDetails> getListSopByMessageKey(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkServiceImpl::getListSopByMessageKey() method");
		List<SopDetails> sopMessageList = null;
		try {
			sopMessageList = sopMsgLnkDAO.getListSopByMessageKey(sopMsgLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnk", sopMsgLnk);
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getListSopByMessageKey", e, argsMap);
		}

		log.info("Just before leaving sopMsgLnkDAO:: getListSopByMessageKey:"
				+ sopMessageList);
		return sopMessageList;
	}

	/**
	 * This method is called to get SOP List sort by the message based sop list
	 * from sopmsglink
	 *
	 * @param messageKey
	 * @return List of SOP message link details
	 * @exception - ApplicationException in case of error
	 */

	public List<SopDetails> getSortedSopBySopMsg(
			List<SopDetails> sopListForWorkflow,
			List<SopDetails> sopListByMsgKey) throws ApplicationException {
		log.info("Entered inside SopMsgLnkServiceImpl::getSortedSopBySopMsg() method");
		List<SopDetails> sopListAftSortedByMsg = new ArrayList<SopDetails>();

		try {
			for (SopDetails sopByMsgKey : sopListByMsgKey)

			{
				for (SopDetails sopForWrkflw : sopListForWorkflow) {
					if ((sopForWrkflw.getSopId()) == (sopByMsgKey.getSopId())) {
						sopListAftSortedByMsg.add(sopByMsgKey);
						break;
					}

				}
			}

			for (SopDetails sopForWrkflw : sopListForWorkflow) {
				boolean sopAlreadyAdded = false;
				for (SopDetails sopAftSorted : sopListAftSortedByMsg) {
					if (sopForWrkflw.getSopId() == sopAftSorted.getSopId()) {
						sopAlreadyAdded = true;
					}
				}

				if (!sopAlreadyAdded) {
					sopListAftSortedByMsg.add(sopForWrkflw);
				}
			}

		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopListForWorkflow", sopListForWorkflow);
			argsMap.put("sopListByMsgKey", sopListByMsgKey);
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getSortedSopBySopMsg", e, argsMap);
		}
		log.info("Just before leaving SopMsgLnkServiceImpl::getSortedSopBySopMsg() method:getFilterdSopBySopMsg:"
				+ sopListAftSortedByMsg);
		return sopListAftSortedByMsg;
	}
}
