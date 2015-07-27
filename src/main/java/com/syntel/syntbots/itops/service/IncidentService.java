/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Incident
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface IncidentService {

	List<IncidentDetails> getClosedIncidentList(UserDetails userDetails)
			throws ApplicationException;

	List<IncidentDetails> getIncidentListForUser(UserDetails userDetails)
			throws ApplicationException;

	IncidentDetails getIncidentById(Integer incdntDtlsId,
			UserDetails userDetails) throws ApplicationException;

	List<WorkflowDetails> getWorkFlowListAndParamsBySopId(int sopId)
			throws ApplicationException;

	int getOpenIncidentsForLoggedInUser(UserDetails userDetails)
			throws ApplicationException;

	int getsevereIncidentsForLoggedInUser(UserDetails userDetails)
			throws ApplicationException;

	List<IncidentDetails> getIncidentListByIncidentOpendate(
			IncidentDetails incidentDetails) throws Exception;

	IncidentDetails getlistIncidentDetailsById(Integer incdntDtlsId)
			throws Exception;

	void saveIncidentDtls(IncidentDetails incidentDetails) throws Exception;

}
