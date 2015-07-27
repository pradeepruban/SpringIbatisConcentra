/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syntel.syntbots.itops.dto.EncryptionDetails;
import com.syntel.syntbots.itops.service.SyntBotsITOpsUtillService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This is a container class for IT Ops Util application.
 * 
 * @author Syntel
 * @version 1.0
 */
@Controller
public class SyntBotsITOpsUtillController {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SyntBotsITOpsUtillService syntBotsITOpsUtillService;

	/**
	 * This is used for encrypting the given data
	 * 
	 * @param encryptionDtls
	 *            - this contains data to be encrypted
	 * @return String
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/syntbotsITOpsEncryptData")
	public @ResponseBody String handleEncryptData(
			@RequestBody EncryptionDetails encryptionDtls)
			throws ApplicationException {
		String encryptedData = null;
		try {
			log.info("Entered inside SyntBotsITOpsUtillController::handleEncryptData");
			encryptedData = syntBotsITOpsUtillService
					.encryptData(encryptionDtls.getData());

		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("encryptionDtls",encryptionDtls);
			throw new ApplicationException(
					"SyntBotsITOpsUtillController.handleEncryptData", e, argsMap);
		}
		return encryptedData;
	}

	/**
	 * This is used for decrypting the given encrypted data
	 * 
	 * @param request
	 *            - request
	 * @return String
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/syntbotsITOpsDecryptData")
	public @ResponseBody String handleDecryptData(HttpServletRequest request)
			throws ApplicationException {

		log.info("Entered inside SyntBotsITOpsUtillController::handleDecryptData");
		String strEncryptedData = "";
		String decryptedData = "";
		try {
			if (request.getParameter("encryptedData") != null) {
				strEncryptedData = request.getParameter("encryptedData");
			} else {
				log.info("encryptedData in request parameter is null");
			}

			if (strEncryptedData.length() > 0) {
				decryptedData = syntBotsITOpsUtillService
						.decryptData(strEncryptedData);
			}
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("strEncryptedData",strEncryptedData);
			throw new ApplicationException("SyntBotsITOpsUtillController.handleDecryptData", e, argsMap);
		}
		return decryptedData;
	}

}
