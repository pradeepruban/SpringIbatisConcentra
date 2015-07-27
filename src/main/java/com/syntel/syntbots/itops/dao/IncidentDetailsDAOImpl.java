/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/	
package com.syntel.syntbots.itops.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.syntel.syntbots.itops.dto.IncidentDetails;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.UserDetails;
import com.syntel.syntbots.itops.mapper.IncidentDetailsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;


/**
*This class contains all the DAO layer methods related to Incident.
*@author Syntel
*@version 1.0
*/
@Repository("incidentDAO")
public class IncidentDetailsDAOImpl implements IncidentDetailsDAO{
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private IncidentDetailsMapper  incidentMapper;


	/**
	*This method is called to get all the   Closed Incident Details  by userdetails
	*@param  userDetails
	*@returnThis List<IncidentDetails> all the values related userDetails  
	*@exception -  ApplicationException in case of error
	*/
	public List<IncidentDetails> getClosedIncidentList(UserDetails userDetails) throws ApplicationException {
		log.info("inside IncidentDetailsDAOImpl:getClosedIncidentList()");
		List<IncidentDetails> closedIncidentList = null;
		try{
			closedIncidentList = incidentMapper.getClosedIncidentList(userDetails);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("userDetails",userDetails);
			throw new ApplicationException("IncidentDetailsDAOImpl.getClosedIncidentList", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getClosedIncidentList()");
		return  closedIncidentList;
	}
	
	
	/**
	*This method is called to get all the   IncidentDetails by userdetails
	*@param  userDetails
	*@returnThis List<IncidentDetails> all the values related userDetails  
	*@exception -  ApplicationException in case of error
	*/
	public List<IncidentDetails> getIncidentListForUser(UserDetails userDetails) throws ApplicationException {	
		log.info("inside IncidentDetailsDAOImpl:getIncidentListForUser()");
		List<IncidentDetails> incidentDetailsForUser= null;
		try{
		incidentDetailsForUser = incidentMapper.getIncidentListForUser(userDetails);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("userDetails",userDetails);
			throw new ApplicationException("IncidentDetailsDAOImpl.getIncidentListForUser", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getIncidentListForUser()");
		return incidentDetailsForUser;
	}

	/**
	*This method is called to  get Incident By Id
	*@param 
	*@returnThis List<IncidentDetails> all the values related IncidentDetails  
	*@exception - 
	*/
	
	public IncidentDetails getIncidentById(Integer incdntDtlsId) throws ApplicationException {	
		log.info("inside IncidentDetailsDAOImpll:getIncidentById()");
		IncidentDetails incdntDtlsById=null;
		try{
		incdntDtlsById =incidentMapper.getIncidentById(incdntDtlsId);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("incdntDtlsId",incdntDtlsId);
			throw new ApplicationException("IncidentDetailsDAOImpl.getIncidentById", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getIncidentById()");
		return incdntDtlsById;
	}
	

	
	/**
	*This method is called to get the  WorkflowId
	*@param workflowName
	*@returnThis string of workflowName by Id  
	*@exception -  ApplicationException in case of error
	*/
	public int getWorkflowId(String workflowName)throws ApplicationException {
		log.info("inside IncidentDetailsDAOImpl:getWorkflowId()");
		int workflowId = 0;
		try{
			workflowId = incidentMapper.getWorkflowId(workflowName);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("workflowName",workflowName);
			throw new ApplicationException("IncidentDetailsDAOImpl.getWorkflowId", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getWorkflowId()");
		return workflowId;
	}


	
	/**
	*This method is called to get all the   Open Incident by logged user 
	*@param userDetails
	*@returnThis integer of sever incident count related User  
	*@exception -  ApplicationException in case of error
	*/
	
	public int getOpenIncidentsForLoggedInUser(UserDetails userDetails)throws ApplicationException {
		log.info("inside IncidentDetailsDAOImpl:getOpenIncidentsForLoggedInUser()");
		int openIncidents = 0;
		try{
			openIncidents = incidentMapper.getOpenIncidentsForLoggedInUser(userDetails);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("userDetails",userDetails);
			throw new ApplicationException("IncidentDetailsDAOImpl.getOpenIncidentsForLoggedInUser", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getOpenIncidentsForLoggedInUser()");
		return openIncidents;
	}

	
	/**
	*This method is called to get all the   severe Incidents by logged user 
	*@param userDetails
	*@returnThis integer of incident count related User  
	*@exception -  ApplicationException in case of error
	*/
	public int getsevereIncidentsForLoggedInUser(UserDetails userDetails) throws ApplicationException{
		log.info("inside IncidentDetailsDAOImpl:getsevereIncidentsForLoggedInUser()");
		int severeIncidents = 0;
		try{
			severeIncidents = incidentMapper.getsevereIncidentsForLoggedInUser(userDetails);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("userDetails",userDetails);
			throw new ApplicationException("IncidentDetailsDAOImpl.getsevereIncidentsForLoggedInUser", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl: getsevereIncidentsForLoggedInUser()");
		return severeIncidents;
	}

	/**
	*This method is called to get incident list by incident opendate 
	*@param incidentDetails
	*@returnThis List<IncidentDetails>
	*@exception -  ApplicationException in case of error
	*/
	public List<IncidentDetails> getIncidentListByIncidentOpendate(
			IncidentDetails incidentDetails ) throws ApplicationException {
		List<IncidentDetails> returndList = null;
		log.info("insideIncidentDetailsDAOImpl:getIncidentListByIncidentOpendate()");
		try{
		returndList=incidentMapper.getIncidentListByIncidentOpendate(incidentDetails);
		log.info("IncidentDetails returndList is from DaoImpl"+returndList);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("incidentDetails",incidentDetails);
			throw new ApplicationException("IncidentDetailsDAOImpl.getIncidentListByIncidentOpendate", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getIncidentListByIncidentOpendate()");
		return returndList;
	}


	/**
	*This method is called to get incident details by incident id 
	*@param incdntDtlsId
	*@returnThis IncidentDetails
	*@exception -  ApplicationException in case of error
	*/
	public IncidentDetails getlistIncidentDetailsById(Integer incdntDtlsId)
			throws ApplicationException {
		log.info("inside IncidentDetailsDAOImpl:getlistIncidentDetailsById()");
		IncidentDetails incidentDeatilsList = null;
		try{
			  incidentDeatilsList =  incidentMapper.getlistIncidentDetailsById(incdntDtlsId);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("incdntDtlsId",incdntDtlsId);
			throw new ApplicationException("IncidentDetailsDAOImpl.getlistIncidentDetailsById", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getlistIncidentDetailsById()");
			return incidentDeatilsList;
			
			
		}


	/**
	*This method is called to get sop list  by incident id 
	*@param incdntAppName,IncdntAssgnmntGrp
	*@returnThis List<SopDetails>
	*@exception -  ApplicationException in case of error
	*/
	public List<SopDetails> getSopListByIncidentId(String incdntAppName ,String IncdntAssgnmntGrp) throws ApplicationException {
		List<SopDetails> sopDetailsList = null;
		log.info("inside incidentDaoImpl:getSopListByIncidentId()");
		try{
		 sopDetailsList =  incidentMapper.getSopListByIncidentId(incdntAppName,IncdntAssgnmntGrp);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("incdntAppName",incdntAppName);
			argsMap.put("IncdntAssgnmntGrp",IncdntAssgnmntGrp);
			throw new ApplicationException("IncidentDetailsDAOImpl.getSopListByIncidentAppnameAndAssGrp", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl:getSopListByIncidentId()");
		return sopDetailsList;
	}


	/**
	*This method is called to get sop list  by incident id 
	*@param incdntAppName,IncdntAssgnmntGrp
	*@returnThis List<SopDetails>
	*@exception -  ApplicationException in case of error
	*/
	public List<SopDetails> getSopListByIncidentid(String incidentId) throws ApplicationException {
		List<SopDetails> sopDetailsList = null;
		log.info("inside incidentDaoImpl:getSopListByIncidentid");
		try{
		 sopDetailsList =  incidentMapper.getSopListByIncidentid(incidentId);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("incidentId",incidentId);
			throw new ApplicationException("IncidentDetailsDAOImpl.getSopListByIncidentid", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl: getSopListByIncidentid()");
		return sopDetailsList;
	}


	/**
	*This method is used to save  sop  incident details
	*@param incdntAppName,IncdntAssgnmntGrp
	*@returnThis List<SopDetails>
	*@exception -  ApplicationException in case of error
	*/
	public void saveIncidentDtls(IncidentDetails incidentDetails)throws ApplicationException {
		log.info("inside incidentDaoImpl:saveIncidentDtls");
		try{
		incidentMapper.saveIncidentDtls(incidentDetails);
		}catch(Exception e){
			Map argsMap = new HashMap();
			argsMap.put("incidentDetails",incidentDetails);
			throw new ApplicationException("IncidentDetailsDAOImpl.saveIncidentDtls", e, argsMap);
		}
		log.info("Just before leaving IncidentDetailsDAOImpl: saveIncidentDtls()");
	}



}
