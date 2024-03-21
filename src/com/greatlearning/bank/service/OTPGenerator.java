package com.greatlearning.bank.service;

import com.greatlearning.bank.model.Customer;

public class OTPGenerator {
	
	public void generateAndSetOtp(Customer customer) {
		int otp = (int)(Math.random() * 9000)+1000;
		customer.setOtp(otp);
		System.out.println("generated Otp for transfer is: "+otp);
	}
	

}
