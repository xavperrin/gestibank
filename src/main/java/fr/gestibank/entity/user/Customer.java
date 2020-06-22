package fr.gestibank.entity.user;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@PrimaryKeyJoinColumn(name="id")
public class Customer extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3111697784484041650L;
	@Id @GeneratedValue @Column(name="id")
	private Long _id;
	@Column(name ="maritalStatus")
	private MaritalStatus _maritalStatus;	
	@Column(length=20, name ="phoneNumber")
	private String _phoneNumber;
	@ManyToOne
	@JoinColumn(name="ID_MAN")
	private Manager _manager;
	@OneToMany
	private Collection<DepositAccount> _accounts;
	@Column(name ="children")
	private int _children;
	
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
	
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param mail
	 * @param password
	 * @param addr
	 * @param gender
	 * @param maritalstatus
	 * @param manager
	 */
	public  Customer(String firstname, String lastname, String  mail, String password, Address addr,
			Gender gender, MaritalStatus maritalstatus, Manager manager) {
		super(firstname, lastname, mail, password);
		this.setAddress(addr);
		this.setGender(gender);
		this.setMaritalStatus(maritalstatus);
		_manager=manager;
	}

	public Long getId() {
		return _id;
	}

	public void setId(Long id) {
		_id = id;
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

	
	
	
	/**
	 * @return the _accounts
	 */
	public Collection<DepositAccount> get_accounts() {
		return _accounts;
	}



	/**
	 * @param _accounts the _accounts to set
	 */
	public void set_accounts(Collection<DepositAccount> _accounts) {
		this._accounts = _accounts;
	}



	/**
	 * Constructors
	 * 
	 */

	
	
	@Override
	public String toString() {
		return "Customer [_maritalStatus=" + _maritalStatus + ", _phonenumber=" + _phoneNumber + ", idManager="
				+ _manager + ", getId()=" + getId() + ", getFirstname()=" + getFirstname() + ", getLastname()="
				+ getLastname() + ", getMail()=" + getMail() + ", getPassword()=" + getPassword() + ", getAddress()=" + getAddress() + ", getGender()="
				+ getGender() + "]";
	}

	/**
	 * Creates an empty Customer.
	 */

	public Customer() {
		super();
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(_children, _id, _manager, _maritalStatus, _phoneNumber);
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
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		return _children == other._children && Objects.equals(_id, other._id)
				&& Objects.equals(_manager, other._manager) && _maritalStatus == other._maritalStatus
				&& Objects.equals(_phoneNumber, other._phoneNumber);
	}
	
	
}	
	
	

