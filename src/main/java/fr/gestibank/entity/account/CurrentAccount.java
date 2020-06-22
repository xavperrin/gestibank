package fr.gestibank.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.exception.CheckException;
import fr.gestibank.entity.user.Customer;
import nl.garvelink.iban.Modulo97;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class CurrentAccount extends DepositAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5518770430839873116L;

	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	
	public CurrentAccount(String iBAN, double starter, Customer customer) {
		super(iBAN, starter, customer);
	}
	
	public CurrentAccount(String iBAN, double starter) {
		super(iBAN, starter);
		setOverdraftFacility(0);
	}

	public CurrentAccount() {
		super();
		// le contr vide nous permet d'appeler les méthodes afin d'instancer des nouveaux "account"
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		_id=id;
	}
	
	@Override
	public Long getId() {
		return _id;
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
