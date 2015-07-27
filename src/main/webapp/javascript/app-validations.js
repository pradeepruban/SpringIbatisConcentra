	/**
	*This function is called before saving validation details.This function does all the client side validations.
	*/
	function fnAppCommonValidations(validationDtlsArray){

		var errorMessage = '';
		var valCondition="";
		var valElementId="";
		var valElementDesc="";
		var mandatoryCondnAdded = false;
		
		for(var j=0;j<validationDtlsArray.length;j++)
		{
			valCondition = validationDtlsArray[j][0];
			valElementId = validationDtlsArray[j][1];
			valElementDesc = validationDtlsArray[j][2];
			
			if(valCondition == MANDATORY_VALIDATION)
			{
				if(getValuesFromInputField(valElementId).length == 0)
				{
					setInvalidInputFieldBorderRed(valElementId);
					if(!mandatoryCondnAdded)
					{
						mandatoryCondnAdded = true;
						errorMessage += "Please fill in the Mandatory fields.";
					}
				}
			}
			else if(valCondition == POSITIVE_INTEGER_VALIDATION)
			{
				if(!(isPositiveInteger(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" should be a Positive Integer.";
				}				
			}
			else if(valCondition == INTEGER_VALIDATION)
			{
				if(!(isInteger(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" should be an Integer.";
				}
			}
			else if(valCondition == POSITIVE_NUMERIC_VALIDATION)
			{
				if(!(isPositiveNumeric(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" should be a Positive Number.";
				}
			}			
			else if(valCondition == NUMERIC_VALIDATION)
			{
				if(!(isNumeric(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" should be a Number.";
				}
			}
			else if(valCondition == ALPHA_NUMERIC_VALIDATION)
			{
				if(!(isAlphaNumeric(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" can contain only Alpha Numeric characters.";
				}
			}
			else if(valCondition == ALPHA_NUMERIC_SPACE_VALIDATION)
			{
				if(!(isAlphaNumericWithSpace(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" can contain only Alpha Numeric characters and Space.";
				}
			}
			else if(valCondition == ALPHA_NUMERIC_UNDSC_VALIDATION)
			{
				if(!(isAlphaNumericWithUnderscore(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" can contain only Alpha Numeric characters and Underscore.";
				}
			}
			else if(valCondition == ALPHA_NUMERIC_UNDSC_SPACE_VALIDATION)
			{
				if(!(isAlphaNumericWithUnderScoreSpace(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" can contain only Alpha Numeric characters, Underscore and Space.";
				}
			}
			else if(valCondition == ALPHA_NUMERIC_UNDSC_SPACE_HIPHEN_VALIDATION)
			{
				if(!(isAlphaNumericWithUnderScoreSpaceHiphen(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" can contain only Alpha Numeric characters, Underscore, Hiphen and Space.";
				}
			}
			else if(valCondition == ALPHA_NUMERIC_UNDSC_HIPHEN_VALIDATION)
			{
				if(!(isAlphaNumericWithUnderscoreHiphen(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" can contain only Alpha Numeric characters, Underscore and Hiphen.";
				}
			}
			else if(valCondition == PHONE_VALIDATION)
			{
				if(!(isValidPhone(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" is not Valid Phone Number.";
				}
			}
			else if(valCondition == EMAIL_VALIDATION)
			{
				if(!(isValidEmailId(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" is not Valid Email Id.";
				}
			}
			else if(valCondition == PERCENTAGE_VALIDATION)
			{
				if(!(isValidPercentageValue(getValuesFromInputField(valElementId))))
				{
					setInvalidInputFieldBorderRed(valElementId);		
					errorMessage += valElementDesc +" should be a Positive Number between 0 and 100.";
				}
			}			
		}
		
		return errorMessage;
	}