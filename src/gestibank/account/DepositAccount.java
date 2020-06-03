package gestibank.account;

import java.util.ArrayList;

public abstract class DepositAccount {
	String IBAN;
	double balance;
	int overdraftFacility;
	ArrayList<Transaction> transactions;
	

	public void withdraw(double amount) {
		
	}
	public void deposit(double amount) {
	}
	
	
}
