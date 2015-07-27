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

import com.syntel.syntbots.itops.dto.SopDetails;
import com.syntel.syntbots.itops.dto.SopMsgLnk;
import com.syntel.syntbots.itops.mapper.SopMsgLnkMapper;
import com.syntel.syntbots.itops.util.ApplicationException;
import com.syntel.syntbots.itops.util.Logger;

/**
 * This class contains all the DAO layer methods related to SopMsgLnk.
 *
 * @author Syntel
 * @version 1.0
 */
@Repository("sopMsgLnkDAO")
public class SopMsgLnkDAOImpl implements SopMsgLnkDAO {

	private Logger log = Logger.getLogger(this.getClass());
	@Autowired
	private SopMsgLnkMapper sopMsgLnkMapper;

	/**
	 * This method is called to Save the SopMsgLnk
	 *
	 * @param sop
	 *            Msg Lnk details
	 * @returnThis
	 * @exception - ApplicationException in case of error
	 */
	public void saveSopMsgLnk(SopMsgLnk sopMsgLnk) throws ApplicationException {
		log.info("Entered inside SopMsgLnkDAOImpl:saveSopMsgLnk():");
		try {
			sopMsgLnkMapper.saveSopMsgLnk(sopMsgLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnk", sopMsgLnk);
			throw new ApplicationException("SopMsgLnkDAOImpl.saveSopMsgLnk", e,
					argsMap);
		}
		log.info("Just before leaving SopMsgLnkDAOImpl:saveSopMsgLnk()");
	}

	/**
	 * This method is called to get all the SopMsgLnk by sopMsgLnk by SOP Id
	 *
	 * @param sop
	 *            Msg Lnk details
	 * @returnThis List<SopMsgLnk> all the values related SopMsgLnk
	 * @exception - ApplicationException in case of error
	 */
	public List<SopMsgLnk> getSopMsgLnkBySopId(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkDAOImpl:getSopMsgLnkBySopId():");
		List<SopMsgLnk> sopMsgLnkBySopId = null;
		try {
			sopMsgLnkBySopId = sopMsgLnkMapper.getSopMsgLnkBySopId(sopMsgLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnk", sopMsgLnk);
			throw new ApplicationException(
					"SopMsgLnkDAOImpl.getSopMsgLnkBySopId", e, argsMap);
		}
		log.info("Just before leaving SopMsgLnkDAOImpl:getSopMsgLnkBySopId()");
		return sopMsgLnkBySopId;
	}

	/**
	 * This method is called to get all the SopMsgLnk By Msg Keyword
	 *
	 * @param sop
	 *            Msg Lnk details
	 * @returnThis List<SopParamDetails> all the values related SopParamDetails
	 * @exception - ApplicationException in case of error
	 */
	public List<SopMsgLnk> getSopMsgLnkByMsgKeyword(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkDAOImpl:getSopMsgLnkByMsgKeyword():");
		List<SopMsgLnk> sopMsgLnkByMsgKeyword = null;
		try {
			sopMsgLnkByMsgKeyword = sopMsgLnkMapper
					.getSopMsgLnkByMsgKeyword(sopMsgLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnk", sopMsgLnk);
			throw new ApplicationException(
					"SopMsgLnkDAOImpl.getSopMsgLnkByMsgKeyword", e, argsMap);
		}
		log.info("Entered inside SopMsgLnkDAOImpl:getSopMsgLnkByMsgKeyword():");
		return sopMsgLnkByMsgKeyword;
	}

	/**
	 * This method is called to update SopMsgLnk By Msg Keyword
	 *
	 * @param sop
	 *            Msg Lnk details
	 * @returnThis List<SopParamDetails> all the values related SopParamDetails
	 * @exception - ApplicationException in case of error
	 */
	public void updateSopMsglnk(SopMsgLnk sopMsgLnk)
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkDAOImpl:updateSopMsglnk():");
		try {
			sopMsgLnkMapper.updateSopMsglnk(sopMsgLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnk", sopMsgLnk);
			throw new ApplicationException("SopMsgLnkDAOImpl.updateSopMsglnk",
					e, argsMap);
		}
		log.info("Entered inside SopMsgLnkDAOImpl:updateSopMsglnk():");
	}

	/**
	 * This method is called to get all the Sop Msg Lnk details
	 *
	 * @param
	 * @returnThis list of Sop Msg Lnk details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopMsgLnk> getCompleteSopMsgLnkList()
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkDAOImpl:getCompleteSopMsgLnkList():");
		List<SopMsgLnk> sopMsgLnkList = null;
		try {
			sopMsgLnkList = sopMsgLnkMapper.getCompleteSopMsgLnkList();
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnkList", sopMsgLnkList);
			throw new ApplicationException(
					"SopMsgLnkDAOImpl.getCompleteSopMsgLnkList", e, argsMap);
		}
		log.info("Entered inside SopMsgLnkDAOImpl:getCompleteSopMsgLnkList():");
		return sopMsgLnkList;
	}

	/**
	 * This method is called to get user short name by created by Id
	 *
	 * @param created
	 *            by
	 * @returnThis user short name
	 * @exception - ApplicationException in case of error
	 */
	public String getUserShortNameByUserId(int createdBy)
			throws ApplicationException {
		log.info("Entered inside SopMsgLnkDAOImpl:getUserShortNameByUserId:");
		String userShortName = null;
		try {
			userShortName = sopMsgLnkMapper.getUserShortNameByUserId(createdBy);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("userShortName", userShortName);
			throw new ApplicationException(
					"SopMsgLnkDAOImpl.getUserShortNameByUserId", e, argsMap);
		}
		log.info("Entered inside SopMsgLnkDAOImpl:getUserShortNameByUserId:");
		return userShortName;
	}

	/**
	 * This method is called to get SOP List based on the message key link
	 * details
	 *
	 * @param messageKey
	 * @return List of SOP details
	 * @exception - ApplicationException in case of error
	 */
	public List<SopDetails> getListSopByMessageKey(SopMsgLnk sopMsgLnk)
			throws ApplicationException {

		log.info("Entered inside SopMsgLnkDAOImpl:getListSopByMessageKey:");
		List<SopDetails> sopListByMsgKey = null;
		try {
			sopListByMsgKey = sopMsgLnkMapper.getListSopByMessageKey(sopMsgLnk);
		} catch (Exception e) {
			Map argsMap = new HashMap();
			argsMap.put("sopMsgLnk", sopMsgLnk);
			throw new ApplicationException(
					"SopMsgLnkDAOImpl.getListSopByMessageKey", e, argsMap);
		}
		log.info("Entered inside SopMsgLnkDAOImpl:getListSopByMessageKey:");
		return sopListByMsgKey;
	}

}
