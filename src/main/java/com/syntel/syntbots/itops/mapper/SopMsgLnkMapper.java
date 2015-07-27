/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;

/**
*This interface contains all the mappers related to SOP Message Link Details.
*@author Syntel
*@version 1.0
*/
public interface SopMsgLnkMapper {

	/**
	 *This method is used to insert SOP Message Link Details
	 * @param SOP Message Link Details
	 * @return void
	*/
	@Insert("INSERT INTO scmn_sop_msg_lnk(sop_id,msg_keyword,delete_flag,created_by,modified_by,created_date,modified_date,res_attribute1,res_attribute2,res_attribute3,res_attribute4,res_attribute5) VALUES (#{sopId},#{msgKeyword},#{deleteFlag},#{createdBy},#{modifiedBy},#{createdDate},#{modifiedDate},#{resAttribute1},#{resAttribute2},#{resAttribute3},#{resAttribute4},#{resAttribute5}" )
	void saveSopMsgLnk(SopMsgLnk sopMsgLnk);
	
	/**
	 *This method is used to get list of SOP Message Link details
	 * @return list of SOP Message Link details
	 */
	@Select("SELECT sopMsgLnk.sop_id as 'sopId',sopMsgLnk.msg_keyword as 'msgKeyword',sopMsgLnk.delete_flag as 'deleteFlag',"
			+ "sopMsgLnk.created_by as 'createdBy',sopMsgLnk.modified_by as 'modifiedBy',"
			+ "sopMsgLnk.created_date as 'createdDate',DATE_FORMAT(sopMsgLnk.created_date,'%d %b %Y %T') AS 'strSopMsgLnkCreatedDate',"
			+ "sopMsgLnk.modified_date as 'modifiedDate',DATE_FORMAT(sopMsgLnk.modified_date,'%d %b %Y %T') AS 'strSopMsgLnkModifiedDate',"
			+ "sopMsgLnk.res_attribute1 as 'resAttribute1',sopMsgLnk.res_attribute2 as 'resAttribute2',"
			+ "sopMsgLnk.res_attribute3 as 'resAttribute3',sopMsgLnk.res_attribute4 as 'resAttribute4',"
			+ "sopMsgLnk.res_attribute5 as 'resAttribute5' FROM scmn_sop_msg_dtls sopMsgLnk ")
	List<SopMsgLnk> getCompleteSopMsgLnkList();

	/**
	 *This method is used to get list of SOP Message Link details based on SOP Id
	 * @param SOP Message Link Details
	 * @return list of SOP Message Link details
	 */
	@Select("SELECT sopMsgLnk.sop_id as 'sopId',sopMsgLnk.msg_keyword as 'msgKeyword',sopMsgLnk.delete_flag as 'deleteFlag',sopMsgLnk.created_by as 'createdBy',sopMsgLnk.modified_by as 'modifiedBy',sopMsgLnk.created_date as 'createdDate',sopMsgLnk.modified_date as 'modifiedDate',sopMsgLnk.res_attribute1 as 'resAttribute1',sopMsgLnk.res_attribute2 as 'resAttribute2',sopMsgLnk.res_attribute3 as 'resAttribute3',sopMsgLnk.res_attribute4 as 'resAttribute4',sopMsgLnk.res_attribute5 as 'resAttribute5' FROM scmn_sop_msg_lnk sopMsgLnk  WHERE sop_id=#{sopId}")
	List<SopMsgLnk> getSopMsgLnkBySopId(SopMsgLnk sopMsgLnk);

	/**
	 *This method is used to get list of SOP Message Link details based on by message keyword
	 * @param SOP Message Link Details
	 * @return list of SOP Message Link details
	 */
	@Select("SELECT sopMsgLnk.sop_id as 'sopId',sopMsgLnk.msg_keyword as 'msgKeyword',sopMsgLnk.delete_flag as 'deleteFlag',sopMsgLnk.created_by as 'createdBy',sopMsgLnk.modified_by as 'modifiedBy',sopMsgLnk.created_date as 'createdDate',sopMsgLnk.modified_date as 'modifiedDate',sopMsgLnk.res_attribute1 as 'resAttribute1',sopMsgLnk.res_attribute2 as 'resAttribute2',sopMsgLnk.res_attribute3 as 'resAttribute3',sopMsgLnk.res_attribute4 as 'resAttribute4',sopMsgLnk.res_attribute5 as 'resAttribute5' FROM scmn_sop_msg_lnk sopMsgLnk  WHERE msg_keyword=#{msgKeyword}")
	List<SopMsgLnk> getSopMsgLnkByMsgKeyword(SopMsgLnk sopMsgLnk);

	/**
	 *This method is used to update SOP Message Link base on SOP Id
	 * @param SOP Message Link Details
	 * @return void
	*/
	@Update("UPDATE scmn_sop_msg_lnk 	SET	 msg_keyword = #{msgKeyword}, delete_flag = #{deleteFlag}, modified_by = #{modifiedBy}, modified_date = #{modifiedDate}, res_attribute1 = #{resAttribute1}, res_attribute2 = #{resAttribute2}, res_attribute3 = #{resAttribute3}, res_attribute4 = #{resAttribute4}, res_attribute5 = #{resAttribute5} WHERE sop_id=#{sopId}")
	void updateSopMsglnk(SopMsgLnk sopMsgLnk);

	/**
	 *This method is used to get usershort name based on user id
	 * @param user Id in created by feild
	 * @return user name
	*/
	@Select("SELECT usr_short_name FROM scmn_user_dtls where usr_id = #{createdBy}")
	String getUserShortNameByUserId(int createdBy);

	/**
	 *This method is used to sop details based on msg key
	 * @param sopMsgLnk
	 * @return Sop details of list
	*/
	@Select("SELECT sopDtls.sop_id AS sopId, sopDtls.sop_name AS sopName, sopDtls.sop_desc AS sopDesc,sopDtls.delete_flag AS deleteFlag,"
			+ " sopDtls.created_by AS createdBy, sopDtls.modified_by AS modifiedBy,sopDtls.created_date AS "
			+ " createdDate,sopDtls.modified_date AS modifiedDate,sopDtls.res_attribute1 AS resAttribute1,"
			+ " sopDtls.res_attribute2 AS resAttribute2,sopDtls.res_attribute3 AS resAttribute3,sopDtls.res_attribute4"
			+ " AS resAttribute4,sopDtls.res_attribute5 AS resAttribute5 FROM scmn_sop_dtls sopDtls ,scmn_sop_msg_dtls sopMsgDtls" 
			+ " WHERE sopMsgDtls.msg_keyword ='FileSystemCleanup' AND sopDtls.sop_id = sopMsgDtls.sop_id;")
	List<SopDetails> getListSopByMessageKey(SopMsgLnk sopMsgLnk);
	
}
