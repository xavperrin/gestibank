package fr.gestibank.entity.account;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.gestibank.entity.AbstractEntity;
import fr.gestibank.entity.user.Customer;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class DepositAccount extends AbstractEntity<Long> implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2724010856906507822L;
	
	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	@Column(length=50, name="IBAN")
	private String _IBAN;
	@Column(name="balance")
	private double _balance;
	@Column(name="overdraftFacility")
	private double _overdraftFacility;
	@Column(name="history")
	@OneToMany
	private Collection<Transaction> _history;
	@ManyToOne
	@JoinColumn(name="ID_CUST")
	private Customer _customer;

	/**
	 * Creates an empty DepositAccount.
	 */
	public DepositAccount() {
		super();
	}
	
	/**
	 * @param iBAN
	 * @param starteramount
	 */
	public DepositAccount(String iBAN, double starteramount) {
		super();
		_IBAN = iBAN;
		_balance=starteramount;
		_overdraftFacility = 0;
	}
	
	/**
	 * @param iBAN
	 * @param starteramount
	 */
	public DepositAccount(String iBAN, double starteramount, Customer customer) {
		super();
		_customer=customer;
		_IBAN = iBAN;
		_balance=starteramount;
		_overdraftFacility = 0;
	
	}

	public void withdraw(double amount) {
		
	}
	public void deposit(double amount) {
	}
	
	
	
	/**
	 * @return the _id
	 */
	public Long getId() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void setId(Long _id) {
		this._id = _id;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return _customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		_customer = customer;
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
	
	public void setIBAN(String iBAN) {
		_IBAN=iBAN;
	}

	
	public double getOverdraftFacility() {
		return _overdraftFacility;
	}
	public void setOverdraftFacility(double overdraftFacility) {
		_overdraftFacility = overdraftFacility;
	}
	public Collection<Transaction> getHistory() {
		return _history;
	}

	
	public double getDepositSum(){
		double sum=0;
		
		for(Transaction element : _history) {
			sum=+element.getDeposit();
		}
		
		return sum;
	}

	public double getWithdrawSum(){
		double sum=0;
		
		for(Transaction element : _history) {
			sum=+element.getWithdraw();
		}
		return sum;
	}
	
	
}
