/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.syntel.syntbots.itops.dto.QueueDetails;
import com.syntel.syntbots.itops.mapper.QueueDtlsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This interface contains all the DAO layer methods related to Queue Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("queueDtlsDAO")
public class QueueDtlsDAOImpl implements QueueDtlsDAO {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private QueueDtlsMapper queueDtlsMapper;

	/**
	 * This method is called to get all the Queue Details by queueDtls
	 *
	 * @param queueDtls
	 * @returnThis queueDtls values related queueDtls
	 * @exception - ApplicationException in case of error
	 */
	public QueueDetails getQueueDtlsByQueueName(QueueDetails queueDtls)
			throws ApplicationException {
		log.info("Entered inside QueueDtlsDAOImpl:getQueueDtlsByQueueName():");
		QueueDetails queueDtlsByQueueName = null;
		try {
			queueDtlsByQueueName = queueDtlsMapper.getQueueDtlsByQueueName(queueDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueDtls", queueDtls);
			throw new ApplicationException(
					"QueueDtlsDAOImpl.getQueueDtlsByQueueName", e, argsMap);
		}
		log.info("Just before leaving  QueueDtlsDAOImpl:getQueueDtlsByQueueName() method");
		return queueDtlsByQueueName;
	}

	/**
	 * This method is called to get all the Queue Details
	 *
	 * @param sopnm
	 * @returnThis List<QueueDtls> all the values related Queue Details
	 * @exception - ApplicationException in case of error
	 */
	public List<QueueDetails> getQueueDtls() throws ApplicationException {
		log.info("Entered inside QueueDtlsDAOImpl:getQueueDtls():");
		List<QueueDetails> queueDtls = null;
		try {
			queueDtls = queueDtlsMapper.getQueueDtls();
		} catch (Exception e) {
			throw new ApplicationException("QueueDtlsDAOImpl.getQueueDtls", e);
		}
		log.info("Just before leaving  QueueDtlsDAOImpl:getQueueDtls() method");
		return queueDtls;
	}

	/**
	 * This method is called to add new Queue
	 *
	 * @param Queue
	 *            Details
	 * @return void
	 * @throws ApplicationException
	 * @exception - ApplicationException in case of error
	 */
	public void addQueue(QueueDetails queueDetails) throws ApplicationException {
		log.info("Entered inside QueueDtlsDAOImpl:addQueue():");
		try {
			queueDtlsMapper.addQueue(queueDetails);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueDetails", queueDetails);
			throw new ApplicationException("QueueDtlsDAOImpl.addQueue", e,
					argsMap);
		}
		log.info("Just before leaving  QueueDtlsDAOImpl:addQueue() method");

	}

	/**
	 * This method is called to update Queue details
	 *
	 * @param Queue
	 *            Details
	 * @return void
	 * @throws ApplicationException
	 * @exception - ApplicationException in case of error
	 */
	public void updateQueue(QueueDetails queueDetails)
			throws ApplicationException {
		log.info("Entered inside QueueDtlsDAOImpl:updateQueue():");
		try {
			queueDtlsMapper.updateQueue(queueDetails);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueDetails", queueDetails);
			throw new ApplicationException("QueueDtlsDAOImpl.updateQueue", e,
					argsMap);
		}
		log.info("Just before leaving  QueueDtlsDAOImpl:updateQueue() method");

	}

	/**
	 * This method is called to check whetherqueue name already exists or not
	 *
	 * @param Queue
	 *            Details
	 * @return int count of queue name
	 * @throws ApplicationException
	 * @exception - ApplicationException in case of error
	 */
	public int validateQueName(QueueDetails queueDetails)
			throws ApplicationException {
		log.info("Entered inside QueueDtlsDAOImpl:validateQueName:");
		int countQueueName = 0;
		try {
			countQueueName = queueDtlsMapper.validateQueName(queueDetails);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("queueDetails", queueDetails);
			throw new ApplicationException("QueueDtlsDAOImpl.validateQueName",
					e, argsMap);
		}
		log.info("Entered inside QueueDtlsDAOImpl:validateQueName:");
		return countQueueName;
	}

}
