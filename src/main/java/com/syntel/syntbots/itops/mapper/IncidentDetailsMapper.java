/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;

/**
*This interface contains all the mappers related to Incident Details.
*@author Syntel
*@version 1.0
*/


public interface IncidentDetailsMapper {

	
	/*
	@Select("SELECT incdnts.incident_dtls_id as 'incdntDtlsId',incdnts.incident_id as 'incdntId',incdnts.incident_appln_name as 'incdntAppName',"
			+ "incdnts.incident_short_desc as 'incdntSrtDsc',incdnts.incident_category as 'incdntCtgory',incdnts.incident_priority as 'incdntPriority',"
			+ "incdnts.incident_state as 'incdntState',incdnts.incident_assgnmnt_group as 'incdntAssgnmntGrp',incdnts.incident_assigned_to as 'incdntAssgndTo',"
			+ "incdnts.incident_status as 'incdntStatus',incdnts.actual_elapsed_time as 'incdntActlElapsdTime',incdnts.incident_desc as 'incdntDesc',"
			+ "incdnts.delete_flag as 'incdntDltFlag',incdnts.created_date as 'incdntcreatedDate',incdnts.modified_date as 'incdntmodifiedDate',"
			+ "incdnts.incident_original_severity as 'incidentOriginalSeverity',incdnts.incident_opened_date as 'incidentOpenedDate',incdnts.incident_closed_date as 'incidentClosedDate', incdnts.incident_made_sla as 'incidentMadeSla',"
			+ "incdnts.created_by as 'incdntcreatedBy',incdnts.modified_by as 'incdntmodifiedBy',incdnts.res_attribute1 as 'incdntrstAttr1',incdnts.res_attribute2 as 'incdntrstAttr2',"
			+ "incdnts.res_attribute3 as'incdntrstAttr3',incdnts.res_attribute4 as 'incdntrstAttr4',incdnts.res_attribute5 as'incdntrstAttr5' FROM scmn_incident_dtls incdnts, scmn_user_dtls usrDtls "
			+ " WHERE incdnts.incident_assigned_to=usrDtls.usr_short_name AND usrDtls.usr_id=#{usrId} ")*/
	
	//Mapper query for getting incident list based on user logged in
	
