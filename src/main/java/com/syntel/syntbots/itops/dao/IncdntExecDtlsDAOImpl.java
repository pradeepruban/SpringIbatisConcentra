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

import com.syntel.syntbots.itops.dto.IncidentExecDtls;
import com.syntel.syntbots.itops.dto.IncidentExecParamDtls;
import com.syntel.syntbots.itops.mapper.IncdntExecDtlsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Dao impl methods for Incident Executions Details.
 *
 * @author Syntel
 * @version 1.0
 */

@Repository("incidentExecDtlsDAO")
public class IncdntExecDtlsDAOImpl implements IncdntExecDtlsDAO {

	@Autowired
	private IncdntExecDtlsMapper incidentExecDtlsMapper;

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * This method is called to insert Incident Executions Details
	 *
	 * @param incidentExecDtls
	 * @returnThis
	 */

	public void insertIncidentExecDtls(IncidentExecDtls incidentExecDtls)
			throws ApplicationException {

		log.info("Entered inside IncdntExecDtlsDAOImpl::insertIncidentExecDtls() method");
		try {
			incidentExecDtlsMapper.insertIncidentExecDtls(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.insertIncidentExecDtls", e, argsMap);
		}

		log.info("Just before leaving IncdntExecDtlsDAOImpl.insertIncidentExecDtls ");
	}

	/**
	 * This method is called to update Incident Executions Details Status From
	 * Workflow
	 *
	 * @param incidentExecDtls
	 * @returnThis
	 */
	public void updateIncidentExecStatusFromWorkflow(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {
		log.info("Entered inside IncdntExecDtlsDAOImpl::updateIncidentExecStatusFromWorkflow() method");
		try {
			incidentExecDtlsMapper
					.updateIncidentExecStatusFromWorkflow(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.updateIncidentExecStatusFromWorkflow",
					e, argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.updateIncidentExecStatusFromWorkflow ");
	}

	/**
	 * This method is called to get all the Incident Executions Details List
	 *
	 * @param incidentExecDtls
	 * @returnThis List<IncidentExecDtls> all the values related Incident
	 *             Executions Details List
	 */

	public List<IncidentExecDtls> getIncidentExecDtlsList(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {
		List<IncidentExecDtls> incidentExecDtlsList = null;
		log.info("Entered inside IncdntExecDtlsDAOImpl::getIncidentExecDtlsList() method");
		try {
			incidentExecDtlsList = incidentExecDtlsMapper
					.getIncidentExecDtlsList(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.getIncidentExecDtlsList", e, argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.getIncidentExecDtlsList ");
		return incidentExecDtlsList;
	}

	/**
	 * This method is called to get the Max Incident Executions Id Based On
	 * IncidentId
	 *
	 * @param incidentExecDtls
	 * @returnThis LIncidentExecDtls values related IncidentDetails
	 */

	public IncidentExecDtls getMaxIncidentExecIdBasedOnIncidentId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {

		IncidentExecDtls IncidentExecDtlsMax = null;
		log.info("Entered inside IncdntExecDtlsDAOImpl::getMaxIncidentExecIdBasedOnIncidentId() method");
		try {
			IncidentExecDtlsMax = incidentExecDtlsMapper
					.getMaxIncidentExecIdBasedOnIncidentId(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.getMaxIncidentExecIdBasedOnIncidentId",
					e, argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.getMaxIncidentExecIdBasedOnIncidentId ");
		return IncidentExecDtlsMax;
	}

	/**
	 * This method is called to get all the Incident Executions Details By
	 * IncidentExecId
	 *
	 * @param incidentExecDtls
	 * @returnThis List<IncidentExecDtls> all the values related IncidentDetails
	 */

	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentExecId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {

		List<IncidentExecDtls> incidentExecDtlsByIncidentExecId = null;
		log.info("Entered inside IncdntExecDtlsDAOImpl::getIncidentExecDtlsByIncidentExecId() method");
		try {
			incidentExecDtlsByIncidentExecId = incidentExecDtlsMapper
					.getIncidentExecDtlsByIncidentExecId(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.getIncidentExecDtlsByIncidentExecId",
					e, argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.getIncidentExecDtlsByIncidentExecId ");

		return incidentExecDtlsByIncidentExecId;
	}

	/**
	 * This method is called to get all the Incident Executions Details By
	 * IncidentId
	 *
	 * @param incidentExecDtls
	 * @returnThis List<IncidentExecDtls> all the values related
	 *             IncidentExecDtls
	 */

	public List<IncidentExecDtls> getIncidentExecDtlsByIncidentId(
			IncidentExecDtls incidentExecDtls) throws ApplicationException {

		List<IncidentExecDtls> incidentExecDtlsByIncidentId = null;
		log.info("Entered inside IncdntExecDtlsDAOImpl::getIncidentExecDtlsByIncidentId() method");
		try {
			incidentExecDtlsByIncidentId = incidentExecDtlsMapper
					.getIncidentExecDtlsByIncidentId(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.getIncidentExecDtlsByIncidentId", e,
					argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.getIncidentExecDtlsByIncidentId ");
		return incidentExecDtlsByIncidentId;
	}

	/**
	 * This method is called to get all the Incident Param List By IncdntExcId
	 *
	 * @param incidentExecId
	 * @returnThis List<IncidentExecParamDtls> all the values related
	 *             IncidentExecParamDtls
	 */

	public List<IncidentExecParamDtls> getIncidentParamListByIncdntExcId(
			int incidentExecId) throws ApplicationException {
		log.info("Entered inside IncdntExecDtlsDAOImpl::getIncidentParamListByIncdntExcId() method");
		List<IncidentExecParamDtls> incidentExecParamDtlsById = null;
		try {
			incidentExecParamDtlsById = incidentExecDtlsMapper
					.getIncidentParamListByIncdntExcId(incidentExecId);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecId", incidentExecId);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.getIncidentParamListByIncdntExcId",
					e, argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.getIncidentParamListByIncdntExcId ");
		return incidentExecParamDtlsById;
	}

	/**
	 * This method is called to update the Incident Executions From Workflow
	 * based on incidentExecDtls
	 *
	 * @param incidentExecDtls
	 * @returnThis
	 */

	public void updateIncidentExecFromWorkflow(IncidentExecDtls incidentExecDtls)
			throws ApplicationException {
		log.info("Entered inside IncdntExecDtlsDAOImpl::updateIncidentExecFromWorkflow() method");
		try {
			incidentExecDtlsMapper
					.updateIncidentExecFromWorkflow(incidentExecDtls);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("incidentExecDtls", incidentExecDtls);
			throw new ApplicationException(
					"IncdntExecDtlsDAOImpl.updateIncidentExecFromWorkflow", e,
					argsMap);
		}
		log.info("Just before leaving IncdntExecDtlsDAOImpl.updateIncidentExecFromWorkflow ");
	}

}
