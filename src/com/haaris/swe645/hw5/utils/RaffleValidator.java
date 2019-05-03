package com.haaris.swe645.hw5.utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("raffleValidator")
public class RaffleValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		String raffleNumbersInput = (String)arg2;
		String[] raffleNumbers = raffleNumbersInput.split(",");
		if (raffleNumbers.length < 10)
		{
			FacesMessage errorMessage = new FacesMessage("Please enter at least ten numbers");
			throw new ValidatorException(errorMessage);
		}
		else 
		{
			for (int i = 0; i < raffleNumbers.length; i++)
			{
				double number = Double.parseDouble(raffleNumbers[i].trim());
				if (number < 1.00 || number > 100.00)
				{
					FacesMessage errorMessage = new FacesMessage("Your raffle numbers must be between 1 and 100");
					throw new ValidatorException(errorMessage);
				}
			}
		}
		
	}

}
