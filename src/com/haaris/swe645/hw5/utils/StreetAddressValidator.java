package com.haaris.swe645.hw5.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="streetAddressValidator")
public class StreetAddressValidator implements Validator {

	/**
	 * Validate the street address provided by the user,
	 * and throw an exception if the input is bad (i.e. has non-alphanumeric chars
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		
		String streetAddress = (String)arg2;
		boolean isAlphaNumeric = true;
		char[] addressArray = streetAddress.toCharArray();
		for (int i = 0; i < streetAddress.length(); i++)
		{
			if (!Character.isLetterOrDigit(addressArray[i])) 
			{
				//whitespace is not a special char 
				if (addressArray[i] == ' ')
					continue;
				else {
					//the moment a special char is found, the input is invalid
					isAlphaNumeric = false;
					break;
				}
			}
		}
		
		if (isAlphaNumeric == false)
		{
			FacesMessage errorMessage = new FacesMessage("Please enter a valid street address.");
			throw new ValidatorException(errorMessage);
		}

	}

}
