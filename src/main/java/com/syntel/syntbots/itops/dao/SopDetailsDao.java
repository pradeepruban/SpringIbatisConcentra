
/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Sop Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SopDetailsDao {
	public List<SopDetails> getSopDetailsToView() throws ApplicationException;

	public List<SopParamDetails> getSopParamDetailsToView(int sopId)
			throws ApplicationException;

	public void addSOPDtls(SopDetails sopDetails) throws ApplicationException;

	public void updateSOPDtls(SopDetails sopDetails)
			throws ApplicationException;

	public int validateSOPName(SopDetails sopDetails)
			throws ApplicationException;

	public void addSOPParamDtls(SopParamDetails sopParamDetails)
			throws ApplicationException;

	public int validateSOPParamCode(SopParamDetails sopParamDetails)
			throws ApplicationException;

	public void updateSOPParamDtls(SopParamDetails sopParamDetails)
			throws ApplicationException;

}
