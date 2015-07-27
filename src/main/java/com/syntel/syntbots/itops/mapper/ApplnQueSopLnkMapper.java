/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.syntel.syntbots.itops.dto.ApplnQueSopLnk;
import com.syntel.syntbots.itops.dto.SopDetails;

/**
*This interface contains all the mappers related to Applcation SOP Queue Link Details.
*@author Syntel
*@version 1.0
*/
public interface ApplnQueSopLnkMapper {


	/**
	 *This method is used to get list SOP details based on incident application name and incident assignment group
	 * @param incident application name,incident assignment group
	 * @return list SOP details
	*/
	@Select("SELECT sopDtls.sop_id AS sopId, sopDtls.sop_name AS sopName, sopDtls.sop_desc AS sopDesc,sopDtls.delete_flag AS deleteFlag,sopDtls.created_by AS createdBy,"
			+ "sopDtls.modified_by AS modifiedBy,sopDtls.created_date AS createdDate,sopDtls.modified_date AS modifiedDate,sopDtls.res_attribute1 AS resAttribute1,"
			+ "sopDtls.res_attribute2 AS resAttribute2,sopDtls.res_attribute3 AS resAttribute3,sopDtls.res_attribute4 AS resAttribute4,sopDtls.res_attribute5 AS resAttribute5"
			+ " FROM scmn_appln_que_sop_lnk appQueSopLnk,scmn_application_dtls appDtls,scmn_queue_dtls queDtls,"
			+ "scmn_sop_dtls sopDtls WHERE appDtls.appln_name =#{0} AND queDtls.que_name =#{1}"
			+ " AND appQueSopLnk.appln_id=appDtls.appln_id AND appQueSopLnk.que_id = queDtls.que_id AND sopDtls.sop_id=appQueSopLnk.sop_id")
	List<SopDetails> getSopListByApplnNameAndQueueName(String incdntAppName, String incdntAssgnmntGrp);

	/**
	 *This method is used to get list SOP details 
	 * @return list SOP details
	*/
	@Select("SELECT appQSopLnk.appln_id as 'applicationId',appQSopLnk.que_id as 'queueId',appQSopLnk.sop_id as 'sopId',appQSopLnk.delete_flag as 'appQSopLnkDeleteFlag',"
				+ "appQSopLnk.default_flag as 'appQSopLnkDefaultFlag',appQSopLnk.created_by as 'appQSopLnkCreatedBy',appQSopLnk.modified_by as 'appQSopLnkModifiedBy',"
				+ "appQSopLnk.created_date as 'appQSopLnkCreatedDate',DATE_FORMAT(appQSopLnk.created_date,'%d %b %Y %T') AS 'strAppQSopLnkCreatedDate',"
				+ "appQSopLnk.modified_date as 'appQSopLnkModifiedDate',DATE_FORMAT(appQSopLnk.modified_date,'%d %b %Y %T') AS 'strAppQSopLnkModifiedDate',"
				+ "appQSopLnk.res_attribute1 as 'appQSopLnkResAttribute1',appQSopLnk.res_attribute2 as 'appQSopLnkResAttribute2',"
				+ "appQSopLnk.res_attribute3 as 'appQSopLnkResAttribute3',appQSopLnk.res_attribute4 as 'appQSopLnkResAttribute4',"
				+ "appQSopLnk.res_attribute5 as 'appQSopLnkResAttribute5' FROM scmn_appln_que_sop_lnk appQSopLnk ")
	List<ApplnQueSopLnk> getCompleteApplicationQueueSopLinkList();
	
	/**
	 *This method is used to get application name based on application Id
	 * @param application Id
	 * @return application name
	*/
	@Select("SELECT appln_name FROM scmn_application_dtls WHERE appln_id = #{applicationId}")
	String getApplicationNameByApplicationId(long applicationId);

	/**
	 *This method is used to get queue name based on queue Id
	 * @param queue Id
	 * @return queue name
	*/
	@Select("SELECT que_name FROM scmn_queue_dtls WHERE que_id = #{queueId}")
	String getQueueNameByQueueId(long queueId);

	/**
	 *This method is used to get SOP name based on SOP Id
	 * @param SOP Id
	 * @return SOP name
	*/
	@Select("SELECT sop_name FROM scmn_sop_dtls WHERE sop_id = #{sopId}")
	String getSopNameBySopId(long sopId);

	
	
}