	 /**
	 *This method is used to get list of incident details for user
	 * @param user details
	 * @return list of incident details
	 */
	@Select("SELECT incdnts.incident_dtls_id AS 'incdntDtlsId',incdnts.incident_id AS 'incdntId',"
			+ "incdnts.incident_appln_name AS 'incdntAppName',incdnts.incident_short_desc AS 'incdntSrtDsc',"
			+ "incdnts.incident_category AS 'incdntCtgory',incdnts.incident_priority AS 'incdntPriority',"
			+ "incdnts.incident_state AS 'incdntState',incdnts.incident_assgnmnt_group AS 'incdntAssgnmntGrp',"
			+ "incdnts.incident_assigned_to AS 'incdntAssgndTo',incdnts.incident_status AS 'incdntStatus',"
			+ "incdnts.actual_elapsed_time AS 'incdntActlElapsdTime',incdnts.incident_desc AS 'incdntDesc',"
			+ "incdnts.delete_flag AS 'incdntDltFlag',incdnts.created_date AS 'incdntcreatedDate',"
			+ "incdnts.modified_date AS 'incdntmodifiedDate',incdnts.incident_original_severity AS 'incidentOriginalSeverity',"
			+ " DATE_FORMAT(incdnts.incident_opened_date,'%d %b %Y %T') AS 'strIncidentOpenedDate'," 
			+ "incdnts.incident_opened_date AS 'incidentOpenedDate',incdnts.incident_closed_date AS 'incidentClosedDate',"
			+ "incdnts.incident_made_sla AS 'incidentMadeSla',incdnts.created_by AS 'incdntcreatedBy',"
			+ "incdnts.modified_by AS 'incdntmodifiedBy',incdnts.res_attribute1 AS 'incdntrstAttr1',"
			+ "incdnts.res_attribute2 AS 'incdntrstAttr2',incdnts.res_attribute3 AS 'incdntrstAttr3',"
			+ "incdnts.res_attribute4 AS 'incdntrstAttr4',incdnts.res_attribute5 AS 'incdntrstAttr5',"
			+ "(SELECT incExecDtlsInner1.incident_exec_status FROM scmn_incident_exec_dtls incExecDtlsInner1 WHERE incExecDtlsInner1.incident_exec_id IN "
			+ "(SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2 WHERE incExecDtlsInner2.incident_id = incdnts.incident_id))"
			+ " AS 'incidentExecStatus',"
			+ "(SELECT DATE_FORMAT(incExecDtlsInner1.incident_exec_start_date,'%d %b %Y %T') FROM scmn_incident_exec_dtls incExecDtlsInner1 WHERE incExecDtlsInner1.incident_exec_id IN "
			+ "(SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2 WHERE incExecDtlsInner2.incident_id = incdnts.incident_id))"
			+ " AS 'strExecStartDate'"
			+ " FROM scmn_incident_dtls incdnts " 
			+ " INNER JOIN scmn_application_dtls applnDtls ON applnDtls.appln_name=incdnts.incident_appln_name and applnDtls.delete_flag='0' "
			+ " INNER JOIN scmn_queue_dtls queDtls ON queDtls.que_name=incdnts.incident_assgnmnt_group  and queDtls.delete_flag='0' "
			+ " INNER JOIN scmn_user_appln_queue_lnk usrApplnQueLnk ON usrApplnQueLnk.que_id = queDtls.que_id and usrApplnQueLnk.appln_id = applnDtls.appln_id and usrApplnQueLnk.to_view='1' and usrApplnQueLnk.delete_flag='0' "			
			+ " WHERE  usrApplnQueLnk.usr_id=#{usrId} AND LOWER(incdnts.incident_state) in ('active', 'new', 'open') ")
	List<IncidentDetails> getIncidentListForUser(UserDetails userDetails);
	
	//changed to all incidents
	/*@Select("SELECT incdnts.incident_dtls_id AS 'incdntDtlsId',incdnts.incident_id AS 'incdntId',"
			+ "incdnts.incident_appln_name AS 'incdntAppName',incdnts.incident_short_desc AS 'incdntSrtDsc',"
			+ "incdnts.incident_category AS 'incdntCtgory',incdnts.incident_priority AS 'incdntPriority',"
			+ "incdnts.incident_state AS 'incdntState',incdnts.incident_assgnmnt_group AS 'incdntAssgnmntGrp',"
			+ "incdnts.incident_assigned_to AS 'incdntAssgndTo',incdnts.incident_status AS 'incdntStatus',"
			+ "incdnts.actual_elapsed_time AS 'incdntActlElapsdTime',incdnts.incident_desc AS 'incdntDesc',"
			+ "incdnts.delete_flag AS 'incdntDltFlag',incdnts.created_date AS 'incdntcreatedDate',"
			+ "incdnts.modified_date AS 'incdntmodifiedDate',incdnts.incident_original_severity AS 'incidentOriginalSeverity',"
			+ " DATE_FORMAT(incdnts.incident_opened_date,'%d %b %Y %T') AS 'strIncidentOpenedDate'," 
			+ "incdnts.incident_opened_date AS 'incidentOpenedDate',incdnts.incident_closed_date AS 'incidentClosedDate',"
			+ "incdnts.incident_made_sla AS 'incidentMadeSla',incdnts.created_by AS 'incdntcreatedBy',"
			+ "incdnts.modified_by AS 'incdntmodifiedBy',incdnts.res_attribute1 AS 'incdntrstAttr1',"
			+ "incdnts.res_attribute2 AS 'incdntrstAttr2',incdnts.res_attribute3 AS 'incdntrstAttr3',"
			+ "incdnts.res_attribute4 AS 'incdntrstAttr4',incdnts.res_attribute5 AS 'incdntrstAttr5',"
			+ "(SELECT incExecDtlsInner1.incident_exec_status FROM scmn_incident_exec_dtls incExecDtlsInner1 WHERE incExecDtlsInner1.incident_exec_id IN "
			+ "(SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2 WHERE incExecDtlsInner2.incident_id = incdnts.incident_id))"
			+ " AS 'incidentExecStatus',"
			+ "(SELECT DATE_FORMAT(incExecDtlsInner1.incident_exec_start_date,'%d %b %Y %T') FROM scmn_incident_exec_dtls incExecDtlsInner1 WHERE incExecDtlsInner1.incident_exec_id IN "
			+ "(SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2 WHERE incExecDtlsInner2.incident_id = incdnts.incident_id))"
			+ " AS 'strExecStartDate'"
			+ " FROM scmn_incident_dtls incdnts "
			+ " WHERE LOWER(incdnts.incident_state) in ('active', 'new', 'open') ")*/
	


