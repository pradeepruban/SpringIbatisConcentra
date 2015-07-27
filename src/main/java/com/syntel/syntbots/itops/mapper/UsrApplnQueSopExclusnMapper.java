/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UsrApplnQueSopExclusn;

/**
*This interface contains all the mappers related to User Applcation Queue Sop Exclusion Details.
*@author Syntel
*@version 1.0
*/
public interface UsrApplnQueSopExclusnMapper {

	/**
	 *This method is used to get User Applcation Queue Sop Exclusion details.
	 * @return list of User Applcation Queue Sop Exclusion details
	*/
	@Select("SELECT usrAppQSopExclsn.appln_id as 'usrApplnQueSopExclsnApplicationId',usrAppQSopExclsn.que_id as 'usrApplnQueSopExclsnQueueId',usrAppQSopExclsn.usr_id as 'usrApplnQueSopExclsnUsrId',usrAppQSopExclsn.sop_id as 'usrApplnQueSopExclsnSopId',usrAppQSopExclsn.delete_flag as 'usrApplnQueSopExclsnDeleteFlag',"
			+ "usrAppQSopExclsn.created_by as 'usrApplnQueSopExclsnCreatedBy',usrAppQSopExclsn.modified_by as 'usrApplnQueSopExclsnModifiedBy',"
			+ "usrAppQSopExclsn.created_date as 'usrApplnQueSopExclsnCreatedDate',DATE_FORMAT(usrAppQSopExclsn.created_date,'%d %b %Y %T') AS 'strUsrApplnQueSopExclsnCreatedDate',"
			+ "usrAppQSopExclsn.modified_date as 'usrApplnQueSopExclsnModifiedDate',DATE_FORMAT(usrAppQSopExclsn.modified_date,'%d %b %Y %T') AS 'strUsrApplnQueSopExclsnModifiedDate',"
			+ "usrAppQSopExclsn.res_attribute1 as 'usrApplnQueSopExclsnResAttribute1',usrAppQSopExclsn.res_attribute2 as 'usrApplnQueSopExclsnResAttribute2',"
			+ "usrAppQSopExclsn.res_attribute3 as 'usrApplnQueSopExclsnResAttribute3',usrAppQSopExclsn.res_attribute4 as 'usrApplnQueSopExclsnResAttribute4',"
			+ "usrAppQSopExclsn.res_attribute5 as 'usrApplnQueSopExclsnResAttribute5' FROM scmn_usr_appln_que_sop_exclson usrAppQSopExclsn ")
	List<UsrApplnQueSopExclusn> getCompleteUserApplicationQueueSopExclusionList();
	
	@Select("SELECT sopDtls.sop_id AS sopId, sopDtls.sop_name AS sopName, sopDtls.sop_desc AS sopDesc,sopDtls.delete_flag AS deleteFlag,sopDtls.created_by AS createdBy,"
			+" sopDtls.modified_by AS modifiedBy,sopDtls.created_date AS createdDate,sopDtls.modified_date AS modifiedDate,sopDtls.res_attribute1 AS resAttribute1,"
			+" sopDtls.res_attribute2 AS resAttribute2,sopDtls.res_attribute3 AS resAttribute3,sopDtls.res_attribute4 AS resAttribute4,sopDtls.res_attribute5 AS resAttribute5"
			+" FROM scmn_usr_appln_que_sop_exclson usrAppQueSopLnk,scmn_application_dtls appDtls,scmn_queue_dtls queDtls,scmn_user_dtls userDtls ,scmn_sop_dtls sopDtls"
		    +" WHERE userDtls.usr_id = #{0} AND  appDtls.appln_name = #{1} AND queDtls.que_name = #{2}"
			+" AND usrAppQueSopLnk.appln_id=appDtls.appln_id AND usrAppQueSopLnk.que_id = queDtls.que_id AND sopDtls.sop_id=usrAppQueSopLnk.sop_id AND queDtls.delete_flag ='0' AND sopDtls.delete_flag = '0' AND usrAppQueSopLnk.delete_flag = '0' AND usrAppQueSopLnk.usr_id =userDtls.usr_id ")

	List<SopDetails> getsopListNotAccessByUsr(long usrId, String incdntAppName,String incdntAssgnmntGrp);
}
