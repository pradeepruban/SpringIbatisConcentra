/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Incident
 *
 * @author Syntel
 * @version 1.0
 */
public interface IncidentDetailsDAO {

	List<IncidentDetails> getClosedIncidentList(UserDetails userDetails)
			throws ApplicationException;

	List<IncidentDetails> getIncidentListForUser(UserDetails userDetails)
			throws ApplicationException;

	IncidentDetails getIncidentById(Integer incdntDtlsId)
			throws ApplicationException;

	int getWorkflowId(String workflowName) throws ApplicationException;

	int getOpenIncidentsForLoggedInUser(UserDetails userDetails)
			throws ApplicationException;

	int getsevereIncidentsForLoggedInUser(UserDetails userDetails)
			throws ApplicationException;

	List<IncidentDetails> getIncidentListByIncidentOpendate(
			IncidentDetails incidentDetails) throws ApplicationException;

	IncidentDetails getlistIncidentDetailsById(Integer incdntDtlsId)
			throws ApplicationException;

	List<SopDetails> getSopListByIncidentId(String incdntAppName,
			String IncdntAssgnmntGrp) throws ApplicationException;

	List<SopDetails> getSopListByIncidentid(String incidentId) throws ApplicationException;

	void saveIncidentDtls(IncidentDetails incidentDetails)
			throws ApplicationException;

}
