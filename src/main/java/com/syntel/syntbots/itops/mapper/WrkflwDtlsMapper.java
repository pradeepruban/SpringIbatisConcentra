/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.syntel.syntbots.itops.dto.WorkflowDetails;

/**
*This interface contains all the mappers related to WorkFlow Details.
*@author Syntel
*@version 1.0
*/
public interface WrkflwDtlsMapper {

	/**
	 *This method is used to get list of WorkFlow details 
	 *@return list of Workflow details
	*/
	@Select("SELECT scmnWorkFlow.wrkflw_id AS 'wrkflwId',scmnWorkFlow.wrkflw_name AS 'wrkflwName',"
			+ "scmnWorkFlow.wrkflw_desc AS 'wrkflwDesc',scmnWorkFlow.wrkflw_url AS 'wrkflwUrl',"
			+ "scmnWorkFlow.wrkflw_version AS 'wrkflwVersion',scmnWorkFlow.wrkflw_deployment_id AS 'wrkflwDeploymentId',"
			+ "DATE_FORMAT(scmnWorkFlow.wrkflw_decomision_date,'%d %b %Y %T') AS strDecomisionDate,"
			+ "scmnWorkFlow.wrkflw_decomision_date AS 'wrkflwDecomisionDate',scmnWorkFlow.wrkflw_listen_queue AS 'wrkflwListenQueue',"
			+ "scmnWorkFlow.delete_flag AS 'deleteFlag',scmnWorkFlow.created_by AS 'createdBy',users.usr_short_name AS createdByUserName,"
			+ "scmnWorkFlow.modified_by AS 'modifiedBy',(SELECT usrDtls.usr_first_name FROM scmn_user_dtls usrDtls WHERE usrDtls.usr_id = scmnWorkFlow.modified_by) AS modifiedByUserName,"
			+ "scmnWorkFlow.created_date AS 'createdDate',DATE_FORMAT(scmnWorkFlow.created_date,'%d %b %Y %T') AS strCreatedDate,"
			+ "scmnWorkFlow.modified_date AS 'modifiedDate',DATE_FORMAT(scmnWorkFlow.modified_date,'%d %b %Y %T') AS strModifiedDate,"
			+ "scmnWorkFlow.res_attribute1 AS 'resAttribute1',"
			+ "scmnWorkFlow.res_attribute2 AS 'resAttribute2',scmnWorkFlow.res_attribute3 AS 'resAttribute3',scmnWorkFlow.res_attribute4 AS 'resAttribute4',"
			+ "scmnWorkFlow.res_attribute5 AS 'resAttribute5',scmnWorkFlow.wrkflw_definition_id AS 'wrkflwDefinitionId',"
			+ "scmnWorkFlow.wrkflw_userName AS 'wrkflwUsername',scmnWorkFlow.wrkflw_password AS 'wrkflwPassword' FROM scmn_workflow_dtls scmnWorkFlow,scmn_user_dtls users "
			+ "WHERE scmnWorkFlow.created_by=users.usr_id")
	public List<WorkflowDetails> getWrkflwDtlsList();
	
	/**
	 *This method is used to get WorkFlow details 
	 *@param Workflow details
	 *@return Workflow details
	*/
	@Select("SELECT scmnWorkFlow.wrkflw_id as 'wrkflwId',scmnWorkFlow.wrkflw_name as 'wrkflwName',scmnWorkFlow.wrkflw_desc as 'wrkflwDesc',"
			+ "scmnWorkFlow.wrkflw_url as 'wrkflwUrl',scmnWorkFlow.wrkflw_version as 'wrkflwVersion',scmnWorkFlow.wrkflw_deployment_id as 'wrkflwDeploymentId',"
			+ "scmnWorkFlow.wrkflw_decomision_date as 'wrkflwDecomisionDate',scmnWorkFlow.wrkflw_listen_queue as 'wrkflwListenQueue',"
			+ "scmnWorkFlow.delete_flag as 'deleteFlag',scmnWorkFlow.created_by as 'createdBy',scmnWorkFlow.modified_by as 'modifiedBy',"
			+ "scmnWorkFlow.created_date as 'createdDate',scmnWorkFlow.modified_date as 'modifiedDate',scmnWorkFlow.res_attribute1 as 'resAttribute1',"
			+ "scmnWorkFlow.res_attribute2 as 'resAttribute2',scmnWorkFlow.res_attribute3 as 'resAttribute3',scmnWorkFlow.res_attribute4 as 'resAttribute4',"
			+ "scmnWorkFlow.res_attribute5 as 'resAttribute5',scmnWorkFlow.wrkflw_definition_id as 'wrkflwDefinitionId',"
			+ "scmnWorkFlow.wrkflw_userName as 'wrkflwUsername', AES_DECRYPT(scmnWorkFlow.wrkflw_password, 'SyntBots_Passwrd') as 'wrkflwPassword' "
			+ "FROM scmn_workflow_dtls scmnWorkFlow  WHERE wrkflw_id=#{wrkflwId}")
	public WorkflowDetails getWorkFlowDtls(WorkflowDetails workflowDtls);

