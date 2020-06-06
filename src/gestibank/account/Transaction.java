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

	public abstract double getWithdraw();

	public abstract double getDeposit();

	@Override
	public String toString() {
		return "[amount:" + _amount + ", date:" + _date + "]";
	}
	
	

}
