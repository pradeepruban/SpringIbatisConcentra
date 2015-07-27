/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
/**
*This interface contains all the mappers related to WorkFlow Param Link Details.
*@author Syntel
*@version 1.0
*/
public interface WrkflwPrmLnkMapper {
	
	/**
	 *This method is used to get workflow param link details 
	  * @param workflow details
	  * @return list of workflow param link details
	*/
	@Select("SELECT scmnWorkFlowParam.wrkflw_id as 'wrkflwId',scmnWorkFlowParam.param_name as 'paramName',scmnWorkFlowParam.param_code as 'paramCode',scmnWorkFlowParam.param_desc as 'paramDesc',scmnWorkFlowParam.param_type as 'paramType',scmnWorkFlowParam.param_validation as 'paramValidation',  scmnWorkFlowParam.param_to_be_shown as 'paramToBeShown',scmnWorkFlowParam.param_val_to_be_shown as 'paramValToBeShown',scmnWorkFlowParam.param_type_in_workflow as 'paramTypeInWorkflow',scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',scmnWorkFlowParam.param_order as 'paramOrder',scmnWorkFlowParam.param_mandatory as 'paramMandatory',scmnWorkFlowParam.param_default_value as 'paramDefaultValue',scmnWorkFlowParam.param_to_be_stored as 'paramToBeStored',scmnWorkFlowParam.param_to_be_encrypted as 'paramToBeEncrypted',scmnWorkFlowParam.delete_flag as 'deleteFlag',scmnWorkFlowParam.created_by as 'createdBy',scmnWorkFlowParam.modified_by as 'modifiedBy',scmnWorkFlowParam.created_date as 'createdDate',scmnWorkFlowParam.modified_date as 'modifiedDate',scmnWorkFlowParam.res_attribute1 as 'resAttribute1',scmnWorkFlowParam.res_attribute2 as 'resAttribute2',scmnWorkFlowParam.res_attribute3 as 'resAttribute3',scmnWorkFlowParam.res_attribute4 as 'resAttribute4',scmnWorkFlowParam.res_attribute5 as 'resAttribute5' FROM scmn_workflow_param_lnk scmnWorkFlowParam  WHERE wrkflw_id=#{wrkflwId}")
	public List<WorkflowParamLnk> getWorkflowParamLinkDtls(WorkflowDetails workflowDtls);

	/**
	 *This method is used to get workflow param list details by workflow id  
	  * @param workflow id 
	  * @return list of workflow param link details
	*/
	@Select("SELECT scmnWorkFlowParam.wrkflw_param_lnk_id as 'wrkflwParamLnkId',scmnWorkFlowParam.wrkflw_id as 'wrkflwId',scmnWorkFlowParam.param_name as 'paramName',"
			+ "scmnWorkFlowParam.param_type as 'paramType',scmnWorkFlowParam.param_validation as 'paramValidation',scmnWorkFlowParam.param_code as 'paramCode',"
			+ "scmnWorkFlowParam.param_order as 'paramOrder',scmnWorkFlowParam.param_mandatory as 'paramMandatory',scmnWorkFlowParam.param_desc as 'paramDesc',"
			+ "scmnWorkFlowParam.param_default_value as 'paramDefaultValue',scmnWorkFlowParam.param_to_be_stored as 'paramToBeStored',"
			+ "scmnWorkFlowParam.param_to_be_encrypted as 'paramToBeEncrypted',scmnWorkFlowParam.param_to_be_shown as 'paramToBeShown',"
			+ "scmnWorkFlowParam.param_val_to_be_shown as 'paramValToBeShown',scmnWorkFlowParam.param_type_in_workflow as 'paramTypeInWorkflow',"
			+ "scmnWorkFlowParam.delete_flag as 'deleteFlag',scmnWorkFlowParam.created_by as 'createdBy',users.usr_short_name AS createdByUsernameParam,"
			+ "scmnWorkFlowParam.modified_by as 'modifiedBy',users.usr_short_name AS modifiedByUsernameParam,"
			+ "scmnWorkFlowParam.created_date as 'createdDate',DATE_FORMAT(scmnWorkFlowParam.created_date,'%d %b %Y %T') AS strCreatedDateParam,"
			+ "scmnWorkFlowParam.modified_date as 'modifiedDate',DATE_FORMAT(scmnWorkFlowParam.modified_date,'%d %b %Y %T') AS strModifiedDateParam,"
			+ "scmnWorkFlowParam.res_attribute1 as 'resAttribute1',scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',scmnWorkFlowParam.res_attribute2 as 'resAttribute2',scmnWorkFlowParam.res_attribute3 as 'resAttribute3',"
			+ "scmnWorkFlowParam.res_attribute4 as 'resAttribute4',scmnWorkFlowParam.res_attribute5 as 'resAttribute5' FROM scmn_workflow_param_lnk scmnWorkFlowParam,scmn_user_dtls users"
			+ " WHERE wrkflw_id=#{wrkflwId} AND scmnWorkFlowParam.created_by=users.usr_id order by paramOrder")
	public List<WorkflowParamLnk> getWorkflowParamListByWrkflwId(long wrkflwId);

