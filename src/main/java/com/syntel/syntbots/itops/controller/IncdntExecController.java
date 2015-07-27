/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syntel.syntbots.itops.dto.DataTableObject;
import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.service.IncidentExecutionService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for IncidentExecution Details.
 *
 * @author Syntel
 * @version 1.0
 */

@Controller
public class IncdntExecController {

	private Logger log = Logger.getLogger(this.getClass());

	/** This is a default constructor */
	public IncdntExecController() {
		log.info("Inside IncdntExecController constructor");
	}

	@Autowired
	private IncidentExecutionService incidentExecutionService;

	/**
	 * This method is called to handle execute incident .This is an ajax call.
	 *
	 * @param request
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/executeIncident")
	@ResponseBody
	public void handleExecuteIncidentRequest(HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		String strJSON = "";
		try {
			log.info("Entered inside IncdntExecController::handleExecuteIncidentRequest()");
			Enumeration enum1 = request.getParameterNames();
			while (enum1.hasMoreElements()) {
				log.info("enum1.nextElement() is:" + enum1.nextElement());
			}
			strJSON = request.getParameter("execIncidentJSON");
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
			// log.info("strJSON is:::::" + strJSON + ":::::");
			// log.info("userId in IncdntExecController::handleExecuteIncidentRequest is:::::"
			// + strJSON + ":::::");
			JSONObject execIncidentJSON = new JSONObject(strJSON);
			IncidentExecDtls incidentExecDtls = new IncidentExecDtls();
			String strIncidentId = ApplicationUtils.getValueFromJSON(
					execIncidentJSON, "incidentId");
			String strIncdntDtlsId = ApplicationUtils.getValueFromJSON(
					execIncidentJSON, "incdntDtlsId");

			String strApplnName = ApplicationUtils.getValueFromJSON(
					execIncidentJSON, "applnName");
			String strSopId = ApplicationUtils.getValueFromJSON(
					execIncidentJSON, "sopId");
			String strWrkflwIdId = ApplicationUtils.getValueFromJSON(
					execIncidentJSON, "wrkflwId");
			String strQueName = ApplicationUtils.getValueFromJSON(
					execIncidentJSON, "queName");
			int iSopId = 0;
			int iWrkflwId = 0;
			int incdntDtlsId = 0;
			if (StringUtils.hasText(strSopId)) {
				iSopId = Integer.parseInt(strSopId);
			}
			if (StringUtils.hasText(strWrkflwIdId)) {
				iWrkflwId = Integer.parseInt(strWrkflwIdId);
			}

			if (StringUtils.hasText(strWrkflwIdId)) {
				incdntDtlsId = Integer.parseInt(strIncdntDtlsId);
			}

			incidentExecDtls.setIncidentId(strIncidentId);
			incidentExecDtls.setApplnName(strApplnName);
			incidentExecDtls.setQueName(strQueName);
			incidentExecDtls.setSopId(iSopId);
			incidentExecDtls.setWrkflwId(iWrkflwId);
			incidentExecDtls.setIncidentExecStartDate(new java.util.Date());
			incidentExecDtls.setIncidentExecStatus("Invoked");
			incidentExecDtls.setUsrId(userDetails.getUsrId());
			incidentExecDtls.setIncdntDtlsId(incdntDtlsId);

			log.info("incidentExecDtls is:::::" + incidentExecDtls + ":::::");
			/**
			 * From here is for saving incident Param details
			 */
			JSONObject execIncidentParamsJSONObject = new JSONObject();
			JSONArray jsonExecIncidentParamsArray = execIncidentJSON
					.getJSONArray("execIncidentParamsData");
			if (jsonExecIncidentParamsArray != null) {
				List<IncidentExecParamDtls> incidentExecParamDtlsList = new ArrayList<IncidentExecParamDtls>();
				IncidentExecParamDtls incidentExecParamDtls = null;
				for (int i = 0; i < jsonExecIncidentParamsArray.length(); i++) {
					incidentExecParamDtls = new IncidentExecParamDtls();
					execIncidentParamsJSONObject = jsonExecIncidentParamsArray
							.getJSONObject(i);
					// log.info("execIncidentParamsJSONObject is:"+execIncidentParamsJSONObject.toString());
					incidentExecParamDtls.setParamName(ApplicationUtils
							.getValueFromJSON(execIncidentParamsJSONObject,
									"paramName"));
					incidentExecParamDtls.setParamCode(ApplicationUtils
							.getValueFromJSON(execIncidentParamsJSONObject,
									"paramCode"));
					incidentExecParamDtls.setParamValue(ApplicationUtils
							.getValueFromJSON(execIncidentParamsJSONObject,
									"paramValue"));
					incidentExecParamDtlsList.add(incidentExecParamDtls);
				}
				incidentExecDtls
						.setIncidentExecParamDtlsList(incidentExecParamDtlsList);
			}

