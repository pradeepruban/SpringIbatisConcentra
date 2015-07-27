/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.remote.client.api.RemoteRuntimeEngineFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.ApplicationDtlsDAO;
import com.syntel.syntbots.itops.dao.IncdntExecDtlsDAO;
import com.syntel.syntbots.itops.dao.IncdntExecPrmDtlsDAO;
import com.syntel.syntbots.itops.dao.QueueDtlsDAO;
import com.syntel.syntbots.itops.dao.SopParamDtlsDAO;
import com.syntel.syntbots.itops.dao.WrkflwDtlsDAO;
import com.syntel.syntbots.itops.dao.WrkflwPrmLnkDAO;
import com.syntel.syntbots.itops.dto.ApplicationDetails;
import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
import com.syntel.syntbots.itops.dto.QueueDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.dto.WorkflowDetails;
import com.syntel.syntbots.itops.dto.WorkflowParamLnk;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.AsynchTaskExecutorUtil;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * Incident Execution Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("incidentExecutionService")
public class IncidentExecutionServiceImpl implements IncidentExecutionService {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private IncdntExecDtlsDAO incidentExecDtlsDAO;

	@Autowired
	private IncdntExecPrmDtlsDAO incidentExecParamDtlsDAO;

	@Autowired
	private SopParamDtlsDAO sopParamDtlsDAO;

	@Autowired
	private WrkflwDtlsDAO workflowDtlsDAO;

	@Autowired
	private WrkflwPrmLnkDAO workflowParamLnkDAO;

	@Autowired
	private QueueDtlsDAO queueDtlsDAO;

	@Autowired
	private ApplicationDtlsDAO applctnDtlsDAO;

	@Autowired
	private SyntBotsITOpsUtillService syntBotsITOpsUtillService;

	@Autowired
	private AsynchTaskExecutorUtil asynchTaskExecutorUtil;

