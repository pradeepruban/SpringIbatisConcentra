/***********************************************************
 *Copyright (C) 2015 Syntel and/or its affiliates
 *All rights reserved.
 ************************************************************/
package com.syntel.syntbots.itops.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntel.syntbots.itops.dao.SopDetailsDao;
import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the Service implementation layer methods related to
 * SOP Details.
 *
 * @author Syntel
 * @version 1.0
 */
@Service("sopDetailsService")
public class SopDetailsServiceImpl implements SopDetailsService {

	@Autowired
	private SopDetailsDao sopDetailsDAO;

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * This method is called to get list of SOP details
	 *
	 * @return list of SOP details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopDetails> getSopDetailsToView() throws ApplicationException {
		List<SopDetails> sopdtls = new ArrayList<SopDetails>();
		try {

			sopdtls = sopDetailsDAO.getSopDetailsToView();
			log.info("inside SopDetailsServiceImpl: getSopDetailsToView() "
					+ sopdtls);
			for (SopDetails sopdtlsTemp : sopdtls) {
				int sopId = sopdtlsTemp.getSopId();
				log.info("sopId from  sopdtls:" + sopId);
				List<SopParamDetails> SopParamDetailsBysopId = sopDetailsDAO
						.getSopParamDetailsToView(sopId);
				sopdtlsTemp.setSopParamDetails(SopParamDetailsBysopId);
			}
			log.info("inside SopDetailsServiceImpl: getSopDetailsToView()"
					+ sopdtls);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopDetailsServiceImpl.getSopDetailsToView", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:getSopDetailsToView() method");
		return sopdtls;
	}

	/**
	 * This method is called to save SOP details
	 *
	 * @param sopDetails
	 * 
	 * @exception - ApplicationException in case of error
	 */
	public void saveSOPDtls(SopDetails sopDetails) throws ApplicationException {

		log.info("inside SopDetailsServiceImpl: saveSOPDtls() ");
		try {
			if (sopDetails.getSopId() == 0) {
				sopDetailsDAO.addSOPDtls(sopDetails);
			}
			sopDetailsDAO.updateSOPDtls(sopDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException("SopDetailsServiceImpl.saveSOPDtls",
					e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:saveSOPDtls() method");
	}

	/**
	 * This method is called to get count of sopname's for given sop name
	 *
	 * @param sopDetails
	 * 
	 * @return int count
	 * @exception - ApplicationException in case of error
	 */
	public int validateSOPName(SopDetails sopDetails)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: validateSOPName() ");
		int temp = 0;
		try {
			temp = sopDetailsDAO.validateSOPName(sopDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopDetailsServiceImpl.validateSOPName", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:validateSOPName() method");
		return temp;
	}

	/**
	 * This method is to adding SOP param Details
	 *
	 * @param sopParamDetails
	 * 
	 * @return
	 * @exception - ApplicationException in case of error
	 */
	public void addSOPParamDtls(SopParamDetails sopParamDetails)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: addSOPParamDtls() ");
		try {
			sopDetailsDAO.addSOPParamDtls(sopParamDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopDetailsServiceImpl.addSOPParamDtls", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:addSOPParamDtls() method");
	}

	/**
	 * This method is to validate SOP ParamDetails
	 *
	 * @param sopParamDetails
	 * 
	 * @return int tempParamCode
	 * @exception - ApplicationException in case of error
	 */
	public int validateSOPParamCode(SopParamDetails sopParamDetails)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: validateSOPParamCode() ");
		int tempParamCode = 0;
		try {
			tempParamCode = sopDetailsDAO.validateSOPParamCode(sopParamDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopDetailsServiceImpl.validateSOPParamCode", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:validateSOPParamCode() method");
		return tempParamCode;
	}

	/**
	 * This method is to update SOP ParamDetails
	 *
	 * @param sopParamDetails
	 * 
	 * @return
	 * @exception - ApplicationException in case of error
	 */
	public void updateSOPParamDtls(SopParamDetails sopParamDetails)
			throws ApplicationException {
		log.info("inside SopDetailsServiceImpl: updateSOPParamDtls() ");
		try {
			sopDetailsDAO.updateSOPParamDtls(sopParamDetails);
		} catch (ApplicationException e) {
			throw e;
		} catch (Exception e) {
			throw new ApplicationException(
					"SopDetailsServiceImpl.updateSOPParamDtls", e);
		}
		log.info("Just before leaving  QueueDtlsServiceImpl:updateSOPParamDtls() method");

	}
}
