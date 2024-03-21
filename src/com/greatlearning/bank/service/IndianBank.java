package com.greatlearning.bank.service;

import com.greatlearning.bank.model.Customer;

public class IndianBank implements InternetBanking {

	@Override
	public int checkBalance(Customer cust) {
		if(cust.getBalance()<5000) {
			System.out.println("Please maintain minimum balance of 5000");
		}
		return cust.getBalance();
	}

	@Override
	public void withdrawl(Customer cust, int amount) {
		if(cust.getBalance() < amount) {
			System.out.println("insufficient balance in account: "+cust.getBalance());
			System.out.println("withdrawl not successful ");
			return;
		}
		int newBalance = cust.getBalance()- amount;
		cust.setBalance(newBalance);
		System.out.println("withdrawl successful and new balance: "+newBalance);
	}

	@Override
	public void deposit(Customer cust, int amount) {
		if(amount<0) {
			System.out.println("Invalid deposit amount " +amount);
			System.out.println("Deposit not sucesseful");
			return;
		}
		int newBalance = cust.getBalance()+amount;
		cust.setBalance(newBalance);
		System.out.println("Deposit successful and new balance " +newBalance);
	}

	@Override
	public void transfer(Customer fromCust, Customer toCust, int amount, int otp) {
		if(amount> fromCust.getBalance()) {
			System.out.println("Insufficiant balance in account " +fromCust.getBalance());
			System.out.println("Transfer not successful");
			return;
		}
		if(fromCust.getOtp() != otp) {
			System.out.println("Invalid otp entered"+otp);
			System.out.println("Transfer not successful");
			return;
		}
		int fromBalance = fromCust.getBalance();
		int toBalance = toCust.getBalance();
		fromBalance = fromBalance-amount;
		toBalance = toBalance+amount;
		fromCust.setBalance(fromBalance);
		toCust.setBalance(toBalance);
		System.out.println("Transfer successful and updated balance is"+fromBalance);
	}

	@Override
	public boolean validateCredentials(Customer cust, String accountNo, String password) {
		if(accountNo != null && password != null) {
			return accountNo.equals(cust.getAccountNo()) && password.equals(cust.getPassword());
		}
		return false;
	}

}
