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
import com.syntel.syntbots.itops.dto.QueueDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.service.QueueDtlsService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the controller methods for QueueDtls.
 *
 * @author Syntel
 * @version 1.0
 */
@Controller
public class QueueDtlsController {

	@Autowired
	private QueueDtlsService queueDtlsService;

	private Logger log = Logger.getLogger("inside QueueDtlsController"
			+ this.getClass());

	/**
	 * This method is called to get List of Queue details.
	 *
	 * @return response - DataTableObject
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/getQueueDtls")
	@ResponseBody
	public DataTableObject getQueueDtls() throws ApplicationException {
		log.info("Entered inside QueueDtlsController::getQueueDtls()");

		DataTableObject dataTableObject = new DataTableObject();
		try {

			List<QueueDetails> queueDtls = null;
			queueDtls = queueDtlsService.getQueueDtls();
			for (QueueDetails queueDeatails : queueDtls) {

				String queueDeatailsActions = "<a href=\"javaScript:fnPopulateQueueDtls('"
						+ queueDeatails.getQueId()
						+ "','"
						+ queueDeatails.getQueName()
						+ "');\" title='Edit QueueDetails'><i class='fa fa-pencil'></i> </a>";
				queueDeatails.setQueueAction(queueDeatailsActions);
			}
			log.info("returned value" + queueDtls);
			dataTableObject.setAaData(queueDtls);

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("QueueDtlsController.getQueueDtls",
					e);
		}
		log.info("Just before leaving QueueDtlsController::getQueueDtls()");
		return dataTableObject;

	}
	/**
	 * This method is called to save Queue details.
	 * @RequestBody-Queue Details,request
	 * @return response - String
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itopsEditQueuedtls")
	public @ResponseBody String saveQueue(
			@RequestBody QueueDetails queueDetails, HttpServletRequest request)
			throws ApplicationException {
		try {

			log.info("Entered inside QueueDtlsController::saveQueue() method with queueDetails as:"
					+ queueDetails + ":" + queueDetails.getQueDesc());
			UserDetails userDetails = ApplicationUtils.getLogedInUser(request);

			long usrId = userDetails.getUsrId();
			queueDetails.setCreatedBy((int) usrId);
			queueDetails.setModifiedBy((int) usrId);

			queueDtlsService.saveQueue(queueDetails);
			log.info("Just before leaving QueueDtlsController::saveQueue() method.");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueDetails", queueDetails);
			throw new ApplicationException("QueueDtlsController.saveQueue", e, argsMap);
		}
		return "{}";
	}
	/**
	 * This method is called to validate Queue details.
	 * @RequestBody-Queue Details
	 * @return response - int count of queue name
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/itOpsValQueDtls")
	public @ResponseBody int validateQueName(
			@RequestBody QueueDetails queueDetails) throws ApplicationException {
		log.info("Entered inside QueueDtlsController::validateQueName() method with queueDetails as:"
				+ queueDetails + ":" + queueDetails.getQueId());
		int countQueName = 0;
		try {
			countQueName = queueDtlsService.validateQueName(queueDetails);
			log.info("countQueName" + countQueName);
			log.info("Just before leaving QueueDtlsController::validateQueName() method");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueDetails", queueDetails);
			throw new ApplicationException(
					"QueueDtlsController.validateQueName", e, argsMap);
		}
		return countQueName;
	}

}
