/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Applcation
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface ApplicationDtlsService {

	public void saveApplctnDtls(ApplicationDetails applctnDtls)
			throws ApplicationException;

	public ApplicationDetails getApplicationDtls(ApplicationDetails applctnDtls)
			throws ApplicationException;

	public List<ApplicationDetails> getApplicationDtlsToView()
			throws ApplicationException;

	public void saveApplicationDtls(ApplicationDetails applicationDetails)
			throws ApplicationException;;

	public int validateApplicationName(ApplicationDetails applicationDetails)
			throws ApplicationException;;

}