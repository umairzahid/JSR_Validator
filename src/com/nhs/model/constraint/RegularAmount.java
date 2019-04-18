package com.nhs.model.constraint;

import javax.validation.constraints.NotNull;

@Amount
public class RegularAmount 
{


	private String amount = null;
	@NotNull
	private Frequency frequency = null;
	
	
	
	public RegularAmount(String amount, Frequency frequency) {
		super();
		this.amount = amount;
		this.frequency = frequency;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Frequency getFrequency() {
		return frequency;
	}
	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

}

