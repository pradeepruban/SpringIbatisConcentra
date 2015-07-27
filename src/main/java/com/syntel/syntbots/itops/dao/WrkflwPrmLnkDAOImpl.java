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

import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.mapper.WrkflwPrmLnkMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
*This class contains all the DAO layer methods related to WorkflowParamLnk.
*@author Syntel
*@version 1.0
*/
@Repository("workflowParamLnkDAO")
public class WrkflwPrmLnkDAOImpl implements WrkflwPrmLnkDAO {

	private Logger log=Logger.getLogger(this.getClass());
	
	@Autowired
	private WrkflwPrmLnkMapper  workflowParamLnkMapper;
	
	/**
	*This method is called to get all the Complete  WorkflowParamLinkDtls 
	*@param  workflow Details
	*@returnThis List of WorkflowParamLnk 
	*@exception - ApplicationException 
	*/
	public List<WorkflowParamLnk> getWorkflowParamLinkDtls(WorkflowDetails workflowDtls)throws ApplicationException {
		
		log.info("Entered inside WorkflowParamLnkDAOImpl::getWorkflowParamLinkDtls() method");
		List<WorkflowParamLnk> workflowParamLnkList = null;
		try{
			workflowParamLnkList = workflowParamLnkMapper.getWorkflowParamLinkDtls(workflowDtls);
		}catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.getWorkflowParamLinkDtls", e, argsMap);
		}
		
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:getWorkflowParamLinkDtls() method");
		return workflowParamLnkList;		
	}

	/**
	*This method is called to get all the Complete WorkflowParamList By WrkflwId
	*@param  wrkflwId
	*@returnThis List of Workflow Param Lnk details
	*@exception -   ApplicationException 
	*/
	public List<WorkflowParamLnk> getWorkflowParamListByWrkflwId(long wrkflwId)throws ApplicationException {
		log.info("Entered inside WorkflowParamLnkDAOImpl::getWorkflowParamListByWrkflwId() method");
		List<WorkflowParamLnk> workflowParamLnkListForWrkFlw = null;
		try{
			workflowParamLnkListForWrkFlw = workflowParamLnkMapper.getWorkflowParamListByWrkflwId(wrkflwId);
		}catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("wrkflwId", wrkflwId);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.getWorkflowParamListByWrkflwId", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:getWorkflowParamListByWrkflwId() method");
		return workflowParamLnkListForWrkFlw;
	}

	/**
	*This method is called to get all the Complete  Encrypted Param Names By Wrkflw Id
	*@param  Wrokflow Id
	*@returnThis List of Workflow Param Lnk details 
	*@exception -   ApplicationException 
	*/
	public List<WorkflowParamLnk> getEncryptedParamNamesByWrkflwId(WorkflowDetails workflowDtls) throws ApplicationException {
		
		log.info("Entered inside WorkflowParamLnkDAOImpl::getEncryptedParamNamesByWrkflwId() method");
		List<WorkflowParamLnk> workflowParamLnkEncryptedListByWrkFlwId = null;
		try{
			workflowParamLnkEncryptedListByWrkFlwId = workflowParamLnkMapper.getEncryptedParamNamesByWrkflwId(workflowDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowDtls", workflowDtls);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.getEncryptedParamNamesByWrkflwId", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:getEncryptedParamNamesByWrkflwId() method");
		return workflowParamLnkEncryptedListByWrkFlwId;
	}

	/**
	*This method is called to get all the Complete  EncryptedParamNames By IncdntExecId
	*@param  Incident execution Id
	*@returnThis List of WorkflowParamLnk 
	*@exception -   ApplicationException 
	*/
	public List<WorkflowParamLnk> getEncryptedParamNamesByIncdntExecId(IncidentExecDtls incidentExecDtls) throws ApplicationException {

		log.info("Entered inside WorkflowParamLnkDAOImpl::getEncryptedParamNamesByIncdntExecId() method");
		List<WorkflowParamLnk> workflowParamLnkEncryptedListByIncdntExecId =  null;
		try{
			workflowParamLnkEncryptedListByIncdntExecId= workflowParamLnkMapper.getEncryptedParamNamesByIncdntExecId(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.getEncryptedParamNamesByIncdntExecId", e, argsMap);
		}
		log.info("Just before leaving WrkflwPrmLnkDAOImpl:getEncryptedParamNamesByIncdntExecId() method");
		return workflowParamLnkEncryptedListByIncdntExecId;
	}
	
	/**
	*This method is called to get all the Complete workflowParamList To be ShowTo User By Wrkflw Id
	*@param  Wrokflow Id
	*@returnThis List of Workflow Param Lnk details
	*@exception -   ApplicationException 
	*/
	public List<WorkflowParamLnk> getWorkflowParamListTobeShowToUserByWrkflwId(long wrkflwId) throws ApplicationException {
		log.info("Entered inside WorkflowParamLnkDAOImpl::getWorkflowParamListTobeShowToUserByWrkflwId() method");
		List<WorkflowParamLnk> workflowParamLnkListForWrkFlw = null;
		try{
			workflowParamLnkListForWrkFlw = workflowParamLnkMapper.getWorkflowParamListTobeShowToUserByWrkflwId(wrkflwId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("wrkflwId", wrkflwId);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.getWorkflowParamListTobeShowToUserByWrkflwId", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:getWorkflowParamListTobeShowToUserByWrkflwId() method");
		return workflowParamLnkListForWrkFlw;
	}
	
	/**
	*This method is called to get all the workflow param list based on SOP Id
	*@param SOP details
	*@returnThis List of Workflow Param Lnk details
	*@exception -   ApplicationException 
	*/
	public List<WorkflowParamLnk> getWorkflwParamCodeListBySOPId(SopDetails sopDetails) throws ApplicationException {
		log.info("Entered inside WorkflowParamLnkDAOImpl::getWorkflwParamCodeListBySOPId() method");
		List<WorkflowParamLnk> workflwParamCodeListBySOPId=null;
		try{
			workflwParamCodeListBySOPId = workflowParamLnkMapper.getWorkflwParamCodeListBySOPId(sopDetails);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopDetails", sopDetails);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.getWorkflwParamCodeListBySOPId", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:getWorkflwParamCodeListBySOPId() method");
		return workflwParamCodeListBySOPId;
	}
	
	/**
	 * This method is called to get count of workflow param name to check whether workflow param name already exists.
	 * @RequestBody workflowparam Details
	 * @return int count of workflow param name
	 * @throws ApplicationException
	 */
	public int validateWorkflowParamName(WorkflowParamLnk workflowParamLnk) throws ApplicationException {
		log.info("Entered inside WorkflowParamLnkDAOImpl::validateWorkflowParamName() method");
		int countWrkflwParamNameCount=0;
		try{
				countWrkflwParamNameCount=workflowParamLnkMapper.validateWorkflowParamName(workflowParamLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowParamLnk", workflowParamLnk);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.validateWorkflowParamName", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:validateWorkflowParamName() method");
		return countWrkflwParamNameCount;
	}
	
	/**
	 * This method is called to add new workflow details
	 * @RequestBody workflow Details
	 * @return void
	 * @throws ApplicationException
	 */
	public void addWrkflwParamDtls(WorkflowParamLnk workflowParamLnk) throws ApplicationException {
		log.info("Entered inside WorkflowParamLnkDAOImpl::addWrkflwParamDtls() method");
		try{
		workflowParamLnkMapper.addWrkflwParamDtls(workflowParamLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowParamLnk", workflowParamLnk);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.addWrkflwParamDtls", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:addWrkflwParamDtls() method");
		
	}
	/**
	 * This method is called to update existing workflow param details
	 * @RequestBody workflow param Details
	 * @return void
	 * @throws ApplicationException
	 */
	public void updateWrkflwparamDtls(WorkflowParamLnk workflowParamLnk) throws ApplicationException {
		log.info("Entered inside WorkflowParamLnkDAOImpl::updateWrkflwparamDtls() method");
		try{
			workflowParamLnkMapper.updateWrkflwparamDtls(workflowParamLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("workflowParamLnk", workflowParamLnk);
			throw new ApplicationException(
					"WrkflwPrmLnkDAOImpl.updateWrkflwparamDtls", e, argsMap);
		}
		log.info("Just before leaving  WrkflwPrmLnkDAOImpl:updateWrkflwparamDtls() method");
	}

}