	/**
	 *This method is used to get encrypted param names details by workflow id  
	  * @param workflow details 
	  * @return list of workflow param link details
	*/
	@Select("SELECT scmnWorkFlowParam.wrkflw_id as 'wrkflwId',scmnWorkFlowParam.param_name as 'paramName',"
			+ "scmnWorkFlowParam.param_type as 'paramType',scmnWorkFlowParam.param_validation as 'paramValidation',scmnWorkFlowParam.param_code as 'paramCode',"
			+ "scmnWorkFlowParam.param_order as 'paramOrder',scmnWorkFlowParam.param_mandatory as 'paramMandatory',scmnWorkFlowParam.param_desc as 'paramDesc',"
			+ "scmnWorkFlowParam.param_default_value as 'paramDefaultValue',scmnWorkFlowParam.param_to_be_stored as 'paramToBeStored',"
			+ "scmnWorkFlowParam.param_to_be_encrypted as 'paramToBeEncrypted',scmnWorkFlowParam.param_to_be_shown as 'paramToBeShown',scmnWorkFlowParam.param_val_to_be_shown as 'paramValToBeShown',scmnWorkFlowParam.param_type_in_workflow as 'paramTypeInWorkflow',scmnWorkFlowParam.delete_flag as 'deleteFlag',scmnWorkFlowParam.created_by as 'createdBy',"
			+ "scmnWorkFlowParam.modified_by as 'modifiedBy',scmnWorkFlowParam.created_date as 'createdDate',scmnWorkFlowParam.modified_date as 'modifiedDate',"
			+ "scmnWorkFlowParam.res_attribute1 as 'resAttribute1',scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',scmnWorkFlowParam.res_attribute2 as 'resAttribute2',scmnWorkFlowParam.res_attribute3 as 'resAttribute3',"
			+"scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',"
			+ "scmnWorkFlowParam.res_attribute4 as 'resAttribute4',scmnWorkFlowParam.res_attribute5 as 'resAttribute5' FROM scmn_workflow_param_lnk scmnWorkFlowParam"
			+ " WHERE wrkflw_id=#{wrkflwId} AND param_to_be_encrypted = '1' order by paramOrder ")
	public List<WorkflowParamLnk> getEncryptedParamNamesByWrkflwId(WorkflowDetails workflowDtls);

	/**
	 *This method is used to get encrypted param names  by incident execution id  
	  * @param incident execution details 
	  * @return list of workflow param names link details
	*/
	@Select("SELECT scmnWorkFlowParam.wrkflw_id as 'wrkflwId',scmnWorkFlowParam.param_name as 'paramName',"
			+ "scmnWorkFlowParam.param_type as 'paramType',scmnWorkFlowParam.param_validation as 'paramValidation',scmnWorkFlowParam.param_code as 'paramCode',"
			+ "scmnWorkFlowParam.param_order as 'paramOrder',scmnWorkFlowParam.param_mandatory as 'paramMandatory',scmnWorkFlowParam.param_desc as 'paramDesc',"
			+ "scmnWorkFlowParam.param_default_value as 'paramDefaultValue',scmnWorkFlowParam.param_to_be_stored as 'paramToBeStored',"
			+ "scmnWorkFlowParam.param_to_be_encrypted as 'paramToBeEncrypted',scmnWorkFlowParam.param_to_be_shown as 'paramToBeShown',scmnWorkFlowParam.param_val_to_be_shown as 'paramValToBeShown',scmnWorkFlowParam.param_type_in_workflow as 'paramTypeInWorkflow',scmnWorkFlowParam.delete_flag as 'deleteFlag',scmnWorkFlowParam.created_by as 'createdBy',"
			+ "scmnWorkFlowParam.modified_by as 'modifiedBy',scmnWorkFlowParam.created_date as 'createdDate',scmnWorkFlowParam.modified_date as 'modifiedDate',"
			+ "scmnWorkFlowParam.res_attribute1 as 'resAttribute1',scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',scmnWorkFlowParam.res_attribute2 as 'resAttribute2',scmnWorkFlowParam.res_attribute3 as 'resAttribute3',"
			+"scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',"
			+ "scmnWorkFlowParam.res_attribute4 as 'resAttribute4',scmnWorkFlowParam.res_attribute5 as 'resAttribute5' FROM scmn_workflow_param_lnk scmnWorkFlowParam,scmn_incident_exec_dtls scmnIncExecDtls "
			+ " WHERE scmnWorkFlowParam.wrkflw_id=scmnIncExecDtls.wrkflw_id AND scmnIncExecDtls.incident_exec_id=#{incidentExecId} order by paramOrder")
	public List<WorkflowParamLnk> getEncryptedParamNamesByIncdntExecId(IncidentExecDtls incidentExecDtls);

	
	
