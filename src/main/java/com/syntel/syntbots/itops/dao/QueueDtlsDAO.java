/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.dao;

import java.util.List;

import com.syntel.syntbots.itops.dto.QueueDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the DAO layer methods related to Queue Details
 * DAO.
 *
 * @author Syntel
 * @version 1.0
 */

public interface QueueDtlsDAO {

	public QueueDetails getQueueDtlsByQueueName(QueueDetails queueDtls)
			throws ApplicationException;

	public List<QueueDetails> getQueueDtls() throws ApplicationException;

	public void addQueue(QueueDetails queueDetails) throws ApplicationException;

	public void updateQueue(QueueDetails queueDetails)
			throws ApplicationException;

	public int validateQueName(QueueDetails queueDetails)
			throws ApplicationException;
}
