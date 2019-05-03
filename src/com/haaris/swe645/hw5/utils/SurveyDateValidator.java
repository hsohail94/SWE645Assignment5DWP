package com.haaris.swe645.hw5.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("surveyDateValidator")
public class SurveyDateValidator implements Validator {

	/**
	 * Validate the survey date provided by the user
	 * Throw an exception if it is not in the format mm/dd/yyyy
	 * @param context
	 * @param component
	 * @param value
	 */
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		String datePattern = "\\d{2}/\\d{2}/\\d{4}";
		String surveyDate = (String)value;
		
		if (!surveyDate.matches(datePattern))
		{
			FacesMessage errorMessage = new FacesMessage("Please enter a valid date in the format mm/dd/yyyy");
			throw new ValidatorException(errorMessage);
		}
	}

}
