package fr.gestibank.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;




@Entity
@PrimaryKeyJoinColumn(name="_id")
public class Customer extends User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3111697784484041650L;
	
	@Column(name ="maritalStatus")
	MaritalStatus _maritalStatus;	
	@Column(length=20, name ="phoneNumber")
	String _phoneNumber;
	@Column(name ="idManager")
	Long idManager;
	@Column(name ="children")
	int children;

	
	
	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 */
	public Customer(String firstname, String lastname, String mail, String password) {
		super(firstname, lastname, mail, password);
	}



	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param addr
	 * @param gender
	 * @param maritalstatus
	 */
	public  Customer(String firstname, String lastname, String  mail, String password, Address addr,
			Gender gender, MaritalStatus maritalstatus) {
		super(firstname, lastname, mail, password);
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
		return _phoneNumber;
	}

	public void setPhonenumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public Long getIdManager() {
		return idManager;
	}

	public void setIdManager(Long idManager) {
		this.idManager = idManager;
	}

	/**
	 * Constructors
	 * 
	 */

	
	
	@Override
	public String toString() {
		return "Customer [_maritalStatus=" + _maritalStatus + ", _phonenumber=" + _phoneNumber + ", idManager="
				+ idManager + ", getId()=" + getId() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getMail()=" + getMail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress() + ", getGender()="
				+ getGender() + "]";
	}



	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
}	
	
	

