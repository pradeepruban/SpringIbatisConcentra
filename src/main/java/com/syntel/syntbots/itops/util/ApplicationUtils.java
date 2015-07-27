/* Copyright (C) 2015 Syntel and/or its affiliates. All rights reserved.
 *
 */	
package com.syntel.syntbots.itops.util;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.BeanMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;

import com.syntel.syntbots.itops.dto.UserDetails;

/**
 * This class contains the utility methods used in the application 
 * @author Syntel
 * @version 1.0
 */

public class ApplicationUtils {
	
	
	/**
	 * This is just an over-ridden method to 
	 * populateBeanValuesIntoJSONObject(Object origObj, JSONObject jsonObject, String dateFormat)
	 * to just use the same when specific date format need not to be considered.
	 */
	public static JSONObject populateBeanValuesIntoJSONObject(Object origObj, JSONObject jsonObject) throws Exception
	{
		return populateBeanValuesIntoJSONObject(origObj, jsonObject, SyntBotsITOpsConstants.DATE_FORMAT_MM_DD_YYYY);
	}
	
	/**
	 * This method is called to populate bean values into JSONObject. This method uses Reflection API. This considers only simple properties of the origObj. 
	 * So, if the origObj contains any custom Bean as a property, then that property is not considered.  
	 * In this method, all the different properties of the object are found and the Property Name / Value of the object are stored into JSON object.
	 * @param origObj - This is the Original object whose properties need to be stored into JSONObject. 
	 * @param jsonObject - The JSONObject into which the properties need to be set.
	 * @return JSONObject - The JSONObject in which the object property Name / Values are added.
	 */
	public static JSONObject populateBeanValuesIntoJSONObject(Object origObj, JSONObject jsonObject, String dateFormat) throws Exception
	{
		if(origObj != null)
		{
			BeanMap beanMap = new BeanMap(origObj);
			Set keys = beanMap.keySet();
			Iterator keyIterator = keys.iterator();
			String propertyName ="";
			Class propertyType = null;
			if(jsonObject == null)
			{
				jsonObject = new JSONObject();
			}
			while( keyIterator.hasNext() ) {
				propertyName = (String) keyIterator.next();
				propertyType =  beanMap.getType(propertyName);				
				if(propertyType != null)
				{
					setJSONObjectProperty(propertyName, propertyType, propertyType.toString(), origObj, jsonObject, dateFormat);
				}
			}
		}
		
		return jsonObject;
	}
	
	
	/**
	 * This method puts property Name / value into JSONObject.
	 * @param propertyName - This is the Property Name. With this name only, the value is put into JSONObject.
	 * @param propertyType - This is the Property Type. This is used to find out what kind of property it is.
	 * @param propertyTypeStr - This is the Property Type in the form of String.
	 * @param origObj - This is the Original Object from which the value needs to be taken and set into JSONObject.
	 * @param JSONObject - The JSONObject into which the properties need to be set.
	 */
	public static void setJSONObjectProperty(String propertyName, Class propertyType, String propertyTypeStr, Object origObj, JSONObject jsonObject, String dateFormat) throws Exception
	{
		
		Object propertyValue = null;
		try
		{
			propertyValue = PropertyUtils.getSimpleProperty(origObj, propertyName);
			
			if(propertyType == java.util.Date.class)
			{
				
				if(propertyValue != null)
				{
					if(!StringUtils.hasText(dateFormat))
					{
						dateFormat = SyntBotsITOpsConstants.DATE_FORMAT_MM_DD_YYYY;
					}
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
					String dtPropertyValue = simpleDateFormat.format(propertyValue);					
					jsonObject.put(propertyName, dtPropertyValue);
				}
				
			}			
			else if(propertyValue != null)
			{
				jsonObject.put(propertyName, propertyValue);
			}						
			
		}catch(Exception e)
		{
			
			Map argsMap = new HashMap();
			argsMap.put("propertyName", propertyName);
			argsMap.put("propertyValue", propertyValue);
			argsMap.put("dateFormat", dateFormat);
			argsMap.put("propertyTypeStr", propertyTypeStr);
			throw new ApplicationException("ApplicationUtils.setJSONObjectProperty", e, argsMap);
		}
			
	}
	
