/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/

package com.syntel.syntbots.itops.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
import com.syntel.syntbots.itops.mapper.IncdntExecPrmDtlsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Dao impl methods for Incident Executions Param
 * Details..
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("incidentExecParamDtlsDAO")
public class IncdntExecPrmDtlsDAOImpl implements IncdntExecPrmDtlsDAO {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IncdntExecPrmDtlsMapper incidentExecParamDtlsMapper;

	/**
	 * This method is called to insert Incident Executions Param Details.
	 *
	 * @param incidentExecParamDtls
	 * @returnThis
	 */

	public void insertIncidentExecParamDtls(
			IncidentExecParamDtls incidentExecParamDtls)
			throws ApplicationException {

		log.info("Entered inside IncdntExecPrmDtlsDAOImpl::insertIncidentExecParamDtls() method");
		try {
			incidentExecParamDtlsMapper
					.insertIncidentExecParamDtls(incidentExecParamDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecParamDtls", incidentExecParamDtls);
			throw new ApplicationException(
					"IncdntExecPrmDtlsDAOImpl.insertIncidentExecParamDtls", e,
					argsMap);
		}
		log.info("Just before leaving IncdntExecPrmDtlsDAOImpl.insertIncidentExecParamDtls ");

	}

}
