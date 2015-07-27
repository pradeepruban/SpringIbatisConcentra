/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;

/**
*This interface contains all the mappers related to Incident Execution Details.
*@author Syntel
*@version 1.0
*/
public interface IncdntExecDtlsMapper {	
	
	/**
	 *This method is used to insert incident execution details
	 * @param incident execution details
	 * @return void
	*/
	@Insert("INSERT INTO scmn_incident_exec_dtls(incident_id,usr_id,appln_id,"
			+ "que_id,sop_id,wrkflw_id,incident_exec_start_date,incident_exec_end_date,"
			+ "incident_exec_status,incident_exec_remarks,incident_exec_excp_msg,"
			+ "incident_exec_excp_dtls,incident_exec_excp_stckTrce)"
			+ "VALUES(#{incidentId},#{usrId},#{applnId},#{queId},#{sopId},"
			+ "#{wrkflwId},#{incidentExecStartDate},#{incidentExecEndDate},#{incidentExecStatus},"
			+ "#{incidentExecRemarks},#{incidentExecExcpMsg},#{incidentExecExcpDtls},#{incidentExecExcpStcktrce})")
	 public void insertIncidentExecDtls(IncidentExecDtls incidentExecDtls);
	
	/**
	 *This method is used to get maximum value of incident execution id based on incident Id
	 * @param incident Id
	 * @return incident execution details
	*/
	 @Select("SELECT MAX(incident_exec_id) as incidentExecId FROM scmn_incident_exec_dtls WHERE incident_id=#{incidentId}")
	 public IncidentExecDtls getMaxIncidentExecIdBasedOnIncidentId(IncidentExecDtls incidentExecDtls);
	
	/*@Select("SELECT applctnDtls.appln_id as applnId,applctnDtls.appln_code as applnCode,applctnDtls.appln_name as applnName,applctnDtls.appln_short_desc as applnShortDesc,applctnDtls.appln_desc as applnDesc,applctnDtls.appln_context_path as applnContextPath,applctnDtls.delete_flag as deleteFlag,applctnDtls.created_by as createdBy,applctnDtls.modified_by as modifiedBy,applctnDtls.created_date as createdDate,applctnDtls.modified_date as modifiedDate,applctnDtls.res_attribute1 as resAttribute1,applctnDtls.res_attribute2 as resAttribute2,applctnDtls.res_attribute3 as resAttribute3,applctnDtls.res_attribute4 as resAttribute4,applctnDtls.res_attribute5 as resAttribute5 FROM scmn_application_dtls applctnDtls  WHERE appln_name=#{applnName}")

	public ApplctnDtls getApplctnDtls(ApplctnDtls applctnDtls);
	*/



	/*	@Select("SELECT incdntExecDtls.incident_exec_id as 'incidentExecId',incdntExecDtls.incident_id as 'incidentId',incdntExecDtls.usr_id as 'usrId',"
			+ "(SELECT innerUsrs.usr_short_name FROM scmn_user_dtls innerUsrs WHERE innerUsrs.usr_id = incdntExecDtls.usr_id) AS 'usrName',"
			+ " incdntExecDtls.appln_id as 'applnId',applns.appln_name as 'applnName',incdntExecDtls.que_id as 'queId',queues.que_name as'queName',incdntExecDtls.sop_id as 'sopId',sops.sop_name as 'sopName',"
			+ " incdntExecDtls.wrkflw_id as 'wrkflwId',wrkflws.wrkflw_name as 'wrkflwName',incdntExecDtls.incident_exec_start_date as 'incidentExecStartDate',incdntExecDtls.incident_exec_end_date as 'incidentExecEndDate',"
			+ " DATE_FORMAT(incdntExecDtls.incident_exec_start_date,'%d %b %Y %T') AS 'strIncidentExecStartDate'," 
			+ " DATE_FORMAT(incdntExecDtls.incident_exec_end_date,'%d %b %Y %T') AS 'strIncidentExecEndDate'," 
			+ " incdntExecDtls.incident_exec_status as 'incidentExecStatus',incdntExecDtls.incident_exec_remarks as 'incidentExecRemarks',incdntExecDtls.incident_exec_excp_msg as 'incidentExecExcpMsg',"
			+ " incdntExecDtls.incident_exec_excp_dtls as 'incidentExecExcpDtls',incdntExecDtls.incident_exec_excp_stckTrce as 'incidentExecExcpStcktrce' FROM scmn_incident_exec_dtls incdntExecDtls," 
			+  " scmn_user_dtls usrs ,scmn_application_dtls applns, scmn_queue_dtls queues, scmn_sop_dtls sops, scmn_workflow_dtls wrkflws, scmn_user_appln_queue_lnk usrApplnQueLnk "
			+ " WHERE usrApplnQueLnk.usr_id=#{usrId} AND incdntExecDtls.appln_id=applns.appln_id AND incdntExecDtls.que_id=queues.que_id AND incdntExecDtls.sop_id=sops.sop_id " 
			+ " AND incdntExecDtls.wrkflw_id=wrkflws.wrkflw_id and usrApplnQueLnk.que_id = incdntExecDtls.que_id and usrApplnQueLnk.appln_id = incdntExecDtls.appln_id and usrs.usr_id = usrApplnQueLnk.usr_id " 
			+ " and usrApplnQueLnk.to_view='1' and usrApplnQueLnk.delete_flag='0' ")
	*/
	
