/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.mapper.LoginMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Dao impl methods for Login.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private LoginMapper loginMapper;

	/**
	 * This method is called to get the authenticated UserDetails
	 *
	 * @param UserDetails
	 * @returnThis UserDetails values related user
	 */

	public UserDetails authenticateUserDetails(UserDetails userDetails)
			throws ApplicationException {
	
		log.info("Inside LoginDAOImpl::authenticateUser, after  loginMapper.authenticateUser method");
		UserDetails retUserDetails = null;
		try{
		 retUserDetails = loginMapper
				.authenticateUserDetails(userDetails);
		}catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails",userDetails);
			throw new ApplicationException("LoginDAOImpl.authenticateUser", e, argsMap);
		}
		log.info("Just before leaving  LoginDAOImpl::authenticateUser ");
		return retUserDetails;
	}

	/**
	 * This method is called to get the UserDetails by userCode
	 *
	 * @param userCode
	 * @returnThis UserDetails values related UserDetails
	 */
	public UserDetails getUserDetails(String userCode)
			throws ApplicationException {
		log.info("Inside LoginDAOImpl::getUserDetails with userCode:"
				+ userCode + ":");
		UserDetails userDetails = null;
		try{
			userDetails = loginMapper.getUserDetails(userCode);
		}catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails",userDetails);
			throw new ApplicationException("LoginDAOImpl.getUserDetails", e, argsMap);
		}
		log.info("Just before leaving  LoginDAOImpl::getUserDetails ");
		return userDetails;
	}

}
