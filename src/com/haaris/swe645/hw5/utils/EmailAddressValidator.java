package com.haaris.swe645.hw5.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailAddressValidator")
public class EmailAddressValidator implements Validator {

	/**
	 * Validate the email address provided by the user
	 * 
	 * @param context
	 * @param component
	 * @param value
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		String emailAddressPattern = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		String emailAddress = (String)value;
		
		if (!emailAddress.matches(emailAddressPattern))
		{
			FacesMessage errorMessage = new FacesMessage("Please enter a valid email address in the format somethingsomething@email.com");
			throw new ValidatorException(errorMessage);
		}

	}

}
