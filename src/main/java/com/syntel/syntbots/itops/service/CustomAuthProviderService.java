/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Custom Auth
 * Provider Details.
 *
 * @author Syntel
 * @version 1.0
 */

public interface CustomAuthProviderService {

	public UsernamePasswordAuthenticationToken authenticateUserDetails(
			UserDetails userDetails) throws ApplicationException;

	public UserDetails authenticateUserDetailsInCustomWay(
			UserDetails userDetails) throws ApplicationException;

}