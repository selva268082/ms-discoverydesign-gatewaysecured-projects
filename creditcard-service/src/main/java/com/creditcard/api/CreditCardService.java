package com.creditcard.api;

import com.creditcard.bean.CreditCardNumber;

public interface CreditCardService {
	
	boolean checkCreditCard(CreditCardNumber creditCardNumber);

}
