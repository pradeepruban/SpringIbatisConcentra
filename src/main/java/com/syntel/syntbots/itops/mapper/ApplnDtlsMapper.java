/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
*This interface contains all the mappers related to Applcation Details.
*@author Syntel
*@version 1.0
*/

public interface ApplnDtlsMapper{

	/**
	 *This method is used for inserting application details 
	  * @param application name application details
	*/
@Insert("INSERT INTO scmn_application_dtls(appln_code,appln_name,appln_short_desc,appln_desc,appln_context_path,delete_flag,created_by,modified_by,created_date,modified_date,res_attribute1,res_attribute2,res_attribute3,res_attribute4,res_attribute5) VALUES (#{ApplnCode},#{ApplnName},#{ApplnShortDesc},#{ApplnDesc},#{ApplnContextPath},#{DeleteFlag},#{CreatedBy},#{ModifiedBy},#{CreatedDate},#{ModifiedDate},#{ResAute1},#{ResAute2},#{ResAute3},#{ResAute4},#{ResAute5}")
public void insertApplctnDtls(ApplicationDetails applctnDtls);




/* @Select("SELECT applctnDtls.appln_id as applnId,applctnDtls.appln_code as applnCode,applctnDtls.appln_name as applnName,applctnDtls.appln_short_desc as applnShortDesc,applctnDtls.appln_desc as applnDesc,applctnDtls.appln_context_path as applnContextPath,applctnDtls.delete_flag as deleteFlag,applctnDtls.created_by as createdBy,applctnDtls.modified_by as modifiedBy,applctnDtls.created_date as createdDate,applctnDtls.modified_date as modifiedDate,applctnDtls.res_attribute1 as resAttribute1,applctnDtls.res_attribute2 as resAttribute2,applctnDtls.res_attribute3 as resAttribute3,applctnDtls.res_attribute4 as resAttribute4,applctnDtls.res_attribute5 as resAttribute5 FROM scmn_application_dtls applctnDtls  WHERE appln_name=#{applnName}")

public ApplctnDtls getApplctnDtls(ApplctnDtls applctnDtls);*/

             
/**
 *This method is used for updating application details based on application name
 * @param encryptedData - encrypted data i.e. to be decrypted
*/ 
@Update("UPDATE scmn_application_dtls 	SET	 appln_id = #{ApplnId}, appln_code = #{ApplnCode}, appln_short_desc = #{ApplnShortDesc}, appln_desc = #{ApplnDesc}, appln_context_path = #{ApplnContextPath}, delete_flag = #{DeleteFlag}, modified_by = #{ModifiedBy}, modified_date = #{ModifiedDate}, res_attribute1 = #{ResAute1}, res_attribute2 = #{ResAute2}, res_attribute3 = #{ResAute3}, res_attribute4 = #{ResAute4}, res_attribute5 = #{ResAute5} WHERE appln_name=#{ApplnName}")
public void updateApplctnDtls(ApplicationDetails applctnDtls);

/**
 *This method is used to get application details based on application name 
 * @param application name
 * @return application details
*/
@Select("SELECT applctnDtls.appln_id AS 'applnId',applctnDtls.appln_code AS 'applnCode'," +
		"applctnDtls.appln_name AS 'applnName',applctnDtls.appln_desc AS 'applnDesc', "+
		 "applctnDtls.appln_short_desc AS 'applnShortDesc',"+
		"applctnDtls.appln_context_path AS 'applnContextPath'," +
		"applctnDtls.delete_flag AS 'deleteFlag',applctnDtls.created_by AS 'createdBy'," +
		"(SELECT usrDtls.usr_first_name FROM scmn_user_dtls usrDtls WHERE usrDtls.usr_id = applctnDtls.modified_by) AS 'modifiedBy'," +
		" DATE_FORMAT(applctnDtls.created_date,'%d %b %Y %T') AS 'strCreatedDate'," +
		"DATE_FORMAT(applctnDtls.modified_date,'%d %b %Y %T') AS 'strModifiedDate',"+
		"applctnDtls.res_attribute1 AS 'resAttribute1'," +
		"applctnDtls.res_attribute2 AS 'resAttribute2',applctnDtls.res_attribute3 AS 'resAttribute3'," +
		"applctnDtls.res_attribute4 AS 'resAttribute4',applctnDtls.res_attribute5 AS 'resAttribute5'" +
		" FROM scmn_application_dtls applctnDtls  WHERE appln_name=#{applnName}")
	public ApplicationDetails getApplicationDtls(ApplicationDetails applctnDtls);


/**
 *This method is used to get list of application details  
 * @return list of application details
*/
@Select("SELECT applctnDtls.appln_id AS 'applnId',applctnDtls.appln_code AS 'applnCode'," +
		"applctnDtls.appln_name AS 'applnName',applctnDtls.appln_short_desc AS 'applnShortDesc'," +
		"usrDtls.usr_first_name AS 'createdUser'," +
		"applctnDtls.appln_desc AS 'applnDesc',applctnDtls.appln_context_path AS 'applnContextPath'," +
		"applctnDtls.delete_flag AS 'deleteFlag'," +
		"(SELECT usrDtls.usr_first_name FROM scmn_user_dtls usrDtls WHERE usrDtls.usr_id = applctnDtls.modified_by) AS 'modifiedUser'," +
		"DATE_FORMAT(applctnDtls.created_date,'%d %b %Y %T') AS 'strCreatedDate'," +
		"DATE_FORMAT(applctnDtls.created_date,'%d %b %Y %T') AS 'strModifiedDate',applctnDtls.res_attribute1 AS 'resAttribute1'," +
		"applctnDtls.res_attribute2 AS 'resAttribute2',applctnDtls.res_attribute3 AS 'resAttribute3'," +
		"applctnDtls.res_attribute4 AS 'resAttribute4',applctnDtls.res_attribute5 AS 'resAttribute5' " +
		"FROM scmn_application_dtls applctnDtls INNER JOIN scmn_user_dtls usrDtls ON usrDtls.usr_id=applctnDtls.created_by")
   List<ApplicationDetails> getApplicationDtlsToView();


@Insert("INSERT INTO scmn_application_dtls (appln_name,appln_desc,appln_code,appln_short_desc,appln_context_path,delete_flag,created_by,created_date,modified_date)" +
		"VALUES (#{applnName},#{applnDesc},#{applnCode},#{applnShortDesc},#{applnContextPath},#{deleteFlag},#{createdBy},CURRENT_TIMESTAMP(),#{modifiedDate})")
public void addApplication(ApplicationDetails applicationDetails);


@Update("UPDATE scmn_application_dtls appliactiondtls SET appliactiondtls.appln_name=#{applnName},appliactiondtls.appln_code=#{applnCode},appliactiondtls.appln_context_path=#{applnContextPath},appliactiondtls.appln_short_desc=#{applnShortDesc}," +
		"appliactiondtls.appln_desc=#{applnDesc},appliactiondtls.delete_flag=#{deleteFlag},modified_by=#{modifiedBy},modified_date=CURRENT_TIMESTAMP() WHERE appliactiondtls.appln_id=#{applnId}")
public void updateApplication(ApplicationDetails applicationDetails);



@Select("SELECT COUNT(appln_name) AS 'countApplicationName' FROM scmn_application_dtls  WHERE appln_name=#{applnName}")
public int validateApplicationName(ApplicationDetails applicationDetails);

}