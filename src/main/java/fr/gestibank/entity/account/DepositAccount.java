package fr.gestibank.entity.account;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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


	@ManyToOne
	@JoinColumn(name="fk_customer_id")
	private Customer _customer;
	@OneToMany(mappedBy="_depositaccount", fetch=FetchType.LAZY)
	@Column(name="history")
	private Collection<Transaction> _history;
	@Column(name ="creation_date")
	private LocalDate _creation_date;

	
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
		
	
	}
	
	

	/**
	 * @return the creation_date
	 */
	public LocalDate getCreation_date() {
		return _creation_date;
	}

	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(LocalDate creation_date) {
		_creation_date = creation_date;
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

	@Override
	public int hashCode() {
		return Objects.hash(_IBAN, _balance, _customer, _history, _id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DepositAccount)) {
			return false;
		}
		DepositAccount other = (DepositAccount) obj;
		return Objects.equals(_IBAN, other._IBAN)
				&& Double.doubleToLongBits(_balance) == Double.doubleToLongBits(other._balance)
				&& Objects.equals(_customer, other._customer) && Objects.equals(_id, other._id);
	}
	
	
	
	
}
