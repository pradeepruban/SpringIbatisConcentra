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

import com.syntel.syntbots.itops.dto.SopParamDetails;
import com.syntel.syntbots.itops.mapper.SopParamDtlsMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to SopParamDtls.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("sopParamDtlsDAO")
public class SopParamDtlsDAOImpl implements SopParamDtlsDAO {

	@Autowired
	private SopParamDtlsMapper sopparamdtlsMapper;

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * This method is called to get all the Sop Param Details by sop Id
	 *
	 * @param sopParamDtls
	 * @returnThis List<SopParamDetails> all the values related SopParam Details
	 * @exception -ApplicationException in case of error
	 */
	public List<SopParamDetails> getSopParamDtls(SopParamDetails sopParamDtls)
			throws ApplicationException {

		log.info("Inside SopParamDtlsDAOImpl ::getSopParamDtls:" + sopParamDtls);
		List<SopParamDetails> retrnsopParamDtlsList = null;
		try {
			retrnsopParamDtlsList = sopparamdtlsMapper
					.getSopParamDtls(sopParamDtls);

			if (retrnsopParamDtlsList == null) {
				retrnsopParamDtlsList = new ArrayList<SopParamDetails>();
			}
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopParamDtls", sopParamDtls);
			throw new ApplicationException("SopMsgLnkDAOImpl.getSopParamDtls",
					e, argsMap);
		}
		log.info("Just before leaving SopParamDtlsDAOImpl.getSopParamDtls, retrnsopParamDtlsList is:"
				+ retrnsopParamDtlsList);

		return retrnsopParamDtlsList;

	}

}