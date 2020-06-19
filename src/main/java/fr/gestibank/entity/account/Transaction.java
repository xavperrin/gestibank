package fr.gestibank.entity.account;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Transaction {

	
	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	@Column(name="amount")
	double _amount;
	@Column(name="date")
	LocalDate _date;
	
	public double getAmount() {
		return _amount;
	}

	public LocalDate getDate() {
		return _date;
	}

	
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
