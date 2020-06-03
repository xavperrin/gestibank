package gestibank.user;

import gestibank.society.MaritalStatus;

public class Customer extends User {
	
	MaritalStatus _maritalStatus;	
	String _phonenumber;
	int idManager;
	int children;

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

	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param phonenumber
	 */
	public Customer(String id, String firstname, String lastname, String mail, String password, String phonenumber) {
		super(id, firstname, lastname, mail, password);
		_phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "Customer [_maritalStatus=" + _maritalStatus + ", _phonenumber=" + _phonenumber + ", idManager="
				+ idManager + ", getId()=" + getId() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getMail()=" + getMail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress() + ", getGender()="
				+ getGender() + "]";
	}
}	
	
	


