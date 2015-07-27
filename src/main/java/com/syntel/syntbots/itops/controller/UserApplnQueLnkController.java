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
import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.service.UsrApplnQueLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for UserApplicationQueueLink.
 *
 * @author Syntel
 * @version 1.0
 */
@Controller
public class UserApplnQueLnkController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UsrApplnQueLnkService userApplicationQueueLinkService;

	/**
	 * This method is called to get List of User Application Queue Link details.
	 * This is an ajax call.
	 * 
	 * @return DataTableObject
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/usrAppQLinkDetails")
	public @ResponseBody DataTableObject getUserApplicationQueueLinkListData()
			throws ApplicationException {
		log.info("Entered inside UserApplnQueLnkController::getUserApplicationQueueLinkListData() method ");
		DataTableObject dataTableObject = new DataTableObject();
		List<UsrApplnQueLnk> userApplicationQueueLinkList = null;
		try {
			userApplicationQueueLinkList = userApplicationQueueLinkService
					.getCompleteUserApplicationQueueLinkList();
			
			for (UsrApplnQueLnk usrApplnQueLnk : userApplicationQueueLinkList) {
				
				String UsrApplnQLnkActions = "<a href=\"javaScript:fnPopulateUsrApplnQLnkDtlsInPopUp('"+usrApplnQueLnk.getUsrAppQLinkId()+"');\" title='Edit ApplicationDetails'><i class='fa fa-pencil'></i> </a>";
				usrApplnQueLnk.setUsrAppQLinkActions(UsrApplnQLnkActions);								
			}
			
			
			
			
			dataTableObject.setAaData(userApplicationQueueLinkList);
			log.info(dataTableObject.getAaData()
					+ "Just before leaving UserApplnQueLnkController::getUserApplicationQueueLinkListData() getAppQueueSopLinkListData:"
					+ userApplicationQueueLinkList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UserApplnQueLnkController.getUserApplicationQueueLinkListData",
					e);
		}
		return dataTableObject;
	}
	/**
	 * This method is called to validate User Application Queue Link details while creating new link.
	 * This is an ajax call.
	 * @param  User Application Queue Link details
	 * @return int count of User Application Queue
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/valUsrApplnQueLinkDtls")	
	public @ResponseBody int itOpsValUsrApplnQueLinkDtls(@RequestBody UsrApplnQueLnk usrApplnQueLnk) throws ApplicationException {
		log.info("Entered inside UserApplnQueLnkController::itOpsValUsrApplnQueLinkDtls() method with UsrApplnQueLnk as:"+usrApplnQueLnk);
		int countUsrApplnQueLink = 0;
		try{
			countUsrApplnQueLink=userApplicationQueueLinkService.ValUsrApplnQueLinkDtls(usrApplnQueLnk);
			log.info("countUsrApplnQueLink"+countUsrApplnQueLink);
			log.info("Just before leaving UserApplnQueLnkController::itOpsValUsrApplnQueLinkDtls() method");
			
			
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrApplnQueLnk",usrApplnQueLnk);
			throw new ApplicationException(
					"UserApplnQueLnkController.itOpsValUsrApplnQueLinkDtls", e, argsMap);
		}
		return countUsrApplnQueLink;
	}
	/**
	 * This method is called to add new User Application Queue Link details.
	 * This is an ajax call.
	 * @param  User Application Queue Link details
	 * @return String
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/addUsrApplnQueLinkDtls")	
	public @ResponseBody String addUsrApplnQueLinkDtls(@RequestBody UsrApplnQueLnk usrApplnQueLnk,HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside UserApplnQueLnkController::addUsrApplnQueLinkDtls() method with UsrApplnQueLnk as:"+usrApplnQueLnk);
		UserDetails userDetails = null;
		long usrId = 0;
		try{
			 userDetails = ApplicationUtils.getLogedInUser(request);
			 usrId = userDetails.getUsrId();
			
			 usrApplnQueLnk.setUsrAppQLinkCreatedBy((int) usrId);
			 userApplicationQueueLinkService.addUsrApplnQueLinkDtls(usrApplnQueLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrApplnQueLnk",usrApplnQueLnk);
			throw new ApplicationException(
					"UserApplnQueLnkController.addUsrApplnQueLinkDtls", e, argsMap);
		}
		log.info("Just before leaving UserApplnQueLnkController::addUsrApplnQueLinkDtls() method");
		return "{}";
	}
	/**
	 * This method is called to update existing User Application Queue Link details.
	 * This is an ajax call.
	 * @param  User Application Queue Link details
	 * @return String
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/updateUsrApplnQueLinkDtls")	
	public @ResponseBody String updateUsrApplnQueLinkDtls(@RequestBody UsrApplnQueLnk usrApplnQueLnk,HttpServletRequest request) throws ApplicationException {
		log.info("Entered inside UserApplnQueLnkController::updateUsrApplnQueLinkDtls() method with UsrApplnQueLnk as:"+usrApplnQueLnk);
		UserDetails userDetails = null;
		long usrId = 0;
		try{
			 userDetails = ApplicationUtils.getLogedInUser(request);
			 usrId = userDetails.getUsrId();
			
			 usrApplnQueLnk.setUsrAppQLinkModifiedBy((int) usrId);
			 userApplicationQueueLinkService.updateUsrApplnQueLinkDtls(usrApplnQueLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("usrApplnQueLnk",usrApplnQueLnk);
			throw new ApplicationException(
					"UserApplnQueLnkController.updateUsrApplnQueLinkDtls", e, argsMap);
		}
		log.info("Just before leaving UserApplnQueLnkController::updateUsrApplnQueLinkDtls() method");
		return "{}";
	}
}
