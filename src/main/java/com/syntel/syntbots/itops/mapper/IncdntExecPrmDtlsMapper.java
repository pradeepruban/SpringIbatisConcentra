/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import org.apache.ibatis.annotations.Insert;

import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
/**
*This interface contains all the mappers related to Incident Execution param Details.
*@author Syntel
*@version 1.0
*/
public interface IncdntExecPrmDtlsMapper {	
	
	/**
	 *This method is used to insert incident execution param details
	 * @param incident execution param details
	 * @return void
	*/
	@Insert("INSERT INTO scmn_incident_exec_param_dtls(incident_exec_id,param_name, param_code, param_value,delete_flag,created_by,created_date,res_attribute1,res_attribute2,res_attribute3,res_attribute4,res_attribute5) VALUE (#{incidentExecId}, #{paramName}, #{paramCode}, #{paramValue},#{deleteFlag},#{createdBy},#{createdDate},#{resAttribute1},#{resAttribute2},#{resAttribute3},#{resAttribute4},#{resAttribute5})" )
	public void insertIncidentExecParamDtls(IncidentExecParamDtls incidentExecParamDtls);
}