	/**
	 * This is just an over-ridden method to 
	 * populateJSONObjectValuesIntoBean(Object origObj, JSONObject jsonObject, String dateFormat)
	 * to just use the same when specific date format need not to be considered.
	 */
	public static Object populateJSONObjectValuesIntoBean(Object origObj, JSONObject jsonObject) throws Exception
	{
		return populateJSONObjectValuesIntoBean(origObj, jsonObject, SyntBotsITOpsConstants.DATE_FORMAT_MM_DD_YYYY);
	}
	
	/**
	 * This method is called to populate JSON Object values into Bean. 
	 * In this method, all the different properties of the origObj are found and for those properties, the corresponding values are found from JSONObject, and the values 
	 * are set into the origObj. This method uses Reflection API. So, if the origObj contains any custom Bean as a property, then that property is not considered.  
	 * @param origObj - This is the Original object whose properties need to be set by taking the corresponding property values from JSONObject. 
	 * @param jsonObject - The JSONObject from which the property values need to be retrieved.
	 * @return Object - The Bean object after setting all the property values.
	 */
	public static Object populateJSONObjectValuesIntoBean(Object origObj, JSONObject jsonObject, String dateFormat) throws Exception
	{
		if(origObj != null)
		{
			BeanMap beanMap = new BeanMap(origObj);
			Set keys = beanMap.keySet();
			Iterator keyIterator = keys.iterator();
			String propertyName ="";
			Class propertyType = null;
			
			while( keyIterator.hasNext() ) {
				propertyName = (String) keyIterator.next();
				propertyType =  beanMap.getType(propertyName);
				
				if(propertyType != null)
				{
					setBeanProperty(propertyName, propertyType, propertyType.toString(), origObj, jsonObject, dateFormat);
				}
			}
		}
		
		return origObj;
	}
	
	
	/**
	 * This method sets property value into origObj.
	 * @param propertyName - This is the Property Name of origObj, into which the value is set.
	 * @param propertyType - This is the Property Type. This is used to find out what kind of property it is.
	 * @param propertyTypeStr - This is the Property Type in the form of String.
	 * @param origObj - This is the Original Object into which the value is set by taking the property value from JSONObject.
	 * @param JSONObject - The JSONObject from which the property value needs to be retrieved.
	 */
	public static void setBeanProperty(String propertyName, Class propertyType, String propertyTypeStr, Object origObj, JSONObject jsonObject, String dateFormat) throws Exception
	{
		
		String propertyValue = null;
		try
		{
			
			propertyValue = getValueFromJSON(jsonObject,propertyName);
			
			if(propertyType == java.lang.String.class)
			{
				if(StringUtils.hasLength(propertyValue))
				{
									
					PropertyUtils.setSimpleProperty(origObj, propertyName, propertyValue);
				}
			}
			else if((propertyType == java.lang.Integer.class) || ((propertyType == int.class)))
			{

				if((StringUtils.hasText(propertyValue)) && (!propertyValue.equals("null")))
				{
					Integer intPropertyValue = Integer.parseInt(propertyValue);
					PropertyUtils.setSimpleProperty(origObj, propertyName, intPropertyValue);
				}
				
			}
			else if((propertyType == java.lang.Long.class) || ((propertyType == long.class)))
			{
			
				if((StringUtils.hasText(propertyValue)) && (!propertyValue.equals("null")))
				{
					Long lngPropertyValue = Long.parseLong(propertyValue);
					PropertyUtils.setSimpleProperty(origObj, propertyName, lngPropertyValue);
				}
				
			}
			else if((propertyType == java.lang.Float.class)  || ((propertyType == float.class)))
			{
			
				if((StringUtils.hasText(propertyValue)) && (!propertyValue.equals("null")))
				{
					Float fltPropertyValue = Float.parseFloat(propertyValue);
					PropertyUtils.setSimpleProperty(origObj, propertyName, fltPropertyValue);
				}
				
			}
			else if((propertyType == java.lang.Double.class) || ((propertyType == double.class)))
			{
				
				if((StringUtils.hasText(propertyValue)) && (!propertyValue.equals("null")))
				{
					Double dblPropertyValue = Double.parseDouble(propertyValue);
					PropertyUtils.setSimpleProperty(origObj, propertyName, dblPropertyValue);
				}
				
			}
			else if(propertyType == java.util.Date.class)
			{
				
				if(StringUtils.hasText(propertyValue))
				{
					if(!StringUtils.hasText(dateFormat))
					{
						dateFormat = SyntBotsITOpsConstants.DATE_FORMAT_MM_DD_YYYY;
					}
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
					java.util.Date dtPropertyValue = simpleDateFormat.parse(propertyValue);					
					PropertyUtils.setSimpleProperty(origObj, propertyName, dtPropertyValue);
				}
				
			}
		}catch(Exception e)
		{
			Map argsMap = new HashMap();
			argsMap.put("propertyName", propertyName);
			argsMap.put("propertyValue", propertyValue);
			argsMap.put("dateFormat", dateFormat);
			argsMap.put("propertyTypeStr", propertyTypeStr);
			throw new ApplicationException("ApplicationUtils.setJSONObjectProperty", e, argsMap);
		}
			
	}
	
