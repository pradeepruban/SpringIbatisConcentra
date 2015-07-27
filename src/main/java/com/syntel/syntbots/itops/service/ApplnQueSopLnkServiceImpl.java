/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.ApplnQueSopLnkDAO;
import com.syntel.syntbots.itops.dao.SopMsgLnkDAO;
import com.syntel.syntbots.itops.dto.ApplnQueSopLnk;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * Applcation queue SOP link Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("applicationQueueSopLinkService")
public class ApplnQueSopLnkServiceImpl implements ApplnQueSopLnkService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ApplnQueSopLnkDAO applicationQueueSopLinkDAO;

	@Autowired
	private SopMsgLnkDAO sopMsgLnkDAO;

	/**
	 * This method is called to get list of SOP details based on incident
	 * application name and incident assignment group
	 *
	 * @param incident
	 *            application name,incident assignment group
	 * @return list of SOP details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopDetails> getSopListByApplnNameAndQueueName(
			String incdntAppName, String incdntAssgnmntGrp)
			throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkServiceImpl::getSopListByApplnNameAndQueueName() method");
		List<SopDetails> sopListForWorkFlw = null;
		try {
		  sopListForWorkFlw = applicationQueueSopLinkDAO
				.getSopListByApplnNameAndQueueName(incdntAppName,
						incdntAssgnmntGrp);
		} catch (ApplicationException e) {
			throw new ApplicationException(
					"ApplnQueSopLnkServiceImpl.getSopListByApplnNameAndQueueName", e);
		}
		return sopListForWorkFlw;
	}

	/**
	 * This method is called to get list of Application queue SOP link details
	 *
	 * @return list of Application Queue SOP link details
	 * @exception - ApplicationException in case of error
	 */
	public List<ApplnQueSopLnk> getCompleteApplicationQueueSopLinkList()
			throws ApplicationException {
		List<ApplnQueSopLnk> applicationQueueSopLinkList = null;
		try {
			applicationQueueSopLinkList = applicationQueueSopLinkDAO
					.getCompleteApplicationQueueSopLinkList();
			for (ApplnQueSopLnk applicationQueueSopLink : applicationQueueSopLinkList) {
				String strAppQSopLnkCreatedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(applicationQueueSopLink
								.getAppQSopLnkCreatedBy());
				applicationQueueSopLink
						.setStrAppQSopLnkCreatedByShortUserName(strAppQSopLnkCreatedByShortUserName);
				String strAppQSopLnkModifiedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(applicationQueueSopLink
								.getAppQSopLnkModifiedBy());
				applicationQueueSopLink
						.setStrAppQSopLnkModifiedByShortUserName(strAppQSopLnkModifiedByShortUserName);
				String strAppQSopLnkApplicationName = applicationQueueSopLinkDAO
						.getApplicationNameByApplicationId(applicationQueueSopLink
								.getApplicationId());
				applicationQueueSopLink
						.setStrAppQSopLnkApplicationName(strAppQSopLnkApplicationName);
				String strAppQSopLnkQueueName = applicationQueueSopLinkDAO
						.getQueueNameByQueueId(applicationQueueSopLink
								.getQueueId());
				applicationQueueSopLink
						.setStrAppQSopLnkQueueName(strAppQSopLnkQueueName);
				String strAppQSopLnkSopName = applicationQueueSopLinkDAO
						.getSopNameBySopId(applicationQueueSopLink.getSopId());
				applicationQueueSopLink
						.setStrAppQSopLnkSopName(strAppQSopLnkSopName);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"ApplnQueSopLnkServiceImpl.getCompleteApplicationQueueSopLinkList",
					e);
		}
		return applicationQueueSopLinkList;
	}

}
