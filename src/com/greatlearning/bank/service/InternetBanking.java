package com.greatlearning.bank.service;

import com.greatlearning.bank.model.Customer;

public interface InternetBanking {
	public int checkBalance(Customer cust);
	
	public void withdrawl(Customer cust, int amount);
	
	public void deposit(Customer cust, int amount);
	
	public void transfer(Customer fromCust, Customer toCust, int amount, int otp);
	
	public boolean validateCredentials(Customer cust, String accountNo, String password);

}
