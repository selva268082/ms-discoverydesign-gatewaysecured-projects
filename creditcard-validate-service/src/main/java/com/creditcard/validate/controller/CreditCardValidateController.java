package com.creditcard.validate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.creditcard.validate.api.CreditCardValidatorService;
import com.creditcard.validate.bean.CreditCardResponse;

@RestController
@RequestMapping("/credit")
public class CreditCardValidateController {

	@Autowired
	CreditCardValidatorService creditCardValidatorService;
	
	
	@GetMapping(path = "/validate/{creditCardNumber}")
	public ResponseEntity<CreditCardResponse> validateCreditCard(@PathVariable String creditCardNumber)
	{
				
		boolean isValid=creditCardValidatorService.validateCreditCardNumber(creditCardNumber);
		CreditCardResponse creditCardResponse = new CreditCardResponse();
		creditCardResponse.setValid(isValid);
		
		return new ResponseEntity<CreditCardResponse>(creditCardResponse,HttpStatus.OK);
		
	}
	
	
	
	
}
