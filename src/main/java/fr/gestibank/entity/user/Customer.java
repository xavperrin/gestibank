package fr.gestibank.entity.user;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import fr.gestibank.entity.account.DepositAccount;
import fr.gestibank.entity.society.Address;
import fr.gestibank.entity.society.Gender;
import fr.gestibank.entity.society.MaritalStatus;

@Entity
@PrimaryKeyJoinColumn(name="fk_user_id")
public class Customer extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3111697784484041650L;

				  
	@Column(name ="children")
	private int _children;
	@Column(name ="maritalStatus")
	private MaritalStatus _maritalStatus;	
	@Column(length=20, name ="phone_number")
	private String _phoneNumber;
	
	@ManyToOne
	@JoinColumn(name="fk_manager_id")
	private Manager _manager;
	@OneToMany(mappedBy="_customer", fetch=FetchType.LAZY)
	@Column(name="list_accounts")
	private Collection<DepositAccount> _accounts;
	@OneToMany(mappedBy="_customer", fetch=FetchType.LAZY)
	@Column(name="list_requests")
	private Collection<Request> _requests;
	
	
	/**
	 * Creates an empty Customer.
	 */

	public Customer() {
		super();
	}
	
	/**
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
	 * @param address
	 * @param gender
	 */
	public Customer(String firstname, String lastname, String mail, String password, Address address, Gender gender) {
		super(firstname, lastname, mail, password, address, gender);
	}

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 * @param children
	 * @param maritalStatus
	 * @param phoneNumber
	 */
	public Customer(String firstname, String lastname, String mail, String password, Address address, Gender gender,
			int children, MaritalStatus maritalStatus, String phoneNumber) {
		super(firstname, lastname, mail, password, address, gender);
		_children = children;
		_maritalStatus = maritalStatus;
		_phoneNumber = phoneNumber;
	}
	

	

	/**
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param address
	 * @param gender
	 * @param maritalStatus
	 */
	public Customer(String firstname, String lastname, String mail, String password, Address address, Gender gender,
			MaritalStatus maritalStatus) {
		super(firstname, lastname, mail, password, address, gender);
		_maritalStatus = maritalStatus;
	}

					  
			 
  

							 
		   
  

	public int getChildren() {
		return _children;
	}

	public void setChildren(int children) {
		_children = children;
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

	public Manager getManager() {
		return _manager;
	}

	public void setManager(Manager manager) {
		this._manager = manager;
	}
	
	
	public Collection<DepositAccount> get_accounts() {
		return _accounts;
	}

	public void set_accounts(Collection<DepositAccount> _accounts) {
		this._accounts = _accounts;
	}

	public Collection<Request> getRequests() {
		return _requests;
	}

	public void setRequests(Collection<Request> requests) {
		_requests = requests;
	}
	

	// Getters nécessaire pour thymeleaf (thymeleaf fait appel aux getters pour récupérer les données, mais ne peux pas se servir de ceux ci-dessus)
	public int get_children() {
		return _children;
	}
	public MaritalStatus get_maritalStatus() {
		return _maritalStatus;
	}
	public String get_phoneNumber() {
		return _phoneNumber;
	}
	public Manager get_manager() {
		return _manager;
	}
	
	
	@Override
	public String toString() {
		return "Customer [_maritalStatus=" + _maritalStatus + ", _phonenumber=" + _phoneNumber + ", idManager="
				+ _manager + ", getId()=" + getId() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getMail()=" + getMail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress() + ", getGender()="
				+ getGender() + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + _children;
		result = prime * result + ((_maritalStatus == null) ? 0 : _maritalStatus.hashCode());
		result = prime * result + ((_phoneNumber == null) ? 0 : _phoneNumber.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
   
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
								   
			return false;
   
		Customer other = (Customer) obj;
		if (_children != other._children)
			return false;
		if (_maritalStatus != other._maritalStatus)
			return false;
		if (_phoneNumber == null) {
			if (other._phoneNumber != null)
				return false;
		} else if (!_phoneNumber.equals(other._phoneNumber))
			return false;
		return true;
	}
	
 
}	
	
	

