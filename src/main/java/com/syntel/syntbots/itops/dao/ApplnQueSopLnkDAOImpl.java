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

import com.syntel.syntbots.itops.dto.ApplnQueSopLnk;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.mapper.ApplnQueSopLnkMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to
 * ApplicationQueueSopLink.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("applicationQueueSopLinkDAO")
public class ApplnQueSopLnkDAOImpl implements ApplnQueSopLnkDAO {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ApplnQueSopLnkMapper applicationQueueSopLinkMapper;

	/**
	 * This method is called to get all the SopList by Applname and Queue name
	 *
	 * @param incdntAppName
	 *            ,incdntAssgnmntGrp
	 * @throws ApplicationException
	 * @returnThis List<SopDtlsDTO> all the values related SopDtlsDTO
	 * @exception - ApplicationException in case of error
	 */
	public List<SopDetails> getSopListByApplnNameAndQueueName(
			String incdntAppName, String incdntAssgnmntGrp)
			throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkDAOImpl::getSopListByApplnNameAndQueueName() method");
		List<SopDetails> sopListForWorkFlw = null;
		try {
			sopListForWorkFlw = applicationQueueSopLinkMapper
					.getSopListByApplnNameAndQueueName(incdntAppName,
							incdntAssgnmntGrp);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incdntAppName", incdntAppName);
			argsMap.put("incdntAssgnmntGrp", incdntAssgnmntGrp);
			throw new ApplicationException(
					"ApplnQueSopLnkDAOImpl.getSopListByApplnNameAndQueueName",
					e, argsMap);
		}
		log.info("Just before leaving ApplnQueSopLnkDAOImpl:getSopListByApplnNameAndQueueName ");
		return sopListForWorkFlw;
	}

	/**
	 * This method is called to get all the Complete Application Queue Sop Link
	 * List
	 *
	 * @param
	 * @returnThis List<ApplicationQueueSopLink> all the values related
	 *             ApplicationQueueSopLink
	 * @exception - ApplicationException in case of error
	 */
	public List<ApplnQueSopLnk> getCompleteApplicationQueueSopLinkList()
			throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkDAOImpl::getCompleteApplicationQueueSopLinkList() method");
		List<ApplnQueSopLnk> applicationQueueSopLinkList = null;
		try {
			applicationQueueSopLinkList = applicationQueueSopLinkMapper
					.getCompleteApplicationQueueSopLinkList();
		} catch (Exception e) {
			throw new ApplicationException(
					"ApplnQueSopLnkDAOImpl.getCompleteApplicationQueueSopLinkList",
					e);
		}
		log.info("Just before leaving ApplnQueSopLnkDAOImpl:getCompleteApplicationQueueSopLinkList ");
		return applicationQueueSopLinkList;
	}

	/**
	 * This method is called to get ApplicationName by AppId
	 *
	 * @param applicationId
	 * @returnThis gives the appName
	 * @exception - ApplicationException in case of error
	 */
	public String getApplicationNameByApplicationId(long applicationId)
			throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkDAOImpl::getApplicationNameByApplicationId() method");
		String appName = null;
		try {
			appName = applicationQueueSopLinkMapper
					.getApplicationNameByApplicationId(applicationId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applicationName", appName);
			throw new ApplicationException(
					"ApplnQueSopLnkDAOImpl.getApplicationNameByApplicationId",
					e, argsMap);
		}
		log.info("Just before leaving ApplnQueSopLnkDAOImpl:getApplicationNameByApplicationId ");
		return appName;
	}

	/**
	 * This method is called to gets the QueueName by QueueId
	 *
	 * @param QueueId
	 * @returnThis gives the QueueId
	 * @exception - ApplicationException in case of error
	 */
	public String getQueueNameByQueueId(long queueId)
			throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkDAOImpl::getQueueNameByQueueId() method");
		String queueName = null;
		try {
			queueName = applicationQueueSopLinkMapper
					.getQueueNameByQueueId(queueId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueName", queueName);
			throw new ApplicationException(
					"ApplnQueSopLnkDAOImpl.getQueueNameByQueueId", e, argsMap);
		}
		log.info("Just before leaving ApplnQueSopLnkDAOImpl:getQueueNameByQueueId ");
		return queueName;
	}

	/**
	 * This method is called to get new Sop name by SopId
	 *
	 * @param sopId
	 * @returnThis gives the sopname
	 * @exception - ApplicationException in case of error
	 */
	public String getSopNameBySopId(long sopId) throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkDAOImpl::getSopNameBySopId() method");

		String sopName = null;
		try {
			sopName = applicationQueueSopLinkMapper.getSopNameBySopId(sopId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopName", sopName);
			throw new ApplicationException(
					"ApplnQueSopLnkDAOImpl.getSopNameBySopId", e, argsMap);
		}
		log.info("Just before leaving ApplnQueSopLnkDAOImpl:getSopNameBySopId ");
		return sopName;
	}

}
