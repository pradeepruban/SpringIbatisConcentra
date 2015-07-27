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

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueSopExclusn;
import com.syntel.syntbots.itops.mapper.UsrApplnQueSopExclusnMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to
 * UserApplicationQueueSopExclusion.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("userApplicationQueueSopExclusionDAO")
public class UsrApplnQueSopExclusnDAOImpl implements UsrApplnQueSopExclusnDAO {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UsrApplnQueSopExclusnMapper userApplicationQueueSopExclusionMapper;

	/**
	 * This method is called to get all the Complete User Application Queue Sop
	 * Exclusion Lists
	 *
	 * @param
	 * @returnThis List of User Application Queue Sop Exclusion details
	 * @exception - ApplicationException in case of error
	 */
	public List<UsrApplnQueSopExclusn> getCompleteUserApplicationQueueSopExclusionList()
			throws ApplicationException {

		log.info("Entered inside UsrApplnQueSopExclusnDAOImpl:getCompleteUserApplicationQueueSopExclusionList():");
		List<UsrApplnQueSopExclusn> UserApplicationQueueSopExclusionList = null;
		try {
			UserApplicationQueueSopExclusionList = userApplicationQueueSopExclusionMapper
					.getCompleteUserApplicationQueueSopExclusionList();
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("UserApplicationQueueSopExclusionList",
					UserApplicationQueueSopExclusionList);
			throw new ApplicationException(
					"UserApplicationQueueSopExclusionDAO.getCompleteUserApplicationQueueSopExclusionList",
					e, argsMap);
		}
		log.info("Just before leaving UsrApplnQueSopExclusnDAOImpl:getCompleteUserApplicationQueueSopExclusionList()");
		return UserApplicationQueueSopExclusionList;
	}

	/**
	 * This method is called to get all the List of Sop which the logged in user
	 * dont have rights to execute
	 *
	 * @param user
	 *            id,incident App Name,incident Assgnmnt Grp
	 * @returnThis List of SopDetails
	 * @exception - ApplicationException in case of error
	 */

	public List<SopDetails> getsopListNotAccessByUsr(long usrId,
			String incdntAppName, String incdntAssgnmntGrp)
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueSopExclusnDAOImpl:getsopListNotAccessByUsr():");
		List<SopDetails> sopListNotAccessByUsr = null;
		try {

			sopListNotAccessByUsr = userApplicationQueueSopExclusionMapper
					.getsopListNotAccessByUsr(usrId, incdntAppName,
							incdntAssgnmntGrp);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrId", usrId);
			argsMap.put("incdntAppName", incdntAppName);
			argsMap.put("incdntAssgnmntGrp", incdntAssgnmntGrp);
			throw new ApplicationException(
					"UserApplicationQueueSopExclusionDAO.getsopListNotAccessByUsr",
					e, argsMap);
		}
		log.info("Just before leaving UsrApplnQueSopExclusnDAOImpl:getsopListNotAccessByUsr()");
		return sopListNotAccessByUsr;
	}

}
