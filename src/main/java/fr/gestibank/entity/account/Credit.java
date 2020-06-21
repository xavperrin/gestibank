package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Credit extends Transaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 764722307528988772L;

	/**
	 * Creates an empty Credit.
	 */
	
	public Credit() {
		super();
	}
	
	public Credit(double amount) {
		super(amount);
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
