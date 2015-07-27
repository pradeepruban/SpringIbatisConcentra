/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.UserDetailsDAO;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * user application queue link.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("userDetailsService4")
public class UserDetailsServiceImpl implements UserDetailsService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private UserDetailsDAO userDetailsDao;

	/**
	 * This method is called to get complete list of user.
	 *
	 * @return list of User Details
	 * @exception - ApplicationException in case of error
	 */
	public List<UserDetails> getCompleteUserDetailsList()
			throws ApplicationException {
		log.info("inside UserDetailsServiceImpl: getCompleteUserDetailsList() ");
		List<UserDetails> usrDetailsList = null;
		
		try {
			usrDetailsList = userDetailsDao.getCompleteUserDetailsList();
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"UserDetailsServiceImpl.getCompleteUserDetailsList", e);
		}
		log.info("Just before leaving  UserDetailsServiceImpl: getCompleteUserDetailsList() method");
		return usrDetailsList;
	}

}
