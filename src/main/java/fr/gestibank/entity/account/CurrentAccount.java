package fr.gestibank.entity.account;


import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.user.Customer;

@Entity
@PrimaryKeyJoinColumn(name="fk_depositaccount_id")
public class CurrentAccount extends DepositAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5518770430839873116L;
	
	public CurrentAccount() {
		super();
		// le contr vide nous permet d'appeler les méthodes afin d'instancer des nouveaux "account"
	}
	
	public CurrentAccount(String iBAN, double starter, Customer customer) {
		super(iBAN, starter, customer);
	}
	
	public CurrentAccount(String iBAN, double starter) {
		super(iBAN, starter);
		setOverdraftFacility(0);
	}


	public void checkData() throws CheckException{
		if(this.getIBAN()==null)
			throw new CheckException("Current account with null values should not be created");
		if(this.getIBAN().equals(""))
			throw new CheckException("Current account with empty IBAN values should not be created");
		if(this.getCustomer()==null)
			throw new CheckException("Current account with null customer linked should not be created");
		if(this.getCustomer().getFirstname()==null||this.getCustomer().getLastname()==null)
			throw new CheckException("Current account with an empty customer linked should not be created");
	}
	
}
