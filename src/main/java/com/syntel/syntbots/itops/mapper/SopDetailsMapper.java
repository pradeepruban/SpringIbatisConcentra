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
import com.syntel.syntbots.itops.dto.SopParamDetails;

/**
*This interface contains all the mappers related to SOP Details.
*@author Syntel
*@version 1.0
*/
public interface SopDetailsMapper {

	/**
	 *This method is used to get list of SOP details
	 * @return list of SOP details
	 */
	@Select("SELECT sopdtls.sop_id AS 'sopId',sopdtls.sop_name AS 'sopName',sopdtls.sop_desc AS 'sopDesc'," +
			"sopdtls.delete_flag AS 'deleteflag',usrDtls.usr_first_name AS 'createdUser',"+
			"sopdtls.modified_by AS 'modifiedBy'," +
			"DATE_FORMAT(sopdtls.created_date,'%d %b %Y %T') AS 'strCreatedDate',"
			+ "(SELECT usrDtls.usr_first_name FROM scmn_user_dtls usrDtls WHERE usrDtls.usr_id = sopdtls.modified_by) AS 'modifiedUser' ," +
			"DATE_FORMAT(sopdtls.modified_date,'%d %b %Y %T') AS 'strModifiedDate',sopdtls.res_attribute1 AS 'resAttribute1'," +
			"sopdtls.res_attribute2 AS 'resAttribute2',sopdtls.res_attribute3 AS 'resAttribute3'," +
			"sopdtls.res_attribute4 AS 'resAttribute4',sopdtls.res_attribute5 AS 'resAttribute5'"+
			"FROM scmn_sop_dtls sopdtls INNER JOIN scmn_user_dtls usrDtls ON sopdtls.created_by=usrDtls.usr_id")
	List<SopDetails> getSopDetailsToView();

	/**
	 *This method is used to get list of SOP details based on SOP Id
	 * @param SOP Id
	 * @return list of SOP param details
	 */
	@Select("SELECT sopparamdtls.sop_id AS 'sopId',sopparamdtls.sop_param_id AS 'sopParamId',sopparamdtls.param_code AS 'paramCode',sopparamdtls.param_value AS 'paramValue'," +
			"sopparamdtls.delete_flag AS 'deleteflag',usrDtls.usr_first_name AS 'createdUser',(SELECT usrDtls.usr_first_name FROM scmn_user_dtls usrDtls WHERE usrDtls.usr_id = sopparamdtls.modified_by) AS 'modifiedUser' ," +
			"DATE_FORMAT(sopparamdtls.created_date,'%d %b %Y %T') AS 'strCreatedDate'," +
			"DATE_FORMAT(sopparamdtls.modified_date,'%d %b %Y %T') AS 'strModifiedDate'," +
			"sopparamdtls.res_attribute1 AS 'resAttribute1',sopparamdtls.res_attribute2 AS 'resAttribute2'," +
			"sopparamdtls.res_attribute3 AS 'resAttribute3',sopparamdtls.res_attribute4 AS 'resAttribute4'," +
			"sopparamdtls.res_attribute5 AS 'resAttribute5'FROM scmn_sop_param_dtls sopparamdtls INNER JOIN scmn_sop_dtls sopdtls ON ((sopdtls.sop_id=#{sopId})&&(sopparamdtls.sop_id=#{sopId})) INNER JOIN scmn_user_dtls usrDtls ON sopparamdtls.created_by=usrDtls.usr_id")
	 
	List<SopParamDetails> getSopParamDetailsToView(int sopId);
	/**
	 *This method is used to insert SOP details
	 * @param SOP details
	 */
	@Insert("INSERT INTO scmn_sop_dtls (sop_name,sop_desc,delete_flag,created_by,created_date,modified_date)"
		  + " VALUES (#{sopName},#{sopDesc},#{deleteFlag},#{createdBy},CURRENT_TIMESTAMP(),#{modifiedDate})")
	void addSOPDtls(SopDetails sopDetails);
	/**
	 *This method is used to update SOP details
	 * @param SOP details
	 */
	@Update("UPDATE scmn_sop_dtls SET sop_name=#{sopName},sop_desc=#{sopDesc},delete_flag=#{deleteFlag},modified_by=#{modifiedBy},modified_date=CURRENT_TIMESTAMP() WHERE sop_Id=#{sopId}")
	void updateSOPDtls(SopDetails sopDetails);
	/**
	 *This method is used to get count of SOP name for given SOP nameS
	 * @param SOP details
	 * @return int count
	 */
	@Select("SELECT COUNT(sop_name) FROM scmn_sop_dtls WHERE sop_name=#{sopName}")
	int validateSOPName(SopDetails sopDetails);

	@Insert("INSERT INTO scmn_sop_param_dtls(sop_id,param_code,param_value,delete_flag,created_by,created_date,modified_date)"
								  + "VALUES (#{sopId},#{paramCode},#{paramValue},0,#{createdBy},CURRENT_TIMESTAMP(),#{modifiedDate})")
	
	void addSOPParamDtls(SopParamDetails sopParamDetails);

	@Select("SELECT COUNT(param_code) FROM scmn_sop_param_dtls WHERE param_code=#{paramCode} AND sop_id=#{sopId} AND sop_param_id!=#{sopParamId}")
	int validateSOPParamCode(SopParamDetails sopParamDetails);

	@Update("UPDATE scmn_sop_param_dtls SET param_code=#{paramCode},param_value=#{paramValue},delete_flag=#{deleteFlag},modified_by=#{modifiedBy},modified_date=CURRENT_TIMESTAMP() WHERE sop_param_id=#{sopParamId}")
	void updateSOPParamDtls(SopParamDetails sopParamDetails);


	

}
