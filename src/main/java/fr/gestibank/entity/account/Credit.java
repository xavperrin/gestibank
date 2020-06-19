package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="_id")
public class Credit extends Transaction {

	public Credit(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getWithdraw() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDeposit() {
		// TODO Auto-generated method stub
		return super.getAmount();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Credit "+super.toString();
	}

	
	
}
