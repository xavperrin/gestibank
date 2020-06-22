package fr.gestibank.entity.account;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2338603225689523544L;
	
	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	@Column(name="amount")
	double _amount;
	@Column(name="date")
	LocalDate _date;
	@ManyToOne
	@JoinColumn(name="ID_ACCOUNT")
	DepositAccount _depositaccount;
	
	public double getAmount() {
		return _amount;
	}

	public LocalDate getDate() {
		return _date;
	}

	
	public Transaction() {
		super();
	}

	/**
	 * 
	 * @param amount
	 */
	public Transaction(double amount){
		_amount=amount;
		_date=LocalDate.now();
	}

	public double getWithdraw() {
	  return 0;	
	}

	public double getDeposit() {
		return 0;
	}

	@Override
	public String toString() {
		return "[amount:" + _amount + ", date:" + _date + "]";
	}
	
	

}
