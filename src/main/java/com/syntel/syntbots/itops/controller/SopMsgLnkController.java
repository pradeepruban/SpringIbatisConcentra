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
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.service.SopMsgLnkService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for SopMsgLnk.
 *
 * @author Syntel
 * @version 1.0
 */

@Controller
public class SopMsgLnkController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SopMsgLnkService sopMsgLnkService;

	/**
	 * This method is called to get List of Sop Message Link Details. 
	 * This is an ajax call.
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/listSopMskLnkDetails")
	public @ResponseBody DataTableObject getSopMsgLnkListData()
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkController::getSopMsgLnkListData() method ");
		List<SopMsgLnk> sopMsgLnkList = null;
		DataTableObject dataTableObject = new DataTableObject();
		try {
			sopMsgLnkList = sopMsgLnkService.getCompleteSopMsgLnkList();
			dataTableObject.setAaData(sopMsgLnkList);
			log.info(dataTableObject.getAaData()
					+ "Just before leaving SopMsgLnkController::getSopMsgLnkListData() method"
					+ sopMsgLnkList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkController.getSopMsgLnkListData", e);
		}
		return dataTableObject;

	}
}
