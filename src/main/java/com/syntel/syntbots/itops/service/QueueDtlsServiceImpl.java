/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.QueueDtlsDAO;
import com.syntel.syntbots.itops.dto.QueueDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * Queue Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("queueDtlsService")
public class QueueDtlsServiceImpl implements QueueDtlsService {
	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private QueueDtlsDAO queueDtlsDAO;

	/**
	 * This method is called to get queue details by queue name
	 *
	 * @param queueDetails
	 * 
	 * @return queue details for particular queue name
	 * @exception - ApplicationException in case of error
	 */
	public QueueDetails getQueueDtlsByQueueName(QueueDetails queueDtls)
			throws ApplicationException {
		log.info("Entered inside QueueDtlsServiceImpl:getQueueDtlsByQueueName():");
		QueueDetails queueDtlsByQueueName = null;
		try {
			queueDtlsByQueueName = queueDtlsDAO
					.getQueueDtlsByQueueName(queueDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"QueueDtlsServiceImpl.getQueueDtlsByQueueName", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:getQueueDtlsByQueueName() method");
		return queueDtlsByQueueName;
	}

	/**
	 * This method is called to get list of queue details
	 *
	 * @return list of queue details
	 * @exception - ApplicationException in case of error
	 */
	public List<QueueDetails> getQueueDtls() throws ApplicationException {
		log.info("Entered inside QueueDtlsServiceImpl:getQueueDtls():");
		List<QueueDetails> quedtls = null;
		try {
			quedtls = queueDtlsDAO.getQueueDtls();
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("QueueDtlsServiceImpl.getQueueDtls",
					e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:getQueueDtls() method");
		return quedtls;
	}

	/**
	 * This method is called to save queue details
	 * 
	 * @param queueDetails
	 * @return
	 * @exception - ApplicationException in case of error
	 */
	public void saveQueue(QueueDetails queueDetails)
			throws ApplicationException {
		log.info("Entered inside QueueDtlsServiceImpl:saveQueue():");
		try {
			if (queueDetails.getQueId() == 0) {
				queueDtlsDAO.addQueue(queueDetails);
			}
			queueDtlsDAO.updateQueue(queueDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("QueueDtlsServiceImpl.saveQueue", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:saveQueue() method");
	}

	/**
	 * This method is called to validate queue name
	 * 
	 * @param queueDetails
	 * @return
	 * @exception - ApplicationException in case of error
	 */
	public int validateQueName(QueueDetails queueDetails)
			throws ApplicationException {
		log.info("Entered inside QueueDtlsServiceImpl:validateQueName():");
		int temp = 0;
		try {
			temp = queueDtlsDAO.validateQueName(queueDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"QueueDtlsServiceImpl.validateQueName", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:validateQueName() method");
		return temp;
	}

}
