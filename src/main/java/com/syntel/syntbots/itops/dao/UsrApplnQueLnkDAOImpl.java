/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
import com.syntel.syntbots.itops.mapper.UsrApplnQueLnkMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to
 * UserApplicationQueueLink.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("userApplicationQueueLinkDAO")
public class UsrApplnQueLnkDAOImpl implements UsrApplnQueLnkDAO {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UsrApplnQueLnkMapper userApplicationQueueLinkMapper;

	/**
	 * This method is called to get all the Complete User Application Queue Link
	 * Lists
	 *
	 * @param
	 * @returnThis List of User application queue link details
	 * @exception - ApplicationException in case of error
	 */
	public List<UsrApplnQueLnk> getCompleteUserApplicationQueueLinkList()
			throws ApplicationException {

		log.info("Entered inside UsrApplnQueLnkDAOImpl:getCompleteUserApplicationQueueLinkList():");
		List<UsrApplnQueLnk> userApplicationQueueLinkList = null;
		try {
			userApplicationQueueLinkList = userApplicationQueueLinkMapper
					.getCompleteUserApplicationQueueLinkList();
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("UserApplicationQueueLinkList",
					userApplicationQueueLinkList);
			throw new ApplicationException(
					"UsrApplnQueLnkDAOImpl.getCompleteUserApplicationQueueLinkList",
					e, argsMap);
		}
		log.info("Just before leaving UsrApplnQueLnkDAOImpl:getCompleteUserApplicationQueueLinkList()");
		return userApplicationQueueLinkList;
	}

	/**
	 * This method is called to get User Application Queue Link based on the
	 * application and queue information of the logged user is get linked
	 *
	 * @param userDetails
	 *            ,incident application name,incident assignment group
	 * @returnThis User Appln Que Lnk details for respected user
	 * @exception - ApplicationException in case of error
	 */

	public UsrApplnQueLnk getUsrApplnQueLnkDetailsByAppnameandQueName(
			long usrId, String incdntAppName, String incdntAssgnmntGrp)
			throws ApplicationException {

		log.info("Entered inside UsrApplnQueLnkDAOImpl:getUsrApplnQueLnkDetailsByAppnameandQueName():");
		UsrApplnQueLnk usrApplnQueLnkDetails = null;
		try {
			usrApplnQueLnkDetails = userApplicationQueueLinkMapper
					.getUsrApplnQueLnkDetailsByAppnameandQueName(usrId,
							incdntAppName, incdntAssgnmntGrp);

		} catch (Exception e) {

			Map argsMap = new HashMap();
			argsMap.put("UsrApplnQueLnk", usrApplnQueLnkDetails);
			throw new ApplicationException(
					"UsrApplnQueLnkDAOimpl.getUsrApplnQueLnkDetailsByAppnameandQueName",
					e, argsMap);
		}
		log.info("Just before leaving UsrApplnQueLnkDAOImpl:getUsrApplnQueLnkDetailsByAppnameandQueName()");
		return usrApplnQueLnkDetails;
	}
	/**
	 * This method is called to validate User Application Queue Link details while creating new link.
	 * @param  User Application Queue Link details
	 * @return int count of User Application Queue
	 * @throws ApplicationException
	 */
	public int ValUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueLnkDAOImpl::ValUsrApplnQueLinkDtls() method");
		int countUsrApplnQueLink = 0;
		try {
			countUsrApplnQueLink = userApplicationQueueLinkMapper.ValUsrApplnQueLinkDtls(usrApplnQueLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrApplnQueLnk", usrApplnQueLnk);
			throw new ApplicationException(
					"UsrApplnQueLnkDAOimpl.ValUsrApplnQueLinkDtls", e, argsMap);
		}
		log.info("Just before leaving  UsrApplnQueLnkDAOImpl:ValUsrApplnQueLinkDtls() method");
		return countUsrApplnQueLink;
	}
	/**
	 * This method is called to add new User Application Queue Link details.
	 * @param  User Application Queue Link details
	 * @return void
	 * @throws ApplicationException
	 */
	public void addUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueLnkDAOImpl::addUsrApplnQueLinkDtls() method");
		try{
			userApplicationQueueLinkMapper.addUsrApplnQueLinkDtls(usrApplnQueLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrApplnQueLnk", usrApplnQueLnk);
			throw new ApplicationException(
					"UsrApplnQueLnkDAOimpl.addUsrApplnQueLinkDtls", e, argsMap);
		}
		log.info("Just before leaving  UsrApplnQueLnkDAOImpl:addUsrApplnQueLinkDtls() method");
		
	}
	/**
	 * This method is called to update existing User Application Queue Link details.
	 * @param  User Application Queue Link details
	 * @return Void
	 * @throws ApplicationException
	 */
	public void updateUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueLnkDAOImpl::updateUsrApplnQueLinkDtls() method");
		try{
			userApplicationQueueLinkMapper.updateUsrApplnQueLinkDtls(usrApplnQueLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrApplnQueLnk", usrApplnQueLnk);
			throw new ApplicationException(
					"UsrApplnQueLnkDAOimpl.updateUsrApplnQueLinkDtls", e, argsMap);
		}
		log.info("Just before leaving  UsrApplnQueLnkDAOImpl::updateUsrApplnQueLinkDtls() method");
		
	}

}
