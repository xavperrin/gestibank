package fr.gestibank.entity.account;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="_id")
public class CurrentAccount extends DepositAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5518770430839873116L;

	public CurrentAccount(String iBAN, double starter) {
		//super(iBAN, starter);
		setOverdraftFacility(0);
	}

	public CurrentAccount() {
		super();
		// le contr vide nous permet d'appeler les méthodes afin d'instancer des nouveaux "account"
	}
	
}
