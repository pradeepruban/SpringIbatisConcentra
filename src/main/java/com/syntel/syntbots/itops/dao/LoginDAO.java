/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Login.
 *
 * @author Syntel
 * @version 1.0
 */
public interface LoginDAO {

	public UserDetails authenticateUserDetails(UserDetails userDetails)
			throws ApplicationException;

	public UserDetails getUserDetails(String userCode)
			throws ApplicationException;
}
