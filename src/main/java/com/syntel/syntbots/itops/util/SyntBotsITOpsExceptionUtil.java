/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
package com.syntel.syntbots.itops.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;

import com.syntel.syntbots.itops.util.ApplicationAnotherException;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This is utility class used for handling Exceptions.
 * 
 * @author Syntel
 * @version 1.0
 */

public class SyntBotsITOpsExceptionUtil {

	
    Logger log = Logger.getLogger(this.getClass());      
  
    /**
	 * This method is utility method used for handling Exceptions.
	 * Here depending on the application key, we get the message to be shown to developer and user from the corresponding properties files.
	 * @param ex - The actual Exception that is thrown. 
	 * @return Map - This contains all the necessary things required to inform to user.
	 */   
       
    public Map getExceptionDetails(Exception ex) 
    {
       Properties displayErrorProp = new Properties();
       InputStream inputStream = null;
       log.warn("Entered inside SyntBotsITOpsExceptionUtil::handleException()");
        
       String message = "";
       String strStackTrace = "";       
       String displayErrorMessageValue ="";
       Map argsMap = null;
       Set keySet = null;
       Iterator keyIterator = null;
       String argsKey = null;
	   Object argsObj = null;
       String displayStackTrace="";
       String arguments="";
       String otherExcpInfo ="";
       
       if(ex instanceof ApplicationException)
       {
    	   log.info("inside ex instanceof ApplicationException ");
    	   ApplicationException ae = (ApplicationException)ex;
	       message = ae.getMessage();
	       strStackTrace = ae.getStrStackTrace();
	       argsMap = ae.getArgsMap();
       }
       else if(ex instanceof ApplicationAnotherException)
       {
    	   log.info("inside ex instanceof ApplicationAnotherException ");
    	   ApplicationAnotherException aae = (ApplicationAnotherException)ex;
    	   message = aae.getMessage();
	       strStackTrace = aae.getStrStackTrace();
	       argsMap = aae.getArgsMap();
       }
       else
       {
    	   log.info("inside else of Exception ");
    	   ApplicationException e = new ApplicationException(ex);
    	   message = e.getMessage();
	       strStackTrace = e.getStrStackTrace();
       }
    
       String[] excTraces=StringUtils.delimitedListToStringArray(strStackTrace, "Caused by:");
      
      
       if((excTraces != null) && (excTraces.length > 0))
       {
    	   displayStackTrace = excTraces[excTraces.length-1]; 
       }
       else
       {
    	   displayStackTrace = strStackTrace;
       }
       
       
       if(displayStackTrace != null && displayStackTrace.length() > 2500)
       {
    	   displayStackTrace = displayStackTrace.substring(0, 2500);
       }
              
       
       String[] dispErrMsgPropFiles = {"controllerDisplayErrorMessages", "daoDisplayErrorMessages", "serviceDisplayErrorMessages", "miscDisplayErrorMessages"};
       
       try
       {
    	   ClassLoader loader = Thread.currentThread().getContextClassLoader();
    	   for(String dispErrMsgPropFile : dispErrMsgPropFiles)
	       {
	    	   log.info("dispErrMsgPropFile is:"+dispErrMsgPropFile+":");
	    	   
	    	   inputStream = loader.getResourceAsStream(dispErrMsgPropFile+".properties");	    	   
	    	   log.info("inputStream5 is:"+inputStream+":");
	    	   displayErrorProp.load(inputStream);
	    	   log.info("After displayErrorProp.load ..");
	       }
	       
       } 
       catch (Exception e) {             
		   e.printStackTrace();         
	   }
       
       if(message != null)
       {	       
	       if(displayErrorProp.getProperty(message) != null)
	       {
	    	   displayErrorMessageValue = displayErrorProp.getProperty(message);
	       }
       }
      
       log.error("message is:"+message+":");
       log.error("displayErrorMessageValue is:"+displayErrorMessageValue+":");       
       log.error("StackTrace is:"+strStackTrace+":");
       log.error("displayStackTrace is:"+displayStackTrace+":");
       if(argsMap != null)
       {
    	   keySet = argsMap.keySet();
    	   if(keySet != null)
    	   {
    		   keyIterator =keySet.iterator();
    		   if(keyIterator != null)
    		   {
    			   int argsCount=0;
            	   while(keyIterator.hasNext())
            	   {
            		   argsKey = (String) keyIterator.next();
            		   argsObj = argsMap.get(argsKey);
            		   log.error("Argument "+argsCount+", "+ argsKey +" value is:"+argsObj.toString()+":");
            		   arguments = arguments + "Argument "+argsCount+", "+ argsKey +" value is:"+argsObj.toString()+":\n";
            		   argsCount++;
            	   }
    		   }
        	   
    	   }
    	 
       }
       
     
       
       Map returnMap = new java.util.HashMap();
       returnMap.put("Message", message);
       returnMap.put("DisplayErrorMessageValue", displayErrorMessageValue);       
       returnMap.put("StackTrace", strStackTrace);
       returnMap.put("DisplayStackTrace", displayStackTrace);
       returnMap.put("Arguments", arguments);
       returnMap.put("OtherExceptionInfo", otherExcpInfo);       
    	   
       log.warn("Just before leaving SyntBotsITOpsExceptionUtil::getExceptionDetails()");       
       
       return returnMap;       
    } 
}

