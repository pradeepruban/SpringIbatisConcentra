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

import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.dto.DataTableObject;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.service.ApplicationDtlsService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;

/**
*This class contains all the controller methods for ApplicationDetails.
*@author Syntel
*@version 1.0
*/

@Controller
public class ApplicationDetailsController {
	
@Autowired	
private ApplicationDtlsService applctnDtlsService;

private Logger log = Logger.getLogger("inside ApplicationDetailsController"+this.getClass());


/**
*This method is called to get List of Application details.This is an ajax call.
*@param request
*@return response - DataTableObject
*@exception -  ApplicationException in case of error
*/
@RequestMapping(value = "/getApplicationDtlsToView")
@ResponseBody public DataTableObject getApplicationDtlsList() throws ApplicationException {
		log.info("Entered inside ApplicationDetailsController::getApplicationDtlsList()");
		
		DataTableObject dataTableObject = new DataTableObject();
		try {
			List<ApplicationDetails> applicationDtls = null;
			applicationDtls = applctnDtlsService.getApplicationDtlsToView();
			
			for (ApplicationDetails applicationDeatails : applicationDtls) {
				String applicationActions = "<a href=\"javaScript:fnPopulateApplicationDtlsInPopUp('"
						+ applicationDeatails.getApplnId()
						+ "','"
						+ applicationDeatails.getApplnName()
						+ "');\" title='Edit ApplicationDetails'><i class='fa fa-pencil'></i> </a>";
				applicationDeatails.setApplicationActions(applicationActions);
			}
			
			log.info("returned applicationDtls " + applicationDtls);
			dataTableObject.setAaData(applicationDtls);
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			
			throw new ApplicationException("ApplicationDetailsController.getApplicationDtlsList", e);
		}
		
		log.info("Just before leaving ApplicationDetailsController::getApplicationDtlsList()");
		return dataTableObject;
}

/**
*This method is used to Save of Application details.This is an ajax call.
*@param applicationDetails
*@return response -
*@exception -  ApplicationException in case of error
*/
@RequestMapping(value = "/itopsAddEditApplicationDtls")	
public @ResponseBody void itopsSaveApplicationDtls(@RequestBody ApplicationDetails applicationDetails,
		HttpServletRequest request) throws ApplicationException {
		try {
			applctnDtlsService = null;
			log.info("Entered inside ApplicationDetailsController::itopsSaveApplicationDtls() method with ApplicationDtls as:"
					+ applicationDetails + ":" + applicationDetails.getApplnDesc());
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);

			long usrId = userDetails.getUsrId();
			applicationDetails.setCreatedBy((int) usrId);
			applicationDetails.setModifiedBy((int) usrId);
			applctnDtlsService.saveApplicationDtls(applicationDetails);
			log.info("Just before leaving ApplicationDetailsController::itopsSaveApplicationDtls() method.");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("applicationDetails", applicationDetails);
			throw new ApplicationException(
					"ApplicationDetailsController.itopsSaveApplicationDtls", e, argsMap);
		}
		
}


/**
*This method is used to Checking whether the ApplicationName is already exist or not .This is an ajax call.
*@param applicationDetails
*@return response -
*@exception -  ApplicationException in case of error
*/
@RequestMapping(value = "/itOpsValApplicationDtls")	
public @ResponseBody int itOpsCheckAppNameExist(@RequestBody ApplicationDetails applicationDetails) throws ApplicationException {
	log.info("Entered inside ApplicationDetailsController::itOpsCheckAppNameExist() method with ApplicationDtls as:"
				+ applicationDetails + ":" + applicationDetails.getApplnId());
	int countApplicationName = 0;
		try {
			 countApplicationName = applctnDtlsService.validateApplicationName(applicationDetails);
			log.info("countApplicationName" + countApplicationName);

	}catch (ApplicationException e) {
		throw e;
	} catch (Exception e) {
		Map argsMap = new HashMap();
		argsMap.put("applicationDetails", applicationDetails);
		throw new ApplicationException(
				"ApplicationDetailsController.itOpsCheckAppNameExist", e, argsMap);
	}
		log.info("Just before leaving ApplicationDetailsController::itOpsCheckAppNameExist() method");
		return countApplicationName;

}

}