	/**
	 * This method gives the value of the property from JSONObject. If the corresponding property is not found in JSONObject, then blank("") is given.
	 * In this method, we can avoid org.json.JSONException, if the corresponding property is not available in JSONObject.
	 * @param JSONObject - The JSONObject from which the property value needs to be extracted.
	 * @param jsonPropertyName - This is the Property Name for which the value need to be found in JSONObject.
	 * @return String - This is the value of the Property from jSONObject.If the corresponding property is not found in JSONObject, then blank("") is given.
	 */
	public static String getValueFromJSON(JSONObject jSONObject,  String jsonPropertyName)
	{
		String jsonPropertyValue = "";
		try
		{
			if( (jSONObject != null) && (StringUtils.hasText(jsonPropertyName)) ) 
			{
				jsonPropertyValue = jSONObject.getString(jsonPropertyName);
			}
		}catch(org.json.JSONException je)
		{
			
		}
		return jsonPropertyValue;
	}
	
	/**
	 * This method gives the trimmed value of the property from JSONObject. If the corresponding property is not found in JSONObject, then blank("") is given.
	 * In this method, we can avoid org.json.JSONException, if the corresponding property is not available in JSONObject.
	 * This is similar to the above method, Except that this trims the output value.
	 * @param JSONObject - The JSONObject from which the property value needs to be extracted.
	 * @param jsonPropertyName - This is the Property Name for which the value need to be found in JSONObject.
	 * @return String - This is the value of the Property from jSONObject.If the corresponding property is not found in JSONObject, then blank("") is given.
	 */
	public static String getTrimmedValueFromJSON(JSONObject jSONObject,  String jsonPropertyName)
	{
		String jsonPropertyValue = "";
		try
		{
			if( (jSONObject != null) && (StringUtils.hasText(jsonPropertyName)) ) 
			{
				jsonPropertyValue = jSONObject.getString(jsonPropertyName);
				if(StringUtils.hasText(jsonPropertyValue))
				{
					jsonPropertyValue = jsonPropertyValue.trim();
				}
			}
		}catch(org.json.JSONException je)
		{
		}
		return jsonPropertyValue;
	}
	
	/**
	 * This method gives the JSONArray value of the property from JSONObject. If the corresponding property is not found in JSONObject, then null is given.
	 * In this method, we can avoid org.json.JSONException, if the corresponding property is not available in JSONObject.
	 * @param JSONObject - The JSONObject from which the property value needs to be extracted.
	 * @param jsonPropertyName - This is the Property Name for which the value need to be found in JSONObject.
	 * @return JSONArray - This is the value of the Property from jSONObject.If the corresponding property is not found in JSONObject, then null is given.
	 */
	public static JSONArray getJSONArrayFromJSON(JSONObject jSONObject,  String jsonPropertyName)
	{
		JSONArray jsonPropertyValue = null;
		try
		{
			if( (jSONObject != null) && (StringUtils.hasText(jsonPropertyName)) ) 
			{
				jsonPropertyValue = jSONObject.getJSONArray(jsonPropertyName);
			}
		}catch(org.json.JSONException je)
		{
		}
		return jsonPropertyValue;
	}
	
	/**
	 * This method gives the URL content in the form of String.
	 * @param urlToRead - URL Value.
	 * @return returns the data.	
	 */
	public String getURLContent(String urlToRead)
	{
		URL url;
	    HttpURLConnection conn;
	    BufferedReader rd;
	    String line;
	    String result = "";
	    try {
	       url = new URL(urlToRead);
	       conn = (HttpURLConnection) url.openConnection();
	       conn.setRequestMethod("GET");
	       rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	       while ((line = rd.readLine()) != null) {
	          result += line;
	       }
	       rd.close();
	    } catch (Exception e) {
	    }
	    
	    return result;
	}
	