    /**
		 *This method is used to get list of incident execution details
		 * @param incident execution details
		 * @return list of incident execution details
	*/
	@Select("SELECT incdntExecDtls.incident_exec_id AS 'incidentExecId',incdntExecDtls.incident_id AS 'incidentId',incdntExecDtls.usr_id AS 'usrId',"
			+"(SELECT innerUsrs.usr_short_name FROM scmn_user_dtls innerUsrs WHERE innerUsrs.usr_id = incdntExecDtls.usr_id) AS 'usrName',"
			+" incdntExecDtls.appln_id AS 'applnId',applns.appln_name AS 'applnName',incdntExecDtls.que_id AS 'queId',queues.que_name AS'queName',incdntExecDtls.sop_id AS 'sopId',sops.sop_name AS 'sopName',"
			+" incdntExecDtls.wrkflw_id AS 'wrkflwId',wrkflws.wrkflw_name AS 'wrkflwName',incdntExecDtls.incident_exec_start_date AS 'incidentExecStartDate',incdntExecDtls.incident_exec_end_date AS 'incidentExecEndDate',"
			+" DATE_FORMAT(incdntExecDtls.incident_exec_start_date,'%d %b %Y %T') AS 'strIncidentExecStartDate', "
			+" DATE_FORMAT(incdntExecDtls.incident_exec_end_date,'%d %b %Y %T') AS 'strIncidentExecEndDate',"
			+" incdntExecDtls.incident_exec_status AS 'incidentExecStatus',incdntExecDtls.incident_exec_remarks AS 'incidentExecRemarks',incdntExecDtls.incident_exec_excp_msg AS 'incidentExecExcpMsg',"
			+" incdntExecDtls.incident_exec_excp_dtls AS 'incidentExecExcpDtls',incdntExecDtls.incident_exec_excp_stckTrce AS 'incidentExecExcpStcktrce' FROM scmn_incident_exec_dtls incdntExecDtls, "
			+" scmn_user_dtls usrs ,scmn_application_dtls applns, scmn_queue_dtls queues, scmn_sop_dtls sops, scmn_workflow_dtls wrkflws, scmn_user_appln_queue_lnk usrApplnQueLnk "
			+" WHERE usrApplnQueLnk.usr_id=#{usrId} AND incdntExecDtls.appln_id=applns.appln_id AND incdntExecDtls.que_id=queues.que_id AND incdntExecDtls.sop_id=sops.sop_id "
			+" AND incdntExecDtls.wrkflw_id=wrkflws.wrkflw_id AND usrApplnQueLnk.que_id = incdntExecDtls.que_id AND usrApplnQueLnk.appln_id = incdntExecDtls.appln_id AND usrs.usr_id = usrApplnQueLnk.usr_id "
			+" AND usrApplnQueLnk.to_view='1' AND usrApplnQueLnk.delete_flag='0' ORDER BY incident_exec_id  DESC;")
	List<IncidentExecDtls> getIncidentExecDtlsList(IncidentExecDtls incidentExecDtls);


	 /**
	 *This method is used to update incident execution status from workflow details
	 * @param incident execution details
	 * @return void
	 */
	@Update("UPDATE scmn_incident_exec_dtls incdntExc SET incdntExc.incident_exec_status=#{incidentExecStatus},"
			+ "incdntExc.incident_exec_remarks=#{incidentExecRemarks} WHERE incdntExc.incident_exec_id=#{incidentExecId}")
	public void updateIncidentExecStatusFromWorkflow(IncidentExecDtls incidentExecDtls);

