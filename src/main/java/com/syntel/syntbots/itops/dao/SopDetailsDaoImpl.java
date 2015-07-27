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

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.mapper.SopDetailsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;


/**
*This class contains all the DAO layer methods related to SopDetailsDao.
*@author Syntel
*@version 1.0
*/
@Repository("sopDetailsDao")
public class SopDetailsDaoImpl implements SopDetailsDao{
	
	 private Logger log = Logger.getLogger(this.getClass());
	 @Autowired
	 private SopDetailsMapper  sopDetailsMapper;

	 
	/**
	*This method is called to get all the   Sop Details 
	*@param  
	*@returnThis List<SopDtlsDTO> all the values related SopDtlsDTO  
	*@exception - ApplicationException in case of error 
	*/
	 public List<SopDetails> getSopDetailsToView() throws ApplicationException{
		    log.info("Entered inside SopDetailsDAOImpl:getSopDetailsToView():");
		    List<SopDetails> sopDtls = null;
		    try {
			 sopDtls=sopDetailsMapper.getSopDetailsToView();
		    }catch (Exception e) {
					throw new ApplicationException("SopDetailsDAOImpl.getSopDetailsToView",
							e);
				}
			log.info("Just before leaving SopDetailsDAOImpl:getSopDetailsToView()");
			return  sopDtls;
	}

	/**
	*This method is called to get all the Sop Param Details To View by sopId
	*@param  sopId
	*@returnThis List<SopParamDetails> all the values related Sop Param Details  
	*@exception - ApplicationException in case of error  
	*/
	public List<SopParamDetails> getSopParamDetailsToView(int sopId) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:getSopParamDetailsToView():");
		List<SopParamDetails> sopParamDtls =  null;
		 try {
		sopParamDtls=sopDetailsMapper.getSopParamDetailsToView(sopId);
		 }catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("sopId", sopId);
				throw new ApplicationException("SopDetailsDAOImpl.getSopParamDetailsToView",
						e, argsMap);
			}
		log.info("Just before leaving SopDetailsDAOImpl:getSopParamDetailsToView()");
		return  sopParamDtls;
	}
	/**
	*This method is called to insert SOP details
	*@param  SOP details 
	*@return void
	 * @throws ApplicationException 
	*@exception -  ApplicationException in case of error
	*/
	public void addSOPDtls(SopDetails sopDetails) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:addSOPDtls():");
		 try {
		sopDetailsMapper.addSOPDtls(sopDetails);
		 }catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("sopDetails", sopDetails);
				throw new ApplicationException("SopDetailsDAOImpl.addSOPDtls",
						e, argsMap);
			}
		log.info("Just before leaving SopDetailsDAOImpl:addSOPDtls()");
	}
	/**
	*This method is called to update SOP details
	*@param  SOP details 
	*@return void
	 * @throws ApplicationException 
	*@exception -  ApplicationException in case of error
	*/
	public void updateSOPDtls(SopDetails sopDetails) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:updateSOPDtls():");
		 try {
		sopDetailsMapper.updateSOPDtls(sopDetails);
		 }catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("sopDetails", sopDetails);
				throw new ApplicationException("SopDetailsDAOImpl.updateSOPDtls",
						e, argsMap);
			}
		log.info("Just before leaving SopDetailsDAOImpl:updateSOPDtls()");
	}
	/**
	*This method is called to get count of sop name for given sop name
	*@param SOP details
	*@return int count
	 * @throws ApplicationException 
	*@exception -  ApplicationException in case of error
	*/
	public int validateSOPName(SopDetails sopDetails) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:validateSOPName():");
		int temp = 0;
		 try {
		   temp=sopDetailsMapper.validateSOPName(sopDetails);
		 }catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("sopDetails", sopDetails);
				throw new ApplicationException("SopDetailsDAOImpl.validateSOPName",
						e, argsMap);
			}
		log.info("Just before leaving SopDetailsDAOImpl:validateSOPName()");
		return temp;
	}
	/**
	*This method is called to add new SOP param details
	*@param sop param details
	*@return void
	 * @throws ApplicationException 
	*@exception - ApplicationException in case of error
	*/
	public void addSOPParamDtls(SopParamDetails sopParamDetails) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:addSOPParamDtls():");
		 try {
		sopDetailsMapper.addSOPParamDtls(sopParamDetails);
		 }catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("sopParamDetails", sopParamDetails);
				throw new ApplicationException("SopDetailsDAOImpl.addSOPParamDtls",
						e, argsMap);
			}
		log.info("Just before leaving SopDetailsDAOImpl:addSOPParamDtls()");
	}
	/**
	*This method is called to get count of sop param code for given sop name
	*@param SOP param details
	*@return int count
	 * @throws ApplicationException 
	*@exception -  ApplicationException in case of error
	*/
	public int validateSOPParamCode(SopParamDetails sopParamDetails) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:validateSOPParamCode:");
		int tempParamCode = 0;
		 try {
		 tempParamCode=sopDetailsMapper.validateSOPParamCode(sopParamDetails);
		 }catch (Exception e) {
				Map argsMap = new HashMap();
				argsMap.put("sopParamDetails", sopParamDetails);
				throw new ApplicationException("SopDetailsDAOImpl.validateSOPParamCode",
						e, argsMap);
			}
		log.info("Just before leaving SopDetailsDAOImpl:validateSOPParamCode");
		return tempParamCode;
	}
	/**
	*This method is called to update SOP param details
	*@param  SOP param details 
	*@return void
	 * @throws ApplicationException 
	*@exception -  ApplicationException in case of error
	*/
	public void updateSOPParamDtls(SopParamDetails sopParamDetails) throws ApplicationException {
		log.info("Entered inside SopDetailsDAOImpl:updateSOPParamDtls:");
		try {
		sopDetailsMapper.updateSOPParamDtls(sopParamDetails);
		}catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopParamDetails", sopParamDetails);
			throw new ApplicationException("SopDetailsDAOImpl.updateSOPParamDtls",
					e, argsMap);
		}
		log.info("Just before leaving SopDetailsDAOImpl:updateSOPParamDtls");
		
	}
}

