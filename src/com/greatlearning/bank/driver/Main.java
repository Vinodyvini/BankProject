package com.greatlearning.bank.driver;

import java.util.Scanner;

import com.greatlearning.bank.model.Customer;
import com.greatlearning.bank.service.IndianBank;
import com.greatlearning.bank.service.InternetBanking;
import com.greatlearning.bank.service.OTPGenerator;

public class Main {

	public static void main(String[] args) {
		//create a new bank Customer account
		
		Customer customer1 = new Customer();
		customer1.setAccountNo("10005");
		customer1.setPassword("Test123");
		customer1.setBalance(10000);
		
		Customer customer2 = new Customer();
		customer2.setAccountNo("10006");
		customer2.setPassword("Test123");
		customer2.setBalance(5000);
		
		//Funtionality referance 
		InternetBanking bank = new IndianBank();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Enter your Account No");
		String accountNo = sc.nextLine();
		
		System.out.println("Please Enter your password");
		String password = sc.nextLine();
		
		//this only support login for customer1
		boolean result=bank.validateCredentials(customer1, accountNo, password);
		
		if(result) {
			//print options
			int option = 0;
			do {
				System.out.println("------------------------------");
				System.out.println("1.Check Balance");
				System.out.println("2.Deposit");
				System.out.println("3.Withdrawl");
				System.out.println("4.Transfer");
				System.out.println("5.Logout");
				System.out.println("------------------------------");
				option = sc.nextInt();
				sc.nextLine();
				switch(option) {
				case 1:
					System.out.println("The Customer balance is "+bank.checkBalance(customer1));
					break;
				case 2:
					System.out.println("Please enter the deposit amount");
					int amount = sc.nextInt();
					sc.nextLine();
					bank.deposit(customer1, amount);
					break;
				case 3:
					System.out.println("Please enter the withdrawl amount");
					int amount1 = sc.nextInt();
					sc.nextLine();
					bank.withdrawl(customer1, amount1);
					break;
				case 4:
					System.out.println("Please enter the transfer amount");
					int amount2= sc.nextInt();
					sc.nextLine();
					OTPGenerator otpGen = new OTPGenerator();
					otpGen.generateAndSetOtp(customer1);
					System.out.println("Please enter the transfer otp");
					int otp= sc.nextInt();
					sc.nextLine();
					bank.transfer(customer1, customer2, amount2, otp);
					break;
				case 5:
					System.out.println("successfully logged out...!");
					option = 0;
					break;
				default:
					System.out.println("Invalid option");
				}
			}while(option !=0);
		}else {
			System.out.println("Invalid credential");
		}

	}

}
