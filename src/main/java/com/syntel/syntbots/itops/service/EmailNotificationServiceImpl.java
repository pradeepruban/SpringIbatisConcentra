/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class handles all the E-mail Notifications of application
 * 
 * @author Syntel
 * @version 1.0
 */
@Service("emailNotificationService")
public class EmailNotificationServiceImpl implements NotificationService {

	private String[] excpToAdresses;
	private Logger log = Logger.getLogger(this.getClass());

	public void setExcpToAdresses(String[] tempExcpToAdresses) {
		this.excpToAdresses = tempExcpToAdresses;
	}

	public String[] getExcpToAdresses() {
		return this.excpToAdresses;
	}

	/**
	 * This method sends the E-mail whenever an exception gets raised in any
	 * Spring Controller Here the message body is framed and the same is sent
	 * through mail
	 * 
	 * @param message
	 *            - E-mail Message
	 * @param displayErrorMessageValue
	 *            - Error Message displayed to User
	 * @param errorMessageValue
	 *            - Error Message useful to developer
	 * @param strStackTrace
	 *            - Entire Stack Trace.
	 * @param displayStackTrace
	 *            - Stack Trace displayed to User
	 * @param arguments
	 *            - Argument details that raised the Exception.
	 * @param otherExcpInfo
	 *            - other Exception info. like user details etc.
	 * @exception-ApplicationException
	 */
	public void sendNotification(String message,
			String displayErrorMessageValue, String errorMessageValue,
			String strStackTrace, String displayStackTrace, String arguments,
			String otherExcpInfo) throws ApplicationException {
		log.info("Entered inside EmailNotificationServiceImpl::sendNotification() method");
		String msgBody = "";
		try {
			String[] defaultToAdresses = { "sureshbabu_konduru@syntelinc.com" };
			if ((excpToAdresses == null) || (excpToAdresses.length == 0)) {
				excpToAdresses = defaultToAdresses;
			}
			msgBody = "<B>Message:</B>" + message
					+ "<BR> <BR> <B>Display Error Message Value:</B>"
					+ displayErrorMessageValue
					+ "<BR> <BR> <B>Error Message Value:</B>"
					+ errorMessageValue
					+ "<BR> <BR> <B>Display Stack Trace:</B>"
					+ displayStackTrace + "<BR> <BR> <B>Stack Trace:</B>"
					+ strStackTrace + "<BR> <BR> <B>Arguments:</B>  "
					+ arguments;

			if (StringUtils.hasText(otherExcpInfo)) {
				msgBody = otherExcpInfo + "<BR> <BR>" + msgBody;
			}

			log.info("Inside EmailNotificationServiceImpl::sendNotification(), msgBody is:"
					+ msgBody + ":");

			/*
			 * SimpleMailMessage msg = new
			 * SimpleMailMessage(this.templateMessage);
			 * msg.setTo(excpToAdresses); msg.setText("Message:" + message
			 * +"\n\n Display Error Message Value:"+displayErrorMessageValue +
			 * "\n\n Error Message Value:"+errorMessageValue +
			 * "\n\n Display Stack Trace:"+displayStackTrace
			 * +"\n\n Stack Trace: "+ strStackTrace +"\n\n Arguments:\n\n "+
			 * arguments); this.mailSender.send(msg);
			 */
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("msgBody", msgBody);
			throw new ApplicationException(
					"EmailNotificationServiceImpl.sendNotification", e, argsMap);
		}

		log.info("Just before leaving EmailNotificationServiceImpl::sendNotification() method");
	}

	/**
	 * This method is called to send Notification email.
	 * 
	 * @param messageSubj
	 *            - This gives the email message subject that needs to be sent
	 *
	 * @param message
	 *            - This gives the email message that needs to be sent
	 *
	 * @param toAddress
	 *            - This gives the email(comma separated)
	 *
	 * @exception-ApplicationException
	 */
	public void sendNotification(String messageSubj, String message,
			String toAddress) throws ApplicationException {
		log.info("Entered inside EmailNotificationServiceImpl::sendNotification() method with messageSubj:"
				+ messageSubj
				+ ":message:"
				+ message
				+ "::toAddress"
				+ toAddress + ":");

		try {
			String[] notifyToAdresses;
			String[] defaultToAdresses = { "sureshbabu_konduru@syntelinc.com" };
			if ((toAddress == null) || (toAddress.length() == 0)) {
				notifyToAdresses = defaultToAdresses;
			} else {
				notifyToAdresses = org.springframework.util.StringUtils
						.commaDelimitedListToStringArray(toAddress);

			}
			log.info("notifyToAdresses" + notifyToAdresses);
			String msgBody = message;

			log.info("Inside EmailNotificationServiceImpl::sendNotification(), msgBody is:"
					+ msgBody + ":");

		} catch (Exception e) {
			throw new ApplicationException(
					"EmailNotificationServiceImpl.sendNotification", e);
		}

		log.info("Just before leaving EmailNotificationServiceImpl::sendNotification() method");
	}

}
