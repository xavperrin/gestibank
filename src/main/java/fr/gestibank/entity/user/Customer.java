package fr.gestibank.entity.user;

import javax.persistence.Entity;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;




@Entity
public class Customer extends User {
	
	MaritalStatus _maritalStatus;	
	String _phonenumber;
	int idManager;
	int children;

	
	
	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 */
	public Customer(String id, String firstname, String lastname, String mail, String password) {
		super(id, firstname, lastname, mail, password);
	}



	public  Customer(String id, String firstname, String lastname, String  mail, String password, Address addr,
			Gender gender, MaritalStatus maritalstatus) {
		super(id, firstname, lastname, mail, password);
		this.setAddress(addr);
		this.setGender(gender);
		this.setMaritalStatus(maritalstatus);
		
	}



	public MaritalStatus getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public String getPhonenumber() {
		return _phonenumber;
	}

	public void setPhonenumber(String phoneNumber) {
		_phonenumber = phoneNumber;
	}

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	/**
	 * Constructors
	 * 
	 */

	
	
	@Override
	public String toString() {
		return "Customer [_maritalStatus=" + _maritalStatus + ", _phonenumber=" + _phonenumber + ", idManager="
				+ idManager + ", getId()=" + getId() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getMail()=" + getMail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress() + ", getGender()="
				+ getGender() + "]";
	}
}	
	
	


