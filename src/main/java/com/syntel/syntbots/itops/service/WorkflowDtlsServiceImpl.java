/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.WrkflwDtlsDAO;
import com.syntel.syntbots.itops.dao.WrkflwPrmLnkDAO;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;
import com.syntel.syntbots.itops.util.SyntBotsITOpsConstants;

/**
 * This class contains all the Service implementation layer methods related to
 * WorkFlow Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("workflowDtlsService")
public class WorkflowDtlsServiceImpl implements WorkflowDtlsService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private WrkflwDtlsDAO workflowDtlsDAO;

	@Autowired
	private WrkflwPrmLnkDAO workflowParamLnkDAO;

	/**
	 * This method is called to get WorkFlow details.
	 *
	 * @return List of Workflow Details
	 * @exception - ApplicationException in case of error
	 */
	public List<WorkflowDetails> getWrkflwDtlsList()
			throws ApplicationException {
		log.info("inside WorkflowDtlsServiceImpl: getWrkflwDtlsList() ");

		List<WorkflowDetails> wrkflwDtlsList = null;
		try {
			wrkflwDtlsList = workflowDtlsDAO.getWrkflwDtlsList();
			for (WorkflowDetails workflowDtls : wrkflwDtlsList) {
				if (workflowDtls.getDeleteFlag() == 0) {
					workflowDtls.setStrDeleteFlag(SyntBotsITOpsConstants.FLAG_NO);
				} else {
					workflowDtls.setStrDeleteFlag(SyntBotsITOpsConstants.FLAG_YES);
				}
			}

			for (WorkflowDetails workflowDtls : wrkflwDtlsList) {
				long wrkflwId = workflowDtls.getWrkflwId();
				List<WorkflowParamLnk> workflowParamLnkList = workflowParamLnkDAO
						.getWorkflowParamListByWrkflwId(wrkflwId);
				workflowDtls.setWorkflowParamLnkList(workflowParamLnkList);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"WorkflowDtlsServiceImpl.getWrkflwDtlsList", e);
		}
		log.info("Just before leaving WorkflowDtlsServiceImpl: getWrkflwDtlsList()");
		return wrkflwDtlsList;
	}

	/**
	*This method is called to get WorkFlow details by workflow name.
	*@param workflow Details
	*@return Workflow Details
	*@exception -  ApplicationException in case of error
	*/
	public WorkflowDetails getWrkflwDtlsByWrkflwName(WorkflowDetails workflowDtls) throws ApplicationException{
		
		log.info("inside WorkflowDtlsServiceImpl: getWrkflwDtlsByWrkflwName() ");
		WorkflowDetails wrkflwDtldByWrkflwName=null;
		try{
		wrkflwDtldByWrkflwName =workflowDtlsDAO.getWrkflwDtlsByWrkflwName(workflowDtls);
		
		if(wrkflwDtldByWrkflwName.getDeleteFlag()==0)
		{
			wrkflwDtldByWrkflwName.setStrDeleteFlag(SyntBotsITOpsConstants.FLAG_NO);
		}
		else{
			wrkflwDtldByWrkflwName.setStrDeleteFlag(SyntBotsITOpsConstants.FLAG_YES);
		}
		
		long wrkflwId=wrkflwDtldByWrkflwName.getWrkflwId();
		List<WorkflowParamLnk> workflowParamLnkList=workflowParamLnkDAO.getWorkflowParamListByWrkflwId(wrkflwId);
		for (WorkflowParamLnk workflowParamLnk : workflowParamLnkList) {
			
			if(workflowParamLnk.getParamMandatory()==0)
			{
				workflowParamLnk.setStrParamMandatory(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrParamMandatory(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			if(workflowParamLnk.getParamToBeStored()==0)
			{
				workflowParamLnk.setStrParamToBeStored(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrParamToBeStored(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			if(workflowParamLnk.getParamToBeEncrypted()==0)
			{
				workflowParamLnk.setStrParamToBeEncrypted(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrParamToBeEncrypted(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			if(workflowParamLnk.getParamToBeShown()==0)
			{
				workflowParamLnk.setStrParamToBeShown(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrParamToBeShown(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			if(workflowParamLnk.getConsiderSopParamDtl()==0)
			{
				workflowParamLnk.setStrConsiderSopParamDtl(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrConsiderSopParamDtl(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			if(workflowParamLnk.getParamValToBeShown()==0)
			{
				workflowParamLnk.setStrParamValToBeShown(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrParamValToBeShown(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			if(workflowParamLnk.getDeleteFlag()==0)
			{
				workflowParamLnk.setStrDeleteFlag(SyntBotsITOpsConstants.FLAG_NO);
			}
			else{
				workflowParamLnk.setStrDeleteFlag(SyntBotsITOpsConstants.FLAG_YES);
			}
			
			
		}
		
		wrkflwDtldByWrkflwName.setWorkflowParamLnkList(workflowParamLnkList);
	  } catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"WorkflowDtlsServiceImpl.getWrkflwDtlsByWrkflwName", e);
		}
	  log.info("Just before leaving WorkflowDtlsServiceImpl:getWrkflwDtlsByWrkflwName()");
	  return wrkflwDtldByWrkflwName;
	}
	/**
	 * This method is called to get count of workflow name to check whether workflow name already exists.
	 * @RequestBody workflow Details
	 * @return int count of workflow name
	 * @throws ApplicationException
	 */
	public int validateWrkflwName(WorkflowDetails workflowDtls) throws ApplicationException{
		log.info("inside WorkflowDtlsServiceImpl: validateWrkflwName() ");
		int countWrkflwName=0;
		try{
				countWrkflwName=workflowDtlsDAO.validateWrkflwName(workflowDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"WorkflowDtlsServiceImpl.validateWrkflwName", e);
		}
		log.info("Just before leaving WorkflowDtlsServiceImpl:validateWrkflwName()");
		return countWrkflwName;
	}
	/**
	 * This method is called to save workflow details(add or update)
	 * @RequestBody workflow Details
	 * @return void
	 * @throws ApplicationException
	 */
	public void saveWrkflwDtls(WorkflowDetails workflowDtls)throws ApplicationException {
		log.info("inside WorkflowDtlsServiceImpl: saveWrkflwDtls() ");
		try{
			if(workflowDtls.getWrkflwId()==0)
			{
				workflowDtlsDAO.addWrkflwDtls(workflowDtls);
			}
			workflowDtlsDAO.updateWrkflwDtls(workflowDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"WorkflowDtlsServiceImpl.saveWrkflwDtls", e);
		}
		log.info("Just before leaving WorkflowDtlsServiceImpl:saveWrkflwDtls()");
	}

}
