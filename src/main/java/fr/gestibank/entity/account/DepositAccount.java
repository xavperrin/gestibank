package fr.gestibank.entity.account;

import java.util.Vector;

public abstract class DepositAccount {
	
	private String _IBAN;
	private double _balance;
	private double _overdraftFacility;
	private Vector<Transaction> history;
	

	public DepositAccount(String iBAN, double starteramount) {
		super();
		_IBAN = iBAN;
		_balance=starteramount;
		_overdraftFacility = 0;
		this.history = new Vector<Transaction>();
		this.history.add(new Credit(starteramount));
	}
	public void withdraw(double amount) {
		
	}
	public void deposit(double amount) {
	}
	
	public double getBalance() {
		return _balance;
	}
	public void setBalance(double balance) {
		_balance = balance;
	}
	public String getIBAN() {
		return _IBAN;
	}

	
	public double getOverdraftFacility() {
		return _overdraftFacility;
	}
	public void setOverdraftFacility(double overdraftFacility) {
		_overdraftFacility = overdraftFacility;
	}
	public Vector<Transaction> getHistory() {
		return history;
	}

	
	
	public double getDepositSum(){
		double sum=0;
		
		for(Transaction element : history) {
			sum=+element.getDeposit();
		}
		
		return sum;
		
		
	}
	
	
	public double getWithdrawSum(){
		double sum=0;
		
		for(Transaction element : history) {
			sum=+element.getWithdraw();
		}
		
		return sum;
		
		
	}
	
	
}
