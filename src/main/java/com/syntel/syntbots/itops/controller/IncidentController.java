/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syntel.syntbots.itops.dto.DataTableObject;
import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.service.IncidentService;
import com.syntel.syntbots.itops.service.SopMsgLnkService;
import com.syntel.syntbots.itops.service.WrkflwPrmLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;

/**
 * This class contains all the controller methods for IncidentDetails.
 *
 * @author Syntel
 * @version 1.0
 */

@Controller
public class IncidentController {

	private Logger log = Logger.getLogger(this.getClass());

	/** This is a default constructor */
	public IncidentController() {
		log.info("Inside IncidentController constructor");
	}

	@Autowired
	private IncidentService incidentService;

	@Autowired
	private WrkflwPrmLnkService workflowParamLnkService;

	@Autowired
	private SopMsgLnkService sopMsgLnkService;

	/**
	 * This method is called to get list of Closed incident Details.
	 * This is an ajax call.
	 *
	 * @param request
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/getClosedIncidentList")
	public @ResponseBody DataTableObject getClosedIncidentList(
			HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside IncidentController::getClosedIncidentList() method ");
		UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
		List<IncidentDetails> closedIncidentList = null;
		DataTableObject dataTableObject = new DataTableObject();
		if (null != userDetails) {
			try {
				closedIncidentList = incidentService
						.getClosedIncidentList(userDetails);
				if (closedIncidentList == null) {
					closedIncidentList = new ArrayList<IncidentDetails>();
				}

				dataTableObject.setAaData(closedIncidentList);
				
				for (IncidentDetails incDtls : closedIncidentList) {

					String incidentDetailsActions = "<a href=\"javaScript:fnViewIncidentDtlsBasedOnSelectedRow('"
							+ incDtls.getIncdntDtlsId()
							+ "','"
							+ incDtls.getIncdntAppName()
							+ "','"
							+ incDtls.getIncdntAssgnmntGrp()
							+ "');\" title='Incident Details'><i style='margin-left: 22%;' class='glyphicon glyphicon-book'></i> </a>";
					log.info("incDtls.getIncdntDtlsId()"
							+ incDtls.getIncdntDtlsId());
					incDtls.setIncdntAction(incidentDetailsActions);

				}
			} catch (ApplicationException e) {
				throw e;
			} catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("userDetails", userDetails);
				throw new ApplicationException(
						"IncidentController.getClosedIncidentList", e, argsMap);
			}
		}
		log.info("Just before leaving IncidentController::getClosedIncidentList() method:closedIncidentList:"
				+ closedIncidentList + ":");
		return dataTableObject;
	}

	/**
	 * This method is called to get list of Incident Details for logged in user
	 * This is an ajax call.
	 *
	 * @param request
	 *            - userDetails from Session
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/incidentListForLoggedInUser")
	public @ResponseBody DataTableObject getIncidentListForLoggedInUser(
			HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside IncidentController::getIncidentListForLoggedInUser() method ");
		List<IncidentDetails> incidentList = null;
		UserDetails userDetails = ApplicationUtils.getLogedInUser(request);	
		DataTableObject dataTableObject = new DataTableObject();
		if (null != userDetails) {
			try {
				incidentList = incidentService
						.getIncidentListForUser(userDetails);
				for (IncidentDetails incDtls : incidentList) {

					String incidentDetailsActions = "<a href=\"javaScript:fnViewSecondTabByIncidentDtlsId('"
							+ incDtls.getIncdntDtlsId()
							+ "','"
							+ incDtls.getIncdntAppName()
							+ "','"
							+ incDtls.getIncdntAssgnmntGrp()
							+ "');\" title='Incident Details'><i style='margin-left: 22%;' class='glyphicon glyphicon-book'></i> </a> <a href=\"javaScript:fnSOPExceutionByIncidentId('"
							+ incDtls.getIncdntId()
							+ "');\" title='Sop Execution'><i style='margin-left: 22%;' class='fa fa-cogs '></i></a>";
					log.info("incDtls.getIncdntDtlsId()"
							+ incDtls.getIncdntDtlsId());
					incDtls.setIncdntAction(incidentDetailsActions);

				}
				if (incidentList == null) {
					incidentList = new ArrayList<IncidentDetails>();
				}

				dataTableObject.setAaData(incidentList);

				log.info(dataTableObject.getAaData()
						+ "Just before leaving IncidentController::getIncidentListForLoggedInUser() method:incidentList:"
						+ incidentList + ":");
			} catch (ApplicationException e) {
				throw e;
			} catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("userDetails", userDetails);
				throw new ApplicationException(
						"IncidentController.getIncidentListForLoggedInUser", e, argsMap);
			}
		}
		return dataTableObject;
	}

	/**
	 * This method is called to get List of Incident Details based on incident
	 * details Id .This is an ajax call.
	 *
	 * @RequestBody IncidentDetails
	 * @return response - IncidentDetails DTO
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/listIncidentById")
	public @ResponseBody IncidentDetails getIncidentById(
			@RequestBody IncidentDetails incidentDetails,HttpServletRequest request)
			throws ApplicationException {
		log.info("Entered inside IncidentController::getIncidentById() method with "
				+ incidentDetails.getIncdntDtlsId());

		IncidentDetails incidentDetailsForWrkFlw = null;
		int incidentId = incidentDetails.getIncdntDtlsId();
		
		try {
			UserDetails userDetails= ApplicationUtils.getLogedInUser(request);
			if (incidentId != 0) {
				incidentDetailsForWrkFlw = incidentService.getIncidentById(incidentId,userDetails);
				log.info("Just before leaving IncidentController::getIncidentById() method:IncdntAppName:"
						+ incidentDetailsForWrkFlw.getIncdntAppName() + ":");
			}
		}  catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentDetails",incidentDetails);
			throw new ApplicationException("IncidentController.getIncidentById", e, argsMap);
		}
		return incidentDetailsForWrkFlw;
	}

	/**
	 * This method is called to get number of Open Incidents for logged in user
	 * This is an ajax call.
	 *
	 * @param request
	 * @return response - int
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/openIncidentsForLoggedInUser")
	public @ResponseBody int openIncidentsForLoggedInUser(
			HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside IncidentController::openIncidentsForLoggedInUser() method ");
		int openIncidents = 0;
		UserDetails userDetails = ApplicationUtils.getLogedInUser(request);	
		try {
			openIncidents = incidentService
					.getOpenIncidentsForLoggedInUser(userDetails);
			log.info("Just before leaving IncidentController::openIncidentsForLoggedInUser() method"
					+ openIncidents);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails", userDetails);
			throw new ApplicationException(
					"IncidentController.openIncidentsForLoggedInUser", e, argsMap);
		}
		return openIncidents;
	}

	/**
	 * This method is called to get number of severe Incidents for logged in
	 * user .This is an ajax call.
	 *
	 * @param request
	 * @return response - int
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/severeIncidentsForLoggedInUser")
	public @ResponseBody int severeIncidentsForLoggedInUser(
			HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside IncidentController::severeIncidentsForLoggedInUser() method ");
		int severeIncidents = 0;

		UserDetails userDetails = ApplicationUtils.getLogedInUser(request);	
		try {
			severeIncidents = incidentService
					.getsevereIncidentsForLoggedInUser(userDetails);
			log.info("Just before leaving IncidentController::severeIncidentsForLoggedInUser() method"
					+ severeIncidents);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails", userDetails);
			throw new ApplicationException(
					"IncidentController.severeIncidentsForLoggedInUser", e, argsMap );
		}
		return severeIncidents;
	}
	
	
	/**
	 * This method is called to get IncidentDetails By incidentId
	 * This is an ajax call.
	 *
	 * @param Incident Details
	 * @return response - int
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/listIncidentDetailsById")
	public @ResponseBody IncidentDetails getIncidentDetailsById(
			@RequestBody IncidentDetails incidentDetails) throws Exception {
		log.info("Entered inside IncidentController::getIncidentDetailsById() method "
				+ incidentDetails.getIncdntDtlsId());
		IncidentDetails incidentDeatils = null;
		int incidentId = incidentDetails.getIncdntDtlsId();
		DataTableObject dataTableObject = new DataTableObject();
		try {
			if (incidentId != 0) {
				incidentDeatils = incidentService
						.getlistIncidentDetailsById(incidentId);
				log.info("Just before leaving IncidentController::getIncidentDetailsById() method"
						+ incidentDeatils);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentDetails", incidentDetails);
			throw new ApplicationException(
					"IncidentController.getIncidentDetailsById", e, argsMap);
		}

		return incidentDeatils;
	}
	/**
	 * This method is called to get IncidentDetails By incident open date
	 * This is an ajax call.
	 *
	 * @param Incident Details
	 * @return response data table object
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/getIncidentListByIncidentOpendate")
	public @ResponseBody DataTableObject getIncidentListByIncidentOpendate(
			@RequestBody IncidentDetails incidentDetails,
			HttpServletRequest request) throws Exception {
		log.info("Entered inside IncidentController::getIncidentListByIncidentOpendate() method with "
				+ incidentDetails.getStartDate()
				+ "and"
				+ incidentDetails.getEndDate());

		UserDetails userDetails = ApplicationUtils.getLogedInUser(request);	
		incidentDetails.setUsrId(userDetails.getUsrId());
		List<IncidentDetails> incidentDetailsByOpenedDate = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {

			incidentDetailsByOpenedDate = incidentService
					.getIncidentListByIncidentOpendate(incidentDetails);
			
			for (IncidentDetails incDtls : incidentDetailsByOpenedDate) {

				String incidentDetailsActions = "<a href=\"javaScript:fnViewIncidentDtlsBasedOnSelectedRow('"
						+ incDtls.getIncdntDtlsId()
						+ "','"
						+ incDtls.getIncdntAppName()
						+ "','"
						+ incDtls.getIncdntAssgnmntGrp()
						+ "');\" title='Incident Details'><i style='margin-left: 22%;' class='glyphicon glyphicon-book'></i> </a>";
				log.info("incDtls.getIncdntDtlsId()"
						+ incDtls.getIncdntDtlsId());
				incDtls.setIncdntAction(incidentDetailsActions);

			}
			if (incidentDetailsByOpenedDate == null) {
				incidentDetailsByOpenedDate = new ArrayList<IncidentDetails>();
			}

			dataTableObject.setAaData(incidentDetailsByOpenedDate);
			
			log.info("Just before leaving IncidentController::getIncidentListByIncidentOpendate() method:incidentDetailsByOpenedDate:"
					+ incidentDetailsByOpenedDate + ":");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentDetails", incidentDetails);
			throw new ApplicationException(
					"IncidentController.getIncidentListByIncidentOpendate", e, argsMap);
		}
		return dataTableObject;
	}
	/**
	 * This method is called to save IncidentDetails 
	 * This is an ajax call.
	 *
	 * @param Incident Details,request
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/saveincidentdetails")	
	public @ResponseBody String saveIncidentDetails(@RequestBody IncidentDetails incidentDetails,HttpServletRequest request) throws ApplicationException {
		try{
				log.info("Entered inside IncidentController::saveIncidentDtls() method with sopDetails as:"+incidentDetails+":"+incidentDetails.getIncdntDtlsId());
				UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
				long usrId = userDetails.getUsrId();
				
				incidentDetails.setIncdntcreatedBy((int) usrId);
				
				incidentService.saveIncidentDtls(incidentDetails);
				log.info("Just before leaving IncidentController::saveIncidentDtls() method");
			
			
			return "{}";
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentDetails", incidentDetails);
			throw new ApplicationException(
					"IncidentController.saveIncidentDetails", e, argsMap);
		}
	}

}
