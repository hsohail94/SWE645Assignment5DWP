package com.haaris.swe645.hw5.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneNumberValidator")
public class PhoneNumberValidator implements Validator {

	/**
	 * Validate the phone nmumber provided by the user, and throw an exception
	 * if the input is bad
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		String phoneNumber = (String)value;
		String validPhoneNumberPattern = "\\(\\d{3}\\)-\\d{3}-\\d{4}";
		if (!phoneNumber.matches(validPhoneNumberPattern))
		{
			FacesMessage errorMessage = new FacesMessage("Please enter a valid phone number in the format (XXX)-XXX-XXXX.");
			throw new ValidatorException(errorMessage);
		}

	}

}
