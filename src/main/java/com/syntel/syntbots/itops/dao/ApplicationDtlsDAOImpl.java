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

import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.mapper.ApplnDtlsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to ApplctnDtls.
 *
 * @version 1.0
 */
@Repository("applctnDtlsDAO")
public class ApplicationDtlsDAOImpl implements ApplicationDtlsDAO {

	@Autowired
	private ApplnDtlsMapper applctndtlsMapper;

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * This method is called to insert new Application Details.
	 *
	 * @param ApplicationDetails
	 *            This gives the new Application Details.
	 * @return
	 * @exception - ApplicationException in case of error
	 */

	public void insertApplctnDtls(ApplicationDetails applctnDtls)
			throws ApplicationException {
		log.info("Entered Inside ApplicationDtlsDAOImpl::insertApplctnDtls:" + applctnDtls);
		try {
			applctndtlsMapper.insertApplctnDtls(applctnDtls);
			log.info("ApplicationDtlsDAOImpl.insertApplctnDtls, procedure executed successfully");
			log.info("Just before leaving ApplicationDtlsDAOImpl.insertApplctnDtls ");
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applctnDtls", applctnDtls);
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.insertApplctnDtls", e, argsMap);
		}
		log.info("Just before leaving  ApplicationDtlsDAOImpl: insertApplctnDtls() method");

	}

	/**
	 * This method is called to update Application Details.
	 *
	 * @param ApplicationDetails
	 *            This gives the updated Application Details.
	 * @exception - ApplicationException in case of error
	 * @return
	 */

	public void updateApplctnDtls(ApplicationDetails applctnDtls)
			throws ApplicationException {
		log.info("Entered Inside ApplicationDtlsDAOImpl::updateApplctnDtls:"
				+ applctnDtls);
		try {
			
			applctndtlsMapper.updateApplctnDtls(applctnDtls);
			log.info("Just before leaving ApplicationDtlsDAOImpl.updateApplctnDtls ");

		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applctnDtls", applctnDtls);
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.updateApplctnDtlsByName", e,
					argsMap);
		}
		log.info("Just before leaving  ApplicationDtlsDAOImpl: updateApplctnDtls() method");
	}

	/**
	 * This method is called to get Application Details.
	 *
	 * @param ApplicationDetails
	 *            - This gives the details entered by user Application Details..
	 *
	 * @return Application Details.- This contains the ApplctnDtls details which
	 *         the user requested
	 * @exception - ApplicationException in case of error user requested
	 */

	public ApplicationDetails getApplicationDtls(ApplicationDetails applctnDtls)
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsDAOImpl :: getApplicationDtls() method");
		ApplicationDetails returnApplctnDtls = null;
		try {
			log.info("Inside ApplicationDtlsDAOImpl ::getApplctnDtls:"
					+ applctnDtls.getApplnName());
			returnApplctnDtls = applctndtlsMapper
					.getApplicationDtls(applctnDtls);
			if (returnApplctnDtls == null) {
				returnApplctnDtls = applctnDtls;
			}
			log.info("Just before leaving ApplicationDtlsDAOImpl.getApplctnDtls"
					+ returnApplctnDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applctnDtls", applctnDtls);
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.getApplicationDtls", e, argsMap);
		}
		log.info("Just before leaving  ApplicationDtlsDAOImpl:getApplicationDtls() method");
		return returnApplctnDtls;

	}

	/**
	 * This method is called to get A Application Details.
	 *
	 * @param ApplicationDetails
	 *            - This gives the details entered by user Application Details.
	 *
	 * @return List<ApplctnDtls>- This contains all the ApplctnDtls details
	 *         which the
	 * @exception - ApplicationException in case of error user requested
	 */
	public List<ApplicationDetails> getApplicationDtlsToView()
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsDAOImpl :: getApplicationDtlsToView() method");
		List<ApplicationDetails> applicationDtls = null;
		try {
			applicationDtls = applctndtlsMapper.getApplicationDtlsToView();
			log.info("Just before leaving ApplicationDtlsDAOImpl.getApplctnDtls"
					+ applicationDtls);
		} catch (Exception e) {
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.getApplicationDtlsToView", e);
		}
		log.info("Just before leaving ApplicationDtlsDAOImpl.getApplicationDtlsToView");
		return applicationDtls;
	}

	/**
	 * This method is called to add Application Details.
	 *
	 * @param ApplicationDetails
	 *            - This gives the details entered by user Application Details.
	 *
	 * @return
	 * @exception - ApplicationException in case of error user requested
	 */
	public void addApplication(ApplicationDetails applicationDetails)
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsDAOImpl:addApplication():");
		try {
			applctndtlsMapper.addApplication(applicationDetails);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applicationDetails", applicationDetails);
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.addApplication", e, argsMap);
		}

		log.info("Just before leaving  ApplicationDtlsDAOImpl:addApplication() method");

	}

	/**
	 * This method is called to update Application Details.
	 *
	 * @param ApplicationDetails
	 *            - This gives the details entered by user Application Details.
	 *
	 * @return
	 * @exception - ApplicationException in case of error user requested
	 */
	public void updateApplication(ApplicationDetails applicationDetails)
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsDAOImpl:updateApplication:");
		try {
			applctndtlsMapper.updateApplication(applicationDetails);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applicationDetails", applicationDetails);
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.updateApplctnDtlsById", e, argsMap);
		}
		log.info("Just before leaving  ApplicationDtlsDAOImpl:updateApplication() method");

	}

	/**
	 * This method is called to validate whetherApplication Name exist or not.
	 *
	 * @param ApplicationDetails
	 *            - This gives the details entered by user Application Details.
	 *
	 * @return int
	 * @exception - ApplicationException in case of error user requested
	 */
	public int validateApplicationName(ApplicationDetails applicationDetails)
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsDAOImpl:validateApplicationName():");
		int countAppName = 0;
		try {
			countAppName = applctndtlsMapper
					.validateApplicationName(applicationDetails);
			log.info("Just before leaving  ApplicationDtlsDAOImpl:validateApplicationName() method");
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applicationDetails", applicationDetails);
			throw new ApplicationException(
					"ApplicationDtlsDAOImpl.validateApplicationName", e,
					argsMap);
		}
		log.info("Just before leaving  ApplicationDtlsDAOImpl:validateApplicationName() method");
		return countAppName;
	}

}