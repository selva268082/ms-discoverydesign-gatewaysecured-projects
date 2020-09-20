package com.creditcard.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.springframework.stereotype.Component;

@Component
public class CreditCardNumber {
	
	private String creditCardNumber;

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
	}
	
	
	

}
