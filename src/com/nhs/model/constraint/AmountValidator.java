package com.nhs.model.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AmountValidator implements ConstraintValidator<Amount, RegularAmount> 
{
	
	@Override
	public boolean isValid(RegularAmount regAmount, ConstraintValidatorContext arg1) {
		
		if ( regAmount == null ) {
            return false;
        }

		if(!regAmount.getAmount().contains("."))
		{
			return true;
		}
		String[] tempArr= regAmount.getAmount().split("\\.");
		String pencePart = tempArr[1]==null?null:tempArr[1];
		
		if(pencePart == null ||
				pencePart.length()>2)
		{
			return false;
		}
		
		
		/**
		 *   Assuming that amount is in format 100.25  i.e. pound.pence; any number of digits for pounds but only two digits or less for pence
		 *   
		 *   We need to check if the pence part of amount.
		 *   If pence/7 is a whole number, then amount is valid weekly amount
		 */
		
		Float amount = Float.valueOf(pencePart);
        if ( regAmount.getFrequency().equals(Frequency.WEEK) ) 
        {
        	//•	If frequency is a multiple of a week, monetary amount must be divisible to a weekly value that is a whole number of pence.
        	Float weeklyAmount = amount/7;
        	
        	if(weeklyAmount % 1f ==0)
        		return true;
        	else
        		return false;
        }
        else {
            return true;
        }
	}

	

}