	/**
	 *This method is used to get list of incident execution details by incident execution Id
	 * @param incident execution details
	 * @return list of incident execution details
	 */	
	@Select("SELECT incdntExecDtls.incident_exec_id as 'incidentExecId',incdntExecDtls.incident_id as 'incidentId',incdntExecDtls.usr_id as 'usrId',usrs.usr_first_name as 'usrName',"
			+ "incdntExecDtls.appln_id as 'applnId',applns.appln_name as 'applnName',incdntExecDtls.que_id as 'queId',queues.que_name as'queName',incdntExecDtls.sop_id as 'sopId',sops.sop_name as 'sopName',"
			+ "incdntExecDtls.wrkflw_id as 'wrkflwId',wrkflws.wrkflw_name as 'wrkflwName',incdntExecDtls.incident_exec_start_date as 'incidentExecStartDate',incdntExecDtls.incident_exec_end_date as 'incidentExecEndDate',"
			+ "incdntExecDtls.incident_exec_status as 'incidentExecStatus',incdntExecDtls.incident_exec_remarks as 'incidentExecRemarks',incdntExecDtls.incident_exec_excp_msg as 'incidentExecExcpMsg',"
			+ "incdntExecDtls.incident_exec_excp_dtls as 'incidentExecExcpDtls',incdntExecDtls.incident_exec_excp_stckTrce as 'incidentExecExcpStcktrce' FROM scmn_incident_exec_dtls incdntExecDtls,scmn_user_dtls usrs,scmn_application_dtls applns,scmn_queue_dtls queues,scmn_sop_dtls sops,scmn_workflow_dtls wrkflws"
			+ " WHERE incdntExecDtls.usr_id=usrs.usr_id AND incdntExecDtls.appln_id=applns.appln_id AND incdntExecDtls.que_id=queues.que_id AND incdntExecDtls.sop_id=sops.sop_id AND incdntExecDtls.wrkflw_id=wrkflws.wrkflw_id AND incdntExecDtls.incident_exec_id=#{incidentExecId}")
	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentExecId(IncidentExecDtls incidentExecDtls);

	/**
	 *This method is used to get list of incident execution details by incident Id
	 * @param incident execution details
	 * @return list of incident execution details
	 */
	@Select("SELECT incdntExecDtls.incident_exec_id as 'incidentExecId',incdntExecDtls.incident_id as 'incidentId',incdntExecDtls.usr_id as 'usrId',usrs.usr_first_name as 'usrName',"
			+ "incdntExecDtls.appln_id as 'applnId',applns.appln_name as 'applnName',incdntExecDtls.que_id as 'queId',queues.que_name as'queName',incdntExecDtls.sop_id as 'sopId',sops.sop_name as 'sopName',"
			+ "incdntExecDtls.wrkflw_id as 'wrkflwId',wrkflws.wrkflw_name as 'wrkflwName',incdntExecDtls.incident_exec_start_date as 'incidentExecStartDate',incdntExecDtls.incident_exec_end_date as 'incidentExecEndDate',"
			+ "incdntExecDtls.incident_exec_status as 'incidentExecStatus',incdntExecDtls.incident_exec_remarks as 'incidentExecRemarks',incdntExecDtls.incident_exec_excp_msg as 'incidentExecExcpMsg',"
			+ "incdntExecDtls.incident_exec_excp_dtls as 'incidentExecExcpDtls',incdntExecDtls.incident_exec_excp_stckTrce as 'incidentExecExcpStcktrce' FROM scmn_incident_exec_dtls incdntExecDtls,scmn_user_dtls usrs,scmn_application_dtls applns,scmn_queue_dtls queues,scmn_sop_dtls sops,scmn_workflow_dtls wrkflws"
			+ " WHERE incdntExecDtls.usr_id=usrs.usr_id AND incdntExecDtls.appln_id=applns.appln_id AND incdntExecDtls.que_id=queues.que_id AND incdntExecDtls.sop_id=sops.sop_id AND incdntExecDtls.wrkflw_id=wrkflws.wrkflw_id AND incdntExecDtls.incident_id=#{incidentId}")
	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentId(IncidentExecDtls incidentExecDtls);
	
	/**
	 *This method is used to get list of incident execution param details by incident execution Id
	 * @param incident execution Id
	 * @return list of incident execution param details
	 */
	@Select("SELECT incidentExecParamDtls.incident_exec_id AS 'incidentExecId',incidentExecParamDtls.param_name AS 'paramName' ,incidentExecParamDtls.param_value AS 'paramValue' FROM scmn_incident_exec_param_dtls incidentExecParamDtls  WHERE incident_exec_id=#{incidentExecId}")
	public List<IncidentExecParamDtls> getIncidentParamListByIncdntExcId(int incidentExecId);

	/**
	 *This method is used to update incident execution status from workflow details based on incident execution Id
	 * @param incident execution Id
	 * @return void
	 */
	@Update("UPDATE scmn_incident_exec_dtls incdntExc SET incdntExc.incident_exec_end_date=#{incidentExecEndDate},incdntExc.incident_exec_status=#{incidentExecStatus},"
			+ "incdntExc.incident_exec_remarks=#{incidentExecRemarks},incdntExc.incident_exec_excp_msg=#{incidentExecExcpMsg},incdntExc.incident_exec_excp_dtls=#{incidentExecExcpDtls},incdntExc.incident_exec_excp_stckTrce=#{incidentExecExcpStcktrce} WHERE incdntExc.incident_exec_id=#{incidentExecId}")
	public void updateIncidentExecFromWorkflow(IncidentExecDtls incidentExecDtls);


	
}
