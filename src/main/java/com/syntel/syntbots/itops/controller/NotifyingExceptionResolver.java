/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/	

package com.syntel.syntbots.itops.controller;


import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.syntel.syntbots.itops.service.NotificationService;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;
import com.syntel.syntbots.itops.util.SyntBotsITOpsExceptionUtil;

/**
 * This class handles all the Exceptions of ItOps application that is raised in Spring
 * 
 * @author Syntel 
 * @version 1.0
 */

public class NotifyingExceptionResolver extends  SimpleMappingExceptionResolver {
	
	private Properties priorityExpMappings;
    private Map<String,NotificationService> priorityNSMappings;
    String notificationMessage = null;
    private Logger log = Logger.getLogger(this.getClass());
   
       
    public void setPriorityExceptionMappings(Properties  priorityExpMappings){
        this.priorityExpMappings = priorityExpMappings;
    }
    
    public void setPriorityNotificationServicesMappings (Map<String,NotificationService> priorityNSMappings){
        this.priorityNSMappings = priorityNSMappings;
    }
    
    public void setNotificationMessage(String message){
        this.notificationMessage = message;
    }
    
  
    
    /**
	 * This method gets executed whenever an exception gets raised in any Spring Controller
	 * Here depending on the application key, we get the message to be shown to developer and user from the corresponding properties files. 
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @param handler - Object
	 * @param ex - The actual Exception that is thrown. 
	 * @return ModelAndView - This is the ModelAndView to which the request needs to be forwarded.
	 */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) {
       
       
       log.warn("Entered inside NotifyingExceptionResolver::doResolveException()");
        
       String message = "";
       String strStackTrace = "";
       String errorMessageValue ="";
       String displayErrorMessageValue ="";
       String displayStackTrace="";
       String arguments="";
       String otherExcpInfo ="";
       Map exceptionDetailsMap = null;
       
       SyntBotsITOpsExceptionUtil syntBotsDevOpsExceptionUtil = new  SyntBotsITOpsExceptionUtil();
       try{
       exceptionDetailsMap = syntBotsDevOpsExceptionUtil.getExceptionDetails(ex);
       
       message = (String) exceptionDetailsMap.get("Message");
       displayErrorMessageValue = (String) exceptionDetailsMap.get("DisplayErrorMessageValue");
       errorMessageValue = (String) exceptionDetailsMap.get("ErrorMessageValue");
       strStackTrace = (String) exceptionDetailsMap.get("StackTrace");
       displayStackTrace = (String) exceptionDetailsMap.get("DisplayStackTrace");
       arguments = (String) exceptionDetailsMap.get("Arguments");
       otherExcpInfo = (String) exceptionDetailsMap.get("OtherExceptionInfo");
       boolean blnNotificationToBeSent = true;
       
       String[] strNotificationsAvoided=SyntBotsITOpsConstants.EXCEPTION_NOTIFICATIONS_AVOIDED;
       
       for (int i = 0; i < strNotificationsAvoided.length; i++) {
           if(strNotificationsAvoided[i].equalsIgnoreCase(message))
           {           	
           		blnNotificationToBeSent= false;
           }				
       }
       
       if(blnNotificationToBeSent)
       {
    	   sendNotification(ex, message, displayErrorMessageValue, errorMessageValue, strStackTrace, displayStackTrace, arguments, otherExcpInfo);
       }
       log.warn("Just before leaving NotifyingExceptionResolver::doResolveException()");
       
       request.setAttribute(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_MESSAGE, displayErrorMessageValue);
       request.setAttribute(SyntBotsITOpsConstants.EXCEPTION_DISPLAY_TRACE, displayStackTrace);
       
       } catch(ApplicationException e){
			try {
				throw new ApplicationException("NotifyingExceptionResolver.doResolveException", e);
			} catch (Exception e1) {
				//e1.printStackTrace();
				log.error(e1);
			} 
		}catch(Exception e){
			log.error(e);
		}
       return super.doResolveException(request, response, handler, ex);
       
    }
    
    
    /**
   	 * This method sends the Notification basing on the priority
   	 */
    private void sendNotification(Exception ex, String message, String displayErrorMessageValue, String errorMessageValue, String strStackTrace, String displayStackTrace, String arguments, String otherExcpInfo) throws ApplicationException {
        String priority = resolvePriority(this.priorityExpMappings, ex);
        NotificationService notificationService = resolveNotificationService (this.priorityNSMappings, priority);
        /*String message = (notificationMessage == null ? priority :  notificationMessage);*/
        if(notificationService != null) {
        	/*log.debug("notification message was sent");*/
        	 try{
        	notificationService.sendNotification(message, displayErrorMessageValue, errorMessageValue, strStackTrace, displayStackTrace, arguments, otherExcpInfo);
        	 } catch (ApplicationException e) {
				throw e;
			} catch (Exception e) {
				throw new ApplicationException("NotifyingExceptionResolver.sendNotification", e);
			}
        }  	
    }
    
    /**
   	 * This method resolves the priority basing on the Exception
   	 */
    private String resolvePriority(Properties priorityExpMappings,  Exception ex){
        return this.findMatchingViewName(priorityExpMappings, ex);
    }
    
    
    /**
   	 * This method resolves the notification service basing on the the priority
   	 */
    private NotificationService resolveNotificationService (Map<String,NotificationService> priorityNSMappings, String priority){
        NotificationService notificationService = null;
       
        notificationService = priorityNSMappings.get(priority);
       
        /*if (notificationService != null && logger.isDebugEnabled()) {
            logger.debug("Resolving to a notification service for priority ["  + priority + "]");
        }*/
       
        return notificationService;
    }
 
}

