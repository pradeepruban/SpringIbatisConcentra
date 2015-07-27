/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Incident
 * Executions.
 *
 * @author Syntel
 * @version 1.0
 */

public interface IncdntExecDtlsDAO {

	public void insertIncidentExecDtls(IncidentExecDtls incidentExecDtls)
			throws ApplicationException;

	public void updateIncidentExecStatusFromWorkflow(
			IncidentExecDtls incidentExecDtls) throws ApplicationException;

	public List<IncidentExecDtls> getIncidentExecDtlsList(
			IncidentExecDtls incidentExecDtls) throws ApplicationException;

	public IncidentExecDtls getMaxIncidentExecIdBasedOnIncidentId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException;

	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentExecId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException;

	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException;

	public List<IncidentExecParamDtls> getIncidentParamListByIncdntExcId(
			int incidentExecId) throws ApplicationException;

	public void updateIncidentExecFromWorkflow(IncidentExecDtls incidentExecDtls)
			throws ApplicationException;

}