	/**
	 * It returns the value in the form of object.
	 * @param coloumnValue - Column Value.
	 * @param dataType - Data type.
	 * @return Object - return Object.	
	 */
	
	public static Object getValueInObject(String coloumnValue,String dataType) throws ParseException{
		
		return getValueInObject(coloumnValue, dataType, "mm/dd/yyyy");
	}
	
	
	/**
	 * It returns the value in the form of object.
	 * @param coloumnValue - Column Value.
	 * @param dataType - Data type.
	 * @param format - would be useful in the form of Date.
	 * @return Object - return Object.	
	 */
	public static Object getValueInObject(String coloumnValue,String dataType, String format) throws ParseException{
	
		if(coloumnValue.length()==0){
			if(!( (dataType.equals("String")) || (dataType.equals("Date")) )){
				coloumnValue="0";
			}
		}
	    if(dataType.equals("String"))
	    {
	        return new String(coloumnValue);
	    }
	    else if(dataType.equals("Long"))
	    {
	        return new Long(Long.parseLong(coloumnValue));
	    }
	    else if(dataType.equals("Integer"))
	    {
	    	return new Integer(Integer.parseInt(coloumnValue));
	    }
	    else if(dataType.equals("Float"))
	    {
	    	return new Float(Float.parseFloat(coloumnValue));	
	    }
	    else if(dataType.equals("Double"))
	    {
	    	return new Double(Double.parseDouble(coloumnValue));
	    }
	    else if(dataType.equals("Date"))
	    {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    	Date objectDate =null;
	    	objectDate = dateFormat.parse(coloumnValue);
	    	return objectDate;
	    }
	    else{
	    	return new String(coloumnValue);
	    }
	}

