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

import com.syntel.syntbots.itops.dto.SopWrkflwLnk;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.mapper.SopWorkFlowLinkMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to SopWorkFlowLink.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("sopWorkFlowLinkDAO")
public class SopWrkFlwLnkDAOImpl implements SopWrkFlwLnkDAO {
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private SopWorkFlowLinkMapper sopWorkFlowLinkMapper;

	/**
	 * This method is called to get all the workflow Details By SopId
	 *
	 * @param sopId
	 * @returnThis List of workflow details related Sop Id
	 * @exception - ApplicationException in case of error
	 */
	public List<WorkflowDetails> getWorkFlowListBySopId(int sopId)
			throws ApplicationException {
		log.info("Entered inside SopWorkFlowLnkDAOImpl::getWorkFlowListBySopId() method:SopId:"
				+ sopId + ":");
		List<WorkflowDetails> workflowListForWrkFlw = null;
		try {
			workflowListForWrkFlw = sopWorkFlowLinkMapper
					.getWorkFlowListBySopId(sopId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopId", sopId);
			throw new ApplicationException(
					"SopWorkFlowLnkDAOImpl.getWorkFlowListBySopId", e, argsMap);
		}
		log.info("Just before leaving SopWorkFlowLnkDAOImpl:getWorkFlowListBySopId()");
		return workflowListForWrkFlw;
	}

	/**
	 * This method is called to get all the Complete sop Workflow Link Lists
	 *
	 * @param
	 * @returnThis List of sop workflow link details
	 * @exception - ApplicationException in case of error
	 */

	public List<SopWrkflwLnk> getCompleteSopWorkflowLnkList()
			throws ApplicationException {
		log.info("Entered inside SopWorkFlowLnkDAOImpl::getCompleteSopWorkflowLnkList() method");
		List<SopWrkflwLnk> sopWorkflowLinkList = null;
		try {
			sopWorkflowLinkList = sopWorkFlowLinkMapper
					.getCompleteSopWorkflowLnkList();
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopWorkflowLinkList", sopWorkflowLinkList);
			throw new ApplicationException(
					"SopWorkFlowLinkDAO.getCompleteSopWorkflowLnkList", e,
					argsMap);
		}
		log.info("Just before leaving SopWorkFlowLnkDAOImpl:getCompleteSopWorkflowLnkList()");
		return sopWorkflowLinkList;
	}

	/**
	 * This method is called get Workflow name by Workflow Id
	 *
	 * @param WorkflowId
	 * @returnThis String of workflow name
	 * @exception - ApplicationException in case of error
	 */
	public String getWorkFlowNameByWorkflowId(long workfLowId)
			throws ApplicationException {
		log.info("Entered inside SopWorkFlowLnkDAOImpl::getWorkFlowNameByWorkflowId() method");
		String wrkflwName = null;
		try {
			wrkflwName = sopWorkFlowLinkMapper
					.getWorkFlowNameByWorkflowId(workfLowId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("wrkflwName", wrkflwName);
			throw new ApplicationException(
					"SopWorkFlowLinkDAO.getWorkFlowNameByWorkflowId", e,
					argsMap);
		}
		log.info("Just before leaving SopWorkFlowLnkDAOImpl:getWorkFlowNameByWorkflowId()");
		return wrkflwName;
	}

}
