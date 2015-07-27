/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to SOP Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SopDetailsService {

	public List<SopDetails> getSopDetailsToView() throws ApplicationException;

	public void saveSOPDtls(SopDetails sopDetails) throws ApplicationException;

	public int validateSOPName(SopDetails sopDetails)
			throws ApplicationException;

	public void addSOPParamDtls(SopParamDetails sopParamDetails)
			throws ApplicationException;

	public int validateSOPParamCode(SopParamDetails sopParamDetails)
			throws ApplicationException;

	public void updateSOPParamDtls(SopParamDetails sopParamDetails)
			throws ApplicationException;

}
