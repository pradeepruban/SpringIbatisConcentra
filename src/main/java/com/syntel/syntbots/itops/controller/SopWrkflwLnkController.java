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
import com.syntel.syntbots.itops.dto.SopWrkflwLnk;
import com.syntel.syntbots.itops.service.SopWrkflwLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for SopWorkflowLink Details.
 *
 * @author Syntel
 * @version 1.0
 */

@Controller
public class SopWrkflwLnkController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SopWrkflwLnkService sopWorkflowLinkService;

	/**
	 * This method is called to get List of Sop Workflow Link details. 
	 * This is an ajax call.
	 *
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/listSopWrkflwLnkDetails")
	public @ResponseBody DataTableObject getSopWorkflowLnkListData()
			throws ApplicationException {
		log.info("Entered inside SopWrkflwLnkController::getSopWorkflowLnkListData() method ");
		List<SopWrkflwLnk> sopWrkflwLnkList = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {
			sopWrkflwLnkList = sopWorkflowLinkService
					.getCompleteSopWorkflowLnkList();
			dataTableObject.setAaData(sopWrkflwLnkList);
			log.info(dataTableObject.getAaData()
					+ "Just before leaving SopWrkflwLnkController::getSopWorkflowLnkListData() method"
					+ sopWrkflwLnkList);

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopWrkflwLnkController.getSopWorkflowLnkListData", e);
		}
		return dataTableObject;
	}
}
