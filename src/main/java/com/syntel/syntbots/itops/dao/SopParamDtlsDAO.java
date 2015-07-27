/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to SopParam
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SopParamDtlsDAO {

	public List<SopParamDetails> getSopParamDtls(SopParamDetails sopParamDtls)
			throws ApplicationException;

}