			incidentExecutionService.executeIncident(incidentExecDtls);
			log.info("Just before leaving IncdntExecController::handleExecuteIncidentRequest()");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("strJSON", strJSON);
			throw new ApplicationException(
					"IncdntExecController.handleExecuteIncidentRequest", e,
					argsMap);

		}

	}

	/**
	 * This method is called to get List of Incident Execution data .This is an
	 * ajax call.
	 *
	 * @param request
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/getIncidentExecutionList")
	public @ResponseBody DataTableObject getIncidentExecutionData(
			HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside IncdntExecController::getIncidentExecutionData() method ");
		IncidentExecDtls incidentExecDtls = new IncidentExecDtls();
		List<IncidentExecDtls> incidentExecDtlsList = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
			incidentExecDtls.setUsrId(userDetails.getUsrId());

			if (incidentExecDtls != null) {

				incidentExecDtlsList = incidentExecutionService
						.getIncidentExecDtlsList(incidentExecDtls);
			}
			if (incidentExecDtlsList == null) {
				incidentExecDtlsList = new ArrayList<IncidentExecDtls>();
			}
			dataTableObject.setAaData(incidentExecDtlsList);

			log.info("Just before leaving IncdntExecController::getIncidentExecutionData() method"
					+ incidentExecDtlsList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncdntExecController.getIncidentExecutionData", e);
		}
		return dataTableObject;

	}

	/**
	 * This method is called to update incident execution status .This is an ajax call.
	 *
	 * @RequestBody incidentExecDtls
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/updateIncidentExecStatusFromWorkflow")
	public @ResponseBody String updateIncidentExecStatusFromWorkflow(
			@RequestBody IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		log.info("Entered inside IncdntExecController::updateIncidentExecStatusFromWorkflow() method with "
				+ incidentExecDtls.getIncidentExecId());

		try {
			incidentExecutionService
					.updateIncidentExecStatusFromWorkflow(incidentExecDtls);
			log.info("Just before leaving IncdntExecController::updateIncidentExecStatusFromWorkflow(incidentExecDtls) method");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecController.updateIncidentExecStatusFromWorkflow",
					e, argsMap);
		}
		return "{}";
	}

	/**
	 * This method is called to update incident execution from workflow.This is
	 * an ajax call.
	 *
	 * @RequestBody incidentExecDtls
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/updateIncidentExecFromWorkflow")
	public @ResponseBody String updateIncidentExecFromWorkflow(
			@RequestBody IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		log.info("Entered inside IncdntExecController::updateIncidentExecFromWorkflow() method with "
				+ incidentExecDtls.getIncidentExecId());

		try {

			incidentExecutionService
					.updateIncidentExecFromWorkflow(incidentExecDtls);
			log.info("Just before leaving IncdntExecController::updateIncidentExecFromWorkflow(incidentExecDtls) method");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecController.updateIncidentExecFromWorkflow",
					e, argsMap);
		}
		return "{}";
	}

	/**
	 * This method is called to get List of incident execution details by
	 * incident execution Id .This is an ajax call.
	 *
	 * @RequestBody incidentExecDtls
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/getIncidentExecDtlsByIncidentExecId")
	public @ResponseBody DataTableObject getIncidentExecDtlsByIncidentExecId(
			@RequestBody IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		log.info("Entered inside IncdntExecController::getIncidentExecDtlsByIncidentExecId() method with incidentExecutionId"
				+ incidentExecDtls.getIncidentExecId());
		List<IncidentExecDtls> incidentExecDtlsByExecId = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {
			incidentExecDtlsByExecId = incidentExecutionService
					.getIncidentExecDtlsByIncidentExecId(incidentExecDtls);
			dataTableObject.setAaData(incidentExecDtlsByExecId);
			log.info(dataTableObject.getAaData()
					+ "Just before leaving IncdntExecController::getIncidentExecDtlsByIncidentExecId() method"
					+ incidentExecDtlsByExecId);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecController.getIncidentExecDtlsByIncidentExecId",
					e, argsMap);
		}
		return dataTableObject;
	}

	/**
	 * This method is called to get List of incident execution details by
	 * incident Id .This is an ajax call.
	 *
	 * @RequestBody incidentExecDtls
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/getIncidentExecDtlsByIncidentId")
	public @ResponseBody DataTableObject getIncidentExecDtlsByIncidentId(
			@RequestBody IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		log.info("Entered inside IncdntExecController::getIncidentExecDtlsByIncidentId() method with incidentExecutionId"
				+ incidentExecDtls.getIncidentId());
		List<IncidentExecDtls> incidentExecDtlsById = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {
			incidentExecDtlsById = incidentExecutionService
					.getIncidentExecDtlsByIncidentId(incidentExecDtls);
			dataTableObject.setAaData(incidentExecDtlsById);

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecController.getIncidentExecDtlsByIncidentId", e,
					argsMap);
		}
		log.info("Just before leaving IncdntExecController::getIncidentExecDtlsByIncidentId() method:incidentExecDtlsById:"
				+ incidentExecDtlsById + ":");
		return dataTableObject;
	}

}
