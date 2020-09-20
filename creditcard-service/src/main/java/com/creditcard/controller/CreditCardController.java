package com.creditcard.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.api.CreditCardService;
import com.creditcard.bean.CreditCardNumber;
import com.creditcard.bean.CreditCardNumberException;

@RestController
@RequestMapping("/credit")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@PostMapping(path= "/validate")
	public ResponseEntity<Boolean> checkCreditCard(@Valid @RequestBody CreditCardNumber creditCardNumber, Errors error)
			throws CreditCardNumberException {
		if (error != null && error.hasErrors())
			throw new CreditCardNumberException("CRE-101", "INVALID CREDITCARD");

		return new ResponseEntity<Boolean>(creditCardService.checkCreditCard(creditCardNumber), HttpStatus.OK);
	}

}
