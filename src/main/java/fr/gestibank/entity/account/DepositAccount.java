package fr.gestibank.entity.account;

import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DepositAccount {
	
	
	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	@Column(length=50, name="IBAN")
	private String _IBAN;
	@Column(name="balance")
	private double _balance;
	@Column(name="overdraftFacility")
	private double _overdraftFacility;
	@Column(name="history")
	private Vector<Transaction> history;
	

	public DepositAccount() {
		//on crée notre contructeurs sans args lié à SavingAccount
	}
	
	/**
	 * 
	 * @param iBAN
	 * @param starteramount
	 */
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
