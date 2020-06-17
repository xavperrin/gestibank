package gestibank.account;

import java.time.LocalDate;

public abstract class Transaction {

	double _amount;
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