	/**
	 * This method is called to execute incident
	 *
	 * @param Incident
	 *            execution details
	 * @return void
	 * @exception - ApplicationException in case of error
	 */
	public void executeIncident(IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		log.info("Entered inside IncidentExecutionServiceImpl::executeIncident()");
		if (incidentExecDtls != null) {
			log.info("incidentExecDtls is:" + incidentExecDtls + ":");
		} else {
			log.info("incidentExecDtls is null");
		}
		try {
			ApplicationDetails applctnDtls = new ApplicationDetails();
			applctnDtls.setApplnName(incidentExecDtls.getApplnName());
			log.info("while trying to get Application Details, ApplnName is:"
					+ incidentExecDtls.getApplnName() + ":");
			ApplicationDetails retrnApplicationDtls = applctnDtlsDAO
					.getApplicationDtls(applctnDtls);
			log.info("retrnApplicationDtls  is:" + retrnApplicationDtls + ":");

			QueueDetails queDtls = new QueueDetails();
			queDtls.setQueName(incidentExecDtls.getQueName());
			log.info("while trying to get Que Details, QueName is:"
					+ incidentExecDtls.getQueName() + ":");
			QueueDetails retrnQueDtls = queueDtlsDAO
					.getQueueDtlsByQueueName(queDtls);
			log.info("retrnQueDtls is:" + retrnQueDtls + ":"
					+ retrnQueDtls.getQueId());
			WorkflowDetails workflowDtlsById = new WorkflowDetails();
			workflowDtlsById.setWrkflwId(incidentExecDtls.getWrkflwId());
			workflowDtlsById = workflowDtlsDAO
					.getWorkFlowDtls(workflowDtlsById);
			log.info("Got Work Flow Details successfully and workflow is:"
					+ workflowDtlsById);

			List<WorkflowParamLnk> workflowParamLinkList = workflowParamLnkDAO
					.getWorkflowParamLinkDtls(workflowDtlsById);
			if (workflowParamLinkList == null) {
				workflowParamLinkList = new ArrayList<WorkflowParamLnk>();
			}
			log.info("workflowParamLinkList  is:" + workflowParamLinkList + ":");

			SopParamDetails sopParamDtls = new SopParamDetails();
			sopParamDtls.setSopId(incidentExecDtls.getSopId());
			List<SopParamDetails> sopParamDetailsList = sopParamDtlsDAO
					.getSopParamDtls(sopParamDtls);

			incidentExecDtls.setApplnId(retrnApplicationDtls.getApplnId());
			incidentExecDtls.setQueId(retrnQueDtls.getQueId());
			List<IncidentExecParamDtls> incidentExecParamDtlsListFromUser = incidentExecDtls
					.getIncidentExecParamDtlsList();
			log.info("***************paramaters***********"
					+ incidentExecParamDtlsListFromUser);
			log.info("before insertion incidentExecDtls is:" + incidentExecDtls);
			incidentExecDtlsDAO.insertIncidentExecDtls(incidentExecDtls);
			log.info("inserted into Incident Execution Details successfully");

			IncidentExecDtls retIncidentExecDtls = incidentExecDtlsDAO
					.getMaxIncidentExecIdBasedOnIncidentId(incidentExecDtls);
			int incidentExecId = retIncidentExecDtls.getIncidentExecId();
			String incidentId = incidentExecDtls.getIncidentId();
			log.info("incidentExecDtls.getIncidentExecId() is:"
					+ incidentExecId + ":");

			List<IncidentExecParamDtls> incidentExecParamDtlsListToStore = new ArrayList<IncidentExecParamDtls>();
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("incidentExecId", Integer.toString(incidentExecId));
			paramMap.put("incidentId", incidentId);
			paramMap.put("incdntDtlsId",
					Integer.toString(incidentExecDtls.getIncdntDtlsId()));

			String strParamValue = "";
			IncidentExecParamDtls tempIncidentExecParamDtlsToStore = null;
			for (WorkflowParamLnk tempWorkflowParamLnk : workflowParamLinkList) {

				log.info("tempWorkflowParamLnk is:" + tempWorkflowParamLnk);
				if (tempWorkflowParamLnk.getParamToBeShown() == 0) {
					log.info("inside tempWorkflowParamLnk.getParamToBeShown() == 0");
					strParamValue = tempWorkflowParamLnk.getParamDefaultValue();
					// log.info("strParamValue is:"+strParamValue+":");
					if (tempWorkflowParamLnk.getConsiderSopParamDtl() == 1) {
						log.info("inside tempWorkflowParamLnk.getConsiderSopParamDtl() == 1");
						for (SopParamDetails sopParamDetails : sopParamDetailsList) {
							if (tempWorkflowParamLnk.getParamCode()
									.equalsIgnoreCase(
											sopParamDetails.getParamCode())) {
								strParamValue = sopParamDetails.getParamValue();
							}
						}
					}
					// log.info("strParamValue after sopParamDetails is considered  is:"+strParamValue+":");

				} else {
					for (IncidentExecParamDtls objIncidentExecParamDtls : incidentExecParamDtlsListFromUser) {
						log.info("tempWorkflowParamLnk.getParamName() is:"
								+ tempWorkflowParamLnk.getParamName()
								+ ":objIncidentExecParamDtls.getParamName:"
								+ objIncidentExecParamDtls.getParamName() + ":");
						log.info("tempWorkflowParamLnk.getParamCode() is:"
								+ tempWorkflowParamLnk.getParamCode()
								+ ":objIncidentExecParamDtls.getParamCode:"
								+ objIncidentExecParamDtls.getParamCode() + ":");
						if (tempWorkflowParamLnk
								.getParamCode()
								.equalsIgnoreCase(
										objIncidentExecParamDtls.getParamCode())) {
							strParamValue = objIncidentExecParamDtls
									.getParamValue();
							// log.info("inside if names match, strParamValue is:"+strParamValue+":");
						}
					}
				}

				if (tempWorkflowParamLnk.getParamToBeEncrypted() == 1) {
					strParamValue = syntBotsITOpsUtillService
							.encryptData(strParamValue);
				}

				// log.info("in assigning paramMap for ParamName:"+tempWorkflowParamLnk.getParamName()+", Param Code is:"+tempWorkflowParamLnk.getParamCode()+", strParamValue is:"+strParamValue+":");
				paramMap.put(tempWorkflowParamLnk.getParamCode(), strParamValue);

				if (!(tempWorkflowParamLnk.getParamToBeStored() == 0)) {
					tempIncidentExecParamDtlsToStore = new IncidentExecParamDtls();
					tempIncidentExecParamDtlsToStore
							.setIncidentExecId(incidentExecId);
					tempIncidentExecParamDtlsToStore
							.setParamName(tempWorkflowParamLnk.getParamName());
					tempIncidentExecParamDtlsToStore
							.setParamCode(tempWorkflowParamLnk.getParamCode());
					tempIncidentExecParamDtlsToStore
							.setParamValue(strParamValue);
					tempIncidentExecParamDtlsToStore.setDeleteFlag(0);
					tempIncidentExecParamDtlsToStore
							.setCreatedBy(incidentExecDtls.getUsrId());
					tempIncidentExecParamDtlsToStore
							.setCreatedDate(new java.util.Date());

					incidentExecParamDtlsListToStore
							.add(tempIncidentExecParamDtlsToStore);
				}

			}

			// log.info("paramMap is:"+paramMap+":");

			for (IncidentExecParamDtls tempIncidentExecParamDtls : incidentExecParamDtlsListToStore) {
				incidentExecParamDtlsDAO
						.insertIncidentExecParamDtls(tempIncidentExecParamDtls);
			}
			log.info("inserted into Incident Execution Param Details successfully");

			String instanceUrl = workflowDtlsById.getWrkflwUrl();
			String userName = workflowDtlsById.getWrkflwUsername();
			String password = workflowDtlsById.getWrkflwPassword();
			String deploymentId = workflowDtlsById.getWrkflwDeploymentId();
			String definitionId = workflowDtlsById.getWrkflwDefinitionId();

			log.info("instanceUrl is:" + instanceUrl + ":userName:" + userName
					+ ":deploymentId:" + deploymentId + ":definitionId:"
					+ definitionId + ":");

			/**** start sending request to BPM ****/
			RuntimeEngine engine = RemoteRuntimeEngineFactory.newRestBuilder()
					.addUrl(new URL(instanceUrl)).addUserName(userName)
					.addPassword(password).addDeploymentId(deploymentId)
					.addTimeout(600).build();

			KieSession ksession = engine.getKieSession();

			// log.info("param map is : " + paramMap);
			asynchTaskExecutorUtil.startProcess(ksession, paramMap,
					definitionId);
			log.info("BPM Process started");
			/**** end sending request to BPM ****/
			log.info("Just before leaving IncidentExecutionServiceImpl::executeIncident()");

		}catch (ApplicationException e) {
			throw e;
		}catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.executeIncident", e);
		}
	}

	/**
	 * This method is called to update incident execution status from workflow
	 *
	 * @param incident
	 *            execution details
	 * @return void
	 * @exception - ApplicationException in case of error
	 */
	public void updateIncidentExecStatusFromWorkflow(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {
		try {
			incidentExecDtlsDAO
					.updateIncidentExecStatusFromWorkflow(incidentExecDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.updateIncidentExecStatusFromWorkflow", e);
		}
	}

	/**
	 * This method is called to get list of incident execution details
	 *
	 * @param incidentExecDtls
	 * @return list of IncidentExecDtls
	 * @exception - ApplicationException in case of error
	 */
	public List<IncidentExecDtls> getIncidentExecDtlsList(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {

		List<IncidentExecDtls> incidentExecDtlsList = null;
		try {
			incidentExecDtlsList = incidentExecDtlsDAO
					.getIncidentExecDtlsList(incidentExecDtls);
			for (IncidentExecDtls incidentExecTemp : incidentExecDtlsList) {
				int incidentExecId = incidentExecTemp.getIncidentExecId();
				List<IncidentExecParamDtls> incidentExecParamDtlsById = incidentExecDtlsDAO
						.getIncidentParamListByIncdntExcId(incidentExecId);
				incidentExecTemp
						.setIncidentExecParamDtlsList(incidentExecParamDtlsById);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.getIncidentExecDtlsList", e);
		}
		return incidentExecDtlsList;
	}

	/**
	 * This method is called to get maximum incident execution Id based on
	 * incident Id
	 *
	 * @param incidentExecDtls
	 * @return IncidentExecDtls DTO
	 * @exception - ApplicationException in case of error
	 */
	public IncidentExecDtls getMaxIncidentExecIdBasedOnIncidentId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {
		IncidentExecDtls incidentExecDtlsMax = null;
		try {
			incidentExecDtlsDAO
					.getMaxIncidentExecIdBasedOnIncidentId(incidentExecDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.getMaxIncidentExecIdBasedOnIncidentId", e);
		}
		return incidentExecDtlsMax;
	}

	/**
	 * This method is called to get list of incident execution details based on
	 * incident execution Id
	 *
	 * @param incidentExecDtls
	 * @return list of IncidentExecDtls DTO
	 * @exception - ApplicationException in case of error
	 */
	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentExecId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {
		List<IncidentExecDtls> incidentExecDtlsByIncidentExecId = null;
		try {
			incidentExecDtlsByIncidentExecId = incidentExecDtlsDAO
					.getIncidentExecDtlsByIncidentExecId(incidentExecDtls);

			for (IncidentExecDtls incidentExecTemp : incidentExecDtlsByIncidentExecId) {
				int incidentExecId = incidentExecTemp.getIncidentExecId();
				List<IncidentExecParamDtls> incidentExecParamDtlsById = incidentExecDtlsDAO
						.getIncidentParamListByIncdntExcId(incidentExecId);
				incidentExecTemp
						.setIncidentExecParamDtlsList(incidentExecParamDtlsById);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.getIncidentExecDtlsByIncidentExecId", e);
		}
		return incidentExecDtlsByIncidentExecId;
	}

	/**
	 * This method is called to get list of incident execution details Id based
	 * on incident Id
	 *
	 * @param incidentExecDtls
	 * @return list of IncidentExecDtls DTO
	 * @exception - ApplicationException in case of error
	 */
	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {
		List<IncidentExecDtls> incidentExecDtlsByIncidentId = null;
		try {

			incidentExecDtlsByIncidentId = incidentExecDtlsDAO
					.getIncidentExecDtlsByIncidentId(incidentExecDtls);
			for (IncidentExecDtls incidentExecTemp : incidentExecDtlsByIncidentId) {
				int incidentExecId = incidentExecTemp.getIncidentExecId();
				List<IncidentExecParamDtls> incidentExecParamDtlsById = incidentExecDtlsDAO
						.getIncidentParamListByIncdntExcId(incidentExecId);
				incidentExecTemp
						.setIncidentExecParamDtlsList(incidentExecParamDtlsById);
			}
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.getIncidentExecDtlsByIncidentId", e);
		}
		return incidentExecDtlsByIncidentId;
	}

	/**
	 * This method is called to update incident execution details from workflow
	 *
	 * @param incidentExecDtls
	 * @return void
	 * @exception - ApplicationException in case of error
	 */
	public void updateIncidentExecFromWorkflow(IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		try {
			incidentExecDtlsDAO
					.updateIncidentExecFromWorkflow(incidentExecDtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("IncidentExecutionServiceImpl.updateIncidentExecFromWorkflow", e);
		}
	}

}
