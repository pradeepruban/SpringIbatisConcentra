/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Notification
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface NotificationService {

	public void sendNotification(String message,
			String displayErrorMessageValue, String errorMessageValue,
			String strStackTrace, String displayStackTrace, String arguments,
			String otherExcpInfo) throws ApplicationException;

	public void sendNotification(String messageSubj, String message,
			String toAddress) throws ApplicationException;

}
