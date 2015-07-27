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

import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.mapper.WrkflwDtlsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to Workflow Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("workflowDtlsDAO")
public class WrkflwDtlsDAOImpl implements WrkflwDtlsDAO {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private WrkflwDtlsMapper workflowDtlsMapper;

	/**
	 * This method is called to get WorkFlowDtls
	 *
	 * @param workflow
	 *            detaisl
	 * @returnThis WorkflowDtls all the values related Workflow Details
	 * @exception - ApplicationException in case of error
	 */
	public WorkflowDetails getWorkFlowDtls(WorkflowDetails workflowDtls)
			throws ApplicationException {

		log.info("Entered inside WorkflowDtlsDAOImpl::getWorkFlowDtls() method");
		WorkflowDetails objWorkflowDtls = null;
		try {
			objWorkflowDtls = workflowDtlsMapper.getWorkFlowDtls(workflowDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsDAOImpl.getWorkFlowDtls", e, argsMap);
		}
		log.info("Just before leaving  WorkflowDtlsDAOImpl:getWorkFlowDtls() method");
		return objWorkflowDtls;
	}

	/**
	 * This method is called to get all the Complete Workflow Details List
	 *
	 * @param
	 * @returnThis List<WorkflowDtls> all the values related Workflow Details
	 *             List
	 * @exception - ApplicationException in case of error
	 */
	public List<WorkflowDetails> getWrkflwDtlsList()
			throws ApplicationException {
		log.info("Entered inside WorkflowDtlsDAOImpl::getWorkFlowDtls() method");
		List<WorkflowDetails> wrkflwDtlsList = null;
		try {
			wrkflwDtlsList = workflowDtlsMapper.getWrkflwDtlsList();
		} catch (Exception e) {
			throw new ApplicationException(
					"WorkflowDtlsDAOImpl.getWrkflwDtlsList", e);
		}
		log.info("Just before leaving  WorkflowDtlsDAOImpl:getWrkflwDtlsList() method");
		return wrkflwDtlsList;
	}

	/**
	 * This method is called to get the Workflow Details By Wrkflw Name
	 *
	 * @param workflow
	 *            Dtls
	 * @returnThis WorkflowDtls returns value related to Workflow Details
	 * @exception - ApplicationException in case of error
	 */
	public WorkflowDetails getWrkflwDtlsByWrkflwName(
			WorkflowDetails workflowDtls) throws ApplicationException {
		log.info("Entered inside WorkflowDtlsDAOImpl::getWrkflwDtlsByWrkflwName() method");
		WorkflowDetails wrkflwDtlsByWrkflwName = null;
		try {
			wrkflwDtlsByWrkflwName = workflowDtlsMapper
					.getWrkflwDtlsByWrkflwName(workflowDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsDAOImpl.getWrkflwDtlsByWrkflwName", e, argsMap);
		}
		log.info("Just before leaving  WorkflowDtlsDAOImpl:getWrkflwDtlsByWrkflwName() method");
		return wrkflwDtlsByWrkflwName;
	}

	/**
	 * This method is called to get count of workflow name to check whether
	 * workflow name already exists.
	 * 
	 * @RequestBody workflow Details
	 * @return int count of workflow name
	 * @throws ApplicationException
	 */
	public int validateWrkflwName(WorkflowDetails workflowDtls)
			throws ApplicationException {
		log.info("Entered inside WorkflowDtlsDAOImpl::validateWrkflwName() method");
		int countWrkflwName = 0;
		try {
			countWrkflwName = workflowDtlsMapper
					.validateWrkflwName(workflowDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsDAOImpl.validateWrkflwName", e, argsMap);
		}
		log.info("Just before leaving  WorkflowDtlsDAOImpl:validateWrkflwName() method");
		return countWrkflwName;
	}

	/**
	 * This method is called to add new workflow details
	 * 
	 * @RequestBody workflow Details
	 * @return void
	 * @throws ApplicationException
	 */
	public void addWrkflwDtls(WorkflowDetails workflowDtls)
			throws ApplicationException {
		log.info("Entered inside WorkflowDtlsDAOImpl::addWrkflwDtls() method");
		try {
			workflowDtlsMapper.addWrkflwDtls(workflowDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException("WorkflowDtlsDAOImpl.addWrkflwDtls",
					e, argsMap);
		}
		log.info("Just before leaving  WorkflowDtlsDAOImpl:addWrkflwDtls() method");
	}

	/**
	 * This method is called to update existing workflow details
	 * 
	 * @RequestBody workflow Details
	 * @return void
	 * @throws ApplicationException
	 */
	public void updateWrkflwDtls(WorkflowDetails workflowDtls)
			throws ApplicationException {
		log.info("Entered inside WorkflowDtlsDAOImpl::updateWrkflwDtls() method");
		try {
			workflowDtlsMapper.updateWrkflwDtls(workflowDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException(
					"WorkflowDtlsDAOImpl.updateWrkflwDtls", e, argsMap);
		}

		log.info("Just before leaving  WorkflowDtlsDAOImpl:updateWrkflwDtls() method");
	}

}
