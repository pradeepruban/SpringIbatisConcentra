/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.syntel.syntbots.itops.dao.IncidentDetailsDAO;
import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the service implementation layer methods related to
 * Incidents.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("incidentService")
public class IncidentServiceImpl implements IncidentService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IncidentDetailsDAO incidentDAO;

	@Autowired
	private ApplnQueSopLnkService applicationQueueSopLinkService;

	@Autowired
	private SopWrkflwLnkService sopWorkFlowLinkService;

	@Autowired
	private WrkflwPrmLnkService workflowParamLnkService;

	@Autowired
	private UsrApplnQueSopExclusnService userApplicationQueueSopExclusionService;

	@Autowired
	private SopMsgLnkService sopMsgLnkService;

	@Autowired
	private UsrApplnQueLnkService userApplicationQueueLinkService;

	/**
	 * This method is called to list of closed Incident details
	 *
	 * @param User
	 *            Details
	 * @return list of IncidentDetails
	 * @exception - ApplicationException in case of error
	 */
	public List<IncidentDetails> getClosedIncidentList(UserDetails userDetails)
			throws ApplicationException {
		log.info("Entered inside IncidentServiceImpl:getClosedIncidentList():");
		List<IncidentDetails> closedIncidentList = null;
		try {
			closedIncidentList = incidentDAO.getClosedIncidentList(userDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getClosedIncidentList", e);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getClosedIncidentList() method");
		return closedIncidentList;
	}

	/**
	 * This method is called to list of Incident details for logged in user
	 *
	 * @param User
	 *            Details
	 * @return list of IncidentDetails
	 * @exception - ApplicationException in case of error
	 */
	public List<IncidentDetails> getIncidentListForUser(UserDetails userDetails)
			throws ApplicationException {
		log.info("Entered inside IncidentServiceImpl:getIncidentListForUser():");
		List<IncidentDetails> incidentDetailsList = null;
		try {
			incidentDetailsList = incidentDAO
					.getIncidentListForUser(userDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getIncidentListForUser", e);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getIncidentListForUser() method");
		return incidentDetailsList;
	}

	/**
	 * This method is called to get Incident details by incident details Id
	 *
	 * @param incidentdetails
	 *            Id
	 * @return Incident Details
	 * @exception - ApplicationException in case of error
	 */
	public IncidentDetails getIncidentById(Integer incdntDtlsId,
			UserDetails userDetails) throws ApplicationException {
		log.info("Entered inside IncidentServiceImpl:getIncidentById()");
		log.info("Entered inside IncidentServiceImpl:getIncidentById() user details"+userDetails);
		List<WorkflowDetails> wrkflwList = null;
		List<SopDetails> sopListForWorkflow = null;
		List<SopDetails> sopListNotAccessByUsr = null;
		List<SopDetails> sopListByMsgKey = null;

		SopDetails sopDtlsForWorkFlow = null;
		WorkflowDetails WorkflowDtlsForWorkFlow = null;
		UsrApplnQueLnk usrApplnQueLnkDetails = null;
		List<WorkflowParamLnk> workflowParamListForWorkFlow = null;

		SopMsgLnk sopMsgLnk = new SopMsgLnk();
		IncidentDetails incidentDetailsForWrkFlw = null;

		try {

			incidentDetailsForWrkFlw = incidentDAO
					.getIncidentById(incdntDtlsId);

			if (incidentDetailsForWrkFlw != null) {
				sopListForWorkflow = applicationQueueSopLinkService
						.getSopListByApplnNameAndQueueName(
								incidentDetailsForWrkFlw.getIncdntAppName(),
								incidentDetailsForWrkFlw.getIncdntAssgnmntGrp());
				log.info("soplist for the Geting Workflow "
						+ sopListForWorkflow);
			}

			if (sopListForWorkflow != null && incidentDetailsForWrkFlw != null
					&& userDetails != null) {
				sopListNotAccessByUsr = userApplicationQueueSopExclusionService
						.getsopListNotAccessByUsr(userDetails,
								incidentDetailsForWrkFlw);
				usrApplnQueLnkDetails = userApplicationQueueLinkService
						.getUsrApplnQueLnkDetailsByAppnameandQueName(
								userDetails, incidentDetailsForWrkFlw);
				log.info(" usrApplnQueLnkDetails  values for usr ::"
						+ usrApplnQueLnkDetails.getUsrAppQLinkToViewFlag());
				log.info(" Sop List that user doesnt have access ::"
						+ sopListNotAccessByUsr);

			}
			if (sopListForWorkflow != null && sopListNotAccessByUsr != null) {
				sopListForWorkflow = userApplicationQueueSopExclusionService
						.getSopListAccessByUsrforWrkflw(sopListForWorkflow,
								sopListNotAccessByUsr);
				log.info(" soplist for the Geting Workflow after sorting by sop list that user dont have access::"
						+ sopListForWorkflow);
			}

			if (sopListForWorkflow != null) {
				sopMsgLnk.setMsgKeyword("FileSystemCleanup");
				log.info("Sop List of after user Exclued" + sopListForWorkflow);
				sopListByMsgKey = sopMsgLnkService
						.getListSopByMessageKey(sopMsgLnk);
				sopListForWorkflow = sopMsgLnkService.getSortedSopBySopMsg(
						sopListForWorkflow, sopListByMsgKey);
				log.info("Sorted Sop List of on bases of msg key "
						+ sopListForWorkflow);

			}

			if (!(CollectionUtils.isEmpty(sopListForWorkflow))) {
				sopDtlsForWorkFlow = sopListForWorkflow.get(0);
			}
			if (sopDtlsForWorkFlow != null) {
				wrkflwList = sopWorkFlowLinkService
						.getWorkFlowListBySopId(sopDtlsForWorkFlow.getSopId());
			}

			if (!(CollectionUtils.isEmpty(wrkflwList))) {
				WorkflowDtlsForWorkFlow = wrkflwList.get(0);
			}

			if (WorkflowDtlsForWorkFlow != null) {
				workflowParamListForWorkFlow = workflowParamLnkService
						.getWorkflowParamListTobeShowToUserByWrkflwId(WorkflowDtlsForWorkFlow
								.getWrkflwId());
			}

			incidentDetailsForWrkFlw.setSopList(sopListForWorkflow);
			incidentDetailsForWrkFlw.setWorkFlowList(wrkflwList);
			incidentDetailsForWrkFlw
					.setWorkFlowParamList(workflowParamListForWorkFlow);
			incidentDetailsForWrkFlw.setUsrApplnQueLnk(usrApplnQueLnkDetails);
		} catch (ApplicationException ae) {
			throw ae;
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userDetails", userDetails);
			throw new ApplicationException(
					"IncidentServiceImpl.getIncidentById", e, argsMap);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getIncidentById() method");
		return incidentDetailsForWrkFlw;
	}

	/**
	 * This method is called to get list of Workflow details and param details
	 * by SOP Id
	 *
	 * @param SOP
	 *            Id
	 * @return list of Workflow details
	 * @exception - ApplicationException in case of error
	 */
	public List<WorkflowDetails> getWorkFlowListAndParamsBySopId(int sopId)
			throws ApplicationException {
		log.info("Entered inside IncidentServiceImpl:getWorkFlowListAndParamsBySopId()");
		List<WorkflowDetails> workflowDtlsList = null;

		WorkflowDetails WorkflowDtlsForWorkFlow = null;

		List<WorkflowParamLnk> workflowParamListForWorkFlow = null;

		try {

			if (sopId != 0) {
				workflowDtlsList = sopWorkFlowLinkService
						.getWorkFlowListBySopId(sopId);
			}

			if (!(CollectionUtils.isEmpty(workflowDtlsList))) {
				WorkflowDtlsForWorkFlow = workflowDtlsList.get(0);
			}

			if (WorkflowDtlsForWorkFlow != null) {
				workflowParamListForWorkFlow = workflowParamLnkService
						.getWorkflowParamListByWrkflwId(WorkflowDtlsForWorkFlow
								.getWrkflwId());
			}

			WorkflowDtlsForWorkFlow
					.setWorkflowParamLnkList(workflowParamListForWorkFlow);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getWorkFlowListAndParamsBySopId", e);
		}

		log.info("Just before leaving  IncidentServiceImpl :: getWorkFlowListAndParamsBySopId method");
		return workflowDtlsList;
	}

	/**
	 * This method is called to get count of open incidents for logged in user
	 *
	 * @param user
	 *            details
	 * @return integer - openIncidentsForLoggedInUser
	 * @exception - ApplicationException in case of error
	 */
	public int getOpenIncidentsForLoggedInUser(UserDetails userDetails)
			throws ApplicationException {
		log.info("Entered inside IncidentServiceImpl:getOpenIncidentsForLoggedInUser()");
		int openIncidentsForLoggedInUser = 0;
		try {
			openIncidentsForLoggedInUser = incidentDAO
					.getOpenIncidentsForLoggedInUser(userDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getOpenIncidentsForLoggedInUser", e);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getOpenIncidentsForLoggedInUser");
		return openIncidentsForLoggedInUser;

	}

	/**
	 * This method is called to get count of severe incidents for logged in user
	 *
	 * @param user
	 *            details
	 * @return integer
	 * @exception - ApplicationException in case of error
	 */
	public int getsevereIncidentsForLoggedInUser(UserDetails userDetails)
			throws ApplicationException {
		log.info("Entered inside IncidentServiceImpl:getsevereIncidentsForLoggedInUser()");
		int severeIncidents = 0;
		try {
			severeIncidents = incidentDAO
					.getsevereIncidentsForLoggedInUser(userDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getsevereIncidentsForLoggedInUser", e);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getsevereIncidentsForLoggedInUser");
		return severeIncidents;
	}

	public List<IncidentDetails> getIncidentListByIncidentOpendate(
			IncidentDetails incidentDetails) throws Exception {
		log.info("Entered inside IncidentServiceImpl:getIncidentListByIncidentOpendate()");
		List<IncidentDetails> incdntLstByIncdntOpndate = null;
		try {
			incdntLstByIncdntOpndate = incidentDAO
					.getIncidentListByIncidentOpendate(incidentDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getIncidentListByIncidentOpendate", e);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getIncidentListByIncidentOpendate");
		return incdntLstByIncdntOpndate;

	}

	public IncidentDetails getlistIncidentDetailsById(Integer incdntDtlsId)
			throws Exception {
		log.info("Entered inside IncidentServiceImpl:getlistIncidentDetailsById():");

		List<SopDetails> sopList = null;

		List<SopParamDetails> sopParamList = null;
		IncidentDetails rtrnincidentDetailsList = null;

		try {
			rtrnincidentDetailsList = incidentDAO
					.getlistIncidentDetailsById(incdntDtlsId);

			if (rtrnincidentDetailsList != null) {

				// String incidentId=rtrnincidentDetailsList.getIncdntId();
				sopList = incidentDAO
						.getSopListByIncidentid(rtrnincidentDetailsList
								.getIncdntId());
				log.info("sopList" + sopList);
				rtrnincidentDetailsList.setSopList(sopList);
			}

			log.info("returndlist from servieimpl is" + rtrnincidentDetailsList);
			// log.info("returend list form incident serviceimpl"+rtrnincidentDetailsList);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getlistIncidentDetailsById", e);
		}
		log.info("Just before leaving  IncidentServiceImpl :: getlistIncidentDetailsById()");
		return rtrnincidentDetailsList;

	}

	public void saveIncidentDtls(IncidentDetails incidentDetails)
			throws Exception {
		try {
			incidentDAO.saveIncidentDtls(incidentDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"IncidentServiceImpl.getIncidentListByIncidentOpendate", e);
		}
	}

}
