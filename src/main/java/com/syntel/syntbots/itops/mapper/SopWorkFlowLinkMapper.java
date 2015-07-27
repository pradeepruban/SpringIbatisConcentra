/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.syntel.syntbots.itops.dto.SopWrkflwLnk;
import com.syntel.syntbots.itops.dto.WorkflowDetails;

/**
*This interface contains all the mappers related to SOP workflow link Details.
*@author Syntel
*@version 1.0
*/
public interface SopWorkFlowLinkMapper {

	/**
	 *This method is used to get list of workflow details based on SOP Id
	 * @param SOP Id
	 * @return list of workflow details
	 */
	@Select("SELECT swd.wrkflw_id AS 'wrkflwId',swd.wrkflw_name AS 'wrkflwName',swd.wrkflw_desc AS wrkflwDesc,swd.wrkflw_url AS wrkflwUrl,"
			+ "swd.wrkflw_version AS wrkflwVersion,swd.wrkflw_deployment_id AS wrkflwDeploymentId,swd.wrkflw_decomision_date AS wrkflwDecomisionDate,"
			+ "swd.wrkflw_listen_queue AS wrkflwListenQueue,swd.delete_flag AS deleteFlag,swd.created_by AS createdBy,swd.modified_by AS modifiedBy,"
			+ "swd.created_date AS createdDate,swd.modified_date AS modifiedDate,swd.wrkflw_definition_id AS wrkflwDefinitionId,"
			+ "swd.wrkflw_userName AS wrkflwUserName,swd.wrkflw_password AS wrkflwPassword,"
			+ "swd.res_attribute1 AS resAttribute1,swd.res_attribute2 AS resAttribute2,swd.res_attribute3 AS resAttribute3,"
			+ "swd.res_attribute4 AS resAttribute4,swd.res_attribute5 AS resAttribute5"
			+ " FROM scmn_workflow_dtls swd JOIN scmn_sop_workflow_lnk  swl ON  swl.wrkflw_id =swd.wrkflw_id JOIN scmn_sop_dtls sop ON sop.sop_id=swl.sop_id WHERE sop.sop_id=#{sopId}")
	List<WorkflowDetails> getWorkFlowListBySopId(int sopId);

	/**
	 *This method is used to get list of SOP workflow link details
	 * @return list of SOP workflow link details
	 */
	@Select("SELECT sopWrkflwLnk.sop_id as 'sopId',sopWrkflwLnk.wrkflw_id as 'workFlowId',sopWrkflwLnk.default_flag as 'sopWrkflwLnkDefaultFlag',sopWrkflwLnk.delete_flag as 'sopWrkflwLnkDeleteFlag',"
			+ "sopWrkflwLnk.created_by as 'sopWrkflwLnkCreatedBy',sopWrkflwLnk.modified_by as 'sopWrkflwLnkModifiedBy',"
			+ "sopWrkflwLnk.created_date as 'sopWrkflwLnkCreatedDate',DATE_FORMAT(sopWrkflwLnk.created_date,'%d %b %Y %T') AS 'strSopWrkflwLnkCreatedDate',"
			+ "sopWrkflwLnk.modified_date as 'sopWrkflwLnkModifiedDate',DATE_FORMAT(sopWrkflwLnk.modified_date,'%d %b %Y %T') AS 'strSopWrkflwLnkModifiedDate',"
			+ "sopWrkflwLnk.res_attribute1 as 'resAttribute1',sopWrkflwLnk.res_attribute2 as 'resAttribute2',"
			+ "sopWrkflwLnk.res_attribute3 as 'resAttribute3',sopWrkflwLnk.res_attribute4 as 'resAttribute4',"
			+ "sopWrkflwLnk.res_attribute5 as 'resAttribute5' FROM scmn_sop_workflow_lnk sopWrkflwLnk ")
	List<SopWrkflwLnk> getCompleteSopWorkflowLnkList();
	
	/**
	 *This method is used to get workflow name based on workflow Id
	 * @param workflow Id
	 * @return  workflow name
	 */
	@Select("SELECT wrkflw_name FROM scmn_workflow_dtls where wrkflw_id = #{workfLowId}")
	String getWorkFlowNameByWorkflowId(long workfLowId);
	

}
