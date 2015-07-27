/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.syntel.syntbots.itops.dto.UsrApplnQueLnk;
/**
*This interface contains all the mappers related to User Applcation Queue Link Details.
*@author Syntel
*@version 1.0
*/
public interface UsrApplnQueLnkMapper {
	
	/**
	 *This method is used to get User Applcation Queue Link  details.
	 * @return list of User Applcation Queue Link details
	*/
	@Select("SELECT usrApplnQueLnk.usr_appln_que_lnk_id as 'usrAppQLinkId',usrApplnQueLnk.appln_id as 'usrAppQLinkApplicationId',usrApplnQueLnk.que_id as 'usrAppQLinkQueueId',usrApplnQueLnk.usr_id as 'usrAppQLinkUsrId',usrApplnQueLnk.delete_flag as 'usrAppQLinkDeleteFlag',"
			+ "usrApplnQueLnk.to_view as 'usrAppQLinkToViewFlag',usrApplnQueLnk.to_execute as 'usrAppQLinkToExecuteFlag',usrApplnQueLnk.created_by as 'usrAppQLinkCreatedBy',usrApplnQueLnk.modified_by as 'usrAppQLinkModifiedBy',"
			+ "usrApplnQueLnk.created_date as 'usrAppQLinkCreatedDate',DATE_FORMAT(usrApplnQueLnk.created_date,'%d %b %Y %T') AS 'strUsrAppQLinkCreatedDate',"
			+ "usrApplnQueLnk.modified_date as 'usrAppQLinkModifiedDate',DATE_FORMAT(usrApplnQueLnk.modified_date,'%d %b %Y %T') AS 'strUsrAppQLinkModifiedDate',"
			+ "usrApplnQueLnk.res_attribute1 as 'usrAppQLinkResAttribute1',usrApplnQueLnk.res_attribute2 as 'usrAppQLinkResAttribute2',"
			+ "usrApplnQueLnk.res_attribute3 as 'usrAppQLinkResAttribute3',usrApplnQueLnk.res_attribute4 as 'usrAppQLinkResAttribute4',"
			+ "usrApplnQueLnk.res_attribute5 as 'usrAppQLinkResAttribute5' FROM scmn_user_appln_queue_lnk usrApplnQueLnk ")
	List<UsrApplnQueLnk> getCompleteUserApplicationQueueLinkList();

	
	@Select("SELECT usrApplnQueLnk.appln_id as 'usrAppQLinkApplicationId',usrApplnQueLnk.que_id as 'usrAppQLinkQueueId',usrApplnQueLnk.usr_id as 'usrAppQLinkUsrId',usrApplnQueLnk.delete_flag as 'usrAppQLinkDeleteFlag',"
			+ "usrApplnQueLnk.to_view as 'usrAppQLinkToViewFlag',usrApplnQueLnk.to_execute as 'usrAppQLinkToExecuteFlag',usrApplnQueLnk.created_by as 'usrAppQLinkCreatedBy',usrApplnQueLnk.modified_by as 'usrAppQLinkModifiedBy',"
			+ "usrApplnQueLnk.created_date as 'usrAppQLinkCreatedDate',DATE_FORMAT(usrApplnQueLnk.created_date,'%d %b %Y %T') AS 'strUsrAppQLinkCreatedDate',"
			+ "usrApplnQueLnk.modified_date as 'usrAppQLinkModifiedDate',DATE_FORMAT(usrApplnQueLnk.modified_date,'%d %b %Y %T') AS 'strUsrAppQLinkModifiedDate',"
			+ "usrApplnQueLnk.res_attribute1 as 'usrAppQLinkResAttribute1',usrApplnQueLnk.res_attribute2 as 'usrAppQLinkResAttribute2',"
			+ "usrApplnQueLnk.res_attribute3 as 'usrAppQLinkResAttribute3',usrApplnQueLnk.res_attribute4 as 'usrAppQLinkResAttribute4',"
			+ "usrApplnQueLnk.res_attribute5 as 'usrAppQLinkResAttribute5' FROM scmn_user_appln_queue_lnk usrApplnQueLnk ,scmn_user_dtls userDtls ,scmn_queue_dtls queDtls,"
			+ "scmn_application_dtls appDtls WHERE userDtls.usr_id = #{0} AND  appDtls.appln_name = #{1} AND queDtls.que_name = #{2} AND "
			+ "usrApplnQueLnk.appln_id=appDtls.appln_id AND usrApplnQueLnk.que_id = queDtls.que_id AND usrApplnQueLnk.usr_id = userDtls.usr_id ")
	
	UsrApplnQueLnk getUsrApplnQueLnkDetailsByAppnameandQueName(long usrId,String incdntAppName, String incdntAssgnmntGrp);


	@Select("SELECT COUNT(usr_appln_que_lnk_id) FROM scmn_user_appln_queue_lnk WHERE usr_id=#{usrAppQLinkUsrId} AND appln_id=#{usrAppQLinkApplicationId} AND que_id=#{usrAppQLinkQueueId}")
	int ValUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk);

	@Insert("INSERT INTO scmn_user_appln_queue_lnk(usr_id,appln_id,que_id,to_view,to_execute,delete_flag,created_by,created_date) "
		  + "VALUES (#{usrAppQLinkUsrId},#{usrAppQLinkApplicationId},#{usrAppQLinkQueueId},#{usrAppQLinkToViewFlag},#{usrAppQLinkToExecuteFlag},0,#{usrAppQLinkCreatedBy},CURRENT_TIMESTAMP())")
	void addUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk);

	@Update("UPDATE scmn_user_appln_queue_lnk SET to_view=#{usrAppQLinkToViewFlag},to_execute=#{usrAppQLinkToExecuteFlag},delete_flag=#{usrAppQLinkDeleteFlag},modified_by=#{usrAppQLinkModifiedBy},modified_date=CURRENT_TIMESTAMP() WHERE usr_appln_que_lnk_id=#{usrAppQLinkId}")
	void updateUsrApplnQueLinkDtls(UsrApplnQueLnk usrApplnQueLnk);

}