	 /**
	 *This method is used to get incident details by incident details Id
	 * @param incident details Id
	 * @return incident details
	 */
	@Select("SELECT incdnts.incident_dtls_id as 'incdntDtlsId',incdnts.incident_id as 'incdntId',incdnts.incident_appln_name as 'incdntAppName',"
			+ "incdnts.incident_short_desc as 'incdntSrtDsc',incdnts.incident_category as 'incdntCtgory',incdnts.incident_priority as 'incdntPriority',"
			+ "incdnts.incident_state as 'incdntState',incdnts.incident_assgnmnt_group as 'incdntAssgnmntGrp',incdnts.incident_assigned_to as 'incdntAssgndTo',"
			+ "incdnts.incident_status as 'incdntStatus',incdnts.actual_elapsed_time as 'incdntActlElapsdTime',incdnts.incident_desc as 'incdntDesc',"
			+ "incdnts.delete_flag as 'incdntDltFlag',incdnts.created_date as 'incdntcreatedDate',incdnts.modified_date as 'incdntmodifiedDate',"
			+ "incdnts.incident_original_severity as 'incidentOriginalSeverity',incdnts.incident_opened_date as 'incidentOpenedDate',"
			+ " DATE_FORMAT(incdnts.incident_opened_date,'%d %b %Y %T') AS 'strIncidentOpenedDate'," 
			+ "incdnts.incident_closed_date as 'incidentClosedDate', incdnts.incident_made_sla as 'incidentMadeSla',"
			+ "incdnts.created_by as 'incdntcreatedBy',incdnts.modified_by as 'incdntmodifiedBy',incdnts.res_attribute1 as 'incdntrstAttr1',incdnts.res_attribute2 as 'incdntrstAttr2',"
			+ "incdnts.res_attribute3 as'incdntrstAttr3',incdnts.res_attribute4 as 'incdntrstAttr4',incdnts.res_attribute5 as'incdntrstAttr5' FROM scmn_incident_dtls incdnts WHERE incdnts.incident_dtls_id=#{incdntDtlsId}")
	IncidentDetails getIncidentById(Integer incdntDtlsId);


	/**
	 *This method is used to get list of workflow details based on SOP name
	 * @param sop name
	 * @return list of workflow details
	*/
	@Select("SELECT swd.wrkflw_id as 'wrkflwId', swd.wrkflw_name as 'wrkflwName' FROM scmn_workflow_dtls swd JOIN scmn_sop_workflow_lnk  swl ON  swl.wrkflw_id =swd.wrkflw_id JOIN  scmn_sop_dtls sop ON sop.sop_id=swl.sop_id WHERE sop.sop_name=#{sopnm}") 
	List<WorkflowDetails> getWorkflowname(String sopnm);
	
