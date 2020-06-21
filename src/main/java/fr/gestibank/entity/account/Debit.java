package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="_id")
public class Debit extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7534687563299060222L;

	public Debit(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getWithdraw() {
		// TODO Auto-generated method stub
		return super.getAmount();
	}

	@Override
	public double getDeposit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Debit "+super.toString();
	}

}
