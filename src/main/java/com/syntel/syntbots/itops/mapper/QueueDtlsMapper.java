/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/
package com.syntel.syntbots.itops.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.syntel.syntbots.itops.dto.QueueDetails;

/**
*This interface contains all the mappers related to Queue Details.
*@author Syntel
*@version 1.0
*/



public interface QueueDtlsMapper {
	
	String QUEUE_GETQUEUEDETAILS = "{CALL getQueueDtls()}";
	
	
	String PROC_SAVEDATA = "{CALL addQueue(#{queName, mode=IN, jdbcType=VARCHAR}, #{queDesc, mode=IN, jdbcType=VARCHAR}, #{deleteFlag, mode=IN, jdbcType=INTEGER}, #{createdBy, mode=IN, jdbcType=INTEGER})}";

	/**
	 *This method is used to get list of queue details based on queue name
	 * @param queue name
	 * @return list of queue details
	 */
	@Select("SELECT queueDtls.que_id as 'queId',queueDtls.que_name as 'queName',queueDtls.que_desc as 'queDesc',"
			+ "queueDtls.delete_flag as 'deleteFlag',queueDtls.created_by as 'createdBy',queueDtls.modified_by as 'modifiedBy',"
			+ "queueDtls.created_date as 'createdDate',queueDtls.modified_date as 'modifiedDate',queueDtls.res_attribute1 as 'resAttribute1',"
			+ "queueDtls.res_attribute2 as 'resAttribute2',queueDtls.res_attribute3 as 'resAttribute3',queueDtls.res_attribute4 as 'resAttribute4',"
			+ "queueDtls.res_attribute5 as 'resAttribute5' FROM scmn_queue_dtls queueDtls  WHERE que_name=#{queName}")
	QueueDetails getQueueDtlsByQueueName(QueueDetails queueDtls);

	/**
	 *This method is used to get list of queue details 
	 * @return list of queue details
	 */
	/*
	@Select("SELECT queueDtls.que_id AS 'queId',queueDtls.que_name AS 'queName',queueDtls.que_desc AS 'queDesc'," +
			" usrDtls.usr_first_name AS 'createdUser', dbo.fnConvertDateToString(queueDtls.created_date,'%d %b %Y %T') AS 'strCreatedDate'," +
			" usrDtls.usr_first_name AS 'modifiedUser',dbo.fnConvertDateToString(queueDtls.modified_date,'%d %b %Y %T') AS 'strModifiedDate',queueDtls.delete_flag AS 'deleteFlag'," +
			" queueDtls.res_attribute1 AS 'resAttribute1',queueDtls.res_attribute2 AS 'resAttribute2',queueDtls.res_attribute3 AS 'resAttribute3'," +
			" queueDtls.res_attribute4 AS 'resAttribute4',queueDtls.res_attribute5 AS 'resAttribute5'" +
			" FROM scmn_queue_dtls queueDtls INNER JOIN scmn_user_dtls usrDtls ON queueDtls.created_by=usrDtls.usr_id")*/
	
	@Select(value= QUEUE_GETQUEUEDETAILS)

	List<QueueDetails> getQueueDtls();
	
	
	@Select(value= PROC_SAVEDATA)
		void addQueue(QueueDetails queueDetails);
	
	@Update("UPDATE scmn_queue_dtls queue SET queue.que_name=#{queName}," +
			"queue.que_desc=#{queDesc},queue.delete_flag=#{deleteFlag},modified_by=#{modifiedBy},modified_date=CURRENT_TIMESTAMP() WHERE queue.que_Id=#{queId}")
	void updateQueue(QueueDetails queueDetails);



	@Select("SELECT COUNT(que_name) AS 'countQueName' FROM scmn_queue_dtls queueDtls WHERE que_name=#{queName}")
	int validateQueName(QueueDetails queueDetails);
	
	@Select("SELECT fnConvertDateToString(queueDtls.created_date,'%d %b %Y %T') AS 'strCreatedDate',fnConvertDateToString(queueDtls.modified_date,'%d %b %Y %T') AS 'strModifiedDate' FROM scmn_queue_dtls queueDtls INNER JOIN scmn_user_dtls usrDtls ON queueDtls.created_by=usrDtls.usr_id")
	QueueDetails getQueueCreatedAndModifedDate();
	
	
	
	
	
	
	
	
	

}
