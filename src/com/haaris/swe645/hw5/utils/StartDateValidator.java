package com.haaris.swe645.hw5.utils;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Validator for survey and start date field, to make sure that start date is not earlier than given survey date
 * @author haaris
 *
 */
@FacesValidator(value="startDateValidator")
public class StartDateValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		Date surveyDate = (Date)arg2;
		//UIInput startDateComponent = (UIInput) 
		UIInput startDateObj = (UIInput)arg1.getAttributes().get("startDate");
				
		if (startDateObj == null || surveyDate == null)
			return;
		
		Date startDate = (Date)startDateObj.getValue();
		
		if (startDate.before(surveyDate))
		{
			FacesMessage errorMessage = new FacesMessage("ERROR: semester start date is earlier than survey date.");
			throw new ValidatorException(errorMessage);
		}
	}

}
