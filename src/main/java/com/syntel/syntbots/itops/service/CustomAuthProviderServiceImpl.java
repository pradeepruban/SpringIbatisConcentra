/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.LoginDAO;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationSecurityException;
import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;
import com.syntel.syntbots.itops.util.SyntBotsITOpsEncryptionUtil;

/**
 * This class contains all the service layer methods related to User Logging In.
 * 
 * @author Syntel
 * @version 1.0
 */
@Service("customAuthProviderService")
public class CustomAuthProviderServiceImpl implements AuthenticationProvider,
		CustomAuthProviderService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private LoginDAO loginDAO;

	public boolean supports(Class<?> arg0) {
		log.info("Entered inside CustomAuthProviderServiceImpl::supports()");
		return true;
	}

	/**
	 * This method is called to authenticate the user that is logging in. This
	 * method also updates last logged on details into "Attribute1" column of
	 * agt_user_details table. This method also gets the user responsibilities
	 * and the corresponding forms and set the same in session, so that the same
	 * can be accessed using
	 * SecurityContextHolder.getContext().getAuthentication()
	 * 
	 * @param Authentication
	 *            - Logging in user details.
	 * 
	 * @return Authentication - This contains the user responsibilities and the
	 *         corresponding forms user has access to.
	 * 
	 */
	public Authentication authenticate(Authentication authentication) {

		log.info("Entered inside CustomAuthProviderServiceImpl::authenticate()");
		UsernamePasswordAuthenticationToken objUsernamePasswordAuthenticationToken = null;
		try {
			UserDetails userDetails = new UserDetails();
			userDetails.setUsrCode(authentication.getName());
			userDetails.setUsrPassword(authentication.getCredentials()
					.toString());
			objUsernamePasswordAuthenticationToken = authenticateUserDetails(userDetails);
		} catch (BadCredentialsException ae) {
			log.info("Inside CustomAuthProviderServiceImpl :: authenticate() method, BadCredentialsException.."
					+ ae.getMessage());
			throw new ApplicationSecurityException(ae.getMessage());
		} catch (ApplicationException ae) {
			throw new ApplicationSecurityException(ae.getMessage(),
					ae.getExcp(), ae.getArgsMap());
		} catch (Exception e) {
			log.info("Inside CustomAuthProviderServiceImpl :: authenticate() method, Exception.."
					+ e.getMessage());
			Map argsMap = new HashMap();
			argsMap.put("UserName", authentication.getName());
			throw new ApplicationSecurityException(
					"CustomAuthProviderServiceImpl.authenticate", e, argsMap);

		}

		return objUsernamePasswordAuthenticationToken;

	}

	/**
	 * This method is called to authenticate the user that is logging in.
	 * 
	 * @param UserDetails
	 *            - Logged in user details.
	 * 
	 * @return UsernamePasswordAuthenticationToken
	 * @exception-ApplicationException
	 * 
	 */
	public UsernamePasswordAuthenticationToken authenticateUserDetails(
			UserDetails userDetails) throws ApplicationException {
		log.info("Entered inside CustomAuthProviderServiceImpl::authenticateUserDetails()");
		UsernamePasswordAuthenticationToken objUsernamePasswordAuthenticationToken = null;
		try {
			UserDetails retUserDetails = loginDAO.getUserDetails(userDetails
					.getUsrCode());
			if (retUserDetails != null) {
				UserDetails retUserDetailsAfterAuthentication = loginDAO
						.authenticateUserDetails(userDetails);
				if (retUserDetailsAfterAuthentication == null) {
					log.info("User authentication is not successful..");
					throw new BadCredentialsException("Invalid Credentials");
				}
				Map userDetailsMap = new java.util.HashMap();
				userDetailsMap.put("UserDetails",
						retUserDetailsAfterAuthentication);
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
				log.info("objUsernamePasswordAuthenticationToken instance is going to be created");
				String encPassword = SyntBotsITOpsEncryptionUtil
						.encrypt(userDetails.getUsrPassword());
				userDetailsMap.put(
						SyntBotsITOpsConstants.ENC_PASSWORD_IN_SESSION,
						encPassword);
				objUsernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetailsMap, encPassword, authorities);
				log.info("Just before leaving CustomAuthProviderServiceImpl::authenticateUserDetails()");
			} else {
				log.info("userDetails from DB is null");
				throw new BadCredentialsException("User does not exist");
			}
		} catch (BadCredentialsException bce) {
			throw bce;
		} catch (ApplicationException ae) {
			throw ae;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("UserCode", userDetails.getUsrCode());
			throw new ApplicationException(
					"CustomAuthProviderServiceImpl.authenticateUserDetails", e,
					argsMap);
		}
		return objUsernamePasswordAuthenticationToken;
	}

	/**
	 * This method is called to authenticate the user that is logging in.
	 * 
	 * @param UserDetails
	 *            - Logged in user details.
	 * 
	 * @return UserDetails
	 * 
	 * @exception-ApplicationException
	 * 
	 */
	public UserDetails authenticateUserDetailsInCustomWay(
			UserDetails userDetails) throws ApplicationException {
		log.info("Entered inside CustomAuthProviderServiceImpl::authenticateUserDetailsInCustomWay()");
		UserDetails retUserDetails = null;
		try {
			UserDetails objUserDetails = loginDAO.getUserDetails(userDetails
					.getUsrCode());

			if (objUserDetails != null) {
				log.info("Inside CustomAuthProviderServiceImpl::authenticateUserDetailsInCustomWay(), objUserDetails is not null");

				retUserDetails = loginDAO.authenticateUserDetails(userDetails);

				if (retUserDetails == null) {
					log.info("Inside CustomAuthProviderServiceImpl::authenticateUserDetailsInCustomWay(), retUserDetails is null");
				} else if (retUserDetails != null) {
					log.info("Inside CustomAuthProviderServiceImpl::authenticateUserDetailsInCustomWay(), retUserDetails is not null");
				}

				log.info("Just before leaving CustomAuthProviderServiceImpl::authenticateUserDetailsInCustomWay()");
			} else {
				log.info("objUserDetails is null");
			}

			if (retUserDetails == null) {
				log.info("Inside CustomAuthProviderServiceImpl::authenticateUserDetails(), user authentication is failed.");
			}
		} catch (ApplicationException ae) {
			throw ae;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("UserCode", userDetails.getUsrCode());
			throw new ApplicationException(
					"CustomAuthProviderServiceImpl.authenticateUserDetailsInCustomWay", e,
					argsMap);
		}
		return retUserDetails;
	}

	/**
	 * This method is called to get attribute values
	 * 
	 * @param Attributes
	 *            ,attribute name
	 * @return UserDetails
	 * 
	 * @exception-ApplicationException
	 * 
	 */

	private String getAttributeValue(Attributes attrs, String attributeName)
			throws ApplicationException {
		String attributeValue = "";
		try {
			Attribute attribute = attrs.get(attributeName);
			if ((attribute != null) && (attribute.get() != null)) {
				attributeValue = attribute.get().toString();
			}
		} catch (Exception e) {
			throw new ApplicationException("CustomAuthProviderServiceImpl.getAttributeValue", e);
		}
		return attributeValue;
	}

}
