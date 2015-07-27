/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
package com.syntel.syntbots.itops.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

/**
 * This class is generic Exception raised by all the methods of EasyGo application
 * 
 * @author Syntel
 * @version 1.0
 */
public class ApplicationException extends Exception{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5569195015436941032L;
	private int number;
	private String message;
	private String strStackTrace;
	private Map argsMap;
	private Throwable excp;
	
	/**
	 * ApplicationException default constructor
	 */
	public ApplicationException() {
		super();
	}



  /**
  	 * This method gets the Message.
  	 *
  	 * @return java.lang.String
  	 */
  	public String getMessage() {
  		return message;
  	}  

  	/**
  	 * This method sets the Contact Id.
  	 *
  	 * @param newMessage java.lang.String
  	 */
  	public void setMessage(String newMessage) {
  		message= newMessage;
  	}  


 
	/**
	 * @return the excp
	 */
	public Throwable getExcp() {
		return excp;
	}



	/**
	 * @param excp the excp to set
	 */
	public void setExcp(Throwable excp) {
		this.excp = excp;
	}



	/**
	 * ApplicationException constructor with error number and message
	 *
	 * @param errorNumber Error number
	 * @param msg a <code>String<code> to provide details of the exception
	 */
	public ApplicationException(int errorNumber, String msg) {
		super(msg);
		number = errorNumber;
		setMessage(msg);
	}

	/**
	 * ApplicationException constructor with error message
	 *
	 * @param msg  a <code>String<code> to provide details of the exception
	 * Modified by Stanley on July 29th
	 */

	public ApplicationException(String msg){
		super(msg);
		setMessage(msg);
	}


	/**
	 * ApplicationException constructor with <code>Throwable<code> as parameter
	 *
	 * @param excp <code>Exception</code> object
	 */

	public ApplicationException(Throwable excp){
		super(excp.toString());
		setExcp(excp);
        StringWriter sw = new StringWriter();
        excp.printStackTrace(new PrintWriter(sw));
        strStackTrace = sw.toString();
	}
	
	/**
	 * ApplicationException constructor with <code>msg, Throwable<code> as parameter
	 *
	 * @param excp <code>Throwable</code> object
	 */

	public ApplicationException(String msg, Throwable excp){
		super(msg,excp);
		setMessage(msg);
		setExcp(excp);
		StringWriter sw = new StringWriter();
        excp.printStackTrace(new PrintWriter(sw));
        strStackTrace = sw.toString();
	}
	
	/**
	 * ApplicationException constructor with <code>msg, Throwable, argsMap<code> as parameter
	 *
	 * @param excp <code>Throwable</code> object
	 */

	public ApplicationException(String msg,  Map argumentsMap){
		super(msg);
		setMessage(msg);		
        argsMap = argumentsMap;
	}

	/**
	 * ApplicationException constructor with <code>msg, Throwable, argsMap<code> as parameter
	 *
	 * @param excp <code>Throwable</code> object
	 */

	public ApplicationException(String msg, Throwable excp, Map argumentsMap){
		super(msg,excp);
		setMessage(msg);
		setExcp(excp);
		StringWriter sw = new StringWriter();
        excp.printStackTrace(new PrintWriter(sw));
        strStackTrace = sw.toString();
        argsMap = argumentsMap;
	}

	/**
	 * Retuns the Error Number of the exception
	 *
	 * @return <code>int</code> error number
	 */

	public int getNum() {
		return number;
	}

	/**
	 * Returns the Stack Trace of the exception
	 *
	 * @return <code>String</code> Stack Trace
	 */

	public String getStrStackTrace() {
		return strStackTrace;
	}  
    
	
	/**
	 * Returns the Stack Trace of the exception
	 *
	 * @return <code>String</code> Stack Trace
	 */

	public Map getArgsMap() {
		return argsMap;
	}  
	
}
