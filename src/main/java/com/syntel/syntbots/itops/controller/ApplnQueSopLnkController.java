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
import com.syntel.syntbots.itops.dto.ApplnQueSopLnk;
import com.syntel.syntbots.itops.dto.DataTableObject;
import com.syntel.syntbots.itops.service.ApplnQueSopLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for ApplicationQueueSopLink.
 *
 * @author Syntel
 * @version 1.0
 */

@Controller
public class ApplnQueSopLnkController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private ApplnQueSopLnkService applicationQueueSopLinkservice;

	/**
	 * This method is called to get List of Application Queue Sop Link
	 * details.This is an ajax call.
	 *
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */

	@RequestMapping(value = "/appQueueSopLnkDetails")
	public @ResponseBody DataTableObject getAppQueueSopLinkListData()
			throws ApplicationException {
		log.info("Entered inside ApplnQueSopLnkController::getAppQueueSopLinkListData() method ");
		List<ApplnQueSopLnk> applicationQueueSopLinkList = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {
			applicationQueueSopLinkList = applicationQueueSopLinkservice
					.getCompleteApplicationQueueSopLinkList();
			dataTableObject.setAaData(applicationQueueSopLinkList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"ApplnQueSopLnkController.getAppQueueSopLinkListData", e);
		}
		log.info("Just before leaving ApplnQueSopLnkController::getAppQueueSopLinkListData():applicationQueueSopLinkList:"
				+ applicationQueueSopLinkList + ":");
		return dataTableObject;
	}
}
