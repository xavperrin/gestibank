package fr.gestibank.entity.account;


import java.util.Objects;

import javax.persistence.Column;
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
	@Column(name="overdraft_facility")
	private Double _overdraftFacility;
	
	private static final long serialVersionUID = -5518770430839873116L;
	
	public CurrentAccount() {
		super();
		_overdraftFacility=0.0;
		// le contr vide nous permet d'appeler les méthodes afin d'instancer des nouveaux "account"
	}
	
	public CurrentAccount(String iBAN, double starter, Customer customer) {
		super(iBAN, starter, customer);
		_overdraftFacility=0.0;
	}
	
	public CurrentAccount(String iBAN, double starter, Customer customer, double overdraftfacility) {
		super(iBAN, starter, customer);
		_overdraftFacility=overdraftfacility;
	}



	

	/**
	 * @return the overdraftFacility
	 */
	public Double getOverdraftFacility() {
		return _overdraftFacility;
	}

	/**
	 * @param overdraftFacility the overdraftFacility to set
	 */
	public void setOverdraftFacility(Double overdraftFacility) {
		_overdraftFacility = overdraftFacility;
	}

	public boolean checkData() throws CheckException {
			if (getCustomer() == null || getCustomer().equals(new Customer() ))
	            throw new CheckException("Current account with null or empty customer linked should not be created");
	        if (_overdraftFacility == null || _overdraftFacility<0)
	            throw new CheckException("Invalid overdraft facility");
	        if (getIBAN()=="")
	            throw new CheckException("Current account with empty IBAN values should not be created");
	        if (getIBAN() == null)
	        	throw new CheckException("Current account with null IBAN values should not be created");
			return true;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(_overdraftFacility);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof CurrentAccount)) {
			return false;
		}
		CurrentAccount other = (CurrentAccount) obj;
		return Objects.equals(_overdraftFacility, other._overdraftFacility);
	}



	
	

		
}
	
	
	


	
	
	

