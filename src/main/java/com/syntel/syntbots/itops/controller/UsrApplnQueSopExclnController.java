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
import com.syntel.syntbots.itops.dto.UsrApplnQueSopExclusn;
import com.syntel.syntbots.itops.service.UsrApplnQueSopExclusnService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for
 * UserApplicationQueueSopExclusion.
 *
 * @author Syntel
 * @version 1.0
 */
@Controller
public class UsrApplnQueSopExclnController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UsrApplnQueSopExclusnService userApplicationQueueSopExclusionService;

	/**
	 * This method is called to get List of User Application Queue Sop Exclusion details.
	 * This is an ajax call.
	 * 
	 * @return DataTableObject
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/usrApplnQueSopExclsnDetails")
	public @ResponseBody DataTableObject getUserApplicationQueueSopExclusionList()
			throws ApplicationException {
		log.info("Entered inside UsrApplnQueSopExclnController::getUserApplicationQueueSopExclusionList() method ");
		DataTableObject dataTableObject = new DataTableObject();
		List<UsrApplnQueSopExclusn> userApplicationQueueSopExclusionList = null;
		try {
			userApplicationQueueSopExclusionList = userApplicationQueueSopExclusionService
					.getCompleteUserApplicationQueueSopExclusionList();
			dataTableObject.setAaData(userApplicationQueueSopExclusionList);
			log.info(dataTableObject.getAaData()
					+ "Just before leaving UsrApplnQueSopExclnController::getUserApplicationQueueSopExclusionList() getCompleteUserApplicationQueueSopExclusionList:"
					+ userApplicationQueueSopExclusionList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UsrApplnQueSopExclnController.getUserApplicationQueueSopExclusionList",
					e);
		}
		return dataTableObject;
	}
}
