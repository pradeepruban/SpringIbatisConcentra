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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syntel.syntbots.itops.dto.DataTableObject;
import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.service.WorkflowDtlsService;
import com.syntel.syntbots.itops.service.WrkflwPrmLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for Workflow details.
 *
 * @author Syntel
 * @version 1.0
 */
@Controller
public class WorkflowDtlsController {

	private Logger log = Logger.getLogger(this.getClass());

	/** This is default constructor */
	public WorkflowDtlsController() {
		log.info("Inside WorkflowDtlsController constructor");
	}

	@Autowired
	private WorkflowDtlsService workflowDtlsService;

	@Autowired
	private WrkflwPrmLnkService workflowParamLnkService;

	/**
	 * This method is called to get  WorkFlow Details List.
	 * This is an ajax call.
	 * 
	 * @return DataTableObject
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/listWrkflowDtls")
	public @ResponseBody DataTableObject getWrkFlwDtlsList()
			throws ApplicationException {

		log.info("Entered inside WorkflowDtlsController::getWrkFlwDtlsList() method ");
		List<WorkflowDetails> wrkflwDtlsList = null;
	
		DataTableObject dataTableObject = new DataTableObject();
		try {
			wrkflwDtlsList = workflowDtlsService.getWrkflwDtlsList();
			
			
			dataTableObject.setAaData(wrkflwDtlsList);

			log.info(dataTableObject.getAaData()
					+ "Just before leaving IncidentController::getIncidentData() method"
					+ wrkflwDtlsList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"WorkflowDtlsController.getWrkFlwDtlsList", e);
		}
		return dataTableObject;
	}

	/**
	 * This method is called to get List of encrypted param details based on workflow Id.
	 * This is an ajax call.
	 *
	 * @RequestBody workflowDtls
	 * @return DataTableObject
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/getEncryptedParamNamesByWrkflwId")
	public @ResponseBody List<WorkflowParamLnk> getEncryptedParamNamesByWrkflwId(
			@RequestBody WorkflowDetails workflowDtls)
			throws ApplicationException {

		log.info("Entered inside WorkflowDtlsController::getEncryptedParamNamesByWrkflwId() method with "
				+ workflowDtls.getWrkflwId());

		List<WorkflowParamLnk> workflowParamLnkEncryptedList = null;
		try {
			workflowParamLnkEncryptedList = workflowParamLnkService
					.getEncryptedParamNamesByWrkflwId(workflowDtls);

			for (WorkflowParamLnk workflowParamLnk : workflowParamLnkEncryptedList) {
				log.info("Just before leaving WorkflowDtlsController::getEncryptedParamNamesByWrkflwId() method"
						+ workflowParamLnk.getParamName());
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls",workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsController.getEncryptedParamNamesByWrkflwId",
					e, argsMap);
		}
		return workflowParamLnkEncryptedList;
	}

	/**
	 * This method is called to get List of encrypted param details based on incident execution Id .
	 * This is an ajax call.
	 *
	 * @RequestBody incidentExecDtls
	 * @return DataTableObject
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/getEncryptedParamNamesByIncdntExecId")
	public @ResponseBody List<WorkflowParamLnk> getEncryptedParamNamesByIncdntExecId(
			@RequestBody IncidentExecDtls incidentExecDtls)
			throws ApplicationException {

		log.info("Entered inside WorkflowDtlsController::getEncryptedParamNamesByIncdntExecId() method with "
				+ incidentExecDtls.getIncidentExecId());

		List<WorkflowParamLnk> workflowParamLnkEncryptedListByIncdntId = null;

		try {
			workflowParamLnkEncryptedListByIncdntId = workflowParamLnkService
					.getEncryptedParamNamesByIncdntExecId(incidentExecDtls);

			for (WorkflowParamLnk workflowParamLnkList : workflowParamLnkEncryptedListByIncdntId) {
				log.info("Just before leaving WorkflowDtlsController::getEncryptedParamNamesByIncdntExecId() method"
						+ workflowParamLnkList.getParamName());
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls",incidentExecDtls);
			throw new ApplicationException(
					"WorkflowDtlsController.getEncryptedParamNamesByIncdntExecId",
					e, argsMap);
		}
		return workflowParamLnkEncryptedListByIncdntId;
	}

	/**
	 * This method is called to get List of Workflow details based on WorkflowName .
	 * This is an ajax call.
	 *
	 * @RequestBody workflowDtls
	 * @return WorkflowDtls DTO
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/getWrkflwDtlsByWrkflwName")
	public @ResponseBody WorkflowDetails getWrkflwDtlsByWrkflwName(
			@RequestBody WorkflowDetails workflowDtls)
			throws ApplicationException {

		log.info("Entered inside WorkflowDtlsController::getWrkflwDtlsByWrkflwName() method with "
				+ workflowDtls.getWrkflwName());

		WorkflowDetails workflowDtlsByWrkflwName = null;
		List<WorkflowParamLnk> wrkflwParamDetailsList=null;
		try {

			workflowDtlsByWrkflwName = workflowDtlsService.getWrkflwDtlsByWrkflwName(workflowDtls);
			wrkflwParamDetailsList=workflowDtlsByWrkflwName.getWorkflowParamLnkList();
			
			for (WorkflowParamLnk wrkflwParamDetails2 : wrkflwParamDetailsList) {
	    		
				log.info("wrkflwParamDetails for loop"+wrkflwParamDetails2);
	    		String wrkflwParamDtlsAction ="<a href=\"javaScript:fnPopulateWrkflwParamDtlsInPopup('" +wrkflwParamDetails2.getWrkflwId()+"','"+wrkflwParamDetails2.getWrkflwParamLnkId() +"');\" title='Sop Param Edit'><i style='margin-left: 22%;' class='fa fa-pencil '></i></a>";
	    		
	    		log.info("wrkflwParamDtlsAction for loop"+wrkflwParamDtlsAction);
	    		
	    		wrkflwParamDetails2.setWrkflwParamAction(wrkflwParamDtlsAction);
	    		log.info("wrkflwParamDetails for loop DTO"+wrkflwParamDetails2.getWrkflwParamAction());
	    		
	    	}
			workflowDtlsByWrkflwName.setWorkflowParamLnkList(wrkflwParamDetailsList);
			log.info("Just before leaving WorkflowDtlsController::getWrkflwDtlsByWrkflwName() method"
					+ workflowDtlsByWrkflwName);
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls",workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsController.getWrkflwDtlsByWrkflwName", e, argsMap);
		}
		return workflowDtlsByWrkflwName;
	}
	
	/**
	 * This method is called to get count of workflow name to check whether workflow name already exists.
	 * This is an ajax call.
	 * @RequestBody workflow Details
	 * @return int count of workflow name
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/itOpsValWrkflwDtls")	
	public @ResponseBody int itOpsValWrkflwDtls(@RequestBody WorkflowDetails workflowDtls) throws ApplicationException {
		log.info("Entered inside WorkflowDtlsController::itOpsValWrkflwDtls() method with WorkflowDetails as:"+workflowDtls+":"+workflowDtls.getWrkflwName());
		int countWrkflwName = 0;
		try{
			 countWrkflwName=workflowDtlsService.validateWrkflwName(workflowDtls);
			log.info("countSOPName"+countWrkflwName);
			log.info("Just before leaving WorkflowDtlsController::itOpsValWrkflwDtls() method");
			
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls",workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsController.itOpsValWrkflwDtls", e, argsMap);
		}
		return countWrkflwName;
	}
	/**
	 * This method is called to save workflow details(add or update)
	 * This is an ajax call.
	 * @RequestBody workflow Details
	 * @return string
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/itOpsSaveWrkflwDtls")	
	public @ResponseBody String itOpsSaveWrkflwDtls(@RequestBody WorkflowDetails workflowDtls,HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside WorkflowDtlsController::itOpsSaveWrkflwDtls() method with WorkflowDetails as:"+workflowDtls);
		UserDetails userDetails = null;
		long usrId = 0;
		try{
			 userDetails = ApplicationUtils.getLogedInUser(request);
			 usrId = userDetails.getUsrId();
			
			workflowDtls.setCreatedBy((int) usrId);
			workflowDtls.setModifiedBy((int) usrId);
			
			workflowDtlsService.saveWrkflwDtls(workflowDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls",workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsController.itOpsSaveWrkflwDtls", e, argsMap);
		}
		log.info("Just before leaving WorkflowDtlsController::itOpsSaveWrkflwDtls() method");
		return "{}";
	}
	/**
	 * This method is called to get count of workflow param name to check whether workflow param name already exists.
	 * This is an ajax call.
	 * @RequestBody workflow param Details
	 * @return int count of workflow param name
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/itOpsValWrkflwParamDtls")	
	public @ResponseBody int itOpsValWrkflwParamDtls(@RequestBody WorkflowParamLnk workflowParamLnk) throws ApplicationException {
		log.info("Entered inside WorkflowDtlsController::itOpsValWrkflwParamDtls() method with WorkflowDetails as:"+workflowParamLnk+":"+workflowParamLnk.getParamName());
		int countWrkflwParamNameCount = 0;
		try{
			countWrkflwParamNameCount=workflowParamLnkService.validateWorkflowParamName(workflowParamLnk);
			log.info("countWrkflwParamNameCount"+countWrkflwParamNameCount);
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowParamLnk",workflowParamLnk);
			throw new ApplicationException(
					"WorkflowDtlsController.itOpsValWrkflwParamDtls", e, argsMap);
		}
		log.info("Just before leaving WorkflowDtlsController::itOpsValWrkflwParamDtls() method");
		return countWrkflwParamNameCount;
	}
	/**
	 * This method is called to save workflow details(add or update)
	 * This is an ajax call.
	 * @RequestBody workflow Details
	 * @return string
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/itOpsSaveWrkflwParamDtls")	
	public @ResponseBody String saveWrkflwParamDtls(@RequestBody WorkflowParamLnk workflowParamLnk,HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside WorkflowDtlsController::saveWrkflwParamDtls() method with workflowParamLnk as:"+workflowParamLnk+":"+workflowParamLnk.getParamName());
		UserDetails userDetails = null;
		long usrId = 0;
		try{
			 userDetails = ApplicationUtils.getLogedInUser(request);
			 usrId = userDetails.getUsrId();
	
			workflowParamLnk.setCreatedBy((int) usrId);
			workflowParamLnk.setModifiedBy((int) usrId);
			workflowParamLnkService.saveWrkflwParamDtls(workflowParamLnk);
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowParamLnk",workflowParamLnk);
			throw new ApplicationException(
					"WorkflowDtlsController.saveWrkflwParamDtls", e, argsMap);
		}
		log.info("Just before leaving saveWrkflwParamDtls::saveWrkflwParamDtls() method");
		return "{}";
	}

}