	/**
	 *This method is used to get list of workflow param details based on workflow Id
	 * @param workflow Id
	 * @return list of workflow param link details
	*/
	 @Select("SELECT param_name As paramName FROM scmn_workflow_param_lnk WHERE wrkflw_id =#{workFlowID} ORDER BY param_order  ASC")
	 List<WorkflowParamLnk> getParamValues(int workFlowID);

	 /**
		 *This method is used to get workflow name based workflow Id
		 * @param workflow name
		 * @return  workflow Id
		*/
	 @Select("SELECT wrkflw_id As workFlowID FROM scmn_workflow_dtls WHERE wrkflw_name =#{workflowName}")
	int getWorkflowId(String workflowName);


	 /**
		 *This method is used to get number of open incidents for logged in user
		 * @param userdetails
		 * @return  number of open incidents
		*/
	@Select("SELECT COUNT(incdnts.incident_dtls_id) AS openIncidents " 
			+ " FROM scmn_incident_dtls incdnts " 
			+ " INNER JOIN scmn_application_dtls applnDtls ON applnDtls.appln_name=incdnts.incident_appln_name and applnDtls.delete_flag='0' "
			+ " INNER JOIN scmn_queue_dtls queDtls ON queDtls.que_name=incdnts.incident_assgnmnt_group  and queDtls.delete_flag='0' "
			+ " INNER JOIN scmn_user_appln_queue_lnk usrApplnQueLnk ON usrApplnQueLnk.que_id = queDtls.que_id and usrApplnQueLnk.appln_id = applnDtls.appln_id and usrApplnQueLnk.to_view='1' and usrApplnQueLnk.delete_flag='0' "
			+ " WHERE  usrApplnQueLnk.usr_id=#{usrId} AND  LOWER(incdnts.incident_state) in ('active', 'new', 'open')")
	 int getOpenIncidentsForLoggedInUser(UserDetails userDetails);

