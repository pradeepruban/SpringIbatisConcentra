/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

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
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.service.SopDetailsService;
import com.syntel.syntbots.itops.service.WrkflwPrmLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for SopDetails.
 *
 * @author Syntel
 * @version 1.0
 */

@Controller
public class SopDetailsController {

	@Autowired
	private SopDetailsService sopDetailsService;

	@Autowired
	private WrkflwPrmLnkService workflowParamLnkService;

	private Logger log = Logger.getLogger("inside SopDetailsController"
			+ this.getClass());

	/**
	 * This method is called to get List of Sop details.This is an ajax call.
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/getSopDetailsToView")
	@ResponseBody
	public DataTableObject getSopDtlsList() throws ApplicationException {
		log.info("Entered inside SopDetailsController::getSopDtlsList()");
		DataTableObject dataTableObject = new DataTableObject();
		try {

			List<SopDetails> sopDtls = null;
			sopDtls = sopDetailsService.getSopDetailsToView();

			List<SopParamDetails> SopParamDetails = null;

			for (SopDetails sopDetails : sopDtls) {
				String SOPDtlsAction = "<a href=\"javaScript:fnPopulateSOPDtlsInPopup('"
						+ sopDetails.getSopId()
						+ "');\" title='Sop Edit'><i style='margin-left: 22%;' class='fa fa-pencil '></i></a>";
				sopDetails.setSopAction(SOPDtlsAction);

				SopParamDetails = sopDetails.getSopParamDetails();
				for (SopParamDetails sopParamDetails2 : SopParamDetails) {
					String SOPParamDtlsAction = "<a href=\"javaScript:fnPopulateSOPParamDtlsInPopup('"
							+ sopParamDetails2.getSopId()
							+ "','"
							+ sopParamDetails2.getSopParamId()
							+ "');\" title='Sop Param Edit'><i style='margin-left: 22%;' class='fa fa-pencil '></i></a>";
					sopParamDetails2.setSopParamAction(SOPParamDtlsAction);
				}

			}
			log.info("returned value" + sopDtls);
			dataTableObject.setAaData(sopDtls);

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopDetailsController.getSopDtlsList", e);
		}
		log.info("Just before leaving SopDetailsController::getSopDtlsList()");
		return dataTableObject;

	}

	/**
	 * This method is called to get count of SOP name for given SOP name. This
	 * is an ajax call.
	 * @param sopDetails
	 * @return response - int count
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsValSOPDtls")
	public @ResponseBody int validateSOPName(@RequestBody SopDetails sopDetails)
			throws ApplicationException {
		log.info("Entered inside SopDetailsController::validateSOPName() method with sopDetails as:"
				+ sopDetails + ":" + sopDetails.getSopId());
		int countSOPName = 0;
		try {

			countSOPName = sopDetailsService.validateSOPName(sopDetails);
			log.info("countSOPName" + countSOPName);
			log.info("Just before leaving SopDetailsController::validateSOPName() method");

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopDetails", sopDetails);
			throw new ApplicationException(
					"SopDetailsController.validateSOPName", e, argsMap);
		}
		return countSOPName;
	}

	/**
	 * This method is called to save or update SOP details.This is an ajax call.
	 * @param sopDetails
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsSaveSOPDtls")
	public @ResponseBody String saveSOPDtls(@RequestBody SopDetails sopDetails,
			HttpServletRequest request) throws ApplicationException {
		try {

			log.info("Entered inside SopDetailsController::saveSOPDtls() method with sopDetails as:"
					+ sopDetails + ":" + sopDetails.getSopId());
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
			long usrId = userDetails.getUsrId();

			sopDetails.setCreatedBy((int) usrId);
			sopDetails.setModifiedBy((int) usrId);

			sopDetailsService.saveSOPDtls(sopDetails);
			log.info("Just before leaving SopDetailsController::saveSOPDtls() method");

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopDetails", sopDetails);
			throw new ApplicationException("SopDetailsController.saveSOPDtls",
					e, argsMap);
		}

		return "{}";
	}

	/**
	 * This method is called to get Workflow ParamCode List by sopId.This is an
	 * ajax call.
	 * @param sopDetails
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsGetParamCodeList")
	public @ResponseBody List<WorkflowParamLnk> getWorkflwParamCodeListBySOPId(
			@RequestBody SopDetails sopDetails) throws ApplicationException {

		log.info("Entered inside SopDetailsController::getWorkflwParamCodeListBySOPId() method with "
				+ sopDetails.getSopId());

		List<WorkflowParamLnk> workflowParamLnkListBySOPId = null;
		try {
			workflowParamLnkListBySOPId = workflowParamLnkService
					.getWorkflwParamCodeListBySOPId(sopDetails);
			for (WorkflowParamLnk workflowParamLnk : workflowParamLnkListBySOPId) {
				log.info("Just before leaving WorkflowDtlsController::handleGetEncryptedParamNamesByWrkflwId() method"
						+ workflowParamLnk.getParamName());
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopDetails", sopDetails);
			throw new ApplicationException(
					"SopDetailsController.getWorkflwParamCodeListBySOPId", e,
					argsMap);
		}
		return workflowParamLnkListBySOPId;
	}

	/**
	 * This method is called to Save SOP Param Details
	 * @param sopParamDetail
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsAddSOPParamDtls")
	public @ResponseBody String addSOPParamDtls(
			@RequestBody SopParamDetails sopParamDetails,
			HttpServletRequest request) throws ApplicationException {
		try {

			log.info("Entered inside SopDetailsController::addSOPParamDtls() method with sopParamDetails as:"
					+ sopParamDetails + ":" + sopParamDetails.getParamCode());
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
			long usrId = userDetails.getUsrId();

			sopParamDetails.setCreatedBy((int) usrId);
			sopDetailsService.addSOPParamDtls(sopParamDetails);
			log.info("Just before leaving SopDetailsController::addSOPParamDtls() method");
			return "{}";
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopParamDetails", sopParamDetails);
			throw new ApplicationException(
					"SopDetailsController.addSOPParamDtls", e, argsMap);
		}
	}

	/**
	 * This method is called to Validating SOP Param Details
	 * @param sopParamDetails
	 * @return response - int count of SOP param code
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsValSOPParamDtls")
	public @ResponseBody int validateSOPParamDtls(
			@RequestBody SopParamDetails sopParamDetails)
			throws ApplicationException {
		log.info("Entered inside SopDetailsController::itOpsValSOPParamDtls() method with sopParamDetails as:"
				+ sopParamDetails + ":" + sopParamDetails.getParamCode());
		int countParamCode = 0;
		try {

			countParamCode = sopDetailsService
					.validateSOPParamCode(sopParamDetails);
			log.info("countParamCode" + countParamCode);
			log.info("Just before leaving SopDetailsController::itOpsValSOPParamDtls() method");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopParamDetails", sopParamDetails);
			throw new ApplicationException(
					"SopDetailsController.validateSOPParamDtls", e, argsMap);
		}
		return countParamCode;
	}

	/**
	 * This method is called to Update SOP Param Details
	 * @param sopParamDetails
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsUpdateSOPParamDtls")
	public @ResponseBody String updateSOPParamDtls(
			@RequestBody SopParamDetails sopParamDetails,
			HttpServletRequest request) throws ApplicationException {
		try {

			log.info("Entered inside SopDetailsController::updateSOPParamDtls() method with sopParamDetails as:"
					+ sopParamDetails + ":" + sopParamDetails.getParamCode());
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);
			long usrId = userDetails.getUsrId();

			sopParamDetails.setModifiedBy((int) usrId);
			sopDetailsService.updateSOPParamDtls(sopParamDetails);
			log.info("Just before leaving SopDetailsController::updateSOPParamDtls() method");

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopParamDetails", sopParamDetails);
			throw new ApplicationException(
					"SopDetailsController.updateSOPParamDtls", e, argsMap);
		}
		return "{}";
	}

}
