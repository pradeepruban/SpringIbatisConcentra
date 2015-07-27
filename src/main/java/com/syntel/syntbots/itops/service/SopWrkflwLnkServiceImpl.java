/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.ApplnQueSopLnkDAO;
import com.syntel.syntbots.itops.dao.SopMsgLnkDAO;
import com.syntel.syntbots.itops.dao.SopWrkFlwLnkDAO;
import com.syntel.syntbots.itops.dto.SopWrkflwLnk;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * SOP Workflow link Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("sopWorkFlowLinkService")
public class SopWrkflwLnkServiceImpl implements SopWrkflwLnkService {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SopWrkFlwLnkDAO sopWorkFlowLinkDAO;
	@Autowired
	private ApplnQueSopLnkDAO applicationQueueSopLinkDAO;

	@Autowired
	private SopMsgLnkDAO sopMsgLnkDAO;

	/**
	 * This method is called to get workflow details list based on SOP Id
	 *
	 * @param sopId
	 * 
	 * @return List of workflow details
	 * @exception - ApplicationException in case of error
	 */
	public List<WorkflowDetails> getWorkFlowListBySopId(int sopId)
			throws ApplicationException {
		log.info("Entered inside SopWrkflwLnkServiceImpl::getWorkFlowListBySopId() method");
		List<WorkflowDetails> workflowListForWrkFlw = null;
		try {
			workflowListForWrkFlw = sopWorkFlowLinkDAO
					.getWorkFlowListBySopId(sopId);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getWorkFlowListBySopId", e);
		}
		log.info("Just before leaving  SopWrkflwLnkServiceImpl:getWorkFlowListBySopId() method");
		return workflowListForWrkFlw;
	}

	/**
	 * This method is called to get list of SOP workflow link details
	 *
	 * @param sopId
	 * 
	 * @return List of Sop Workflow Link details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopWrkflwLnk> getCompleteSopWorkflowLnkList()
			throws ApplicationException {
		log.info("Entered inside SopWrkflwLnkServiceImpl::getCompleteSopWorkflowLnkList() method");

		List<SopWrkflwLnk> sopWorkflowLinkList = null;
		try {
			sopWorkflowLinkList = sopWorkFlowLinkDAO
					.getCompleteSopWorkflowLnkList();
			for (SopWrkflwLnk sopWorkflowLink : sopWorkflowLinkList) {
				String strSopWrkflwLnkCreatedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(sopWorkflowLink
								.getSopWrkflwLnkCreatedBy());
				sopWorkflowLink
						.setStrSopWrkflwLnkCreatedByShortUserName(strSopWrkflwLnkCreatedByShortUserName);
				String strSopWrkflwLnkModifiedByShortUserName = sopMsgLnkDAO
						.getUserShortNameByUserId(sopWorkflowLink
								.getSopWrkflwLnkModifiedBy());
				sopWorkflowLink
						.setStrSopWrkflwLnkModifiedByShortUserName(strSopWrkflwLnkModifiedByShortUserName);
				String workflowName = sopWorkFlowLinkDAO
						.getWorkFlowNameByWorkflowId(sopWorkflowLink
								.getWorkFlowId());
				sopWorkflowLink.setWorkflowName(workflowName);
				String sopName = applicationQueueSopLinkDAO
						.getSopNameBySopId(sopWorkflowLink.getSopId());
				sopWorkflowLink.setSopName(sopName);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopMsgLnkServiceImpl.getCompleteSopWorkflowLnkList", e);
		}
		return sopWorkflowLinkList;
	}

}