	/**
	 *This method is used to get number of severe incidents for logged in user
	 * @param userdetails
	 * @return  number of severe incidents
	*/
	 @Select("SELECT COUNT(incdnts.incident_dtls_id) AS openIncidents " 
				+ " FROM scmn_incident_dtls incdnts " 
				+ " INNER JOIN scmn_application_dtls applnDtls ON applnDtls.appln_name=incdnts.incident_appln_name and applnDtls.delete_flag='0' "
				+ " INNER JOIN scmn_queue_dtls queDtls ON queDtls.que_name=incdnts.incident_assgnmnt_group  and queDtls.delete_flag='0' "
				+ " INNER JOIN scmn_user_appln_queue_lnk usrApplnQueLnk ON usrApplnQueLnk.que_id = queDtls.que_id and usrApplnQueLnk.appln_id = applnDtls.appln_id and usrApplnQueLnk.to_view='1' and usrApplnQueLnk.delete_flag='0' "
				+ " WHERE  usrApplnQueLnk.usr_id=#{usrId} AND LOWER(incdnts.incident_original_severity) = 'sev1' AND  LOWER(incdnts.incident_state) in ('active', 'new', 'open') ")
	 int getsevereIncidentsForLoggedInUser(UserDetails userDetails);
	
	 
	 /**
		 *This method is used to get list of closed incident details
		 * @param user details
		 * @return list of closed incident details
		 */
	 @Select("SELECT incdnts.incident_dtls_id AS 'incdntDtlsId',incdnts.incident_id AS 'incdntId',"
				+ "incdnts.incident_appln_name AS 'incdntAppName',incdnts.incident_short_desc AS 'incdntSrtDsc',"
				+ "incdnts.incident_category AS 'incdntCtgory',incdnts.incident_priority AS 'incdntPriority',"
				+ "incdnts.incident_state AS 'incdntState',incdnts.incident_assgnmnt_group AS 'incdntAssgnmntGrp',"
				+ "incdnts.incident_assigned_to AS 'incdntAssgndTo',incdnts.incident_status AS 'incdntStatus',"
				+ "incdnts.actual_elapsed_time AS 'incdntActlElapsdTime',incdnts.incident_desc AS 'incdntDesc',"
				+ "incdnts.delete_flag AS 'incdntDltFlag',incdnts.created_date AS 'incdntcreatedDate',"
				+ "incdnts.modified_date AS 'incdntmodifiedDate',incdnts.incident_original_severity AS 'incidentOriginalSeverity',"
				+ " DATE_FORMAT(incdnts.incident_opened_date,'%d %b %Y %T') AS 'strIncidentOpenedDate'," 
				+ " DATE_FORMAT(incdnts.incident_closed_date,'%d %b %Y %T') AS 'strIncidentClosedDate'," 
				+ "incdnts.incident_opened_date AS 'incidentOpenedDate',incdnts.incident_closed_date AS 'incidentClosedDate',"
				+ "incdnts.incident_made_sla AS 'incidentMadeSla',incdnts.created_by AS 'incdntcreatedBy',"
				+ "incdnts.modified_by AS 'incdntmodifiedBy',incdnts.res_attribute1 AS 'incdntrstAttr1',"
				+ "incdnts.res_attribute2 AS 'incdntrstAttr2',incdnts.res_attribute3 AS 'incdntrstAttr3',"
				+ "incdnts.res_attribute4 AS 'incdntrstAttr4',incdnts.res_attribute5 AS 'incdntrstAttr5',"
				+ "(SELECT incExecDtlsInner1.incident_exec_status FROM scmn_incident_exec_dtls incExecDtlsInner1"
				+ " WHERE incExecDtlsInner1.incident_exec_id IN (SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2"
				+ " WHERE incExecDtlsInner2.incident_id = incdnts.incident_id)) AS 'incidentExecStatus',"
				+ "(SELECT incExecDtlsInner1.incident_exec_remarks FROM scmn_incident_exec_dtls incExecDtlsInner1"
				+ " WHERE incExecDtlsInner1.incident_exec_id IN (SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2"
				+ " WHERE incExecDtlsInner2.incident_id = incdnts.incident_id)) AS 'incidentExecRemarks',"
				+ "(SELECT DATE_FORMAT(incExecDtlsInner1.incident_exec_start_date,'%d %b %Y %T') FROM scmn_incident_exec_dtls incExecDtlsInner1 WHERE incExecDtlsInner1.incident_exec_id IN "
				+ "(SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2 WHERE incExecDtlsInner2.incident_id = incdnts.incident_id))"
				+ " AS 'strExecStartDate'"
				+ " FROM scmn_incident_dtls incdnts "				 
				+ " INNER JOIN scmn_application_dtls applnDtls ON applnDtls.appln_name=incdnts.incident_appln_name and applnDtls.delete_flag='0' "
				+ " INNER JOIN scmn_queue_dtls queDtls ON queDtls.que_name=incdnts.incident_assgnmnt_group  and queDtls.delete_flag='0' "
				+ " INNER JOIN scmn_user_appln_queue_lnk usrApplnQueLnk ON usrApplnQueLnk.que_id = queDtls.que_id and usrApplnQueLnk.appln_id = applnDtls.appln_id and usrApplnQueLnk.to_view='1' and usrApplnQueLnk.delete_flag='0' "			
				+ " WHERE  usrApplnQueLnk.usr_id=#{usrId} AND LOWER(incdnts.incident_state) not in ('active', 'new', 'open') ")				
	List<IncidentDetails> getClosedIncidentList(UserDetails userDetails);
	
