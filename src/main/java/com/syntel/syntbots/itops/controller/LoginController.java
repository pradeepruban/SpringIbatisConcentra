/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.service.CustomAuthProviderService;
import com.syntel.syntbots.itops.util.ApplicationAnotherException;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.ApplicationUtils;
import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;

/**
*This class contains all the controller methods for Login.
*@author Syntel
*@version 1.0
*/

@Controller
public class LoginController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private CustomAuthProviderService customAuthProviderService;
	
	/**
	*This method directs to login page.This is an ajax call.
	*@return  ModelAndView- login
	*/
	@RequestMapping("/login")
	public ModelAndView login() {
		log.info("Inside LoginController::login");
		return new ModelAndView("login");
	}
	
	/**
	*This method directs to loginWrapper page.This is an ajax call.
	*@return  ModelAndView- loginWrapper
	*/
	@RequestMapping("/loginWrapper")
	public ModelAndView loginWrapper() {
		log.info("Inside LoginController::loginWrapper");
		return new ModelAndView("loginWrapper");
	}

	

	/**
	 * THIS IS NOT CURRENTLY USED AS APPLICATION IS INTEGRATED WITH SPRING SECURITY.
	 * 
	 * This method is called to validate login details entered by User. The
	 * user entered details are fetched from Request and the same is verified against the Stored ones
	 * and the response is sent accordingly.
	 * 
	 * @param request
	 *            This gives the details entered by user.
	 * @return ModelAndView - mav object
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/loginUser")	
	public ModelAndView handleLoginUserRequest(HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		ModelAndView mav;
		Map messagesMap = new HashMap();
		String modelView="";
		String userCode = "";
		String userPassword = "";
		try {
			HttpSession session = request.getSession(true);
			if(session.getAttribute("loginErrorMsg") != null)
			{
				session.removeAttribute("loginErrorMsg"); 
			}
			
			log.info("Entered inside LoginController::handleLoginUserRequest()");
			request.setCharacterEncoding(SyntBotsITOpsConstants.UTF8_CHARACTER_ENCODING);
			if(request.getParameter("usrCode") != null)
			{
				userCode = request.getParameter("usrCode");
			}
			
			if(request.getParameter("usrPassword") != null)
			{
				userPassword = request.getParameter("usrPassword");
			}			
			
			UserDetails userDetails = new UserDetails();
			userDetails.setUsrCode(userCode);
			userDetails.setUsrPassword(userPassword);
			
			log.info("userDetails is:"+userDetails+":");
			
			UserDetails objUserDetails = customAuthProviderService.authenticateUserDetailsInCustomWay(userDetails);
			
			if(objUserDetails != null)
			{
				modelView = "itopsMain";
				mav = new ModelAndView("redirect:"+modelView,"messages", messagesMap);
				session.setAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION, objUserDetails.getUsrId());
				session.setAttribute(SyntBotsITOpsConstants.USER_CODE_IN_SESSION,userDetails.getUsrCode());
				session.setAttribute(SyntBotsITOpsConstants.USER_NAME_IN_SESSION, objUserDetails.getUsrShortName());				
			}
			else
			{
				modelView = "login";
				messagesMap.put("message","Incorrect Login Details");
				session.setAttribute("loginErrorMsg", "Invalid Credentials");
				mav = new ModelAndView("redirect:"+modelView, "messages", messagesMap);				
				//log.info("mav is set for login.jsp");
			}
			
			log.info("modelView is:"+modelView+":messages is:"+messagesMap);
			log.info("Just before leaving LoginController::handleLoginUserRequest()");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"LoginController.handleLoginUserRequest", e);
		}
		return mav;		
	}
	
	/**
	 * This method is called to fetch details related to logged in User. The
	 * user details related to the logged in user are fetched from database and the same are stored in session for future reference.
	 * 
	 * @param request
	 *            This gives the details entered by user.
	 * @return response - response object
	 * @exception - ApplicationException in case of error
	 */
	@RequestMapping(value = "/userEntry")	
	public ModelAndView handleUserEntryRequest(HttpServletRequest request,
			HttpServletResponse response) throws ApplicationException {
		
		ModelAndView mav;
		Map messagesMap = new HashMap();
		String modelView=SyntBotsITOpsConstants.SYNTBOTSITOPS_HOME_PAGE;
		String userCode = "";
		UserDetails userDetails = null;
		Map userDetailsMap = null;		
		try {
			/*HttpSession session = request.getSession(true);
			log.info("Entered inside LoginController::handleUserEntryRequest()");
			if(SecurityContextHolder.getContext() != null)
			{
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
				if(auth != null)
				{					
					userDetailsMap = (Map) auth.getPrincipal();				
					userDetails = (UserDetails) userDetailsMap.get("UserDetails");
					userCode = userDetails.getUsrCode();
					session.setAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION, userDetails.getUsrId());
					session.setAttribute(SyntBotsITOpsConstants.USER_CODE_IN_SESSION,userDetails.getUsrCode());
					session.setAttribute(SyntBotsITOpsConstants.USER_NAME_IN_SESSION, userDetails.getUsrShortName());
					log.info(userDetails.getUsrId()+" is added into session with attribute name as "+ SyntBotsITOpsConstants.USER_ID_IN_SESSION);					
				}
				else
				{
					log.info("LoginController.handleUserEntryRequest:: auth Authentication is null");
					throw new ApplicationException("SecurityContextHolder.Context.Authentication is null");
				}
			}
			else
			{				
				log.info("LoginController.handleUserEntryRequest:: SecurityContextHolder.getContext() is null");
				throw new ApplicationException("SecurityContextHolder.getContext() is null");
			}*/
			
			ApplicationUtils.setUserDetailsIntoSession(request);
			
			mav = new ModelAndView("redirect:"+modelView, "messages", messagesMap);
			
			log.info("modelView is:"+modelView+":messages is:"+messagesMap);
			log.info("Just before leaving LoginController::handleUserEntryRequest()");
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userCode", userCode);
			throw new ApplicationException(
					"LoginController.handleUserEntryRequest", e, argsMap);
		}
		return mav;		
	}
	
	
}

