/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;

/**
 * This is a container class for IT Ops application.
 * 
 * @author Syntel
 * @version 1.0
 */

@Controller
public class SyntBotsITOpsController {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * This method directs to ItOps Main .This is an ajax call.
	 *
	 * @return ModelAndView - itopsMain
	 */
	@RequestMapping("/itopsMain")
	public ModelAndView itopsMain(HttpServletRequest request) {
		log.info("Entered inside SyntBotsITOpsController::itopsMain()");
		String strModelView = "login";
		HttpSession session = request.getSession();
		if (session.getAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION) != null) {
			strModelView = "itopsMain";
		}
		return new ModelAndView(strModelView);
	}

	/**
	 * This method directs to Logout page .This is an ajax call.
	 *
	 * @return ModelAndView - login
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		log.info("Entered inside SyntBotsITOpsController::logout()");
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return new ModelAndView("login");
	}

	/**
	 * This method directs to incidentDetailsList page .This is an ajax call.
	 *
	 * @return ModelAndView - incidentDetailsList
	 */
	@RequestMapping("/incidentDetailsList")
	public ModelAndView incidentDetailsList() {
		log.info("Entered inside SyntBotsITOpsController::incidentDetailsList()");
		return new ModelAndView("incidentDetailsList");
	}

	/**
	 * This method directs to incidentDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - incidentDetails
	 */
	@RequestMapping("/incidentDetails")
	public ModelAndView incidentDetails() {
		log.info("Entered inside SyntBotsITOpsController::incidentDetails()");
		return new ModelAndView("incidentDetails");
	}

	/**
	 * This method directs to closedIncidentDetailsList page .This is an ajax
	 * call.
	 *
	 * @return ModelAndView - closedIncidentDetailsList
	 */
	@RequestMapping("/closedIncidentDetailsList")
	public ModelAndView closedIncidentDetailsList() {
		log.info("Entered inside SyntBotsITOpsController::closedIncidentDetailsList()");
		return new ModelAndView("closedIncidentDetailsList");
	}

	/**
	 * This method directs to sopExecution page .This is an ajax call.
	 *
	 * @return ModelAndView - sopExecution
	 */
	@RequestMapping("/sopExecution")
	public ModelAndView sopExecution() {
		log.info("Entered inside SyntBotsITOpsController::sopExecution()");
		return new ModelAndView("sopExecution");
	}

	/**
	 * This method directs to workflowDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - workflowDetails
	 */
	@RequestMapping("/workflowDetails")
	public ModelAndView workflowDetails() {
		log.info("Entered Inside SyntBotsITOpsController:workflowDetails()");
		return new ModelAndView("workflowDetails");
	}

	/**
	 * This method directs to defaultError page .This is an ajax call.
	 *
	 * @return ModelAndView - defaultError
	 */
	@RequestMapping("/defaultError")
	public ModelAndView defaultError() {
		log.info("Entered Inside SyntBotsITOpsController:defaultError()");
		return new ModelAndView("defaultError");
	}

	/**
	 * This method directs to error page .This is an ajax call.
	 *
	 * @return ModelAndView - error
	 */
	@RequestMapping("/error")
	@ResponseBody
	public ModelAndView error() {
		log.info("Entered Inside SyntBotsITOpsController:error()");
		return new ModelAndView("error");
	}

	/**
	 * This method directs to anotherError page .This is an ajax call.
	 *
	 * @return ModelAndView - anotherError
	 */
	@RequestMapping("/anotherError")
	public ModelAndView anotherError() {
		log.info("Entered Inside SyntBotsITOpsController:anotherError()");
		return new ModelAndView("anotherError");
	}

	/**
	 * This method directs to queueDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - queueDetails
	 */
	@RequestMapping("/queueDetails")
	public ModelAndView queueDetails() {
		log.info("Entered Inside SyntBotsITOpsController:queueDetails()");
		return new ModelAndView("queueDetails");
	}

	/**
	 * This method directs to sopDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - sopDetails
	 */
	@RequestMapping("/sopDetails")
	public ModelAndView sopDetails() {
		log.info("Entered Inside SyntBotsITOpsController:sopDetails()");
		return new ModelAndView("sopDetails");
	}

	/**
	 * This method directs to applicationDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - applicationDetails
	 */
	@RequestMapping("/applicationDetails")
	public ModelAndView applicationDetails() {
		log.info("Entered Inside SyntBotsITOpsController:applicationDetails()");
		return new ModelAndView("applicationDetails");
	}

	/**
	 * This method directs to duplicateLoginError page .This is an ajax call.
	 *
	 * @return ModelAndView - duplicateLoginError
	 */
	@RequestMapping("/duplicateLoginError")
	public ModelAndView duplicateLoginError() {
		log.info("Entered Inside SyntBotsITOpsController:duplicateLoginError");
		return new ModelAndView("duplicateLoginError");
	}

	/**
	 * This method directs to dashboard page .This is an ajax call.
	 *
	 * @return ModelAndView - dashboard
	 */
	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		log.info("Entered Inside SyntBotsITOpsController:dashboard()");
		return new ModelAndView("dashboard");
	}

	/**
	 * This method directs to sopMsgLink page .This is an ajax call.
	 *
	 * @return ModelAndView - sopMsgLink
	 */
	@RequestMapping("/sopMsgLink")
	public ModelAndView sopMsgLink() {
		log.info("Entered Inside SyntBotsITOpsController:sopMsgLink()");
		return new ModelAndView("sopMsgLink");
	}

	/**
	 * This method directs to sopWorkflowLink page .This is an ajax call.
	 *
	 * @return ModelAndView - sopWorkflowLink
	 */
	@RequestMapping("/sopWorkflowLink")
	public ModelAndView sopWorkflowLink() {
		log.info("Entered Inside SyntBotsITOpsController:sopWorkflowLink()");
		return new ModelAndView("sopWorkflowLink");
	}

	/**
	 * This method directs to appQueSopLink page .This is an ajax call.
	 *
	 * @return ModelAndView - appQueSopLink
	 */
	@RequestMapping("/appQueSopLink")
	public ModelAndView appQueSopLink() {
		log.info("Entered Inside SyntBotsITOpsController:appQueSopLink()");
		return new ModelAndView("appQueSopLink");
	}

	/**
	 * This method directs to usrApplnQueueLink page .This is an ajax call.
	 *
	 * @return ModelAndView - usrApplnQueueLink
	 */
	@RequestMapping("/usrApplnQueueLink")
	public ModelAndView usrApplnQueueLink() {
		log.info("Entered Inside SyntBotsITOpsController:usrApplnQueueLink()");
		return new ModelAndView("usrApplnQueueLink");
	}

	/**
	 * This method directs to usrApplnQueSopExclsn page .This is an ajax call.
	 *
	 * @return ModelAndView - usrApplnQueSopExclsn
	 */
	@RequestMapping("/usrApplnQueSopExclsn")
	public ModelAndView usrApplnQueSopExclsn() {
		log.info("Entered Inside SyntBotsITOpsController:usrApplnQueSopExclsn()");
		return new ModelAndView("usrApplnQueSopExclsn");
	}

	/**
	 * This method directs to listIncidentDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - listIncidentDetails
	 */
	@RequestMapping("/closedIncidentDetails")
		public ModelAndView closedIncidentDetails(){	
		log.info("Entered Inside SyntBotsITOpsController:listIncidentDetails()");
		return new ModelAndView("closedIncidentDetails");
	}
	
	/**
	 * This method directs to UserDetails page .This is an ajax call.
	 *
	 * @return ModelAndView - listIncidentDetails
	 */
	@RequestMapping("/userDetails")
		public ModelAndView UserDetailsJsp(){	
		log.info("Entered Inside SyntBotsITOpsController:UserDetails()");
		return new ModelAndView("userDetails");
	}
	
}
