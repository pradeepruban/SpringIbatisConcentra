/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syntel.syntbots.itops.dto.DataTableObject;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.service.UserDetailsService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;


/**
 * This class contains all the controller methods for UserApplicationQueueLink.
 *
 * @author Syntel
 * @version 1.0
 */
@Controller
public class UserDetailsController {
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserDetailsService userDetailsService;
	
	/**
	 * This method is called to get user details
	 * This is an ajax call.
	 * @param 
	 * @return response data table object
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/usrdetailslist")
	public @ResponseBody DataTableObject getUserDetailsListData()
			throws ApplicationException {
	
		log.info("Entered inside UserDetailsController::getUserDetailsListData() method ");
		DataTableObject dataTableObject = new DataTableObject();
		List<UserDetails> userDetailsList = null;
		try {
			userDetailsList = userDetailsService.getCompleteUserDetailsList();
			dataTableObject.setAaData(userDetailsList);
			log.info(dataTableObject.getAaData()
					+ "Just before leaving UserDetailsController::getUserDetailsListData() getUserDetailsListData:"
					+ userDetailsList);
		}catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UserDetailsController.getUserDetailsListData",
					e);
		}
		return dataTableObject;
	}
}
