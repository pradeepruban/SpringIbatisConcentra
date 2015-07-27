/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/

package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Application
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface ApplicationDtlsDAO {
	public void insertApplctnDtls(ApplicationDetails applctnDtls)
			throws ApplicationException;

	public void updateApplctnDtls(ApplicationDetails applctnDtls)
			throws ApplicationException;

	public ApplicationDetails getApplicationDtls(ApplicationDetails applctnDtls)
			throws ApplicationException;

	public List<ApplicationDetails> getApplicationDtlsToView()
			throws ApplicationException;

	public void addApplication(ApplicationDetails applicationDetails)
			throws ApplicationException;

	public void updateApplication(ApplicationDetails applicationDetails)
			throws ApplicationException;

	public int validateApplicationName(ApplicationDetails applicationDetails)
			throws ApplicationException;

}