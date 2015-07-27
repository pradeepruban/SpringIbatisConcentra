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
import com.syntel.syntbots.itops.dao.UsrApplnQueSopExclusnDAO;
import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueSopExclusn;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * user application queue sop exclusion.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("userApplicationQueueSopExclusionService")
public class UsrApplnQueSopExclusnServiceImpl implements
		UsrApplnQueSopExclusnService {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ApplnQueSopLnkDAO applicationQueueSopLinkDAO;

	@Autowired
	private SopMsgLnkDAO sopMsgLnkDAO;

	@Autowired
	private UsrApplnQueSopExclusnDAO userApplicationQueueSopExclusionDAO;

	/**
	 * This method is called to get list of complete user application queue sop
	 * exclusion.
	 *
	 * @return list of User Application Queue Sop Exclusion
	 * @exception - ApplicationException in case of error
	 */
	public List<UsrApplnQueSopExclusn> getCompleteUserApplicationQueueSopExclusionList()
			throws ApplicationException {
		log.info("inside UsrApplnQueSopExclusnServiceImpl: getCompleteUserApplicationQueueSopExclusionList() ");
		List<UsrApplnQueSopExclusn> userApplicationQueueSopExclusionList = null;
		try {
			userApplicationQueueSopExclusionList = userApplicationQueueSopExclusionDAO
					.getCompleteUserApplicationQueueSopExclusionList();
			for (UsrApplnQueSopExclusn userApplicationQueueSopExclusion : userApplicationQueueSopExclusionList) {
				String strUsrApplnQueSopExclsnApplicationName = applicationQueueSopLinkDAO
						.getApplicationNameByApplicationId(userApplicationQueueSopExclusion
								.getUsrApplnQueSopExclsnApplicationId());
				userApplicationQueueSopExclusion
						.setStrUsrApplnQueSopExclsnApplicationName(strUsrApplnQueSopExclsnApplicationName);
				String strUsrApplnQueSopExclsnSopName = applicationQueueSopLinkDAO
						.getSopNameBySopId(userApplicationQueueSopExclusion
								.getUsrApplnQueSopExclsnSopId());
				userApplicationQueueSopExclusion
						.setStrUsrApplnQueSopExclsnSopName(strUsrApplnQueSopExclsnSopName);
				String strUsrApplnQueSopExclsnUsrName = sopMsgLnkDAO
						.getUserShortNameByUserId((int) userApplicationQueueSopExclusion
								.getUsrApplnQueSopExclsnUsrId());
				userApplicationQueueSopExclusion
						.setStrUsrApplnQueSopExclsnUsrName(strUsrApplnQueSopExclsnUsrName);
				String strUsrApplnQueSopExclsnQueueName = applicationQueueSopLinkDAO
						.getQueueNameByQueueId(userApplicationQueueSopExclusion
								.getUsrApplnQueSopExclsnQueueId());
				userApplicationQueueSopExclusion
						.setStrUsrApplnQueSopExclsnQueueName(strUsrApplnQueSopExclsnQueueName);
				String strUsrApplnQueSopExclsnCreatedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(userApplicationQueueSopExclusion
								.getUsrApplnQueSopExclsnCreatedBy());
				userApplicationQueueSopExclusion
						.setStrUsrApplnQueSopExclsnCreatedByShortUserName(strUsrApplnQueSopExclsnCreatedByShortUserName);
				String strUsrApplnQueSopExclsnModifiedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(userApplicationQueueSopExclusion
								.getUsrApplnQueSopExclsnModifiedBy());
				userApplicationQueueSopExclusion
						.setStrUsrApplnQueSopExclsnModifiedByShortUserName(strUsrApplnQueSopExclsnModifiedByShortUserName);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UsrApplnQueSopExclusnServiceImpl.getCompleteUserApplicationQueueSopExclusionList",
					e);
		}
		log.info("Just before leaving UsrApplnQueSopExclusnServiceImpl: getCompleteUserApplicationQueueSopExclusionList()");
		return userApplicationQueueSopExclusionList;
	}

	/**
	 * This method is called to get all the List of Sop which the logged in user
	 * dont have rights to execute
	 *
	 * @param usrId
	 *            ,incdntAppName,incdntAssgnmntGrp
	 * @returnThis List<SopDetails> sopListNotAccessByUsr all the values related
	 *             SopWorkflowLink
	 * @exception - ApplicationException
	 */

	public List<SopDetails> getsopListNotAccessByUsr(UserDetails userDetails,
			IncidentDetails incidentDetailsForWrkFlw)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueSopExclusnServiceImpl:getsopListNotAccessByUsr():");
		List<SopDetails> sopListNotAccessByUsr = null;
		long usrId = userDetails.getUsrId();
		try {
			sopListNotAccessByUsr = userApplicationQueueSopExclusionDAO
					.getsopListNotAccessByUsr(usrId,
							incidentDetailsForWrkFlw.getIncdntAppName(),
							incidentDetailsForWrkFlw.getIncdntAssgnmntGrp());
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails", userDetails);
			argsMap.put("incidentDetailsForWrkFlw", incidentDetailsForWrkFlw);
			throw new ApplicationException(
					"UsrApplnQueSopExclusnServiceImpl.getsopListNotAccessByUsr",
					e, argsMap);

		}
		log.info("Just before leaving  UsrApplnQueSopExclusnServiceImpl::getsopListNotAccessByUsr()::"
				+ sopListNotAccessByUsr);

		return sopListNotAccessByUsr;
	}

	/**
	 * This method is called to get all the List of Sop which the logged in user
	 * have rights to execute
	 *
	 * @param sopListbeforeSorted
	 *            ,sopListNotAccessByUsr
	 * @returnThis List<sopListAccessByUsr> sopListAccessByUsr all the values
	 *             related SopWorkflow
	 * @exception - ApplicationException
	 */

	public List<SopDetails> getSopListAccessByUsrforWrkflw(
			List<SopDetails> sopListbeforeSorted,
			List<SopDetails> sopListNotAccessByUsr) throws ApplicationException {
		log.info("Entered inside UsrApplnQueSopExclusnServiceImpl:getSopListAccessByUsrforWrkflw():");
		List<SopDetails> sopListAccessByUsr = new ArrayList<SopDetails>();

		try {
			boolean blnSopToBeExcluded = false;
			for (SopDetails sopbeforeSorted : sopListbeforeSorted) {
				blnSopToBeExcluded = false;
				for (SopDetails sopNotAccessByusr : sopListNotAccessByUsr) {
					if ((sopbeforeSorted.getSopId()) == (sopNotAccessByusr
							.getSopId())) {
						blnSopToBeExcluded = true;
					}

				}

				if (!blnSopToBeExcluded) {
					sopListAccessByUsr.add(sopbeforeSorted);
				}
			}
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopListbeforeSorted", sopListbeforeSorted);
			argsMap.put("sopListNotAccessByUsr", sopListNotAccessByUsr);
			throw new ApplicationException(
					"UsrApplnQueSopExclusnServiceImpl.getSopListAccessByUsrforWrkflw",
					e, argsMap);
		}
		log.info("Just before leaving  UsrApplnQueSopExclusnServiceImpl::getSopListAccessByUsrforWrkflw()::"
				+ sopListAccessByUsr);
		return sopListAccessByUsr;
	}

}
