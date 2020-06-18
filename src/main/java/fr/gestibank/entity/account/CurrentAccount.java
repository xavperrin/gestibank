package fr.gestibank.entity.account;

public class CurrentAccount extends DepositAccount {

	public CurrentAccount(String iBAN, double starter) {
		super(iBAN, starter);
		setOverdraftFacility(0);
		
	}
	
	



}