	/**
	 *This method is used to get workflow param list to be shown to user by workflow id  
	  * @param workflow id
	  * @return list of workflow param details
	*/
	@Select("SELECT scmnWorkFlowParam.wrkflw_id as 'wrkflwId',scmnWorkFlowParam.param_name as 'paramName',"			
			+ "scmnWorkFlowParam.param_type as 'paramType',scmnWorkFlowParam.param_validation as 'paramValidation',scmnWorkFlowParam.param_code as 'paramCode', "
			+ "scmnWorkFlowParam.param_order as 'paramOrder',scmnWorkFlowParam.param_mandatory as 'paramMandatory',scmnWorkFlowParam.param_desc as 'paramDesc', "
			+ "scmnWorkFlowParam.param_default_value as 'paramDefaultValue',scmnWorkFlowParam.param_to_be_stored as 'paramToBeStored',"
			+ "scmnWorkFlowParam.param_to_be_encrypted as 'paramToBeEncrypted',scmnWorkFlowParam.param_to_be_shown as 'paramToBeShown',scmnWorkFlowParam.param_val_to_be_shown as 'paramValToBeShown',scmnWorkFlowParam.param_type_in_workflow as 'paramTypeInWorkflow',scmnWorkFlowParam.delete_flag as 'deleteFlag',scmnWorkFlowParam.created_by as 'createdBy',"
			+ "scmnWorkFlowParam.modified_by as 'modifiedBy',scmnWorkFlowParam.created_date as 'createdDate',scmnWorkFlowParam.modified_date as 'modifiedDate',"
			+ "scmnWorkFlowParam.res_attribute1 as 'resAttribute1',scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',scmnWorkFlowParam.res_attribute2 as 'resAttribute2',scmnWorkFlowParam.res_attribute3 as 'resAttribute3',"
			+"scmnWorkFlowParam.consider_sop_param_dtl as 'considerSopParamDtl',"
			+ "scmnWorkFlowParam.res_attribute4 as 'resAttribute4',scmnWorkFlowParam.res_attribute5 as 'resAttribute5' FROM scmn_workflow_param_lnk scmnWorkFlowParam"
			+ " WHERE wrkflw_id=#{wrkflwId} AND param_to_be_shown = '1' order by paramOrder")
	public List<WorkflowParamLnk> getWorkflowParamListTobeShowToUserByWrkflwId(long wrkflwId);

	@Select("SELECT DISTINCT(scmnWorkFlowParam.param_name) AS 'paramName' FROM scmn_workflow_param_lnk scmnWorkFlowParam JOIN  scmn_sop_workflow_lnk scmnsopworkflowlnk ON scmnWorkFlowParam.wrkflw_id=scmnsopworkflowlnk.wrkflw_id "
			+ "WHERE scmnsopworkflowlnk.sop_id=#{sopId} AND scmnWorkFlowParam.param_name NOT IN (SELECT param_code FROM scmn_sop_param_dtls WHERE sop_id=#{sopId})")
	public List<WorkflowParamLnk> getWorkflwParamCodeListBySOPId(SopDetails sopDetails);

	@Select("SELECT COUNT(param_name) FROM scmn_workflow_param_lnk WHERE param_name=#{paramName} AND wrkflw_id=#{wrkflwId} AND wrkflw_param_lnk_id!=#{wrkflwParamLnkId}")
	public int validateWorkflowParamName(WorkflowParamLnk workflowParamLnk);

	@Insert("INSERT INTO scmn_workflow_param_lnk(wrkflw_id,param_name,param_code,param_validation,param_order,param_mandatory,param_default_value,param_to_be_stored,param_to_be_encrypted,param_to_be_shown,param_val_to_be_shown,param_type_in_workflow,created_date,consider_sop_param_dtl,delete_flag,created_by,param_desc,param_type) "
			+ "VALUES (#{wrkflwId},#{paramName},#{paramCode},#{paramValidation},#{paramOrder},#{paramMandatory},#{paramDefaultValue},#{paramToBeStored},#{paramToBeEncrypted},#{paramToBeShown},#{paramValToBeShown},#{paramTypeInWorkflow},CURRENT_TIMESTAMP(),#{considerSopParamDtl},#{deleteFlag},#{createdBy},#{paramDesc},#{paramType})")
	public void addWrkflwParamDtls(WorkflowParamLnk workflowParamLnk);
	
	@Update("UPDATE scmn_workflow_param_lnk SET param_name=#{paramName},param_code=#{paramCode},param_validation=#{paramValidation},param_order=#{paramOrder},param_mandatory=#{paramMandatory},param_default_value=#{paramDefaultValue},param_to_be_stored=#{paramToBeStored},param_to_be_encrypted=#{paramToBeEncrypted},param_to_be_shown=#{paramToBeShown},"
			+ "param_val_to_be_shown=#{paramValToBeShown},param_type_in_workflow=#{paramTypeInWorkflow},modified_date=CURRENT_TIMESTAMP(),consider_sop_param_dtl=#{considerSopParamDtl},delete_flag=#{deleteFlag},modified_by=#{modifiedBy},param_desc=#{paramDesc},param_type=#{paramType} WHERE wrkflw_param_lnk_id=#{wrkflwParamLnkId}")
	public void updateWrkflwparamDtls(WorkflowParamLnk workflowParamLnk);

	
	
	
}
