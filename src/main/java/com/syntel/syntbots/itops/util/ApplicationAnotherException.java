/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
package com.syntel.syntbots.itops.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;


/**
 * This class is another Exception raised by Syntbots application.
 * 
 * @author Syntel
 * @version 1.0
 */
public class ApplicationAnotherException extends Exception{	

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
	 * ApplicationAnotherException default constructor
	 */
	public ApplicationAnotherException() {
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
	 * ApplicationAnotherException constructor with error number and message
	 *
	 * @param errorNumber Error number
	 * @param msg a <code>String<code> to provide details of the exception
	 */
	public ApplicationAnotherException(int errorNumber, String msg) {
		super(msg);
		number = errorNumber;
		setMessage(msg);
	}

	/**
	 * ApplicationAnotherException constructor with error message
	 *
	 * @param msg  a <code>String<code> to provide details of the exception
	 */

	public ApplicationAnotherException(String msg){
		super(msg);
		setMessage(msg);
	}


	/**
	 * ApplicationAnotherException constructor with <code>Throwable<code> as parameter
	 *
	 * @param excp <code>Exception</code> object
	 */

	public ApplicationAnotherException(Throwable excp){
		super(excp.toString());
		setExcp(excp);
        StringWriter sw = new StringWriter();
        excp.printStackTrace(new PrintWriter(sw));
        strStackTrace = sw.toString();
	}
	
	/**
	 * ApplicationAnotherException constructor with <code>msg, Throwable<code> as parameter
	 *
	 * @param excp <code>Throwable</code> object
	 */

	public ApplicationAnotherException(String msg, Throwable excp){
		super(msg,excp);
		setMessage(msg);
		setExcp(excp);
		StringWriter sw = new StringWriter();
        excp.printStackTrace(new PrintWriter(sw));
        strStackTrace = sw.toString();
	}

	/**
	 * ApplicationAnotherException constructor with <code>msg, Throwable, argsMap<code> as parameter
	 *
	 * @param excp <code>Throwable</code> object
	 */

	public ApplicationAnotherException(String msg, Throwable excp, Map argumentsMap){
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
