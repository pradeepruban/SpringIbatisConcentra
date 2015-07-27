/***********************************************************
  *Copyright (C) 2015 Syntel and/or its affiliates
  *All rights reserved.
************************************************************/

package com.syntel.syntbots.itops.mapper;

import org.apache.ibatis.annotations.Select;


import com.syntel.syntbots.itops.dto.UserDetails;
/**
*This interface contains all the mappers related to Login Details.
*@author Syntel
*@version 1.0
*/


public interface LoginMapper {
	
	/**
	 *This method is used to get authnticated user details 
	 * @param User Details
	 * @return User Details
	 */
	@Select("SELECT usr_id as 'usrId', usr_code as 'usrCode', usr_first_name as 'usrFirstName', usr_password as 'usrPassword', usr_short_name as 'usrShortName' FROM scmn_user_dtls WHERE usr_code = #{usrCode} and AES_DECRYPT(usr_password, 'SyntBots_Passwrd') = #{usrPassword} ")
	public UserDetails authenticateUserDetails(UserDetails userDetails);
	
	/**
	 *This method is used to get user details based on user code
	 * @param User code
	 * @return User Details
	 */
	@Select("SELECT usr_id as 'usrId', usr_code as 'usrCode', usr_first_name as  'usrFirstName', usr_password as 'usrPassword', usr_short_name as 'usrShortName' FROM scmn_user_dtls WHERE usr_code = #{userCode} ")
	public UserDetails getUserDetails(String userCode);


}