	/**
	 * This method gives the file data from the given file path.
	 * @param filePath - The file path.
	 * @return returns the data in the array.	
	 */
	public static byte[] getFileData(String filePath) throws ApplicationException
	{
		byte[] bytes = null;
		InputStream is = null;
		Map argsMap = new HashMap();
		argsMap.put("filePath", filePath);
		try
		{
			File file = new File(filePath); 
			is = new FileInputStream(file);
		
			long length = file.length();
			
		
			if (length > Integer.MAX_VALUE) {
				throw new ApplicationException("ApplicationUtils.getFileData.FileTooLarge", argsMap);
			}
			
		
			bytes = new byte[(int)length];
			
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
			       && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
			    offset += numRead;
			}
			
			if (offset < bytes.length) {
				throw new ApplicationException("ApplicationUtils.getFileData.FileNotReadCompletely", argsMap);
			}
			
			
		}
		catch(FileNotFoundException e)
		{			
			throw new ApplicationException("ApplicationUtils.getFileData.FileNotFound", e, argsMap);
		}
		catch(Exception e)
		{					
			throw new ApplicationException("ApplicationUtils.getFileData", e, argsMap);
		}
		finally
		{
			try
			{
				if(is != null)
				{
					is.close();
					is = null;
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return bytes;
	}
	
	
	
	/**
	 * This method gives the title for the given Column Name. Basically, this method prepares title in the Camel Case Format for the given Column Name.
	 * @param ColumnName - The Column Name for which Title needs to be prepared.
	 * @return strToRemove - This is the initial default String that needs to be removed while making the title from the column name.	
	 */
	public static String getTitleFromColumnName(String columnName, String strToRemove)
	{
		String title = "";
		String[] partsWithoutPrefix = null;
		String[] parts = null;
		
		if(StringUtils.hasText(columnName))
		{
			parts = StringUtils.tokenizeToStringArray(columnName, "_");
			if( (parts != null ) && (parts.length > 0) )
			{
				if(parts[0].equalsIgnoreCase(strToRemove))
				{
					partsWithoutPrefix = new String[parts.length - 1];
					for(int i=1;i<parts.length;i++)
					{
						partsWithoutPrefix[i-1] = parts[i];
					}
				}
				else
				{
					partsWithoutPrefix = parts;					
				}	
			}
			
			if( (partsWithoutPrefix != null ) && (partsWithoutPrefix.length > 0) )
			{
				for(int i=0;i<partsWithoutPrefix.length;i++)
				{
					title += StringUtils.capitalize(partsWithoutPrefix[i].toLowerCase());
				}
			}
		}		
		return title;
	}
	
	
	
		
	/**
	 * This method is used to get Start of day. i.e. for the given Date, it appends, 00:00:00.0 as time and return it back
	 *    
	 * @param date -- This is the date for which start time needs to be appended.
	 * @return Date -- Date with 00:00:00:0 time.
	 */
	public static Date getStartOfDay(Date date) throws Exception {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	}
	
	/**
	 * This method is used to get End of day. i.e. for the given Date, it appends, 59:59:59.999 as time and return it back
	 *    
	 * @param date -- This is the date for which end time needs to be appended.
	 * @return Date -- Date with  23:59:59.999 time.
	 */
	public static Date getEndOfDay(Date date)  throws Exception {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	    return calendar.getTime();
	}
	
	
	
	/**
	 * This method is used to round Currency Value to the given number.  
	 *    
	 * @param value -- value to be rounded
	 * @param numberToBeRoundedTo -- Number to be rounded to
	 * @return --  this contains value after it is rounded.
	 */
	public static double roundCurrencyValue(double value, double numberToBeRoundedTo){
        double remainder = value % numberToBeRoundedTo;
        if (remainder > 0)
        {
        	value = ((value - remainder) + numberToBeRoundedTo);
        }                        
        return value;
	}
	
	/**
	 * This method gives the trimmed value of the input String. If the input value is null, then blank("") is returned.	
	 * @param strValue - This is the input Value that needs to be trimmed.
	 * @return String - This is the trimmed value of the input.
	 */
	public static String getTrimmedValue(String strValue)
	{
		String strReturnValue = "";
		if(strValue != null)
		{
			strReturnValue = strValue.trim();
		}		
		return strReturnValue;
	}
	
	
	/**
	 * This method gives wheter a string is in number formt or not
	 * @param str the valkue that has to be checked
	 * @return true IF STRING IS NUMBER
	 */
	public static boolean isStringNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	

	/**
	 * This method gives the userDetails from Session
	 * @param request
	 * @return userDetails
	 */
	public static UserDetails getLogedInUser(HttpServletRequest request) throws ApplicationException
	{
		System.out.println("Entered inside ApplicationUtils::getLogedInUser() method");
		long userId = 0;
		HttpSession session = request.getSession(false);
		System.out.println("Got session object");
		if( (session != null) && (session.getAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION) != null) ) {
			System.out.println("inside USER_ID_IN_SESSION is not null");
			userId = (Long) session
					.getAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION);
			System.out.println("userId is:"+userId+":");
		}
		else
		{
			System.out.println("inside USER_ID_IN_SESSION is null");
			setUserDetailsIntoSession(request);
			//if( (session == null) || (session.getAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION) == null) )
			if(session == null) 
			{
				session = request.getSession(true);
			}
			if (session.getAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION) != null) {
				System.out.println("inside else USER_ID_IN_SESSION is not null");
				userId = (Long) session
						.getAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION);
				System.out.println("inside else userId is:"+userId+":");
			}
		}
		UserDetails userDetails = new UserDetails();
		userDetails.setUsrId(userId);
		return userDetails;
	}
	/**
	 * This method sets userDetails into Session by taking details from spring authentication
	 * @param request
	 * @return void
	 */
	public static void setUserDetailsIntoSession(HttpServletRequest request) throws ApplicationException
	{
		System.out.println("Entered inside ApplicationUtils::setUserDetailsInSession() method");
		UserDetails userDetails = null;
		Map userDetailsMap = null;	
		if(SecurityContextHolder.getContext() != null)
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
			if(auth != null)
			{					
				userDetailsMap = (Map) auth.getPrincipal();				
				userDetails = (UserDetails) userDetailsMap.get("UserDetails");
				String userCode = userDetails.getUsrCode();
				HttpSession session = request.getSession(true);
				session.setAttribute(SyntBotsITOpsConstants.USER_ID_IN_SESSION, userDetails.getUsrId());
				session.setAttribute(SyntBotsITOpsConstants.USER_CODE_IN_SESSION,userDetails.getUsrCode());
				session.setAttribute(SyntBotsITOpsConstants.USER_NAME_IN_SESSION, userDetails.getUsrShortName());
				System.out.println(userDetails.getUsrId()+" is added into session with attribute name as "+ SyntBotsITOpsConstants.USER_ID_IN_SESSION);					
			}
			else
			{
				System.out.println("ApplicationUtils::setUserDetailsInSession auth Authentication is null");
				throw new ApplicationException("SecurityContextHolder.Context.Authentication is null");
			}
		}
		
		System.out.println("Just before leaving ApplicationUtils::setUserDetailsInSession() method");
	}

}
