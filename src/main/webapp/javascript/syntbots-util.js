	 /**
	 * This function is used to get the JSON value from the jsonObject. It gives '' if the key is not found in the given jsonObject.
	 * @param jsonObject - The JSON Object from which the value needs to be found 
	 * @param key - It is the key(name of the JSON pair) for which the value needs to be found.
	 */
	 function getJSONValue(jsonObject, key)
	 {
		 var elementValue=jsonObject[key];        	
     	
     	if(typeof elementValue != 'undefined')
     	{  
     		return elementValue;
     	}
     	
     	return '';
	 }
	 
	 /**
	 * This function is basically used to show red mark around the input field in which the invalid value is entered.
	 * This function sets the border color and width.
	 * @param fieldObj - The input field for which the red mark should be shown. 
	 */
	 function setInvalidInputFieldBorderRed(fieldObj){
		document.getElementById(fieldObj).style.borderColor = "#FF3300";
		document.getElementById(fieldObj).style.borderWidth="1px";
	}
	 
	 
	 /**
	 * This function is basically used to clear red mark around the input field in which the invalid value is entered.
	 * This function clears the border color and width.
	 * @param fieldObj - The input field for which the border color and width should be cleared
	 */
	 function clearInvalidInputFieldBorderRed(fieldObj){
		 
		document.getElementById(fieldObj).style.borderColor = "";
		document.getElementById(fieldObj).style.borderWidth="";
	}
	 
	 
	 /**
	 * This function is basically used to show red mark around the object in which the invalid value is entered.
	 * This function sets the border color and width.
	 * @param field - The field for which the red mark should be shown. 
	 */
	 function setInvalidFieldBorderRed(field){
		 field.style.borderColor = "#FF3300";
		 field.style.borderWidth="1px";
	}
	 
	 /**
	 * This function basically clears red mark around the object in which the invalid value is entered.
	 * This function clears the border color and width.
	 * @param field - The field for which the border color and width should be cleared. 
	 */
	 function clearFieldBorderRed(field){
		 field.style.borderColor = "";
		 field.style.borderWidth="";
	}
	 
	 /**
	 * This function is basically used to show tool tip.
	 * @param field - The field for which tool tip should be shown.
	 * @param errorToolTip - The tool tip that needs to be shown.  
	 */
	 function setInvalidFieldToolTip(field, errorToolTip){
		 document.getElementById(field).title = errorToolTip;
	}
	 
	 /**
	 * This function basically clears tool tip.
	 * @param field - The field for which tool tip should be cleared. 
	 */
	 function clearFieldToolTip(field){		 
		 document.getElementById(field).title = "";
	}
	
	 /**
	 * This function sets / clears border color and width for 'field' basing on isValid parameter.
	 * If isValid is false, then it sets focus on 'field'
	 * @param field - The field for which the border color and width should be shown / cleared. 
	 * @param isValid - The parameter on which the border color and width should be shown / cleared.
	 * @param errorToolTip - tool tip that needs to be set. 
	 */
	 function fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip){
		 
		 if(!isValid)
		{			
			 setInvalidInputFieldBorderRed(field);
			 setInvalidFieldToolTip(field, errorToolTip);
			//field.focus();
			setTimeout("document.getElementById('"+field+"').focus();",1);
			//setTimeout("document.getElementById('"+field+"').select();",100);
			return false;
		}
		else
		{
			clearInvalidInputFieldBorderRed(field);
			clearFieldToolTip(field);
		}
		 
	 }
	 
	 /**
	 * This function is used to set the Error message in the given elementName and makes it visible.
	 * @param errorMessage - The errorMessage that needs to be set
	 * @param elementName - The elementName to which the value needs to be set 
	 */
	 
	 function setErrorMessage(errorMessage, elementName){
		if(document.getElementById(elementName).style.display == "none"){
			document.getElementById(elementName).style.display="block";
		}
		document.getElementById(elementName).innerHTML = errorMessage;
	}
	 
	 /**
	 * This function gives the value of the Element 'obj'
	 * @param obj - The Element name for which the value needs to be found
	 *  
	 */
	function getValuesFromInputField(obj){
		
		
		if(document.getElementById(obj))
		{
		
			return document.getElementById(obj).value.replace(/^\s+|\s+$/g, '');
		}
		else
		{
		
			return ''; 
		}
		
	}
	
	
	 /**
	 * This function is basically sets CSS on focus of the given checkbox	 
	 * @param chkBoxObj - The checkbox which should be focussed. 
	 */
	 function setChkBoxFocus(chkBoxObj){		
		document.getElementById(chkBoxObj).style.borderWidth="2px";
		document.getElementById(chkBoxObj).style.border="1";
		document.getElementById(chkBoxObj).style.background="#BDBDBD";
		//document.getElementById(chkBoxObj).style.borderColor = "#000000";
	}
	 
	 /**
	 * This function is basically sets different CSS on blur of the given checkbox	 
	 * @param chkBoxObj - The checkbox which should be blurred. 
	 */
	 function removeChkBoxFocus(chkBoxObj){		 
		document.getElementById(chkBoxObj).style.borderWidth="0px";
		document.getElementById(chkBoxObj).style.border="0";
		document.getElementById(chkBoxObj).style.background="#FFFFFF";
		//document.getElementById(chkBoxObj).style.borderColor = "#000000";#FFFFFF
	}
	
	 /**
	 * This function validates the given input is valid phone number or not	 
	 * @param phone - input that needs to be validated for whether it is valid phone no. or not  
	 */	
	function isValidPhone(phone) {
		var isValid=true;
		if(phone.length > 0)
		{
			var ph = phone.toString().replace(/\+/g, '').replace(/-/g, '');
			isValid = !isNaN(ph);
		}
        
        return isValid;
    }
	
	 /**
	 * This function validates the given input is valid phone number or not	and basing on the result, it sets focus, border color and tool tip.
	 * @param field - input field that needs to be validated for whether it is valid phone no. or not  
	 * @param fieldDesc - field description of the input field that needs to be validated  
	 */	
	function fnValidatePhone(field, fieldDesc){		
		
		var isValid= isValidPhone(getValuesFromInputField(field));		
		var errorToolTip = fieldDesc + " is not a Valid Phone Number. Example for phone: +971-xxxx-xxxxx";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
	}
	
	
	 /**
	 * This function validates the given input is valid E-mail or not	 
	 * @param email - input that needs to be validated for whether it is valid e-mail or not  
	 */	
	function isValidEmailId(email) {
		var isValid=true;
		if(email.length > 0)
		{
			 var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			 isValid = re.test(email);
		}
		if(isValid)
		{
			var emailDomainStartsAt = email.indexOf("@");
			var domainName = email.substring(emailDomainStartsAt+1);			
			var dotCountInDomain = 0;
			for(var j=0; j<domainName.length; j++)
			{		  			  
				  if((domainName.charAt(j)) == '.')
				  {
					dotCountInDomain++;
				  }
			}			
			if(dotCountInDomain > 2)
			{
				isValid = false;
			}
		}
        
        return isValid;	    
    }
	
	/**
	 * This function validates the given input is valid E-mail or not and basing on the result, it sets focus, border color and tool tip.	 
	 * @param field - input field that needs to be validated for whether it is valid e-mail or not
	 * @param fieldDesc - field description of the input field that needs to be validated    
	 */	
	function fnValidateEmailId(field, fieldDesc){
		var isValid = isValidEmailId(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " is not Valid Email Id. Example for email: Noname@email.com";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
	}
	
	 
	 /**
	 * This function checks for special characters in given string.
	 * @param alphanum - The string for check. 
	 */
	 function isAlphaNumeric(alphanum)
	 {
	 	var numeric = alphanum;
	 	var validString = true;
	 	for(var j=0; j<numeric.length; j++)
 		{
 			  var alphaa = numeric.charAt(j);
 			  var hh = alphaa.charCodeAt(0);
 			  if((hh > 47 && hh<58) || (hh > 64 && hh<91) || (hh > 96 && hh<123))
 			  {
 			  }else	{              
 				  validString = false;
 			  }
  		}
	 	return validString;
	 }
	 
	 
	 /**
	 * This function checks for special characters in given field.
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function fnAlphaNumeric(field, fieldDesc){
		 
		var isValid= isAlphaNumeric(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " can contain only Alpha Numeric characters.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	 
	 
	 /**
	 * This function checks whether the given field value is a valid number or not.
	 * @param numericValue - field value that needs to be validated .
	 */
	 function isNumeric(numericValue){
		
		var isValid=true;		
		if(numericValue.length > 0)
		{
			isValid= !isNaN(numericValue);
		}
		return isValid;
	}
	 
	 /**
	 * This function checks whether the given field value is a valid number or not.
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated .
	 * @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function fnNumeric(field, fieldDesc){
	
		var isValid =  isNumeric(getValuesFromInputField(field));		
		var errorToolTip = fieldDesc + " should be a Number.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	 
	 
	 /**
	 * This function checks whether the given field value is a valid positive number or not.
	 * @param fieldValue - field value that needs to be validated.
	 */
	 function isPositiveNumeric(fieldValue){
		
		var isValid=true;		
		if(fieldValue.length > 0)
		{
			isValid= !isNaN(fieldValue);
		}
		if(isValid)
		{
			if(fieldValue < 0)
			{
				isValid = false;
			}
		}
		
		return isValid;
	}
		 
	 
	 /**
	 * This function checks whether the given field value is a valid positive number or not.
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated  
	 */
	 function fnPositiveNumeric(field, fieldDesc){		
		
		var isValid =  isPositiveNumeric(getValuesFromInputField(field));	
		var errorToolTip = fieldDesc + " should be a Positive Number.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);		
	}
	 
	 
	 /**
	 * This function checks whether the given field value is a valid Integer or not.
	 * @param fieldValue - field value that needs to be validated.
	 */
	 function isInteger(fieldValue){
		
		var isValid = true;		
		if(fieldValue.length > 0)
		{
			isValid= !isNaN(fieldValue);
			if(isValid)
			{
				var dotIndex = fieldValue.indexOf(".");
				if(dotIndex >= 0 )
				{
					isValid= false;
				}				
			}
		}
		
		return isValid;
	}
		 
	
	 /**
	 * This function checks whether the given field value is a valid Integer or not.
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function fnInteger(field, fieldDesc){
		
		var isValid =  isInteger(getValuesFromInputField(field));		
		var errorToolTip = fieldDesc + " should be an Integer";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	 
	 
	 /**
	 * This function checks whether the given field value is a valid Positive Integer or not.
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function isPositiveInteger(fieldValue){

		//var numericExpression = /^[0-9]+$/;	
		var isValid = true;
		if(fieldValue.length > 0)
		{
			isValid= !isNaN(fieldValue);
			if(isValid)
			{
				var dotIndex = fieldValue.indexOf(".");
				if(dotIndex >= 0 )
				{
					isValid= false;
				}
				if(isValid)
				{
					if(fieldValue < 0)
					{
						isValid = false;
					}
				}
			}
		}
		
		return isValid;
	}
	 
	 /**
	 * This function checks whether the given field value is a valid Positive Integer or not.
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function fnPositiveInteger(field, fieldDesc){
		
		var isValid =  isPositiveInteger(getValuesFromInputField(field));		
		var errorToolTip = fieldDesc + " should be a Positive Integer";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);		
	}
	 
	 /**
	 * This function checks whether the given field value is a valid number or not.
	 * And it also checks whether the field contains more decimals than the one given in 'noOfDecimals'. 
	 * @param fieldValue - the value that needs to be validated.
	 * @param noOfDecimals - no. of decimals allowed in the input field.  
	 */
	 function isNumericWithLimittedDecimals(fieldValue, noOfDecimals){
		
		var isValid = true;
		if(fieldValue.length > 0)
		{
			isValid= !isNaN(fieldValue);
			if(isValid)
			{
				var decimalStartsAt = fieldValue.indexOf(".");
				if(decimalStartsAt >= 0)
				{
					var fieldValueLength = fieldValue.length;
					//alert("decimalStartsAt:"+decimalStartsAt+":fieldValueLength:"+fieldValueLength+":noOfDecimals:"+noOfDecimals+":")
					if(fieldValueLength > (decimalStartsAt + noOfDecimals + 1))
					{
						isValid= false;
					}
				}

			}
		}
		
		return isValid;
	}
	 
	 /**
	 * This function checks whether the given field value is a valid number or not.
	 * And it also checks whether the field contains more decimals than the one given in 'noOfDecimals'. 
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated .
	 * @param noOfDecimals - no. of decimals allowed in the input field.
	 * @param fieldDesc - field description of the input field that needs to be validated    
	 */
	 function fnNumericWithLimittedDecimals(field, noOfDecimals, fieldDesc){
		 
		var isValid= isNumericWithLimittedDecimals(getValuesFromInputField(field), noOfDecimals);
		var errorToolTip = fieldDesc + " should be a number with maximum "+noOfDecimals+" decimals.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);

	}
	
	 
	 /**
	 * This function validates the given input for special charecters. This function allows alpha numeric characters, space, hiphen and '_'.
	 * @param alphanum - input that needs to be validated 
	 */
	 function isAlphaNumericWithUnderScoreSpaceHiphen(alphanum){
		 var validString = true;
		 //var specialchars=alphanum.match (/^[a-zA-Z0-9+(), -]+$/);
		 if(alphanum.length > 0)
		 {
			 var specialchars = alphanum.match (/[^a-zA-Z 0-9 \_ \-]+/g);   
			 if(specialchars!=null)
			 {		
				 validString = false;
			 }
		 }
		
		 return  validString;
	 }
	 
	 /**
	 *  This function validates the given input for special charecters. This function allows alpha numeric characters, space, hiphen and '_'.
	 *  Basing on the result, it also sets focus, border color and tool tip
	 *  @param field - input field that needs to be validated.
	 *  @param fieldDesc - field description of the input field that needs to be validated  
	 */
	 function fnAlphaNumericWithUnderScoreSpaceHiphen(field, fieldDesc){
		 
		var isValid= isAlphaNumericWithUnderScoreSpaceHiphen(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " can contain only Alpha Numeric characters, Underscore, Hiphen and Space.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	 
	 /**
	 * This function validates the given input for special charecters. This function allows alpha numeric characters, space and '_'.
	 * @param alphanum - input that needs to be validated 
	 */
	 function isAlphaNumericWithUnderScoreSpace(alphanum){
		 var validString = true;
		 //var specialchars=alphanum.match (/^[a-zA-Z0-9+(), -]+$/);
		 if(alphanum.length > 0)
		 {
			 var specialchars = alphanum.match (/[^a-zA-Z 0-9 \_]+/g);   
			 if(specialchars!=null)
			 {		
				 validString = false;
			 }
		 }
		
		 return  validString;
	 }
	 
	 
	 /**
	 *  This function validates the given input for special charecters. This function allows alpha numeric characters, space and '_'.
	 *  Basing on the result, it also sets focus, border color and tool tip
	 *  @param field - input field that needs to be validated.
	 *  @param fieldDesc - field description of the input field that needs to be validated  
	 */
	 function fnAlphaNumericWithUnderScoreSpace(field, fieldDesc){
		 
		var isValid= isAlphaNumericWithUnderScoreSpace(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " can contain only Alpha Numeric characters, Underscore and Space.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	 
	 
	 /**
	 * This function validates the given input for special characters. This function allows alpha numeric characters, '_' and '-'.
	 *  @param alphanum - input that needs to be validated 
	 */
	 function isAlphaNumericWithUnderscoreHiphen(alphanum){

		 var validString = true;
		 if(alphanum.length > 0)
		 {
			 var specialchars = alphanum.match (/[^a-zA-Z 0-9 \_ \-]+/g);   
		 
			 if(specialchars==null)
			 {			 
				 if (alphanum.indexOf(" ") > -1) // remove spaces
				 {
					 validString = false;
				 }		
			 } else	 {
				 validString = false;
			 }
		 }
		 
		 return  validString;
	 }
	 
	 
	 /**
	 * This function validates the given input for special characters. This function allows alpha numeric characters, '_' and '-'.
	 *  Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated  
	 */
	 function fnAlphaNumericWithUnderscoreHiphen(field, fieldDesc){
		 
		var isValid= isAlphaNumericWithUnderscoreHiphen(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " can contain only Alpha Numeric characters Underscore and Hiphen.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
		 
		 
	 /**
	 * This function validates the given input for special characters. This function allows alpha numeric characters and '_'.
	 *  @param alphanum - input that needs to be validated 
	 */
	 function isAlphaNumericWithUnderscore(alphanum){

		 var validString = true;
		 if(alphanum.length > 0)
		 {
			 var specialchars = alphanum.match (/[^a-zA-Z 0-9 \_]+/g);   
		 
			 if(specialchars==null)
			 {			 
				 if (alphanum.indexOf(" ") > -1) // remove spaces
				 {
					 validString = false;
				 }		
			 } else	 {
				 validString = false;
			 }
		 }
		 
		 return  validString;
	 }
	 
	 
	 /**
	 * This function validates the given input for special characters. This function allows alpha numeric characters and '_'.
	 *  Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated  
	 */
	 function fnAlphaNumericWithUnderscore(field, fieldDesc){
		 
		var isValid= isAlphaNumericWithUnderscore(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " can contain only Alpha Numeric characters and Underscore.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	 
	 /**
	 * This function validates the given input for special characters. This function allows alpha numeric characters and space.
	 *  @param alphanum - input that needs to be validated 
	 */
	 function isAlphaNumericWithSpace(alphanum){
		 		
	 	var numeric = alphanum;
	 	var validString = true;
	 	for(var j=0; j<numeric.length; j++)
 		{
 			  var alphaa = numeric.charAt(j);
 			  var hh = alphaa.charCodeAt(0);
 			  if((hh > 47 && hh<58) || (hh > 64 && hh<91) || (hh > 96 && hh<123) || (hh == 32))
 			  {
 			  }else	{              
 				  validString = false;
 			  }
  		}
	 	return validString;
	 }
	 
	 
	 /**
	 * This function validates the given input for special characters. This function allows alpha numeric characters and space.
	 * Basing on the result, it also sets focus, border color and tool tip
	 *  @param field - input field that needs to be validated
	 *  @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function fnAlphaNumericWithSpace(field, fieldDesc){
		 
		var isValid= isAlphaNumericWithSpace(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " can contain only Alpha Numeric characters and Space.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);
		
	}
	
 	/**
	 * This function validates the given input is valid Percentage or not	 
	 * @param field - input that needs to be validated for whether it is valid percentage or not  
	 */	
 
 	function isValidPercentageValue(fieldValue){
 		
 		var isValid=true;		
		if(fieldValue.length > 0)
		{
			isValid = !isNaN(fieldValue);
			
			if(isValid)
			{
				if((fieldValue < 0) || (fieldValue > 100) )
				{
					isValid = false;
				}				
			}
		}
					
		return isValid;
	}
	 
 	/**
	 * This function checks whether the given field value is a valid percentage or not
	 * Basing on the result, it also sets focus, border color and tool tip
	 * @param field - input field that needs to be validated.
	 * @param fieldDesc - field description of the input field that needs to be validated   
	 */
	 function fnValidPercentageValue(field, fieldDesc){
		
		var isValid = isValidPercentageValue(getValuesFromInputField(field));
		var errorToolTip = fieldDesc + " should be a Positive Number between 0 and 100.";
		fnSetFieldBorderToolTipAndFocus(field, isValid, errorToolTip);			
		
	}
	 
	
	 /**
	 * This function is common function to make an Ajax call in the case of Save. Ideal to use for Save functionality
	 * @param actionURL - URL to which AJAX call should be made.
	 * @param strJSONData - the actual JSON Data
	 * @param scsFnToBeCalled - function to be called when ajax call is successful
	 * @param errFnToBeCalled - function to be called when ajax call is failed
	 * @param jsonDataParamName - Parameter Name on which JSON data is sent
	 * @param alertMsgToBeShown - Alert message to be shown or not
	 * @param strAlertMsg - Alert message that should be given. If it is not given, be default 'Data saved successfully.' message is shown.  
	 */
	function fnCommonDoAjaxForSave(actionURL, strJSONData,  scsFnToBeCalled, errFnToBeCalled, jsonDataParamName, alertMsgToBeShown, strAlertMsg){
		
		debugger;
		//alert('inside fnCommonDoAjaxForSave fn., where actionURL:'+actionURL+':, and strJSONData:'+strJSONData+':');
		var alertMsg = "Data saved successfully.";
		
		if( (typeof(strAlertMsg) !="undefined")  && (strAlertMsg != 'undefined') && (strAlertMsg != null) && (strAlertMsg.length > 0)  )
		{
			alertMsg = strAlertMsg;
		}
		if(!varITOpsAjaxSaveInProgress)
		{
			varITOpsAjaxSaveInProgress = true;
			fnShowLoader();
			$.ajax({     
				type:"POST",     
				data: fnGetAjaxDataToBeSent(jsonDataParamName, strJSONData),
				url: actionURL, 
				dataType: 'json',
				beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        },
				success:function(data, textStatus, XMLHttpRequest){
					
					//alert('inside fnCommonDoAjaxForSave success block');
					
					if((typeof(data)!="undefined") && (data!=null) && (typeof(data.displayMessage) !="undefined") && (data.displayMessage != null) ){
						alertMsg+=data.displayMessage;
					}
					
					if( (typeof(alertMsgToBeShown) !="undefined")  && (alertMsgToBeShown != 'undefined') && (alertMsgToBeShown != null) && (alertMsgToBeShown.length > 0) && (alertMsgToBeShown == 'true')  )
					{
						jAlert(alertMsg, 'Status');
					}
					
					if( (typeof(scsFnToBeCalled)!="undefined") && (scsFnToBeCalled != 'undefined') && (scsFnToBeCalled != null) && (scsFnToBeCalled.length > 0)  )
					{
						window[scsFnToBeCalled](data);	
					}
					varITOpsAjaxSaveInProgress = false;
					fnHideLoader();				
				},     
				error:function(XMLHttpRequest, textStatus, errorThrown){ 
					//alert('inside fnCommonDoAjaxForSave error block');
					fnAssignErrorDetailsForITOps(XMLHttpRequest.responseText);
					if( (typeof(errFnToBeCalled)!="undefined") && (errFnToBeCalled != 'undefined') && (errFnToBeCalled != null) && (errFnToBeCalled.length > 0)  )
					{
						window[errFnToBeCalled]();		
					}
					varITOpsAjaxSaveInProgress = false;
					fnHideLoader();						
				}
			});
		}
		else
		{
			jAlert("Save is already in progress.", "INFO");
		}
	}
	 
	
	/**
	 * This function is common function to make an Ajax call in the case of Get. Ideal to use for Get functionality
	 * @param actionURL - URL to which AJAX call should be made.
	 * @param strJSONData - the actual JSON Data	 
	 * @param scsFnToBeCalled - function to be called when ajax call is successful
	 * @param errFnToBeCalled - function to be called when ajax call is errored out
	 * @param jsonDataParamName - Parameter Name on which JSON data is sent
	 */
	function fnCommonDoAjaxForGet(actionURL, strJSONData, scsFnToBeCalled, errFnToBeCalled, jsonDataParamName){
		fnShowLoader()
		//startProgressBar();
		//alert('inside fnCommonDoAjaxForGet fn., where actionURL:'+actionURL+':, and strJSONData:'+strJSONData+':');
		jQuery.ajax({     
			type:"POST",     
			data: fnGetAjaxDataToBeSent(jsonDataParamName, strJSONData),			
			url: actionURL,
			dataType: 'json',
			beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },			
			success:function(data, textStatus, XMLHttpRequest){			
				if((typeof(scsFnToBeCalled)!="undefined") && (scsFnToBeCalled != 'undefined') &&   (scsFnToBeCalled != null) && (scsFnToBeCalled.length > 0)  )
				{
					window[scsFnToBeCalled](data);
					fnHideLoader();
					//endProgressBar();
					//setInterval(function(){document.getElementById("progressbar").style.display="none";},1000);
					
				}
			},     
			error:function(XMLHttpRequest, textStatus, errorThrown){ 
				fnAssignErrorDetailsForITOps(XMLHttpRequest.responseText);			
				if( (typeof(errFnToBeCalled)!="undefined") && (errFnToBeCalled != 'undefined') && (errFnToBeCalled != null) && (errFnToBeCalled.length > 0)   )
				{
					window[errFnToBeCalled]();
					fnHideLoader();
					//endProgressBar();
					//document.getElementById("progressbar").style.display="none";
				}
			}
		});
		
	}
	
	
	/**
	 * This function is common function to make an Ajax call in the case of Save. Ideal to use for Save functionality
	 * @param actionURL - URL to which AJAX call should be made.
	 * @param jsonDataParamName - Parameter Name on which JSON data is sent
	 * @param strJSONData - the actual JSON Data
	 * @param scsFnToBeCalled - function to be called when ajax call is successful
	 * @param strAlertMsg - Alert message that should be given. If it is not given, be default 'Data saved successfully.' message is shown.  
	 */
	function fnCommonDoAjaxForSaveForRequest(actionURL, jsonDataParamName, strJSONData,  scsFnToBeCalled, strAlertMsg, errFnToBeCalled){
		
		debugger;
		var alertMsg = "Data saved successfully.";
		if( (typeof(strAlertMsg) !="undefined")  && (strAlertMsg != 'undefined') && (strAlertMsg != null) && (strAlertMsg.length > 0)  )
		{
			alertMsg = strAlertMsg;
		}
		if(!varITOpsAjaxSaveInProgress)
		{		
			fnShowLoader();
			$.ajax({     
				type:"POST",     
				data: jsonDataParamName+"="+strJSONData,
				url: actionURL, 
				dataType: 'json',
				success:function(data, textStatus, XMLHttpRequest){						
					if((typeof(data)!="undefined") && (data!=null) && (typeof(data.displayMessage) !="undefined") && (data.displayMessage != null) ){
						alertMsg+=data.displayMessage;
					}
					
					//jAlert(alertMsg, 'Status');
					
					if( (typeof(scsFnToBeCalled)!="undefined") && (scsFnToBeCalled != 'undefined') && (scsFnToBeCalled != null) && (scsFnToBeCalled.length > 0)  )
					{
						//alert("Succes funtion in utils");
						window[scsFnToBeCalled](data);	
						
					}
					varITOpsAjaxSaveInProgress = false;
					fnHideLoader();
					//document.getElementById("progressbar").style.display="none";
				},     
				error:function(XMLHttpRequest, textStatus, errorThrown){ 
					fnAssignErrorDetailsForITOps(XMLHttpRequest.responseText);
					if( (typeof(errFnToBeCalled)!="undefined") && (errFnToBeCalled != 'undefined') && (errFnToBeCalled != null) && (errFnToBeCalled.length > 0)  )
					{
						window[errFnToBeCalled]();	
						
					}
					varITOpsAjaxSaveInProgress = false;
					fnHideLoader();
					//document.getElementById("progressbar").style.display="none";
				}
			});
		}
		else
		{
			jAlert("Save is already in progress.", "INFO");
		}
	}
	
	/**
	 * This function is used to load data into Data Table.
	 * @param varDataTableIdToBeLoaded - Id of dataTable to be loaded.
	 * @param varDataTableData - the actual JSON Data to be loaded into dataTable.
	 */
	function fnLoadDataTable(varDataTableIdToBeLoaded, varDataTableData)
	 {
		 //alert('inside fnLoadDataTable function, varDataTableData is:'+varDataTableData+':');
		 //table = $(tableId).dataTable();
	    oSettings = varDataTableIdToBeLoaded.fnSettings();
	    
	    varDataTableIdToBeLoaded.fnClearTable(this);

	    for (var i=0; i<varDataTableData.aaData.length; i++)
	    {
	    	varDataTableIdToBeLoaded.oApi._fnAddData(oSettings, varDataTableData.aaData[i]);
	    }

	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    varDataTableIdToBeLoaded.fnDraw();   
	 }
	
	/**
	 * This function is used to load list data into Data Table.This is similar to fnLoadDataTable.
	 * @param varDataTableIdToBeLoaded - Id of dataTable to be loaded.
	 * @param varDataList - the actual JSON Data list to be loaded into dataTable.
	 */
	function fnLoadDataTableFromList(varDataTableIdToBeLoaded, varDataList)
	 {
		 //alert('inside fnLoadDataTable function, varDataTableData is:'+varDataTableData+':');
		 //table = $(tableId).dataTable();
	    oSettings = varDataTableIdToBeLoaded.fnSettings();
	    
	    varDataTableIdToBeLoaded.fnClearTable(this);

	    for (var i=0; i<varDataList.length; i++)
	    {
	    	varDataTableIdToBeLoaded.oApi._fnAddData(oSettings, varDataList[i]);
	    }

	    oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
	    varDataTableIdToBeLoaded.fnDraw();   
	 }
	/**
	 * This function decides the data to be sent with the Ajax call.
	 * if jsonDataParamName is not null, then it just sends the data for the given param name, 
	 * otherwise it sends only the data.  
	 * @param jsonDataParamName - Parameter Name on which JSON data to be sent
	 * @param strJSONData - the actual JSON Data
	 *  
	 */
	function fnGetAjaxDataToBeSent(jsonDataParamName, strJSONData){
		
		//alert('inside fnGetAjaxDataToBeSent fn..');
		
		if( (typeof(jsonDataParamName) !="undefined")  && (jsonDataParamName != 'undefined') && (jsonDataParamName != null) && (jsonDataParamName.length > 0)  )
		{
			//alert('inside fnGetAjaxDataToBeSent fn., !=undefined,'+jsonDataParamName+"="+strJSONData+':');
			return jsonDataParamName+"="+strJSONData;
		}
		else
		{
			//alert('inside fnGetAjaxDataToBeSent fn., ===undefined,'+strJSONData+':');
			return strJSONData;
		}
		
	}
	 
	 /**
	 * This function gives the value of the Element 'obj'
	 * @param obj - The Element name for which the value needs to be found
	 *  
	 */
	function getValuesFromTextBox(obj){
		
		if(document.getElementById(obj))
		{
			return document.getElementById(obj).value.replace(/^\s+|\s+$/g, '');
		}
		else
		{
			return ''; 
		}
	}
	
	 /**
	 * This function gives current date in the format of 'DD/MMM/YYYY'
	 */
	function fnGetDateInDDMMMYYYY(){
		
		var currentDate = new Date(); 
		var monthValue = currentDate.getMonth(); 
		var dayValue = currentDate.getDate(); 
		var yearValue = currentDate.getFullYear();
		
		var dateInDDMMMYYYY = dayValue + "/" + MONTH_NAMES_CONSTANTS_IN_SHORT[monthValue] + "/" +  yearValue;
		
		return dateInDDMMMYYYY;
	}
	
	/**
	*This fn clears the border color and width
	*
	*/
	function clearBorderColorAndWidth(elementName){
		//debugger;
		
		var element=document.getElementById(elementName);
		element.style.borderColor = "";
		element.style.borderWidth = "";
		element.title = "";
	}
	
	 
	
	
	/**
	 * This function gives Browser Name. This function is used where browser specific JS is required.
	 * In main.jsp, this is accessed and in BROWSER_NAME global variable, the corresponding value is stored. 
	 * So, wherever Browser specific JS is required, there  BROWSER_NAME == BROWSER_IE etc.. can be used.
	 */
	function fnGetBrowserName()
	{
		var nAgt = navigator.userAgent;
		if((verOffset=nAgt.indexOf("MSIE"))!=-1) {
			//browserName = "Microsoft Internet Explorer";
			browserName = BROWSER_IE; 
		}
		else if((verOffset=nAgt.indexOf("Chrome"))!=-1) {
			//browserName = "Chrome";
			browserName = BROWSER_CHROME;
		}
		else if((verOffset=nAgt.indexOf("Firefox"))!=-1) {
			//browserName = "Firefox";
			browserName = BROWSER_FIREFOX;
		}
		else{
			//browserName = "Others";
			browserName = BROWSER_OTHERS;
		}
		return browserName;
	}
	
	/**
	 * This function gives the selected tab index in the given div id. 
	 */
	function fnGetSelectedTabIndex(varTabsId)
	{
		return $('#'+varTabsId).tabs('option', 'selected');
	}
	
	
	
	/**
	 * This function returns the Options String by taking them from input 'data'.
	 * Input 'data' contains options array, with each option object containing value and text.   
	 */
	 function fnGetEditOptionsValue(data){
		  		
		var strSelOptionsObj="";	
		strSelOptionsObj =  "" + ":"+ varBlankOptionText + ";";

		for(var i=0; i<data.options.length; i++){
			strSelOptionsObj = strSelOptionsObj + data.options[i].value + ":"+ data.options[i].text + ";";
		}		
		
		if(strSelOptionsObj.length > 2)
		{
			strSelOptionsObj = strSelOptionsObj.substr(0, strSelOptionsObj.length-1);						
		}
		return strSelOptionsObj;
	}
	 
	
	 /**
	 * This function returns the value after trimming the same
	 * @param elemValue - The Element value that needs to be trimmed
	 *  
	 */
	function getValueAfterTrim(elemValue){	
		return elemValue.replace(/^\s+|\s+$/g, '');		
	}
	
	
	/**
	 * This function removes all the options of given select box.
	 * @param elem - The Element id for which options need to be removed
	 *  
	 */
	function fnRemoveOptions(elem){
		var selDropDown = document.getElementById(elem);
		var i;
		for(i = selDropDown.length - 1; i>=0; i--) {
			selDropDown.remove(i);
		}
	}
	
	 /**
	 * 
	 * This function returns blank value if it is undefined. Otherwise it returns the value after trimming the same.
	 * @param elemValue - The Element value that is input for this function.
	 *  
	 */
	function getBlankValueIfUndefined(elemValue){
		var returnVal = '';
		if(typeof elemValue != 'undefined')
		{
			returnVal = elemValue.replace(/^\s+|\s+$/g, '');	
		}		
		return returnVal;
		
	}
	
	 /**
	 * This function round then number to specified
	 * @param obj - The Element name for which the value needs to be found
	 *  
	 */
	function trueRound(value, digits){
	    return parseFloat((Math.round((value*Math.pow(10,digits)).toFixed(digits-1))/Math.pow(10,digits)).toFixed(digits));
	}
	
	
	/**
	*This fn returns todays date 
	*/
	function fnGetsTodaysDate(){
		 var currentTime = new Date();
		 var month = currentTime.getMonth() + 1;
		 var day = currentTime.getDate();
		 var year = currentTime.getFullYear();
		 var todaysDate = month + "/"+day+"/"+year;
		 return todaysDate;
	}
	
	/**
	*This function is used to check whether mainStr String ends with suffixStr String.
	*/
	function fnEndsWith(mainStr, suffixStr) {
	    return mainStr.indexOf(suffixStr, mainStr.length - suffixStr.length) !== -1;
	}
	
	
	/**
	*This function is used to show Loading image for Ajax calls .
	*/
	function fnShowLoader() {
		//alert("inside:fnShowLoader()")
		$('#content').oLoader({
		      backgroundColor:'#fff',
		      image: varsyntbotsitopsContextPath+'/images/blue-load.gif',
		      fadeInTime: 500,
		      fadeOutTime: 1000,
		      fadeLevel: 0.8
		    });
	}
	
	/**
	*This function is used to Hide the  Loader.
	*/
	function fnHideLoader() {
		//alert("inside:fnHideLoader()")
		 $('#content').oLoader('hide');
	}
	
	
	/**
	*This function is used to Initialize Dialog box for Form Validations.
	*/	
	function fnInitializeItOpsValidationDialog(){
		//alert("inside fnInitializeValidationDialog()");
		$('#itopsValidationDialog').dialog({
			autoOpen : false,
			width : 400,
			resizable : false,
			modal : true,
			title: "Validation Message",
			buttons : [{
			html : "Ok",
			"class" : "btn btn-primary",
			click : function() {

			$(this).dialog("close");

			}
			}]
			});
	}
	/**
	*This function is used to Open Dialog box to show Required Fileds for Form Validation.
	*/
	function fnShowItOpsValidationDialog(varItOpsValidationDetailsErrMsg){
	//	alert("inside fnValidateDialog():"+varQueDetailsErrMsg+":");
		 document.getElementById("itopsValidationDialog").innerHTML = varItOpsValidationDetailsErrMsg;
		$('#itopsValidationDialog').dialog('open');
	   

		
	}
	
	
	
