/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.syntel.syntbots.itops.dto.SopParamDetails;

/**
*This interface contains all the mappers related to SOP Param Details.
*@author Syntel
*@version 1.0
*/
public interface SopParamDtlsMapper {
	
	/**
	 *This method is used to get list of SOP Param details based on SOP Id
	 * @param SOP param Details
	 * @return list of SOP param details
	 */
	 @Select("SELECT sopParamDtls.sop_id as 'sopId',sopParamDtls.param_code as 'paramCode'," +
	 		"sopParamDtls.param_value as 'paramValue',sopParamDtls.delete_flag as 'deleteFlag'," +
	 		"sopParamDtls.created_by as 'createdBy',sopParamDtls.created_date as 'createdDate'," +
	 		"sopParamDtls.modified_by as 'modifiedBy',sopParamDtls.modified_date as 'modifiedDate'," +
	 		"sopParamDtls.res_attribute1 as 'resAttribute1',sopParamDtls.res_attribute2 as 'resAttribute2'," +
	 		"sopParamDtls.res_attribute3 as 'resAttribute3',sopParamDtls.res_attribute4 as 'resAttribute4'," +
	 		"sopParamDtls.res_attribute5 as 'resAttribute5' FROM scmn_sop_param_dtls sopParamDtls  WHERE sop_id=#{sopId}")
	 public List<SopParamDetails> getSopParamDtls(SopParamDetails sopParamDtls);

			
}