	 @Select("SELECT incdnts.incident_dtls_id AS 'incdntDtlsId',incdnts.incident_id AS 'incdntId',"
				+ "incdnts.incident_appln_name AS 'incdntAppName',incdnts.incident_short_desc AS 'incdntSrtDsc',"
				+ "incdnts.incident_category AS 'incdntCtgory',incdnts.incident_priority AS 'incdntPriority',"
				+ "incdnts.incident_state AS 'incdntState',incdnts.incident_assgnmnt_group AS 'incdntAssgnmntGrp',"
				+ "incdnts.incident_assigned_to AS 'incdntAssgndTo',incdnts.incident_status AS 'incdntStatus',"
				+ "incdnts.actual_elapsed_time AS 'incdntActlElapsdTime',incdnts.incident_desc AS 'incdntDesc',"
				+ "incdnts.delete_flag AS 'incdntDltFlag',incdnts.created_date AS 'incdntcreatedDate',"
				+ "incdnts.modified_date AS 'incdntmodifiedDate',incdnts.incident_original_severity AS 'incidentOriginalSeverity',"
				+ " DATE_FORMAT(incdnts.incident_opened_date,'%d %b %Y %T') AS 'strIncidentOpenedDate'," 
				+ " DATE_FORMAT(incdnts.incident_closed_date,'%d %b %Y %T') AS 'strIncidentClosedDate'," 
				+ "incdnts.incident_opened_date AS 'incidentOpenedDate',incdnts.incident_closed_date AS 'incidentClosedDate',"
				+ "incdnts.incident_made_sla AS 'incidentMadeSla',incdnts.created_by AS 'incdntcreatedBy',"
				+ "incdnts.modified_by AS 'incdntmodifiedBy',incdnts.res_attribute1 AS 'incdntrstAttr1',"
				+ "incdnts.res_attribute2 AS 'incdntrstAttr2',incdnts.res_attribute3 AS 'incdntrstAttr3',"
				+ "incdnts.res_attribute4 AS 'incdntrstAttr4',incdnts.res_attribute5 AS 'incdntrstAttr5',"
				+ "(SELECT incExecDtlsInner1.incident_exec_status FROM scmn_incident_exec_dtls incExecDtlsInner1"
				+ " WHERE incExecDtlsInner1.incident_exec_id IN (SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2"
				+ " WHERE incExecDtlsInner2.incident_id = incdnts.incident_id)) AS 'incidentExecStatus',"
				+ "(SELECT incExecDtlsInner1.incident_exec_remarks FROM scmn_incident_exec_dtls incExecDtlsInner1"
				+ " WHERE incExecDtlsInner1.incident_exec_id IN (SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2"
				+ " WHERE incExecDtlsInner2.incident_id = incdnts.incident_id)) AS 'incidentExecRemarks',"
				+ "(SELECT DATE_FORMAT(incExecDtlsInner1.incident_exec_start_date,'%d %b %Y %T') FROM scmn_incident_exec_dtls incExecDtlsInner1 WHERE incExecDtlsInner1.incident_exec_id IN "
				+ "(SELECT MAX(incExecDtlsInner2.incident_exec_id) FROM scmn_incident_exec_dtls incExecDtlsInner2 WHERE incExecDtlsInner2.incident_id = incdnts.incident_id))"
				+ " AS 'strExecStartDate'"
				+ " FROM scmn_incident_dtls incdnts "				 
				+ " INNER JOIN scmn_application_dtls applnDtls ON applnDtls.appln_name=incdnts.incident_appln_name and applnDtls.delete_flag='0' "
				+ " INNER JOIN scmn_queue_dtls queDtls ON queDtls.que_name=incdnts.incident_assgnmnt_group  and queDtls.delete_flag='0' "
				+ " INNER JOIN scmn_user_appln_queue_lnk usrApplnQueLnk ON usrApplnQueLnk.que_id = queDtls.que_id and usrApplnQueLnk.appln_id = applnDtls.appln_id and usrApplnQueLnk.to_view='1' and usrApplnQueLnk.delete_flag='0' "			
				+ " WHERE usrApplnQueLnk.usr_id=#{usrId} AND LOWER(incdnts.incident_state) not in ('active', 'new', 'open') AND incdnts.incident_opened_date BETWEEN #{startDate} AND #{endDate}")		

