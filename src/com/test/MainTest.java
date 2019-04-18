package com.test;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.nhs.model.constraint.Frequency;
import com.nhs.model.constraint.RegularAmount;

public class MainTest {

	/**
	 * Testing validator
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
		
		for(float i=10;i<11;i+=0.01)
		{
			RegularAmount amount = new RegularAmount(new DecimalFormat("##.##").format(i), Frequency.WEEK);
			Set<ConstraintViolation<RegularAmount>> amountViolations = validator.validate( amount );
			if(amountViolations.size()>0)
			{
				System.out.println( "Error Message : " +amountViolations.iterator().next().getMessage());
				System.out.println("Invalid Amount : "+amount.getAmount());
			}
			else
			{
				System.out.println( "\n****  Amount is valid:");
				System.out.println("****  Valid Amount : "+amount.getAmount()+"\n");
			}
		}

	}

}
