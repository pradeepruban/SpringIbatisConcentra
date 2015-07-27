/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/	
package com.syntel.syntbots.itops.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.mapper.UserDetailsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
*This class contains all the DAO layer methods related to UserApplicationQueueLink.
*@author Syntel
*@version 1.0
*/
@Repository("userDetailsDao")
public class UserDetailsDAOImpl implements UserDetailsDAO {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private UserDetailsMapper userDetailsMapper;
	
	/**
	*This method is called get userdetails list
	*@param  
	*@returnThis list of user details   
	*@exception -  ApplicationException in case of error
	*/
	public List<UserDetails> getCompleteUserDetailsList()
			throws ApplicationException {
		
		log.info("Entered inside UserDetailsDAOImpl:getCompleteUserDetailsList():");
		List<UserDetails> usrDetailsList = null;
		try{
			usrDetailsList = userDetailsMapper.getCompleteUserDetailsList();
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("UserDetailsList",usrDetailsList);
			throw new ApplicationException("UserDetailsDAOImpl.getCompleteUserDetailsList", e, argsMap);
		}
		log.info("Just before leaving UserDetailsDAOImpl:getCompleteUserDetailsList()");
		return usrDetailsList;
	}
	
	

}
