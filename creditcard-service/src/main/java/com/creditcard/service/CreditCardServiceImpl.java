package com.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.creditcard.api.CreditCardService;
import com.creditcard.bean.CreditCardNumber;
import com.creditcard.bean.CreditCardResponse;

@Service
public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	RestTemplate restTemplate;
	 
	@Override
	public boolean checkCreditCard(CreditCardNumber creditCardNumber) {
        //Logic to Credit card validation service to validate the passed credit card number 
		String creditCardNumberStr =creditCardNumber.getCreditCardNumber();
	  	String url= "http://localhost:8090/credit/validate/"+creditCardNumberStr;
		CreditCardResponse  response= restTemplate.getForObject(url, CreditCardResponse.class);
		return response.isValid();
	}

}
