package com.creditcard.validate.service;

import org.springframework.stereotype.Service;

import com.creditcard.validate.api.CreditCardValidatorService;

@Service
public class CreditCardValidatorServiceImpl implements CreditCardValidatorService{
	
	
	public boolean validateCreditCardNumber(String creditCardNumber)
	{
		boolean isValid=true;
		if(creditCardNumber!=null)
		{
			int creditCardNumberLength=creditCardNumber.length();
			if(creditCardNumberLength>16)
			{
				isValid=false;
			}
		}
		
		return isValid;
		
	}
	

}
