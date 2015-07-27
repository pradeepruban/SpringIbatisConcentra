/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import javax.jws.WebService;

import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to User
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
@WebService
public interface UserDetailsService {

	List<UserDetails> getCompleteUserDetailsList() throws ApplicationException;

}
