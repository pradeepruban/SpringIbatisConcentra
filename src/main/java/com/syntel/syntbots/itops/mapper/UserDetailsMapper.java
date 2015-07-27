/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.syntel.syntbots.itops.dto.UserDetails;



/**
*This interface contains all the mappers related to User Details.
*@author Syntel
*@version 1.0
*/

public interface UserDetailsMapper {

	/**
	 *This method is used to get User details.
	 * @return list of User details
	 */
	@Select("SELECT usrdtls.usr_id as 'usrId',usrdtls.usr_code as 'usrCode',usrdtls.usr_first_name as 'usrFirstName',"
			+ "usrdtls.usr_middle_name as 'usrMiddleName',usrdtls.usr_last_name as 'usrLastName',usrdtls.usr_short_name as 'usrShortName',"
			+ "usrdtls.usr_title as 'usrTitle',usrdtls.usr_parent_id as 'usrParentId',usrdtls.usr_employee_code as 'usrEmployeeCode',"
			+ "usrdtls.designation_id as 'usrDesignationId',usrdtls.usr_comments as 'usrComments',usrdtls.usr_type as 'usrType',"
			+ "usrdtls.usr_password as 'usrPassword',usrdtls.corp_group_id as 'usrCorpGroupId',usrdtls.dept_id as 'usrDeptId',"
			+ "usrdtls.project_id as 'usrProjectId',usrdtls.usr_phone_number as 'usrPhoneNumber',usrdtls.usr_mobile_number as 'usrMobileNumber',usrdtls.usr_email as 'usrEmail',usrdtls.delete_flag as 'usrDeleteFlag',"
			+ "usrdtls.created_by as 'usrCreatedBy',usrdtls.modified_by as 'usrModifiedBy',"
			+ "usrdtls.created_date as 'usrCreatedDate',DATE_FORMAT(usrdtls.created_date,'%d %b %Y %T') AS 'strUsrCreatedDate',"
			+ "usrdtls.modified_date as 'usrModifiedDate',DATE_FORMAT(usrdtls.modified_date,'%d %b %Y %T') AS 'strUsrModifiedDate',"
			+ "usrdtls.res_attribute1 as 'resattribute1',usrdtls.res_attribute2 as 'resattribute2',"
			+ "usrdtls.res_attribute3 as 'resattribute3',usrdtls.res_attribute4 as 'resattribute4',"
			+ "usrdtls.res_attribute5 as 'resattribute5' FROM scmn_user_dtls usrdtls ")
	List<UserDetails> getCompleteUserDetailsList();
}
