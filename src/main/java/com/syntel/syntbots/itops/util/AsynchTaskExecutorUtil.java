/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
package com.syntel.syntbots.itops.util;

import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.springframework.core.task.TaskExecutor;
/**
 * This class contains the utility methods used in the application 
 * @author Syntel
 * @version 1.0
 */

public class AsynchTaskExecutorUtil {

	private class BPMProcessStartTask implements Runnable {
		Logger log = Logger.getLogger(this.getClass());

		private KieSession ksession;
		private Map paramMap;
		private String definitionId;
		/**
		 * This is just constructor method to class BPMProcessStartTask 
		 
		 */
		
		public BPMProcessStartTask(KieSession ksession, Map paramMap,
				String definitionId) {
			this.ksession = ksession;
			this.paramMap = paramMap;
			this.definitionId = definitionId;

		}

		public void run() {

			/**** start sending request to BPM ****/
			log.info("sending BPM request aynch");
			ProcessInstance pi = ksession.startProcess(definitionId, paramMap);
			log.info("Sent BPM request aynch" +pi);

			/**** end sending request to BPM ****/

		}

	}

	private TaskExecutor taskExecutor;

	public AsynchTaskExecutorUtil(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	/**
	 * This is  method to start the JBPM process to and 
	 @param ksession,paramMap,definitionId
	 */
	
	
	public void startProcess(KieSession ksession, Map paramMap, String definitionId)  throws ApplicationException{
		try{
	
			taskExecutor.execute(new BPMProcessStartTask( ksession,  paramMap,  definitionId));
		}
		   catch(Exception e)
			{
					throw new ApplicationException(e); 
			}
	}
}