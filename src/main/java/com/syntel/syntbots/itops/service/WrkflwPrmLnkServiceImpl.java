/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.WrkflwPrmLnkDAO;
import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;
/**
*This class contains all the Service implementation layer methods related to WorkFlow Param Link Details.
*@author Syntel
*@version 1.0
*/
@Service("workflowParamLnkService")
public class WrkflwPrmLnkServiceImpl implements WrkflwPrmLnkService{
	
	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private WrkflwPrmLnkDAO workflowParamLnkDAO;

	/**
	*This method is called to get WorkFlow param list by workflow Id
	*@param workflow Id
	*@return List of Workflow Param Link
	*@exception -  ApplicationException in case of error
	*/
	public List<WorkflowParamLnk> getWorkflowParamListByWrkflwId(int wrkflwId) throws ApplicationException{
		log.info("Entered inside WrkflwPrmLnkServiceImpl::getWorkflowParamListByWrkflwId() method");
		List<WorkflowParamLnk> workflowParamLnkListForWrkFlw = null;
		try {
		workflowParamLnkListForWrkFlw = workflowParamLnkDAO.getWorkflowParamListByWrkflwId(wrkflwId);
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.getWorkflowParamListByWrkflwId", e);
		}
		log.info("Just before leaving  WrkflwPrmLnkServiceImpl::getWorkflowParamListByWrkflwId() method");
		return workflowParamLnkListForWrkFlw;
	}

	/**
	*This method is called to get Encrypted param names list by workflow Id
	*@param workflow details
	*@return List of Workflow Param Link
	*@exception -  ApplicationException in case of error
	*/
	public List<WorkflowParamLnk> getEncryptedParamNamesByWrkflwId(WorkflowDetails workflowDtls)throws ApplicationException {
		
		log.info("Entered inside WrkflwPrmLnkServiceImpl::getEncryptedParamNamesByWrkflwId() method");
		List<WorkflowParamLnk> workflowParamLnkEncryptedListBywrkflwId = null;
		try {
		workflowParamLnkEncryptedListBywrkflwId = workflowParamLnkDAO.getEncryptedParamNamesByWrkflwId(workflowDtls);
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.getEncryptedParamNamesByWrkflwId", e);
		}
		log.info("Just before leaving  WrkflwPrmLnkServiceImpl::getEncryptedParamNamesByWrkflwId() method");
		return workflowParamLnkEncryptedListBywrkflwId;
		
	}

	/**
	*This method is called to get Encrypted param names list by incident execution Id
	*@param incident Execution details
	*@return List of Workflow Param Link
	*@exception -  ApplicationException in case of error
	*/
	public List<WorkflowParamLnk> getEncryptedParamNamesByIncdntExecId(IncidentExecDtls incidentExecDtls) throws ApplicationException{
		
		log.info("Entered inside WrkflwPrmLnkServiceImpl::getEncryptedParamNamesByIncdntExecId() method");
		List<WorkflowParamLnk> workflowParamLnkEncryptedListByIncdntExecId = null;
		try {
		
		workflowParamLnkEncryptedListByIncdntExecId = workflowParamLnkDAO.getEncryptedParamNamesByIncdntExecId(incidentExecDtls);
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.getEncryptedParamNamesByIncdntExecId", e);
		}
		log.info("Just before leaving  WrkflwPrmLnkServiceImpl::getEncryptedParamNamesByIncdntExecId() method");
		return workflowParamLnkEncryptedListByIncdntExecId;
	}

	/**
	*This method is called to get Workflow param list to be shown by workflow Id
	*@param workflow Id
	*@return List of Workflow Param Link
	*@exception -  ApplicationException in case of error
	*/
	public List<WorkflowParamLnk> getWorkflowParamListTobeShowToUserByWrkflwId(int wrkflwId) throws ApplicationException {
		log.info("Entered inside WrkflwPrmLnkServiceImpl::getWorkflowParamListTobeShowToUserByWrkflwId() method");
		List<WorkflowParamLnk> workflowParamLnkListForWrkFlw = null;
		try {
		workflowParamLnkListForWrkFlw = workflowParamLnkDAO.getWorkflowParamListTobeShowToUserByWrkflwId(wrkflwId);
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.getWorkflowParamListTobeShowToUserByWrkflwId", e);
		}
		log.info("Just before leaving WrkflwPrmLnkServiceImpl::getWorkflowParamListTobeShowToUserByWrkflwId() method");
		return workflowParamLnkListForWrkFlw;
	}
	/**
	*This method is called to get Workflow param list to be shown by SOP Id
	*@param SOP details
	*@return List of Workflow Param Link
	*@exception -  ApplicationException in case of error
	*/
	public List<WorkflowParamLnk> getWorkflwParamCodeListBySOPId(SopDetails sopDetails) throws ApplicationException {
		log.info("Entered inside WrkflwPrmLnkServiceImpl::getWorkflwParamCodeListBySOPId() method");
		List<WorkflowParamLnk> workflwParamCodeListBySOPId = null;
		try {
		     workflwParamCodeListBySOPId = workflowParamLnkDAO.getWorkflwParamCodeListBySOPId(sopDetails);
		} catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.getWorkflwParamCodeListBySOPId", e);
		}
		log.info("Just before leaving WrkflwPrmLnkServiceImpl::getWorkflwParamCodeListBySOPId() method");
		return workflwParamCodeListBySOPId;
	
	}
	/**
	 * This method is called to get count of workflow param name to check whether workflow paramname already exists.
	 * @RequestBody workflow param Details
	 * @return int count of workflow param name
	 * @throws ApplicationException
	 */
	public int validateWorkflowParamName(WorkflowParamLnk workflowParamLnk)throws ApplicationException {
		log.info("Entered inside WrkflwPrmLnkServiceImpl::validateWorkflowParamName() method");
		int tempWrkflwParamNameCount=0;
		try{
			tempWrkflwParamNameCount=workflowParamLnkDAO.validateWorkflowParamName(workflowParamLnk);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.validateWorkflowParamName", e);
		}
		log.info("Just before leaving WrkflwPrmLnkServiceImpl: validateWorkflowParamName()");
		return tempWrkflwParamNameCount;
	}
	/**
	 * This method is called to save workflow param details(add or update)
	 * @RequestBody workflow param Details
	 * @return void
	 * @throws ApplicationException
	 */
	public void saveWrkflwParamDtls(WorkflowParamLnk workflowParamLnk) throws ApplicationException {
		log.info("Entered inside WrkflwPrmLnkServiceImpl::saveWrkflwParamDtls() method");
		try{
			if(workflowParamLnk.getWrkflwParamLnkId()==0)
			{
				workflowParamLnkDAO.addWrkflwParamDtls(workflowParamLnk);
			}else{
				workflowParamLnkDAO.updateWrkflwparamDtls(workflowParamLnk);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("WrkflwPrmLnkServiceImpl.saveWrkflwParamDtls", e);
		}
		log.info("Just before leaving WrkflwPrmLnkServiceImpl: saveWrkflwParamDtls()");
	}
}
