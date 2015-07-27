/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.ApplnQueSopLnkDAO;
import com.syntel.syntbots.itops.dao.SopMsgLnkDAO;
import com.syntel.syntbots.itops.dao.UsrApplnQueLnkDAO;
import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * user application queue link.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("userApplicationQueueLinkService")
public class UsrApplnQueLnkServiceImpl implements UsrApplnQueLnkService {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ApplnQueSopLnkDAO applicationQueueSopLinkDAO;

	@Autowired
	private SopMsgLnkDAO sopMsgLnkDAO;

	@Autowired
	private UsrApplnQueLnkDAO userApplicationQueueLinkDAO;

	/**
	 * This method is called to get list of complete user application queue
	 * link.
	 *
	 * @return list of User Application Queue link
	 * @exception - ApplicationException in case of error
	 */
	public List<UsrApplnQueLnk> getCompleteUserApplicationQueueLinkList()
			throws ApplicationException {
		log.info("inside UsrApplnQueLnkServiceImpl: getCompleteUserApplicationQueueLinkList() ");
		List<UsrApplnQueLnk> userApplicationQueueLinkList = null;
		try {
			userApplicationQueueLinkList = userApplicationQueueLinkDAO
					.getCompleteUserApplicationQueueLinkList();
			for (UsrApplnQueLnk userApplicationQueueLink : userApplicationQueueLinkList) {
				String strUsrAppQLinkApplicationName = applicationQueueSopLinkDAO
						.getApplicationNameByApplicationId(userApplicationQueueLink
								.getUsrAppQLinkApplicationId());
				userApplicationQueueLink
						.setStrUsrAppQLinkApplicationName(strUsrAppQLinkApplicationName);
				String strUsrAppQLinkQueueName = applicationQueueSopLinkDAO
						.getQueueNameByQueueId(userApplicationQueueLink
								.getUsrAppQLinkQueueId());
				userApplicationQueueLink
						.setStrUsrAppQLinkQueueName(strUsrAppQLinkQueueName);
				String strUsrAppQLinkUsrName = sopMsgLnkDAO
						.getUserShortNameByUserId((int) userApplicationQueueLink
								.getUsrAppQLinkUsrId());
				userApplicationQueueLink
						.setStrUsrAppQLinkUsrName(strUsrAppQLinkUsrName);
				String strUsrAppQLinkCreatedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(userApplicationQueueLink
								.getUsrAppQLinkCreatedBy());
				userApplicationQueueLink
						.setStrUsrAppQLinkCreatedByShortUserName(strUsrAppQLinkCreatedByShortUserName);
				String strUsrAppQLinkModifiedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(userApplicationQueueLink
								.getUsrAppQLinkModifiedBy());
				userApplicationQueueLink
						.setStrUsrAppQLinkModifiedByShortUserName(strUsrAppQLinkModifiedByShortUserName);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UsrApplnQueLnkServiceImpl.getCompleteUserApplicationQueueLinkList",
					e);
		}
		log.info("Just before leaving  UsrApplnQueLnkServiceImpl: getCompleteUserApplicationQueueLinkList()");
		return userApplicationQueueLinkList;
	}

	/**
	 * This method is called to get the the application and queue information of
	 * the logged user is get linked
	 *
	 * @param userDetails
	 *            ,incdntAppName,incdntAssgnmntGrp
	 * @returnThis UsrApplnQueLnk
	 * @exception - ApplicationException
	 */

	public UsrApplnQueLnk getUsrApplnQueLnkDetailsByAppnameandQueName(
			UserDetails userDetails, IncidentDetails incidentDetailsForWrkFlw)
			throws ApplicationException {
		log.info("inside UsrApplnQueLnkServiceImpl: getUsrApplnQueLnkDetailsByAppnameandQueName() ");
		UsrApplnQueLnk usrApplnQueLnkDetails = null;
		long usrId = userDetails.getUsrId();
		try {

			usrApplnQueLnkDetails = userApplicationQueueLinkDAO
					.getUsrApplnQueLnkDetailsByAppnameandQueName(usrId,
							incidentDetailsForWrkFlw.getIncdntAppName(),
							incidentDetailsForWrkFlw.getIncdntAssgnmntGrp());

		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails", userDetails);
			argsMap.put("incidentDetailsForWrkFlw", incidentDetailsForWrkFlw);
			throw new ApplicationException(
					"UsrApplnQueLnkServiceImpl.getUsrApplnQueLnkDetailsByAppnameandQueName",
					e, argsMap);
		}
		log.info("Just before leaving  UsrApplnQueLnkServiceImpl: getUsrApplnQueLnkDetailsByAppnameandQueName()");
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
		log.info("inside UsrApplnQueLnkServiceImpl:validateWrkflwName() ");
		int UsrApplnQueLink=0;
		try{
			UsrApplnQueLink=userApplicationQueueLinkDAO.ValUsrApplnQueLinkDtls(usrApplnQueLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UsrApplnQueLnkServiceImpl.ValUsrApplnQueLinkDtls", e);
		}
		log.info("Just before leaving UsrApplnQueLnkServiceImpl:ValUsrApplnQueLinkDtls() method");
		
		return UsrApplnQueLink;
	}
	/**
	 * This method is called to add new User Application Queue Link details.
	 * @param  User Application Queue Link details
	 * @return void
	 * @throws ApplicationException
	 */
	public void addUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueLnkServiceImpl::addUsrApplnQueLinkDtls() method");
		try{
			
			userApplicationQueueLinkDAO.addUsrApplnQueLinkDtls(usrApplnQueLnk);
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("UsrApplnQueLnkServiceImpl.addUsrApplnQueLinkDtls", e);
		}
		log.info("Just before leaving UsrApplnQueLnkServiceImpl: saveWrkflwParamDtls()");
	}
	/**
	 * This method is called to update existing User Application Queue Link details.
	 * @param  User Application Queue Link details
	 * @return Void
	 * @throws ApplicationException
	 */
	public void updateUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueLnkServiceImpl::saveWrkflwParamDtls() method");
		try{
			
			userApplicationQueueLinkDAO.updateUsrApplnQueLinkDtls(usrApplnQueLnk);
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("UsrApplnQueLnkServiceImpl.updateUsrApplnQueLinkDtls", e);
		}
		log.info("Just before leaving UsrApplnQueLnkServiceImpl::addUsrApplnQueLinkDtls()");
		
	}

}
