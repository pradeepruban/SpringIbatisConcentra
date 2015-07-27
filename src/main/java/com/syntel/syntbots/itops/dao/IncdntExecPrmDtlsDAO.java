/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

/**
 *This interface  contains all the DAO layer methods related to Incident Executions Param  Details.
 *@author Syntel
 *@version 1.0
 */

import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
import com.syntel.syntbots.itops.util.ApplicationException;

public interface IncdntExecPrmDtlsDAO {

	public void insertIncidentExecParamDtls(
			IncidentExecParamDtls incidentExecParamDtls)
			throws ApplicationException;

}