	/**
	 *This method is used to get WorkFlow details by workflow name
	 *@param Workflow details
	 *@return Workflow details
	*/
	@Select("SELECT scmnWorkFlow.wrkflw_id AS 'wrkflwId',scmnWorkFlow.wrkflw_name AS 'wrkflwName',"
			+ "scmnWorkFlow.wrkflw_desc AS 'wrkflwDesc',scmnWorkFlow.wrkflw_url AS 'wrkflwUrl',"
			+ "scmnWorkFlow.wrkflw_version AS 'wrkflwVersion',scmnWorkFlow.wrkflw_deployment_id AS 'wrkflwDeploymentId',"
			+ "DATE_FORMAT(scmnWorkFlow.wrkflw_decomision_date,'%d %b %Y %T') AS strDecomisionDate,"
			+ "scmnWorkFlow.wrkflw_decomision_date AS 'wrkflwDecomisionDate',scmnWorkFlow.wrkflw_listen_queue AS 'wrkflwListenQueue',"
			+ "scmnWorkFlow.delete_flag AS 'deleteFlag',scmnWorkFlow.created_by AS 'createdBy',users.usr_short_name AS createdByUserName,"
			+ "scmnWorkFlow.modified_by AS 'modifiedBy',(SELECT usrDtls.usr_first_name FROM scmn_user_dtls usrDtls WHERE usrDtls.usr_id = scmnWorkFlow.modified_by) AS modifiedByUserName,"
			+ "scmnWorkFlow.created_date AS 'createdDate',DATE_FORMAT(scmnWorkFlow.created_date,'%d %b %Y %T') AS strCreatedDate,"
			+ "scmnWorkFlow.modified_date AS 'modifiedDate',DATE_FORMAT(scmnWorkFlow.modified_date,'%d %b %Y %T') AS strModifiedDate,"
			+ "scmnWorkFlow.res_attribute1 AS 'resAttribute1',"
			+ "scmnWorkFlow.res_attribute2 AS 'resAttribute2',scmnWorkFlow.res_attribute3 AS 'resAttribute3',scmnWorkFlow.res_attribute4 AS 'resAttribute4',"
			+ "scmnWorkFlow.res_attribute5 AS 'resAttribute5',scmnWorkFlow.wrkflw_definition_id AS 'wrkflwDefinitionId',"
			+ "scmnWorkFlow.wrkflw_userName AS 'wrkflwUsername',scmnWorkFlow.wrkflw_password AS 'wrkflwPassword' FROM scmn_workflow_dtls scmnWorkFlow,scmn_user_dtls users "
			+ "WHERE scmnWorkFlow.created_by=users.usr_id AND scmnWorkFlow.wrkflw_name=#{wrkflwName}")
	public WorkflowDetails getWrkflwDtlsByWrkflwName(WorkflowDetails workflowDtls);

	@Select("SELECT COUNT(wrkflw_name) FROM scmn_workflow_dtls WHERE wrkflw_name=#{wrkflwName} AND wrkflw_id!=#{wrkflwId}")
	public int validateWrkflwName(WorkflowDetails workflowDtls);

	@Insert("INSERT INTO scmn_workflow_dtls(wrkflw_name,wrkflw_desc,wrkflw_url,wrkflw_version,wrkflw_deployment_id,wrkflw_decomision_date,wrkflw_listen_queue,delete_flag,created_by,created_date,modified_date,wrkflw_definition_id,wrkflw_userName,wrkflw_password)"
					+ " VALUES (#{wrkflwName},#{wrkflwDesc},#{wrkflwUrl},#{wrkflwVersion},#{wrkflwDeploymentId},#{wrkflwDecomisionDate},#{wrkflwListenQueue},#{deleteFlag},#{createdBy},CURRENT_TIMESTAMP(),#{modifiedDate},#{wrkflwDefinitionId},#{wrkflwUsername},#{wrkflwPassword})")
	public void addWrkflwDtls(WorkflowDetails workflowDtls);

	@Update("UPDATE scmn_workflow_dtls SET wrkflw_name=#{wrkflwName},wrkflw_desc=#{wrkflwDesc},wrkflw_url=#{wrkflwUrl},wrkflw_version=#{wrkflwVersion},"
			+ "wrkflw_deployment_id=#{wrkflwDeploymentId},wrkflw_decomision_date=#{wrkflwDecomisionDate},wrkflw_listen_queue=#{wrkflwListenQueue},delete_flag=#{deleteFlag},"
			+ "modified_by=#{modifiedBy},modified_date=CURRENT_TIMESTAMP(),wrkflw_definition_id=#{wrkflwDefinitionId},wrkflw_userName=#{wrkflwUsername},wrkflw_password=#{wrkflwPassword}"
			+ " WHERE wrkflw_id=#{wrkflwId}")
	public void updateWrkflwDtls(WorkflowDetails workflowDtls);

	
	

}
