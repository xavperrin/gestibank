package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="_id")
public class SavingAccount extends DepositAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7889254707628514344L;

	/**
	 * Creates an empty SavingAccount.
	 */
	public SavingAccount() {
		super();
		// on crée notre contrccteurs sans args et pareil dans DepositAccount afin de les reliers
	}
	
	
	/**
	 * @param iBAN
	 * @param starter
	 */
	public SavingAccount(String iBAN, double starter) {
		super();
		setOverdraftFacility(0);
	}


	
}