			List<IncidentDetails> getIncidentListByIncidentOpendate(IncidentDetails incidentDetails);

			 
			 
			 @Select("SELECT incdnts.incident_dtls_id as 'incdntDtlsId',incdnts.incident_id as 'incdntId',incdnts.incident_appln_name as 'incdntAppName',"
						+ "incdnts.incident_short_desc as 'incdntSrtDsc',incdnts.incident_category as 'incdntCtgory',incdnts.incident_priority as 'incdntPriority',"
						+ "incdnts.incident_state as 'incdntState',incdnts.incident_assgnmnt_group as 'incdntAssgnmntGrp',incdnts.incident_assigned_to as 'incdntAssgndTo',"
						+ "incdnts.incident_status as 'incdntStatus',incdnts.actual_elapsed_time as 'incdntActlElapsdTime',incdnts.incident_desc as 'incdntDesc',"
						+ "incdnts.delete_flag as 'incdntDltFlag',incdnts.created_date as 'incdntcreatedDate',incdnts.modified_date as 'incdntmodifiedDate',"
						+ "incdnts.incident_original_severity as 'incidentOriginalSeverity',incdnts.incident_opened_date as 'incidentOpenedDate',incdnts.incident_closed_date as 'incidentClosedDate', incdnts.incident_made_sla as 'incidentMadeSla',"
						+ "incdnts.created_by as 'incdntcreatedBy',incdnts.modified_by as 'incdntmodifiedBy',incdnts.res_attribute1 as 'incdntrstAttr1',incdnts.res_attribute2 as 'incdntrstAttr2',"
						+ "incdnts.res_attribute3 as'incdntrstAttr3',incdnts.res_attribute4 as 'incdntrstAttr4',incdnts.res_attribute5 as'incdntrstAttr5' FROM scmn_incident_dtls incdnts where incdnts.incident_dtls_id=#{incdntDtlsId}")
			IncidentDetails getlistIncidentDetailsById(Integer incdntDtlsId);

			 @Select("SELECT  sopdtls.sop_id AS sopId,sopdtls.sop_name AS sopname,execdtls.incident_exec_id AS incidentExecId ," +
			 		"sopdtls.sop_desc AS sopDesc,sopdtls.created_by AS createdby,sopdtls.delete_flag AS deleteFlag,sopdtls.created_by AS createdBy" +
			 		" FROM scmn_sop_dtls sopdtls INNER JOIN scmn_incident_exec_dtls execdtls WHERE execdtls.sop_id=sopdtls.sop_id AND execdtls.incident_id=#{incidentId}")						 
			List<SopDetails> getSopListByIncidentid(String incidentId);

			List<SopDetails> getSopListByIncidentId(String incdntAppName,
					String incdntAssgnmntGrp);

			@Insert("INSERT INTO scmn_incident_dtls(incident_id,incident_appln_name,incident_short_desc,incident_category,incident_original_severity,incident_opened_date,incident_priority,incident_state,incident_assgnmnt_group,incident_assigned_to,incident_status,actual_elapsed_time,incident_desc,incident_made_sla,delete_flag,created_by,created_date)"
					+ " VALUES (#{incdntId},#{incdntAppName},#{incdntSrtDsc},#{incdntCtgory},#{incidentOriginalSeverity},#{incidentOpenedDate},#{incdntPriority},#{incdntState},#{incdntAssgnmntGrp},#{incdntAssgndTo},#{incdntStatus},#{incdntActlElapsdTime},#{incdntDesc},#{incidentMadeSla},0,#{incdntcreatedBy},CURRENT_TIMESTAMP())")
			void saveIncidentDtls(IncidentDetails incidentDetails);

			

			
			
			
			
	
	
	
}
