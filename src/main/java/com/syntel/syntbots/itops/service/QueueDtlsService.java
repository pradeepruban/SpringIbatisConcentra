/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.List;

import com.syntel.syntbots.itops.dto.QueueDetails;
import com.syntel.syntbots.itops.util.ApplicationException;

/**
 * This interface contains all the Service layer methods related to Queue
 * Details.
 *
 * @author Syntel
 * @version 1.0
 */
public interface QueueDtlsService {

	QueueDetails getQueueDtlsByQueueName(QueueDetails queueDtls)
			throws ApplicationException;

	List<QueueDetails> getQueueDtls() throws ApplicationException;

	void saveQueue(QueueDetails queueDetails) throws ApplicationException;

	int validateQueName(QueueDetails queueDetails) throws ApplicationException;

}
