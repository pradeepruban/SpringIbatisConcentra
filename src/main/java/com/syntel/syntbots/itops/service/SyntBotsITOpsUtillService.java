/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to SyntBots
 * ItOps Util Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface SyntBotsITOpsUtillService {

	public String encryptData(String data) throws ApplicationException;

	public String decryptData(String encryptedData) throws ApplicationException;

}
