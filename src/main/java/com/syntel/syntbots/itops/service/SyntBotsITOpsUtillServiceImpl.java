/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsEncryptionUtil;

/**
 * This class contains all the Service implementation layer methods related to
 * SyntBots ItOps Utils.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("syntBotsITOpsUtillService")
public class SyntBotsITOpsUtillServiceImpl implements SyntBotsITOpsUtillService {
	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * This particular method is for encrypting data.
	 */
	public String encryptData(String data) throws ApplicationException {
		log.info("inside SyntBotsITOpsUtillServiceImpl: encryptData() ");
		String encryptedData = null;

		try {
			encryptedData = SyntBotsITOpsEncryptionUtil.encrypt(data);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SyntBotsITOpsUtillServiceImpl.encryptData", e);
		}
		log.info("Just before leaving  SyntBotsITOpsUtillServiceImpl: encryptData() method");
		return encryptedData;
	}

	/**
	 * This method is used for decrypting the given encrypted data
	 * 
	 * @param encryptedData
	 *            - encrypted data i.e. to be decrypted
	 * @return
	 * @throws Exception
	 */
	public String decryptData(String encryptedData) throws ApplicationException {
		log.info("inside SyntBotsITOpsUtillServiceImpl: decryptData() ");
		String decryptedData = null;

		try {
			decryptedData = SyntBotsITOpsEncryptionUtil.decrypt(encryptedData);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SyntBotsITOpsUtillServiceImpl.decryptData", e);
		}
		log.info("Just before leaving  SyntBotsITOpsUtillServiceImpl: decryptData() method");
		return decryptedData;
	}

}
