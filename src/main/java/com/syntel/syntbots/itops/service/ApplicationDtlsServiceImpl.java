/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.ApplicationDtlsDAO;
import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * Applcation Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("applctnDtlsService")
public class ApplicationDtlsServiceImpl implements ApplicationDtlsService {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private ApplicationDtlsDAO applctnDtlsDAO;

	/**
	 * This method is called to insert new Application Details
	 *
	 * @param Application
	 *            Details
	 * 
	 * @return void
	 * @exception - ApplicationException in case of error
	 */
	public void saveApplctnDtls(ApplicationDetails applctnDtls)
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsServiceImpl :: saveApplctnDtls() method");
		try {
			applctnDtlsDAO.insertApplctnDtls(applctnDtls);
		} catch (ApplicationException e) {
			throw new ApplicationException(
					"ApplctnDtlsServiceImpl.saveApplctnDtls", e);
		}
		log.info("Just before leaving  ApplctnDtlsServiceImpl :: saveApplctnDtls() method");
	}

	/**
	 * This method is called to get Application Details based on application
	 * name. The corresponding DAO method is called.
	 *
	 * @param Application
	 *            Details
	 * 
	 * @return Application Details
	 * @exception - ApplicationException in case of error
	 */
	public ApplicationDetails getApplicationDtls(ApplicationDetails applctnDtls)
			throws ApplicationException {

		log.info("Entered inside ApplicationDtlsServiceImpl :: getApplicationDtls() method"
				+ applctnDtls);
		ApplicationDetails returnedApplctnDtls = null;

		try {
			returnedApplctnDtls = applctnDtlsDAO
					.getApplicationDtls(applctnDtls);
			if (returnedApplctnDtls == null) {
				returnedApplctnDtls = new ApplicationDetails();
			} else {
				log.info("returnedApplctnDtls is:" + returnedApplctnDtls + ":");
			}
			log.info("Just before leaving  ApplctnDtlsServiceImpl :: getApplctnDtls() method");
		} catch (ApplicationException e) {
			throw new ApplicationException(
					"ApplctnDtlsServiceImpl.getApplctnDtls", e);
		}
		return returnedApplctnDtls;
	}

	/**
	 * This method is called to get list of Application Details. The
	 * corresponding DAO method is called.
	 *
	 * @return list of Application Details
	 * @exception - ApplicationException in case of error
	 */
	public List<ApplicationDetails> getApplicationDtlsToView()
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsServiceImpl :: getApplicationDtlsToView() method");
		List<ApplicationDetails> applicationdtls = null;
		try {
			applicationdtls = applctnDtlsDAO.getApplicationDtlsToView();

		} catch (ApplicationException e) {
			throw new ApplicationException(
					"ApplctnDtlsServiceImpl.getApplicationDtlsToView", e);
		}
		log.info("Just before leaving  ApplctnDtlsServiceImpl :: getApplicationDtlsToView() method");
		return applicationdtls;
	}

	/**
	 * This method is called to save Application Details. The corresponding DAO
	 * method is called.
	 *
	 * @return list of Application Details
	 * @exception - ApplicationException in case of error
	 */
	public void saveApplicationDtls(ApplicationDetails applicationDetails)
			throws ApplicationException {
		log.info("Entered inside ApplicationDetailsServiceImpl:saveApplicationDtls():");
		try {
			if (applicationDetails.getApplnId() == 0) {
				applctnDtlsDAO.addApplication(applicationDetails);
			}
			applctnDtlsDAO.updateApplication(applicationDetails);
		} catch (ApplicationException e) {
			throw new ApplicationException(
					"ApplctnDtlsServiceImpl.saveApplicationDtls", e);
		}
		log.info("Just before leaving  ApplicationDetailsServiceImpl:saveApplicationDtls() method");

	}

	/**
	 * This method is called to check whether Application Name already exist.
	 * The corresponding DAO method is called.
	 *
	 * @return list of Application Details
	 * @exception - ApplicationException in case of error
	 */
	public int validateApplicationName(ApplicationDetails applicationDetails)
			throws ApplicationException {
		log.info("Entered inside ApplicationDtlsServiceImpl:validateApplicationName():");
		int temp = 0;
		try {
			temp = applctnDtlsDAO.validateApplicationName(applicationDetails);
		} catch (ApplicationException e) {
			throw new ApplicationException(
					"ApplctnDtlsServiceImpl.validateApplicationName", e);
		}
		log.info("Just before leaving  ApplicationDtlsServiceImpl:validateApplicationName() method");
		return temp;
	}

}